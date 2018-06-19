package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.downloadprovider.search.b.i;

/* compiled from: MultiSearchAdapter */
final class q implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ o c;

    q(o oVar, String str, String str2) {
        this.c = oVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        i.a().a(this.a, this.b);
    }
}
