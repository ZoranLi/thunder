package com.xunlei.downloadprovider.ad.d;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: AdBaseInfoViewHolder */
final class b implements OnPreDrawListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final boolean onPreDraw() {
        if (!this.a.q) {
            int lineCount = this.a.a.getLineCount();
            this.a.a.setMaxLines(2);
            this.a.q = true;
            if (lineCount <= 2) {
                this.a.b.setVisibility(8);
            } else {
                this.a.b.setVisibility(0);
            }
        }
        return true;
    }
}
