package com.xunlei.downloadprovider.publiser.common.guide.follow.a;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.ad.recommend.a.a.a;
import org.json.JSONObject;

/* compiled from: GuideFollowNetwork */
final class k implements b<JSONObject> {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        if (ITagManager.SUCCESS.equalsIgnoreCase(((JSONObject) obj).optString("result")) != null) {
            this.a.a.a(ITagManager.SUCCESS);
        } else {
            this.a.a.a(a.a.e, a.a.f);
        }
    }
}
