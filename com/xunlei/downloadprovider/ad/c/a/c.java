package com.xunlei.downloadprovider.ad.c.a;

import java.util.List;

/* compiled from: Scheduler */
public final class c implements a {
    private b a = null;
    private List<b> b = null;

    public final void a(b bVar) {
        this.a = bVar;
    }

    public final void a(List<b> list) {
        this.b = list;
    }

    public final void a() {
        b(this.a);
        if (this.b != null) {
            for (b b : this.b) {
                b(b);
            }
        }
    }

    private static void b(b bVar) {
        if (bVar == null) {
            return;
        }
        if (!(bVar instanceof f) || ((f) bVar).f()) {
            bVar.a();
        }
    }
}
