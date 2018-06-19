package com.xiaomi.channel.commonutils.string;

import com.tencent.tinker.android.dx.instruction.Opcodes;

public class c {
    private static String a(byte b) {
        int i = (b & Opcodes.NEG_FLOAT) + (b < (byte) 0 ? 128 : 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i < 16 ? "0" : "");
        stringBuilder.append(Integer.toHexString(i).toLowerCase());
        return stringBuilder.toString();
    }

    public static java.lang.String a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x002f }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x002f }
        r1 = new java.lang.StringBuffer;
        r1.<init>();
        r2 = r4.getBytes();
        r4 = r4.length();
        r3 = 0;
        r0.update(r2, r3, r4);
        r4 = r0.digest();
    L_0x001b:
        r0 = r4.length;
        if (r3 >= r0) goto L_0x002a;
    L_0x001e:
        r0 = r4[r3];
        r0 = a(r0);
        r1.append(r0);
        r3 = r3 + 1;
        goto L_0x001b;
    L_0x002a:
        r4 = r1.toString();
        return r4;
    L_0x002f:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.string.c.a(java.lang.String):java.lang.String");
    }

    public static String b(String str) {
        return a(str).subSequence(8, 24).toString();
    }
}
