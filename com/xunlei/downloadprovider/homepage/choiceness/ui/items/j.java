package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: ChoicenessLiveStoryItemView */
final class j extends OnScrollListener {
    final /* synthetic */ ChoicenessLiveStoryItemView a;

    j(ChoicenessLiveStoryItemView choicenessLiveStoryItemView) {
        this.a = choicenessLiveStoryItemView;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        recyclerView = recyclerView.getLayoutManager();
        if (i == 0 && (recyclerView instanceof LinearLayoutManager) != 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView;
            this.a.a(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition(), "slide");
        }
    }
}
