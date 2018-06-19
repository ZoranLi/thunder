package com.tencent.smtt.utils;

import com.tencent.smtt.sdk.a.a;
import java.security.Provider;
import java.security.Security;
import java.util.Random;

public class q {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static q b;
    private String c;
    private String d;
    private String e = String.valueOf(new Random().nextInt(89999999) + 10000000);

    private q() {
        int nextInt = new Random().nextInt(89999999) + 10000000;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append(String.valueOf(nextInt));
        this.c = stringBuilder.toString();
    }

    public static synchronized q a() {
        q qVar;
        synchronized (q.class) {
            if (b == null) {
                b = new q();
            }
            qVar = b;
        }
        return qVar;
    }

    private String b(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = a[i2 >>> 4];
            cArr[i3 + 1] = a[i2 & 15];
        }
        return new String(cArr);
    }

    public java.lang.String a(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r5 = r5.getBytes();
        r0 = "RSA/ECB/NoPadding";	 Catch:{ Exception -> 0x000b }
        r0 = javax.crypto.Cipher.getInstance(r0);	 Catch:{ Exception -> 0x000b }
        goto L_0x001a;
    L_0x000b:
        r4.b();	 Catch:{ Exception -> 0x0015 }
        r0 = "RSA/ECB/NoPadding";	 Catch:{ Exception -> 0x0015 }
        r0 = javax.crypto.Cipher.getInstance(r0);	 Catch:{ Exception -> 0x0015 }
        goto L_0x001a;
    L_0x0015:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = 0;
    L_0x001a:
        r1 = "MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==";
        r1 = r1.getBytes();
        r2 = new java.security.spec.X509EncodedKeySpec;
        r3 = 0;
        r1 = android.util.Base64.decode(r1, r3);
        r2.<init>(r1);
        r1 = "RSA";
        r1 = java.security.KeyFactory.getInstance(r1);
        r1 = r1.generatePublic(r2);
        r2 = 1;
        r0.init(r2, r1);
        r5 = r0.doFinal(r5);
        r5 = r4.b(r5);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.q.a(java.lang.String):java.lang.String");
    }

    public byte[] a(byte[] bArr) {
        return a.a(this.e.getBytes(), bArr, 1);
    }

    public void b() {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    public java.lang.String c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.d;
        if (r0 != 0) goto L_0x0049;
    L_0x0004:
        r0 = r5.c;
        r0 = r0.getBytes();
        r1 = 0;
        r2 = "RSA/ECB/NoPadding";	 Catch:{ Exception -> 0x0012 }
        r2 = javax.crypto.Cipher.getInstance(r2);	 Catch:{ Exception -> 0x0012 }
        goto L_0x0021;
    L_0x0012:
        r5.b();	 Catch:{ Exception -> 0x001c }
        r2 = "RSA/ECB/NoPadding";	 Catch:{ Exception -> 0x001c }
        r2 = javax.crypto.Cipher.getInstance(r2);	 Catch:{ Exception -> 0x001c }
        goto L_0x0021;
    L_0x001c:
        r2 = move-exception;
        r2.printStackTrace();
        r2 = r1;
    L_0x0021:
        r1 = "MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==";
        r1 = r1.getBytes();
        r3 = new java.security.spec.X509EncodedKeySpec;
        r4 = 0;
        r1 = android.util.Base64.decode(r1, r4);
        r3.<init>(r1);
        r1 = "RSA";
        r1 = java.security.KeyFactory.getInstance(r1);
        r1 = r1.generatePublic(r3);
        r3 = 1;
        r2.init(r3, r1);
        r0 = r2.doFinal(r0);
        r0 = r5.b(r0);
        r5.d = r0;
    L_0x0049:
        r0 = r5.d;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.q.c():java.lang.String");
    }
}
