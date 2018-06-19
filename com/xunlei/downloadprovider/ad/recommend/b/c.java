package com.xunlei.downloadprovider.ad.recommend.b;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import com.xunlei.downloadprovider.ad.downloadlist.c.f;
import java.util.List;

/* compiled from: RecommendAdPresenter */
final class c implements a {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void a(List<l> list) {
        if (this.a.c.e() == null) {
            f.a().a(this.a.c.b());
            this.a.b();
            this.a.a(false);
        }
    }

    public final void a(int i, String str) {
        if (this.a.c.e() == 0) {
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_advertise", "adv_downloadin_change_fail").addString("tabid", com.xunlei.downloadprovider.ad.recommend.c.a.a(this.a.c.b())));
            this.a.b();
            this.a.a(false);
        }
    }
}
