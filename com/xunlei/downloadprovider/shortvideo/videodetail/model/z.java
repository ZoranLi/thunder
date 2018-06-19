package com.xunlei.downloadprovider.shortvideo.videodetail.model;

/* compiled from: ShortMovieDetailDataLoader */
final class z implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ y b;

    z(y yVar, String str) {
        this.b = yVar;
        this.a = str;
    }

    public final void run() {
        if (this.b.a.a != null) {
            this.b.a.a.a(13, this.a);
        }
    }
}
