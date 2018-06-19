package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.xunlei.downloadprovider.homepage.redpacket.a.d.a;

/* compiled from: RequestRedPacketManager */
public final class e implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ d b;

    public e(d dVar, a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    public final void run() {
        d.a(this.b, new a(0, "http://api-shoulei-ssl.xunlei.com/ares/web_api/is_new", new f(this), new g(this)));
    }
}
