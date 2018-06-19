package com.alibaba.baichuan.android.trade.c.a.a.a;

import com.alibaba.baichuan.android.trade.c.a.a.b.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {
    public d a;
    private List b;

    public a(d dVar) {
        this.a = dVar;
        if (dVar.j != null) {
            if (dVar.j.size() != 0) {
                this.b = new ArrayList(dVar.j.size());
                for (com.alibaba.baichuan.android.trade.c.a.a.a.d.a a : dVar.j.values()) {
                    b a2 = a.a();
                    if (a2 != null) {
                        this.b.add(a2);
                    }
                }
                return;
            }
        }
        this.b = Collections.emptyList();
    }

    public final boolean a(c cVar) {
        boolean z = false;
        if (this.a.m != null) {
            if (this.b.size() == 0) {
                return false;
            }
            for (f a : this.a.m.values()) {
                if (a.a(cVar)) {
                    for (b a2 : this.b) {
                        if (a2.a(cVar)) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }
}
