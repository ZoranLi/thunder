package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.c.a;
import com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.c;
import com.xunlei.downloadprovider.web.BrowserFrom;

/* compiled from: SearchAssociativeAdapter */
final class an implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ al b;

    an(al alVar, c cVar) {
        this.b = alVar;
        this.a = cVar;
    }

    public final void onClick(View view) {
        al.a(this.b, this.a.b, "", BrowserFrom.SEARCH_THINK_HISTORY);
        a.b("search_think_history", this.a.b, "website", "quangwang");
    }
}
