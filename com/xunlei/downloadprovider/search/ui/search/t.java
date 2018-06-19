package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.b.i;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.a;

/* compiled from: MultiSearchAdapter */
final class t implements OnClickListener {
    final /* synthetic */ ak a;
    final /* synthetic */ o b;

    t(o oVar, ak akVar) {
        this.b = oVar;
        this.a = akVar;
    }

    public final void onClick(View view) {
        view = this.a.e;
        a.a();
        a.a(this.b.b, 22, view.trim(), false, BrowserFrom.SEARCH_NOW_LINK);
        i.a().a(this.b.c, 1);
        com.xunlei.downloadprovider.search.c.a.a("zhannei_content");
    }
}
