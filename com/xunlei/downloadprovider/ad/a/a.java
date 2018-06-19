package com.xunlei.downloadprovider.ad.a;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.downloadlist.DownloadListADConst.DownloadListSSPAdMapping;
import com.xunlei.downloadprovider.ad.recommend.RecommendADConst.RecommendSSPAdMapping;
import com.xunlei.downloadprovider.download.tasklist.list.feed.f;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ADClient */
public final class a {
    public static a a;
    public b b;
    public b c;
    public b d;
    public boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private a i = new a(0);
    private a j = new a(1);
    private a k = new a(2);

    /* compiled from: ADClient */
    private static class a {
        Map<THUNDER_AD_INFO, List<com.xunlei.downloadprovider.ad.common.h.a>> a;
        Map<THUNDER_AD_INFO, List<l>> b;
        List<THUNDER_AD_INFO> c;
        private int d;
        private String e;
        private int f;

        private a(int i) {
            this.d = i;
            this.a = new HashMap();
            this.c = new ArrayList();
            switch (this.d) {
                case 0:
                    this.c.add(DownloadListSSPAdMapping.getThunderAdInfo(0));
                    this.c.addAll(RecommendSSPAdMapping.getThunderAdInfos(0));
                    return;
                case 1:
                    this.c.add(DownloadListSSPAdMapping.getThunderAdInfo(1));
                    this.c.addAll(RecommendSSPAdMapping.getThunderAdInfos(1));
                    return;
                case 2:
                    this.c.add(DownloadListSSPAdMapping.getThunderAdInfo(2));
                    this.c.addAll(RecommendSSPAdMapping.getThunderAdInfos(2));
                    break;
                default:
                    break;
            }
        }

        final void a() {
            if (this.b == null || this.b.isEmpty()) {
                if (this.f != 0) {
                    Object<THUNDER_AD_INFO> arrayList = new ArrayList();
                    for (THUNDER_AD_INFO thunder_ad_info : this.a.keySet()) {
                        if (this.a.get(thunder_ad_info) != null) {
                            List<com.xunlei.downloadprovider.ad.common.h.a> list = (List) this.a.get(thunder_ad_info);
                            if (!(list == null || list.size() == 0)) {
                                for (com.xunlei.downloadprovider.ad.common.h.a a : list) {
                                    a.a(this.f, this.e);
                                }
                            }
                            arrayList.add(thunder_ad_info);
                        }
                    }
                    if (!d.a(arrayList)) {
                        for (THUNDER_AD_INFO remove : arrayList) {
                            this.a.remove(remove);
                        }
                    }
                }
                return;
            }
            for (THUNDER_AD_INFO remove2 : this.b.keySet()) {
                if (this.a.get(remove2) != null) {
                    List<com.xunlei.downloadprovider.ad.common.h.a> list2 = (List) this.a.get(remove2);
                    if (!(list2 == null || list2.size() == 0)) {
                        for (com.xunlei.downloadprovider.ad.common.h.a a2 : list2) {
                            a2.a((List) this.b.get(remove2));
                        }
                    }
                    this.a.remove(remove2);
                }
            }
        }

        static /* synthetic */ void a(a aVar, THUNDER_AD_INFO thunder_ad_info, com.xunlei.downloadprovider.ad.common.h.a aVar2) {
            List list = (List) aVar.a.get(thunder_ad_info);
            if (list == null) {
                list = new ArrayList();
                aVar.a.put(thunder_ad_info, list);
            }
            list.add(aVar2);
            aVar.a();
        }
    }

    /* compiled from: ADClient */
    private static class b {
        Map<THUNDER_AD_INFO, List<l>> a;
        public int b;
        private Map<THUNDER_AD_INFO, com.xunlei.downloadprovider.ad.common.h.a> c;
        private String d;
        private int e;
        private boolean f;

        private b(int i) {
            this.f = true;
            this.c = new HashMap();
            this.b = i;
        }

        final void a() {
            if (!this.f) {
                return;
            }
            if (this.a == null || this.a.isEmpty()) {
                if (this.e != 0) {
                    for (THUNDER_AD_INFO thunder_ad_info : this.c.keySet()) {
                        ((com.xunlei.downloadprovider.ad.common.h.a) this.c.get(thunder_ad_info)).a(this.e, this.d);
                    }
                    this.f = false;
                }
                return;
            }
            for (THUNDER_AD_INFO thunder_ad_info2 : this.a.keySet()) {
                if (this.c.get(thunder_ad_info2) != null) {
                    ((com.xunlei.downloadprovider.ad.common.h.a) this.c.get(thunder_ad_info2)).a((List) this.a.get(thunder_ad_info2));
                }
            }
            this.f = false;
        }

        public static /* synthetic */ void a(b bVar, THUNDER_AD_INFO thunder_ad_info, com.xunlei.downloadprovider.ad.common.h.a aVar) {
            bVar.c.put(thunder_ad_info, aVar);
            bVar.a();
        }
    }

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public final void a(int i) {
        if (!f.a()) {
            switch (i) {
                case 0:
                    if (this.f == 0) {
                        this.f = true;
                        new com.xunlei.downloadprovider.ad.common.adget.b.b().a(this.i.c, new b(this.i));
                        return;
                    }
                    return;
                case 1:
                    if (this.g == 0) {
                        this.g = true;
                        new com.xunlei.downloadprovider.ad.common.adget.b.b().a(this.j.c, new b(this.j));
                        return;
                    }
                    return;
                case 2:
                    if (this.h == 0) {
                        this.h = true;
                        new com.xunlei.downloadprovider.ad.common.adget.b.b().a(this.k.c, new b(this.k));
                        break;
                    }
                    return;
                default:
                    break;
            }
        }
    }

    public final void a(THUNDER_AD_INFO thunder_ad_info, com.xunlei.downloadprovider.ad.common.h.a aVar) {
        if (this.i.c.contains(thunder_ad_info)) {
            a.a(this.i, thunder_ad_info, aVar);
        } else if (this.j.c.contains(thunder_ad_info)) {
            a.a(this.j, thunder_ad_info, aVar);
        } else {
            if (this.k.c.contains(thunder_ad_info)) {
                a.a(this.k, thunder_ad_info, aVar);
            }
        }
    }
}
