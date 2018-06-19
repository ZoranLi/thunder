package com.xunlei.downloadprovider.web.website.e;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.website.f.a;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: WebsiteCardItemViewHolder */
public final class f implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ e c;

    public f(e eVar, String str, String str2) {
        this.c = eVar;
        this.a = str;
        this.b = str2;
    }

    public final void onClick(View view) {
        String str;
        view = "history".equals(this.a);
        if (this.c.l == 1003) {
            str = view != null ? "search_web_his" : "search_web_collect";
            view = view != null ? BrowserFrom.SEARCH_WEB_HIS : BrowserFrom.SEARCH_WEB_COLLECT;
        } else if (this.c.l == 1002) {
            str = view != null ? "dl_center_his" : "dl_center_collect";
            view = view != null ? BrowserFrom.DL_CENTER_HIS : BrowserFrom.DL_CENTER_COLLECT;
        } else {
            str = view != null ? "browser_his" : "browser_collect";
            view = view != null ? BrowserFrom.BROWSER_HIS : BrowserFrom.BROWSER_COLLECT;
        }
        a.a(str, this.b, this.c.k.getVisibility() == 0);
        if (this.c.k.getVisibility() == 0) {
            this.c.k.setVisibility(8);
            b.a();
            b.c(this.b);
        }
        com.xunlei.downloadprovider.web.a.a();
        com.xunlei.downloadprovider.web.a.a(this.c.m, this.b, false, view);
    }
}
