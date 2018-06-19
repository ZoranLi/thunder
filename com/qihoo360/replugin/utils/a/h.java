package com.qihoo360.replugin.utils.a;

/* compiled from: SecurityUtil */
public final class h {
    public static byte[] a(java.io.File r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r6 = com.qihoo360.replugin.utils.c.a(r6);	 Catch:{ Exception -> 0x002e, all -> 0x0026 }
        r1 = "MD5";	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
    L_0x000f:
        r3 = r6.read(r2);	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
        if (r3 < 0) goto L_0x001c;	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
    L_0x0015:
        if (r3 <= 0) goto L_0x000f;	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
    L_0x0017:
        r4 = 0;	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
        r1.update(r2, r4, r3);	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
        goto L_0x000f;	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
    L_0x001c:
        r1 = r1.digest();	 Catch:{ Exception -> 0x002f, all -> 0x0024 }
        com.qihoo360.replugin.utils.b.a(r6);
        return r1;
    L_0x0024:
        r0 = move-exception;
        goto L_0x002a;
    L_0x0026:
        r6 = move-exception;
        r5 = r0;
        r0 = r6;
        r6 = r5;
    L_0x002a:
        com.qihoo360.replugin.utils.b.a(r6);
        throw r0;
    L_0x002e:
        r6 = r0;
    L_0x002f:
        com.qihoo360.replugin.utils.b.a(r6);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.a.h.a(java.io.File):byte[]");
    }
}
