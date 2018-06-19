package com.baidu.mobads.g;

import com.baidu.mobads.g.o.a;

class d implements a {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void a(e eVar) {
        this.a.a("OK", eVar, "download apk successfully, downloader exit");
        c.f = null;
    }

    public void b(e eVar) {
        this.a.a("ERROR", eVar, "downloadApk failed");
    }
}
