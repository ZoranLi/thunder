package com.xunlei.downloadprovider.download.taskdetails;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.xunlei.downloadprovider.download.util.j;

/* compiled from: TaskDetailFragment */
final class ah extends OnScrollListener {
    final /* synthetic */ TaskDetailFragment a;

    ah(TaskDetailFragment taskDetailFragment) {
        this.a = taskDetailFragment;
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        this.a.a(false, false);
        j.a().a = true;
        j.a().b = System.currentTimeMillis();
    }
}
