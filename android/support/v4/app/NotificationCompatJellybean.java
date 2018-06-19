package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompatBase.Action;
import android.support.v4.app.NotificationCompatBase.Action.Factory;
import android.support.v4.app.RemoteInputCompatBase.RemoteInput;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(16)
class NotificationCompatJellybean {
    static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Class<?> sActionClass;
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock = new Object();
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock = new Object();

    public static class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private android.app.Notification.Builder b;
        private List<Bundle> mActionExtrasList = new ArrayList();
        private RemoteViews mBigContentView;
        private RemoteViews mContentView;
        private final Bundle mExtras;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            Notification notification2 = notification;
            Bundle bundle2 = bundle;
            String str3 = str;
            String str4 = str2;
            boolean z5 = false;
            android.app.Notification.Builder deleteIntent = new android.app.Notification.Builder(context).setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification2.deleteIntent);
            if ((notification2.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z5 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            r0.b = deleteIntent.setFullScreenIntent(pendingIntent3, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            r0.mExtras = new Bundle();
            if (bundle2 != null) {
                r0.mExtras.putAll(bundle2);
            }
            if (z3) {
                r0.mExtras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            if (str3 != null) {
                r0.mExtras.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str3);
                if (z4) {
                    r0.mExtras.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                } else {
                    r0.mExtras.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (str4 != null) {
                r0.mExtras.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str4);
            }
            r0.mContentView = remoteViews2;
            r0.mBigContentView = remoteViews3;
        }

        public void addAction(Action action) {
            this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.b, action));
        }

        public android.app.Notification.Builder getBuilder() {
            return this.b;
        }

        public Notification build() {
            Notification build = this.b.build();
            Bundle extras = NotificationCompatJellybean.getExtras(build);
            Bundle bundle = new Bundle(this.mExtras);
            for (String str : this.mExtras.keySet()) {
                if (extras.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            extras.putAll(bundle);
            SparseArray buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (buildActionExtrasMap != null) {
                NotificationCompatJellybean.getExtras(build).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, buildActionExtrasMap);
            }
            if (this.mContentView != null) {
                build.contentView = this.mContentView;
            }
            if (this.mBigContentView != null) {
                build.bigContentView = this.mBigContentView;
            }
            return build;
        }
    }

    NotificationCompatJellybean() {
    }

    public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        notificationBuilderWithBuilderAccessor = new BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            notificationBuilderWithBuilderAccessor.setSummaryText(charSequence2);
        }
    }

    public static void addBigPictureStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        notificationBuilderWithBuilderAccessor = new BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            notificationBuilderWithBuilderAccessor.bigLargeIcon(bitmap2);
        }
        if (z) {
            notificationBuilderWithBuilderAccessor.setSummaryText(charSequence2);
        }
    }

    public static void addInboxStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        notificationBuilderWithBuilderAccessor = new InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence);
        if (z) {
            notificationBuilderWithBuilderAccessor.setSummaryText(charSequence2);
        }
        charSequence = arrayList.iterator();
        while (charSequence.hasNext()) {
            notificationBuilderWithBuilderAccessor.addLine((CharSequence) charSequence.next());
        }
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static android.os.Bundle getExtras(android.app.Notification r6) {
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
        r0 = sExtrasLock;
        monitor-enter(r0);
        r1 = sExtrasFieldAccessFailed;	 Catch:{ all -> 0x0046 }
        r2 = 0;	 Catch:{ all -> 0x0046 }
        if (r1 == 0) goto L_0x000a;	 Catch:{ all -> 0x0046 }
    L_0x0008:
        monitor-exit(r0);	 Catch:{ all -> 0x0046 }
        return r2;
    L_0x000a:
        r1 = 1;
        r3 = sExtrasField;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        if (r3 != 0) goto L_0x002c;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
    L_0x000f:
        r3 = android.app.Notification.class;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r4 = "extras";	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = r3.getDeclaredField(r4);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r4 = android.os.Bundle.class;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r5 = r3.getType();	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r4 = r4.isAssignableFrom(r5);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        if (r4 != 0) goto L_0x0027;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
    L_0x0023:
        sExtrasFieldAccessFailed = r1;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        monitor-exit(r0);	 Catch:{ all -> 0x0046 }
        return r2;
    L_0x0027:
        r3.setAccessible(r1);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        sExtrasField = r3;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
    L_0x002c:
        r3 = sExtrasField;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = r3.get(r6);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = (android.os.Bundle) r3;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        if (r3 != 0) goto L_0x0040;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
    L_0x0036:
        r3 = new android.os.Bundle;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3.<init>();	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r4 = sExtrasField;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r4.set(r6, r3);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
    L_0x0040:
        monitor-exit(r0);	 Catch:{ all -> 0x0046 }
        return r3;	 Catch:{ all -> 0x0046 }
    L_0x0042:
        sExtrasFieldAccessFailed = r1;	 Catch:{ all -> 0x0046 }
        monitor-exit(r0);	 Catch:{ all -> 0x0046 }
        return r2;	 Catch:{ all -> 0x0046 }
    L_0x0046:
        r6 = move-exception;	 Catch:{ all -> 0x0046 }
        monitor-exit(r0);	 Catch:{ all -> 0x0046 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationCompatJellybean.getExtras(android.app.Notification):android.os.Bundle");
    }

    public static Action readAction(Factory factory, RemoteInput.Factory factory2, int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        boolean z;
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        if (bundle != null) {
            RemoteInput[] fromBundleArray = RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, NotificationCompatExtras.EXTRA_REMOTE_INPUTS), factory2);
            factory2 = RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, EXTRA_DATA_ONLY_REMOTE_INPUTS), factory2);
            z = bundle.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES);
            remoteInputArr = factory2;
            remoteInputArr2 = fromBundleArray;
        } else {
            z = false;
            remoteInputArr2 = null;
            remoteInputArr = remoteInputArr2;
        }
        return factory.build(i, charSequence, pendingIntent, bundle, remoteInputArr2, remoteInputArr, z);
    }

    public static Bundle writeActionAndGetExtras(android.app.Notification.Builder builder, Action action) {
        builder.addAction(action.getIcon(), action.getTitle(), action.getActionIntent());
        builder = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            builder.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        }
        if (action.getDataOnlyRemoteInputs() != null) {
            builder.putParcelableArray(EXTRA_DATA_ONLY_REMOTE_INPUTS, RemoteInputCompatJellybean.toBundleArray(action.getDataOnlyRemoteInputs()));
        }
        builder.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
        return builder;
    }

    public static int getActionCount(Notification notification) {
        synchronized (sActionsLock) {
            notification = getActionObjectsLocked(notification);
            notification = notification != null ? notification.length : null;
        }
        return notification;
    }

    public static android.support.v4.app.NotificationCompatBase.Action getAction(android.app.Notification r8, int r9, android.support.v4.app.NotificationCompatBase.Action.Factory r10, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory r11) {
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
        r0 = sActionsLock;
        monitor-enter(r0);
        r1 = 0;
        r2 = getActionObjectsLocked(r8);	 Catch:{ IllegalAccessException -> 0x0045 }
        if (r2 == 0) goto L_0x0048;	 Catch:{ IllegalAccessException -> 0x0045 }
    L_0x000a:
        r2 = r2[r9];	 Catch:{ IllegalAccessException -> 0x0045 }
        r8 = getExtras(r8);	 Catch:{ IllegalAccessException -> 0x0045 }
        if (r8 == 0) goto L_0x0022;	 Catch:{ IllegalAccessException -> 0x0045 }
    L_0x0012:
        r3 = "android.support.actionExtras";	 Catch:{ IllegalAccessException -> 0x0045 }
        r8 = r8.getSparseParcelableArray(r3);	 Catch:{ IllegalAccessException -> 0x0045 }
        if (r8 == 0) goto L_0x0022;	 Catch:{ IllegalAccessException -> 0x0045 }
    L_0x001a:
        r8 = r8.get(r9);	 Catch:{ IllegalAccessException -> 0x0045 }
        r8 = (android.os.Bundle) r8;	 Catch:{ IllegalAccessException -> 0x0045 }
        r7 = r8;	 Catch:{ IllegalAccessException -> 0x0045 }
        goto L_0x0023;	 Catch:{ IllegalAccessException -> 0x0045 }
    L_0x0022:
        r7 = r1;	 Catch:{ IllegalAccessException -> 0x0045 }
    L_0x0023:
        r8 = sActionIconField;	 Catch:{ IllegalAccessException -> 0x0045 }
        r4 = r8.getInt(r2);	 Catch:{ IllegalAccessException -> 0x0045 }
        r8 = sActionTitleField;	 Catch:{ IllegalAccessException -> 0x0045 }
        r8 = r8.get(r2);	 Catch:{ IllegalAccessException -> 0x0045 }
        r5 = r8;	 Catch:{ IllegalAccessException -> 0x0045 }
        r5 = (java.lang.CharSequence) r5;	 Catch:{ IllegalAccessException -> 0x0045 }
        r8 = sActionIntentField;	 Catch:{ IllegalAccessException -> 0x0045 }
        r8 = r8.get(r2);	 Catch:{ IllegalAccessException -> 0x0045 }
        r6 = r8;	 Catch:{ IllegalAccessException -> 0x0045 }
        r6 = (android.app.PendingIntent) r6;	 Catch:{ IllegalAccessException -> 0x0045 }
        r2 = r10;	 Catch:{ IllegalAccessException -> 0x0045 }
        r3 = r11;	 Catch:{ IllegalAccessException -> 0x0045 }
        r8 = readAction(r2, r3, r4, r5, r6, r7);	 Catch:{ IllegalAccessException -> 0x0045 }
        monitor-exit(r0);	 Catch:{ all -> 0x0043 }
        return r8;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r8 = move-exception;	 Catch:{ all -> 0x0043 }
        goto L_0x004a;	 Catch:{ all -> 0x0043 }
    L_0x0045:
        r8 = 1;	 Catch:{ all -> 0x0043 }
        sActionsAccessFailed = r8;	 Catch:{ all -> 0x0043 }
    L_0x0048:
        monitor-exit(r0);	 Catch:{ all -> 0x0043 }
        return r1;	 Catch:{ all -> 0x0043 }
    L_0x004a:
        monitor-exit(r0);	 Catch:{ all -> 0x0043 }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationCompatJellybean.getAction(android.app.Notification, int, android.support.v4.app.NotificationCompatBase$Action$Factory, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory):android.support.v4.app.NotificationCompatBase$Action");
    }

    private static java.lang.Object[] getActionObjectsLocked(android.app.Notification r3) {
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
        r0 = sActionsLock;
        monitor-enter(r0);
        r1 = ensureActionReflectionReadyLocked();	 Catch:{ all -> 0x001b }
        r2 = 0;	 Catch:{ all -> 0x001b }
        if (r1 != 0) goto L_0x000c;	 Catch:{ all -> 0x001b }
    L_0x000a:
        monitor-exit(r0);	 Catch:{ all -> 0x001b }
        return r2;
    L_0x000c:
        r1 = sActionsField;	 Catch:{ IllegalAccessException -> 0x0016 }
        r3 = r1.get(r3);	 Catch:{ IllegalAccessException -> 0x0016 }
        r3 = (java.lang.Object[]) r3;	 Catch:{ IllegalAccessException -> 0x0016 }
        monitor-exit(r0);	 Catch:{ all -> 0x001b }
        return r3;	 Catch:{ all -> 0x001b }
    L_0x0016:
        r3 = 1;	 Catch:{ all -> 0x001b }
        sActionsAccessFailed = r3;	 Catch:{ all -> 0x001b }
        monitor-exit(r0);	 Catch:{ all -> 0x001b }
        return r2;	 Catch:{ all -> 0x001b }
    L_0x001b:
        r3 = move-exception;	 Catch:{ all -> 0x001b }
        monitor-exit(r0);	 Catch:{ all -> 0x001b }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationCompatJellybean.getActionObjectsLocked(android.app.Notification):java.lang.Object[]");
    }

    private static boolean ensureActionReflectionReadyLocked() {
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
        r0 = sActionsAccessFailed;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = 1;
        r2 = sActionsField;	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        if (r2 != 0) goto L_0x0042;	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
    L_0x000b:
        r2 = "android.app.Notification$Action";	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        sActionClass = r2;	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r3 = "icon";	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r2 = r2.getDeclaredField(r3);	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        sActionIconField = r2;	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r2 = sActionClass;	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r3 = "title";	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r2 = r2.getDeclaredField(r3);	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        sActionTitleField = r2;	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r2 = sActionClass;	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r3 = "actionIntent";	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r2 = r2.getDeclaredField(r3);	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        sActionIntentField = r2;	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r2 = android.app.Notification.class;	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r3 = "actions";	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r2 = r2.getDeclaredField(r3);	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        sActionsField = r2;	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        r2.setAccessible(r0);	 Catch:{ ClassNotFoundException -> 0x0040, NoSuchFieldException -> 0x003d }
        goto L_0x0042;
    L_0x003d:
        sActionsAccessFailed = r0;
        goto L_0x0042;
    L_0x0040:
        sActionsAccessFailed = r0;
    L_0x0042:
        r2 = sActionsAccessFailed;
        if (r2 != 0) goto L_0x0047;
    L_0x0046:
        return r0;
    L_0x0047:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationCompatJellybean.ensureActionReflectionReadyLocked():boolean");
    }

    public static Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList, Factory factory, RemoteInput.Factory factory2) {
        if (arrayList == null) {
            return null;
        }
        Action[] newArray = factory.newArray(arrayList.size());
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = getActionFromBundle((Bundle) arrayList.get(i), factory, factory2);
        }
        return newArray;
    }

    private static Action getActionFromBundle(Bundle bundle, Factory factory, RemoteInput.Factory factory2) {
        Bundle bundle2 = bundle.getBundle(KEY_EXTRAS);
        boolean z = false;
        if (bundle2 != null) {
            z = bundle2.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES, false);
        }
        return factory.build(bundle.getInt(KEY_ICON), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable(KEY_ACTION_INTENT), bundle.getBundle(KEY_EXTRAS), RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, KEY_REMOTE_INPUTS), factory2), RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, KEY_DATA_ONLY_REMOTE_INPUTS), factory2), z);
    }

    public static ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
        if (actionArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList(actionArr.length);
        for (Action bundleForAction : actionArr) {
            arrayList.add(getBundleForAction(bundleForAction));
        }
        return arrayList;
    }

    private static Bundle getBundleForAction(Action action) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt(KEY_ICON, action.getIcon());
        bundle2.putCharSequence("title", action.getTitle());
        bundle2.putParcelable(KEY_ACTION_INTENT, action.getActionIntent());
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
        bundle2.putBundle(KEY_EXTRAS, bundle);
        bundle2.putParcelableArray(KEY_REMOTE_INPUTS, RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        return bundle2;
    }
}
