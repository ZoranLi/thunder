package com.getui.gtc.b;

import com.getui.gtc.entity.a;
import com.getui.gtc.entity.a.b;
import com.getui.gtc.entity.d;

final class e implements b {
    final /* synthetic */ a a;
    final /* synthetic */ d b;
    final /* synthetic */ c c;

    e(c cVar, a aVar, d dVar) {
        this.c = cVar;
        this.a = aVar;
        this.b = dVar;
    }

    public final void a(int i, a.a aVar) {
        if (this.a != null) {
            a.a a = this.a.a(i);
            if (a != null) {
                if (!a.b.equalsIgnoreCase(aVar.b)) {
                    com.getui.gtc.e.e.a(a.c);
                    c.a(this.c, this.b, aVar);
                }
                return;
            }
        }
        c.a(this.c, this.b, aVar);
    }
}
