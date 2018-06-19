package com.xunlei.downloadprovider.vodnew.a.b;

import android.content.Context;
import android.os.Bundle;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.vodnew.a.e.aa;
import com.xunlei.downloadprovider.vodnew.a.e.o.b;
import com.xunlei.downloadprovider.vodnew.a.e.o.c;
import com.xunlei.downloadprovider.vodnew.a.e.o.d;
import com.xunlei.downloadprovider.vodnew.a.e.o.e;
import com.xunlei.downloadprovider.vodnew.a.e.o.f;
import com.xunlei.downloadprovider.vodnew.a.e.o.g;
import com.xunlei.downloadprovider.vodnew.a.e.o.i;

/* compiled from: PlayerCallbackBroadcastDecorator */
public final class a extends aa {
    e a;
    b b;
    com.xunlei.downloadprovider.vodnew.a.e.o.a c;
    g d;
    i e;
    c f;
    d g;
    f h;
    private Context j = BrothersApplication.getApplicationInstance();

    public a(com.xunlei.downloadprovider.vodnew.a.d.c cVar) {
        super(cVar);
        this.i.a(new b(this));
        this.i.a(new c(this));
        this.i.a(new d(this));
        this.i.a(new e(this));
        this.i.a(new f(this));
        this.i.a(new g(this));
        this.i.a(new h(this));
        this.i.a(new i(this));
    }

    public final void a(e eVar) {
        this.a = eVar;
    }

    public final void a(b bVar) {
        this.b = bVar;
    }

    public final void a(com.xunlei.downloadprovider.vodnew.a.e.o.a aVar) {
        this.c = aVar;
    }

    public final void a(g gVar) {
        this.d = gVar;
    }

    public final void a(i iVar) {
        this.e = iVar;
    }

    public final void a(c cVar) {
        this.f = cVar;
    }

    public final void a(d dVar) {
        this.g = dVar;
    }

    public final void a(f fVar) {
        this.h = fVar;
    }

    static /* synthetic */ Bundle a(a aVar, int i) {
        Bundle bundle = new Bundle(i + 1);
        bundle.putInt("KEY_Player_Id", aVar.i.c());
        return bundle;
    }
}
