package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: BasePayActivity */
final class l implements Runnable {
    final /* synthetic */ BasePayActivity a;

    l(BasePayActivity basePayActivity) {
        this.a = basePayActivity;
    }

    public final void run() {
        LoginHelper.a().b();
    }
}
