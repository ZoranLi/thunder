package mtopsdk.mtop.common;

import mtopsdk.a.b.e;
import mtopsdk.a.f;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;
import mtopsdk.mtop.a;
import mtopsdk.mtop.util.h;

public final class o implements f {
    public e a;
    public f b;
    public h c = null;
    a d;
    private Object e;

    public o(a aVar) {
        this.d = aVar;
        this.e = aVar.i;
    }

    private void a(e eVar, Object obj) {
        mtopsdk.mtop.util.e.a(b(), new q(this, eVar, obj));
    }

    private int b() {
        String a = a();
        return a != null ? a.hashCode() : hashCode();
    }

    final void a(h hVar) {
        if (hVar != null) {
            hVar.b();
            hVar.g();
            if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
                j.a(a(), hVar.toString());
            }
        }
    }

    private String a() {
        return this.c != null ? this.c.q : null;
    }

    public final void a(mtopsdk.a.a aVar, Exception exception) {
        mtopsdk.a.b.f fVar = new mtopsdk.a.b.f();
        fVar.a = aVar.a();
        fVar.b = -7;
        fVar.c = exception.getMessage();
        a(fVar.a(), this.e);
    }

    public final void a(e eVar) {
        mtopsdk.mtop.util.e.a(b(), new p(this, eVar, this.e));
        a(eVar, this.e);
    }

    public final void onCancel(mtopsdk.a.a aVar) {
        mtopsdk.a.b.f fVar = new mtopsdk.a.b.f();
        fVar.a = aVar.a();
        fVar.b = -8;
        a(fVar.a(), this.e);
    }
}
