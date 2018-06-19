package com.xunlei.downloadprovider.personal.message.data;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.data.vo.a;
import com.xunlei.downloadprovider.pushmessage.l;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: MessageNetWork */
final class h implements b<JSONObject> {
    final /* synthetic */ f a;
    final /* synthetic */ boolean b;
    final /* synthetic */ MessageType c;
    final /* synthetic */ boolean d;
    final /* synthetic */ g e;

    h(g gVar, f fVar, boolean z, MessageType messageType, boolean z2) {
        this.e = gVar;
        this.a = fVar;
        this.b = z;
        this.c = messageType;
        this.d = z2;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        g.b;
        new StringBuilder("getPersonalMessage onResponse=").append(jSONObject);
        a parseFromJsonObject = MessageInfo.parseFromJsonObject(jSONObject);
        if (this.a != null) {
            this.a.a(parseFromJsonObject, this.b, this.c);
        }
        if (this.e.a == null) {
            this.e.a = new ArrayList();
        }
        if (this.b) {
            this.e.a.clear();
        }
        if (this.d) {
            l.a(BrothersApplication.getApplicationInstance());
        }
        this.e.a.addAll(parseFromJsonObject.c);
        this.e.a(this.c);
    }
}
