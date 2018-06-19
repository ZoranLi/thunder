package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: CommentItemViewHolder */
final class u implements OnLongClickListener {
    final /* synthetic */ n a;

    u(n nVar) {
        this.a = nVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.f != null) {
            this.a.f.a(this.a.g, 9, this.a.o);
        }
        return true;
    }
}
