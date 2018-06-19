package com.xunlei.downloadprovider.ad.a;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.b.a;
import com.xunlei.downloadprovider.ad.common.adget.l;
import java.util.List;
import java.util.Map;

/* compiled from: ADClient */
final class b implements a {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void a(Map<THUNDER_AD_INFO, List<l>> map) {
        this.a.b = map;
        this.a.a();
    }
}
