package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskCommentItemViewHolderNew */
final class br implements OnClickListener {
    final /* synthetic */ be a;

    br(be beVar) {
        this.a = beVar;
    }

    public final void onClick(View view) {
        if (this.a.r.isLiked() == null) {
            be.k(this.a);
            if (this.a.g != null) {
                this.a.g.a(this.a.p, 11, this.a.r);
            }
        }
    }
}
