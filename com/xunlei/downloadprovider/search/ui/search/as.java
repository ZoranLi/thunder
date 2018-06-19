package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.a;
import java.util.List;

/* compiled from: SearchContentFragment */
final class as implements a {
    final /* synthetic */ SearchContentFragment a;

    as(SearchContentFragment searchContentFragment) {
        this.a = searchContentFragment;
    }

    public final void a() {
        this.a.c = this.a.c | 1;
        SearchContentFragment.b(this.a);
        SearchContentFragment.class.getSimpleName();
    }

    public final void b() {
        this.a.c = this.a.c & false;
        this.a.a.setVisibility(0);
        SearchContentFragment.b(this.a);
        SearchContentFragment.class.getSimpleName();
    }

    public final void c() {
        List b = bq.a().b();
        if (b == null || b.size() <= 0) {
            SearchContentFragment searchContentFragment = this.a;
            searchContentFragment.c = searchContentFragment.c | 1;
            SearchContentFragment.b(this.a);
            SearchContentFragment.class.getSimpleName();
        }
    }
}
