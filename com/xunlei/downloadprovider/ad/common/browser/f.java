package com.xunlei.downloadprovider.ad.common.browser;

import android.webkit.WebView;
import com.xunlei.downloadprovider.web.base.core.CustomWebView.b;

/* compiled from: WebViewToutiaoActivity */
final class f implements b {
    final /* synthetic */ WebViewToutiaoActivity a;

    public final void a() {
    }

    f(WebViewToutiaoActivity webViewToutiaoActivity) {
        this.a = webViewToutiaoActivity;
    }

    public final void a(WebView webView) {
        webView.getSettings().setBlockNetworkImage(false);
    }
}
