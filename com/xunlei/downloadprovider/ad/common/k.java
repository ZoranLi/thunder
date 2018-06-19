package com.xunlei.downloadprovider.ad.common;

import com.xunlei.downloadprovider.ad.common.i.a;
import java.util.Iterator;

/* compiled from: RequestTimeoutController */
final class k implements Runnable {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void run() {
        this.a.a.c = true;
        Iterator it = this.a.a.a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).g_();
        }
    }
}
