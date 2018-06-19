package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.log.e;
import com.xiaomi.push.log.f;

public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    private static boolean hasWritePermission(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r5.getPackageManager();	 Catch:{ Exception -> 0x0026 }
        r5 = r5.getPackageName();	 Catch:{ Exception -> 0x0026 }
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ Exception -> 0x0026 }
        r5 = r1.getPackageInfo(r5, r2);	 Catch:{ Exception -> 0x0026 }
        r5 = r5.requestedPermissions;	 Catch:{ Exception -> 0x0026 }
        if (r5 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x0026 }
    L_0x0013:
        r1 = r5.length;	 Catch:{ Exception -> 0x0026 }
        r2 = r0;	 Catch:{ Exception -> 0x0026 }
    L_0x0015:
        if (r2 >= r1) goto L_0x0026;	 Catch:{ Exception -> 0x0026 }
    L_0x0017:
        r3 = r5[r2];	 Catch:{ Exception -> 0x0026 }
        r4 = "android.permission.WRITE_EXTERNAL_STORAGE";	 Catch:{ Exception -> 0x0026 }
        r3 = r4.equals(r3);	 Catch:{ Exception -> 0x0026 }
        if (r3 == 0) goto L_0x0023;
    L_0x0021:
        r5 = 1;
        return r5;
    L_0x0023:
        r2 = r2 + 1;
        goto L_0x0015;
    L_0x0026:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.Logger.hasWritePermission(android.content.Context):boolean");
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    private static void setPushLog(Context context) {
        LoggerInterface eVar;
        Object obj = sUserLogger != null ? 1 : null;
        LoggerInterface fVar = new f(context);
        if (!sDisablePushLog && hasWritePermission(context) && obj != null) {
            eVar = new e(sUserLogger, fVar);
        } else if (sDisablePushLog || !hasWritePermission(context)) {
            eVar = obj != null ? sUserLogger : new e(null, null);
        } else {
            b.a(fVar);
            return;
        }
        b.a(eVar);
    }
}
