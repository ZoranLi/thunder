package com.xunlei.downloadprovider.personal.lixianspace.b;

/* compiled from: LXSpaceDataHelper */
final class h implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ c d;

    h(c cVar, long j, int i, String str) {
        this.d = cVar;
        this.a = j;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        for (a a : this.d.b) {
            a.a(this.a, this.b);
        }
    }
}
