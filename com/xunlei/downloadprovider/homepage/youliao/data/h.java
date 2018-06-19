package com.xunlei.downloadprovider.homepage.youliao.data;

import com.xunlei.downloadprovider.search.b.b;
import org.json.JSONObject;

/* compiled from: YouliaoNetDataSource */
public final class h implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ d b;

    public h(d dVar, b bVar) {
        this.b = dVar;
        this.a = bVar;
    }

    public final void run() {
        this.b.b = true;
        this.b.c;
        JSONObject b = a.b();
        this.b.b = false;
        d.a(this.b, b, this.a, true);
    }
}
