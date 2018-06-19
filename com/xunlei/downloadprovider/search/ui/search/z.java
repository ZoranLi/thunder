package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.c.a;
import com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.c;
import com.xunlei.downloadprovider.web.BrowserFrom;

/* compiled from: MultiSearchAdapter */
final class z implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ o b;

    z(o oVar, c cVar) {
        this.b = oVar;
        this.a = cVar;
    }

    public final void onClick(View view) {
        o.a(this.b, this.a.b, "", BrowserFrom.SEARCH_THINK_HISTORY);
        a.b("search_think_history", this.a.b, "website", "quangwang");
    }
}
