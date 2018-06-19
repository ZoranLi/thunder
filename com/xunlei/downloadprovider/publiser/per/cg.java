package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: PublisherActivity */
final class cg implements k {
    final /* synthetic */ PublisherActivity a;

    cg(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        if (this.a.d != null) {
            if (shareOperationType == ShareOperationType.REPORT) {
                ReportActivity.a(this.a, this.a.k, "shortvideo_usercenter");
            } else if (shareOperationType == ShareOperationType.LINK_PUBLISH) {
                PublisherActivity.A(this.a);
            }
            a.d(shareOperationType.getReportShareTo(), this.a.d.a().getUid(), this.a.d.a().getKind());
        }
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        if (this.a.d != null) {
            a.a(shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), i, this.a.d.a().getUid(), this.a.d.a().getKind());
        }
    }
}
