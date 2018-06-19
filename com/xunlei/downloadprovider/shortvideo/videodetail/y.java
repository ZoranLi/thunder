package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.ViewGroup.MarginLayoutParams;
import com.xunlei.downloadprovider.homepage.b;
import com.xunlei.xllib.android.d;

/* compiled from: ShortMovieDetailActivity */
final class y implements Runnable {
    final /* synthetic */ MarginLayoutParams a;
    final /* synthetic */ ShortMovieDetailActivity b;

    y(ShortMovieDetailActivity shortMovieDetailActivity, MarginLayoutParams marginLayoutParams) {
        this.b = shortMovieDetailActivity;
        this.a = marginLayoutParams;
    }

    public final void run() {
        if (this.b.f != null) {
            if (this.a.topMargin + this.b.i.getMeasuredHeight() > d.b(this.b) - b.a()) {
                this.b.f.a(true);
            } else {
                this.b.f.a(false);
            }
            this.b.f.a(this.b.w ^ true, false);
        }
    }
}
