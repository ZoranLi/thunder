package com.xunlei.downloadprovider.ad.recommend.b;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.recommend.RecommendADConst;
import java.util.Comparator;

/* compiled from: RecommendAdPresenter */
final class f implements Comparator<l> {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return RecommendADConst.a((l) obj2) - RecommendADConst.a((l) obj);
    }
}
