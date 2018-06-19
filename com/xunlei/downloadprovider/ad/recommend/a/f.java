package com.xunlei.downloadprovider.ad.recommend.a;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h;
import com.xunlei.downloadprovider.ad.recommend.a.c.a;
import java.util.Arrays;
import java.util.List;

/* compiled from: RecommendAdModel */
final class f implements a {
    final /* synthetic */ h.a a;
    final /* synthetic */ c b;

    f(c cVar, h.a aVar) {
        this.b = cVar;
        this.a = aVar;
    }

    public final void a(List<l> list, int i, String str) {
        c.e;
        new StringBuilder("onLoadComplete. mIsDestroyed: ").append(this.b.d);
        if (!this.b.d) {
            String arrays;
            l a;
            c.e;
            StringBuilder stringBuilder = new StringBuilder("onLoadComplete pageIndex: ");
            stringBuilder.append(i);
            stringBuilder.append(" positionId: ");
            stringBuilder.append(str);
            stringBuilder.append(" result: ");
            if (list != null) {
                if (!list.isEmpty()) {
                    arrays = Arrays.toString(list.toArray());
                    stringBuilder.append(arrays);
                    if (!(list == null || list.isEmpty())) {
                        a = c.a(this.b, i, (List) list);
                        c.e;
                        new StringBuilder("uniqueData: ").append(a != null ? "null" : a.toString());
                        if (a != null) {
                            c.a(this.b, i, a);
                        }
                    }
                    ((List) this.b.c.get(Integer.valueOf(i))).remove(str);
                    c.a(this.b, i, this.a);
                }
            }
            arrays = "null";
            stringBuilder.append(arrays);
            a = c.a(this.b, i, (List) list);
            c.e;
            if (a != null) {
            }
            new StringBuilder("uniqueData: ").append(a != null ? "null" : a.toString());
            if (a != null) {
                c.a(this.b, i, a);
            }
            ((List) this.b.c.get(Integer.valueOf(i))).remove(str);
            c.a(this.b, i, this.a);
        }
    }

    public final void a(String str, int i, String str2) {
        c.e;
        new StringBuilder("onLoadFail. mIsDestroyed: ").append(this.b.d);
        if (!this.b.d) {
            c.e;
            StringBuilder stringBuilder = new StringBuilder("onLoadFail positionId: ");
            stringBuilder.append(str2);
            stringBuilder.append(" errorInfo: ");
            stringBuilder.append(str);
            ((List) this.b.c.get(Integer.valueOf(i))).remove(str2);
            c.a(this.b, i, this.a);
        }
    }
}
