package com.xunlei.downloadprovider.homepage.cinecism;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xunlei.xllib.android.b;

/* compiled from: CinecismDetailActivity */
final class m extends WebViewClient {
    final /* synthetic */ CinecismDetailActivity a;

    m(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.equals("http://m.sjzhushou.com/404")) {
            if (this.a.p != null) {
                this.a.p.b();
            }
            this.a.a(404);
        } else {
            webView.loadUrl(str);
        }
        return true;
    }

    public final void onPageFinished(WebView webView, String str) {
        CinecismDetailActivity.a;
        super.onPageFinished(webView, str);
        if (b.a(this.a) != null) {
            if ("data:text/html,chromewebdata".equalsIgnoreCase(str) == null) {
                if ("http://m.sjzhushou.com/404".equals(str) == null) {
                    if ("http://m.sjzhushou.com/h5/page/common/404.html".equals(str) == null) {
                        if (this.a.r == null) {
                            this.a.s = 2;
                            CinecismDetailActivity.c(this.a);
                            CinecismDetailActivity.d(this.a);
                            this.a.u = System.currentTimeMillis();
                        }
                        return;
                    }
                }
                this.a.a(404);
                return;
            }
        }
        this.a.a(-1);
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        CinecismDetailActivity.a;
        webView.stopLoading();
        this.a.r = true;
        this.a.a(i);
    }
}
