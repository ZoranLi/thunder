package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.d.m;

/* compiled from: BrowserActivity */
final class l implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ k b;

    l(k kVar, String str) {
        this.b = kVar;
        this.a = str;
    }

    public final void run() {
        BrowserActivity browserActivity = this.b.a;
        m.a();
        browserActivity.a(m.d(this.a));
    }
}
