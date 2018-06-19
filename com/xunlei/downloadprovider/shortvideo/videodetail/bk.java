package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailFragment.a;

/* compiled from: ShortMovieDetailFragment */
final class bk implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ ShortMovieDetailFragment b;

    bk(ShortMovieDetailFragment shortMovieDetailFragment, boolean z) {
        this.b = shortMovieDetailFragment;
        this.a = z;
    }

    public final void run() {
        if (this.b.mActivity != null) {
            if (!this.b.mActivity.isFinishing()) {
                this.b.p.b = this.a;
                ((a) this.b.mActivity).a(this.b.p);
            }
        }
    }
}
