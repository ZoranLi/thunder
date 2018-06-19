package com.xunlei.downloadprovider.web.browser.transcode;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.plugin.p;

/* compiled from: BrowserTranscodeDataLoader */
final class c implements com.xunlei.downloadprovider.member.payment.a.e.c<p> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        if (BrothersApplication.getApplicationInstance().getSharedPreferences("transcode_javascript_file_version", 0).getInt("file_version", 0) == ((p) obj).b) {
            obj = new StringBuilder();
            obj.append(this.a.c);
            obj.append(" - loadTranscodeData");
            this.a.a();
            return;
        }
        this.a.a(true);
    }

    public final void onFail(String str) {
        str = new StringBuilder();
        str.append(this.a.c);
        str.append(" - loadTranscodeData");
    }
}
