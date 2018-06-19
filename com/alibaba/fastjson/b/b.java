package com.alibaba.fastjson.b;

import com.tencent.tinker.android.dex.DebugInfoItem;

/* compiled from: ClassWriter */
public final class b {
    int a;
    int b;
    final a c;
    d[] d;
    int e;
    final d f;
    final d g;
    final d h;
    String i;
    c j;
    c k;
    g l;
    g m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int[] r;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.b = (byte) 1;
        this.c = new a();
        this.d = new d[DebugInfoItem.DBG_END_SEQUENCE];
        this.e = (int) (0.75d * ((double) this.d.length));
        this.f = new d();
        this.g = new d();
        this.h = new d();
    }

    public final void a(String str, String str2, String[] strArr) {
        this.a = 49;
        this.n = 33;
        this.o = b(str).a;
        this.i = str;
        str = null;
        if (str2 == null) {
            str2 = null;
        } else {
            str2 = b(str2).a;
        }
        this.p = str2;
        if (strArr != null && strArr.length > null) {
            this.q = strArr.length;
            this.r = new int[this.q];
            while (str < this.q) {
                this.r[str] = b(strArr[str]).a;
                str++;
            }
        }
    }

    public final byte[] a() {
        int i = 24 + (this.q * 2);
        int i2 = i;
        i = 0;
        for (c cVar = this.j; cVar != null; cVar = cVar.a) {
            i++;
            i2 += 8;
        }
        int i3 = i2;
        i2 = 0;
        for (g gVar = this.l; gVar != null; gVar = gVar.a) {
            int i4;
            i2++;
            if (gVar.h.b > 0) {
                gVar.b.a("Code");
                i4 = ((18 + gVar.h.b) + 0) + 8;
            } else {
                i4 = 8;
            }
            if (gVar.f > 0) {
                gVar.b.a("Exceptions");
                i4 += 8 + (gVar.f * 2);
            }
            i3 += i4;
        }
        a aVar = new a(i3 + this.c.b);
        aVar.c(-889275714).c(this.a);
        aVar.b(this.b).a(this.c.a, this.c.b);
        aVar.b(this.n & -393217).b(this.o).b(this.p);
        aVar.b(this.q);
        for (i3 = 0; i3 < this.q; i3++) {
            aVar.b(this.r[i3]);
        }
        aVar.b(i);
        for (c cVar2 = this.j; cVar2 != null; cVar2 = cVar2.a) {
            aVar.b(cVar2.b & -393217).b(cVar2.c).b(cVar2.d);
            aVar.b(0);
        }
        aVar.b(i2);
        for (g gVar2 = this.l; gVar2 != null; gVar2 = gVar2.a) {
            aVar.b(gVar2.c & -393217).b(gVar2.d).b(gVar2.e);
            i2 = gVar2.h.b > 0 ? 1 : 0;
            if (gVar2.f > 0) {
                i2++;
            }
            aVar.b(i2);
            if (gVar2.h.b > 0) {
                aVar.b(gVar2.b.a("Code")).c((12 + gVar2.h.b) + 0);
                aVar.b(gVar2.i).b(gVar2.j);
                aVar.c(gVar2.h.b).a(gVar2.h.a, gVar2.h.b);
                aVar.b(0);
                aVar.b(0);
            }
            if (gVar2.f > 0) {
                aVar.b(gVar2.b.a("Exceptions")).c((gVar2.f * 2) + 2);
                aVar.b(gVar2.f);
                for (i2 = 0; i2 < gVar2.f; i2++) {
                    aVar.b(gVar2.g[i2]);
                }
            }
        }
        aVar.b(0);
        return aVar.a;
    }

    final d a(Object obj) {
        d dVar;
        if (obj instanceof Integer) {
            obj = ((Integer) obj).intValue();
            dVar = this.f;
            dVar.b = 3;
            dVar.c = obj;
            dVar.h = Integer.MAX_VALUE & (dVar.b + obj);
            dVar = a(this.f);
            if (dVar == null) {
                this.c.a(3).c(obj);
                obj = this.b;
                this.b = obj + 1;
                dVar = new d(obj, this.f);
                b(dVar);
            }
            return dVar;
        } else if (obj instanceof String) {
            String str = (String) obj;
            this.g.a(8, str, null, null);
            dVar = a(this.g);
            if (dVar == null) {
                this.c.b(8, a(str));
                obj = this.b;
                this.b = obj + 1;
                dVar = new d(obj, this.g);
                b(dVar);
            }
            return dVar;
        } else if (obj instanceof h) {
            String str2;
            h hVar = (h) obj;
            if (hVar.j == 10) {
                str2 = new String(hVar.k, hVar.l, hVar.m);
            } else {
                str2 = new String(hVar.k, hVar.l, hVar.m);
            }
            return b(str2);
        } else {
            StringBuilder stringBuilder = new StringBuilder("value ");
            stringBuilder.append(obj);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public final int a(String str) {
        this.f.a(1, str, null, null);
        d a = a(this.f);
        if (a == null) {
            a a2 = this.c.a(1);
            int length = str.length();
            int i = a2.b;
            if ((i + 2) + length > a2.a.length) {
                a2.d(2 + length);
            }
            byte[] bArr = a2.a;
            int i2 = i + 1;
            bArr[i] = (byte) (length >>> 8);
            i = i2 + 1;
            bArr[i2] = (byte) length;
            i2 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt <= '\u0000' || charAt > '') {
                    throw new UnsupportedOperationException();
                }
                int i3 = i + 1;
                bArr[i] = (byte) charAt;
                i2++;
                i = i3;
            }
            a2.b = i;
            str = this.b;
            this.b = str + 1;
            a = new d(str, this.f);
            b(a);
        }
        return a.a;
    }

    public final d b(String str) {
        this.g.a(7, str, null, null);
        d a = a(this.g);
        if (a != null) {
            return a;
        }
        this.c.b(7, a(str));
        str = this.b;
        this.b = str + 1;
        a = new d(str, this.g);
        b(a);
        return a;
    }

    public final d a(String str, String str2) {
        this.g.a(12, str, str2, null);
        d a = a(this.g);
        if (a != null) {
            return a;
        }
        str = a(str);
        this.c.b(12, str).b(a(str2));
        str = this.b;
        this.b = str + 1;
        a = new d(str, this.g);
        b(a);
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final com.alibaba.fastjson.b.d a(com.alibaba.fastjson.b.d r9) {
        /*
        r8 = this;
        r0 = r8.d;
        r1 = r9.h;
        r2 = r8.d;
        r2 = r2.length;
        r1 = r1 % r2;
        r0 = r0[r1];
    L_0x000a:
        if (r0 == 0) goto L_0x006b;
    L_0x000c:
        r1 = r0.b;
        r2 = r9.b;
        if (r1 != r2) goto L_0x0068;
    L_0x0012:
        r1 = r9.b;
        r2 = 0;
        r3 = 1;
        switch(r1) {
            case 1: goto L_0x005e;
            case 2: goto L_0x0019;
            case 3: goto L_0x0056;
            case 4: goto L_0x0056;
            case 5: goto L_0x004d;
            case 6: goto L_0x004d;
            case 7: goto L_0x005e;
            case 8: goto L_0x005e;
            case 9: goto L_0x0019;
            case 10: goto L_0x0019;
            case 11: goto L_0x0019;
            case 12: goto L_0x0038;
            case 13: goto L_0x005e;
            case 14: goto L_0x0019;
            case 15: goto L_0x004d;
            default: goto L_0x0019;
        };
    L_0x0019:
        r1 = r0.e;
        r4 = r9.e;
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0066;
    L_0x0023:
        r1 = r0.f;
        r4 = r9.f;
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0066;
    L_0x002d:
        r1 = r0.g;
        r4 = r9.g;
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0066;
    L_0x0037:
        goto L_0x005c;
    L_0x0038:
        r1 = r0.e;
        r4 = r9.e;
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0066;
    L_0x0042:
        r1 = r0.f;
        r4 = r9.f;
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0066;
    L_0x004c:
        goto L_0x005c;
    L_0x004d:
        r4 = r0.d;
        r6 = r9.d;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x0066;
    L_0x0055:
        goto L_0x005c;
    L_0x0056:
        r1 = r0.c;
        r4 = r9.c;
        if (r1 != r4) goto L_0x0066;
    L_0x005c:
        r2 = r3;
        goto L_0x0066;
    L_0x005e:
        r1 = r0.e;
        r2 = r9.e;
        r2 = r1.equals(r2);
    L_0x0066:
        if (r2 != 0) goto L_0x006b;
    L_0x0068:
        r0 = r0.i;
        goto L_0x000a;
    L_0x006b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.b.b.a(com.alibaba.fastjson.b.d):com.alibaba.fastjson.b.d");
    }

    final void b(d dVar) {
        int length;
        if (this.b > this.e) {
            length = this.d.length;
            int i = (length * 2) + 1;
            d[] dVarArr = new d[i];
            for (length--; length >= 0; length--) {
                d dVar2 = this.d[length];
                while (dVar2 != null) {
                    int i2 = dVar2.h % i;
                    d dVar3 = dVar2.i;
                    dVar2.i = dVarArr[i2];
                    dVarArr[i2] = dVar2;
                    dVar2 = dVar3;
                }
            }
            this.d = dVarArr;
            this.e = (int) (((double) i) * 0.75d);
        }
        length = dVar.h % this.d.length;
        dVar.i = this.d[length];
        this.d[length] = dVar;
    }
}
