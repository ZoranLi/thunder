package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskCommentItemViewHolder */
final class bd implements OnClickListener {
    final /* synthetic */ ar a;

    bd(ar arVar) {
        this.a = arVar;
    }

    public final void onClick(View view) {
        if (this.a.s.isLiked() == null) {
            ar.k(this.a);
            if (this.a.f != null) {
                this.a.f.a(this.a.q, 11, this.a.s);
            }
        }
    }
}
