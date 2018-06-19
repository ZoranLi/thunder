package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: TaskCommentItemViewHolderNew */
final class bf implements OnPreDrawListener {
    final /* synthetic */ be a;

    bf(be beVar) {
        this.a = beVar;
    }

    public final boolean onPreDraw() {
        if (!this.a.s) {
            int lineCount = this.a.j.getLineCount();
            this.a.j.setMaxLines(2);
            this.a.s = true;
            if (lineCount <= 2) {
                this.a.k.setVisibility(8);
            } else {
                this.a.k.setVisibility(0);
            }
        }
        return true;
    }
}
