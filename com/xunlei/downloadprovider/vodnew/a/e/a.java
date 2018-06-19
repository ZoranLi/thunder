package com.xunlei.downloadprovider.vodnew.a.e;

import com.xunlei.downloadprovider.download.downloadvod.i;

/* compiled from: PlayerStateBase */
abstract class a {
    protected static final String a = o.class.getSimpleName();
    protected o b;

    public abstract int a();

    public abstract void a(int i);

    public abstract void a(i iVar);

    public abstract String b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public a(o oVar) {
        this.b = oVar;
    }

    public static a a(o oVar, int i) {
        switch (i) {
            case 0:
                return new m(oVar);
            case 1:
                return new d(oVar);
            case 2:
                return new k(oVar);
            case 3:
                return new j(oVar);
            case 4:
                return new e(oVar);
            case 5:
                return new l(oVar);
            case 6:
                return new c(oVar);
            case 7:
                return new b(oVar);
            default:
                return 0;
        }
    }
}
