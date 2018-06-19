package com.xunlei.downloadprovider.ad.recommend.a;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.List;

/* compiled from: RecommendAdModel */
final class d implements a {
    final /* synthetic */ c.a a;
    final /* synthetic */ int b;
    final /* synthetic */ THUNDER_AD_INFO c;
    final /* synthetic */ c d;

    d(c cVar, c.a aVar, int i, THUNDER_AD_INFO thunder_ad_info) {
        this.d = cVar;
        this.a = aVar;
        this.b = i;
        this.c = thunder_ad_info;
    }

    public final void a(List<l> list) {
        this.a.a((List) list, this.b, this.c.getPositionId());
    }

    public final void a(int i, String str) {
        this.a.a(str, this.b, this.c.getPositionId());
    }
}
