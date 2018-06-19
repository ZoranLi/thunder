package com.xunlei.downloadprovider.contentpublish.website.a;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: WebsiteNetworkHelper */
final class c implements b<JSONObject> {
    final /* synthetic */ com.xunlei.downloadprovider.member.payment.a.e.c a;
    final /* synthetic */ b b;

    c(b bVar, com.xunlei.downloadprovider.member.payment.a.e.c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.a != null) {
            obj = jSONObject.optString("result");
            if (ITagManager.SUCCESS.equalsIgnoreCase(obj)) {
                this.a.onSuccess(obj);
                return;
            }
            this.a.onFail(obj);
        }
    }
}
