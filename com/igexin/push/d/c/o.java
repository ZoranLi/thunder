package com.igexin.push.d.c;

public class o extends e {
    public boolean a;
    public boolean b;
    public String c;
    public String d;
    public long e;

    public o() {
        this.i = 37;
    }

    public void a(byte[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r6[r0];
        r2 = r1 & 64;
        r3 = 1;
        if (r2 == 0) goto L_0x000a;
    L_0x0008:
        r2 = r3;
        goto L_0x000b;
    L_0x000a:
        r2 = r0;
    L_0x000b:
        r5.a = r2;
        r2 = r1 & 128;
        if (r2 == 0) goto L_0x0012;
    L_0x0011:
        r0 = r3;
    L_0x0012:
        r5.b = r0;
        r0 = r5.b;
        if (r0 == 0) goto L_0x002f;
    L_0x0018:
        r0 = r5.a(r1);
        r5.c = r0;
        r0 = com.igexin.b.a.b.f.c(r6, r3);
        r1 = r0 + 2;
        r3 = r3 + r1;
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x002f }
        r2 = 3;	 Catch:{ Exception -> 0x002f }
        r4 = r5.c;	 Catch:{ Exception -> 0x002f }
        r1.<init>(r6, r2, r0, r4);	 Catch:{ Exception -> 0x002f }
        r5.d = r1;	 Catch:{ Exception -> 0x002f }
    L_0x002f:
        r0 = r6.length;
        if (r0 <= r3) goto L_0x0038;
    L_0x0032:
        r0 = com.igexin.b.a.b.f.e(r6, r3);
        r5.e = r0;
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.o.a(byte[]):void");
    }

    public byte[] d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.a;
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0005:
        r0 = 64;
        goto L_0x0009;
    L_0x0008:
        r0 = r1;
    L_0x0009:
        r2 = r7.b;
        r3 = 0;
        if (r2 == 0) goto L_0x002b;
    L_0x000e:
        r0 = r0 | 128;
        r0 = (byte) r0;
        r2 = 3;
        r4 = r7.d;	 Catch:{ Exception -> 0x0021 }
        r5 = r7.c;	 Catch:{ Exception -> 0x0021 }
        r4 = r4.getBytes(r5);	 Catch:{ Exception -> 0x0021 }
        r3 = r4.length;	 Catch:{ Exception -> 0x0020 }
        r2 = r2 + r3;
        r6 = r4;
        r4 = r3;
        r3 = r6;
        goto L_0x0022;
    L_0x0020:
        r3 = r4;
    L_0x0021:
        r4 = r1;
    L_0x0022:
        r5 = r7.c;
        r5 = r7.a(r5);
        r0 = r0 | r5;
        r0 = (byte) r0;
        goto L_0x002d;
    L_0x002b:
        r2 = 1;
        r4 = r1;
    L_0x002d:
        r2 = r2 + 8;
        r2 = new byte[r2];
        r0 = com.igexin.b.a.b.f.c(r0, r2, r1);
        r5 = r7.b;
        if (r5 == 0) goto L_0x0044;
    L_0x0039:
        r0 = com.igexin.b.a.b.f.b(r4, r2, r0);
        if (r3 == 0) goto L_0x0044;
    L_0x003f:
        r1 = com.igexin.b.a.b.f.a(r3, r1, r2, r0, r4);
        r0 = r0 + r1;
    L_0x0044:
        r3 = r7.e;
        com.igexin.b.a.b.f.a(r3, r2, r0);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.o.d():byte[]");
    }
}
