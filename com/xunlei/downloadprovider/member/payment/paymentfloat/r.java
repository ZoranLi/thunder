package com.xunlei.downloadprovider.member.payment.paymentfloat;

import com.android.volley.n.b;
import com.xunlei.common.concurrent.XLThreadPool;
import org.json.JSONObject;

/* compiled from: MemberPriceHelper */
final class r implements b<JSONObject> {
    final /* synthetic */ m a;

    r(m mVar) {
        this.a = mVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        XLThreadPool.execute(new s(this, (JSONObject) obj));
    }
}
