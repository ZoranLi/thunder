package com.xunlei.downloadprovider.publiser.per.a;

import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import org.json.JSONObject;

/* compiled from: PublishNetworkHelper */
final class b implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ int c = 20;
    final /* synthetic */ e$d d;
    final /* synthetic */ a e;

    b(a aVar, long j, long j2, e$d com_xunlei_downloadprovider_member_payment_a_e_d) {
        this.e = aVar;
        this.a = j;
        this.b = j2;
        this.d = com_xunlei_downloadprovider_member_payment_a_e_d;
    }

    public final void run() {
        JSONObject a = a.c(this.a, this.b, this.c);
        a.a;
        a.a;
        new StringBuilder("getPublishList body =>").append(a);
        this.e.a(new ar(1, "http://api-shoulei-ssl.xunlei.com/publish_list/query_pub_v3", a, new c(this), new d(this)));
    }
}
