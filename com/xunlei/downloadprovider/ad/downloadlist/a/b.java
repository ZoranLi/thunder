package com.xunlei.downloadprovider.ad.downloadlist.a;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.a.h;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import com.xunlei.downloadprovider.ad.downloadlist.DownloadListADConst.DownloadListSSPAdMapping;
import com.xunlei.downloadprovider.ad.downloadlist.c;
import com.xunlei.downloadprovider.ad.downloadlist.c.g;
import com.xunlei.downloadprovider.ad.downloadlist.d;
import com.xunlei.downloadprovider.download.tasklist.list.feed.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LoadADExecutor */
public class b extends a implements a {
    public b(c.a aVar) {
        super(aVar);
    }

    public final void a() {
        int b = this.c.b();
        if (this.c.c() != 1) {
            String str = d.a;
            d a = d.a();
            a.c[b] = this;
            a.a(b);
            return;
        }
        str = d.a;
        if (com.xunlei.downloadprovider.ad.a.d.a(b)) {
            if (f.a()) {
                c a2 = c.a();
                com.xunlei.downloadprovider.ad.downloadlist.b cVar = new c(this, b);
                if (h.a() && com.xunlei.downloadprovider.d.d.a().d.j()) {
                    if (g.a().d) {
                        cVar.a();
                        return;
                    } else {
                        a2.a(b, cVar);
                        return;
                    }
                } else if (c.c == b) {
                    cVar.a();
                    return;
                } else {
                    a2.a(b, cVar);
                    return;
                }
            }
            com.xunlei.downloadprovider.ad.a.a.a().a(DownloadListSSPAdMapping.getThunderAdInfo(com.xunlei.downloadprovider.ad.a.d.b(b)), this);
        }
    }

    public final void a(List<l> list) {
        String str = d.a;
        new StringBuilder("onLoadComplete ").append(this.c.b());
        if (!(list == null || list.size() == 0 || this.c == null)) {
            list = b(list);
            com.xunlei.downloadprovider.ad.downloadlist.b.a.a().a(this.d).put(this.e, list);
            if (this.e.equals(com.xunlei.downloadprovider.ad.downloadlist.a.a(this.c))) {
                if (com.xunlei.downloadprovider.ad.common.a.a(list)) {
                    this.c.a(list);
                    return;
                }
                if (list != null) {
                    list = com.xunlei.downloadprovider.ad.downloadlist.a.a(this.d);
                    int i = this.b;
                    Map hashMap = new HashMap();
                    hashMap.put("ad_type", "ssp");
                    hashMap.put("tabid", list);
                    hashMap.put("order", String.valueOf(i));
                    hashMap.put("errorcode", "-108");
                    com.xunlei.downloadprovider.ad.downloadlist.c.h.a("adv_downloadtab_fail", hashMap, true);
                }
                b();
            }
        }
    }

    private l b(List<l> list) {
        l lVar = (l) list.get(0);
        if (SocializeProtocolConstants.PROTOCOL_KEY_TENCENT.equals(lVar.y())) {
            l lVar2 = (l) d.a().b.get(Integer.valueOf(this.d));
            if (lVar2 == null) {
                b.class.getSimpleName();
                d.a().b.put(Integer.valueOf(this.d), lVar);
            } else {
                b.class.getSimpleName();
                for (l lVar3 : list) {
                    if (lVar3.a(lVar2)) {
                        b.class.getSimpleName();
                    } else {
                        b.class.getSimpleName();
                        return lVar3;
                    }
                }
            }
        }
        b.class.getSimpleName();
        new StringBuilder("return result.get(0)! ").append(lVar.y());
        return (l) list.get(0);
    }

    public final void a(int i, String str) {
        i = d.a;
        new StringBuilder("onLoadFail ").append(this.c.b());
        b();
    }
}
