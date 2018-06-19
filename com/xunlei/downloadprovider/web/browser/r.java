package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.web.website.g.b$a;

/* compiled from: BrowserActivity */
final class r implements b$a {
    final /* synthetic */ BrowserActivity a;

    public final void b() {
    }

    r(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void a() {
        this.a.runOnUiThread(new s(this.a));
    }
}
