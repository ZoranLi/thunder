package com.xunlei.downloadprovider.web.browser.transcode;

import com.xunlei.downloadprovider.web.browser.a.i;

/* compiled from: BrowserTranscodeHelper */
final class j implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ BrowserTranscodeHelper b;

    j(BrowserTranscodeHelper browserTranscodeHelper, i iVar) {
        this.b = browserTranscodeHelper;
        this.a = iVar;
    }

    public final void run() {
        this.a.a();
    }
}
