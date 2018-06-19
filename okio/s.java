package okio;

import javax.annotation.Nullable;

/* compiled from: Segment */
final class s {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    s f;
    s g;

    s() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    s(s sVar) {
        this(sVar.a, sVar.b, sVar.c);
        sVar.d = true;
    }

    s(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = null;
        this.d = 1;
    }

    @Nullable
    public final s a() {
        s sVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return sVar;
    }

    public final s a(s sVar) {
        sVar.g = this;
        sVar.f = this.f;
        this.f.g = sVar;
        this.f = sVar;
        return sVar;
    }

    public final void a(s sVar, int i) {
        if (sVar.e) {
            if (sVar.c + i > 8192) {
                if (sVar.d) {
                    throw new IllegalArgumentException();
                } else if ((sVar.c + i) - sVar.b > 8192) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(sVar.a, sVar.b, sVar.a, 0, sVar.c - sVar.b);
                    sVar.c -= sVar.b;
                    sVar.b = 0;
                }
            }
            System.arraycopy(this.a, this.b, sVar.a, sVar.c, i);
            sVar.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
