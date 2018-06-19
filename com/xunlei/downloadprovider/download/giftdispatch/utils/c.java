package com.xunlei.downloadprovider.download.giftdispatch.utils;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: GiftDispatchingDataManager */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            a.b;
            new StringBuilder("requestGiftDispathingData - ").append(jSONObject.toString());
            a.a(this.a.b, jSONObject);
            return;
        }
        this.a.b.c();
    }
}
