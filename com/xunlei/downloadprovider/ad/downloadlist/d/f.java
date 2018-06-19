package com.xunlei.downloadprovider.ad.downloadlist.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: TaskAdCardImageViewHolder */
final class f implements OnClickListener {
    final /* synthetic */ l a;
    final /* synthetic */ d b;

    f(d dVar, l lVar) {
        this.b = dVar;
        this.a = lVar;
    }

    public final void onClick(View view) {
        this.b.b.a(this.a, this.b.c());
        this.b.a = null;
    }
}
