package org.apache.thrift.protocol;

import org.apache.thrift.f;

public class h {
    private static int a = Integer.MAX_VALUE;

    public static void a(e eVar, byte b) {
        a(eVar, b, a);
    }

    public static void a(e eVar, byte b, int i) {
        if (i <= 0) {
            throw new f("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case (byte) 2:
                eVar.q();
                return;
            case (byte) 3:
                eVar.r();
                return;
            case (byte) 4:
                eVar.v();
                return;
            case (byte) 6:
                eVar.s();
                return;
            case (byte) 8:
                eVar.t();
                return;
            case (byte) 10:
                eVar.u();
                return;
            case (byte) 11:
                eVar.x();
                return;
            case (byte) 12:
                eVar.g();
                while (true) {
                    b i3 = eVar.i();
                    if (i3.b != (byte) 0) {
                        a(eVar, i3.b, i - 1);
                        eVar.j();
                    } else {
                        eVar.h();
                        return;
                    }
                }
            case (byte) 13:
                d k = eVar.k();
                while (i2 < k.c) {
                    int i4 = i - 1;
                    a(eVar, k.a, i4);
                    a(eVar, k.b, i4);
                    i2++;
                }
                eVar.l();
                return;
            case (byte) 14:
                i o = eVar.o();
                while (i2 < o.b) {
                    a(eVar, o.a, i - 1);
                    i2++;
                }
                eVar.p();
                return;
            case (byte) 15:
                c m = eVar.m();
                while (i2 < m.b) {
                    a(eVar, m.a, i - 1);
                    i2++;
                }
                eVar.n();
                return;
            default:
                return;
        }
    }
}
