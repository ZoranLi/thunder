package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.downloadprovider.member.payment.bean.PayConfigurationParam;
import com.xunlei.downloadprovider.member.payment.external.e;
import com.xunlei.downloadprovider.search.b.b;
import java.util.ArrayList;

/* compiled from: PayActivity */
final class ag implements b<ArrayList<PayConfigurationParam>> {
    final /* synthetic */ PayActivity a;

    ag(PayActivity payActivity) {
        this.a = payActivity;
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.a.v = e.a((ArrayList) obj, -1, this.a.d.e);
        this.a.u();
    }
}
