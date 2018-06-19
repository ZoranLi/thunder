package com.xunlei.downloadprovider.ad.feedvideo;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FeedVideoADItemView */
final class o implements OnClickListener {
    final /* synthetic */ h a;

    o(h hVar) {
        this.a = hVar;
    }

    public final void onClick(View view) {
        this.a.a(this.a.p);
        a.b().b.put(this.a.getMovieId(), Boolean.valueOf(false));
        this.a.q.a();
    }
}
