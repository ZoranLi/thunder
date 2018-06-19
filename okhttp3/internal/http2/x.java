package okhttp3.internal.http2;

/* compiled from: Settings */
public final class x {
    int a;
    final int[] b = new int[10];

    final x a(int i, int i2) {
        if (i >= this.b.length) {
            return this;
        }
        this.a = (1 << i) | this.a;
        this.b[i] = i2;
        return this;
    }

    final boolean a(int i) {
        return ((1 << i) & this.a) != 0;
    }

    final int a() {
        return (this.a & 2) != 0 ? this.b[1] : -1;
    }

    public final int b() {
        return (this.a & 128) != 0 ? this.b[7] : 65535;
    }
}
