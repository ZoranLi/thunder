package com.xunlei.downloadprovider.web.website.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: WebsiteMoreOperationDialog */
final class j implements OnClickListener {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final void onClick(View view) {
        if (this.a.b == "collect") {
            view = this.a.c == 1002 ? "dl_center_collect" : this.a.c == 1003 ? "search_web_collect" : "browser_collect";
            b.a().a(this.a.a.a(), view, "press", new k(this));
            return;
        }
        if (this.a.b == "history") {
            b.a().a(this.a.a.a(), new m(this));
            this.a.dismiss();
        }
    }
}
