package com.alibaba.fastjson.b;

import com.tencent.tinker.android.dx.instruction.Opcodes;

/* compiled from: MethodWriter */
public final class g implements f {
    g a;
    final b b;
    int c;
    final int d;
    final int e;
    int f;
    int[] g;
    a h = new a();
    int i;
    int j;

    public g(b bVar, String str, String str2, String[] strArr) {
        if (bVar.l == null) {
            bVar.l = this;
        } else {
            bVar.m.a = this;
        }
        bVar.m = this;
        this.b = bVar;
        this.c = 1;
        this.d = bVar.a(str);
        this.e = bVar.a(str2);
        if (strArr != null && strArr.length > null) {
            this.f = strArr.length;
            this.g = new int[this.f];
            for (str = null; str < this.f; str++) {
                this.g[str] = bVar.b(strArr[str]).a;
            }
        }
    }

    public final void a(int i) {
        this.h.a(i);
    }

    public final void a(int i, int i2) {
        this.h.a(i, i2);
    }

    public final void b(int i, int i2) {
        if (i2 < 4 && i != Opcodes.DIV_FLOAT) {
            this.h.a(i < 54 ? (26 + ((i - 21) << 2)) + i2 : (59 + ((i - 54) << 2)) + i2);
        } else if (i2 >= 256) {
            this.h.a(196).b(i, i2);
        } else {
            this.h.a(i, i2);
        }
    }

    public final void a(int i, String str) {
        this.h.b(i, this.b.b(str).a);
    }

    public final void a(int i, String str, String str2, String str3) {
        b bVar = this.b;
        bVar.h.a(9, str, str2, str3);
        d a = bVar.a(bVar.h);
        if (a == null) {
            str = bVar.b(str).a;
            bVar.c.b(9, str).b(bVar.a(str2, str3).a);
            str = bVar.b;
            bVar.b = str + 1;
            a = new d(str, bVar.h);
            bVar.b(a);
        }
        this.h.b(i, a.a);
    }

    public final void b(int i, String str, String str2, String str3) {
        int i2 = i == Opcodes.SHR_INT_2ADDR ? 1 : 0;
        b bVar = this.b;
        int i3 = i2 != 0 ? 11 : 10;
        bVar.h.a(i3, str, str2, str3);
        d a = bVar.a(bVar.h);
        if (a == null) {
            bVar.c.b(i3, bVar.b(str).a).b(bVar.a(str2, str3).a);
            str = bVar.b;
            bVar.b = str + 1;
            a = new d(str, bVar.h);
            bVar.b(a);
        }
        str = a.c;
        if (i2 != 0) {
            if (str == null) {
                str = h.b(str3);
                a.c = str;
            }
            this.h.b(Opcodes.SHR_INT_2ADDR, a.a).a(str >> 2, 0);
            return;
        }
        this.h.b(i, a.a);
    }

    public final void a(int i, e eVar) {
        if ((eVar.a & 2) == 0 || eVar.b - this.h.b >= -32768) {
            this.h.a(i);
            i = this.h;
            int i2 = this.h.b - 1;
            if ((eVar.a & 2) == 0) {
                int i3 = i.b;
                if (eVar.d == null) {
                    eVar.d = new int[6];
                }
                if (eVar.c >= eVar.d.length) {
                    Object obj = new int[(eVar.d.length + 6)];
                    System.arraycopy(eVar.d, 0, obj, 0, eVar.d.length);
                    eVar.d = obj;
                }
                int[] iArr = eVar.d;
                int i4 = eVar.c;
                eVar.c = i4 + 1;
                iArr[i4] = i2;
                int[] iArr2 = eVar.d;
                int i5 = eVar.c;
                eVar.c = i5 + 1;
                iArr2[i5] = i3;
                i.b(-1);
                return;
            }
            i.b(eVar.b - i2);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void a(e eVar) {
        int i = this.h.b;
        byte[] bArr = this.h.a;
        eVar.a |= 2;
        eVar.b = i;
        int i2 = 0;
        while (i2 < eVar.c) {
            int i3 = i2 + 1;
            i2 = eVar.d[i2];
            int i4 = i3 + 1;
            int i5 = eVar.d[i3];
            i2 = i - i2;
            i3 = i5 + 1;
            bArr[i5] = (byte) (i2 >>> 8);
            bArr[i3] = (byte) i2;
            i2 = i4;
        }
    }

    public final void a(Object obj) {
        obj = this.b.a(obj);
        int i = obj.a;
        if (obj.b != 5) {
            if (obj.b != 6) {
                if (i >= 256) {
                    this.h.b(19, i);
                    return;
                } else {
                    this.h.a(18, i);
                    return;
                }
            }
        }
        this.h.b(20, i);
    }

    public final void b(int i) {
        this.h.a(Opcodes.LONG_TO_INT).a(i, 1);
    }

    public final void c(int i, int i2) {
        this.i = i;
        this.j = i2;
    }
}
