package com.alibaba.sdk.android.feedback.xblink.webview;

import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.i.g;

class b extends a {
    final /* synthetic */ HybridPlusWebView d;

    private b(HybridPlusWebView hybridPlusWebView) {
        this.d = hybridPlusWebView;
    }

    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"htmlFinsh".equals(str)) {
            return false;
        }
        this.d.mHandler.sendEmptyMessage(1016);
        if (g.a()) {
            StringBuilder stringBuilder = new StringBuilder("dom ready time:");
            stringBuilder.append(System.currentTimeMillis() - this.d.beginTime);
            g.c("HybridPlusWebView", stringBuilder.toString());
        }
        return true;
    }
}
