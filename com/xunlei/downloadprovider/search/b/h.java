package com.xunlei.downloadprovider.search.b;

import com.xunlei.downloadprovider.search.b.c.a;
import java.util.List;

/* compiled from: SearchNetworkHelper */
final class h implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ List c;
    final /* synthetic */ c d;

    h(c cVar, a aVar, String str, List list) {
        this.d = cVar;
        this.a = aVar;
        this.b = str;
        this.c = list;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
