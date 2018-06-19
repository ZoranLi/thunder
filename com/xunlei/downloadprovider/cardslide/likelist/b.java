package com.xunlei.downloadprovider.cardslide.likelist;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: CardSlideLikeActivity */
final class b extends OnScrollListener {
    final /* synthetic */ CardSlideLikeActivity a;

    b(CardSlideLikeActivity cardSlideLikeActivity) {
        this.a = cardSlideLikeActivity;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0 && ((LinearLayoutManager) this.a.c.getLayoutManager()).findLastVisibleItemPosition() >= this.a.d.getItemCount() - 2) {
            this.a.b("startKey");
        }
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
    }
}
