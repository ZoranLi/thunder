package com.xunlei.downloadprovider.ad.recommend.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.b.b;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.recommend.RecommendADConst.RecommendSSPAdMapping;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RecommendAdModel */
public class c {
    static c a = null;
    private static final String e = "c";
    final Map<Integer, List<l>> b;
    final Map<Integer, List<String>> c;
    boolean d;

    /* compiled from: RecommendAdModel */
    public interface a {
        void a(String str, int i, String str2);

        void a(List<l> list, int i, String str);
    }

    private c() {
        this.d = false;
        this.d = false;
        this.b = new HashMap();
        this.c = new HashMap();
        this.c.put(Integer.valueOf(0), new ArrayList(3));
        this.c.put(Integer.valueOf(1), new ArrayList(3));
        this.c.put(Integer.valueOf(2), new ArrayList(3));
        this.b.put(Integer.valueOf(0), new ArrayList(3));
        this.b.put(Integer.valueOf(1), new ArrayList(3));
        this.b.put(Integer.valueOf(2), new ArrayList(3));
    }

    public static c a() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    public final void a(int i, com.xunlei.downloadprovider.ad.common.h.a aVar, String str) {
        List<THUNDER_AD_INFO> thunderAdInfos = RecommendSSPAdMapping.getThunderAdInfos(i);
        if (thunderAdInfos.isEmpty()) {
            str = new StringBuilder("plz configure for this pageIndex: ");
            str.append(i);
            throw new RuntimeException(str.toString());
        }
        b(i);
        a(i);
        a fVar = new f(this, aVar);
        if ("change".equals(str) != null) {
            aVar = com.xunlei.downloadprovider.ad.a.a.a();
            String str2 = b.a;
            b bVar = null;
            switch (i) {
                case 0:
                    aVar.b = new b(i);
                    bVar = aVar.b;
                    break;
                case 1:
                    aVar.c = new b(i);
                    bVar = aVar.c;
                    break;
                case 2:
                    aVar.d = new b(i);
                    bVar = aVar.d;
                    break;
                default:
                    break;
            }
            if (bVar != null) {
                aVar = new b();
                List arrayList = new ArrayList();
                arrayList.addAll(RecommendSSPAdMapping.getThunderAdInfos(bVar.b));
                aVar.a(arrayList, new com.xunlei.downloadprovider.ad.a.c(bVar));
            }
        }
        for (THUNDER_AD_INFO thunder_ad_info : thunderAdInfos) {
            StringBuilder stringBuilder = new StringBuilder("loadAds pageIndex: ");
            stringBuilder.append(i);
            stringBuilder.append(" thunderAdInfo: ");
            stringBuilder.append(thunder_ad_info.name());
            stringBuilder.append(" loadType: ");
            stringBuilder.append(str);
            if ("change".equals(str)) {
                com.xunlei.downloadprovider.ad.a.a a = com.xunlei.downloadprovider.ad.a.a.a();
                com.xunlei.downloadprovider.ad.common.h.a dVar = new d(this, fVar, i, thunder_ad_info);
                String str3 = b.a;
                switch (i) {
                    case 0:
                        b.a(a.b, thunder_ad_info, dVar);
                        break;
                    case 1:
                        b.a(a.c, thunder_ad_info, dVar);
                        break;
                    case 2:
                        b.a(a.d, thunder_ad_info, dVar);
                        break;
                    default:
                        break;
                }
            }
            com.xunlei.downloadprovider.ad.a.a.a().a(thunder_ad_info, new e(this, fVar, i, thunder_ad_info));
        }
    }

    final void a(int i) {
        List list = (List) this.c.get(Integer.valueOf(i));
        list.clear();
        list.addAll(RecommendSSPAdMapping.getPositionIds(i));
    }

    final void b(int i) {
        int positionCount = RecommendSSPAdMapping.getPositionCount(i);
        List list = (List) this.b.get(Integer.valueOf(i));
        list.clear();
        for (int i2 = 0; i2 < positionCount; i2++) {
            list.add(null);
        }
    }

    @NonNull
    final List<l> c(int i) {
        List<l> list = (List) this.b.get(Integer.valueOf(i));
        List<l> arrayList = new ArrayList(3);
        for (l lVar : list) {
            if (lVar != null) {
                arrayList.add(lVar);
            }
        }
        return arrayList;
    }

    private static String a(l lVar) {
        if (lVar == null) {
            return "";
        }
        if (lVar.v == null) {
            new StringBuilder("wtf, model's styleInfo is null. model.positionId: ").append(lVar.A());
            return TextUtils.isEmpty(lVar.k()) ? lVar.l() : lVar.k();
        } else {
            switch (g.a[lVar.v.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return lVar.k();
                case 10:
                case 11:
                case 12:
                    return lVar.l();
                default:
                    return lVar.l();
            }
        }
    }

    static /* synthetic */ l a(c cVar, int i, List list) {
        List<l> list2 = (List) cVar.b.get(Integer.valueOf(i));
        for (l lVar : list) {
            if (com.xunlei.downloadprovider.ad.common.a.a(lVar)) {
                for (l lVar2 : list2) {
                    Object obj = 1;
                    if (lVar != lVar2) {
                        if (lVar != null) {
                            if (lVar2 != null) {
                                if (lVar.y().equals(lVar2.y())) {
                                    if (lVar.j() != null || lVar2.j() != null) {
                                        if (lVar.j() == null || lVar2.j() == null || !lVar.j().equals(lVar2.j())) {
                                            if (a(lVar) != null || a(lVar2) != null) {
                                                if (!(a(lVar) == null || a(lVar2) == null || !a(lVar).equals(a(lVar2)))) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        obj = null;
                    }
                    if (obj == null) {
                    }
                }
                return lVar;
            }
        }
        return null;
    }

    static /* synthetic */ boolean a(c cVar, int i, l lVar) {
        String A = lVar.A();
        if (TextUtils.isEmpty(A)) {
            cVar = new StringBuilder("positionId is invalid: ");
            cVar.append(A);
            cVar.append(", plz set valid positionId first");
        } else {
            RecommendSSPAdMapping fromPositionId = RecommendSSPAdMapping.fromPositionId(A);
            if (fromPositionId == null) {
                cVar = new StringBuilder("positionId is invalid: ");
                cVar.append(A);
                cVar.append(", can not find correct local position");
            } else {
                int i2 = fromPositionId.position;
                List list = (List) cVar.b.get(Integer.valueOf(i));
                if (i2 < list.size()) {
                    if (i2 >= 0) {
                        list.set(i2, lVar);
                        lVar = new StringBuilder("isSaveSuccess pageIndex: ");
                        lVar.append(i);
                        lVar.append(" position: ");
                        lVar.append(fromPositionId.position);
                        return true;
                    }
                }
                i = new StringBuilder("wtf,position is invalid. position: ");
                i.append(i2);
                i.append(" mData.size(): ");
                i.append(list.size());
            }
        }
        return null;
    }

    static /* synthetic */ void a(c cVar, int i, com.xunlei.downloadprovider.ad.common.h.a aVar) {
        if (((List) cVar.c.get(Integer.valueOf(i))).isEmpty()) {
            cVar = cVar.c(i);
            if (cVar.isEmpty() == 0) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            } else if (aVar != null) {
                aVar.a(-11, "-11");
            }
        }
    }
}
