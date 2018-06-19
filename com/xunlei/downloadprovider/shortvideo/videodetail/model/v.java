package com.xunlei.downloadprovider.shortvideo.videodetail.model;

/* compiled from: ShortMovieDetailDataLoader */
final class v implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ u b;

    v(u uVar, String str) {
        this.b = uVar;
        this.a = str;
    }

    public final void run() {
        if (this.b.a.b.a != null) {
            this.b.a.b.a.a(this.a);
        }
    }
}
