package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.d.a;
import org.json.JSONObject;

/* compiled from: ChatDialogNetwork */
final class l implements c<JSONObject> {
    final /* synthetic */ c a;
    final /* synthetic */ d b;

    l(d dVar, c cVar) {
        this.b = dVar;
        this.a = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        obj = a.c((JSONObject) obj);
        if (a.a.a(obj)) {
            this.a.a(obj.a);
        } else {
            this.a.a(b.a(obj.b, obj.c));
        }
    }

    public final void a(b bVar) {
        this.a.a(bVar);
    }
}
