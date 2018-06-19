package com.xiaomi.metoknlp.a;

import com.xiaomi.metoknlp.a;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class e {
    private static String a;
    private static String b;
    private static String c;

    public static String a() {
        if (a != null) {
            return a;
        }
        String b = b(d.b());
        if (b == null) {
            return b(c.a("ro.ril.miui.imei", ""));
        }
        a = b;
        return b;
    }

    public static java.lang.String a(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 16;
        r0 = new char[r0];
        r0 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        r8 = r8.getBytes();	 Catch:{ Exception -> 0x003e }
        r1 = "MD5";	 Catch:{ Exception -> 0x003e }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x003e }
        r1.update(r8);	 Catch:{ Exception -> 0x003e }
        r8 = r1.digest();	 Catch:{ Exception -> 0x003e }
        r1 = r8.length;	 Catch:{ Exception -> 0x003e }
        r2 = r1 * 2;	 Catch:{ Exception -> 0x003e }
        r2 = new char[r2];	 Catch:{ Exception -> 0x003e }
        r3 = 0;	 Catch:{ Exception -> 0x003e }
        r4 = r3;	 Catch:{ Exception -> 0x003e }
    L_0x001f:
        if (r3 >= r1) goto L_0x0038;	 Catch:{ Exception -> 0x003e }
    L_0x0021:
        r5 = r8[r3];	 Catch:{ Exception -> 0x003e }
        r6 = r4 + 1;	 Catch:{ Exception -> 0x003e }
        r7 = r5 >>> 4;	 Catch:{ Exception -> 0x003e }
        r7 = r7 & 15;	 Catch:{ Exception -> 0x003e }
        r7 = r0[r7];	 Catch:{ Exception -> 0x003e }
        r2[r4] = r7;	 Catch:{ Exception -> 0x003e }
        r4 = r6 + 1;	 Catch:{ Exception -> 0x003e }
        r5 = r5 & 15;	 Catch:{ Exception -> 0x003e }
        r5 = r0[r5];	 Catch:{ Exception -> 0x003e }
        r2[r6] = r5;	 Catch:{ Exception -> 0x003e }
        r3 = r3 + 1;	 Catch:{ Exception -> 0x003e }
        goto L_0x001f;	 Catch:{ Exception -> 0x003e }
    L_0x0038:
        r8 = new java.lang.String;	 Catch:{ Exception -> 0x003e }
        r8.<init>(r2);	 Catch:{ Exception -> 0x003e }
        return r8;
    L_0x003e:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.e.a(java.lang.String):java.lang.String");
    }

    public static boolean a(int i) {
        return i == 1;
    }

    public static String b() {
        if (b != null && !b.isEmpty()) {
            return b;
        }
        String a = c.a("ro.product.model", "");
        b = a;
        a = a.replaceAll(" ", "");
        b = a;
        return a;
    }

    private static java.lang.String b(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r6 == 0) goto L_0x0035;
    L_0x0003:
        r1 = r6.isEmpty();
        if (r1 != 0) goto L_0x0035;
    L_0x0009:
        r1 = ",";
        r1 = r6.startsWith(r1);
        if (r1 != 0) goto L_0x0019;
    L_0x0011:
        r1 = ",";
        r1 = r6.endsWith(r1);
        if (r1 == 0) goto L_0x0021;
    L_0x0019:
        r1 = ",";
        r2 = "";
        r6 = r6.replace(r1, r2);
    L_0x0021:
        r1 = "0";
        r1 = r6.startsWith(r1);
        if (r1 == 0) goto L_0x0034;
    L_0x0029:
        r1 = java.lang.Long.parseLong(r6);	 Catch:{ Exception -> 0x0033 }
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x0034;
    L_0x0033:
        return r0;
    L_0x0034:
        return r6;
    L_0x0035:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.e.b(java.lang.String):java.lang.String");
    }

    public static String c() {
        if (c != null && !c.isEmpty()) {
            return c;
        }
        String a = c.a("ro.build.version.incremental", "");
        c = a;
        return a;
    }

    public static String d() {
        return !a.a() ? a.b() : a.c() ? "cts" : !c.a("ro.product.locale.region", "CN").equals("CN") ? "global" : a.d() ? "alpha" : a.e() ? "dev" : a.f() ? "stable" : "alpha";
    }

    public static int e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xiaomi.metoknlp.a.d.a();
        r1 = -1;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = r0.length();
        r3 = r0.isEmpty();
        if (r3 != 0) goto L_0x0020;
    L_0x0012:
        r3 = 1;
        if (r2 <= r3) goto L_0x0020;
    L_0x0015:
        r2 = 0;
        r3 = 3;
        r0 = r0.substring(r2, r3);	 Catch:{ Exception -> 0x0020 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0020 }
        return r0;
    L_0x0020:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.e.e():int");
    }

    public static int f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xiaomi.metoknlp.a.d.a();
        r1 = -1;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = r0.length();
        r3 = r0.isEmpty();
        if (r3 != 0) goto L_0x001f;
    L_0x0012:
        r3 = 1;
        if (r2 <= r3) goto L_0x001f;
    L_0x0015:
        r2 = 3;
        r0 = r0.substring(r2);	 Catch:{ Exception -> 0x001f }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x001f }
        return r0;
    L_0x001f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.a.e.f():int");
    }

    public static String g() {
        String str = "";
        try {
            return a.a().getPackageManager().getPackageInfo(a.a().getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String h() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
