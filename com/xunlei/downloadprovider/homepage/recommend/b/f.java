package com.xunlei.downloadprovider.homepage.recommend.b;

import com.xunlei.downloadprovider.homepage.recommend.feed.a;
import com.xunlei.downloadprovider.homepage.recommend.feed.i;
import com.xunlei.downloadprovider.homepage.recommend.feed.j;
import java.util.List;

/* compiled from: LikeRecordHelper */
public final class f implements Runnable {
    final /* synthetic */ c a;

    public f(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        List<b> a = a.a(c.a().a.getWritableDatabase().query(a.a, new String[]{a.b, a.c, a.d, a.e, a.f}, null, null, null, null, null, null));
        if (a != null) {
            for (b bVar : a) {
                a a2 = a.a();
                String str = bVar.d;
                com.xunlei.downloadprovider.homepage.recommend.a.a.a().a(str, 1, bVar.e, new i(a2, str), new j(a2));
                StringBuilder stringBuilder = new StringBuilder("上报点赞数据.....movieId, gcid = ");
                stringBuilder.append(bVar.d);
                stringBuilder.append(", ");
                stringBuilder.append(bVar.e);
            }
        }
    }
}
