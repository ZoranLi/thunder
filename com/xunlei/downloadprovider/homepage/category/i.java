package com.xunlei.downloadprovider.homepage.category;

import java.util.List;

/* compiled from: ShortVideoCategoryActivity */
final class i implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ h b;

    i(h hVar, List list) {
        this.b = hVar;
        this.a = list;
    }

    public final void run() {
        boolean z = true;
        if (!(this.a == null || this.a.isEmpty())) {
            if (this.b.a.a.i.getItemCount() <= 0) {
                this.b.a.a.m = System.currentTimeMillis();
                this.b.a.a.e.hide();
                z = false;
            }
            this.b.a.a.i.a(this.a);
        }
        ShortVideoCategoryActivity.a(this.b.a.a, z, this.a);
    }
}
