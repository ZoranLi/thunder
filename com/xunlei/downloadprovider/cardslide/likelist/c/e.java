package com.xunlei.downloadprovider.cardslide.likelist.c;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: CardLikeNetHelper */
final class e implements b<JSONObject> {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            this.a.b.a(c.a(jSONObject));
        } else {
            this.a.b.a();
        }
    }
}
