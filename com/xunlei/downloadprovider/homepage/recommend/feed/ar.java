package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: FeedVideoItemView */
final class ar implements OnClickListener {
    final /* synthetic */ z a;

    ar(z zVar) {
        this.a = zVar;
    }

    public final void onClick(View view) {
        String videoId = this.a.a.a.getVideoId();
        String valueOf = String.valueOf(this.a.a.a.getPublisherId());
        String kind = this.a.a.b.getKind();
        this.a.z;
        VideoFeedReporter.a(videoId, valueOf, kind, l.c());
        z.a(this.a, this.a.a.a.getPublisherId());
    }
}
