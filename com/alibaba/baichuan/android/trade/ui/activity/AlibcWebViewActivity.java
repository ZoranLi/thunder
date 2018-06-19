package com.alibaba.baichuan.android.trade.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.model.TradeResult;

public class AlibcWebViewActivity extends a {
    private static final String f = "AlibcWebViewActivity";

    public final void a(TradeResult tradeResult) {
        if (this.b.c.e != null) {
            AlibcContext.b.b(new e(this, tradeResult));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            String stringExtra = intent.getStringExtra("url");
            if (stringExtra != null) {
                this.a.loadUrl(stringExtra);
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("caller", getIntent().getStringExtra("caller"));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (AlibcContext.b()) {
            AlibcContext.b();
        }
    }
}
