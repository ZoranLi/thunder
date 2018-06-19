package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.search.a.a;
import com.xunlei.downloadprovider.web.BrowserFrom;

/* compiled from: MultiSearchAdapter */
final class r implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ o b;

    r(o oVar, a aVar) {
        this.b = oVar;
        this.a = aVar;
    }

    public final void onClick(View view) {
        view = new StringBuilder();
        view.append(this.a.b);
        view.append(" ");
        view.append(this.a.m);
        view = view.toString();
        SearchOperateActivity searchOperateActivity = (SearchOperateActivity) this.b.b;
        String str = this.a.b;
        String str2 = this.a.m;
        BrowserFrom browserFrom = BrowserFrom.SEARCH_NOW_THINK;
        if (!k.a.d(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" ");
            stringBuilder.append(str2);
            String stringBuilder2 = stringBuilder.toString();
            XLThreadPool.execute(new be(searchOperateActivity, str, str2));
            str = stringBuilder2;
        }
        searchOperateActivity.a();
        com.xunlei.downloadprovider.web.a.a();
        com.xunlei.downloadprovider.web.a.a(searchOperateActivity, 22, str, true, browserFrom);
        if (this.a.m == null) {
            view = this.a.b;
        }
        com.xunlei.downloadprovider.search.c.a.b("search_think", view, k.a.d(view) ? "website" : "word", "quangwang");
        if (this.a.m == null && k.a.d(this.a.b) != null) {
            XLThreadPool.execute(new s(this));
        }
        com.xunlei.downloadprovider.search.c.a.a("think");
    }
}
