package com.xunlei.downloadprovider.xlui.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: RecycleViewScrollHelper */
public final class h {
    public XRecyclerView a;
    public LinearLayoutManager b;
    public boolean c;
    public int d = -1;

    /* compiled from: RecycleViewScrollHelper */
    private class a extends OnScrollListener {
        final /* synthetic */ h a;

        private a(h hVar) {
            this.a = hVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (this.a.c != null) {
                this.a.c = false;
                recyclerView = this.a.d - this.a.b.findFirstVisibleItemPosition();
                if (recyclerView >= null && recyclerView < this.a.b.getChildCount()) {
                    this.a.a.scrollBy(0, this.a.b.getChildAt(recyclerView).getTop());
                }
            }
        }
    }

    public h(XRecyclerView xRecyclerView, LinearLayoutManager linearLayoutManager) {
        this.a = xRecyclerView;
        this.b = linearLayoutManager;
        this.a.addOnScrollListener(new a());
    }
}
