package com.xunlei.downloadprovider.ad.recommend.a;

import android.database.Observable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: RecommendAdObservable */
public class l extends Observable<b> {
    private static final String a = "l";

    public /* synthetic */ void registerObserver(Object obj) {
        a((b) obj);
    }

    public final void a(b bVar) {
        synchronized (this.mObservers) {
            if (this.mObservers.contains(bVar)) {
                this.mObservers.remove(bVar);
            }
        }
        super.registerObserver(bVar);
    }

    public final void a(int i, List<com.xunlei.downloadprovider.ad.common.adget.l> list) {
        new StringBuilder("onloadSuccess: ").append(Arrays.toString(list.toArray()));
        Iterator it = this.mObservers.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.a == i) {
                bVar.b.a(list);
            }
        }
    }

    public final void a(int i, int i2, String str) {
        Iterator it = this.mObservers.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.a == i) {
                bVar.b.a(i2, str);
            }
        }
    }
}
