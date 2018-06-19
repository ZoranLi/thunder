package com.alibaba.baichuan.android.trade.c.b;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.ut.e;
import com.alibaba.baichuan.android.trade.adapter.ut.performance.Point4UrlLoad;
import com.alibaba.baichuan.android.trade.b.b;
import com.alibaba.baichuan.android.trade.utils.g.a;
import com.alibaba.baichuan.android.trade.utils.l;
import com.alibaba.baichuan.android.trade.utils.m;
import org.android.agoo.common.AgooConstants;

public class f extends WebViewClient {
    private static final String a = "f";
    private boolean b = true;
    private boolean c = false;
    private b d = new b();

    public f(d dVar) {
        this.d.b = dVar;
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.b) {
            e.a((String) this.d.b.b.get("u_label"));
            this.d.b.c.b("urlLoadTime");
            this.d.b.c.b("allTime");
            e.a(this.d.b.c.b);
            this.b = false;
        } else if (this.c) {
            this.c = false;
        } else if (this.d.a != null) {
            this.d.a.timeEnd("urlLoadTime");
            this.d.a.timeEnd("allTime");
            e.a(this.d.a);
            this.d.a = null;
        }
        super.onPageFinished(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.b) {
            e.a((String) this.d.b.b.get("u_label"), "加载失败", String.valueOf(i));
            a.b();
            this.b = false;
        }
        this.c = true;
        super.onReceivedError(webView, i, str, str2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.b) {
            this.d.a = new Point4UrlLoad();
            this.d.a.timeBegin("allTime");
        }
        WebView webView2 = this.d.b.a;
        if (!(webView2 == null || m.a(str))) {
            webView2.setTag(l.a(AlibcContext.a, AgooConstants.MESSAGE_ID, "com_taobao_nb_sdk_webview_click"), Boolean.valueOf(false));
        }
        com.alibaba.baichuan.android.trade.ui.a.a.a();
        return com.alibaba.baichuan.android.trade.ui.a.a.a(this.d, webView, str);
    }
}
