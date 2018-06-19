package com.igexin.push.d.c;

public class p extends e {
    private static final String m = "com.igexin.push.d.c.p";
    public int a;
    public int b;
    public long c;
    public String d;
    public Object e;
    public Object f;
    public String g;
    public String h;

    public p() {
        this.h = "UTF-8";
        this.i = 26;
    }

    public void a(byte[] r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = com.igexin.b.a.b.f.c(r7, r0);
        r6.a = r1;
        r1 = 2;
        r2 = r7[r1];
        r3 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        r2 = r2 & r3;
        r6.b = r2;
        r1 = r7[r1];
        r1 = r6.a(r1);
        r6.h = r1;
        r1 = 3;
        r1 = com.igexin.b.a.b.f.e(r7, r1);
        r6.c = r1;
        r1 = 11;
        r1 = r7[r1];
        r1 = r1 & 255;
        r2 = 12;
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0030 }
        r5 = r6.h;	 Catch:{ Exception -> 0x0030 }
        r4.<init>(r7, r2, r1, r5);	 Catch:{ Exception -> 0x0030 }
        r6.d = r4;	 Catch:{ Exception -> 0x0030 }
        goto L_0x0034;
    L_0x0030:
        r4 = "";
        r6.d = r4;
    L_0x0034:
        r2 = r2 + r1;
        r1 = r0;
    L_0x0036:
        r4 = r7[r2];
        r4 = r4 & 127;
        r1 = r1 | r4;
        r4 = r7[r2];
        r4 = r4 & 128;
        if (r4 == 0) goto L_0x0046;
    L_0x0041:
        r1 = r1 << 7;
        r2 = r2 + 1;
        goto L_0x0036;
    L_0x0046:
        r2 = r2 + 1;
        if (r1 <= 0) goto L_0x0061;
    L_0x004a:
        r4 = r6.b;
        if (r4 != r3) goto L_0x0058;
    L_0x004e:
        r3 = new byte[r1];
        r6.e = r3;
        r3 = r6.e;
        java.lang.System.arraycopy(r7, r2, r3, r0, r1);
        goto L_0x0061;
    L_0x0058:
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x0061 }
        r4 = r6.h;	 Catch:{ Exception -> 0x0061 }
        r3.<init>(r7, r2, r1, r4);	 Catch:{ Exception -> 0x0061 }
        r6.e = r3;	 Catch:{ Exception -> 0x0061 }
    L_0x0061:
        r2 = r2 + r1;
        r1 = r0;
    L_0x0063:
        r3 = r7[r2];
        r3 = r3 & 127;
        r1 = r1 | r3;
        r3 = r7[r2];
        r3 = r3 & 128;
        if (r3 == 0) goto L_0x0073;
    L_0x006e:
        r1 = r1 << 7;
        r2 = r2 + 1;
        goto L_0x0063;
    L_0x0073:
        r2 = r2 + 1;
        if (r1 <= 0) goto L_0x0080;
    L_0x0077:
        r3 = new byte[r1];
        r6.f = r3;
        r3 = r6.f;
        java.lang.System.arraycopy(r7, r2, r3, r0, r1);
    L_0x0080:
        r2 = r2 + r1;
        r0 = r7.length;
        if (r0 <= r2) goto L_0x0093;
    L_0x0084:
        r0 = r2 + 1;
        r1 = r7[r2];
        r1 = r1 & 255;
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x0093 }
        r3 = r6.h;	 Catch:{ Exception -> 0x0093 }
        r2.<init>(r7, r0, r1, r3);	 Catch:{ Exception -> 0x0093 }
        r6.g = r2;	 Catch:{ Exception -> 0x0093 }
    L_0x0093:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.p.a(byte[]):void");
    }

    public final boolean a() {
        return this.b == 128;
    }

    public byte[] d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r13 = this;
        r0 = 0;
        r1 = r13.d;	 Catch:{ Exception -> 0x00a9 }
        r2 = r13.h;	 Catch:{ Exception -> 0x00a9 }
        r1 = r1.getBytes(r2);	 Catch:{ Exception -> 0x00a9 }
        r2 = r13.g;	 Catch:{ Exception -> 0x00a9 }
        r3 = r13.h;	 Catch:{ Exception -> 0x00a9 }
        r2 = r2.getBytes(r3);	 Catch:{ Exception -> 0x00a9 }
        r3 = "";	 Catch:{ Exception -> 0x00a9 }
        r4 = r13.e;	 Catch:{ Exception -> 0x00a9 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x00a9 }
        if (r3 != 0) goto L_0x0031;	 Catch:{ Exception -> 0x00a9 }
    L_0x001b:
        r3 = r13.b;	 Catch:{ Exception -> 0x00a9 }
        r4 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;	 Catch:{ Exception -> 0x00a9 }
        if (r3 != r4) goto L_0x0026;	 Catch:{ Exception -> 0x00a9 }
    L_0x0021:
        r3 = r13.e;	 Catch:{ Exception -> 0x00a9 }
        r3 = (byte[]) r3;	 Catch:{ Exception -> 0x00a9 }
        goto L_0x0032;	 Catch:{ Exception -> 0x00a9 }
    L_0x0026:
        r3 = r13.e;	 Catch:{ Exception -> 0x00a9 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x00a9 }
        r4 = r13.h;	 Catch:{ Exception -> 0x00a9 }
        r3 = r3.getBytes(r4);	 Catch:{ Exception -> 0x00a9 }
        goto L_0x0032;	 Catch:{ Exception -> 0x00a9 }
    L_0x0031:
        r3 = r0;	 Catch:{ Exception -> 0x00a9 }
    L_0x0032:
        r4 = r13.f;	 Catch:{ Exception -> 0x00a9 }
        if (r4 == 0) goto L_0x003b;	 Catch:{ Exception -> 0x00a9 }
    L_0x0036:
        r4 = r13.f;	 Catch:{ Exception -> 0x00a9 }
        r4 = (byte[]) r4;	 Catch:{ Exception -> 0x00a9 }
        goto L_0x003c;	 Catch:{ Exception -> 0x00a9 }
    L_0x003b:
        r4 = r0;	 Catch:{ Exception -> 0x00a9 }
    L_0x003c:
        r5 = 0;	 Catch:{ Exception -> 0x00a9 }
        if (r3 != 0) goto L_0x0041;	 Catch:{ Exception -> 0x00a9 }
    L_0x003f:
        r6 = r5;	 Catch:{ Exception -> 0x00a9 }
        goto L_0x0042;	 Catch:{ Exception -> 0x00a9 }
    L_0x0041:
        r6 = r3.length;	 Catch:{ Exception -> 0x00a9 }
    L_0x0042:
        if (r4 != 0) goto L_0x0046;	 Catch:{ Exception -> 0x00a9 }
    L_0x0044:
        r7 = r5;	 Catch:{ Exception -> 0x00a9 }
        goto L_0x0047;	 Catch:{ Exception -> 0x00a9 }
    L_0x0046:
        r7 = r4.length;	 Catch:{ Exception -> 0x00a9 }
    L_0x0047:
        r8 = com.igexin.b.a.b.f.a(r6);	 Catch:{ Exception -> 0x00a9 }
        r9 = com.igexin.b.a.b.f.a(r7);	 Catch:{ Exception -> 0x00a9 }
        r10 = 13;	 Catch:{ Exception -> 0x00a9 }
        r11 = r1.length;	 Catch:{ Exception -> 0x00a9 }
        r10 = r10 + r11;	 Catch:{ Exception -> 0x00a9 }
        r11 = r8.length;	 Catch:{ Exception -> 0x00a9 }
        r10 = r10 + r11;	 Catch:{ Exception -> 0x00a9 }
        r10 = r10 + r6;	 Catch:{ Exception -> 0x00a9 }
        r11 = r9.length;	 Catch:{ Exception -> 0x00a9 }
        r10 = r10 + r11;	 Catch:{ Exception -> 0x00a9 }
        r10 = r10 + r7;	 Catch:{ Exception -> 0x00a9 }
        r11 = r2.length;	 Catch:{ Exception -> 0x00a9 }
        r10 = r10 + r11;	 Catch:{ Exception -> 0x00a9 }
        r10 = new byte[r10];	 Catch:{ Exception -> 0x00a9 }
        r0 = r13.a;	 Catch:{ Exception -> 0x00aa }
        r0 = com.igexin.b.a.b.f.b(r0, r10, r5);	 Catch:{ Exception -> 0x00aa }
        r11 = r13.b;	 Catch:{ Exception -> 0x00aa }
        r12 = r13.h;	 Catch:{ Exception -> 0x00aa }
        r12 = r13.a(r12);	 Catch:{ Exception -> 0x00aa }
        r11 = r11 | r12;	 Catch:{ Exception -> 0x00aa }
        r11 = com.igexin.b.a.b.f.c(r11, r10, r0);	 Catch:{ Exception -> 0x00aa }
        r0 = r0 + r11;	 Catch:{ Exception -> 0x00aa }
        r11 = r13.c;	 Catch:{ Exception -> 0x00aa }
        r11 = com.igexin.b.a.b.f.a(r11, r10, r0);	 Catch:{ Exception -> 0x00aa }
        r0 = r0 + r11;	 Catch:{ Exception -> 0x00aa }
        r11 = r1.length;	 Catch:{ Exception -> 0x00aa }
        r11 = com.igexin.b.a.b.f.c(r11, r10, r0);	 Catch:{ Exception -> 0x00aa }
        r0 = r0 + r11;	 Catch:{ Exception -> 0x00aa }
        r11 = r1.length;	 Catch:{ Exception -> 0x00aa }
        r1 = com.igexin.b.a.b.f.a(r1, r5, r10, r0, r11);	 Catch:{ Exception -> 0x00aa }
        r0 = r0 + r1;	 Catch:{ Exception -> 0x00aa }
        r1 = r8.length;	 Catch:{ Exception -> 0x00aa }
        r1 = com.igexin.b.a.b.f.a(r8, r5, r10, r0, r1);	 Catch:{ Exception -> 0x00aa }
        r0 = r0 + r1;	 Catch:{ Exception -> 0x00aa }
        if (r6 <= 0) goto L_0x0091;	 Catch:{ Exception -> 0x00aa }
    L_0x008c:
        r1 = com.igexin.b.a.b.f.a(r3, r5, r10, r0, r6);	 Catch:{ Exception -> 0x00aa }
        r0 = r0 + r1;	 Catch:{ Exception -> 0x00aa }
    L_0x0091:
        r1 = r9.length;	 Catch:{ Exception -> 0x00aa }
        r1 = com.igexin.b.a.b.f.a(r9, r5, r10, r0, r1);	 Catch:{ Exception -> 0x00aa }
        r0 = r0 + r1;	 Catch:{ Exception -> 0x00aa }
        if (r7 <= 0) goto L_0x009e;	 Catch:{ Exception -> 0x00aa }
    L_0x0099:
        r1 = com.igexin.b.a.b.f.a(r4, r5, r10, r0, r7);	 Catch:{ Exception -> 0x00aa }
        r0 = r0 + r1;	 Catch:{ Exception -> 0x00aa }
    L_0x009e:
        r1 = r2.length;	 Catch:{ Exception -> 0x00aa }
        r1 = com.igexin.b.a.b.f.c(r1, r10, r0);	 Catch:{ Exception -> 0x00aa }
        r0 = r0 + r1;	 Catch:{ Exception -> 0x00aa }
        r1 = r2.length;	 Catch:{ Exception -> 0x00aa }
        com.igexin.b.a.b.f.a(r2, r5, r10, r0, r1);	 Catch:{ Exception -> 0x00aa }
        return r10;
    L_0x00a9:
        r10 = r0;
    L_0x00aa:
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.p.d():byte[]");
    }
}
