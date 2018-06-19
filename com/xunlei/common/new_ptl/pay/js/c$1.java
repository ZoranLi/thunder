package com.xunlei.common.new_ptl.pay.js;

import android.text.TextUtils;

/* compiled from: XLPayJSRegister */
final class c$1 implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ c b;

    c$1(c cVar, String str) {
        this.b = cVar;
        this.a = str;
    }

    public final void run() {
        if (!TextUtils.isEmpty(this.a)) {
            c.a(this.b).loadUrl(this.a);
        }
    }
}
