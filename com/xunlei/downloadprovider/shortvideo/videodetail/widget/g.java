package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: ShortMovieBaseTitleInfoView */
final class g implements OnPreDrawListener {
    final /* synthetic */ ShortMovieBaseTitleInfoView a;

    g(ShortMovieBaseTitleInfoView shortMovieBaseTitleInfoView) {
        this.a = shortMovieBaseTitleInfoView;
    }

    public final boolean onPreDraw() {
        if (!this.a.e) {
            int lineCount = this.a.a.getLineCount();
            this.a.a.setMaxLines(2);
            this.a.e = true;
            if (lineCount <= 2) {
                this.a.b.setVisibility(8);
            } else {
                this.a.b.setVisibility(0);
            }
        }
        return true;
    }
}
