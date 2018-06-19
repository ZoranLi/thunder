package com.xunlei.downloadprovider.personal.lixianspace.b;

import java.util.List;

/* compiled from: LXSpaceDataHelper */
final class f implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ c d;

    f(c cVar, List list, int i, String str) {
        this.d = cVar;
        this.a = list;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        for (a b : this.d.b) {
            b.b(this.a, this.b);
        }
    }
}
