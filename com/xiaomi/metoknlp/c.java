package com.xiaomi.metoknlp;

import java.util.HashMap;
import java.util.Map;

public final class c {
    private static String a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a() {
        /*
        r0 = com.xiaomi.metoknlp.a.e.b();
        r1 = com.xiaomi.metoknlp.a.e.c();
        r2 = com.xiaomi.metoknlp.a.e.g();
        r3 = com.xiaomi.metoknlp.a.e.e();
        r4 = com.xiaomi.metoknlp.a.e.f();
        r5 = 0;
        if (r0 == 0) goto L_0x0071;
    L_0x0017:
        r6 = r0.isEmpty();
        if (r6 != 0) goto L_0x0071;
    L_0x001d:
        if (r1 == 0) goto L_0x0071;
    L_0x001f:
        r6 = r1.isEmpty();
        if (r6 == 0) goto L_0x0026;
    L_0x0025:
        return r5;
    L_0x0026:
        r6 = a;
        if (r6 != 0) goto L_0x0048;
    L_0x002a:
        r6 = com.xiaomi.metoknlp.a.e.a();
        if (r6 == 0) goto L_0x0047;
    L_0x0030:
        r7 = r6.isEmpty();
        if (r7 == 0) goto L_0x0037;
    L_0x0036:
        return r5;
    L_0x0037:
        r6 = com.xiaomi.metoknlp.a.e.a(r6);
        if (r6 == 0) goto L_0x0043;
    L_0x003d:
        r6 = com.xiaomi.metoknlp.a.e.a(r6);
        a = r6;
    L_0x0043:
        r6 = a;
        if (r6 != 0) goto L_0x0048;
    L_0x0047:
        return r5;
    L_0x0048:
        if (r3 < 0) goto L_0x004c;
    L_0x004a:
        if (r4 >= 0) goto L_0x0050;
    L_0x004c:
        r3 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        r4 = 99;
    L_0x0050:
        r5 = "%s__%s__%d__%d__%s";
        r6 = 5;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r0;
        r0 = 1;
        r6[r0] = r1;
        r0 = 2;
        r1 = java.lang.Integer.valueOf(r3);
        r6[r0] = r1;
        r0 = 3;
        r1 = java.lang.Integer.valueOf(r4);
        r6[r0] = r1;
        r0 = 4;
        r6[r0] = r2;
        r0 = java.lang.String.format(r5, r6);
        return r0;
    L_0x0071:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.c.a():java.lang.String");
    }

    public static java.lang.String a(java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xiaomi.metoknlp.a.f.a();
        r1 = a();
        r2 = 0;
        if (r1 != 0) goto L_0x000c;
    L_0x000b:
        return r2;
    L_0x000c:
        r3 = new java.lang.StringBuffer;
        r3.<init>(r0);
        r0 = "/base/profile/metoknlpsdk/";
        r3.append(r0);
        r3.append(r4);
        r4 = "/";
        r3.append(r4);
        r3.append(r1);
        r4 = "__";
        r3.append(r4);
        r3.append(r5);
        r4 = r3.toString();
        r5 = b();
        r4 = com.xiaomi.metoknlp.a.b.a(r4, r5);	 Catch:{ Exception -> 0x0036 }
        goto L_0x0037;
    L_0x0036:
        r4 = r2;
    L_0x0037:
        r5.clear();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.c.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static Map b() {
        String a = a();
        Map hashMap = new HashMap();
        hashMap.put("CCPVER", a);
        hashMap.put("CCPINF", a);
        return hashMap;
    }
}
