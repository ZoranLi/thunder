package com.xunlei.downloadprovider.ad.downloadlist.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: TaskAdCardImageViewHolder */
final class e implements OnClickListener {
    final /* synthetic */ l a;
    final /* synthetic */ d b;

    e(d dVar, l lVar) {
        this.b = dVar;
        this.a = lVar;
    }

    public final void onClick(View view) {
        view = this.b.b;
        l lVar = this.a;
        this.b.c();
        c.a(lVar, this.b.c);
    }
}
