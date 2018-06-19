package com.xunlei.downloadprovider.personal.liked;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: LikeShortVideoFragment */
final class l extends OnScrollListener {
    final /* synthetic */ LikeShortVideoFragment a;

    l(LikeShortVideoFragment likeShortVideoFragment) {
        this.a = likeShortVideoFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        this.a.b.b(i);
    }
}
