package com.xunlei.downloadprovider.personal.liked;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: LikeCinecismFragment */
final class b extends OnScrollListener {
    final /* synthetic */ LikeCinecismFragment a;

    b(LikeCinecismFragment likeCinecismFragment) {
        this.a = likeCinecismFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        this.a.a.b(i);
    }
}
