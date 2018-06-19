package com.xunlei.downloadprovider.personal.message.chat.personalchat.b;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: ChatNewUserNetwork */
final class h implements b<JSONObject> {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        this.a.b.a((JSONObject) obj);
    }
}
