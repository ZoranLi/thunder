package com.tencent.open.utils;

/* compiled from: ProGuard */
public final class j implements Cloneable {
    private long a;

    public j(long j) {
        this.a = j;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof j) {
                if (this.a == ((j) obj).b()) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final byte[] a() {
        return new byte[]{(byte) ((int) (this.a & 255)), (byte) ((int) ((this.a & 65280) >> 8)), (byte) ((int) ((this.a & 16711680) >> 16)), (byte) ((int) ((this.a & 4278190080L) >> 24))};
    }

    public final long b() {
        return this.a;
    }

    public final int hashCode() {
        return (int) this.a;
    }
}
