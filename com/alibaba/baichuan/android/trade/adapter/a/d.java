package com.alibaba.baichuan.android.trade.adapter.a;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AliPayResult;
import com.alibaba.baichuan.android.trade.model.ResultType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.ui.activity.AlibcWebViewActivity;

final class d implements Runnable {
    final /* synthetic */ AliPayResult a;
    final /* synthetic */ AlibcTradeCallback b;
    final /* synthetic */ WebView c;
    final /* synthetic */ a d;

    d(a aVar, AliPayResult aliPayResult, AlibcTradeCallback alibcTradeCallback, WebView webView) {
        this.d = aVar;
        this.a = aliPayResult;
        this.b = alibcTradeCallback;
        this.c = webView;
    }

    public final void run() {
        TradeResult tradeResult = new TradeResult();
        tradeResult.resultType = ResultType.TYPEPAY;
        tradeResult.payResult = this.a;
        if (this.b != null) {
            this.b.onTradeSuccess(tradeResult);
        }
        if (this.c.getContext() instanceof AlibcWebViewActivity) {
            ((AlibcWebViewActivity) this.c.getContext()).finish();
            return;
        }
        if (this.c.getContext() instanceof Activity) {
            ((Activity) this.c.getContext()).finish();
        }
    }
}
