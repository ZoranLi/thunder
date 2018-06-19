package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: TaskCommentItemViewHolder */
final class ay implements OnLongClickListener {
    final /* synthetic */ ar a;

    ay(ar arVar) {
        this.a = arVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.f != null) {
            this.a.f.a(this.a.g, 9, this.a.s);
        }
        return true;
    }
}
