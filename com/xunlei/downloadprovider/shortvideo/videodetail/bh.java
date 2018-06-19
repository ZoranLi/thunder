package com.xunlei.downloadprovider.shortvideo.videodetail;

/* compiled from: ShortMovieDetailFragment */
final class bh implements Runnable {
    final /* synthetic */ ShortMovieDetailFragment a;

    bh(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void run() {
        String str = ShortMovieDetailFragment.a;
        StringBuilder stringBuilder = new StringBuilder("doSeekToComment--mSeekToComment=");
        stringBuilder.append(this.a.C);
        stringBuilder.append("|mLoadCommentStatus=");
        stringBuilder.append(this.a.w);
        stringBuilder.append("|mLoadHotCommentStatus=");
        stringBuilder.append(this.a.x);
        if (this.a.C && this.a.w != 0 && this.a.x != 0) {
            this.a.c(0);
            if (this.a.D) {
                this.a.r();
            }
        }
    }
}
