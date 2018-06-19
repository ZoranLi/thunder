package com.xunlei.downloadprovider.homepage.cinecism;

import com.xunlei.downloadprovider.homepage.follow.aa;
import java.util.List;

/* compiled from: CinecismDetailActivity */
final class q implements aa {
    final /* synthetic */ CinecismDetailActivity a;

    q(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void a(boolean z, List<String> list) {
        if (!(this.a.g == null || list == null)) {
            if (!list.isEmpty()) {
                if (list.contains(this.a.g.getUid()) != null) {
                    if (z) {
                        this.a.a((boolean) null);
                        return;
                    }
                    this.a.a(true);
                }
            }
        }
    }
}
