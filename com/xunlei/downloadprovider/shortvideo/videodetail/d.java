package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CommentDialog */
final class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        this.a.g.setRotation(0.0f);
        this.a.g.animate().rotation(360.0f).setDuration(500);
        if (this.a.i != null) {
            this.a.i.onClick(view);
        }
    }
}
