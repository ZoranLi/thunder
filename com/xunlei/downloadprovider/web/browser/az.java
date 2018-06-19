package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.search.b.i;

/* compiled from: SearchKeywordUtil */
final class az implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ay b;

    az(ay ayVar, String str) {
        this.b = ayVar;
        this.a = str;
    }

    public final void run() {
        i.a().a(this.a, 0);
    }
}
