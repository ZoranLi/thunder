package com.alibaba.baichuan.android.trade.c.a.a.b;

public final class a {
    public d a;
    private b b;

    public a(d dVar) {
        this.a = dVar;
        this.b = dVar.j;
    }

    public final boolean a(c cVar) {
        if (this.a.m == null || this.b == null) {
            return false;
        }
        for (f a : this.a.m.values()) {
            if (a.a(cVar)) {
                return this.b.a(cVar);
            }
        }
        return false;
    }
}
