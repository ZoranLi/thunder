package com.igexin.b.a.b;

public abstract class b {
    protected String c;
    protected b d;
    protected b e;
    protected boolean f;

    public b(String str, boolean z) {
        this.c = str;
        this.f = z;
    }

    public abstract Object a(e eVar, d dVar, Object obj);

    protected final void a(b bVar) {
        if (bVar != null) {
            b bVar2 = bVar.d;
            bVar.d = this;
            this.e = bVar;
            this.d = bVar2;
        }
    }

    public void a(boolean z) {
        if (!this.f || z) {
            while (this.d != null) {
                b bVar = this.d.d;
                this.d.d = null;
                this.d = bVar;
            }
        }
    }

    public abstract Object c(e eVar, d dVar, Object obj);

    public final Object d(e eVar, d dVar, Object obj) {
        if (obj == null) {
            throw new NullPointerException("Nothing to encode!");
        }
        if (this.d != null) {
            obj = this.d.d(eVar, dVar, obj);
        }
        return a(eVar, dVar, obj);
    }
}
