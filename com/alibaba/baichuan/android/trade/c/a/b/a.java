package com.alibaba.baichuan.android.trade.c.a.b;

import android.webkit.WebView;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.c.a.a.b.b;
import com.alibaba.baichuan.android.trade.c.a.a.b.c;
import com.alibaba.baichuan.android.trade.model.ResultType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.ui.activity.AlibcWebViewActivity;

public final class a implements b {
    public final boolean a(c cVar) {
        if (cVar.g != 2) {
            return false;
        }
        WebView webView = cVar.a;
        if (webView == null) {
            return false;
        }
        if (webView.getContext() instanceof AlibcWebViewActivity) {
            if (cVar.b.b() == null) {
                AlibcWebViewActivity alibcWebViewActivity = (AlibcWebViewActivity) webView.getContext();
                TradeResult tradeResult = new TradeResult();
                tradeResult.resultType = ResultType.TYPECART;
                alibcWebViewActivity.a(tradeResult);
            } else {
                webView.goBack();
            }
        } else if (cVar.b.c.e != null) {
            AlibcContext.b.b(new b(this, cVar, webView));
        }
        return true;
    }
}
