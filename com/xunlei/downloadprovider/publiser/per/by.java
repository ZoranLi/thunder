package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.downloadprovider.homepage.follow.aa;
import java.util.List;

/* compiled from: PublisherActivity */
final class by implements aa {
    final /* synthetic */ PublisherActivity a;

    by(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void a(boolean z, List<String> list) {
        if (this.a.k == this.a.M.g.c()) {
            if (z && this.a.R > 0) {
                this.a.a(this.a.R - 1);
            }
            if (!z) {
                this.a.a(this.a.R + 1);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.k);
        if (list.contains(stringBuilder.toString()) != null) {
            PublisherActivity.b(this.a, z ^ 1);
        }
    }
}
