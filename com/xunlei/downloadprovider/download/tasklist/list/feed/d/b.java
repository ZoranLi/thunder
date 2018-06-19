package com.xunlei.downloadprovider.download.tasklist.list.feed.d;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.d;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* compiled from: TaskListFeedModel */
public class b {
    private static b c;
    HashMap<Integer, Integer> a;
    private c b;
    private long d;

    private b() {
        this.b = null;
        this.b = new c();
        this.a = new HashMap();
        this.d = -1;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    public static void a(long j) {
        synchronized (b.class) {
            if (c != null) {
                if (c.d != -1) {
                    c.d = Math.min(j, c.d);
                } else {
                    c.d = j;
                }
            }
        }
    }

    public final int a(int i) {
        if ((this.a.get(Integer.valueOf(i)) != null ? ((Integer) this.a.get(Integer.valueOf(i))).intValue() : 0) == 0) {
            return 1;
        }
        return ((Integer) this.a.get(Integer.valueOf(i))).intValue();
    }

    public final void a(WeakReference<a<List<e>>> weakReference, int i, int i2, String str) {
        c cVar = this.b;
        a cVar2 = new c(this, weakReference, i, i2);
        long j = this.d;
        if (f.a() != null) {
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.b();
        }
        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a.a().a(new d(cVar, i, i2, j, str, cVar2));
    }

    public static void b() {
        c = null;
    }

    static /* synthetic */ void a(List list, int i, int i2) {
        if (!com.xunlei.xllib.b.d.a(list)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            String stringBuilder2 = stringBuilder.toString();
            long currentTimeMillis = System.currentTimeMillis();
            for (e eVar : list) {
                Object obj = eVar.c;
                StringBuilder stringBuilder3;
                if (obj instanceof com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.a) {
                    com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.a aVar = (com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.a) obj;
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(aVar.b(), "contentid", aVar.b(), i2);
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(aVar.b(), "refreshid", stringBuilder2, i2);
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(aVar.b(), "refreshnum", String.valueOf(i), i2);
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(list.indexOf(eVar) + 1);
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(aVar.b(), "rn", stringBuilder3.toString(), i2);
                } else if (obj instanceof com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a) {
                    com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a aVar2 = (com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a) obj;
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(aVar2.c, "contentid", aVar2.c, i2);
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(aVar2.c, "refreshid", stringBuilder2, i2);
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(aVar2.c, "refreshnum", String.valueOf(i), i2);
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(list.indexOf(eVar) + 1);
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(aVar2.c, "rn", stringBuilder3.toString(), i2);
                } else if (obj instanceof m) {
                    m mVar = (m) obj;
                    if (mVar.b != null) {
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(mVar.b.getVideoId(), "contentid", mVar.b.getVideoId(), i2);
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(mVar.b.getVideoId(), "refreshid", stringBuilder2, i2);
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(mVar.b.getVideoId(), "refreshnum", String.valueOf(i), i2);
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(list.indexOf(eVar) + 1);
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(mVar.b.getVideoId(), "rn", stringBuilder3.toString(), i2);
                    } else {
                        return;
                    }
                } else if (obj instanceof n) {
                    n nVar = (n) obj;
                    if (nVar.a != null) {
                        r6 = new StringBuilder("website");
                        r6.append(nVar.b());
                        r6 = r6.toString();
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(r6, "contentid", nVar.a.a, i2);
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(r6, "refreshid", stringBuilder2, i2);
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(r6, "refreshnum", String.valueOf(i), i2);
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(list.indexOf(eVar) + 1);
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(r6, "rn", stringBuilder3.toString(), i2);
                    } else {
                        return;
                    }
                } else if (obj instanceof com.xunlei.downloadprovider.homepage.choiceness.a.a.c) {
                    com.xunlei.downloadprovider.homepage.choiceness.a.a.c cVar = (com.xunlei.downloadprovider.homepage.choiceness.a.a.c) obj;
                    if (cVar.a != null) {
                        r6 = new StringBuilder("photo_article");
                        r6.append(cVar.b());
                        r6 = r6.toString();
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(r6, "contentid", cVar.a.a, i2);
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(r6, "refreshid", stringBuilder2, i2);
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(r6, "refreshnum", String.valueOf(i), i2);
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(list.indexOf(eVar) + 1);
                        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(r6, "rn", stringBuilder3.toString(), i2);
                    } else {
                        return;
                    }
                } else if (obj instanceof l) {
                    l lVar = (l) obj;
                    r6 = new StringBuilder();
                    long j = currentTimeMillis + 1;
                    r6.append(currentTimeMillis);
                    lVar.u = r6.toString();
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(lVar.u, "contentid", lVar.e(), i2);
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(lVar.u, "refreshid", stringBuilder2, i2);
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(lVar.u, "refreshnum", String.valueOf(i), i2);
                    r6 = new StringBuilder();
                    r6.append(list.indexOf(eVar) + 1);
                    com.xunlei.downloadprovider.download.tasklist.list.feed.a.a().a(lVar.u, "rn", r6.toString(), i2);
                    currentTimeMillis = j;
                } else {
                    String str = com.xunlei.downloadprovider.download.tasklist.list.feed.a.a;
                    new StringBuilder("info type error! ").append(obj.getClass().getSimpleName());
                }
            }
        }
    }
}
