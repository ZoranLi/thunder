package com.xunlei.downloadprovider.personal.message.chat.personalchat.b;

import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.personal.message.chat.c;
import org.json.JSONObject;

/* compiled from: ChatNewUserNetwork */
public final class g implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ c b;
    final /* synthetic */ c c;

    public g(c cVar, JSONObject jSONObject, c cVar2) {
        this.c = cVar;
        this.a = jSONObject;
        this.b = cVar2;
    }

    public final void run() {
        c.b(this.c, new ar(1, "http://api-shoulei-ssl.xunlei.com/pepper/api/report/not_download", this.a, new h(this), new i(this)));
    }
}
