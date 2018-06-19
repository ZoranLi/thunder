package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: TaskCommentItemViewHolder */
final class as implements OnPreDrawListener {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    public final boolean onPreDraw() {
        if (!this.a.t) {
            int lineCount = this.a.j.getLineCount();
            this.a.j.setMaxLines(2);
            this.a.t = true;
            if (lineCount <= 2) {
                this.a.k.setVisibility(8);
            } else {
                this.a.k.setVisibility(0);
            }
        }
        return true;
    }
}
