package com.tencent.mm.opensdk.a;

public final class b {
    public static final java.lang.String e(byte[] r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 16;
        r0 = new char[r0];
        r0 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        r1 = "MD5";	 Catch:{ Exception -> 0x003a }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x003a }
        r1.update(r8);	 Catch:{ Exception -> 0x003a }
        r8 = r1.digest();	 Catch:{ Exception -> 0x003a }
        r1 = r8.length;	 Catch:{ Exception -> 0x003a }
        r2 = r1 * 2;	 Catch:{ Exception -> 0x003a }
        r2 = new char[r2];	 Catch:{ Exception -> 0x003a }
        r3 = 0;	 Catch:{ Exception -> 0x003a }
        r4 = r3;	 Catch:{ Exception -> 0x003a }
    L_0x001b:
        if (r3 >= r1) goto L_0x0034;	 Catch:{ Exception -> 0x003a }
    L_0x001d:
        r5 = r8[r3];	 Catch:{ Exception -> 0x003a }
        r6 = r4 + 1;	 Catch:{ Exception -> 0x003a }
        r7 = r5 >>> 4;	 Catch:{ Exception -> 0x003a }
        r7 = r7 & 15;	 Catch:{ Exception -> 0x003a }
        r7 = r0[r7];	 Catch:{ Exception -> 0x003a }
        r2[r4] = r7;	 Catch:{ Exception -> 0x003a }
        r4 = r6 + 1;	 Catch:{ Exception -> 0x003a }
        r5 = r5 & 15;	 Catch:{ Exception -> 0x003a }
        r5 = r0[r5];	 Catch:{ Exception -> 0x003a }
        r2[r6] = r5;	 Catch:{ Exception -> 0x003a }
        r3 = r3 + 1;	 Catch:{ Exception -> 0x003a }
        goto L_0x001b;	 Catch:{ Exception -> 0x003a }
    L_0x0034:
        r8 = new java.lang.String;	 Catch:{ Exception -> 0x003a }
        r8.<init>(r2);	 Catch:{ Exception -> 0x003a }
        return r8;
    L_0x003a:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.a.b.e(byte[]):java.lang.String");
    }
}
