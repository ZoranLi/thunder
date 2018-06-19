package com.xunlei.downloadprovider.personal.message.data;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import org.json.JSONObject;

/* compiled from: MessageNetWork */
final class l implements b<JSONObject> {
    final /* synthetic */ long a;
    final /* synthetic */ MessageType b;
    final /* synthetic */ f c;
    final /* synthetic */ g d;

    l(g gVar, long j, MessageType messageType, f fVar) {
        this.d = gVar;
        this.a = j;
        this.b = messageType;
        this.c = fVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        g.b;
        new StringBuilder("delUserMessageById jsonObject=").append(jSONObject);
        g.a(this.d, jSONObject, this.a, this.b, this.c);
    }
}
