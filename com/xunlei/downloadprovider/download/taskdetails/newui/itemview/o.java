package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DetailShareBarViewHolder_New */
final class o implements OnClickListener {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final void onClick(View view) {
        if (this.a.f != null && this.a.a != null) {
            view = this.a.f.b();
            if (view != null) {
                view.a(this.a.a);
            }
        }
    }
}
