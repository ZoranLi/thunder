package com.xunlei.downloadprovider.member.payment.a;

import com.android.volley.n.b;
import com.xunlei.common.androidutil.DateTimeUtil;
import com.xunlei.downloadprovider.member.payment.external.e;

/* compiled from: PayNetworkHelper */
final class g implements b<String> {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String str = (String) obj;
        try {
            this.a.g = e.a(str);
            this.a.a(this.a.g);
            f.a(str);
            f.e().setString("pay_save_time", DateTimeUtil.getDate());
        } catch (Object obj2) {
            obj2.printStackTrace();
            this.a.a(null);
        }
    }
}
