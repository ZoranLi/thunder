package org.apache.thrift.protocol;

import java.nio.ByteBuffer;
import org.apache.thrift.f;
import org.apache.thrift.transport.d;

public class a extends e {
    private static final j f = new j();
    protected boolean a = false;
    protected boolean b = true;
    protected int c;
    protected boolean d = false;
    private byte[] g = new byte[1];
    private byte[] h = new byte[2];
    private byte[] i = new byte[4];
    private byte[] j = new byte[8];
    private byte[] k = new byte[1];
    private byte[] l = new byte[2];
    private byte[] m = new byte[4];
    private byte[] n = new byte[8];

    public static class a implements g {
        protected boolean a;
        protected boolean b;
        protected int c;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.a = false;
            this.b = true;
            this.a = z;
            this.b = z2;
            this.c = i;
        }

        public e a(d dVar) {
            e aVar = new a(dVar, this.a, this.b);
            if (this.c != 0) {
                aVar.c(this.c);
            }
            return aVar;
        }
    }

    public a(d dVar, boolean z, boolean z2) {
        super(dVar);
        this.a = z;
        this.b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        d(i2);
        return this.e.d(bArr, i, i2);
    }

    public void a() {
    }

    public void a(byte b) {
        this.g[0] = b;
        this.e.b(this.g, 0, 1);
    }

    public void a(double d) {
        a(Double.doubleToLongBits(d));
    }

    public void a(int i) {
        this.i[0] = (byte) ((i >> 24) & 255);
        this.i[1] = (byte) ((i >> 16) & 255);
        this.i[2] = (byte) ((i >> 8) & 255);
        this.i[3] = (byte) (i & 255);
        this.e.b(this.i, 0, 4);
    }

    public void a(long j) {
        this.j[0] = (byte) ((int) (255 & (j >> 56)));
        this.j[1] = (byte) ((int) (255 & (j >> 48)));
        this.j[2] = (byte) ((int) (255 & (j >> 40)));
        this.j[3] = (byte) ((int) (255 & (j >> 32)));
        this.j[4] = (byte) ((int) (255 & (j >> 24)));
        this.j[5] = (byte) ((int) (255 & (j >> 16)));
        this.j[6] = (byte) ((int) (255 & (j >> 8)));
        this.j[7] = (byte) ((int) (255 & j));
        this.e.b(this.j, 0, 8);
    }

    public void a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r4 = r4.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r0 = r4.length;	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r3.a(r0);	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r0 = r3.e;	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r1 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r2 = r4.length;	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r0.b(r4, r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        return;
    L_0x0012:
        r4 = new org.apache.thrift.f;
        r0 = "JVM DOES NOT SUPPORT UTF-8";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.thrift.protocol.a.a(java.lang.String):void");
    }

    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        a(limit);
        this.e.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    public void a(b bVar) {
        a(bVar.b);
        a(bVar.c);
    }

    public void a(c cVar) {
        a(cVar.a);
        a(cVar.b);
    }

    public void a(d dVar) {
        a(dVar.a);
        a(dVar.b);
        a(dVar.c);
    }

    public void a(i iVar) {
        a(iVar.a);
        a(iVar.b);
    }

    public void a(j jVar) {
    }

    public void a(short s) {
        this.h[0] = (byte) ((s >> 8) & 255);
        this.h[1] = (byte) (s & 255);
        this.e.b(this.h, 0, 2);
    }

    public void a(boolean z) {
        a((byte) z);
    }

    public java.lang.String b(int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.d(r4);	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r0 = new byte[r4];	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r1 = r3.e;	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r2 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r1.d(r0, r2, r4);	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r4 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r4.<init>(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        return r4;
    L_0x0013:
        r4 = new org.apache.thrift.f;
        r0 = "JVM DOES NOT SUPPORT UTF-8";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.thrift.protocol.a.b(int):java.lang.String");
    }

    public void b() {
    }

    public void c() {
        a((byte) 0);
    }

    public void c(int i) {
        this.c = i;
        this.d = true;
    }

    public void d() {
    }

    protected void d(int i) {
        StringBuilder stringBuilder;
        if (i < 0) {
            stringBuilder = new StringBuilder("Negative length: ");
            stringBuilder.append(i);
            throw new f(stringBuilder.toString());
        } else if (this.d) {
            this.c -= i;
            if (this.c < 0) {
                stringBuilder = new StringBuilder("Message length exceeded: ");
                stringBuilder.append(i);
                throw new f(stringBuilder.toString());
            }
        }
    }

    public void e() {
    }

    public void f() {
    }

    public j g() {
        return f;
    }

    public void h() {
    }

    public b i() {
        byte r = r();
        return new b("", r, r == (byte) 0 ? (short) 0 : s());
    }

    public void j() {
    }

    public d k() {
        return new d(r(), r(), t());
    }

    public void l() {
    }

    public c m() {
        return new c(r(), t());
    }

    public void n() {
    }

    public i o() {
        return new i(r(), t());
    }

    public void p() {
    }

    public boolean q() {
        return r() == (byte) 1;
    }

    public byte r() {
        if (this.e.c() > 0) {
            byte b = this.e.a()[this.e.b()];
            this.e.a(1);
            return b;
        }
        a(this.k, 0, 1);
        return this.k[0];
    }

    public short s() {
        byte[] bArr = this.l;
        int i = 0;
        if (this.e.c() >= 2) {
            bArr = this.e.a();
            i = this.e.b();
            this.e.a(2);
        } else {
            a(this.l, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public int t() {
        byte[] bArr = this.m;
        int i = 0;
        if (this.e.c() >= 4) {
            bArr = this.e.a();
            i = this.e.b();
            this.e.a(4);
        } else {
            a(this.m, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8));
    }

    public long u() {
        byte[] bArr = this.n;
        int i = 0;
        if (this.e.c() >= 8) {
            bArr = this.e.a();
            i = this.e.b();
            this.e.a(8);
        } else {
            a(this.n, 0, 8);
        }
        return (((((((((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48)) | (((long) (bArr[i + 2] & 255)) << 40)) | (((long) (bArr[i + 3] & 255)) << 32)) | (((long) (bArr[i + 4] & 255)) << 24)) | (((long) (bArr[i + 5] & 255)) << 16)) | (((long) (bArr[i + 6] & 255)) << 8)) | ((long) (bArr[i + 7] & 255));
    }

    public double v() {
        return Double.longBitsToDouble(u());
    }

    public java.lang.String w() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.t();
        r1 = r5.e;
        r1 = r1.c();
        if (r1 < r0) goto L_0x002d;
    L_0x000c:
        r1 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0025 }
        r2 = r5.e;	 Catch:{ UnsupportedEncodingException -> 0x0025 }
        r2 = r2.a();	 Catch:{ UnsupportedEncodingException -> 0x0025 }
        r3 = r5.e;	 Catch:{ UnsupportedEncodingException -> 0x0025 }
        r3 = r3.b();	 Catch:{ UnsupportedEncodingException -> 0x0025 }
        r4 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0025 }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ UnsupportedEncodingException -> 0x0025 }
        r2 = r5.e;	 Catch:{ UnsupportedEncodingException -> 0x0025 }
        r2.a(r0);	 Catch:{ UnsupportedEncodingException -> 0x0025 }
        return r1;
    L_0x0025:
        r0 = new org.apache.thrift.f;
        r1 = "JVM DOES NOT SUPPORT UTF-8";
        r0.<init>(r1);
        throw r0;
    L_0x002d:
        r0 = r5.b(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.thrift.protocol.a.w():java.lang.String");
    }

    public ByteBuffer x() {
        int t = t();
        d(t);
        if (this.e.c() >= t) {
            ByteBuffer wrap = ByteBuffer.wrap(this.e.a(), this.e.b(), t);
            this.e.a(t);
            return wrap;
        }
        byte[] bArr = new byte[t];
        this.e.d(bArr, 0, t);
        return ByteBuffer.wrap(bArr);
    }
}
