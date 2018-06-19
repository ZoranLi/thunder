package com.xiaomi.metoknlp.a;

import android.content.Context;
import android.telephony.TelephonyManager;

public class d {
    private static TelephonyManager a;
    private static Context b;

    public static String a() {
        return a != null ? a.getNetworkOperator() : null;
    }

    public static void a(Context context) {
        b = context;
        a = (TelephonyManager) context.getSystemService("phone");
    }

    public static java.lang.String b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = b;	 Catch:{ Exception -> 0x0024 }
        if (r1 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x0024 }
    L_0x0005:
        r1 = b;	 Catch:{ Exception -> 0x0024 }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x0024 }
        r2 = "android.permission.READ_PHONE_STATE";	 Catch:{ Exception -> 0x0024 }
        r3 = b;	 Catch:{ Exception -> 0x0024 }
        r3 = r3.getPackageName();	 Catch:{ Exception -> 0x0024 }
        r1 = r1.checkPermission(r2, r3);	 Catch:{ Exception -> 0x0024 }
        if (r1 != 0) goto L_0x0024;	 Catch:{ Exception -> 0x0024 }
    L_0x0019:
        r1 = a;	 Catch:{ Exception -> 0x0024 }
        if (r1 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x0024 }
    L_0x001d:
        r1 = a;	 Catch:{ Exception -> 0x0024 }
        r1 = r1.getDeviceId();	 Catch:{ Exception -> 0x0024 }
        r0 = r1;
    L_0x0024:
        if (r0 == 0) goto L_0x0027;
    L_0x0026:
        return r0;
    L_0x0027:
        r0 = "UNKNOWN";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.d.b():java.lang.String");
    }
}
