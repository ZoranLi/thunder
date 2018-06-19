package com.xunlei.downloadprovider.launch.a;

import java.util.Comparator;

/* compiled from: LaunchCounter */
final class b implements Comparator<String> {
    b() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return a((String) obj, (String) obj2);
    }

    private static int a(java.lang.String r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "\\.";
        r0 = r7.split(r0);
        r1 = "\\.";
        r1 = r8.split(r1);
        r2 = r0.length;
        r3 = r1.length;
        r2 = java.lang.Math.min(r2, r3);
        r3 = 0;
        r4 = r3;
    L_0x0014:
        if (r4 >= r2) goto L_0x002e;
    L_0x0016:
        r5 = r0[r4];	 Catch:{ NumberFormatException -> 0x002a }
        r5 = java.lang.Integer.parseInt(r5);	 Catch:{ NumberFormatException -> 0x002a }
        r6 = r1[r4];	 Catch:{ NumberFormatException -> 0x002a }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x002a }
        if (r5 == r6) goto L_0x0027;
    L_0x0024:
        r3 = r5 - r6;
        goto L_0x002e;
    L_0x0027:
        r4 = r4 + 1;
        goto L_0x0014;
    L_0x002a:
        r3 = r7.compareTo(r8);
    L_0x002e:
        if (r3 != 0) goto L_0x0034;
    L_0x0030:
        r7 = r0.length;
        r8 = r1.length;
        r3 = r7 - r8;
    L_0x0034:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.launch.a.b.a(java.lang.String, java.lang.String):int");
    }
}
