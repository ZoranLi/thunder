package com.xunlei.downloadprovider.member.payment.activity;

import com.android.volley.n.b;
import com.xunlei.common.concurrent.XLThreadPool;
import org.json.JSONObject;

/* compiled from: IActivityConfigImpl */
final class h implements b<JSONObject> {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        XLThreadPool.execute(new i(this, (JSONObject) obj));
    }
}
