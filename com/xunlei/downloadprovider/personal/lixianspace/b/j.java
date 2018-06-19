package com.xunlei.downloadprovider.personal.lixianspace.b;

import com.xunlei.downloadlib.parameter.TorrentInfo;

/* compiled from: LXSpaceDataHelper */
final class j implements Runnable {
    final /* synthetic */ TorrentInfo a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ c d;

    j(c cVar, TorrentInfo torrentInfo, int i, String str) {
        this.d = cVar;
        this.a = torrentInfo;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        for (a a : this.d.b) {
            a.a(this.a);
        }
    }
}
