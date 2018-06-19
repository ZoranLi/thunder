package com.xunlei.downloadprovider.personal.message.chat.personalchat.b;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a;
import org.json.JSONObject;

/* compiled from: ChatNewUserNetwork */
final class e implements b<JSONObject> {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        a aVar = new a();
        if (com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a(aVar, jSONObject) == null) {
            new StringBuilder("reportNewUser. fail. errorMsg: ").append(aVar.c);
            if (this.a.b != null) {
                this.a.b.a(com.xunlei.downloadprovider.personal.message.chat.b.a(aVar));
            }
        } else if (this.a.b != null) {
            this.a.b.a(Boolean.valueOf(true));
        }
    }
}
