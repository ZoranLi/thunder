package com.xunlei.downloadprovider.e.a;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.e.a.f.a;
import org.json.JSONObject;

/* compiled from: LikePresenterImpl */
final class g implements b<JSONObject> {
    final /* synthetic */ a a;
    final /* synthetic */ f b;

    g(f fVar, a aVar) {
        this.b = fVar;
        this.a = aVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (!(this.a == null || jSONObject == null)) {
            if (ITagManager.SUCCESS.contentEquals(jSONObject.optString("result")) != null) {
                this.a.a();
                return;
            }
            this.a.b();
        }
    }
}
