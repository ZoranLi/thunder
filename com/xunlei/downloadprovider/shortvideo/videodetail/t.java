package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ShortMovieDetailActivity */
final class t implements OnClickListener {
    final /* synthetic */ ShortMovieDetailActivity a;

    t(ShortMovieDetailActivity shortMovieDetailActivity) {
        this.a = shortMovieDetailActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
