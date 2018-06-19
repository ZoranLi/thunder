package com.xunlei.downloadprovider.web.browser;

/* compiled from: BrowserActivity */
final class m implements Runnable {
    final /* synthetic */ k a;

    m(k kVar) {
        this.a = kVar;
    }

    public final void run() {
        new ab("long_click", this.a.a).a(this.a.a.w, this.a.a.v, this.a.a.E);
    }
}
