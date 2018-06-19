package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.a.a;
import com.xunlei.downloadprovider.web.BrowserFrom;

/* compiled from: SearchAssociativeAdapter */
final class am implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ al b;

    am(al alVar, a aVar) {
        this.b = alVar;
        this.a = aVar;
    }

    public final void onClick(View view) {
        al.a(this.b, this.a.p.a(), "", BrowserFrom.SEARCH_THINK_COLLECT);
        com.xunlei.downloadprovider.search.c.a.b("search_think_collect", this.a.p.a(), "website", "quangwang");
    }
}
