package com.alipay.sdk.encrypt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public final class d {
    private static final String a = "RSA";

    private static PublicKey b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.a(str2)));
    }

    public static byte[] a(java.lang.String r5, java.lang.String r6) {
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
        r1 = "RSA";	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r6 = com.alipay.sdk.encrypt.a.a(r6);	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r2 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r2.<init>(r6);	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r6 = java.security.KeyFactory.getInstance(r1);	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r6 = r6.generatePublic(r2);	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r1 = "RSA/ECB/PKCS1Padding";	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r1 = javax.crypto.Cipher.getInstance(r1);	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r2 = 1;	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r1.init(r2, r6);	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r6 = "UTF-8";	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r5 = r5.getBytes(r6);	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r6 = r1.getBlockSize();	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r2.<init>();	 Catch:{ Exception -> 0x0054, all -> 0x004d }
        r3 = 0;
    L_0x002e:
        r4 = r5.length;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
        if (r3 >= r4) goto L_0x0042;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
    L_0x0031:
        r4 = r5.length;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
        r4 = r4 - r3;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
        if (r4 >= r6) goto L_0x0038;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
    L_0x0035:
        r4 = r5.length;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
        r4 = r4 - r3;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
        goto L_0x0039;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
    L_0x0038:
        r4 = r6;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
    L_0x0039:
        r4 = r1.doFinal(r5, r3, r4);	 Catch:{ Exception -> 0x0055, all -> 0x004a }
        r2.write(r4);	 Catch:{ Exception -> 0x0055, all -> 0x004a }
        r3 = r3 + r6;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
        goto L_0x002e;	 Catch:{ Exception -> 0x0055, all -> 0x004a }
    L_0x0042:
        r5 = r2.toByteArray();	 Catch:{ Exception -> 0x0055, all -> 0x004a }
        r2.close();	 Catch:{ IOException -> 0x005b }
        goto L_0x005b;
    L_0x004a:
        r5 = move-exception;
        r0 = r2;
        goto L_0x004e;
    L_0x004d:
        r5 = move-exception;
    L_0x004e:
        if (r0 == 0) goto L_0x0053;
    L_0x0050:
        r0.close();	 Catch:{ IOException -> 0x0053 }
    L_0x0053:
        throw r5;
    L_0x0054:
        r2 = r0;
    L_0x0055:
        if (r2 == 0) goto L_0x005a;
    L_0x0057:
        r2.close();	 Catch:{ IOException -> 0x005a }
    L_0x005a:
        r5 = r0;
    L_0x005b:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.encrypt.d.a(java.lang.String, java.lang.String):byte[]");
    }
}
