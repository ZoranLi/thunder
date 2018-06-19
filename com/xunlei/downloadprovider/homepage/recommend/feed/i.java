package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: FeedDataManager */
public final class i implements b<JSONObject> {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    public i(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (!(jSONObject == null || this.b.c == null)) {
            if (ITagManager.SUCCESS.contentEquals(jSONObject.optString("result")) != null) {
                this.b.c.a(true, this.a);
                return;
            }
            this.b.c.a(false, this.a);
        }
    }
}
