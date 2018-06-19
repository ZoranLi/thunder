package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.d.a;

public class BaiduHybridAdManager {
    IOAdEventListener a = new e(this);
    private BaiduHybridAdViewListener b = new d(this);
    private a c;
    private WebView d;
    private boolean e = false;

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.b = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.d = webView;
            this.c = new a(this.d);
            this.c.addEventListener(IXAdEvent.AD_LOADED, this.a);
            this.c.addEventListener(IXAdEvent.AD_ERROR, this.a);
            this.c.addEventListener(IXAdEvent.AD_STARTED, this.a);
            this.c.addEventListener("AdUserClick", this.a);
            this.c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.a);
            this.c.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = null;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!(this.e || this.c == null)) {
            this.c.a(webView, str);
        }
        try {
            if ("mobadssdk".equals(Uri.parse(str).getScheme()) != null) {
                return true;
            }
        } catch (WebView webView2) {
            System.err.println(webView2);
        }
        return null;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.e = true;
    }
}
