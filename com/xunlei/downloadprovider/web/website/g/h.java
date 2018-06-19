package com.xunlei.downloadprovider.web.website.g;

import com.xunlei.downloadprovider.web.website.b.d;
import com.xunlei.downloadprovider.web.website.c.b;

/* compiled from: WebsiteHelper */
final class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ d b;
    final /* synthetic */ b c;

    h(b bVar, String str, d dVar) {
        this.c = bVar;
        this.a = str;
        this.b = dVar;
    }

    public final void run() {
        d b = b.b(this.a);
        if (b != null) {
            b.a(this.a);
        }
        if (b == null || b.e != 1) {
            b.a(this.b);
            return;
        }
        this.b.e = 1;
        b.a(this.b);
    }
}
