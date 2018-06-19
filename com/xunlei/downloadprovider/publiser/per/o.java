package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: HistoryCommentWebsiteViewHolder */
final class o implements OnLongClickListener {
    final /* synthetic */ m a;

    o(m mVar) {
        this.a = mVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.j != null) {
            this.a.j.a(12, this.a.g);
        }
        return true;
    }
}
