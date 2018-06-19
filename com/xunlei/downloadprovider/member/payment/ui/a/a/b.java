package com.xunlei.downloadprovider.member.payment.ui.a.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BaseAbsRecyclerAdapter */
final class b implements OnClickListener {
    final /* synthetic */ d a;
    final /* synthetic */ a b;

    b(a aVar, d dVar) {
        this.b = aVar;
        this.a = dVar;
    }

    public final void onClick(View view) {
        this.b.f.a(this.b, this.a.getLayoutPosition() - this.b.a());
    }
}
