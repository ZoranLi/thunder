package com.xunlei.downloadprovider.homepage.follow.ui.view;

import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.b.g;
import java.util.List;

/* compiled from: RecommendFollowListBaseView */
final class ad implements Runnable {
    final /* synthetic */ ac a;

    ad(ac acVar) {
        this.a = acVar;
    }

    public final void run() {
        int i;
        g gVar = this.a.a;
        List a = gVar.a();
        int i2 = 0;
        if (a.isEmpty()) {
            i = 0;
        } else {
            int min = Math.min(a.size(), 4);
            for (int i3 = 0; i3 < min; i3++) {
                gVar.c.set(i3, (a) a.get(i3));
            }
            i = 1;
        }
        if (i != 0) {
            List c = this.a.a.c();
            while (i2 < c.size()) {
                this.a.c.b[i2].a((a) c.get(i2));
                i2++;
            }
        }
    }
}
