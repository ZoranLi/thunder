package com.alibaba.baichuan.android.trade.adapter.a;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.ut.e;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.utils.a.a;
import com.alibaba.baichuan.android.trade.utils.a.b;

final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ AlibcTradeCallback b;
    final /* synthetic */ WebView c;
    final /* synthetic */ a d;

    c(a aVar, String str, AlibcTradeCallback alibcTradeCallback, WebView webView) {
        this.d = aVar;
        this.a = str;
        this.b = alibcTradeCallback;
        this.c = webView;
    }

    public final void run() {
        a a = b.a(this.a);
        new StringBuilder("alipay支付失败，信息为：").append(a != null ? a.c : null);
        AlibcContext.b();
        e.b("Pay_Result_Alipay", a != null ? a.c : "支付失败", "160102");
        if (this.b != null) {
            AlibcTradeCallback alibcTradeCallback = this.b;
            StringBuilder stringBuilder = new StringBuilder("alipay支付失败，信息为：");
            stringBuilder.append(a.c);
            alibcTradeCallback.onFailure(10010, stringBuilder.toString());
        }
        if (this.c != null) {
            if (AlibcContext.o != null) {
                if (!this.c.getUrl().contains(AlibcContext.o)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(AlibcContext.o);
                    stringBuilder2.append("?tabCode=%s");
                    this.c.loadUrl(String.format(stringBuilder2.toString(), new Object[]{com.alibaba.baichuan.android.trade.g.e.b[1]}));
                } else if (this.c.getUrl().contains(AlibcContext.o)) {
                    this.c.reload();
                } else if (this.c.getContext() instanceof Activity) {
                    ((Activity) this.c.getContext()).finish();
                }
            }
        }
    }
}
