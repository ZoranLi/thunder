package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: ShortMovieDetailDataLoader */
final class u implements b<JSONObject> {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("loadRelatedGameInfo resp =>").append(jSONObject);
        if (jSONObject != null) {
            this.a.b.p.post(new v(this, ITagManager.SUCCESS.contentEquals(jSONObject.optString("result")) ? jSONObject.optString("extra_info") : null));
        }
    }
}
