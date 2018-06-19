package com.xunlei.downloadprovider.ad.a;

import com.xunlei.downloadprovider.ad.downloadlist.b.a;
import com.xunlei.downloadprovider.ad.downloadlist.c;
import com.xunlei.downloadprovider.ad.downloadlist.c.g;
import com.xunlei.downloadprovider.ad.downloadlist.c.i;
import com.xunlei.downloadprovider.ad.downloadlist.d;
import com.xunlei.downloadprovider.ad.recommend.a.h;
import com.xunlei.downloadprovider.ad.recommend.c.b;
import java.util.Iterator;

/* compiled from: HomeDownloadCenterADLoadController */
final class j implements Runnable {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        this.a.g.c();
        this.a.g.d();
        a.a();
        a.j = null;
        c.a();
        c.a = null;
        a.a();
        a.a = null;
        com.xunlei.downloadprovider.ad.b.a.a();
        com.xunlei.downloadprovider.ad.b.a.d = null;
        d.a();
        d.b();
        h.a().c();
        Iterator it = g.a().b.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if ((iVar instanceof com.xunlei.downloadprovider.ad.downloadlist.c.d) || (iVar instanceof com.xunlei.downloadprovider.ad.downloadlist.c.c)) {
                it.remove();
            }
        }
        it = g.a().b.iterator();
        while (it.hasNext()) {
            iVar = (i) it.next();
            if ((iVar instanceof b) || (iVar instanceof com.xunlei.downloadprovider.ad.recommend.c.c)) {
                it.remove();
            }
        }
        g.a().a(0);
    }
}
