package com.xunlei.downloadprovider.ad.common.adget.b;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiADManager */
final class d implements a {
    final /* synthetic */ THUNDER_AD_INFO a;
    final /* synthetic */ j.a b;
    final /* synthetic */ b c;

    d(b bVar, THUNDER_AD_INFO thunder_ad_info, j.a aVar) {
        this.c = bVar;
        this.a = thunder_ad_info;
        this.b = aVar;
    }

    public final void a(List<l> list) {
        this.c.b.put(this.a, list);
        this.c.a(this.a);
    }

    public final void a(int i, String str) {
        if (this.b.b == 0) {
            this.c.b.put(this.a, new ArrayList());
        } else {
            this.c.b.put(this.a, k.a(this.b.b));
        }
        this.c.a(this.a);
    }
}
