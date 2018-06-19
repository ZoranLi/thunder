package com.xunlei.downloadprovider.ad.recommend.a;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.List;

/* compiled from: RecommendAdModelUpperDecoration */
final class i implements a {
    final /* synthetic */ int a;
    final /* synthetic */ h b;

    i(h hVar, int i) {
        this.b = hVar;
        this.a = i;
    }

    public final void a(List<l> list) {
        h.a(this.b, this.a, list);
        this.b.b.put(Integer.valueOf(this.a), Boolean.valueOf(true));
        this.b.a(this.a, list);
    }

    public final void a(int i, String str) {
        this.b.b.put(Integer.valueOf(this.a), Boolean.valueOf(true));
        this.b.a(this.a, i, str);
    }
}
