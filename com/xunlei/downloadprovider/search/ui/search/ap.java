package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.downloadprovider.search.b.i;

/* compiled from: SearchAssociativeAdapter */
final class ap implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ al c;

    ap(al alVar, String str, String str2) {
        this.c = alVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        i.a().a(this.a, this.b);
    }
}
