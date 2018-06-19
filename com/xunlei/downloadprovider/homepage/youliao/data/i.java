package com.xunlei.downloadprovider.homepage.youliao.data;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.search.b.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: YouliaoVideoManager */
public final class i {
    public static long b = 0;
    private static int c = -1;
    public d a = new d();

    /* compiled from: YouliaoVideoManager */
    public interface a {
        void a(List<com.xunlei.downloadprovider.homepage.youliao.flow.a> list, boolean z);
    }

    public final void a(a aVar, boolean z) {
        d dVar = this.a;
        b jVar = new j(this, aVar, z);
        aVar = d.a("http://api-shoulei-ssl.xunlei.com/cataract/api/v2/youliao_timelines", dVar.a);
        z = new StringBuilder("refreshPageData(");
        z.append(dVar.a);
        z.append(") url = ");
        z.append(aVar);
        if (!dVar.b) {
            XLThreadPool.execute(new e(dVar, aVar, jVar));
        }
    }

    public static void a() {
        b = System.currentTimeMillis();
    }

    static /* synthetic */ ArrayList a(List list) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.isEmpty())) {
            for (YouliaoVideo youliaoVideo : list) {
                int i = c + 1;
                c = i;
                if (i >= Integer.MAX_VALUE) {
                    c = 0;
                }
                arrayList.add(new com.xunlei.downloadprovider.homepage.youliao.flow.a(youliaoVideo, (long) c));
            }
        }
        return arrayList;
    }
}
