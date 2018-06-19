package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;

class be extends X5ProxyWebViewClientExtension {
    final /* synthetic */ WebView a;

    be(WebView webView, IX5WebViewClientExtension iX5WebViewClientExtension) {
        this.a = webView;
        super(iX5WebViewClientExtension);
    }

    public void invalidate() {
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.a.onScrollChanged(i3, i4, i, i2);
    }
}
