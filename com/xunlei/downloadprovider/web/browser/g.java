package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.search.b.i;

/* compiled from: BrowserActivity */
final class g implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ BrowserActivity b;

    g(BrowserActivity browserActivity, String str) {
        this.b = browserActivity;
        this.a = str;
    }

    public final void run() {
        i.a().a(this.a, 0);
    }
}
