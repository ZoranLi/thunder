package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
final class u implements b<JSONObject> {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        obj = ((JSONObject) obj).optString("result");
        if (ITagManager.SUCCESS.equalsIgnoreCase(obj)) {
            this.a.b.a();
        } else {
            this.a.b.a(obj);
        }
    }
}
