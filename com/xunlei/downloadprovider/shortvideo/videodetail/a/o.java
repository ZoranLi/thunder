package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: CommentItemViewHolder */
final class o implements OnPreDrawListener {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final boolean onPreDraw() {
        if (!this.a.p) {
            int lineCount = this.a.h.getLineCount();
            this.a.h.setMaxLines(2);
            this.a.p = true;
            if (lineCount <= 2) {
                this.a.i.setVisibility(8);
            } else {
                this.a.i.setVisibility(0);
            }
        }
        return true;
    }
}
