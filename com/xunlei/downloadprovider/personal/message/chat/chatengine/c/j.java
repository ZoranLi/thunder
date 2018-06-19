package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a;
import org.json.JSONObject;

/* compiled from: ChatDialogNetwork */
final class j implements c<JSONObject> {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        a aVar = new a();
        if (d.a.a(aVar, jSONObject) != null) {
            this.a.b.a(Boolean.valueOf(true));
        } else {
            this.a.b.a(b.a(aVar.b, aVar.c));
        }
    }

    public final void a(b bVar) {
        this.a.b.a(bVar);
    }
}
