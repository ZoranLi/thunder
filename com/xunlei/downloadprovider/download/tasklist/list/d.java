package com.xunlei.downloadprovider.download.tasklist.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: TaskListAdapter */
public final class d extends OnScrollListener {
    final /* synthetic */ a a;

    public d(a aVar) {
        this.a = aVar;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        this.a.b(i);
    }
}
