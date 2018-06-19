package com.xunlei.downloadprovider.homepage.cinecism;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.homepage.recommend.a.a;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: CinecismDetailActivity */
final class l implements k {
    final /* synthetic */ CinecismDetailActivity a;

    l(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        if (shareOperationType != ShareOperationType.REPORT) {
            z.a(fVar.j, shareOperationType.getReportShareTo(), this.a.e, this.a.c());
        } else if (this.a.g() == null) {
            ReportActivity.a(this.a, 8, this.a.e, this.a.f.a, DispatchConstants.OTHER);
        }
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        String reportShareTo = shareOperationType.getReportShareTo();
        if (i == 0) {
            a.a().a(this.a.e, 8, this.a.f.a, "share_success");
        }
        z.a(fVar.j, reportShareTo, com.xunlei.downloadprovider.f.a.a(i), i, this.a.e, this.a.c());
    }
}
