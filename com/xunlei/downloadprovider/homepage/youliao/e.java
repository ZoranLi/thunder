package com.xunlei.downloadprovider.homepage.youliao;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: YouliaoVideoFragment */
final class e extends OnScrollListener {
    final /* synthetic */ YouliaoVideoFragment a;

    e(YouliaoVideoFragment youliaoVideoFragment) {
        this.a = youliaoVideoFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (this.a.e != null) {
            recyclerView = this.a.e;
            if (recyclerView.e == 2 && recyclerView.e != i) {
                recyclerView.a(recyclerView.a, true);
            }
            recyclerView.e = i;
        }
    }
}
