package com.xunlei.downloadprovider.publiser.common.recommendfollow;

import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: FollowRecommendItemView */
final class c extends com.xunlei.downloadprovider.member.login.b.c {
    final /* synthetic */ long a;
    final /* synthetic */ FollowRecommendItemView b;

    c(FollowRecommendItemView followRecommendItemView, long j) {
        this.b = followRecommendItemView;
        this.a = j;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (i == 0 && !b.a().b(this.a) && this.a != LoginHelper.a().g.c()) {
            this.b.a(this.a);
        }
    }
}
