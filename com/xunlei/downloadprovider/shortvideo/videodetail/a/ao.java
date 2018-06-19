package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: RefreshableCommentEmptyViewHolder */
final class ao implements OnClickListener {
    final /* synthetic */ am a;

    ao(am amVar) {
        this.a = amVar;
    }

    public final void onClick(View view) {
        this.a.d.setRotation(0.0f);
        this.a.d.animate().rotation(360.0f).setDuration(500);
        if (this.a.c != null) {
            this.a.c.a(view, 25, null);
        }
    }
}
