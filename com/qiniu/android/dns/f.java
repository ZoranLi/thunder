package com.qiniu.android.dns;

/* compiled from: Record */
public final class f {
    public final String a;
    public final int b;
    public final int c;
    public final long d;

    public f(String str, int i, int i2, long j) {
        this.a = str;
        this.b = i;
        str = 600;
        if (i2 >= 600) {
            str = i2;
        }
        this.c = str;
        this.d = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                return this.a.equals(fVar.a) && this.b == fVar.b && this.c == fVar.c && this.d == fVar.d;
            }
        }
        return false;
    }

    public final boolean a() {
        return this.b == 5;
    }
}
