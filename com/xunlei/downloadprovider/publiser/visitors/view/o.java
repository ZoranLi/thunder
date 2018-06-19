package com.xunlei.downloadprovider.publiser.visitors.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.follow.b;

/* compiled from: VisitViewHolder */
final class o implements OnClickListener {
    final /* synthetic */ i a;

    o(i iVar) {
        this.a = iVar;
    }

    public final void onClick(View view) {
        if (b.a().b(this.a.n) != null) {
            i.a(this.a);
        } else {
            i.a(this.a, this.a.n);
        }
    }
}
