package com.google.protobuf.micro;

import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.io.IOException;
import java.io.OutputStream;

public final class c {
    private final byte[] a;
    private final int b;
    private int c;
    private final OutputStream d;

    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.d = outputStream;
        this.a = bArr;
        this.c = 0;
        this.b = bArr.length;
    }

    private c(byte[] bArr, int i, int i2) {
        this.d = null;
        this.a = bArr;
        this.c = i;
        this.b = i + i2;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    public static int b(int i, a aVar) {
        return f(i) + b(aVar);
    }

    public static int b(int i, e eVar) {
        return f(i) + b(eVar);
    }

    public static int b(int i, String str) {
        return f(i) + b(str);
    }

    public static int b(int i, boolean z) {
        return f(i) + b(z);
    }

    public static int b(a aVar) {
        return h(aVar.a()) + aVar.a();
    }

    public static int b(e eVar) {
        int b = eVar.b();
        return h(b) + b;
    }

    public static int b(java.lang.String r1) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r1 = r1.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r0 = r1.length;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r0 = h(r0);	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r1 = r1.length;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r0 = r0 + r1;
        return r0;
    L_0x000e:
        r1 = new java.lang.RuntimeException;
        r0 = "UTF-8 not supported.";
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.micro.c.b(java.lang.String):int");
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int c(int i) {
        return i >= 0 ? h(i) : 10;
    }

    public static int c(int i, int i2) {
        return f(i) + c(i2);
    }

    public static int c(int i, long j) {
        return f(i) + c(j);
    }

    public static int c(long j) {
        return f(j);
    }

    public static int d(int i) {
        return h(i);
    }

    public static int d(int i, int i2) {
        return f(i) + d(i2);
    }

    public static int d(int i, long j) {
        return f(i) + d(j);
    }

    public static int d(long j) {
        return f(j);
    }

    private void d() {
        if (this.d == null) {
            throw new a();
        }
        this.d.write(this.a, 0, this.c);
        this.c = 0;
    }

    public static int f(int i) {
        return h(f.a(i, 0));
    }

    public static int f(long j) {
        return (j & -128) == 0 ? 1 : (j & -16384) == 0 ? 2 : (j & -2097152) == 0 ? 3 : (j & -268435456) == 0 ? 4 : (j & -34359738368L) == 0 ? 5 : (j & -4398046511104L) == 0 ? 6 : (j & -562949953421312L) == 0 ? 7 : (j & -72057594037927936L) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int h(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5;
    }

    public final void a() {
        if (this.d != null) {
            d();
        }
    }

    public final void a(byte b) {
        if (this.c == this.b) {
            d();
        }
        byte[] bArr = this.a;
        int i = this.c;
        this.c = i + 1;
        bArr[i] = b;
    }

    public final void a(int i) {
        if (i >= 0) {
            g(i);
        } else {
            e((long) i);
        }
    }

    public final void a(int i, int i2) {
        e(i, 0);
        a(i2);
    }

    public final void a(int i, long j) {
        e(i, 0);
        a(j);
    }

    public final void a(int i, a aVar) {
        e(i, 2);
        a(aVar);
    }

    public final void a(int i, e eVar) {
        e(i, 2);
        a(eVar);
    }

    public final void a(int i, String str) {
        e(i, 2);
        a(str);
    }

    public final void a(int i, boolean z) {
        e(i, 0);
        a(z);
    }

    public final void a(long j) {
        e(j);
    }

    public final void a(a aVar) {
        byte[] b = aVar.b();
        g(b.length);
        a(b);
    }

    public final void a(e eVar) {
        g(eVar.a());
        eVar.a(this);
    }

    public final void a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        g(bytes.length);
        a(bytes);
    }

    public final void a(boolean z) {
        e((int) z);
    }

    public final void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public final int b() {
        if (this.d == null) {
            return this.b - this.c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public final void b(int i) {
        g(i);
    }

    public final void b(int i, int i2) {
        e(i, 0);
        b(i2);
    }

    public final void b(int i, long j) {
        e(i, 0);
        b(j);
    }

    public final void b(long j) {
        e(j);
    }

    public final void b(byte[] bArr, int i, int i2) {
        if (this.b - this.c >= i2) {
            System.arraycopy(bArr, i, this.a, this.c, i2);
            this.c += i2;
            return;
        }
        int i3 = this.b - this.c;
        System.arraycopy(bArr, i, this.a, this.c, i3);
        i += i3;
        i2 -= i3;
        this.c = this.b;
        d();
        if (i2 <= this.b) {
            System.arraycopy(bArr, i, this.a, 0, i2);
            this.c = i2;
            return;
        }
        this.d.write(bArr, i, i2);
    }

    public final void c() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void e(int i) {
        a((byte) i);
    }

    public final void e(int i, int i2) {
        g(f.a(i, i2));
    }

    public final void e(long j) {
        while ((j & -128) != 0) {
            e((((int) j) & Opcodes.NEG_FLOAT) | 128);
            j >>>= 7;
        }
        e((int) j);
    }

    public final void g(int i) {
        while ((i & -128) != 0) {
            e((i & Opcodes.NEG_FLOAT) | 128);
            i >>>= 7;
        }
        e(i);
    }
}
