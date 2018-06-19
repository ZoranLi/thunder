package com.xunlei.downloadprovider.publiser.common;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: PublisherDataNetworkHelper */
final class m implements b<JSONObject> {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("deleteVideo response =>").append(jSONObject);
        if (ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
            this.a.b.onSuccess(Boolean.valueOf(true));
            this.a.d.a.b();
            return;
        }
        this.a.b.onFail(jSONObject.optString("msg"));
        this.a.d.a.b();
    }
}
