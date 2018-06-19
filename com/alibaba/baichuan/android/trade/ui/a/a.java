package com.alibaba.baichuan.android.trade.ui.a;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.b.b;
import com.alibaba.baichuan.android.trade.c.a.a.e;
import java.util.HashMap;

public class a {
    private static final String a = "a";

    private static class a {
        private static final a a = new a();
    }

    private a() {
    }

    public static a a() {
        return a.a;
    }

    public static boolean a(b bVar, WebView webView, String str) {
        AlibcContext.b();
        AlibcContext.b();
        if (webView == null) {
            return false;
        }
        if (bVar.a != null) {
            bVar.a.timeBegin("urlHandleTime");
        }
        com.alibaba.baichuan.android.trade.c.a.a.c.a aVar = new com.alibaba.baichuan.android.trade.c.a.a.c.a();
        aVar.g = (Activity) webView.getContext();
        aVar.a = webView;
        aVar.d = str;
        aVar.b = bVar.b;
        if (!"true".equals(bVar.b.b.get("show_by_h5"))) {
            aVar.f = "noForceH5";
        }
        aVar.e = 2;
        aVar.i = new HashMap();
        if (bVar.b.c() != null) {
            aVar.i.put("ui_contextParams", bVar.b.c());
        }
        com.alibaba.baichuan.android.trade.c.a.a.b b = e.a().b(aVar);
        if (b.a) {
            bVar.a = null;
            if (webView.getUrl().matches(AlibcContext.m) != null) {
                ((Activity) webView.getContext()).finish();
            }
            return true;
        }
        Object obj = b.b;
        if (bVar.a != null) {
            bVar.a.timeEnd("urlHandleTime");
        }
        if (bVar.a != null) {
            bVar.a.timeBegin("urlLoadTime");
        }
        if (TextUtils.equals(obj, str) != null) {
            AlibcContext.b();
            return false;
        }
        AlibcContext.b();
        webView.loadUrl(obj);
        return true;
    }
}
