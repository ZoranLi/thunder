package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.R;

/* compiled from: BrowserToolBarFragment */
final class aq implements Runnable {
    final /* synthetic */ ap a;

    aq(ap apVar) {
        this.a = apVar;
    }

    public final void run() {
        a.a(this.a.b, this.a.b.b.getString(R.string.thunder_browser_favorite_remove_success));
        this.a.b.a(this.a.a);
    }
}
