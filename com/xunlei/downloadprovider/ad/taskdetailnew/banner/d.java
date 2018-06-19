package com.xunlei.downloadprovider.ad.taskdetailnew.banner;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.report.e;
import com.xunlei.downloadprovider.ad.common.report.h;
import com.xunlei.downloadprovider.ad.taskdetailnew.banner.g.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TaskDetailNewBannerAdController */
final class d implements a {
    final /* synthetic */ e a;
    final /* synthetic */ TaskDetailNewBannerAdController b;

    d(TaskDetailNewBannerAdController taskDetailNewBannerAdController, e eVar) {
        this.b = taskDetailNewBannerAdController;
        this.a = eVar;
    }

    public final void a() {
        h hVar = new h(THUNDER_AD_INFO.TASK_DETAIL_NEW_BANNER.mPositionId, "");
        e eVar = this.a;
        Map hashMap = new HashMap();
        hashMap.put("position_id", hVar.a);
        hashMap.put("style_id", hVar.b);
        if (hVar.getExtras() != null) {
            hashMap.putAll(hVar.getExtras());
        }
        Map hashMap2 = new HashMap();
        hashMap2.put("error_code", String.valueOf(eVar.a));
        hashMap2.put("error_msg", eVar.b);
        hashMap.putAll(hashMap2);
        com.xunlei.downloadprovider.ad.common.report.a.a("ad_noshow", hashMap);
    }
}
