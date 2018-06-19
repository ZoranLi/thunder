package com.xunlei.downloadprovider.web.browser.transcode;

import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.xunlei.downloadprovider.web.browser.a.i;
import java.io.InputStream;
import java.io.PipedOutputStream;

/* compiled from: BrowserTranscodeHelper */
final class h implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ String b;
    final /* synthetic */ PipedOutputStream c;
    final /* synthetic */ WebResourceResponse d;
    final /* synthetic */ InputStream e;
    final /* synthetic */ int f;
    final /* synthetic */ BrowserTranscodeHelper g;

    h(BrowserTranscodeHelper browserTranscodeHelper, i iVar, String str, PipedOutputStream pipedOutputStream, WebResourceResponse webResourceResponse, InputStream inputStream, int i) {
        this.g = browserTranscodeHelper;
        this.a = iVar;
        this.b = str;
        this.c = pipedOutputStream;
        this.d = webResourceResponse;
        this.e = inputStream;
        this.f = i;
    }

    public final void run() {
        BrowserTranscodeHelper.a(this.g, this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
