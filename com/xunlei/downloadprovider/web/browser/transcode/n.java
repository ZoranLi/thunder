package com.xunlei.downloadprovider.web.browser.transcode;

import java.util.TimerTask;

/* compiled from: BrowserTranscodeHelper */
final class n extends TimerTask {
    final /* synthetic */ k a;

    n(k kVar) {
        this.a = kVar;
    }

    public final void run() {
        BrowserTranscodeHelper.a(this.a.g, this.a.b, this.a.d, this.a.e, this.a.a);
    }
}
