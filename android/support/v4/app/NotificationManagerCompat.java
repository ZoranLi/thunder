package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.support.annotation.GuardedBy;
import android.support.v4.app.INotificationSideChannel.Stub;
import android.util.Log;
import com.umeng.message.entity.UMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    @GuardedBy("sEnabledNotificationListenersLock")
    private static Set<String> sEnabledNotificationListenerPackages = new HashSet();
    @GuardedBy("sEnabledNotificationListenersLock")
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock = new Object();
    private static final Object sLock = new Object();
    @GuardedBy("sLock")
    private static SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager = ((NotificationManager) this.mContext.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION));

    private static class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.componentName = componentName;
            this.iBinder = iBinder;
        }
    }

    private static class SideChannelManager implements ServiceConnection, Callback {
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set<String> mCachedEnabledPackages = new HashSet();
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map<ComponentName, ListenerRecord> mRecordMap = new HashMap();

        private static class ListenerRecord {
            public boolean bound = false;
            public final ComponentName componentName;
            public int retryCount = 0;
            public INotificationSideChannel service;
            public LinkedList<Task> taskQueue = new LinkedList();

            public ListenerRecord(ComponentName componentName) {
                this.componentName = componentName;
            }
        }

        public SideChannelManager(Context context) {
            this.mContext = context;
            this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
        }

        public void queueTask(Task task) {
            this.mHandler.obtainMessage(0, task).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    handleQueueTask((Task) message.obj);
                    return true;
                case 1:
                    ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                    handleServiceConnected(serviceConnectedEvent.componentName, serviceConnectedEvent.iBinder);
                    return true;
                case 2:
                    handleServiceDisconnected((ComponentName) message.obj);
                    return true;
                case 3:
                    handleRetryListenerQueue((ComponentName) message.obj);
                    return true;
                default:
                    return null;
            }
        }

        private void handleQueueTask(Task task) {
            updateListenerMap();
            for (ListenerRecord listenerRecord : this.mRecordMap.values()) {
                listenerRecord.taskQueue.add(task);
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceConnected(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = (ListenerRecord) this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.service = Stub.asInterface(iBinder);
                listenerRecord.retryCount = null;
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceDisconnected(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                ensureServiceUnbound(listenerRecord);
            }
        }

        private void handleRetryListenerQueue(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                processListenerQueue(listenerRecord);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                new StringBuilder("Connected to service ").append(componentName);
            }
            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                new StringBuilder("Disconnected from service ").append(componentName);
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        private void updateListenerMap() {
            Set enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (!enabledListenerPackages.equals(this.mCachedEnabledPackages)) {
                this.mCachedEnabledPackages = enabledListenerPackages;
                List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
                Set<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            StringBuilder stringBuilder = new StringBuilder("Permission present on component ");
                            stringBuilder.append(componentName);
                            stringBuilder.append(", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.mRecordMap.containsKey(componentName2)) {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            new StringBuilder("Adding listener record for ").append(componentName2);
                        }
                        this.mRecordMap.put(componentName2, new ListenerRecord(componentName2));
                    }
                }
                Iterator it = this.mRecordMap.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            new StringBuilder("Removing listener record for ").append(entry.getKey());
                        }
                        ensureServiceUnbound((ListenerRecord) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        private boolean ensureServiceBound(ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                return true;
            }
            listenerRecord.bound = this.mContext.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(listenerRecord.componentName), this, 33);
            if (listenerRecord.bound) {
                listenerRecord.retryCount = 0;
            } else {
                new StringBuilder("Unable to bind to listener ").append(listenerRecord.componentName);
                this.mContext.unbindService(this);
            }
            return listenerRecord.bound;
        }

        private void ensureServiceUnbound(ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                this.mContext.unbindService(this);
                listenerRecord.bound = false;
            }
            listenerRecord.service = null;
        }

        private void scheduleListenerRetry(ListenerRecord listenerRecord) {
            if (!this.mHandler.hasMessages(3, listenerRecord.componentName)) {
                listenerRecord.retryCount++;
                if (listenerRecord.retryCount > 6) {
                    StringBuilder stringBuilder = new StringBuilder("Giving up on delivering ");
                    stringBuilder.append(listenerRecord.taskQueue.size());
                    stringBuilder.append(" tasks to ");
                    stringBuilder.append(listenerRecord.componentName);
                    stringBuilder.append(" after ");
                    stringBuilder.append(listenerRecord.retryCount);
                    stringBuilder.append(" retries");
                    listenerRecord.taskQueue.clear();
                    return;
                }
                int i = 1000 * (1 << (listenerRecord.retryCount - 1));
                if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                    StringBuilder stringBuilder2 = new StringBuilder("Scheduling retry for ");
                    stringBuilder2.append(i);
                    stringBuilder2.append(" ms");
                }
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, listenerRecord.componentName), (long) i);
            }
        }

        private void processListenerQueue(android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r4 = this;
            r0 = "NotifManCompat";
            r1 = 3;
            r0 = android.util.Log.isLoggable(r0, r1);
            if (r0 == 0) goto L_0x0028;
        L_0x0009:
            r0 = new java.lang.StringBuilder;
            r2 = "Processing component ";
            r0.<init>(r2);
            r2 = r5.componentName;
            r0.append(r2);
            r2 = ", ";
            r0.append(r2);
            r2 = r5.taskQueue;
            r2 = r2.size();
            r0.append(r2);
            r2 = " queued tasks";
            r0.append(r2);
        L_0x0028:
            r0 = r5.taskQueue;
            r0 = r0.isEmpty();
            if (r0 == 0) goto L_0x0031;
        L_0x0030:
            return;
        L_0x0031:
            r0 = r4.ensureServiceBound(r5);
            if (r0 == 0) goto L_0x0090;
        L_0x0037:
            r0 = r5.service;
            if (r0 != 0) goto L_0x003c;
        L_0x003b:
            goto L_0x0090;
        L_0x003c:
            r0 = r5.taskQueue;
            r0 = r0.peek();
            r0 = (android.support.v4.app.NotificationManagerCompat.Task) r0;
            if (r0 == 0) goto L_0x0084;
        L_0x0046:
            r2 = "NotifManCompat";	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
            r2 = android.util.Log.isLoggable(r2, r1);	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
            if (r2 == 0) goto L_0x0058;	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
        L_0x004e:
            r2 = new java.lang.StringBuilder;	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
            r3 = "Sending task ";	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
            r2.<init>(r3);	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
            r2.append(r0);	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
        L_0x0058:
            r2 = r5.service;	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
            r0.send(r2);	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
            r0 = r5.taskQueue;	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
            r0.remove();	 Catch:{ DeadObjectException -> 0x0070, RemoteException -> 0x0063 }
            goto L_0x003c;
        L_0x0063:
            r0 = new java.lang.StringBuilder;
            r1 = "RemoteException communicating with ";
            r0.<init>(r1);
            r1 = r5.componentName;
            r0.append(r1);
            goto L_0x0084;
        L_0x0070:
            r0 = "NotifManCompat";
            r0 = android.util.Log.isLoggable(r0, r1);
            if (r0 == 0) goto L_0x0084;
        L_0x0078:
            r0 = new java.lang.StringBuilder;
            r1 = "Remote service has died: ";
            r0.<init>(r1);
            r1 = r5.componentName;
            r0.append(r1);
        L_0x0084:
            r0 = r5.taskQueue;
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x008f;
        L_0x008c:
            r4.scheduleListenerRetry(r5);
        L_0x008f:
            return;
        L_0x0090:
            r4.scheduleListenerRetry(r5);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationManagerCompat.SideChannelManager.processListenerQueue(android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord):void");
        }
    }

    private interface Task {
        void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    private static class CancelTask implements Task {
        final boolean all;
        final int id;
        final String packageName;
        final String tag;

        CancelTask(String str) {
            this.packageName = str;
            this.id = null;
            this.tag = null;
            this.all = true;
        }

        CancelTask(String str, int i, String str2) {
            this.packageName = str;
            this.id = i;
            this.tag = str2;
            this.all = null;
        }

        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.all) {
                iNotificationSideChannel.cancelAll(this.packageName);
            } else {
                iNotificationSideChannel.cancel(this.packageName, this.id, this.tag);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.packageName);
            stringBuilder.append(", id:");
            stringBuilder.append(this.id);
            stringBuilder.append(", tag:");
            stringBuilder.append(this.tag);
            stringBuilder.append(", all:");
            stringBuilder.append(this.all);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static class NotifyTask implements Task {
        final int id;
        final Notification notif;
        final String packageName;
        final String tag;

        NotifyTask(String str, int i, String str2, Notification notification) {
            this.packageName = str;
            this.id = i;
            this.tag = str2;
            this.notif = notification;
        }

        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.packageName);
            stringBuilder.append(", id:");
            stringBuilder.append(this.id);
            stringBuilder.append(", tag:");
            stringBuilder.append(this.tag);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static NotificationManagerCompat from(Context context) {
        return new NotificationManagerCompat(context);
    }

    private NotificationManagerCompat(Context context) {
        this.mContext = context;
    }

    public final void cancel(int i) {
        cancel(null, i);
    }

    public final void cancel(String str, int i) {
        this.mNotificationManager.cancel(str, i);
        if (VERSION.SDK_INT <= 19) {
            pushSideChannelQueue(new CancelTask(this.mContext.getPackageName(), i, str));
        }
    }

    public final void cancelAll() {
        this.mNotificationManager.cancelAll();
        if (VERSION.SDK_INT <= 19) {
            pushSideChannelQueue(new CancelTask(this.mContext.getPackageName()));
        }
    }

    public final void notify(int i, Notification notification) {
        notify(null, i, notification);
    }

    public final void notify(String str, int i, Notification notification) {
        if (useSideChannelForNotification(notification)) {
            pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), i, str, notification));
            this.mNotificationManager.cancel(str, i);
            return;
        }
        this.mNotificationManager.notify(str, i, notification);
    }

    public final boolean areNotificationsEnabled() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r11 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 24;
        if (r0 < r1) goto L_0x000d;
    L_0x0006:
        r0 = r11.mNotificationManager;
        r0 = r0.areNotificationsEnabled();
        return r0;
    L_0x000d:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        r2 = 1;
        if (r0 < r1) goto L_0x0082;
    L_0x0014:
        r0 = r11.mContext;
        r1 = "appops";
        r0 = r0.getSystemService(r1);
        r0 = (android.app.AppOpsManager) r0;
        r1 = r11.mContext;
        r1 = r1.getApplicationInfo();
        r3 = r11.mContext;
        r3 = r3.getApplicationContext();
        r3 = r3.getPackageName();
        r1 = r1.uid;
        r4 = android.app.AppOpsManager.class;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = r4.getName();	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = java.lang.Class.forName(r4);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r5 = "checkOpNoThrow";	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r6 = 3;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7 = new java.lang.Class[r6];	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r8 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r9 = 0;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7[r9] = r8;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r8 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7[r2] = r8;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r8 = java.lang.String.class;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r10 = 2;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7[r10] = r8;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r5 = r4.getMethod(r5, r7);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7 = "OP_POST_NOTIFICATION";	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = r4.getDeclaredField(r7);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r7 = java.lang.Integer.class;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = r4.get(r7);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = (java.lang.Integer) r4;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = r4.intValue();	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r6 = new java.lang.Object[r6];	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r6[r9] = r4;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r6[r2] = r1;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r6[r10] = r3;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r0 = r5.invoke(r0, r6);	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r0 = (java.lang.Integer) r0;	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        r0 = r0.intValue();	 Catch:{ ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081, ClassNotFoundException -> 0x0081 }
        if (r0 != 0) goto L_0x0080;
    L_0x007f:
        return r2;
    L_0x0080:
        return r9;
    L_0x0081:
        return r2;
    L_0x0082:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationManagerCompat.areNotificationsEnabled():boolean");
    }

    public final int getImportance() {
        return VERSION.SDK_INT >= 24 ? this.mNotificationManager.getImportance() : -1000;
    }

    public static Set<String> getEnabledListenerPackages(Context context) {
        context = Secure.getString(context.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        synchronized (sEnabledNotificationListenersLock) {
            if (context != null) {
                if (!context.equals(sEnabledNotificationListeners)) {
                    String[] split = context.split(Constants.COLON_SEPARATOR);
                    Set hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    sEnabledNotificationListenerPackages = hashSet;
                    sEnabledNotificationListeners = context;
                }
            }
        }
        return sEnabledNotificationListenerPackages;
    }

    private static boolean useSideChannelForNotification(Notification notification) {
        notification = NotificationCompat.getExtras(notification);
        return (notification == null || notification.getBoolean(EXTRA_USE_SIDE_CHANNEL) == null) ? null : true;
    }

    private void pushSideChannelQueue(Task task) {
        synchronized (sLock) {
            if (sSideChannelManager == null) {
                sSideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());
            }
            sSideChannelManager.queueTask(task);
        }
    }
}
