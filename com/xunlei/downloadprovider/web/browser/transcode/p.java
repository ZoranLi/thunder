package com.xunlei.downloadprovider.web.browser.transcode;

import com.xunlei.downloadprovider.web.browser.a.i;

/* compiled from: BrowserTranscodeHelper */
final class p implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ i b;
    final /* synthetic */ String c;
    final /* synthetic */ BrowserTranscodeHelper d;

    p(BrowserTranscodeHelper browserTranscodeHelper, int i, i iVar, String str) {
        this.d = browserTranscodeHelper;
        this.a = i;
        this.b = iVar;
        this.c = str;
    }

    public final void run() {
        if (BrowserTranscodeHelper.c(this.d) == this.a) {
            this.d.shouldOverrideUrlLoadingForTranscode(this.b, this.c, false);
        }
    }
}
