package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
final class r implements b<JSONObject> {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("getFollowingLatestVideoFeedStatus:result=>").append(jSONObject);
        String optString = jSONObject.optString("result");
        if (ITagManager.SUCCESS.equalsIgnoreCase(optString)) {
            obj = jSONObject.optInt("if_new");
            c cVar = this.a.b;
            boolean z = true;
            if (obj != 1) {
                z = false;
            }
            cVar.onSuccess(Boolean.valueOf(z));
            return;
        }
        this.a.b.onFail(optString);
    }
}
