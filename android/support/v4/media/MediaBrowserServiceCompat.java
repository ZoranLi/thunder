package android.support.v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final float EPSILON = 1.0E-5f;
    @RestrictTo({Scope.LIBRARY_GROUP})
    public static final String KEY_MEDIA_ITEM = "media_item";
    @RestrictTo({Scope.LIBRARY_GROUP})
    public static final String KEY_SEARCH_RESULTS = "search_results";
    static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    static final int RESULT_OK = 0;
    static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap();
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler = new ServiceHandler();
    private MediaBrowserServiceImpl mImpl;
    Token mSession;

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.mRootId = str;
            this.mExtras = bundle;
        }

        public final String getRootId() {
            return this.mRootId;
        }

        public final Bundle getExtras() {
            return this.mExtras;
        }
    }

    private static class ConnectionRecord {
        ServiceCallbacks callbacks;
        String pkg;
        BrowserRoot root;
        Bundle rootHints;
        HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap();

        ConnectionRecord() {
        }
    }

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(Token token);
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        void onResultSent(T t) {
        }

        Result(Object obj) {
            this.mDebug = obj;
        }

        public void sendResult(T t) {
            if (!this.mSendResultCalled) {
                if (!this.mSendErrorCalled) {
                    this.mSendResultCalled = true;
                    onResultSent(t);
                    return;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("sendResult() called when either sendResult() or sendError() had already been called for: ");
            stringBuilder.append(this.mDebug);
            throw new IllegalStateException(stringBuilder.toString());
        }

        public void sendProgressUpdate(Bundle bundle) {
            if (!this.mSendResultCalled) {
                if (!this.mSendErrorCalled) {
                    checkExtraFields(bundle);
                    this.mSendProgressUpdateCalled = true;
                    onProgressUpdateSent(bundle);
                    return;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
            stringBuilder.append(this.mDebug);
            throw new IllegalStateException(stringBuilder.toString());
        }

        public void sendError(Bundle bundle) {
            if (!this.mSendResultCalled) {
                if (!this.mSendErrorCalled) {
                    this.mSendErrorCalled = true;
                    onErrorSent(bundle);
                    return;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("sendError() called when either sendResult() or sendError() had already been called for: ");
            stringBuilder.append(this.mDebug);
            throw new IllegalStateException(stringBuilder.toString());
        }

        public void detach() {
            StringBuilder stringBuilder;
            if (this.mDetachCalled) {
                stringBuilder = new StringBuilder("detach() called when detach() had already been called for: ");
                stringBuilder.append(this.mDebug);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.mSendResultCalled) {
                stringBuilder = new StringBuilder("detach() called when sendResult() had already been called for: ");
                stringBuilder.append(this.mDebug);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.mSendErrorCalled) {
                stringBuilder = new StringBuilder("detach() called when sendError() had already been called for: ");
                stringBuilder.append(this.mDebug);
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                this.mDetachCalled = true;
            }
        }

        boolean isDone() {
            if (!(this.mDetachCalled || this.mSendResultCalled)) {
                if (!this.mSendErrorCalled) {
                    return false;
                }
            }
            return true;
        }

        void setFlags(int i) {
            this.mFlags = i;
        }

        int getFlags() {
            return this.mFlags;
        }

        void onProgressUpdateSent(Bundle bundle) {
            StringBuilder stringBuilder = new StringBuilder("It is not supported to send an interim update for ");
            stringBuilder.append(this.mDebug);
            throw new UnsupportedOperationException(stringBuilder.toString());
        }

        void onErrorSent(Bundle bundle) {
            StringBuilder stringBuilder = new StringBuilder("It is not supported to send an error for ");
            stringBuilder.append(this.mDebug);
            throw new UnsupportedOperationException(stringBuilder.toString());
        }

        private void checkExtraFields(Bundle bundle) {
            if (bundle != null && bundle.containsKey(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                bundle = bundle.getFloat(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                if (bundle < -1.0E-5f || bundle > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    private @interface ResultFlags {
    }

    private class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        public void connect(String str, int i, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            if (MediaBrowserServiceCompat.this.isValidPackage(str, i)) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final int i2 = i;
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                    public void run() {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                        /*
                        r6 = this;
                        r0 = r3;
                        r0 = r0.asBinder();
                        r1 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                        r1 = android.support.v4.media.MediaBrowserServiceCompat.this;
                        r1 = r1.mConnections;
                        r1.remove(r0);
                        r1 = new android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
                        r1.<init>();
                        r2 = r4;
                        r1.pkg = r2;
                        r2 = r5;
                        r1.rootHints = r2;
                        r2 = r3;
                        r1.callbacks = r2;
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.this;
                        r3 = r4;
                        r4 = r6;
                        r5 = r5;
                        r2 = r2.onGetRoot(r3, r4, r5);
                        r1.root = r2;
                        r2 = r1.root;
                        if (r2 != 0) goto L_0x0063;
                    L_0x0034:
                        r0 = new java.lang.StringBuilder;
                        r1 = "No root for client ";
                        r0.<init>(r1);
                        r1 = r4;
                        r0.append(r1);
                        r1 = " from service ";
                        r0.append(r1);
                        r1 = r6.getClass();
                        r1 = r1.getName();
                        r0.append(r1);
                        r0 = r3;	 Catch:{ RemoteException -> 0x0056 }
                        r0.onConnectFailed();	 Catch:{ RemoteException -> 0x0056 }
                        return;
                    L_0x0056:
                        r0 = new java.lang.StringBuilder;
                        r1 = "Calling onConnectFailed() failed. Ignoring. pkg=";
                        r0.<init>(r1);
                        r1 = r4;
                        r0.append(r1);
                        return;
                    L_0x0063:
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;	 Catch:{ RemoteException -> 0x008c }
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.this;	 Catch:{ RemoteException -> 0x008c }
                        r2 = r2.mConnections;	 Catch:{ RemoteException -> 0x008c }
                        r2.put(r0, r1);	 Catch:{ RemoteException -> 0x008c }
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;	 Catch:{ RemoteException -> 0x008c }
                        r2 = android.support.v4.media.MediaBrowserServiceCompat.this;	 Catch:{ RemoteException -> 0x008c }
                        r2 = r2.mSession;	 Catch:{ RemoteException -> 0x008c }
                        if (r2 == 0) goto L_0x008b;	 Catch:{ RemoteException -> 0x008c }
                    L_0x0074:
                        r2 = r3;	 Catch:{ RemoteException -> 0x008c }
                        r3 = r1.root;	 Catch:{ RemoteException -> 0x008c }
                        r3 = r3.getRootId();	 Catch:{ RemoteException -> 0x008c }
                        r4 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;	 Catch:{ RemoteException -> 0x008c }
                        r4 = android.support.v4.media.MediaBrowserServiceCompat.this;	 Catch:{ RemoteException -> 0x008c }
                        r4 = r4.mSession;	 Catch:{ RemoteException -> 0x008c }
                        r1 = r1.root;	 Catch:{ RemoteException -> 0x008c }
                        r1 = r1.getExtras();	 Catch:{ RemoteException -> 0x008c }
                        r2.onConnect(r3, r4, r1);	 Catch:{ RemoteException -> 0x008c }
                    L_0x008b:
                        return;
                    L_0x008c:
                        r1 = new java.lang.StringBuilder;
                        r2 = "Calling onConnect() failed. Dropping client. pkg=";
                        r1.<init>(r2);
                        r2 = r4;
                        r1.append(r2);
                        r1 = android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.this;
                        r1 = android.support.v4.media.MediaBrowserServiceCompat.this;
                        r1 = r1.mConnections;
                        r1.remove(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.1.run():void");
                    }
                });
                return;
            }
            serviceCallbacks = new StringBuilder("Package/uid mismatch: uid=");
            serviceCallbacks.append(i);
            serviceCallbacks.append(" package=");
            serviceCallbacks.append(str);
            throw new IllegalArgumentException(serviceCallbacks.toString());
        }

        public void disconnect(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    MediaBrowserServiceCompat.this.mConnections.remove(serviceCallbacks.asBinder());
                }
            });
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final String str2 = str;
            final IBinder iBinder2 = iBinder;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks2.asBinder());
                    if (connectionRecord == null) {
                        new StringBuilder("addSubscription for callback that isn't registered id=").append(str2);
                    } else {
                        MediaBrowserServiceCompat.this.addSubscription(str2, connectionRecord, iBinder2, bundle2);
                    }
                }
            });
        }

        public void removeSubscription(final String str, final IBinder iBinder, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        new StringBuilder("removeSubscription for callback that isn't registered id=").append(str);
                        return;
                    }
                    if (!MediaBrowserServiceCompat.this.removeSubscription(str, connectionRecord, iBinder)) {
                        StringBuilder stringBuilder = new StringBuilder("removeSubscription called for ");
                        stringBuilder.append(str);
                        stringBuilder.append(" which is not subscribed");
                    }
                }
            });
        }

        public void getMediaItem(final String str, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str)) {
                if (resultReceiver != null) {
                    MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                        public void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                            if (connectionRecord == null) {
                                new StringBuilder("getMediaItem for callback that isn't registered id=").append(str);
                            } else {
                                MediaBrowserServiceCompat.this.performLoadItem(str, connectionRecord, resultReceiver);
                            }
                        }
                    });
                }
            }
        }

        public void registerCallbacks(final ServiceCallbacks serviceCallbacks, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    IBinder asBinder = serviceCallbacks.asBinder();
                    MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                    ConnectionRecord connectionRecord = new ConnectionRecord();
                    connectionRecord.callbacks = serviceCallbacks;
                    connectionRecord.rootHints = bundle;
                    MediaBrowserServiceCompat.this.mConnections.put(asBinder, connectionRecord);
                }
            });
        }

        public void unregisterCallbacks(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    MediaBrowserServiceCompat.this.mConnections.remove(serviceCallbacks.asBinder());
                }
            });
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str)) {
                if (resultReceiver != null) {
                    final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                    final String str2 = str;
                    final Bundle bundle2 = bundle;
                    final ResultReceiver resultReceiver2 = resultReceiver;
                    MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                        public void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks2.asBinder());
                            if (connectionRecord == null) {
                                new StringBuilder("search for callback that isn't registered query=").append(str2);
                            } else {
                                MediaBrowserServiceCompat.this.performSearch(str2, bundle2, connectionRecord, resultReceiver2);
                            }
                        }
                    });
                }
            }
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str)) {
                if (resultReceiver != null) {
                    final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                    final String str2 = str;
                    final Bundle bundle2 = bundle;
                    final ResultReceiver resultReceiver2 = resultReceiver;
                    MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                        public void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks2.asBinder());
                            if (connectionRecord == null) {
                                StringBuilder stringBuilder = new StringBuilder("sendCustomAction for callback that isn't registered action=");
                                stringBuilder.append(str2);
                                stringBuilder.append(", extras=");
                                stringBuilder.append(bundle2);
                                return;
                            }
                            MediaBrowserServiceCompat.this.performCustomAction(str2, bundle2, connectionRecord, resultReceiver2);
                        }
                    });
                }
            }
        }
    }

    private interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, Token token, Bundle bundle) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String str, List<MediaItem> list, Bundle bundle) throws RemoteException;
    }

    private final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl = new ServiceBinderImpl();

        ServiceHandler() {
        }

        public final void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    this.mServiceBinderImpl.connect(data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 2:
                    this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 3:
                    this.mServiceBinderImpl.addSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), data.getBundle(MediaBrowserProtocol.DATA_OPTIONS), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 4:
                    this.mServiceBinderImpl.removeSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 5:
                    this.mServiceBinderImpl.getMediaItem(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 6:
                    this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(message.replyTo), data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS));
                    return;
                case 7:
                    this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 8:
                    this.mServiceBinderImpl.search(data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 9:
                    this.mServiceBinderImpl.sendCustomAction(data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unhandled message: ");
                    stringBuilder.append(message);
                    stringBuilder.append("\n  Service version: 1\n  Client version: ");
                    stringBuilder.append(message.arg1);
                    return;
            }
        }

        public final boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }

        public final void postOrRun(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    @RequiresApi(21)
    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, ServiceCompatProxy {
        Messenger mMessenger;
        final List<Bundle> mRootExtrasList = new ArrayList();
        Object mServiceObj;

        MediaBrowserServiceImplApi21() {
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
        }

        public void setSessionToken(final Token token) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    if (!MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty()) {
                        IMediaSession extraBinder = token.getExtraBinder();
                        if (extraBinder != null) {
                            for (Bundle putBinder : MediaBrowserServiceImplApi21.this.mRootExtrasList) {
                                BundleCompat.putBinder(putBinder, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                            }
                        }
                        MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
                    }
                    MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceImplApi21.this.mServiceObj, token.getToken());
                }
            });
        }

        public void notifyChildrenChanged(final String str, final Bundle bundle) {
            if (this.mMessenger == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
            } else {
                MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                    public void run() {
                        for (IBinder iBinder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(iBinder);
                            List<Pair> list = (List) connectionRecord.subscriptions.get(str);
                            if (list != null) {
                                for (Pair pair : list) {
                                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                                        MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, (Bundle) pair.second);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        public Bundle getBrowserRootHints() {
            if (this.mMessenger == null) {
                return null;
            }
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem or onSearch methods");
            } else if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            }
        }

        public BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            Bundle bundle2;
            if (bundle == null || bundle.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                bundle2 = new Bundle();
                bundle2.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 1);
                BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
                if (MediaBrowserServiceCompat.this.mSession != null) {
                    IBinder iBinder;
                    IMediaSession extraBinder = MediaBrowserServiceCompat.this.mSession.getExtraBinder();
                    String str2 = MediaBrowserProtocol.EXTRA_SESSION_BINDER;
                    if (extraBinder == null) {
                        iBinder = null;
                    } else {
                        iBinder = extraBinder.asBinder();
                    }
                    BundleCompat.putBinder(bundle2, str2, iBinder);
                } else {
                    this.mRootExtrasList.add(bundle2);
                }
            }
            str = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            if (str == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = str.getExtras();
            } else if (str.getExtras() != 0) {
                bundle2.putAll(str.getExtras());
            }
            return new BrowserRoot(str.getRootId(), bundle2);
        }

        public void onLoadChildren(String str, final ResultWrapper<List<Parcel>> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaItem>>(str) {
                void onResultSent(List<MediaItem> list) {
                    Object arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList);
                }

                public void detach() {
                    resultWrapper.detach();
                }
            });
        }
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;

        MediaBrowserServiceImplBase() {
        }

        public void onCreate() {
            this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        }

        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction()) != null ? this.mMessenger.getBinder() : null;
        }

        public void setSessionToken(final Token token) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                public void run() {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r6 = this;
                    r0 = android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.this;
                    r0 = android.support.v4.media.MediaBrowserServiceCompat.this;
                    r0 = r0.mConnections;
                    r0 = r0.values();
                    r0 = r0.iterator();
                L_0x000e:
                    r1 = r0.hasNext();
                    if (r1 == 0) goto L_0x0043;
                L_0x0014:
                    r1 = r0.next();
                    r1 = (android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord) r1;
                    r2 = r1.callbacks;	 Catch:{ RemoteException -> 0x002e }
                    r3 = r1.root;	 Catch:{ RemoteException -> 0x002e }
                    r3 = r3.getRootId();	 Catch:{ RemoteException -> 0x002e }
                    r4 = r3;	 Catch:{ RemoteException -> 0x002e }
                    r5 = r1.root;	 Catch:{ RemoteException -> 0x002e }
                    r5 = r5.getExtras();	 Catch:{ RemoteException -> 0x002e }
                    r2.onConnect(r3, r4, r5);	 Catch:{ RemoteException -> 0x002e }
                    goto L_0x000e;
                L_0x002e:
                    r2 = new java.lang.StringBuilder;
                    r3 = "Connection for ";
                    r2.<init>(r3);
                    r1 = r1.pkg;
                    r2.append(r1);
                    r1 = " is no longer valid.";
                    r2.append(r1);
                    r0.remove();
                    goto L_0x000e;
                L_0x0043:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1.run():void");
                }
            });
        }

        public void notifyChildrenChanged(@NonNull final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                        ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(iBinder);
                        List<Pair> list = (List) connectionRecord.subscriptions.get(str);
                        if (list != null) {
                            for (Pair pair : list) {
                                if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                                    MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, (Bundle) pair.second);
                                }
                            }
                        }
                    }
                }
            });
        }

        public Bundle getBrowserRootHints() {
            if (MediaBrowserServiceCompat.this.mCurConnection != null) {
                return MediaBrowserServiceCompat.this.mCurConnection.rootHints == null ? null : new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            } else {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem or onSearch methods");
            }
        }
    }

    private static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(Messenger messenger) {
            this.mCallbacks = messenger;
        }

        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        public void onConnect(String str, Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 1);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            sendRequest(1, bundle2);
        }

        public void onConnectFailed() throws RemoteException {
            sendRequest(2, null);
        }

        public void onLoadChildren(String str, List<MediaItem> list, Bundle bundle) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            if (list != null) {
                bundle2.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, (list instanceof ArrayList) != null ? (ArrayList) list : new ArrayList(list));
            }
            sendRequest(3, bundle2);
        }

        private void sendRequest(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            this.mCallbacks.send(obtain);
        }
    }

    @RequiresApi(23)
    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        MediaBrowserServiceImplApi23() {
            super();
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public void onLoadItem(String str, final ResultWrapper<Parcel> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new Result<MediaItem>(str) {
                void onResultSent(MediaItem mediaItem) {
                    if (mediaItem == null) {
                        resultWrapper.sendResult(null);
                        return;
                    }
                    Parcel obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    resultWrapper.sendResult(obtain);
                }

                public void detach() {
                    resultWrapper.detach();
                }
            });
        }
    }

    @RequiresApi(26)
    class MediaBrowserServiceImplApi24 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi24.ServiceCompatProxy {
        MediaBrowserServiceImplApi24() {
            super();
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi24.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public void notifyChildrenChanged(String str, Bundle bundle) {
            if (bundle == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
            } else {
                MediaBrowserServiceCompatApi24.notifyChildrenChanged(this.mServiceObj, str, bundle);
            }
        }

        public void onLoadChildren(String str, final ResultWrapper resultWrapper, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaItem>>(str) {
                void onResultSent(List<MediaItem> list) {
                    List arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList, getFlags());
                }

                public void detach() {
                    resultWrapper.detach();
                }
            }, bundle);
        }

        public Bundle getBrowserRootHints() {
            if (MediaBrowserServiceCompat.this.mCurConnection != null) {
                return MediaBrowserServiceCompat.this.mCurConnection.rootHints == null ? null : new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            } else {
                return MediaBrowserServiceCompatApi24.getBrowserRootHints(this.mServiceObj);
            }
        }
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaItem>> result);

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 26) {
            this.mImpl = new MediaBrowserServiceImplApi24();
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserServiceImplApi23();
        } else if (VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserServiceImplApi21();
        } else {
            this.mImpl = new MediaBrowserServiceImplBase();
        }
        this.mImpl.onCreate();
    }

    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaItem>> result, @NonNull Bundle bundle) {
        result.setFlags(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, @NonNull Result<MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void onSearch(@NonNull String str, Bundle bundle, @NonNull Result<List<MediaItem>> result) {
        result.setFlags(4);
        result.sendResult(null);
    }

    public void onCustomAction(@NonNull String str, Bundle bundle, @NonNull Result<Bundle> result) {
        result.sendError(null);
    }

    public void setSessionToken(Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        } else {
            this.mSession = token;
            this.mImpl.setSessionToken(token);
        }
    }

    @Nullable
    public Token getSessionToken() {
        return this.mSession;
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public void notifyChildrenChanged(@NonNull String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, null);
    }

    public void notifyChildrenChanged(@NonNull String str, @NonNull Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        } else {
            this.mImpl.notifyChildrenChanged(str, bundle);
        }
    }

    boolean isValidPackage(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    void addSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List list = (List) connectionRecord.subscriptions.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        for (Pair pair : r0) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, (Bundle) pair.second)) {
                return;
            }
        }
        r0.add(new Pair(iBinder, bundle));
        connectionRecord.subscriptions.put(str, r0);
        performLoadChildren(str, connectionRecord, bundle);
    }

    boolean removeSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z = false;
        if (iBinder == null) {
            return connectionRecord.subscriptions.remove(str) != null;
        } else {
            List list = (List) connectionRecord.subscriptions.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((Pair) it.next()).first) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == null) {
                    connectionRecord.subscriptions.remove(str);
                }
            }
            return z;
        }
    }

    void performLoadChildren(String str, ConnectionRecord connectionRecord, Bundle bundle) {
        final ConnectionRecord connectionRecord2 = connectionRecord;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        Result anonymousClass1 = new Result<List<MediaItem>>(str) {
            void onResultSent(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> r4) {
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
                r3 = this;
                r0 = android.support.v4.media.MediaBrowserServiceCompat.this;
                r0 = r0.mConnections;
                r1 = r3;
                r1 = r1.callbacks;
                r1 = r1.asBinder();
                r0 = r0.get(r1);
                r1 = r3;
                if (r0 == r1) goto L_0x0031;
            L_0x0014:
                r4 = android.support.v4.media.MediaBrowserServiceCompat.DEBUG;
                if (r4 == 0) goto L_0x0030;
            L_0x0018:
                r4 = new java.lang.StringBuilder;
                r0 = "Not sending onLoadChildren result for connection that has been disconnected. pkg=";
                r4.<init>(r0);
                r0 = r3;
                r0 = r0.pkg;
                r4.append(r0);
                r0 = " id=";
                r4.append(r0);
                r0 = r4;
                r4.append(r0);
            L_0x0030:
                return;
            L_0x0031:
                r0 = r3.getFlags();
                r0 = r0 & 1;
                if (r0 == 0) goto L_0x0041;
            L_0x0039:
                r0 = android.support.v4.media.MediaBrowserServiceCompat.this;
                r1 = r5;
                r4 = r0.applyOptions(r4, r1);
            L_0x0041:
                r0 = r3;	 Catch:{ RemoteException -> 0x004d }
                r0 = r0.callbacks;	 Catch:{ RemoteException -> 0x004d }
                r1 = r4;	 Catch:{ RemoteException -> 0x004d }
                r2 = r5;	 Catch:{ RemoteException -> 0x004d }
                r0.onLoadChildren(r1, r4, r2);	 Catch:{ RemoteException -> 0x004d }
                return;
            L_0x004d:
                r4 = new java.lang.StringBuilder;
                r0 = "Calling onLoadChildren() failed for id=";
                r4.<init>(r0);
                r0 = r4;
                r4.append(r0);
                r0 = " package=";
                r4.append(r0);
                r0 = r3;
                r0 = r0.pkg;
                r4.append(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserServiceCompat.1.onResultSent(java.util.List):void");
            }
        };
        this.mCurConnection = connectionRecord;
        if (bundle == null) {
            onLoadChildren(str, anonymousClass1);
        } else {
            onLoadChildren(str, anonymousClass1, bundle);
        }
        this.mCurConnection = null;
        if (anonymousClass1.isDone() == null) {
            StringBuilder stringBuilder = new StringBuilder("onLoadChildren must call detach() or sendResult() before returning for package=");
            stringBuilder.append(connectionRecord.pkg);
            stringBuilder.append(" id=");
            stringBuilder.append(str);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    List<MediaItem> applyOptions(List<MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        bundle = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i == -1 && bundle == -1) {
            return list;
        }
        int i2 = bundle * i;
        int i3 = i2 + bundle;
        if (i >= 0 && bundle > null) {
            if (i2 < list.size()) {
                if (i3 > list.size()) {
                    i3 = list.size();
                }
                return list.subList(i2, i3);
            }
        }
        return Collections.EMPTY_LIST;
    }

    void performLoadItem(String str, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result anonymousClass2 = new Result<MediaItem>(str) {
            void onResultSent(MediaItem mediaItem) {
                if ((getFlags() & 2) != 0) {
                    resultReceiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
                resultReceiver.send(0, bundle);
            }
        };
        this.mCurConnection = connectionRecord;
        onLoadItem(str, anonymousClass2);
        this.mCurConnection = null;
        if (anonymousClass2.isDone() == null) {
            resultReceiver = new StringBuilder("onLoadItem must call detach() or sendResult() before returning for id=");
            resultReceiver.append(str);
            throw new IllegalStateException(resultReceiver.toString());
        }
    }

    void performSearch(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result anonymousClass3 = new Result<List<MediaItem>>(str) {
            void onResultSent(List<MediaItem> list) {
                if ((getFlags() & 4) == 0) {
                    if (list != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaItem[0]));
                        resultReceiver.send(0, bundle);
                        return;
                    }
                }
                resultReceiver.send(-1, null);
            }
        };
        this.mCurConnection = connectionRecord;
        onSearch(str, bundle, anonymousClass3);
        this.mCurConnection = null;
        if (anonymousClass3.isDone() == null) {
            connectionRecord = new StringBuilder("onSearch must call detach() or sendResult() before returning for query=");
            connectionRecord.append(str);
            throw new IllegalStateException(connectionRecord.toString());
        }
    }

    void performCustomAction(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result anonymousClass4 = new Result<Bundle>(str) {
            void onResultSent(Bundle bundle) {
                resultReceiver.send(0, bundle);
            }

            void onProgressUpdateSent(Bundle bundle) {
                resultReceiver.send(1, bundle);
            }

            void onErrorSent(Bundle bundle) {
                resultReceiver.send(-1, bundle);
            }
        };
        this.mCurConnection = connectionRecord;
        onCustomAction(str, bundle, anonymousClass4);
        this.mCurConnection = null;
        if (anonymousClass4.isDone() == null) {
            resultReceiver = new StringBuilder("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
            resultReceiver.append(str);
            resultReceiver.append(" extras=");
            resultReceiver.append(bundle);
            throw new IllegalStateException(resultReceiver.toString());
        }
    }
}
