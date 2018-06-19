package com.xunlei.downloadprovider.download.tasklist.list.feed.d;

import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;
import java.lang.ref.WeakReference;

/* compiled from: TaskListFeedModel */
final class c implements a<d> {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ b d;

    c(b bVar, WeakReference weakReference, int i, int i2) {
        this.d = bVar;
        this.a = weakReference;
        this.b = i;
        this.c = i2;
    }

    public final /* synthetic */ void a(Object obj) {
        d dVar = (d) obj;
        a aVar = (a) this.a.get();
        if (aVar != null) {
            if (!dVar.a() || dVar.c == null || dVar.c.size() <= 3) {
                if (dVar.a == 0 && dVar.a() && (dVar.c == null || dVar.c.size() <= 3)) {
                    if (f.a() != null) {
                        b.a("-999", "results less than 3");
                    }
                } else if (f.a()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(dVar.a);
                    b.a(stringBuilder.toString(), dVar.b);
                }
                aVar.a(-1, "");
            } else {
                b.a(dVar.c, this.b, this.c);
                aVar.a(dVar.c);
            }
        }
    }

    public final void a(int i, String str) {
        a aVar = (a) this.a.get();
        if (aVar != null) {
            aVar.a(i, str);
        }
    }
}
