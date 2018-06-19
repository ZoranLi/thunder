package com.xunlei.downloadprovider.web.browser.transcode;

import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.plugin.q.a;

/* compiled from: BrowserTranscodeDataLoader */
final class d implements a {
    final /* synthetic */ boolean a;
    final /* synthetic */ b b;

    public final void onPluginProgressUpdate(int i) {
    }

    d(b bVar, boolean z) {
        this.b = bVar;
        this.a = z;
    }

    public final void onPluginPrepared() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.c);
        stringBuilder.append(" - downloadTranscodeData");
        q.a().a("com.xunlei.plugin.transcode", new e(this.b));
        b.a(this.b, this.a);
    }

    public final void onPluginFail(int i) {
        i = new StringBuilder();
        i.append(this.b.c);
        i.append(" - downloadTranscodeData");
    }
}
