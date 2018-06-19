package com.xunlei.downloadprovider.personal.lixianspace.b;

/* compiled from: LXSpaceDataHelper */
final class g implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;

    g(c cVar, int i, String str) {
        this.c = cVar;
        this.a = i;
        this.b = str;
    }

    public final void run() {
        for (a a : this.c.b) {
            a.a();
        }
    }
}
