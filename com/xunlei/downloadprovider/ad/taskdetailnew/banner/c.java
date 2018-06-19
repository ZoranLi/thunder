package com.xunlei.downloadprovider.ad.taskdetailnew.banner;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.report.b;
import com.xunlei.downloadprovider.ad.common.report.d;
import com.xunlei.downloadprovider.ad.taskdetailnew.banner.g.a;

/* compiled from: TaskDetailNewBannerAdController */
final class c implements a {
    final /* synthetic */ String a;
    final /* synthetic */ TaskDetailNewBannerAdController b;

    c(TaskDetailNewBannerAdController taskDetailNewBannerAdController, String str) {
        this.b = taskDetailNewBannerAdController;
        this.a = str;
    }

    public final void a() {
        d.a(new b(THUNDER_AD_INFO.TASK_DETAIL_NEW_BANNER.mPositionId), this.a);
    }
}
