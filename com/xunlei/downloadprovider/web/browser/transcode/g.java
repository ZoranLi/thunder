package com.xunlei.downloadprovider.web.browser.transcode;

/* compiled from: BrowserTranscodeHelper */
final class g implements Runnable {
    final /* synthetic */ BrowserTranscodeHelper a;

    g(BrowserTranscodeHelper browserTranscodeHelper) {
        this.a = browserTranscodeHelper;
    }

    public final void run() {
        BrowserTranscodeHelper.b(this.a).disconnect();
    }
}
