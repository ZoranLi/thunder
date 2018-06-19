package com.xunlei.downloadprovider.web.browser.transcode;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.plugin.p;

/* compiled from: BrowserTranscodeDataLoader */
final class e implements c<p> {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        BrothersApplication.getApplicationInstance().getSharedPreferences("transcode_javascript_file_version", 0).edit().putInt("file_version", ((p) obj).b).apply();
    }

    public final void onFail(String str) {
        str = new StringBuilder();
        str.append(this.a.c);
        str.append(" - saveTranscodeDataVersion");
    }
}
