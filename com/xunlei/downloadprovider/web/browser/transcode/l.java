package com.xunlei.downloadprovider.web.browser.transcode;

import com.tencent.smtt.sdk.ValueCallback;
import com.xunlei.common.concurrent.XLThreadPool;

/* compiled from: BrowserTranscodeHelper */
final class l implements ValueCallback<String> {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (str == null || str.equals("null")) {
            BrowserTranscodeHelper.a(this.a.g, this.a.b, this.a.d, this.a.e, this.a.a);
        } else {
            XLThreadPool.execute(new m(this, str));
        }
    }
}
