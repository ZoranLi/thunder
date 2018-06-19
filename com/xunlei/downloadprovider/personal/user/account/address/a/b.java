package com.xunlei.downloadprovider.personal.user.account.address.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: RecyclerAbsAdapter */
final class b implements OnClickListener {
    final /* synthetic */ d a;
    final /* synthetic */ a b;

    b(a aVar, d dVar) {
        this.b = aVar;
        this.a = dVar;
    }

    public final void onClick(View view) {
        this.b.d.a(view, this.a.getLayoutPosition() - this.b.c());
    }
}
