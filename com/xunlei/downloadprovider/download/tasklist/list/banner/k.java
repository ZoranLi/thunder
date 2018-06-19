package com.xunlei.downloadprovider.download.tasklist.list.banner;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.download.c.a;
import org.json.JSONObject;

/* compiled from: BannerOnlineServerHelper */
final class k implements b<JSONObject> {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            try {
                a.a().i = jSONObject.optInt("try_count");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.toString();
    }
}
