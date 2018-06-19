package com.xunlei.downloadprovider.personal.lixianspace.b;

import java.util.List;

/* compiled from: LXSpaceDataHelper */
final class i implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ c d;

    i(c cVar, List list, int i, String str) {
        this.d = cVar;
        this.a = list;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        for (a a : this.d.b) {
            a.a(this.a, this.b);
        }
    }
}
