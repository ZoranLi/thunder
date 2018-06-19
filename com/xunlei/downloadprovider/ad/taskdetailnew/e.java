package com.xunlei.downloadprovider.ad.taskdetailnew;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TaskDetailNewAdModel */
final class e implements a {
    final /* synthetic */ THUNDER_AD_INFO a;
    final /* synthetic */ c b;

    public final void a(int i, String str) {
    }

    e(c cVar, THUNDER_AD_INFO thunder_ad_info) {
        this.b = cVar;
        this.a = thunder_ad_info;
    }

    public final void a(List<l> list) {
        c cVar = this.b;
        THUNDER_AD_INFO thunder_ad_info = this.a;
        List list2 = (List) cVar.a.get(thunder_ad_info);
        if (list2 == null) {
            list2 = new ArrayList();
            cVar.a.put(thunder_ad_info, list2);
        }
        list2.addAll(list);
    }
}
