package com.umeng.message.util;

/* compiled from: OSUtils */
public class d {
    private static final String a = "ro.build.version.emui";
    private static final String b = "ro.miui.ui.version.code";
    private static final String c = "ro.miui.ui.version.name";
    private static final String d = "ro.miui.internal.storage";

    private static boolean a(java.lang.String... r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = com.umeng.message.util.a.g();	 Catch:{ IOException -> 0x0017 }
        r2 = r5.length;	 Catch:{ IOException -> 0x0017 }
        r3 = r0;	 Catch:{ IOException -> 0x0017 }
    L_0x0007:
        if (r3 >= r2) goto L_0x0015;	 Catch:{ IOException -> 0x0017 }
    L_0x0009:
        r4 = r5[r3];	 Catch:{ IOException -> 0x0017 }
        r4 = r1.a(r4);	 Catch:{ IOException -> 0x0017 }
        if (r4 != 0) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r3 = r3 + 1;
        goto L_0x0007;
    L_0x0015:
        r5 = 1;
        return r5;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.util.d.a(java.lang.String[]):boolean");
    }

    public static boolean a() {
        return a(a);
    }

    public static boolean b() {
        return a(b, c, d);
    }

    public static boolean c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = android.os.Build.class;	 Catch:{ Exception -> 0x000f }
        r2 = "hasSmartBar";	 Catch:{ Exception -> 0x000f }
        r3 = new java.lang.Class[r0];	 Catch:{ Exception -> 0x000f }
        r1 = r1.getMethod(r2, r3);	 Catch:{ Exception -> 0x000f }
        if (r1 == 0) goto L_0x000e;
    L_0x000d:
        r0 = 1;
    L_0x000e:
        return r0;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.util.d.c():boolean");
    }
}
