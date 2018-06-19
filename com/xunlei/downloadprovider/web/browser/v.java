package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.web.website.g.b$c;

/* compiled from: BrowserActivity */
final class v implements b$c {
    final /* synthetic */ BrowserActivity a;

    v(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void a(boolean z) {
        this.a.runOnUiThread(new w(this, z));
    }
}
