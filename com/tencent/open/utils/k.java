package com.tencent.open.utils;

/* compiled from: ProGuard */
public final class k implements Cloneable {
    private int a;

    public k(byte[] bArr) {
        this(bArr, 0);
    }

    public k(byte[] bArr, int i) {
        this.a = (bArr[i + 1] << 8) & 65280;
        this.a += bArr[i] & 255;
    }

    public k(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof k) {
                if (this.a == ((k) obj).b()) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final byte[] a() {
        return new byte[]{(byte) (this.a & 255), (byte) ((this.a & 65280) >> 8)};
    }

    public final int b() {
        return this.a;
    }

    public final int hashCode() {
        return this.a;
    }
}
