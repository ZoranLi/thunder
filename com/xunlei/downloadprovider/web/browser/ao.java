package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.R;

/* compiled from: BrowserToolBarFragment */
final class ao implements Runnable {
    final /* synthetic */ am a;

    ao(am amVar) {
        this.a = amVar;
    }

    public final void run() {
        a.a(this.a.d, this.a.d.b.getString(R.string.thunder_browser_favorite_operate_already));
    }
}
