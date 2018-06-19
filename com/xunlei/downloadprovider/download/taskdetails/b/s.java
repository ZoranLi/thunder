package com.xunlei.downloadprovider.download.taskdetails.b;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: TaskCommentController */
final class s extends OnScrollListener {
    final /* synthetic */ b a;

    s(b bVar) {
        this.a = bVar;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (!(this.a.q == 0 || this.a.r == 0)) {
            if (this.a.o) {
                if (i == 0 && ((LinearLayoutManager) this.a.a.getLayoutManager()).findLastVisibleItemPosition() >= this.a.j.a() - 2) {
                    b.j(this.a);
                }
                recyclerView = recyclerView.getLayoutManager();
                if ((recyclerView instanceof LinearLayoutManager) != 0) {
                    ((LinearLayoutManager) recyclerView).findLastVisibleItemPosition();
                    b.f;
                }
            }
        }
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
    }
}
