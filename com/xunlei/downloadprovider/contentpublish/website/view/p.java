package com.xunlei.downloadprovider.contentpublish.website.view;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: WebsiteInfoViewHolder */
final class p implements OnPreDrawListener {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final boolean onPreDraw() {
        if (!this.a.o) {
            int lineCount = this.a.a.getLineCount();
            this.a.a.setMaxLines(2);
            this.a.o = true;
            if (lineCount <= 2) {
                this.a.b.setVisibility(8);
            } else {
                this.a.b.setVisibility(0);
            }
        }
        return true;
    }
}
