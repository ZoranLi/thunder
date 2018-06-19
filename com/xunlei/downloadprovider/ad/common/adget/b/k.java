package com.xunlei.downloadprovider.ad.common.adget.b;

import com.xunlei.downloadprovider.ad.common.adget.ADConst;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.c.b;
import com.xunlei.downloadprovider.ad.common.h.a;
import com.xunlei.downloadprovider.ad.common.report.e;
import java.util.List;

/* compiled from: MultiCacheTask */
final class k implements a {
    final /* synthetic */ byte a;
    final /* synthetic */ b.a b;
    final /* synthetic */ j c;

    k(j jVar, byte b, b.a aVar) {
        this.c = jVar;
        this.a = b;
        this.b = aVar;
    }

    public final void a(List<l> list) {
        this.c.b = (byte) (this.c.b | this.a);
        if (list == null || list.isEmpty()) {
            this.c.e.put(Byte.valueOf(this.a), Integer.valueOf(-13));
        } else {
            this.c.d.put(Byte.valueOf(this.a), list);
        }
        l lVar = null;
        if (!(list == null || list.size() == 0)) {
            lVar = (l) list.get(0);
        }
        list = ADConst.a(this.a);
        if (lVar != null) {
            this.b.a();
            com.xunlei.downloadprovider.ad.common.adget.k.a("adv_request_success", com.xunlei.downloadprovider.ad.common.adget.k.a(list, this.c.a, this.c.c), this.b);
        } else {
            this.b.a();
            com.xunlei.downloadprovider.ad.common.adget.k.a("adv_request_fail", com.xunlei.downloadprovider.ad.common.adget.k.a(this.c.a, this.c.c, list, e.a(-13, "")), this.b);
        }
        this.c.c();
    }

    public final void a(int i, String str) {
        this.c.b = (byte) (this.c.b | this.a);
        this.c.e.put(Byte.valueOf(this.a), Integer.valueOf(i));
        String a = ADConst.a(this.a);
        this.b.a();
        com.xunlei.downloadprovider.ad.common.adget.k.a("adv_request_fail", com.xunlei.downloadprovider.ad.common.adget.k.a(this.c.a, this.c.c, a, e.a(i, str)), this.b);
        this.c.c();
    }
}
