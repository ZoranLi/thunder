package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.xunlei.downloadprovider.ad.d.f.a;

/* compiled from: ShortMovieDetailFragment */
final class bj implements a {
    final /* synthetic */ ShortMovieDetailFragment a;

    bj(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void a() {
        new StringBuilder("onBrandAdUpdate canUpdateRecommendAd(): ").append(ShortMovieDetailFragment.d(this.a));
        this.a.v = 2;
        if (ShortMovieDetailFragment.d(this.a)) {
            this.a.g();
            this.a.h();
        }
    }
}
