package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.xunlei.downloadprovider.e.b.b;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: FeedItemShareLayout */
final class n implements k {
    final /* synthetic */ FeedItemShareLayout a;

    n(FeedItemShareLayout feedItemShareLayout) {
        this.a = feedItemShareLayout;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        fVar = this.a.d;
        if (fVar != null) {
            VideoFeedReporter.a(fVar.a.getVideoId(), "screen", shareOperationType.getReportShareTo());
        }
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        fVar = this.a.d;
        if (fVar != null) {
            VideoFeedReporter.a(fVar.a.getVideoId(), shareOperationType.getReportShareTo(), a.a(i), i, "screen");
            if (i == 0) {
                b.a();
                b.a(fVar.a.getVideoId());
                i = com.xunlei.downloadprovider.homepage.recommend.a.a.a();
                shareOperationType = new StringBuilder();
                shareOperationType.append(fVar.a.getVideoId());
                i.a(shareOperationType.toString(), 1, fVar.a.getGcid(), "share_success");
            }
        }
    }
}
