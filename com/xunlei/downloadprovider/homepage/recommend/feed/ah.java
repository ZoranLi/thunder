package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.xunlei.downloadprovider.e.b.b;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import com.xunlei.downloadprovider.homepage.redpacket.j;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: FeedVideoItemView */
final class ah implements k {
    final /* synthetic */ z a;

    ah(z zVar) {
        this.a = zVar;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        if (shareOperationType == ShareOperationType.REPORT) {
            z.k(this.a);
            VideoFeedReporter.a();
            return;
        }
        VideoFeedReporter.a(this.a.a.a.getVideoId(), "foot", shareOperationType.getReportShareTo());
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        VideoFeedReporter.a(this.a.a.a.getVideoId(), shareOperationType.getReportShareTo(), a.a(i), i, "foot");
        if (i == 0) {
            b.a();
            b.a(this.a.a.a.getVideoId());
            i = com.xunlei.downloadprovider.homepage.recommend.a.a.a();
            shareOperationType = new StringBuilder();
            shareOperationType.append(this.a.a.a.getVideoId());
            i.a(shareOperationType.toString(), 1, this.a.a.a.getGcid(), "share_success");
            j.a().a(this.a.getContext(), fVar);
        }
    }
}
