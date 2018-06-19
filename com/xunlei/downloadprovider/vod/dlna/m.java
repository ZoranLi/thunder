package com.xunlei.downloadprovider.vod.dlna;

/* compiled from: DLNAListDialog */
final class m implements Runnable {
    final /* synthetic */ b a;

    m(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        if (this.a.t != null) {
            this.a.t.a(true);
        }
    }
}
