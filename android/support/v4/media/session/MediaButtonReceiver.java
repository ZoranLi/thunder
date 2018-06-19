package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat.ConnectionCallback;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    private static class MediaButtonConnectionCallback extends ConnectionCallback {
        private final Context mContext;
        private final Intent mIntent;
        private MediaBrowserCompat mMediaBrowser;
        private final PendingResult mPendingResult;

        MediaButtonConnectionCallback(Context context, Intent intent, PendingResult pendingResult) {
            this.mContext = context;
            this.mIntent = intent;
            this.mPendingResult = pendingResult;
        }

        void setMediaBrowser(MediaBrowserCompat mediaBrowserCompat) {
            this.mMediaBrowser = mediaBrowserCompat;
        }

        public void onConnected() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = new android.support.v4.media.session.MediaControllerCompat;	 Catch:{ RemoteException -> 0x001a }
            r1 = r3.mContext;	 Catch:{ RemoteException -> 0x001a }
            r2 = r3.mMediaBrowser;	 Catch:{ RemoteException -> 0x001a }
            r2 = r2.getSessionToken();	 Catch:{ RemoteException -> 0x001a }
            r0.<init>(r1, r2);	 Catch:{ RemoteException -> 0x001a }
            r1 = r3.mIntent;	 Catch:{ RemoteException -> 0x001a }
            r2 = "android.intent.extra.KEY_EVENT";	 Catch:{ RemoteException -> 0x001a }
            r1 = r1.getParcelableExtra(r2);	 Catch:{ RemoteException -> 0x001a }
            r1 = (android.view.KeyEvent) r1;	 Catch:{ RemoteException -> 0x001a }
            r0.dispatchMediaButtonEvent(r1);	 Catch:{ RemoteException -> 0x001a }
        L_0x001a:
            r3.finish();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaButtonReceiver.MediaButtonConnectionCallback.onConnected():void");
        }

        public void onConnectionSuspended() {
            finish();
        }

        public void onConnectionFailed() {
            finish();
        }

        private void finish() {
            this.mMediaBrowser.disconnect();
            this.mPendingResult.finish();
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
            if (intent.hasExtra("android.intent.extra.KEY_EVENT")) {
                ComponentName serviceComponentByAction = getServiceComponentByAction(context, "android.intent.action.MEDIA_BUTTON");
                if (serviceComponentByAction != null) {
                    intent.setComponent(serviceComponentByAction);
                    startForegroundService(context, intent);
                    return;
                }
                serviceComponentByAction = getServiceComponentByAction(context, MediaBrowserServiceCompat.SERVICE_INTERFACE);
                if (serviceComponentByAction != null) {
                    PendingResult goAsync = goAsync();
                    context = context.getApplicationContext();
                    ConnectionCallback mediaButtonConnectionCallback = new MediaButtonConnectionCallback(context, intent, goAsync);
                    intent = new MediaBrowserCompat(context, serviceComponentByAction, mediaButtonConnectionCallback, null);
                    mediaButtonConnectionCallback.setMediaBrowser(intent);
                    intent.connect();
                    return;
                }
                throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
            }
        }
        new StringBuilder("Ignore unsupported intent: ").append(intent);
    }

    public static KeyEvent handleIntent(MediaSessionCompat mediaSessionCompat, Intent intent) {
        if (!(mediaSessionCompat == null || intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()))) {
            if (intent.hasExtra("android.intent.extra.KEY_EVENT")) {
                KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                mediaSessionCompat.getController().dispatchMediaButtonEvent(keyEvent);
                return keyEvent;
            }
        }
        return null;
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, long j) {
        ComponentName mediaButtonReceiverComponent = getMediaButtonReceiverComponent(context);
        if (mediaButtonReceiverComponent == null) {
            return null;
        }
        return buildMediaButtonPendingIntent(context, mediaButtonReceiverComponent, j);
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, ComponentName componentName, long j) {
        if (componentName == null) {
            return null;
        }
        j = PlaybackStateCompat.toKeyCode(j);
        if (j == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, j));
        return PendingIntent.getBroadcast(context, j, intent, 0);
    }

    static ComponentName getMediaButtonReceiverComponent(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        context = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (context.size() == 1) {
            ResolveInfo resolveInfo = (ResolveInfo) context.get(0);
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }
        context.size();
        return null;
    }

    private static void startForegroundService(Context context, Intent intent) {
        if (VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    private static ComponentName getServiceComponentByAction(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        } else if (queryIntentServices.isEmpty() != null) {
            return null;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Expected 1 service that handles ");
            stringBuilder.append(str);
            stringBuilder.append(", found ");
            stringBuilder.append(queryIntentServices.size());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
