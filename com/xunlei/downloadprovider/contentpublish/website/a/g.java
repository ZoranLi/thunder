package com.xunlei.downloadprovider.contentpublish.website.a;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailInfo;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: WebsiteNetworkHelper */
public final class g implements b<JSONObject> {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    public g(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("getWebsiteDetailInfo RESPONSE =>").append(jSONObject);
        if (this.a != null) {
            String optString = jSONObject.optString("result");
            if (ITagManager.SUCCESS.equalsIgnoreCase(optString)) {
                this.a.onSuccess(WebsiteDetailInfo.a(jSONObject));
                return;
            }
            this.a.onFail(optString);
        }
    }
}
