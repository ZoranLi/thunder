package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.c;
import org.json.JSONObject;

/* compiled from: ChatBaseNetwork */
final class b implements com.android.volley.n.b<JSONObject> {
    final /* synthetic */ c a;
    final /* synthetic */ a b;

    b(a aVar, c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        obj = (JSONObject) obj;
        if (a.a(this.a) && this.a != null) {
            this.a.a(obj);
        }
    }
}
