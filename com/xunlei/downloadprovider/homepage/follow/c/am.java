package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
final class am implements b<JSONObject> {
    final /* synthetic */ al a;

    am(al alVar) {
        this.a = alVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("getFollowingLatestLiveStatus:result=>").append(jSONObject);
        String optString = jSONObject.optString("result");
        if (ITagManager.SUCCESS.equals(optString)) {
            this.a.b.a(Boolean.valueOf(jSONObject.optBoolean("new_live")), Integer.valueOf(jSONObject.optInt("num")));
            return;
        }
        this.a.b.a(optString);
    }
}
