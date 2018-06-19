package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;

/* compiled from: ChoicenessLiveGroupItemView */
final class c extends OnScrollListener {
    final /* synthetic */ ChoicenessLiveGroupItemView a;

    c(ChoicenessLiveGroupItemView choicenessLiveGroupItemView) {
        this.a = choicenessLiveGroupItemView;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        recyclerView = recyclerView.getLayoutManager();
        if (i == 0 && (recyclerView instanceof LinearLayoutManager) != 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView;
            i = linearLayoutManager.findFirstVisibleItemPosition();
            recyclerView = linearLayoutManager.findLastVisibleItemPosition();
            this.a.e = i;
            this.a.f = recyclerView;
            ChoicenessReporter.a(i, recyclerView, this.a.c);
        }
    }
}
