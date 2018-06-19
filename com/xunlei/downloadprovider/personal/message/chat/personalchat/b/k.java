package com.xunlei.downloadprovider.personal.message.chat.personalchat.b;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: ChatNewUserNetwork */
final class k implements b<JSONObject> {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        this.a.b.a((JSONObject) obj);
    }
}
