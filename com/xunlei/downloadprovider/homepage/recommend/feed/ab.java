package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: FeedVideoItemView */
final class ab implements a {
    final /* synthetic */ z a;

    ab(z zVar) {
        this.a = zVar;
    }

    public final void a() {
        String videoId = this.a.a.a.getVideoId();
        String valueOf = String.valueOf(this.a.a.a.getPublisherId());
        String kind = this.a.a.b.getKind();
        this.a.z;
        VideoFeedReporter.a(videoId, valueOf, kind, l.c(), "success", "");
        this.a.h.a(true);
        this.a.a.a(true);
        this.a.j.notifyDataSetChanged();
    }

    public final void a(String str) {
        String videoId = this.a.a.a.getVideoId();
        String valueOf = String.valueOf(this.a.a.a.getPublisherId());
        String kind = this.a.a.b.getKind();
        this.a.z;
        VideoFeedReporter.a(videoId, valueOf, kind, l.c(), "fail", str);
        this.a.h.a(false);
        this.a.a.a(false);
    }
}
