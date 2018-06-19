package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BaseCommentViewHolder */
final class h implements OnClickListener {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            view = this.a.a;
            this.a.e;
            view.a(3, this.a.b, false);
        }
    }
}
