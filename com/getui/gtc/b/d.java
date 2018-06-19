package com.getui.gtc.b;

import com.getui.gtc.e.e;
import com.getui.gtc.entity.a;
import com.getui.gtc.entity.a.b;

final class d implements b {
    final /* synthetic */ a a;
    final /* synthetic */ a b;
    final /* synthetic */ c c;

    d(c cVar, a aVar, a aVar2) {
        this.c = cVar;
        this.a = aVar;
        this.b = aVar2;
    }

    public final void a(int i, a.a aVar) {
        if (this.a == null || this.a.a(i) == null) {
            try {
                this.b.b(i);
                e.a(aVar.c);
                this.c.a(aVar.d);
            } catch (Exception e) {
                new String[1][0] = e.toString();
            }
        }
    }
}
