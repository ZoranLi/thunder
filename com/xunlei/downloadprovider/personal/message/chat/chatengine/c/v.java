package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a;
import org.json.JSONObject;

/* compiled from: ChatUserNetwork */
final class v implements c<JSONObject> {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        a aVar = new a();
        r$a.a(aVar, jSONObject);
        if (r$a.a(aVar) != null) {
            this.a.b.a(Boolean.valueOf(true));
        } else {
            this.a.b.a(b.a(aVar.b, aVar.c));
        }
    }

    public final void a(b bVar) {
        this.a.b.a(bVar);
    }
}
