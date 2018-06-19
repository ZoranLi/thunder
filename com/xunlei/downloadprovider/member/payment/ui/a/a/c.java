package com.xunlei.downloadprovider.member.payment.ui.a.a;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: BaseAbsRecyclerAdapter */
final class c implements OnLongClickListener {
    final /* synthetic */ d a;
    final /* synthetic */ a b;

    c(a aVar, d dVar) {
        this.b = aVar;
        this.a = dVar;
    }

    public final boolean onLongClick(View view) {
        view = this.b.g;
        this.a.getLayoutPosition();
        this.b.a();
        return view.a();
    }
}
