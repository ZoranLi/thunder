package com.xunlei.downloadprovider.comment.entity;

import anet.channel.util.HttpConstant;
import com.android.volley.AuthFailureError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: CookieJsonRequest */
public class h extends ar {
    private static final String a = "h";

    public h(int i, String str, JSONObject jSONObject, b<JSONObject> bVar, a aVar) {
        super(i, str, jSONObject, bVar, aVar);
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        headers.put(HttpConstant.COOKIE, g.a());
        return headers;
    }
}
