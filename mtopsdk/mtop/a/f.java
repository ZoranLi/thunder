package mtopsdk.mtop.a;

import mtopsdk.mtop.unit.a;
import mtopsdk.mtop.unit.c;
import mtopsdk.mtop.util.e;

final class f implements Runnable {
    f() {
    }

    public final void run() {
        g.a();
        if (g.e()) {
            if (mtopsdk.common.util.f.b()) {
                e.a(new c());
                return;
            }
            a.a();
        }
    }
}
