package com.igexin.push.d.c;

import java.util.List;

public class k extends e {
    public long a;
    public byte b;
    public int c;
    public String d;
    public List<l> e;

    public k() {
        this.i = 4;
        this.j = (byte) 20;
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
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.k.a(byte[], int, int):java.lang.String");
    }

    public void a(byte[] r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r0 = com.igexin.b.a.b.f.e(r7, r0);
        r6.a = r0;
        r0 = 8;
        r0 = r7[r0];
        r6.b = r0;
        r0 = 9;
        r0 = com.igexin.b.a.b.f.d(r7, r0);
        r0 = r0 & -1;
        r6.c = r0;
        r0 = 14;
        r1 = 13;
        r2 = r7.length;
        if (r2 <= r1) goto L_0x005f;
    L_0x001e:
        r1 = r7[r1];
        r1 = r1 & 255;
        if (r1 <= 0) goto L_0x0060;
    L_0x0024:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r6.e = r2;
        r1 = r1 + r0;
    L_0x002c:
        if (r0 >= r1) goto L_0x0060;
    L_0x002e:
        r2 = new com.igexin.push.d.c.l;
        r2.<init>();
        r3 = r6.e;
        r3.add(r2);
        r3 = r0 + 1;
        r0 = com.igexin.b.a.b.f.a(r7, r0);
        r0 = r0 & 255;
        r4 = r3 + 1;
        r3 = com.igexin.b.a.b.f.a(r7, r3);
        r3 = r3 & 255;
        r5 = (byte) r0;
        r2.a = r5;
        r5 = 1;
        if (r0 == r5) goto L_0x0051;
    L_0x004e:
        r5 = 4;
        if (r0 != r5) goto L_0x005c;
    L_0x0051:
        if (r3 <= 0) goto L_0x005c;
    L_0x0053:
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x005c }
        r5 = "UTF-8";	 Catch:{ Exception -> 0x005c }
        r0.<init>(r7, r4, r3, r5);	 Catch:{ Exception -> 0x005c }
        r2.b = r0;	 Catch:{ Exception -> 0x005c }
    L_0x005c:
        r0 = r4 + r3;
        goto L_0x002c;
    L_0x005f:
        r0 = r1;
    L_0x0060:
        r1 = r7.length;
        if (r1 <= r0) goto L_0x006f;
    L_0x0063:
        r1 = r0 + 1;
        r0 = r7[r0];
        r0 = r0 & 255;
        r7 = r6.a(r7, r1, r0);
        r6.d = r7;
    L_0x006f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.k.a(byte[]):void");
    }

    public byte[] d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.e;
        r1 = 0;
        if (r0 == 0) goto L_0x0034;
    L_0x0005:
        r0 = r7.e;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0034;
    L_0x000d:
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r2 = r7.e;
        r2 = r2.iterator();
    L_0x0018:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x0031;
    L_0x001e:
        r3 = r2.next();
        r3 = (com.igexin.push.d.c.l) r3;
        r3 = r3.d();
        r0.write(r3);	 Catch:{ IOException -> 0x0018 }
        r3 = r0.toByteArray();	 Catch:{ IOException -> 0x0018 }
        r1 = r3;
        goto L_0x0018;
    L_0x0031:
        r0.close();	 Catch:{ IOException -> 0x0034 }
    L_0x0034:
        r0 = 0;
        r2 = 1;
        if (r1 == 0) goto L_0x003c;
    L_0x0038:
        r3 = r1.length;
        r4 = r2 + r3;
        goto L_0x003e;
    L_0x003c:
        r3 = r0;
        r4 = r2;
    L_0x003e:
        r5 = 12;
        r5 = r5 + r4;
        r4 = r7.d;
        r4 = r4.getBytes();
        r4 = r4.length;
        r5 = r5 + r4;
        r5 = r5 + r2;
        r2 = new byte[r5];
        r4 = r7.a;
        r4 = com.igexin.b.a.b.f.a(r4, r2, r0);
        r5 = r7.b;
        r5 = r5 & 255;
        r5 = r5 << 24;
        r6 = r7.c;
        r5 = r5 | r6;
        r5 = com.igexin.b.a.b.f.a(r5, r2, r4);
        r4 = r4 + r5;
        r5 = com.igexin.b.a.b.f.c(r3, r2, r4);
        r4 = r4 + r5;
        if (r3 <= 0) goto L_0x006c;
    L_0x0067:
        r1 = com.igexin.b.a.b.f.a(r1, r0, r2, r4, r3);
        r4 = r4 + r1;
    L_0x006c:
        r1 = r7.d;
        r1 = r1.getBytes();
        r3 = r1.length;
        r5 = r4 + 1;
        com.igexin.b.a.b.f.c(r3, r2, r4);
        r3 = r1.length;
        java.lang.System.arraycopy(r1, r0, r2, r5, r3);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.k.d():byte[]");
    }
}
