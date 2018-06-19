package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: BaseRecyViewFragment */
final class f extends OnScrollListener {
    final /* synthetic */ BaseRecyViewFragment a;

    f(BaseRecyViewFragment baseRecyViewFragment) {
        this.a = baseRecyViewFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.a.d != null) {
            this.a.d.b(i);
        }
        if (((LinearLayoutManager) this.a.c.getLayoutManager()).findLastVisibleItemPosition() >= this.a.d.getItemCount() - 2 && this.a.l() != null) {
            this.a.i();
        }
    }
}
