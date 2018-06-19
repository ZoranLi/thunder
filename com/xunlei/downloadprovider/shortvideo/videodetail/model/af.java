package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import java.util.ArrayList;

/* compiled from: ShortMovieDetailDataLoader */
final class af implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ ae b;

    af(ae aeVar, ArrayList arrayList) {
        this.b = aeVar;
        this.a = arrayList;
    }

    public final void run() {
        if (this.b.a.d.a != null) {
            this.b.a.d.a.a(this.a);
        }
    }
}
