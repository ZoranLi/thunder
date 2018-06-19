package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: ShortMovieDetailFragment */
final class ap extends OnScrollListener {
    final /* synthetic */ ShortMovieDetailFragment a;

    ap(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        recyclerView = ShortMovieDetailFragment.a;
        ShortMovieDetailFragment.a(this.a, i);
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        this.a.m();
    }
}
