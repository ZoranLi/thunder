package com.xunlei.downloadprovider.homepage.follow.c;

import com.xunlei.downloadprovider.member.payment.a.e$d;

/* compiled from: FollowNetworkHelper */
public final class ai implements Runnable {
    final /* synthetic */ StringBuilder a;
    final /* synthetic */ e$d b;
    final /* synthetic */ a c;

    public ai(a aVar, StringBuilder stringBuilder, e$d com_xunlei_downloadprovider_member_payment_a_e_d) {
        this.c = aVar;
        this.a = stringBuilder;
        this.b = com_xunlei_downloadprovider_member_payment_a_e_d;
    }

    public final void run() {
        this.c.a(new ar(0, this.a.toString(), new aj(this), new ak(this)));
    }
}
