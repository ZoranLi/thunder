package com.xunlei.downloadprovider.homepage.photoarticle.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xunlei.xllib.android.b;

/* compiled from: ArticleWebViewHolder */
final class c extends WebViewClient {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (str.equals(this.a.b)) {
            webView.loadUrl(str);
        } else {
            str.indexOf("xunleiapp://xunlei.com/photoArticle");
        }
        return true;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        webView.getSettings().setBlockNetworkImage(true);
    }

    public final void onPageFinished(WebView webView, String str) {
        if (this.a.itemView != null) {
            if (b.a(this.a.itemView.getContext())) {
                if (!"data:text/html,chromewebdata".equalsIgnoreCase(str)) {
                    if (this.a.c != null) {
                        this.a.c.a();
                    }
                    webView.getSettings().setBlockNetworkImage(false);
                    super.onPageFinished(webView, str);
                }
            }
            if (this.a.c != null) {
                this.a.c.a(-1);
            }
            webView.getSettings().setBlockNetworkImage(false);
            super.onPageFinished(webView, str);
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        webView.stopLoading();
        if (this.a.c != null) {
            this.a.c.a(i);
        }
    }
}
