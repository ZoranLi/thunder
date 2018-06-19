package com.xunlei.downloadprovider.download.taskdetails.items;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DetailShareBarViewHolder */
final class n implements OnClickListener {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
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
