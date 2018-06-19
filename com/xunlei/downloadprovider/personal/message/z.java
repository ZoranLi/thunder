package com.xunlei.downloadprovider.personal.message;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: MessageItemFragment */
final class z extends OnScrollListener {
    final /* synthetic */ MessageItemFragment a;

    z(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (!(this.a.m == null || this.a.n == null)) {
            if (this.a.k != null) {
                if (i == 0 && ((LinearLayoutManager) this.a.e.getLayoutManager()).findLastVisibleItemPosition() >= this.a.f.getItemCount() - 2) {
                    MessageItemFragment.k(this.a);
                }
            }
        }
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
    }
}
