package com.xunlei.downloadprovider.ad.a;

import com.xunlei.downloadprovider.ad.downloadlist.b.a;
import com.xunlei.downloadprovider.ad.downloadlist.c;
import com.xunlei.downloadprovider.ad.downloadlist.c.e;
import com.xunlei.downloadprovider.ad.downloadlist.c.i;
import com.xunlei.downloadprovider.ad.downloadlist.d;
import com.xunlei.downloadprovider.ad.recommend.a.h;
import com.xunlei.downloadprovider.ad.recommend.c.b;
import java.util.Iterator;

/* compiled from: DownloadCenterADLoadController */
final class g implements Runnable {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        e.c(this.a);
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
        Iterator it = e.a().b.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if ((iVar instanceof com.xunlei.downloadprovider.ad.downloadlist.c.d) || (iVar instanceof com.xunlei.downloadprovider.ad.downloadlist.c.c)) {
                it.remove();
            }
        }
        it = e.a().b.iterator();
        while (it.hasNext()) {
            iVar = (i) it.next();
            if ((iVar instanceof b) || (iVar instanceof com.xunlei.downloadprovider.ad.recommend.c.c)) {
                it.remove();
            }
        }
        e a = e.a();
        a.a(0);
        a.a(1);
        a.a(2);
    }
}
