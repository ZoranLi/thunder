package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.recommend.a.a;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: ChoicenessPhotoArticleView */
final class ad implements k {
    final /* synthetic */ y a;

    ad(y yVar) {
        this.a = yVar;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        fVar = shareOperationType.getReportShareTo();
        if (shareOperationType == ShareOperationType.REPORT) {
            ReportActivity.a(this.a.getContext(), 1, this.a.d.b(), this.a.d.a.a, DispatchConstants.OTHER);
            ChoicenessReporter.a(this.a.d.b(), "jubao", "home_collect");
            return;
        }
        ChoicenessReporter.b(this.a.d, fVar, "news");
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        if (i == 0) {
            a.a().a(this.a.d.b(), 9, this.a.d.a.a, "share_success");
            y.b(this.a);
        }
        ChoicenessReporter.a(this.a.d, shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), i, false, this.a.getReportContentType());
    }
}
