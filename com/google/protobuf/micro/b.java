package com.google.protobuf.micro;

import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.io.InputStream;
import java.util.Vector;

public final class b {
    private final byte[] a;
    private int b;
    private int c;
    private int d;
    private final InputStream e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private b(InputStream inputStream) {
        this.h = Integer.MAX_VALUE;
        this.j = 64;
        this.k = 67108864;
        this.a = new byte[4096];
        this.b = 0;
        this.d = 0;
        this.e = inputStream;
    }

    private b(byte[] bArr, int i, int i2) {
        this.h = Integer.MAX_VALUE;
        this.j = 64;
        this.k = 67108864;
        this.a = bArr;
        this.b = i2 + i;
        this.d = i;
        this.e = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    private boolean a(boolean z) {
        if (this.d < this.b) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.g + this.b != this.h) {
            this.g += this.b;
            this.d = 0;
            this.b = this.e == null ? -1 : this.e.read(this.a);
            if (this.b != 0) {
                if (this.b >= -1) {
                    if (this.b == -1) {
                        this.b = 0;
                        if (!z) {
                            return false;
                        }
                        throw d.a();
                    }
                    p();
                    int i = (this.g + this.b) + this.c;
                    if (i <= this.k) {
                        if (i >= 0) {
                            return true;
                        }
                    }
                    throw d.h();
                }
            }
            StringBuilder stringBuilder = new StringBuilder("InputStream#read(byte[]) returned invalid result: ");
            stringBuilder.append(this.b);
            stringBuilder.append("\nThe InputStream implementation is buggy.");
            throw new IllegalStateException(stringBuilder.toString());
        } else if (!z) {
            return false;
        } else {
            throw d.a();
        }
    }

    private void p() {
        this.b += this.c;
        int i = this.g + this.b;
        if (i > this.h) {
            this.c = i - this.h;
            this.b -= this.c;
            return;
        }
        this.c = 0;
    }

    public final int a() {
        if (n()) {
            this.f = 0;
            return 0;
        }
        this.f = j();
        if (this.f != 0) {
            return this.f;
        }
        throw d.d();
    }

    public final void a(int i) {
        if (this.f != i) {
            throw d.e();
        }
    }

    public final void a(e eVar) {
        int j = j();
        if (this.i >= this.j) {
            throw d.g();
        }
        j = c(j);
        this.i++;
        eVar.a(this);
        a(0);
        this.i--;
        d(j);
    }

    public final void b() {
        int a;
        do {
            a = a();
            if (a == 0) {
                return;
            }
        } while (b(a));
    }

    public final boolean b(int i) {
        switch (f.a(i)) {
            case 0:
                e();
                return true;
            case 1:
                m();
                return true;
            case 2:
                f(j());
                return true;
            case 3:
                b();
                a(f.a(f.b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                l();
                return true;
            default:
                throw d.f();
        }
    }

    public final int c(int i) {
        if (i < 0) {
            throw d.b();
        }
        i += this.g + this.d;
        int i2 = this.h;
        if (i > i2) {
            throw d.a();
        }
        this.h = i;
        p();
        return i2;
    }

    public final long c() {
        return k();
    }

    public final long d() {
        return k();
    }

    public final void d(int i) {
        this.h = i;
        p();
    }

    public final int e() {
        return j();
    }

    public final byte[] e(int i) {
        if (i < 0) {
            throw d.b();
        } else if ((this.g + this.d) + i > this.h) {
            f((this.h - this.g) - this.d);
            throw d.a();
        } else if (i <= this.b - this.d) {
            r0 = new byte[i];
            System.arraycopy(this.a, this.d, r0, 0, i);
            this.d += i;
            return r0;
        } else if (i < 4096) {
            r0 = new byte[i];
            r2 = this.b - this.d;
            System.arraycopy(this.a, this.d, r0, 0, r2);
            this.d = this.b;
            while (true) {
                a(true);
                r4 = i - r2;
                if (r4 > this.b) {
                    System.arraycopy(this.a, 0, r0, r2, this.b);
                    r2 += this.b;
                    this.d = this.b;
                } else {
                    System.arraycopy(this.a, 0, r0, r2, r4);
                    this.d = r4;
                    return r0;
                }
            }
        } else {
            r2 = this.d;
            int i2 = this.b;
            this.g += this.b;
            this.d = 0;
            this.b = 0;
            i2 -= r2;
            r4 = i - i2;
            Vector vector = new Vector();
            while (r4 > 0) {
                Object obj = new byte[Math.min(r4, 4096)];
                int i3 = 0;
                while (i3 < obj.length) {
                    int read = this.e == null ? -1 : this.e.read(obj, i3, obj.length - i3);
                    if (read == -1) {
                        throw d.a();
                    }
                    this.g += read;
                    i3 += read;
                }
                r4 -= obj.length;
                vector.addElement(obj);
            }
            Object obj2 = new byte[i];
            System.arraycopy(this.a, r2, obj2, 0, i2);
            for (int i4 = 0; i4 < vector.size(); i4++) {
                byte[] bArr = (byte[]) vector.elementAt(i4);
                System.arraycopy(bArr, 0, obj2, i2, bArr.length);
                i2 += bArr.length;
            }
            return obj2;
        }
    }

    public final void f(int i) {
        if (i < 0) {
            throw d.b();
        } else if ((this.g + this.d) + i > this.h) {
            f((this.h - this.g) - this.d);
            throw d.a();
        } else if (i <= this.b - this.d) {
            this.d += i;
        } else {
            int i2 = this.b - this.d;
            this.g += this.b;
            this.d = 0;
            this.b = 0;
            while (i2 < i) {
                int skip = this.e == null ? -1 : (int) this.e.skip((long) (i - i2));
                if (skip <= 0) {
                    throw d.a();
                }
                i2 += skip;
                this.g += skip;
            }
        }
    }

    public final boolean f() {
        return j() != 0;
    }

    public final String g() {
        int j = j();
        if (j > this.b - this.d || j <= 0) {
            return new String(e(j), "UTF-8");
        }
        String str = new String(this.a, this.d, j, "UTF-8");
        this.d += j;
        return str;
    }

    public final a h() {
        int j = j();
        if (j > this.b - this.d || j <= 0) {
            return a.a(e(j));
        }
        a a = a.a(this.a, this.d, j);
        this.d += j;
        return a;
    }

    public final int i() {
        return j();
    }

    public final int j() {
        byte o = o();
        if (o >= (byte) 0) {
            return o;
        }
        int i;
        int i2 = o & Opcodes.NEG_FLOAT;
        byte o2 = o();
        if (o2 >= (byte) 0) {
            i = o2 << 7;
        } else {
            i2 |= (o2 & Opcodes.NEG_FLOAT) << 7;
            o2 = o();
            if (o2 >= (byte) 0) {
                i = o2 << 14;
            } else {
                i2 |= (o2 & Opcodes.NEG_FLOAT) << 14;
                o2 = o();
                if (o2 >= (byte) 0) {
                    i = o2 << 21;
                } else {
                    i2 |= (o2 & Opcodes.NEG_FLOAT) << 21;
                    o2 = o();
                    i2 |= o2 << 28;
                    if (o2 >= (byte) 0) {
                        return i2;
                    }
                    for (i = 0; i < 5; i++) {
                        if (o() >= (byte) 0) {
                            return i2;
                        }
                    }
                    throw d.c();
                }
            }
        }
        return i2 | i;
    }

    public final long k() {
        int i = 0;
        long j = 0;
        while (i < 64) {
            byte o = o();
            long j2 = j | (((long) (o & Opcodes.NEG_FLOAT)) << i);
            if ((o & 128) == 0) {
                return j2;
            }
            i += 7;
            j = j2;
        }
        throw d.c();
    }

    public final int l() {
        return (((o() & 255) | ((o() & 255) << 8)) | ((o() & 255) << 16)) | ((o() & 255) << 24);
    }

    public final long m() {
        return (((((((((long) o()) & 255) | ((((long) o()) & 255) << 8)) | ((((long) o()) & 255) << 16)) | ((((long) o()) & 255) << 24)) | ((((long) o()) & 255) << 32)) | ((((long) o()) & 255) << 40)) | ((((long) o()) & 255) << 48)) | ((((long) o()) & 255) << 56);
    }

    public final boolean n() {
        return this.d == this.b && !a(false);
    }

    public final byte o() {
        if (this.d == this.b) {
            a(true);
        }
        byte[] bArr = this.a;
        int i = this.d;
        this.d = i + 1;
        return bArr[i];
    }
}
