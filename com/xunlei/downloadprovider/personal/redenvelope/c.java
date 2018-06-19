package com.xunlei.downloadprovider.personal.redenvelope;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: GameUsedRequestHelper */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        ((JSONObject) obj).optString("result");
    }
}
