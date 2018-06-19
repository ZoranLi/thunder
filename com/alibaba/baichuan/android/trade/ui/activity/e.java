package com.alibaba.baichuan.android.trade.ui.activity;

import com.alibaba.baichuan.android.trade.model.TradeResult;

final class e implements Runnable {
    final /* synthetic */ TradeResult a;
    final /* synthetic */ AlibcWebViewActivity b;

    e(AlibcWebViewActivity alibcWebViewActivity, TradeResult tradeResult) {
        this.b = alibcWebViewActivity;
        this.a = tradeResult;
    }

    public final void run() {
        this.b.b.c.e.onTradeSuccess(this.a);
        this.b.finish();
    }
}
