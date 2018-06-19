package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;

/* compiled from: FeedVideoItemView */
final class ae extends aj {
    final /* synthetic */ ThunderXmpPlayer a;
    final /* synthetic */ z b;

    ae(z zVar, ThunderXmpPlayer thunderXmpPlayer) {
        this.b = zVar;
        this.a = thunderXmpPlayer;
    }

    public final void a() {
        super.a();
        if (this.b.a != null) {
            this.b.a.f = true;
            VideoFeedReporter.b(this.b.a.a.getVideoId());
            this.b.e();
        }
        this.a.a();
    }
}
