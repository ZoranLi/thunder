package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.text.TextUtils;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: FeedVideoItemView */
final class ac extends c {
    final /* synthetic */ z a;

    ac(z zVar) {
        this.a = zVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (i != 0 || !this.a.a || TextUtils.isEmpty(String.valueOf(this.a.a.a.getPublisherId()))) {
            this.a.h.a((boolean) 0);
        } else if (b.a().b(this.a.a.a.getPublisherId())) {
            this.a.h.a((boolean) 1);
        } else {
            z.a(this.a, this.a.a.a.getPublisherId());
        }
    }
}
