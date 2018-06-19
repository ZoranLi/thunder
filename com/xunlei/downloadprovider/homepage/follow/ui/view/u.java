package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: RecommendFollowBaseView */
final class u extends c {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;
    final /* synthetic */ RecommendFollowBaseView c;

    u(RecommendFollowBaseView recommendFollowBaseView, Context context, a aVar) {
        this.c = recommendFollowBaseView;
        this.a = context;
        this.b = aVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (i == 0) {
            this.c.c(this.b);
        }
    }
}
