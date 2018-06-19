package com.xunlei.downloadprovider.ad.taskdetailnew;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;

/* compiled from: TaskDetailNewAdModel */
final class d implements Runnable {
    final /* synthetic */ THUNDER_AD_INFO a;

    d(THUNDER_AD_INFO thunder_ad_info) {
        this.a = thunder_ad_info;
    }

    public final void run() {
        c.a().b(this.a);
    }
}
