package com.xunlei.downloadprovider.ad.downloadlist;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.b.a;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.downloadlist.DownloadListADConst.DownloadListSSPAdMapping;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: SecondADClient */
final class e implements a {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void a(@NonNull Map<THUNDER_AD_INFO, List<l>> map) {
        for (THUNDER_AD_INFO thunder_ad_info : map.keySet()) {
            if (thunder_ad_info == DownloadListSSPAdMapping.getThunderAdInfo(0)) {
                if (!(map.get(thunder_ad_info) == null || ((List) map.get(thunder_ad_info)).size() == 0)) {
                    this.a.f = new ArrayList();
                    this.a.f.addAll((Collection) map.get(thunder_ad_info));
                    this.a.a(0);
                }
            } else if (thunder_ad_info == DownloadListSSPAdMapping.getThunderAdInfo(1)) {
                if (!(map.get(thunder_ad_info) == null || ((List) map.get(thunder_ad_info)).size() == 0)) {
                    this.a.g = new ArrayList();
                    this.a.g.addAll((Collection) map.get(thunder_ad_info));
                    this.a.a(1);
                }
            } else if (!(thunder_ad_info != DownloadListSSPAdMapping.getThunderAdInfo(2) || map.get(thunder_ad_info) == null || ((List) map.get(thunder_ad_info)).size() == 0)) {
                this.a.h = new ArrayList();
                this.a.h.addAll((Collection) map.get(thunder_ad_info));
                this.a.a(2);
            }
        }
    }
}
