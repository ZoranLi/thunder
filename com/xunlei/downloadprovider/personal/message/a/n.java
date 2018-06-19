package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BaseLikeViewHolder */
final class n implements OnClickListener {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            view = this.a.a;
            this.a.e;
            view.a(3, this.a.b, false);
        }
    }
}
