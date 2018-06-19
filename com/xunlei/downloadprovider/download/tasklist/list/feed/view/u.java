package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;

/* compiled from: VideoFeedViewHolder */
final class u implements OnClickListener {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    public final void onClick(View view) {
        if (this.a.mAdapter.g != null) {
            this.a.mAdapter.g.k = false;
        }
        b.a(this.a.g, this.a.a == 306 ? "dl_tab_video_big_pic" : "dl_tab_video_list", this.a.mAdapter.a());
        t.f(this.a);
    }
}
