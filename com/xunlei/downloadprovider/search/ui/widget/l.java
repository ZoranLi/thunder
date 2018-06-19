package com.xunlei.downloadprovider.search.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.c.a;
import com.xunlei.downloadprovider.search.ui.search.SearchOperateActivity;
import com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.c;

/* compiled from: SearchHistoryListView */
final class l implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    l(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final void onClick(View view) {
        if (this.a.e == 1) {
            a.b("search_page_history", this.a.a, "word", "zonghe");
            ((SearchOperateActivity) this.b.b.getContext()).a("search_page_history", this.a.a, 2);
            return;
        }
        b.a(this.b, this.a.a, this.a.c);
        a.b("search_page_history", this.a.a, "word", "quangwang");
    }
}
