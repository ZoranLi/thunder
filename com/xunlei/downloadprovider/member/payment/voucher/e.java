package com.xunlei.downloadprovider.member.payment.voucher;

import com.android.volley.n.b;
import com.xunlei.common.concurrent.XLThreadPool;
import org.json.JSONObject;

/* compiled from: ThunderVoucherProcessor */
final class e implements b<JSONObject> {
    final /* synthetic */ String a;
    final /* synthetic */ d b;

    e(d dVar, String str) {
        this.b = dVar;
        this.a = str;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("get voucher onResponse = ").append(jSONObject.toString());
        XLThreadPool.execute(new f(this, jSONObject));
    }
}
