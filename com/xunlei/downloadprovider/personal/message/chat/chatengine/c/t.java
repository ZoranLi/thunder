package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a;
import org.json.JSONObject;

/* compiled from: ChatUserNetwork */
final class t implements c<JSONObject> {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        a aVar = new a();
        r$a.a(aVar, jSONObject);
        if (r$a.a(aVar) != null) {
            this.a.c.a(Boolean.valueOf(true));
        } else {
            this.a.c.a(b.a(aVar.b, aVar.c));
        }
    }

    public final void a(b bVar) {
        this.a.c.a(bVar);
    }
}
