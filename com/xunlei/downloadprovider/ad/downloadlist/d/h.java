package com.xunlei.downloadprovider.ad.downloadlist.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: TaskAdCardViewHolder */
final class h implements OnClickListener {
    final /* synthetic */ l a;
    final /* synthetic */ g b;

    h(g gVar, l lVar) {
        this.b = gVar;
        this.a = lVar;
    }

    public final void onClick(View view) {
        view = this.b.b;
        l lVar = this.a;
        this.b.c();
        c.a(lVar, this.b.c);
    }
}
