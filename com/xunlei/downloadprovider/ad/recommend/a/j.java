package com.xunlei.downloadprovider.ad.recommend.a;

import com.xunlei.downloadprovider.ad.common.h;
import com.xunlei.downloadprovider.ad.common.i.a;
import java.util.List;

/* compiled from: RecommendAdModelUpperDecoration */
public final class j implements a {
    final /* synthetic */ int a;
    final /* synthetic */ h.a b;
    final /* synthetic */ h c;

    public j(h hVar, int i, h.a aVar) {
        this.c = hVar;
        this.a = i;
        this.b = aVar;
    }

    public final void g_() {
        c a = this.c.a;
        int i = this.a;
        List c = a.c(i);
        a.a(i);
        a.b(i);
        if (!c.isEmpty()) {
            h.a(this.c, this.a, c);
            if (this.b != null) {
                this.b.a(c);
            }
        } else if (this.b != null) {
            this.b.a(-11, "-11");
        }
    }
}
