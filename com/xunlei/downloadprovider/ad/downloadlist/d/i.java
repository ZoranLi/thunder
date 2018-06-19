package com.xunlei.downloadprovider.ad.downloadlist.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: TaskAdCardViewHolder */
final class i implements OnClickListener {
    final /* synthetic */ l a;
    final /* synthetic */ g b;

    i(g gVar, l lVar) {
        this.b = gVar;
        this.a = lVar;
    }

    public final void onClick(View view) {
        this.b.b.a(this.a, this.b.c());
        this.b.a = null;
    }
}
