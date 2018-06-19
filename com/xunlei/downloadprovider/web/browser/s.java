package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: BrowserActivity */
final class s implements Runnable {
    final /* synthetic */ BrowserActivity a;

    s(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void run() {
        this.a.b(true);
        b.a();
        b.a(this.a, this.a.m.g(), this.a.D, this.a.E, "dlcenter_create_pop");
    }
}
