package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.downloadprovider.member.b.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;

/* compiled from: PaymentSuccessActivity */
final class ar implements h {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ PaymentSuccessActivity c;

    ar(PaymentSuccessActivity paymentSuccessActivity, String str, a aVar) {
        this.c = paymentSuccessActivity;
        this.a = str;
        this.b = aVar;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        LoginHelper.a().b(this);
        if (this.c.d.orderType != PayUtil$OrderType.OPEN) {
            if (this.c.d.orderType != PayUtil$OrderType.RENEW) {
                this.b.a("2;3;4;5;6;9;13");
                return;
            }
        }
        z = PayUtil.d(this.a).intValue() + (this.c.d.monthOrDays * 100);
        i = this.b;
        StringBuilder stringBuilder = new StringBuilder("2;3;4;5;6;9;13_");
        stringBuilder.append(z);
        i.a(stringBuilder.toString());
    }
}
