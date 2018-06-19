package com.xunlei.downloadprovider.web.browser.transcode;

import android.os.Build.VERSION;
import com.xunlei.downloadprovider.web.browser.a.i;
import java.io.PipedOutputStream;

/* compiled from: BrowserTranscodeHelper */
final class k implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ i b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ PipedOutputStream e;
    final /* synthetic */ String f;
    final /* synthetic */ BrowserTranscodeHelper g;

    k(BrowserTranscodeHelper browserTranscodeHelper, int i, i iVar, String str, String str2, PipedOutputStream pipedOutputStream, String str3) {
        this.g = browserTranscodeHelper;
        this.a = i;
        this.b = iVar;
        this.c = str;
        this.d = str2;
        this.e = pipedOutputStream;
        this.f = str3;
    }

    public final void run() {
        new StringBuilder("oldTranscodeRunnable-start:").append(System.currentTimeMillis());
        if (VERSION.SDK_INT >= 19 && BrowserTranscodeHelper.c(this.g) == this.a) {
            i iVar = this.b;
            StringBuilder stringBuilder = new StringBuilder("javascript:");
            stringBuilder.append(BrowserTranscodeHelper.d(this.g).e);
            stringBuilder.append(";\nfilter(\"");
            stringBuilder.append(this.c);
            stringBuilder.append("\",\"");
            stringBuilder.append(this.d);
            stringBuilder.append("\")");
            iVar.a(stringBuilder.toString(), new l(this));
            BrowserTranscodeHelper.e(this.g).schedule(new n(this), 4000);
        }
    }
}
