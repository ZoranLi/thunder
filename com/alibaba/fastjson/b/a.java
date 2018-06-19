package com.alibaba.fastjson.b;

/* compiled from: ByteVector */
public final class a {
    byte[] a;
    int b;

    public a() {
        this.a = new byte[64];
    }

    public a(int i) {
        this.a = new byte[i];
    }

    public final a a(int i) {
        int i2 = this.b;
        int i3 = i2 + 1;
        if (i3 > this.a.length) {
            d(1);
        }
        this.a[i2] = (byte) i;
        this.b = i3;
        return this;
    }

    final a a(int i, int i2) {
        int i3 = this.b;
        if (i3 + 2 > this.a.length) {
            d(2);
        }
        byte[] bArr = this.a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        i = i4 + 1;
        bArr[i4] = (byte) i2;
        this.b = i;
        return this;
    }

    public final a b(int i) {
        int i2 = this.b;
        if (i2 + 2 > this.a.length) {
            d(2);
        }
        byte[] bArr = this.a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        i2 = i3 + 1;
        bArr[i3] = (byte) i;
        this.b = i2;
        return this;
    }

    final a b(int i, int i2) {
        int i3 = this.b;
        if (i3 + 3 > this.a.length) {
            d(3);
        }
        byte[] bArr = this.a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        i = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        i3 = i + 1;
        bArr[i] = (byte) i2;
        this.b = i3;
        return this;
    }

    public final a c(int i) {
        int i2 = this.b;
        if (i2 + 4 > this.a.length) {
            d(4);
        }
        byte[] bArr = this.a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        i2 = i3 + 1;
        bArr[i3] = (byte) i;
        this.b = i2;
        return this;
    }

    public final a a(byte[] bArr, int i) {
        if (this.b + i > this.a.length) {
            d(i);
        }
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.a, this.b, i);
        }
        this.b += i;
        return this;
    }

    final void d(int i) {
        int length = 2 * this.a.length;
        i += this.b;
        if (length > i) {
            i = length;
        }
        i = new byte[i];
        System.arraycopy(this.a, 0, i, 0, this.b);
        this.a = i;
    }
}
