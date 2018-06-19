package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: CounterNetWorkHelper */
final class t implements b<JSONObject> {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("likeVideos=>").append(jSONObject);
        String optString = jSONObject.optString("result");
        if (optString == null || !optString.contentEquals(ITagManager.SUCCESS)) {
            this.a.b.a(Boolean.valueOf(true), null);
        }
        boolean optBoolean = jSONObject.optBoolean("is_more");
        this.a.b.a(Boolean.valueOf(optBoolean), b.d(jSONObject));
    }
}
