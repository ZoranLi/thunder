package com.igexin.push.d.c;

import com.igexin.b.a.b.f;
import com.igexin.push.util.EncryptUtils;

public class i extends e {
    public String a;
    public byte[] b;
    public byte c;
    public String d;

    public i() {
        this.i = 96;
        this.j = (byte) 4;
        this.k = (byte) (this.k | 16);
    }

    private java.lang.String a(byte[] r3, int r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0008 }
        r1 = "UTF-8";	 Catch:{ Exception -> 0x0008 }
        r0.<init>(r3, r4, r5, r1);	 Catch:{ Exception -> 0x0008 }
        return r0;
    L_0x0008:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.i.a(byte[], int, int):java.lang.String");
    }

    public void a(byte[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r5[r0];	 Catch:{ Exception -> 0x002e }
        r4.c = r1;	 Catch:{ Exception -> 0x002e }
        r1 = 1;	 Catch:{ Exception -> 0x002e }
        r1 = r5[r1];	 Catch:{ Exception -> 0x002e }
        r1 = r1 & 255;	 Catch:{ Exception -> 0x002e }
        r2 = 2;	 Catch:{ Exception -> 0x002e }
        r3 = r4.a(r5, r2, r1);	 Catch:{ Exception -> 0x002e }
        r4.a = r3;	 Catch:{ Exception -> 0x002e }
        r2 = r2 + r1;	 Catch:{ Exception -> 0x002e }
        r1 = r2 + 1;	 Catch:{ Exception -> 0x002e }
        r2 = r5[r2];	 Catch:{ Exception -> 0x002e }
        r2 = r2 & 255;	 Catch:{ Exception -> 0x002e }
        r3 = new byte[r2];	 Catch:{ Exception -> 0x002e }
        r4.b = r3;	 Catch:{ Exception -> 0x002e }
        r3 = r4.b;	 Catch:{ Exception -> 0x002e }
        java.lang.System.arraycopy(r5, r1, r3, r0, r2);	 Catch:{ Exception -> 0x002e }
        r1 = r1 + r2;	 Catch:{ Exception -> 0x002e }
        r0 = r1 + 1;	 Catch:{ Exception -> 0x002e }
        r1 = r5[r1];	 Catch:{ Exception -> 0x002e }
        r1 = r1 & 255;	 Catch:{ Exception -> 0x002e }
        r5 = r4.a(r5, r0, r1);	 Catch:{ Exception -> 0x002e }
        r4.d = r5;	 Catch:{ Exception -> 0x002e }
    L_0x002e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.i.a(byte[]):void");
    }

    public byte[] d() {
        byte[] bytes = this.a.getBytes();
        byte[] iv = EncryptUtils.getIV(f.b((int) (System.currentTimeMillis() / 1000)));
        byte[] socketAESKey = EncryptUtils.getSocketAESKey();
        byte[] bArr = new byte[(((((bytes.length + 2) + 2) + socketAESKey.length) + 1) + iv.length)];
        int c = f.c(0, bArr, 0);
        c += f.c((byte) bytes.length, bArr, c);
        c += f.a(bytes, 0, bArr, c, bytes.length);
        c += f.b((short) socketAESKey.length, bArr, c);
        c += f.a(socketAESKey, 0, bArr, c, socketAESKey.length);
        f.a(iv, 0, bArr, c + f.c((byte) iv.length, bArr, c), iv.length);
        return bArr;
    }
}
