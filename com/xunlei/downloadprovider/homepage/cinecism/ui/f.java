package com.xunlei.downloadprovider.homepage.cinecism.ui;

import com.xunlei.downloadprovider.homepage.recommend.a.a;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.k;

/* compiled from: CinecismCardView */
final class f implements k {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, com.xunlei.downloadprovidershare.a.f fVar) {
        this.a.d.a(shareOperationType, this.a.a.b(), shareOperationType.getReportShareTo());
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, com.xunlei.downloadprovidershare.a.f fVar) {
        if (i == 0) {
            a.a().a(this.a.a.b(), 8, this.a.a.a.a, "share_success");
            a.c(this.a);
        }
        this.a.d.a(i, shareOperationType);
    }
}
