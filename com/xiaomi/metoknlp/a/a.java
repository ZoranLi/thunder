package com.xiaomi.metoknlp.a;

import android.os.Build;
import java.lang.reflect.Field;

public class a {
    private static String a = "NLPBuild";
    private static boolean b = false;
    private static String c = Build.BRAND;
    private static String d = Build.TYPE;
    private static Class e;
    private static Field f;
    private static Field g;
    private static Field h;
    private static Field i;
    private static Field j;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.BRAND;
        c = r0;
        r0 = android.os.Build.TYPE;
        d = r0;
        r0 = 1;
        r1 = "miui.os.Build";	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        e = r1;	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r2 = "IS_CTS_BUILD";	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r1 = r1.getField(r2);	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        f = r1;	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r1 = e;	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r2 = "IS_CTA_BUILD";	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r1 = r1.getField(r2);	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        g = r1;	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r1 = e;	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r2 = "IS_ALPHA_BUILD";	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r1 = r1.getField(r2);	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        h = r1;	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r1 = e;	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r2 = "IS_DEVELOPMENT_VERSION";	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r1 = r1.getField(r2);	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        i = r1;	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r1 = e;	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r2 = "IS_STABLE_VERSION";	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r1 = r1.getField(r2);	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        j = r1;	 Catch:{ ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042, ClassNotFoundException -> 0x0042 }
        r0 = 0;
    L_0x0042:
        if (r0 == 0) goto L_0x0051;
    L_0x0044:
        r0 = 0;
        e = r0;
        f = r0;
        g = r0;
        h = r0;
        i = r0;
        j = r0;
    L_0x0051:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.a.<clinit>():void");
    }

    public static boolean a() {
        if (b) {
            new StringBuilder("brand=").append(c);
        }
        return c != null && c.equalsIgnoreCase("xiaomi");
    }

    public static String b() {
        StringBuilder stringBuilder = new StringBuilder("3rdROM-");
        stringBuilder.append(d);
        return stringBuilder.toString();
    }

    public static boolean c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a();
        if (r0 == 0) goto L_0x0017;
    L_0x0006:
        r0 = e;
        if (r0 == 0) goto L_0x0017;
    L_0x000a:
        r0 = f;
        if (r0 == 0) goto L_0x0017;
    L_0x000e:
        r0 = f;	 Catch:{ IllegalAccessException -> 0x0017 }
        r1 = e;	 Catch:{ IllegalAccessException -> 0x0017 }
        r0 = r0.getBoolean(r1);	 Catch:{ IllegalAccessException -> 0x0017 }
        return r0;
    L_0x0017:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.a.c():boolean");
    }

    public static boolean d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a();
        if (r0 == 0) goto L_0x0017;
    L_0x0006:
        r0 = e;
        if (r0 == 0) goto L_0x0017;
    L_0x000a:
        r0 = h;
        if (r0 == 0) goto L_0x0017;
    L_0x000e:
        r0 = h;	 Catch:{ IllegalAccessException -> 0x0017 }
        r1 = e;	 Catch:{ IllegalAccessException -> 0x0017 }
        r0 = r0.getBoolean(r1);	 Catch:{ IllegalAccessException -> 0x0017 }
        return r0;
    L_0x0017:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.a.d():boolean");
    }

    public static boolean e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a();
        if (r0 == 0) goto L_0x0017;
    L_0x0006:
        r0 = e;
        if (r0 == 0) goto L_0x0017;
    L_0x000a:
        r0 = i;
        if (r0 == 0) goto L_0x0017;
    L_0x000e:
        r0 = i;	 Catch:{ IllegalAccessException -> 0x0017 }
        r1 = e;	 Catch:{ IllegalAccessException -> 0x0017 }
        r0 = r0.getBoolean(r1);	 Catch:{ IllegalAccessException -> 0x0017 }
        return r0;
    L_0x0017:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.a.e():boolean");
    }

    public static boolean f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a();
        if (r0 == 0) goto L_0x0017;
    L_0x0006:
        r0 = e;
        if (r0 == 0) goto L_0x0017;
    L_0x000a:
        r0 = j;
        if (r0 == 0) goto L_0x0017;
    L_0x000e:
        r0 = j;	 Catch:{ IllegalAccessException -> 0x0017 }
        r1 = e;	 Catch:{ IllegalAccessException -> 0x0017 }
        r0 = r0.getBoolean(r1);	 Catch:{ IllegalAccessException -> 0x0017 }
        return r0;
    L_0x0017:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.a.f():boolean");
    }
}
