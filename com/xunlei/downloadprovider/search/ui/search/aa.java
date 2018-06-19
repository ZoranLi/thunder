package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.c.a;
import com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.c;
import com.xunlei.downloadprovider.web.BrowserFrom;

/* compiled from: MultiSearchAdapter */
final class aa implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ o b;

    aa(o oVar, c cVar) {
        this.b = oVar;
        this.a = cVar;
    }

    public final void onClick(View view) {
        if (this.a.e == 1) {
            ((SearchOperateActivity) this.b.b).a("search_page_history", this.a.a, 2);
            a.b("search_think_history", this.a.a, "word", "zonghe");
            return;
        }
        o.a(this.b, this.a.a, this.a.c, BrowserFrom.SEARCH_THINK_HISTORY);
        a.b("search_think_history", this.a.a, "word", "quangwang");
    }
}
