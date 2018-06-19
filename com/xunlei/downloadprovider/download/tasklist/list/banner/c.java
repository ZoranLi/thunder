package com.xunlei.downloadprovider.download.tasklist.list.banner;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: BannerOnlineServerHelper */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        BannerManager.a();
        BannerManager.a(jSONObject);
    }
}
