package com.xunlei.downloadprovider.homepage.recommend.fans.a;

import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e$e;

/* compiled from: FansAndFollowNetWork */
final class b implements Runnable {
    final /* synthetic */ StringBuilder a;
    final /* synthetic */ e$e b;
    final /* synthetic */ a c;

    b(a aVar, StringBuilder stringBuilder, e$e com_xunlei_downloadprovider_member_payment_a_e_e) {
        this.c = aVar;
        this.a = stringBuilder;
        this.b = com_xunlei_downloadprovider_member_payment_a_e_e;
    }

    public final void run() {
        this.c.a(new ar(this.a.toString(), new c(this), new d(this)));
    }
}
