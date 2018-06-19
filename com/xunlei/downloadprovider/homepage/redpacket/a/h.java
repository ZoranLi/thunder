package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.xunlei.downloadprovider.homepage.redpacket.a.d.a;
import org.json.JSONObject;

/* compiled from: RequestRedPacketManager */
public final class h implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ d b;

    public h(d dVar, a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    public final void run() {
        d.a(this.b, new a(1, "http://api-shoulei-ssl.xunlei.com/ares/api/newbie", new JSONObject(), new i(this), new j(this)));
    }
}
