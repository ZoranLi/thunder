package com.xunlei.downloadprovider.shortvideo.videodetail;

/* compiled from: ShortMovieDetailActivity */
final class ab implements Runnable {
    final /* synthetic */ ShortMovieDetailActivity a;

    ab(ShortMovieDetailActivity shortMovieDetailActivity) {
        this.a = shortMovieDetailActivity;
    }

    public final void run() {
        if (this.a.a != null && !this.a.a.f.e) {
            this.a.a.f();
        }
    }
}
