package com.xunlei.downloadprovider.search.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.c.a;
import com.xunlei.downloadprovider.search.ui.search.SearchOperateActivity;
import com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.c;

/* compiled from: SearchHistoryListView */
final class k implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    k(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final void onClick(View view) {
        a.b("search_page_history", this.a.b, "website", "quangwang");
        ((SearchOperateActivity) this.b.b.getContext()).a("search_page_history", this.a.b, 2);
    }
}
