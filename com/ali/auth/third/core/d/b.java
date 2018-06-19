package com.ali.auth.third.core.d;

import android.text.TextUtils;

public final class b {
    private static final int a = 6;
    private static final int b = 8;

    public static void a(e eVar) {
        eVar.e = Long.valueOf(1000).longValue();
    }

    public static String b(e eVar) {
        String str = eVar.a;
        if (!TextUtils.isEmpty(str) && str.startsWith(".")) {
            str = str.substring(1);
        }
        StringBuilder stringBuilder = new StringBuilder("http://");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static com.ali.auth.third.core.d.e a(java.lang.String r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r19;
        r1 = r19.length();
        r2 = 0;
        r3 = r2;
    L_0x0008:
        r4 = 0;
        if (r3 < 0) goto L_0x01c1;
    L_0x000b:
        if (r3 >= r1) goto L_0x01c1;
    L_0x000d:
        r5 = r0.charAt(r3);
        r6 = 32;
        if (r5 != r6) goto L_0x0018;
    L_0x0015:
        r3 = r3 + 1;
        goto L_0x0008;
    L_0x0018:
        r5 = 59;
        r7 = r0.indexOf(r5, r3);
        r8 = 61;
        r9 = r0.indexOf(r8, r3);
        r10 = new com.ali.auth.third.core.d.e;
        r10.<init>();
        r11 = 34;
        r12 = -1;
        r13 = 1;
        if (r7 == r12) goto L_0x0031;
    L_0x002f:
        if (r7 < r9) goto L_0x0033;
    L_0x0031:
        if (r9 != r12) goto L_0x0040;
    L_0x0033:
        if (r7 != r12) goto L_0x0036;
    L_0x0035:
        r7 = r1;
    L_0x0036:
        r3 = r0.substring(r3, r7);
        r10.c = r3;
        r10.d = r4;
        r3 = r7;
        goto L_0x0080;
    L_0x0040:
        r7 = r0.substring(r3, r9);
        r10.c = r7;
        r7 = r1 + -1;
        if (r9 >= r7) goto L_0x005a;
    L_0x004a:
        r7 = r9 + 1;
        r7 = r0.charAt(r7);
        if (r7 != r11) goto L_0x005a;
    L_0x0052:
        r3 = r9 + 2;
        r3 = r0.indexOf(r11, r3);
        if (r3 == r12) goto L_0x01c1;
    L_0x005a:
        r3 = r0.indexOf(r5, r3);
        if (r3 != r12) goto L_0x0061;
    L_0x0060:
        r3 = r1;
    L_0x0061:
        r7 = r3 - r9;
        r14 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        if (r7 <= r14) goto L_0x0071;
    L_0x0067:
        r9 = r9 + r13;
        r7 = r9 + 4096;
        r7 = r0.substring(r9, r7);
    L_0x006e:
        r10.d = r7;
        goto L_0x0080;
    L_0x0071:
        r7 = r9 + 1;
        if (r7 == r3) goto L_0x007d;
    L_0x0075:
        if (r3 >= r9) goto L_0x0078;
    L_0x0077:
        goto L_0x007d;
    L_0x0078:
        r7 = r0.substring(r7, r3);
        goto L_0x006e;
    L_0x007d:
        r7 = "";
        goto L_0x006e;
    L_0x0080:
        if (r3 < 0) goto L_0x01c0;
    L_0x0082:
        if (r3 >= r1) goto L_0x01c0;
    L_0x0084:
        r7 = r0.charAt(r3);
        if (r7 == r6) goto L_0x01b6;
    L_0x008a:
        r7 = r0.charAt(r3);
        if (r7 != r5) goto L_0x0092;
    L_0x0090:
        goto L_0x01b6;
    L_0x0092:
        r7 = r0.charAt(r3);
        r9 = 44;
        if (r7 == r9) goto L_0x01c0;
    L_0x009a:
        r7 = r1 - r3;
        r14 = a;
        if (r7 < r14) goto L_0x00bf;
    L_0x00a0:
        r14 = a;
        r14 = r14 + r3;
        r14 = r0.substring(r3, r14);
        r15 = "secure";
        r14 = r14.equalsIgnoreCase(r15);
        if (r14 == 0) goto L_0x00bf;
    L_0x00af:
        r7 = a;
        r3 = r3 + r7;
        r10.f = r13;
        if (r3 == r1) goto L_0x01c0;
    L_0x00b6:
        r7 = r0.charAt(r3);
        if (r7 != r8) goto L_0x0080;
    L_0x00bc:
        r3 = r3 + 1;
        goto L_0x0080;
    L_0x00bf:
        r14 = b;
        if (r7 < r14) goto L_0x00e0;
    L_0x00c3:
        r7 = b;
        r7 = r7 + r3;
        r7 = r0.substring(r3, r7);
        r14 = "httponly";
        r7 = r7.equalsIgnoreCase(r14);
        if (r7 == 0) goto L_0x00e0;
    L_0x00d2:
        r7 = b;
        r3 = r3 + r7;
        r10.g = r13;
        if (r3 == r1) goto L_0x01c0;
    L_0x00d9:
        r7 = r0.charAt(r3);
        if (r7 != r8) goto L_0x0080;
    L_0x00df:
        goto L_0x00bc;
    L_0x00e0:
        r7 = r0.indexOf(r8, r3);
        if (r7 <= 0) goto L_0x01b3;
    L_0x00e6:
        r14 = r0.substring(r3, r7);
        r14 = r14.toLowerCase();
        r15 = "expires";
        r15 = r14.equals(r15);
        if (r15 == 0) goto L_0x0104;
    L_0x00f6:
        r15 = r0.indexOf(r9, r7);
        if (r15 == r12) goto L_0x0104;
    L_0x00fc:
        r6 = r15 - r7;
        r8 = 10;
        if (r6 > r8) goto L_0x0104;
    L_0x0102:
        r3 = r15 + 1;
    L_0x0104:
        r6 = r0.indexOf(r5, r3);
        r3 = r0.indexOf(r9, r3);
        if (r6 != r12) goto L_0x0112;
    L_0x010e:
        if (r3 != r12) goto L_0x0112;
    L_0x0110:
        r3 = r1;
        goto L_0x011d;
    L_0x0112:
        if (r6 != r12) goto L_0x0115;
    L_0x0114:
        goto L_0x011d;
    L_0x0115:
        if (r3 != r12) goto L_0x0119;
    L_0x0117:
        r3 = r6;
        goto L_0x011d;
    L_0x0119:
        r3 = java.lang.Math.min(r6, r3);
    L_0x011d:
        r7 = r7 + 1;
        r6 = r0.substring(r7, r3);
        r7 = r6.length();
        r8 = 2;
        if (r7 <= r8) goto L_0x013a;
    L_0x012a:
        r7 = r6.charAt(r2);
        if (r7 != r11) goto L_0x013a;
    L_0x0130:
        r7 = r6.indexOf(r11, r13);
        if (r7 <= 0) goto L_0x013a;
    L_0x0136:
        r6 = r6.substring(r13, r7);
    L_0x013a:
        r7 = "expires";
        r7 = r14.equals(r7);
        if (r7 == 0) goto L_0x014e;
    L_0x0142:
        r6 = com.ali.auth.third.core.d.d.a(r6);	 Catch:{ IllegalArgumentException -> 0x014a }
        r10.e = r6;	 Catch:{ IllegalArgumentException -> 0x014a }
        goto L_0x01b8;
    L_0x014a:
        r6 = com.ali.auth.third.core.config.a.a;
        goto L_0x01b8;
    L_0x014e:
        r7 = "max-age";
        r7 = r14.equals(r7);
        if (r7 == 0) goto L_0x016a;
    L_0x0156:
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ NumberFormatException -> 0x0167 }
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ NumberFormatException -> 0x0167 }
        r16 = java.lang.Long.parseLong(r6);	 Catch:{ NumberFormatException -> 0x0167 }
        r14 = r14 * r16;	 Catch:{ NumberFormatException -> 0x0167 }
        r5 = r7 + r14;	 Catch:{ NumberFormatException -> 0x0167 }
        r10.e = r5;	 Catch:{ NumberFormatException -> 0x0167 }
        goto L_0x01b8;
    L_0x0167:
        r5 = com.ali.auth.third.core.config.a.a;
        goto L_0x01b8;
    L_0x016a:
        r5 = "path";
        r5 = r14.equals(r5);
        if (r5 == 0) goto L_0x017b;
    L_0x0172:
        r5 = r6.length();
        if (r5 <= 0) goto L_0x01b8;
    L_0x0178:
        r10.b = r6;
        goto L_0x01b8;
    L_0x017b:
        r5 = "domain";
        r5 = r14.equals(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x0183:
        r5 = 46;
        r7 = r6.lastIndexOf(r5);
        if (r7 != 0) goto L_0x018e;
    L_0x018b:
        r10.a = r4;
        goto L_0x01b8;
    L_0x018e:
        r7 = r7 + 1;
        r7 = r6.substring(r7);	 Catch:{ NumberFormatException -> 0x0198 }
        java.lang.Integer.parseInt(r7);	 Catch:{ NumberFormatException -> 0x0198 }
        goto L_0x01b8;
    L_0x0198:
        r6 = r6.toLowerCase();
        r7 = r6.charAt(r2);
        if (r7 == r5) goto L_0x01b0;
    L_0x01a2:
        r5 = new java.lang.StringBuilder;
        r7 = ".";
        r5.<init>(r7);
        r5.append(r6);
        r6 = r5.toString();
    L_0x01b0:
        r10.a = r6;
        goto L_0x01b8;
    L_0x01b3:
        r3 = r1;
        goto L_0x0080;
    L_0x01b6:
        r3 = r3 + 1;
    L_0x01b8:
        r5 = 59;
        r6 = 32;
        r8 = 61;
        goto L_0x0080;
    L_0x01c0:
        return r10;
    L_0x01c1:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.d.b.a(java.lang.String):com.ali.auth.third.core.d.e");
    }
}
