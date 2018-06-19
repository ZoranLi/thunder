package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import java.util.ArrayList;

/* compiled from: ShortMovieDetailDataLoader */
final class aa implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ y c;

    aa(y yVar, int i, ArrayList arrayList) {
        this.c = yVar;
        this.a = i;
        this.b = arrayList;
    }

    public final void run() {
        if (this.c.a.a != null) {
            this.c.a.a.a(this.a, this.b);
        }
    }
}
