package com.xunlei.downloadprovider.member.login.c;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: LoginBusinessHelper */
final class e implements b<JSONObject> {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        ((JSONObject) obj).optString("result");
    }
}
