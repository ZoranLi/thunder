package com.xunlei.downloadprovider.web.browser.transcode;

/* compiled from: BrowserTranscodeHelper */
final class i implements Runnable {
    final /* synthetic */ com.xunlei.downloadprovider.web.browser.a.i a;
    final /* synthetic */ String b;
    final /* synthetic */ BrowserTranscodeHelper c;

    i(BrowserTranscodeHelper browserTranscodeHelper, com.xunlei.downloadprovider.web.browser.a.i iVar, String str) {
        this.c = browserTranscodeHelper;
        this.a = iVar;
        this.b = str;
    }

    public final void run() {
        this.a.a(this.b);
    }
}
