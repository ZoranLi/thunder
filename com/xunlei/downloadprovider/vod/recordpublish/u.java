package com.xunlei.downloadprovider.vod.recordpublish;

/* compiled from: VodPlayerTopicSelectActivity */
final class u implements Runnable {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    public final void run() {
        this.a.a.e.a = this.a.a.c;
        this.a.a.e.onContentChanged();
    }
}
