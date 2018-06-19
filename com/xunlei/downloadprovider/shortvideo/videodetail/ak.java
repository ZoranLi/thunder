package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.xunlei.downloadprovider.player.xmp.c;

/* compiled from: ShortMovieDetailActivity */
final class ak implements c {
    final /* synthetic */ ShortMovieDetailActivity a;

    ak(ShortMovieDetailActivity shortMovieDetailActivity) {
        this.a = shortMovieDetailActivity;
    }

    public final void a(boolean z) {
        this.a.W = z;
        this.a.g();
        if (this.a.a != null) {
            ShortMovieDetailFragment a;
            this.a.w = z;
            boolean z2 = false;
            if (z) {
                this.a.f.c(false);
                if (!this.a.O.getVisibility()) {
                    this.a.O.setVisibility(8);
                }
                a = this.a.f;
            } else {
                if (this.a.O.getVisibility() && this.a.a.h() >= true && ShortMovieDetailActivity.m(this.a)) {
                    ShortMovieDetailActivity.n(this.a);
                }
                z = this.a.r.getVisibility();
                a = this.a.f;
                if (!z) {
                    z2 = true;
                }
            }
            a.a(z2, true);
        }
    }
}
