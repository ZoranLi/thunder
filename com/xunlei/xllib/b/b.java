package com.xunlei.xllib.b;

import android.util.Base64;

/* compiled from: Base64Util */
public abstract class b {
    public static String a(byte[] bArr) {
        return new String(Base64.encode(bArr, 10));
    }

    public static byte[] a(String str) {
        try {
            return Base64.decode(str.getBytes("US-ASCII"), 0);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, String str2) {
        String str3 = "";
        try {
            return new String(Base64.decode(str.getBytes("US-ASCII"), 0), str2);
        } catch (String str4) {
            str4.printStackTrace();
            return str3;
        }
    }

    public static byte[] b(java.lang.String r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r14 = r14.getBytes();	 Catch:{ Exception -> 0x0089 }
        r0 = r14.length;	 Catch:{ Exception -> 0x0089 }
        r1 = new com.xunlei.xllib.b.a$b;	 Catch:{ Exception -> 0x0089 }
        r1.<init>();	 Catch:{ Exception -> 0x0089 }
        r2 = r0 + 1;	 Catch:{ Exception -> 0x0089 }
        r2 = r2 / 2;	 Catch:{ Exception -> 0x0089 }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0089 }
        r1.a = r2;	 Catch:{ Exception -> 0x0089 }
        r2 = r1.c;	 Catch:{ Exception -> 0x0089 }
        r3 = r1.a;	 Catch:{ Exception -> 0x0089 }
        r4 = r1.b;	 Catch:{ Exception -> 0x0089 }
        r5 = r1.d;	 Catch:{ Exception -> 0x0089 }
        r6 = r1.e;	 Catch:{ Exception -> 0x0089 }
        r7 = r1.g;	 Catch:{ Exception -> 0x0089 }
        r8 = 0;	 Catch:{ Exception -> 0x0089 }
        r0 = r0 + r8;	 Catch:{ Exception -> 0x0089 }
        r9 = 3;	 Catch:{ Exception -> 0x0089 }
        if (r5 != r9) goto L_0x0025;	 Catch:{ Exception -> 0x0089 }
    L_0x0023:
        r14 = r8;	 Catch:{ Exception -> 0x0089 }
        goto L_0x006c;	 Catch:{ Exception -> 0x0089 }
    L_0x0025:
        r10 = 1;	 Catch:{ Exception -> 0x0089 }
        r11 = r6;	 Catch:{ Exception -> 0x0089 }
        r6 = r4;	 Catch:{ Exception -> 0x0089 }
        r4 = r8;	 Catch:{ Exception -> 0x0089 }
    L_0x0029:
        if (r4 >= r0) goto L_0x0057;	 Catch:{ Exception -> 0x0089 }
    L_0x002b:
        r12 = r4 + 1;	 Catch:{ Exception -> 0x0089 }
        r4 = r14[r4];	 Catch:{ Exception -> 0x0089 }
        r4 = r4 & 255;	 Catch:{ Exception -> 0x0089 }
        r4 = r2[r4];	 Catch:{ Exception -> 0x0089 }
        r13 = -1;	 Catch:{ Exception -> 0x0089 }
        if (r4 == r13) goto L_0x0055;	 Catch:{ Exception -> 0x0089 }
    L_0x0036:
        r13 = -2;	 Catch:{ Exception -> 0x0089 }
        if (r4 != r13) goto L_0x0040;	 Catch:{ Exception -> 0x0089 }
    L_0x0039:
        if (r7 != 0) goto L_0x0055;	 Catch:{ Exception -> 0x0089 }
    L_0x003b:
        r1.f = r12;	 Catch:{ Exception -> 0x0089 }
        r14 = r8;	 Catch:{ Exception -> 0x0089 }
        r5 = r9;	 Catch:{ Exception -> 0x0089 }
        goto L_0x0058;	 Catch:{ Exception -> 0x0089 }
    L_0x0040:
        if (r5 != 0) goto L_0x0045;	 Catch:{ Exception -> 0x0089 }
    L_0x0042:
        r11 = r4;	 Catch:{ Exception -> 0x0089 }
        r5 = r10;	 Catch:{ Exception -> 0x0089 }
        goto L_0x0055;	 Catch:{ Exception -> 0x0089 }
    L_0x0045:
        if (r5 != r10) goto L_0x0055;	 Catch:{ Exception -> 0x0089 }
    L_0x0047:
        r5 = r6 + 1;	 Catch:{ Exception -> 0x0089 }
        r13 = r11 << 4;	 Catch:{ Exception -> 0x0089 }
        r4 = r4 & 15;	 Catch:{ Exception -> 0x0089 }
        r4 = r4 | r13;	 Catch:{ Exception -> 0x0089 }
        r4 = r4 & 255;	 Catch:{ Exception -> 0x0089 }
        r4 = (byte) r4;	 Catch:{ Exception -> 0x0089 }
        r3[r6] = r4;	 Catch:{ Exception -> 0x0089 }
        r6 = r5;	 Catch:{ Exception -> 0x0089 }
        r5 = r8;	 Catch:{ Exception -> 0x0089 }
    L_0x0055:
        r4 = r12;	 Catch:{ Exception -> 0x0089 }
        goto L_0x0029;	 Catch:{ Exception -> 0x0089 }
    L_0x0057:
        r14 = r10;	 Catch:{ Exception -> 0x0089 }
    L_0x0058:
        if (r5 != r10) goto L_0x0065;	 Catch:{ Exception -> 0x0089 }
    L_0x005a:
        r0 = r6 + 1;	 Catch:{ Exception -> 0x0089 }
        r2 = r11 << 4;	 Catch:{ Exception -> 0x0089 }
        r2 = r2 & 255;	 Catch:{ Exception -> 0x0089 }
        r2 = (byte) r2;	 Catch:{ Exception -> 0x0089 }
        r3[r6] = r2;	 Catch:{ Exception -> 0x0089 }
        r5 = r8;	 Catch:{ Exception -> 0x0089 }
        goto L_0x0066;	 Catch:{ Exception -> 0x0089 }
    L_0x0065:
        r0 = r6;	 Catch:{ Exception -> 0x0089 }
    L_0x0066:
        r1.d = r5;	 Catch:{ Exception -> 0x0089 }
        r1.e = r11;	 Catch:{ Exception -> 0x0089 }
        r1.b = r0;	 Catch:{ Exception -> 0x0089 }
    L_0x006c:
        if (r14 != 0) goto L_0x0076;	 Catch:{ Exception -> 0x0089 }
    L_0x006e:
        r14 = new java.nio.charset.MalformedInputException;	 Catch:{ Exception -> 0x0089 }
        r0 = r1.f;	 Catch:{ Exception -> 0x0089 }
        r14.<init>(r0);	 Catch:{ Exception -> 0x0089 }
        throw r14;	 Catch:{ Exception -> 0x0089 }
    L_0x0076:
        r14 = r1.a;	 Catch:{ Exception -> 0x0089 }
        r14 = r14.length;	 Catch:{ Exception -> 0x0089 }
        r0 = r1.b;	 Catch:{ Exception -> 0x0089 }
        if (r14 != r0) goto L_0x0080;	 Catch:{ Exception -> 0x0089 }
    L_0x007d:
        r14 = r1.a;	 Catch:{ Exception -> 0x0089 }
        return r14;	 Catch:{ Exception -> 0x0089 }
    L_0x0080:
        r14 = r1.a;	 Catch:{ Exception -> 0x0089 }
        r0 = r1.b;	 Catch:{ Exception -> 0x0089 }
        r14 = java.util.Arrays.copyOf(r14, r0);	 Catch:{ Exception -> 0x0089 }
        return r14;
    L_0x0089:
        r14 = 0;
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.b.b.b(java.lang.String):byte[]");
    }
}
