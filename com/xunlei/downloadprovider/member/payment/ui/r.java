package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.payment.external.l$a;

/* compiled from: BasePayActivity */
final class r extends c {
    final /* synthetic */ l$a a;
    final /* synthetic */ BasePayActivity b;

    r(BasePayActivity basePayActivity, l$a com_xunlei_downloadprovider_member_payment_external_l_a) {
        this.b = basePayActivity;
        this.a = com_xunlei_downloadprovider_member_payment_external_l_a;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        this.b.a(this.a);
    }
}
