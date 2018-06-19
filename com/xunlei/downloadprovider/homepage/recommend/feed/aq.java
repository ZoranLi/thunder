package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;

/* compiled from: FeedVideoItemView */
final class aq implements OnClickListener {
    final /* synthetic */ z a;

    aq(z zVar) {
        this.a = zVar;
    }

    public final void onClick(View view) {
        this.a.a.f = false;
        this.a.h.setVisibility(8);
        this.a.a(this.a.C);
        if (this.a.a != null) {
            VideoFeedReporter.a("replay", this.a.a.a.getVideoId(), this.a.a.d, this.a.getFormatType());
        }
    }
}
