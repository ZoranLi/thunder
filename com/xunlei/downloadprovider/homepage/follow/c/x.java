package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
final class x implements b<JSONObject> {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (ITagManager.SUCCESS.equalsIgnoreCase(jSONObject.optString("result"))) {
            this.a.b.onSuccess(this.a.c);
            return;
        }
        this.a.b.onFail(jSONObject.optString("code"));
    }
}
