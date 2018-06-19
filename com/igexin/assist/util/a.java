package com.igexin.assist.util;

import java.security.MessageDigest;

public class a {
    public static java.lang.String a(java.lang.String r4, java.lang.String r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        r4 = com.igexin.push.util.h.a(r4, r0);	 Catch:{ Throwable -> 0x0046 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0046 }
        r0.<init>(r5);	 Catch:{ Throwable -> 0x0046 }
        r5 = r0.reverse();	 Catch:{ Throwable -> 0x0046 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0046 }
        r5 = r5.getBytes();	 Catch:{ Throwable -> 0x0046 }
        r5 = a(r5);	 Catch:{ Throwable -> 0x0046 }
        r0 = new javax.crypto.spec.SecretKeySpec;	 Catch:{ Throwable -> 0x0046 }
        r1 = "AES";	 Catch:{ Throwable -> 0x0046 }
        r0.<init>(r5, r1);	 Catch:{ Throwable -> 0x0046 }
        r5 = "AES/CFB128/NoPadding";	 Catch:{ Throwable -> 0x0046 }
        r5 = javax.crypto.Cipher.getInstance(r5);	 Catch:{ Throwable -> 0x0046 }
        r1 = "";	 Catch:{ Throwable -> 0x0046 }
        r1 = r1.getBytes();	 Catch:{ Throwable -> 0x0046 }
        r1 = a(r1);	 Catch:{ Throwable -> 0x0046 }
        r2 = 2;	 Catch:{ Throwable -> 0x0046 }
        r3 = new javax.crypto.spec.IvParameterSpec;	 Catch:{ Throwable -> 0x0046 }
        r3.<init>(r1);	 Catch:{ Throwable -> 0x0046 }
        r5.init(r2, r0, r3);	 Catch:{ Throwable -> 0x0046 }
        r4 = r5.doFinal(r4);	 Catch:{ Throwable -> 0x0046 }
        if (r4 == 0) goto L_0x0046;	 Catch:{ Throwable -> 0x0046 }
    L_0x0040:
        r5 = new java.lang.String;	 Catch:{ Throwable -> 0x0046 }
        r5.<init>(r4);	 Catch:{ Throwable -> 0x0046 }
        return r5;
    L_0x0046:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.util.a.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
