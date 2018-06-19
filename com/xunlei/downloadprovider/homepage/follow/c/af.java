package com.xunlei.downloadprovider.homepage.follow.c;

import com.xunlei.downloadprovider.member.payment.a.e$f;

/* compiled from: FollowNetworkHelper */
final class af implements Runnable {
    final /* synthetic */ StringBuilder a;
    final /* synthetic */ e$f b;
    final /* synthetic */ a c;

    af(a aVar, StringBuilder stringBuilder, e$f com_xunlei_downloadprovider_member_payment_a_e_f) {
        this.c = aVar;
        this.a = stringBuilder;
        this.b = com_xunlei_downloadprovider_member_payment_a_e_f;
    }

    public final void run() {
        this.c.a(new ar(0, this.a.toString(), new ag(this), new ah(this)));
    }
}
