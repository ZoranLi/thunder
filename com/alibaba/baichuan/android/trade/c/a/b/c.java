package com.alibaba.baichuan.android.trade.c.a.b;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.c.a.a.b.b;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.e.a;

public final class c implements b {
    j a;

    public final boolean a(com.alibaba.baichuan.android.trade.c.a.a.b.c cVar) {
        if (!com.alibaba.baichuan.android.trade.utils.b.a(a.g().a("isNeedAlipay", Boolean.valueOf(true)))) {
            return false;
        }
        this.a = new j(cVar.b.c.e, AlibcContext.s);
        j jVar = this.a;
        WebView webView = cVar.a;
        cVar = cVar.e;
        StringBuilder stringBuilder = new StringBuilder("PayOverrideHandler.handle()--进入支付流程: url:");
        stringBuilder.append(cVar);
        stringBuilder.append(" webview:");
        stringBuilder.append(webView != null ? webView.toString() : null);
        AlibcContext.b();
        com.alibaba.baichuan.android.trade.adapter.a.a a = com.alibaba.baichuan.android.trade.adapter.a.a.a();
        AlibcTradeCallback alibcTradeCallback = jVar.a;
        if (!com.alibaba.baichuan.android.trade.adapter.a.a.b()) {
            return false;
        }
        Uri parse = Uri.parse(cVar);
        cVar = parse.getQueryParameter("alipay_trade_no");
        if (cVar == null) {
            cVar = parse.getQueryParameter("trade_nos");
        }
        Object queryParameter = parse.getQueryParameter("payPhaseId");
        if (queryParameter == null) {
            queryParameter = parse.getQueryParameter("pay_phase_id");
        }
        String queryParameter2 = parse.getQueryParameter("s_id");
        stringBuilder = new StringBuilder("trade_no=\"");
        stringBuilder.append(cVar);
        stringBuilder.append("\"&extern_token=\"");
        stringBuilder.append(queryParameter2);
        stringBuilder.append("\"&partner=\"PARTNER_TAOBAO_ORDER\"");
        if (TextUtils.isEmpty(queryParameter) == null) {
            stringBuilder.append("&payPhaseId=\"");
            stringBuilder.append(queryParameter);
            stringBuilder.append("\"");
        }
        AlibcContext.b.a(new com.alibaba.baichuan.android.trade.adapter.a.b(a, webView, alibcTradeCallback, stringBuilder.toString(), parse));
        return true;
    }
}
