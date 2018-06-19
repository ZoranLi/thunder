package com.huawei.hms.c;

import com.huawei.hms.support.log.a;
import java.security.MessageDigest;

/* compiled from: SHA256 */
public final class f {
    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (byte[] bArr2) {
            StringBuilder stringBuilder = new StringBuilder("NoSuchAlgorithmException");
            stringBuilder.append(bArr2.getMessage());
            a.d("SHA256", stringBuilder.toString());
            return new byte[null];
        }
    }

    public static byte[] a(java.io.File r6) {
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
        r0 = 0;
        r1 = 0;
        r2 = "SHA-256";	 Catch:{ NoSuchAlgorithmException -> 0x0038, NoSuchAlgorithmException -> 0x0038 }
        r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0038, NoSuchAlgorithmException -> 0x0038 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ NoSuchAlgorithmException -> 0x0038, NoSuchAlgorithmException -> 0x0038 }
        r4 = new java.io.FileInputStream;	 Catch:{ NoSuchAlgorithmException -> 0x0038, NoSuchAlgorithmException -> 0x0038 }
        r4.<init>(r6);	 Catch:{ NoSuchAlgorithmException -> 0x0038, NoSuchAlgorithmException -> 0x0038 }
        r3.<init>(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0038, NoSuchAlgorithmException -> 0x0038 }
        r6 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r6 = new byte[r6];	 Catch:{ NoSuchAlgorithmException -> 0x0034, NoSuchAlgorithmException -> 0x0034, all -> 0x0031 }
        r1 = r0;	 Catch:{ NoSuchAlgorithmException -> 0x0034, NoSuchAlgorithmException -> 0x0034, all -> 0x0031 }
    L_0x0017:
        r4 = r3.read(r6);	 Catch:{ NoSuchAlgorithmException -> 0x0034, NoSuchAlgorithmException -> 0x0034, all -> 0x0031 }
        r5 = -1;	 Catch:{ NoSuchAlgorithmException -> 0x0034, NoSuchAlgorithmException -> 0x0034, all -> 0x0031 }
        if (r4 == r5) goto L_0x0023;	 Catch:{ NoSuchAlgorithmException -> 0x0034, NoSuchAlgorithmException -> 0x0034, all -> 0x0031 }
    L_0x001e:
        r1 = r1 + r4;	 Catch:{ NoSuchAlgorithmException -> 0x0034, NoSuchAlgorithmException -> 0x0034, all -> 0x0031 }
        r2.update(r6, r0, r4);	 Catch:{ NoSuchAlgorithmException -> 0x0034, NoSuchAlgorithmException -> 0x0034, all -> 0x0031 }
        goto L_0x0017;	 Catch:{ NoSuchAlgorithmException -> 0x0034, NoSuchAlgorithmException -> 0x0034, all -> 0x0031 }
    L_0x0023:
        if (r1 <= 0) goto L_0x002d;	 Catch:{ NoSuchAlgorithmException -> 0x0034, NoSuchAlgorithmException -> 0x0034, all -> 0x0031 }
    L_0x0025:
        r6 = r2.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0034, NoSuchAlgorithmException -> 0x0034, all -> 0x0031 }
        com.huawei.hms.c.c.a(r3);
        return r6;
    L_0x002d:
        com.huawei.hms.c.c.a(r3);
        goto L_0x0042;
    L_0x0031:
        r6 = move-exception;
        r1 = r3;
        goto L_0x0045;
    L_0x0034:
        r1 = r3;
        goto L_0x0038;
    L_0x0036:
        r6 = move-exception;
        goto L_0x0045;
    L_0x0038:
        r6 = "SHA256";	 Catch:{ all -> 0x0036 }
        r2 = "An exception occurred while computing file 'SHA-256'.";	 Catch:{ all -> 0x0036 }
        com.huawei.hms.support.log.a.d(r6, r2);	 Catch:{ all -> 0x0036 }
        com.huawei.hms.c.c.a(r1);
    L_0x0042:
        r6 = new byte[r0];
        return r6;
    L_0x0045:
        com.huawei.hms.c.c.a(r1);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.c.f.a(java.io.File):byte[]");
    }
}
