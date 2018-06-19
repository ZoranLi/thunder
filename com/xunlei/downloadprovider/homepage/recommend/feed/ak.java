package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.xunlei.downloadprovider.homepage.follow.aa;
import java.util.List;

/* compiled from: FeedVideoItemView */
final class ak implements aa {
    final /* synthetic */ z a;

    ak(z zVar) {
        this.a = zVar;
    }

    public final void a(boolean z, List<String> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (list.contains(String.valueOf(this.a.a.a.getPublisherId())) != null) {
                    if (z) {
                        this.a.h.a((boolean) null);
                        return;
                    }
                    this.a.h.a(true);
                }
            }
        }
    }
}
