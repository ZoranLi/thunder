package com.xunlei.downloadprovider.homepage.follow.ui.view;

import com.xunlei.downloadprovider.homepage.follow.aa;
import java.util.List;

/* compiled from: RecommendFollowBaseView */
final class w implements aa {
    final /* synthetic */ RecommendFollowBaseView a;

    w(RecommendFollowBaseView recommendFollowBaseView) {
        this.a = recommendFollowBaseView;
    }

    public final void a(boolean z, List<String> list) {
        if (!(this.a.c == null || list == null)) {
            if (!list.isEmpty()) {
                if (list.contains(String.valueOf(this.a.c.b)) != null) {
                    if (z) {
                        this.a.b();
                        return;
                    }
                    this.a.a();
                }
            }
        }
    }
}
