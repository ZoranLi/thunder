package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.a.a;
import com.xunlei.downloadprovider.web.BrowserFrom;

/* compiled from: MultiSearchAdapter */
final class y implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ o b;

    y(o oVar, a aVar) {
        this.b = oVar;
        this.a = aVar;
    }

    public final void onClick(View view) {
        o.a(this.b, this.a.p.a(), "", BrowserFrom.SEARCH_THINK_COLLECT);
        com.xunlei.downloadprovider.search.c.a.b("search_think_collect", this.a.p.a(), "website", "quangwang");
    }
}
