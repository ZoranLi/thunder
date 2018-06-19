package com.tencent.tinker.lib.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.util.List;

/* compiled from: BUGLY */
public class TinkerServiceInternals extends ShareTinkerInternals {
    private static final String TAG = "Tinker.ServiceInternals";
    private static String patchServiceProcessName;

    public static void killTinkerPatchServiceProcess(Context context) {
        String tinkerPatchServiceName = getTinkerPatchServiceName(context);
        if (tinkerPatchServiceName != null) {
            Context<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(tinkerPatchServiceName)) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    public static boolean isTinkerPatchServiceRunning(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        context = getTinkerPatchServiceName(context);
        if (context == null) {
            return false;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(context)) {
                    return true;
                }
            }
            return false;
        } catch (Context context2) {
            new StringBuilder("isTinkerPatchServiceRunning Exception: ").append(context2.toString());
            return false;
        } catch (Context context22) {
            new StringBuilder("isTinkerPatchServiceRunning Error: ").append(context22.toString());
            return false;
        }
    }

    public static String getTinkerPatchServiceName(Context context) {
        if (patchServiceProcessName != null) {
            return patchServiceProcessName;
        }
        context = getServiceProcessName(context, TinkerPatchService.class);
        if (context == null) {
            return null;
        }
        patchServiceProcessName = context;
        return context;
    }

    public static boolean isInTinkerPatchServiceProcess(Context context) {
        String processName = ShareTinkerInternals.getProcessName(context);
        context = getTinkerPatchServiceName(context);
        if (context != null) {
            if (context.length() != 0) {
                return processName.equals(context);
            }
        }
        return null;
    }

    private static java.lang.String getServiceProcessName(android.content.Context r2, java.lang.Class<? extends android.app.Service> r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getPackageManager();
        r1 = new android.content.ComponentName;
        r1.<init>(r2, r3);
        r2 = 0;
        r2 = r0.getServiceInfo(r1, r2);	 Catch:{ Throwable -> 0x0011 }
        r2 = r2.processName;
        return r2;
    L_0x0011:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.util.TinkerServiceInternals.getServiceProcessName(android.content.Context, java.lang.Class):java.lang.String");
    }
}
