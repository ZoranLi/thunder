package com.alibaba.baichuan.android.trade.adapter.a;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.ut.e;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AliPayResult;
import com.alipay.sdk.util.h;
import java.util.ArrayList;

public final class b implements Runnable {
    final /* synthetic */ WebView a;
    final /* synthetic */ AlibcTradeCallback b;
    final /* synthetic */ String c;
    final /* synthetic */ Uri d;
    final /* synthetic */ a e;

    public b(a aVar, WebView webView, AlibcTradeCallback alibcTradeCallback, String str, Uri uri) {
        this.e = aVar;
        this.a = webView;
        this.b = alibcTradeCallback;
        this.c = str;
        this.d = uri;
    }

    public final void run() {
        if (this.a.getContext() instanceof Activity) {
            Object a = a.b(this.b, this.a, this.c);
            if (a != null) {
                if (!TextUtils.isEmpty(a)) {
                    String a2 = a.b(a.replace("{", "").replace(h.d, ""), "resultStatus=", ";memo");
                    if (TextUtils.equals("9000", a2)) {
                        ArrayList a3 = a.a(this.d);
                        AliPayResult a4 = a.a(a3);
                        if (a4 != null) {
                            if (a4.payFailedOrders != null || a4.paySuccessOrders != null) {
                                new StringBuilder("QueryOrderResultTask.asyncExecute()--pay success").append(a3);
                                AlibcContext.b();
                                e.a("Pay_Result_Alipay");
                                a.a(this.e, this.b, this.a, a4);
                                return;
                            }
                        }
                        AlibcContext.b();
                        if (this.b != null) {
                            this.b.onFailure(10009, "alipay支付失败，信息为:empty orders");
                        }
                        return;
                    }
                    a.a(this.e, this.b, a2, this.a);
                }
            }
            e.b("Pay_Result_Alipay", "result is null", "160102");
        }
    }
}
