package com.xunlei.downloadprovider.personal.score;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: UserScoreManager */
final class m implements b<JSONObject> {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            this.a.a.a(jSONObject.optString("redirect"), jSONObject.optString("result"));
        }
    }
}
