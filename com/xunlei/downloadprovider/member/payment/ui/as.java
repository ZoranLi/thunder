package com.xunlei.downloadprovider.member.payment.ui;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xunlei.downloadprovider.web.a;

/* compiled from: PaymentSuccessActivity */
final class as extends WebViewClient {
    final /* synthetic */ PaymentSuccessActivity a;

    as(PaymentSuccessActivity paymentSuccessActivity) {
        this.a = paymentSuccessActivity;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.a.a.getWebView().getOriginalUrl().equals(str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        a.a();
        a.a(this.a, str, "", "");
        return true;
    }
}
