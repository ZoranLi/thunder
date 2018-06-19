package com.xunlei.downloadprovider.ad.recommend.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: RecommendAdPresenter */
final class d implements OnClickListener {
    final /* synthetic */ l a;
    final /* synthetic */ View b;
    final /* synthetic */ int c;
    final /* synthetic */ b d;

    d(b bVar, l lVar, View view, int i) {
        this.d = bVar;
        this.a = lVar;
        this.b = view;
        this.c = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.b(this.a, this.b);
        this.d.c.d();
    }
}
