package com.xunlei.downloadprovider.homepage.youliao;

import java.util.ArrayList;

/* compiled from: YouliaoVideoFragment */
final class j implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ i b;

    j(i iVar, ArrayList arrayList) {
        this.b = iVar;
        this.a = arrayList;
    }

    public final void run() {
        this.b.a.e.a(this.a);
        if (!this.b.a.l && this.b.a.c != null) {
            this.b.a.d.a(this.b.a.c);
            this.b.a.l = true;
        }
    }
}
