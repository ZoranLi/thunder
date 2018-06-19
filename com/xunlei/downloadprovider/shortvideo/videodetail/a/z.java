package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CommentItemViewHolder */
final class z implements OnClickListener {
    final /* synthetic */ n a;

    z(n nVar) {
        this.a = nVar;
    }

    public final void onClick(View view) {
        if (this.a.o.isLiked() == null) {
            n.k(this.a);
            if (this.a.f != null) {
                this.a.f.a(this.a.n, 11, this.a.o);
            }
        }
    }
}
