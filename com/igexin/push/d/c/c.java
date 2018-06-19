package com.igexin.push.d.c;

import com.igexin.push.f.b.b;

public class c extends e {
    public int a;
    public int b;
    public Object c;
    public String d;
    public String e;
    public int f;
    public b g;

    public c() {
        this.e = "UTF-8";
        this.f = 1;
        this.i = 27;
        this.j = (byte) 20;
    }

    public final void a() {
        this.b = 64;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(b bVar) {
        this.g = bVar;
    }

    public void a(byte[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = com.igexin.b.a.b.f.c(r6, r0);
        r5.a = r1;
        r1 = 2;
        r2 = r6[r1];
        r3 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        r2 = r2 & r3;
        r5.b = r2;
        r1 = r6[r1];
        r1 = r5.a(r1);
        r5.e = r1;
        r1 = 3;
        r2 = r1;
        r1 = r0;
    L_0x001a:
        r4 = r6[r2];
        r4 = r4 & 127;
        r1 = r1 | r4;
        r4 = r6[r2];
        r4 = r4 & 128;
        if (r4 == 0) goto L_0x002a;
    L_0x0025:
        r1 = r1 << 7;
        r2 = r2 + 1;
        goto L_0x001a;
    L_0x002a:
        r2 = r2 + 1;
        if (r1 <= 0) goto L_0x0045;
    L_0x002e:
        r4 = r5.b;
        if (r4 != r3) goto L_0x003c;
    L_0x0032:
        r3 = new byte[r1];
        r5.c = r3;
        r3 = r5.c;
        java.lang.System.arraycopy(r6, r2, r3, r0, r1);
        goto L_0x0045;
    L_0x003c:
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0045 }
        r3 = r5.e;	 Catch:{ Exception -> 0x0045 }
        r0.<init>(r6, r2, r1, r3);	 Catch:{ Exception -> 0x0045 }
        r5.c = r0;	 Catch:{ Exception -> 0x0045 }
    L_0x0045:
        r2 = r2 + r1;
        r0 = r6[r2];
        r0 = r0 & 255;
        r2 = r2 + 1;
        r1 = r6.length;
        if (r1 <= r2) goto L_0x0058;
    L_0x004f:
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x0058 }
        r3 = r5.e;	 Catch:{ Exception -> 0x0058 }
        r1.<init>(r6, r2, r0, r3);	 Catch:{ Exception -> 0x0058 }
        r5.d = r1;	 Catch:{ Exception -> 0x0058 }
    L_0x0058:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.c.a(byte[]):void");
    }

    public int c() {
        return this.f;
    }

    public byte[] d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = 0;
        r1 = r9.d;	 Catch:{ Exception -> 0x0068 }
        r2 = r9.e;	 Catch:{ Exception -> 0x0068 }
        r1 = r1.getBytes(r2);	 Catch:{ Exception -> 0x0068 }
        r2 = "";	 Catch:{ Exception -> 0x0068 }
        r3 = r9.c;	 Catch:{ Exception -> 0x0068 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x0068 }
        if (r2 != 0) goto L_0x0029;	 Catch:{ Exception -> 0x0068 }
    L_0x0013:
        r2 = r9.b;	 Catch:{ Exception -> 0x0068 }
        r3 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;	 Catch:{ Exception -> 0x0068 }
        if (r2 != r3) goto L_0x001e;	 Catch:{ Exception -> 0x0068 }
    L_0x0019:
        r2 = r9.c;	 Catch:{ Exception -> 0x0068 }
        r2 = (byte[]) r2;	 Catch:{ Exception -> 0x0068 }
        goto L_0x002a;	 Catch:{ Exception -> 0x0068 }
    L_0x001e:
        r2 = r9.c;	 Catch:{ Exception -> 0x0068 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0068 }
        r3 = r9.e;	 Catch:{ Exception -> 0x0068 }
        r2 = r2.getBytes(r3);	 Catch:{ Exception -> 0x0068 }
        goto L_0x002a;	 Catch:{ Exception -> 0x0068 }
    L_0x0029:
        r2 = r0;	 Catch:{ Exception -> 0x0068 }
    L_0x002a:
        r3 = 0;	 Catch:{ Exception -> 0x0068 }
        if (r2 != 0) goto L_0x002f;	 Catch:{ Exception -> 0x0068 }
    L_0x002d:
        r4 = r3;	 Catch:{ Exception -> 0x0068 }
        goto L_0x0030;	 Catch:{ Exception -> 0x0068 }
    L_0x002f:
        r4 = r2.length;	 Catch:{ Exception -> 0x0068 }
    L_0x0030:
        r5 = com.igexin.b.a.b.f.a(r4);	 Catch:{ Exception -> 0x0068 }
        r6 = 4;	 Catch:{ Exception -> 0x0068 }
        r7 = r5.length;	 Catch:{ Exception -> 0x0068 }
        r6 = r6 + r7;	 Catch:{ Exception -> 0x0068 }
        r6 = r6 + r4;	 Catch:{ Exception -> 0x0068 }
        r7 = r1.length;	 Catch:{ Exception -> 0x0068 }
        r6 = r6 + r7;	 Catch:{ Exception -> 0x0068 }
        r6 = new byte[r6];	 Catch:{ Exception -> 0x0068 }
        r0 = r9.a;	 Catch:{ Exception -> 0x0069 }
        r0 = com.igexin.b.a.b.f.b(r0, r6, r3);	 Catch:{ Exception -> 0x0069 }
        r7 = r9.b;	 Catch:{ Exception -> 0x0069 }
        r8 = r9.e;	 Catch:{ Exception -> 0x0069 }
        r8 = r9.a(r8);	 Catch:{ Exception -> 0x0069 }
        r7 = r7 | r8;	 Catch:{ Exception -> 0x0069 }
        r7 = com.igexin.b.a.b.f.c(r7, r6, r0);	 Catch:{ Exception -> 0x0069 }
        r0 = r0 + r7;	 Catch:{ Exception -> 0x0069 }
        r7 = r5.length;	 Catch:{ Exception -> 0x0069 }
        r5 = com.igexin.b.a.b.f.a(r5, r3, r6, r0, r7);	 Catch:{ Exception -> 0x0069 }
        r0 = r0 + r5;	 Catch:{ Exception -> 0x0069 }
        if (r4 <= 0) goto L_0x005d;	 Catch:{ Exception -> 0x0069 }
    L_0x0058:
        r2 = com.igexin.b.a.b.f.a(r2, r3, r6, r0, r4);	 Catch:{ Exception -> 0x0069 }
        r0 = r0 + r2;	 Catch:{ Exception -> 0x0069 }
    L_0x005d:
        r2 = r1.length;	 Catch:{ Exception -> 0x0069 }
        r2 = com.igexin.b.a.b.f.c(r2, r6, r0);	 Catch:{ Exception -> 0x0069 }
        r0 = r0 + r2;	 Catch:{ Exception -> 0x0069 }
        r2 = r1.length;	 Catch:{ Exception -> 0x0069 }
        com.igexin.b.a.b.f.a(r1, r3, r6, r0, r2);	 Catch:{ Exception -> 0x0069 }
        goto L_0x0069;
    L_0x0068:
        r6 = r0;
    L_0x0069:
        if (r6 == 0) goto L_0x0077;
    L_0x006b:
        r0 = r6.length;
        r1 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r0 < r1) goto L_0x0077;
    L_0x0070:
        r0 = r9.j;
        r0 = r0 | 128;
        r0 = (byte) r0;
        r9.j = r0;
    L_0x0077:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.c.d():byte[]");
    }

    public b e() {
        return this.g;
    }
}
