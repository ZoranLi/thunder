package com.xunlei.downloadprovider.ad.recommend.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: RecommendAdViewHolder */
final class f implements OnClickListener {
    final /* synthetic */ l a;
    final /* synthetic */ BaseRecommendAdItemView b;
    final /* synthetic */ int c;
    final /* synthetic */ c d;

    f(c cVar, l lVar, BaseRecommendAdItemView baseRecommendAdItemView, int i) {
        this.d = cVar;
        this.a = lVar;
        this.b = baseRecommendAdItemView;
        this.c = i;
    }

    public final void onClick(View view) {
        this.d.q.a(this.a, this.b, this.c);
    }
}
