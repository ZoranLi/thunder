package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.Request;
import com.android.volley.d;
import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e$d;

/* compiled from: CounterNetWorkHelper */
final class s implements Runnable {
    final /* synthetic */ StringBuilder a;
    final /* synthetic */ e$d b;

    s(StringBuilder stringBuilder, e$d com_xunlei_downloadprovider_member_payment_a_e_d) {
        this.a = stringBuilder;
        this.b = com_xunlei_downloadprovider_member_payment_a_e_d;
    }

    public final void run() {
        Request arVar = new ar(0, this.a.toString(), new t(this), new u(this));
        arVar.setTag("USER_LIKES");
        l requestQueue = VolleyRequestManager.getRequestQueue();
        arVar.setRetryPolicy(new d(10000, 2, 1.0f));
        requestQueue.a(arVar);
    }
}
