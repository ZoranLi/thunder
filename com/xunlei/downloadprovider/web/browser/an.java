package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.contentpublish.website.a.m;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: BrowserToolBarFragment */
final class an implements Runnable {
    final /* synthetic */ am a;

    an(am amVar) {
        this.a = amVar;
    }

    public final void run() {
        this.a.d.a(true);
        if (m.a().d(this.a.a)) {
            b.a();
            b.a(this.a.d.b.getContext(), this.a.a, this.a.b, this.a.c, "browser_collect_pop");
            return;
        }
        a.a(this.a.d, this.a.d.b.getString(R.string.thunder_browser_favorite_add_success));
    }
}
