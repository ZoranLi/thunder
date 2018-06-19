package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: ActivationActivity */
final class b implements h {
    final /* synthetic */ ActivationActivity a;

    b(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        LoginHelper.a().b(this.a.q);
        ActivationActivity.k(this.a);
        this.a.startActivity(new XLIntent(this.a, ActivationPaySuccessActivity.class));
        this.a.finish();
    }
}
