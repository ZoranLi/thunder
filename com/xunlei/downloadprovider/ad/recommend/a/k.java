package com.xunlei.downloadprovider.ad.recommend.a;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import com.xunlei.downloadprovider.ad.common.i;
import java.util.List;

/* compiled from: RecommendAdModelUpperDecoration */
public final class k implements a {
    final /* synthetic */ i a;
    final /* synthetic */ int b;
    final /* synthetic */ a c;
    final /* synthetic */ h d;

    public k(h hVar, i iVar, int i, a aVar) {
        this.d = hVar;
        this.a = iVar;
        this.b = i;
        this.c = aVar;
    }

    public final void a(List<l> list) {
        if (this.a.c) {
            h.c;
            return;
        }
        this.a.d.cancel();
        h.a(this.d, this.b, list);
        if (this.c != null) {
            this.c.a(list);
        }
    }

    public final void a(int i, String str) {
        if (this.a.c) {
            h.c;
            return;
        }
        this.a.d.cancel();
        if (this.c != null) {
            this.c.a(i, str);
        }
    }
}
