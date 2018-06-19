package com.xunlei.downloadprovider.homepage.category;

import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.xllib.b.d;
import java.util.Collection;
import java.util.List;

/* compiled from: ShortVideoCategoryActivity */
final class l implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ k b;

    l(k kVar, List list) {
        this.b = kVar;
        this.a = list;
    }

    public final void run() {
        if (!(this.a == null || this.a.isEmpty())) {
            i c = this.b.a.a.i;
            Collection collection = this.a;
            if (!d.a(collection)) {
                c.a.addAll(collection);
            }
            c.c();
        }
        ShortVideoCategoryActivity.a(this.b.a.a, false, this.a);
    }
}
