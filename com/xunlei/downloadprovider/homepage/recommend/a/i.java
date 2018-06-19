package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.downloadprovider.homepage.follow.c.ar;

/* compiled from: CounterNetWorkHelper */
public final class i implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ int c = null;
    final /* synthetic */ String d;
    final /* synthetic */ int e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ String h;
    final /* synthetic */ String i;
    final /* synthetic */ String j;
    final /* synthetic */ b k;

    public i(b bVar, int i, String str, String str2, String str3, String str4, String str5) {
        this.k = bVar;
        this.a = i;
        this.b = str;
        this.d = str2;
        this.e = 1;
        this.f = str3;
        this.g = str4;
        this.h = null;
        this.i = null;
        this.j = str5;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("sendPlay length=");
        stringBuilder.append(this.a);
        stringBuilder.append(",playType=");
        stringBuilder.append(this.b);
        stringBuilder.append(",playTime=");
        stringBuilder.append(this.c);
        Request arVar = new ar(1, "http://api-shoulei-ssl.xunlei.com/counter/play", b.b(this.d, this.e, this.f, this.g, this.a, this.h, this.b, this.i, this.c, this.j), new j(this), new k(this));
        arVar.setShouldCache(false);
        arVar.setRetryPolicy(new d(1000, 1, 1.0f));
        this.k.a(arVar);
    }
}
