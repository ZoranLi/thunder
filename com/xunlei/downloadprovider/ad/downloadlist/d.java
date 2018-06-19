package com.xunlei.downloadprovider.ad.downloadlist;

import com.xunlei.downloadprovider.ad.a.h;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.b.b;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import com.xunlei.downloadprovider.ad.downloadlist.DownloadListADConst.DownloadListSSPAdMapping;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: SecondADClient */
public class d {
    public static final String a = "d";
    private static d d;
    public final HashMap<Integer, l> b = new HashMap();
    public a[] c;
    private boolean e;
    private List<l> f;
    private List<l> g;
    private List<l> h;
    private List<THUNDER_AD_INFO> i = new ArrayList();

    private d() {
        this.i.add(DownloadListSSPAdMapping.getThunderAdInfo(0));
        if (!h.a()) {
            this.i.add(DownloadListSSPAdMapping.getThunderAdInfo(1));
            this.i.add(DownloadListSSPAdMapping.getThunderAdInfo(2));
        }
        this.c = new a[3];
    }

    public static d a() {
        if (d == null) {
            d = new d();
        }
        return d;
    }

    public static void b() {
        d = null;
    }

    public final void a(int i) {
        List list;
        switch (i) {
            case 0:
                list = this.f;
                break;
            case 1:
                list = this.g;
                break;
            case 2:
                list = this.h;
                break;
            default:
                list = null;
                break;
        }
        if (list != null && this.c[i] != null) {
            this.c[i].a(list);
        }
    }

    public final void c() {
        if (!this.e) {
            this.e = true;
            this.f = null;
            this.g = null;
            this.h = null;
            for (int i = 0; i < this.c.length; i++) {
                this.c[i] = null;
            }
            new b().a(this.i, new e(this));
        }
    }
}
