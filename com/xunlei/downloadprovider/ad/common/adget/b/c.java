package com.xunlei.downloadprovider.ad.common.adget.b;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j.a;
import com.xunlei.downloadprovider.ad.common.adget.k;
import java.util.List;
import java.util.Map;

/* compiled from: MultiADManager */
final class c implements a {
    final /* synthetic */ List a;
    final /* synthetic */ b b;

    c(b bVar, List list) {
        this.b = bVar;
        this.a = list;
    }

    public final void a(Map<THUNDER_AD_INFO, a> map) {
        if (map == null || map.isEmpty()) {
            map = b.a;
            return;
        }
        for (THUNDER_AD_INFO thunder_ad_info : map.keySet()) {
            a aVar = (a) map.get(thunder_ad_info);
            if (aVar != null) {
                if (aVar.a == (byte) 0) {
                    this.b.b.put(thunder_ad_info, k.a(aVar.b));
                    this.b.a(thunder_ad_info);
                } else {
                    b.a(this.b, thunder_ad_info, aVar);
                }
            }
        }
    }

    public final void a() {
        for (THUNDER_AD_INFO thunder_ad_info : this.a) {
            b.a(this.b, thunder_ad_info, new a((byte) 2, thunder_ad_info.getPositionId(), null, null, null, null, thunder_ad_info.getDefStyle(), ""));
        }
    }
}
