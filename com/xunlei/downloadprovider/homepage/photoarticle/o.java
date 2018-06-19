package com.xunlei.downloadprovider.homepage.photoarticle;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.homepage.recommend.a.a;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: PhotoArticleDetailActivity */
final class o implements k {
    final /* synthetic */ PhotoArticleDetailActivity a;

    o(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        if (shareOperationType != ShareOperationType.REPORT) {
            shareOperationType = shareOperationType.getReportShareTo();
            fVar = fVar.j;
            String e = this.a.f;
            String f = this.a.h();
            StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_share_to");
            build.add("news_id", e);
            build.add("author_id", f);
            build.add("from", fVar);
            build.add("to", shareOperationType);
            y.a(build);
        } else if (this.a.c() == null) {
            ReportActivity.a(this.a, 9, this.a.f, this.a.g.a, DispatchConstants.OTHER);
        }
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        shareOperationType = shareOperationType.getReportShareTo();
        if (i == 0) {
            a.a().a(this.a.f, 9, this.a.g.a, "share_success");
        }
        i = com.xunlei.downloadprovider.f.a.a(i);
        fVar = fVar.j;
        String e = this.a.f;
        String f = this.a.h();
        StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_share_result");
        build.add("news_id", e);
        build.add("author_id", f);
        build.add("from", fVar);
        build.add("to", shareOperationType);
        build.add("result", i);
        y.a(build);
    }
}
