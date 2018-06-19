package com.alibaba.baichuan.android.trade.d;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.b.a;
import com.alibaba.baichuan.android.trade.c.b.d;
import java.util.Map;

public final class c implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ a b;
    final /* synthetic */ WebView c;
    final /* synthetic */ Map d;
    final /* synthetic */ WebViewClient e;
    final /* synthetic */ WebChromeClient f;
    final /* synthetic */ String g;
    final /* synthetic */ Map h;
    final /* synthetic */ a i;

    public c(a aVar, Activity activity, a aVar2, WebView webView, Map map, WebViewClient webViewClient, WebChromeClient webChromeClient, String str, Map map2) {
        this.i = aVar;
        this.a = activity;
        this.b = aVar2;
        this.c = webView;
        this.d = map;
        this.e = webViewClient;
        this.f = webChromeClient;
        this.g = str;
        this.h = map2;
    }

    public final void run() {
        d dVar = new d(this.a, this.b, this.c, this.d, this.e, this.f, true);
        a.b;
        new StringBuilder("第三方 WebView首次加载的url=").append(this.g);
        AlibcContext.b();
        String str;
        if (this.h != null) {
            str = this.g;
            Map map = this.h;
            if (dVar.a != null) {
                dVar.a.loadUrl(str, map);
                return;
            }
        }
        str = this.g;
        if (dVar.a != null) {
            dVar.a.loadUrl(str);
        }
    }
}
