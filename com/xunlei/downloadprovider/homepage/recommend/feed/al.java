package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;

/* compiled from: FeedVideoItemView */
final class al implements OnClickListener {
    final /* synthetic */ z a;

    al(z zVar) {
        this.a = zVar;
    }

    public final void onClick(View view) {
        this.a.a(false);
        if (this.a.a != null) {
            VideoFeedReporter.a("play", this.a.a.a.getVideoId(), this.a.a.d, this.a.getFormatType());
        }
    }
}
