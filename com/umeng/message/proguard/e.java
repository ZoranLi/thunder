package com.umeng.message.proguard;

/* compiled from: BaseNCodec */
public abstract class e {
    private static final int a = 2;
    public static final int b = 76;
    public static final int c = 64;
    protected static final int d = 255;
    protected static final byte e = (byte) 61;
    private static final int m = 8192;
    protected final byte f = e;
    protected final int g;
    protected byte[] h;
    protected int i;
    protected boolean j;
    protected int k;
    protected int l;
    private final int n;
    private final int o;
    private final int p;
    private int q;

    protected static boolean c(byte b) {
        if (!(b == (byte) 13 || b == (byte) 32)) {
            switch (b) {
                case (byte) 9:
                case (byte) 10:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    abstract void a(byte[] bArr, int i, int i2);

    abstract void b(byte[] bArr, int i, int i2);

    protected abstract boolean b(byte b);

    protected int d() {
        return 8192;
    }

    protected e(int i, int i2, int i3, int i4) {
        this.n = i;
        this.o = i2;
        i3 = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.g = i3;
        this.p = i4;
    }

    boolean b() {
        return this.h != null;
    }

    int c() {
        return this.h != null ? this.i - this.q : 0;
    }

    private void a() {
        if (this.h == null) {
            this.h = new byte[d()];
            this.i = 0;
            this.q = 0;
            return;
        }
        Object obj = new byte[(this.h.length * 2)];
        System.arraycopy(this.h, 0, obj, 0, this.h.length);
        this.h = obj;
    }

    protected void a(int i) {
        if (this.h == null || this.h.length < this.i + i) {
            a();
        }
    }

    int c(byte[] bArr, int i, int i2) {
        if (this.h == null) {
            return this.j != null ? -1 : null;
        } else {
            i2 = Math.min(c(), i2);
            System.arraycopy(this.h, this.q, bArr, i, i2);
            this.q += i2;
            if (this.q >= this.i) {
                this.h = null;
            }
            return i2;
        }
    }

    private void e() {
        this.h = null;
        this.i = 0;
        this.q = 0;
        this.k = 0;
        this.l = 0;
        this.j = false;
    }

    public Object a(Object obj) throws Exception {
        if (obj instanceof byte[]) {
            return l((byte[]) obj);
        }
        throw new Exception("Parameter supplied to Base-N encode is not a byte[]");
    }

    public String j(byte[] bArr) {
        return b.f(l(bArr));
    }

    public Object b(Object obj) throws Exception {
        if (obj instanceof byte[]) {
            return k((byte[]) obj);
        }
        if (obj instanceof String) {
            return c((String) obj);
        }
        throw new Exception("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public byte[] c(String str) {
        return k(b.f(str));
    }

    public byte[] k(byte[] bArr) {
        e();
        if (bArr != null) {
            if (bArr.length != 0) {
                b(bArr, 0, bArr.length);
                b(bArr, 0, -1);
                bArr = new byte[this.i];
                c(bArr, 0, bArr.length);
                return bArr;
            }
        }
        return bArr;
    }

    public byte[] l(byte[] bArr) {
        e();
        if (bArr != null) {
            if (bArr.length != 0) {
                a(bArr, 0, bArr.length);
                a(bArr, 0, -1);
                bArr = new byte[(this.i - this.q)];
                c(bArr, 0, bArr.length);
                return bArr;
            }
        }
        return bArr;
    }

    public String m(byte[] bArr) {
        return b.f(l(bArr));
    }

    public boolean b(byte[] bArr, boolean z) {
        int i = 0;
        while (i < bArr.length) {
            if (!b(bArr[i]) && (!z || (bArr[i] != e && !c(bArr[i])))) {
                return false;
            }
            i++;
        }
        return 1;
    }

    public boolean d(String str) {
        return b(b.f(str), true);
    }

    protected boolean n(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        int i = 0;
        while (i < bArr.length) {
            if (e != bArr[i]) {
                if (!b(bArr[i])) {
                    i++;
                }
            }
            return 1;
        }
        return false;
    }

    public long o(byte[] bArr) {
        long length = ((long) (((bArr.length + this.n) - 1) / this.n)) * ((long) this.o);
        return this.g > null ? length + ((((length + ((long) this.g)) - 1) / ((long) this.g)) * ((long) this.p)) : length;
    }
}
