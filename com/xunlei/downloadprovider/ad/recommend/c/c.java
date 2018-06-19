package com.xunlei.downloadprovider.ad.recommend.c;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.downloadlist.c.f;
import com.xunlei.downloadprovider.ad.downloadlist.c.i;

/* compiled from: RecommendPVReporter */
public final class c implements i {
    private int a;

    public final boolean b() {
        return false;
    }

    public c(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public final void c() {
        if (f.a().a != null && !f.a().a.contains(Integer.valueOf(this.a))) {
            int i = this.a;
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_advertise", "adv_downloadin_pv").addString("tabid", a.a(i)).addString("net_type", a.b()));
            f.a().a.add(Integer.valueOf(this.a));
        }
    }
}
