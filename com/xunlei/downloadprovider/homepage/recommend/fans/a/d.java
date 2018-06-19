package com.xunlei.downloadprovider.homepage.recommend.fans.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.member.payment.a.e$e;

/* compiled from: FansAndFollowNetWork */
final class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        a.a;
        if (this.a.b != null) {
            e$e com_xunlei_downloadprovider_member_payment_a_e_e = this.a.b;
            String.valueOf(f.a(volleyError));
            com_xunlei_downloadprovider_member_payment_a_e_e.a();
        }
    }
}
