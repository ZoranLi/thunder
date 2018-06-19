package com.xunlei.downloadprovider.personal.a.b.c;

import com.xunlei.downloadprovider.personal.a.e.b.a;

/* compiled from: UserOneGridScoreViewHolder */
final class i implements a {
    final /* synthetic */ e a;

    i(e eVar) {
        this.a = eVar;
    }

    public final void a(com.xunlei.downloadprovider.personal.a.e.i iVar) {
        this.a.p = iVar.d;
        e.m = this.a.p;
        e eVar = this.a;
        boolean z = true;
        if (iVar.a != 1) {
            z = false;
        }
        eVar.o = z;
        e.l = this.a.o;
        this.a.u.sendEmptyMessage(103);
        com.xunlei.downloadprovider.personal.a.a.a().a("key_user_score", String.valueOf(e.m));
    }

    public final void a() {
        this.a.u.sendEmptyMessage(104);
    }
}
