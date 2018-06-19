package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.reflect.a;
import java.security.MessageDigest;

public class h {
    private static Context a;

    public static Context a() {
        return a;
    }

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    public static String b() {
        String c = d.c(a);
        if (c == null) {
            c = d.i(a);
        }
        if (c != null) {
            try {
                return Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(c.getBytes()), 8).substring(0, 16);
            } catch (Throwable e) {
                b.a(e);
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable e) {
            b.a(e);
            return false;
        }
    }

    public static int c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "miui.os.Build";	 Catch:{ Exception -> 0x0025 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0025 }
        r1 = "IS_STABLE_VERSION";	 Catch:{ Exception -> 0x0025 }
        r1 = r0.getField(r1);	 Catch:{ Exception -> 0x0025 }
        r2 = 0;	 Catch:{ Exception -> 0x0025 }
        r1 = r1.getBoolean(r2);	 Catch:{ Exception -> 0x0025 }
        if (r1 == 0) goto L_0x0015;	 Catch:{ Exception -> 0x0025 }
    L_0x0013:
        r0 = 3;	 Catch:{ Exception -> 0x0025 }
        return r0;	 Catch:{ Exception -> 0x0025 }
    L_0x0015:
        r1 = "IS_DEVELOPMENT_VERSION";	 Catch:{ Exception -> 0x0025 }
        r0 = r0.getField(r1);	 Catch:{ Exception -> 0x0025 }
        r0 = r0.getBoolean(r2);	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x0023;
    L_0x0021:
        r0 = 2;
        return r0;
    L_0x0023:
        r0 = 1;
        return r0;
    L_0x0025:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.h.c():int");
    }

    public static boolean d() {
        return TextUtils.equals((String) a.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    public static boolean e() {
        try {
            return Class.forName("miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.valueOf(false));
        } catch (Throwable e) {
            b.a(e);
            return false;
        }
    }
}
