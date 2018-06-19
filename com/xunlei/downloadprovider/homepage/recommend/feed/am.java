package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.app.Activity;
import android.content.Context;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import com.xunlei.downloadprovider.homepage.recommend.feed.FeedVideoItemBottomView.a;
import com.xunlei.downloadprovider.homepage.redpacket.j;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;

/* compiled from: FeedVideoItemView */
final class am implements a {
    final /* synthetic */ Context a;
    final /* synthetic */ z b;

    am(z zVar, Context context) {
        this.b = zVar;
        this.a = context;
    }

    public final void a() {
        if (this.b.a != null) {
            String kind = this.b.a.b.getKind();
            String nickname = this.b.a.b.getNickname();
            String portraitUrl = this.b.a.b.getPortraitUrl();
            m.a(this.a, Long.valueOf(this.b.a.a.getPublisherId()).longValue(), kind, nickname, portraitUrl, From.FEED_FLOW, this.b.a.a.getGcid(), this.b.a.a.getVideoId());
        }
    }

    public final void b() {
        z.e(this.b);
    }

    public final void c() {
        this.b.a(this.b.getVideoDetailFrom());
        if (this.b.a != null) {
            VideoFeedReporter.a(this.b.a.a.getVideoId());
        }
    }

    public final void d() {
        if (this.b.a != null) {
            j.a().a((Activity) this.b.getContext(), "short_video", this.b.a.a, this.b.E, null);
            VideoFeedReporter.b(this.b.a.a.getVideoId(), "foot");
        }
    }

    public final void e() {
        if (this.b.a != null) {
            b.a().a(this.b.a.a.getPublisherId(), true, new an(this));
        }
    }
}
