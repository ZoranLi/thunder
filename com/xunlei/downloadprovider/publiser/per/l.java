package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: HistoryCommentCinecismViewHolder */
final class l implements OnLongClickListener {
    final /* synthetic */ h a;

    l(h hVar) {
        this.a = hVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.g != null) {
            this.a.g.a(15, this.a.f);
        }
        return true;
    }
}
