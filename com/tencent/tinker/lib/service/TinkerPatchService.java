package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.io.File;

/* compiled from: BUGLY */
public class TinkerPatchService extends IntentService {
    private static final String PATCH_PATH_EXTRA = "patch_path_extra";
    private static final String RESULT_CLASS_EXTRA = "patch_result_class";
    private static final String TAG = "Tinker.TinkerPatchService";
    private static int notificationId = -1119860829;
    private static Class<? extends AbstractResultService> resultServiceClass;
    private static AbstractPatch upgradePatchProcessor;

    /* compiled from: BUGLY */
    public static class InnerService extends Service {
        public IBinder onBind(Intent intent) {
            return null;
        }

        public void onCreate() {
            super.onCreate();
            try {
                startForeground(TinkerPatchService.notificationId, new Notification());
            } catch (Throwable th) {
                TinkerLog.e(TinkerPatchService.TAG, "InnerService set service for push exception:%s.", th);
            }
            stopSelf();
        }

        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }
    }

    public TinkerPatchService() {
        super(TinkerPatchService.class.getSimpleName());
    }

    public static void runPatchService(Context context, String str) {
        try {
            Intent intent = new Intent(context, TinkerPatchService.class);
            intent.putExtra(PATCH_PATH_EXTRA, str);
            intent.putExtra(RESULT_CLASS_EXTRA, resultServiceClass.getName());
            context.startService(intent);
        } catch (Context context2) {
            str = TAG;
            StringBuilder stringBuilder = new StringBuilder("start patch service fail, exception:");
            stringBuilder.append(context2);
            TinkerLog.e(str, stringBuilder.toString(), new Object[0]);
        }
    }

    public static void setPatchProcessor(com.tencent.tinker.lib.patch.AbstractPatch r0, java.lang.Class<? extends com.tencent.tinker.lib.service.AbstractResultService> r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        upgradePatchProcessor = r0;
        resultServiceClass = r1;
        r0 = r1.getName();	 Catch:{ ClassNotFoundException -> 0x000c }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x000c }
        return;
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.service.TinkerPatchService.setPatchProcessor(com.tencent.tinker.lib.patch.AbstractPatch, java.lang.Class):void");
    }

    public static String getPatchPathExtra(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.getStringExtra(intent, PATCH_PATH_EXTRA);
        }
        throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }

    public static String getPatchResultExtra(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.getStringExtra(intent, RESULT_CLASS_EXTRA);
        }
        throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
    }

    public static void setTinkerNotificationId(int i) {
        notificationId = i;
    }

    protected void onHandleIntent(Intent intent) {
        Context applicationContext = getApplicationContext();
        Tinker with = Tinker.with(applicationContext);
        with.getPatchReporter().onPatchServiceStart(intent);
        boolean z = false;
        if (intent == null) {
            TinkerLog.e(TAG, "TinkerPatchService received a null intent, ignoring.", new Object[0]);
            return;
        }
        String patchPathExtra = getPatchPathExtra(intent);
        if (patchPathExtra == null) {
            TinkerLog.e(TAG, "TinkerPatchService can't get the path extra, ignoring.", new Object[0]);
            return;
        }
        File file = new File(patchPathExtra);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Throwable th = null;
        increasingPriority();
        PatchResult patchResult = new PatchResult();
        try {
            if (upgradePatchProcessor == null) {
                throw new TinkerRuntimeException("upgradePatchProcessor is null.");
            }
            z = upgradePatchProcessor.tryPatch(applicationContext, patchPathExtra, patchResult);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            with.getPatchReporter().onPatchResult(file, z, elapsedRealtime2);
            patchResult.isSuccess = z;
            patchResult.rawPatchFilePath = patchPathExtra;
            patchResult.costTime = elapsedRealtime2;
            patchResult.e = th;
            AbstractResultService.runResultService(applicationContext, patchResult, getPatchResultExtra(intent));
        } catch (Throwable th2) {
            th = th2;
            with.getPatchReporter().onPatchException(file, th);
        }
    }

    private void increasingPriority() {
        TinkerLog.i(TAG, "try to increase patch process priority", new Object[0]);
        try {
            Notification notification = new Notification();
            if (VERSION.SDK_INT < 18) {
                startForeground(notificationId, notification);
                return;
            }
            startForeground(notificationId, notification);
            startService(new Intent(this, InnerService.class));
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("try to increase patch process priority error:");
            stringBuilder.append(th);
            TinkerLog.i(str, stringBuilder.toString(), new Object[0]);
        }
    }
}
