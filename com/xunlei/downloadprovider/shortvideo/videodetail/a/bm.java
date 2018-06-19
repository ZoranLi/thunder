package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: TaskCommentItemViewHolderNew */
final class bm implements OnLongClickListener {
    final /* synthetic */ be a;

    bm(be beVar) {
        this.a = beVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.g != null) {
            this.a.g.a(this.a.h, 9, this.a.r);
        }
        return true;
    }
}
