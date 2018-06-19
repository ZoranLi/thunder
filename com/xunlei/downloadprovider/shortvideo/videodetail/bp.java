package com.xunlei.downloadprovider.shortvideo.videodetail;

/* compiled from: ShortMovieDetailFragment */
final class bp implements Runnable {
    final /* synthetic */ ShortMovieDetailFragment a;

    bp(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void run() {
        this.a.o.setText("");
        this.a.z.setVisibility(4);
    }
}
