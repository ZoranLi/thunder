package com.xunlei.downloadprovider.web.base.core;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import anet.channel.util.HttpConstant;
import com.xunlei.downloadprovider.download.create.ad;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.launch.dispatch.e;
import com.xunlei.downloadprovider.web.base.core.CustomWebView.b;
import com.xunlei.xllib.android.XLIntent;
import java.net.URISyntaxException;

/* compiled from: CustomWebView */
final class f extends h {
    final /* synthetic */ CustomWebView a;

    f(CustomWebView customWebView) {
        this.a = customWebView;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("weixin://wap/pay?")) {
            Intent xLIntent = new XLIntent();
            xLIntent.setAction("android.intent.action.VIEW");
            xLIntent.setData(Uri.parse(str));
            try {
                this.a.getContext().startActivity(xLIntent);
                return true;
            } catch (ActivityNotFoundException e) {
                new StringBuilder("ActivityNotFoundException: ").append(e.getLocalizedMessage());
                return super.shouldOverrideUrlLoading(webView, str);
            }
        } else if (a(str)) {
            return true;
        } else {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.a.m = false;
        this.a.g = str;
        webView.getSettings().setBlockNetworkImage(true);
        if (this.a.e != null) {
            for (b a : this.a.e) {
                a.a(webView);
            }
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (!this.a.m) {
            this.a.a(true);
        }
        if (!com.xunlei.xllib.android.b.a(this.a.getContext()) || "data:text/html,chromewebdata".equalsIgnoreCase(str)) {
            this.a.b();
        }
        webView.getSettings().setBlockNetworkImage(false);
        if (this.a.e != null) {
            for (b a : this.a.e) {
                a.a();
            }
        }
        super.onPageFinished(webView, str);
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.a.m == null) {
            this.a.a(true);
        }
        webView.stopLoading();
        this.a.j();
        if (com.xunlei.xllib.android.b.a(this.a.getContext()) == null) {
            this.a.a.setErrorType(2);
        } else if (i == 404) {
            this.a.a.setErrorType(1);
        }
        this.a.b();
    }

    private boolean a(String str) {
        String toLowerCase = str.toLowerCase();
        if (b(str)) {
            return true;
        }
        if (!(toLowerCase.startsWith(HttpConstant.HTTP) || toLowerCase.startsWith("https"))) {
            if (!toLowerCase.startsWith("ftp")) {
                if (this.a.q != null) {
                    this.a.q.a(str);
                }
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    parseUri.setComponent(null);
                    try {
                        this.a.getContext().startActivity(parseUri);
                        return true;
                    } catch (ActivityNotFoundException e) {
                        new StringBuilder("ActivityNotFoundException: ").append(e.getLocalizedMessage());
                        if (this.a.q != null) {
                            this.a.q.a(str, -1001);
                        }
                        return false;
                    }
                } catch (URISyntaxException e2) {
                    new StringBuilder("URISyntaxException: ").append(e2.getLocalizedMessage());
                    if (this.a.q != null) {
                        this.a.q.a(str, -1000);
                    }
                    return false;
                }
            }
        }
        return false;
    }

    private boolean b(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            z = false;
        } else {
            z = str.startsWith("thunder://");
        }
        if (!(z || k.g(str))) {
            z = (TextUtils.isEmpty(str) || !str.startsWith("ftp://") || str.endsWith("/")) ? false : true;
            if (!z) {
                if (!str.startsWith("xunleiapp://xunlei.com/sharePage")) {
                    return false;
                }
                try {
                    str = Uri.parse(str);
                } catch (String str2) {
                    str2.printStackTrace();
                    str2 = null;
                }
                if (str2 == null) {
                    return true;
                }
                ad adVar = new ad();
                e.a(str2, adVar, "browser/thunder");
                str2 = adVar.a();
                if (!TextUtils.isEmpty(str2)) {
                    CustomWebView.a(this.a, str2, adVar.c(), this.a.getUrl(), adVar.c("manual/share_h5"));
                }
                return true;
            }
        }
        CustomWebView.a(this.a, str2, null, null, null);
        return true;
    }
}
