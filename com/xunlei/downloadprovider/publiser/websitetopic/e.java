package com.xunlei.downloadprovider.publiser.websitetopic;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: WebsiteTopicFragment */
final class e extends OnScrollListener {
    final /* synthetic */ WebsiteTopicFragment a;

    e(WebsiteTopicFragment websiteTopicFragment) {
        this.a = websiteTopicFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition() >= this.a.c.getItemCount() - 1 && WebsiteTopicFragment.b(this.a) != null) {
            WebsiteTopicFragment.c(this.a);
        }
        if (this.a.getUserVisibleHint() != null) {
            recyclerView = this.a.c;
            if (recyclerView.a() && recyclerView.a != i && recyclerView.c != null && recyclerView.c.a == 1) {
                g.b(recyclerView.c);
                new StringBuilder("Scroll stop! ==> ").append(recyclerView.c.b.e);
            }
            recyclerView.a = i;
        }
    }
}
