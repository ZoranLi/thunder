package com.alibaba.baichuan.android.trade;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.android.trade.b.a;
import com.alibaba.baichuan.android.trade.callback.b;

final class c implements b {
    final /* synthetic */ com.alibaba.baichuan.android.trade.g.b a;
    final /* synthetic */ Activity b;
    final /* synthetic */ WebView c;
    final /* synthetic */ WebViewClient d;
    final /* synthetic */ WebChromeClient e;
    final /* synthetic */ a f;
    final /* synthetic */ com.alibaba.baichuan.android.trade.model.a g;

    c(com.alibaba.baichuan.android.trade.g.b bVar, Activity activity, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, a aVar, com.alibaba.baichuan.android.trade.model.a aVar2) {
        this.a = bVar;
        this.b = activity;
        this.c = webView;
        this.d = webViewClient;
        this.e = webChromeClient;
        this.f = aVar;
        this.g = aVar2;
    }

    public final void a(String str) {
        String c = this.a.c();
        if (str == null || TextUtils.isEmpty(str)) {
            str = c;
        }
        a.b(this.b, this.c, this.d, this.e, this.a.a(str, a.d, this.f), this.a, this.f);
    }
}
