package com.alipay.b.a.a.a.a;

import java.lang.reflect.Method;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;

public final class c {
    private static String a = new String("idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#");

    public static String a() {
        String str = new String();
        for (int i = 0; i < a.length() - 1; i += 4) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(a.charAt(i));
            str = stringBuilder.toString();
        }
        return str;
    }

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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = r4.getBytes();	 Catch:{ Exception -> 0x002d }
        r4 = a(r4);	 Catch:{ Exception -> 0x002d }
        r5 = r5.getBytes();	 Catch:{ Exception -> 0x002d }
        r0 = new javax.crypto.spec.SecretKeySpec;	 Catch:{ Exception -> 0x002d }
        r1 = "AES";	 Catch:{ Exception -> 0x002d }
        r0.<init>(r4, r1);	 Catch:{ Exception -> 0x002d }
        r4 = "AES/CBC/PKCS5Padding";	 Catch:{ Exception -> 0x002d }
        r4 = javax.crypto.Cipher.getInstance(r4);	 Catch:{ Exception -> 0x002d }
        r1 = 1;	 Catch:{ Exception -> 0x002d }
        r2 = new javax.crypto.spec.IvParameterSpec;	 Catch:{ Exception -> 0x002d }
        r3 = r4.getBlockSize();	 Catch:{ Exception -> 0x002d }
        r3 = new byte[r3];	 Catch:{ Exception -> 0x002d }
        r2.<init>(r3);	 Catch:{ Exception -> 0x002d }
        r4.init(r1, r0, r2);	 Catch:{ Exception -> 0x002d }
        r4 = r4.doFinal(r5);	 Catch:{ Exception -> 0x002d }
        goto L_0x002e;
    L_0x002d:
        r4 = 0;
    L_0x002e:
        r4 = b(r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.a.a.c.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static byte[] a(byte[] bArr) {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        Method method = SecureRandom.class.getMethod("setSeed", new Class[]{bArr.getClass()});
        method.setAccessible(true);
        method.invoke(instance2, new Object[]{bArr});
        instance.init(128, instance2);
        return instance.generateKey().getEncoded();
    }

    public static java.lang.String b(java.lang.String r6, java.lang.String r7) {
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
        r6 = r6.getBytes();	 Catch:{ Exception -> 0x004f }
        r6 = a(r6);	 Catch:{ Exception -> 0x004f }
        r0 = r7.length();	 Catch:{ Exception -> 0x004f }
        r1 = 2;	 Catch:{ Exception -> 0x004f }
        r0 = r0 / r1;	 Catch:{ Exception -> 0x004f }
        r2 = new byte[r0];	 Catch:{ Exception -> 0x004f }
        r3 = 0;	 Catch:{ Exception -> 0x004f }
    L_0x0011:
        if (r3 >= r0) goto L_0x002a;	 Catch:{ Exception -> 0x004f }
    L_0x0013:
        r4 = r1 * r3;	 Catch:{ Exception -> 0x004f }
        r5 = r4 + 2;	 Catch:{ Exception -> 0x004f }
        r4 = r7.substring(r4, r5);	 Catch:{ Exception -> 0x004f }
        r5 = 16;	 Catch:{ Exception -> 0x004f }
        r4 = java.lang.Integer.valueOf(r4, r5);	 Catch:{ Exception -> 0x004f }
        r4 = r4.byteValue();	 Catch:{ Exception -> 0x004f }
        r2[r3] = r4;	 Catch:{ Exception -> 0x004f }
        r3 = r3 + 1;	 Catch:{ Exception -> 0x004f }
        goto L_0x0011;	 Catch:{ Exception -> 0x004f }
    L_0x002a:
        r7 = new javax.crypto.spec.SecretKeySpec;	 Catch:{ Exception -> 0x004f }
        r0 = "AES";	 Catch:{ Exception -> 0x004f }
        r7.<init>(r6, r0);	 Catch:{ Exception -> 0x004f }
        r6 = "AES/CBC/PKCS5Padding";	 Catch:{ Exception -> 0x004f }
        r6 = javax.crypto.Cipher.getInstance(r6);	 Catch:{ Exception -> 0x004f }
        r0 = new javax.crypto.spec.IvParameterSpec;	 Catch:{ Exception -> 0x004f }
        r3 = r6.getBlockSize();	 Catch:{ Exception -> 0x004f }
        r3 = new byte[r3];	 Catch:{ Exception -> 0x004f }
        r0.<init>(r3);	 Catch:{ Exception -> 0x004f }
        r6.init(r1, r7, r0);	 Catch:{ Exception -> 0x004f }
        r6 = r6.doFinal(r2);	 Catch:{ Exception -> 0x004f }
        r7 = new java.lang.String;	 Catch:{ Exception -> 0x004f }
        r7.<init>(r6);	 Catch:{ Exception -> 0x004f }
        return r7;
    L_0x004f:
        r6 = 0;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.a.a.c.b(java.lang.String, java.lang.String):java.lang.String");
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(2 * bArr.length);
        for (byte b : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
        }
        return stringBuffer.toString();
    }
}
