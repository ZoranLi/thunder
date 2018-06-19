package com.xunlei.downloadprovider.homepage.cinecism.a;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.homepage.cinecism.a.a.a;
import org.json.JSONObject;

/* compiled from: CinecismNetworkHelper */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("Cinecism--onResponse=").append(jSONObject);
        obj = a.a(jSONObject);
        if (obj == null) {
            this.a.b.onFail("");
        } else if (obj.a()) {
            this.a.b.onSuccess(obj);
        } else {
            this.a.b.onFail(obj.a);
        }
    }
}
