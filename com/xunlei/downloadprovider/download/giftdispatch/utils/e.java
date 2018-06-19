package com.xunlei.downloadprovider.download.giftdispatch.utils;

import com.android.volley.n.a;
import com.android.volley.n.b;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: GiftDispatchingJsonObjectRequest */
public final class e extends SigJsonObjectRequest {
    private static Map<String, String> a;

    static {
        Map hashMap = new HashMap();
        a = hashMap;
        hashMap.put("Content-Type", HttpRequest.CONTENT_TYPE_JSON);
    }

    public e(String str, JSONObject jSONObject, b<JSONObject> bVar, a aVar) {
        super(1, str, jSONObject, bVar, aVar);
    }
}
