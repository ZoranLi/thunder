package com.xunlei.downloadprovider.ad.recommend.a;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.notification.NotificationADInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RecommendAdModelUpperDecoration */
public class h extends l {
    private static String c = "h";
    private static h d;
    public c a;
    public final Map<Integer, Boolean> b;
    private Map<Integer, List<l>> e;

    private h() {
        this.a = null;
        this.e = null;
        this.a = c.a();
        this.b = new HashMap();
        this.e = new HashMap();
        this.e.put(Integer.valueOf(0), new ArrayList(3));
        this.e.put(Integer.valueOf(1), new ArrayList(3));
        this.e.put(Integer.valueOf(2), new ArrayList(3));
    }

    public static h a() {
        if (d == null) {
            d = new h();
        }
        return d;
    }

    public static void b() {
        d = null;
        c.a().d = true;
        c.a = null;
    }

    public final void c() {
        this.b.clear();
        ((List) this.e.get(Integer.valueOf(0))).clear();
        ((List) this.e.get(Integer.valueOf(1))).clear();
        ((List) this.e.get(Integer.valueOf(2))).clear();
        c a = c.a();
        ((List) a.c.get(Integer.valueOf(0))).clear();
        ((List) a.c.get(Integer.valueOf(1))).clear();
        ((List) a.c.get(Integer.valueOf(2))).clear();
        ((List) a.b.get(Integer.valueOf(0))).clear();
        ((List) a.b.get(Integer.valueOf(1))).clear();
        ((List) a.b.get(Integer.valueOf(2))).clear();
    }

    public final void a(int[] iArr) {
        for (int i = 0; i <= 0; i++) {
            int i2 = iArr[0];
            this.a.a(i2, new i(this, i2), NotificationADInfo.REPORT_STATUS_SHOW);
        }
    }

    public final List<l> a(int i) {
        new StringBuilder("getAdInfos.size: ").append(((List) this.e.get(Integer.valueOf(i))).size());
        List<l> arrayList = new ArrayList();
        arrayList.addAll((Collection) this.e.get(Integer.valueOf(i)));
        return arrayList;
    }

    static /* synthetic */ void a(h hVar, int i, List list) {
        List list2 = (List) hVar.e.get(Integer.valueOf(i));
        list2.clear();
        list2.addAll(list);
    }
}
