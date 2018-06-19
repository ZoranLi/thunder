package com.xunlei.downloadprovider.homepage.recommend.fans;

import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.util.List;

/* compiled from: FollowActivity */
final class r implements aa {
    final /* synthetic */ FollowActivity a;

    r(FollowActivity followActivity) {
        this.a = followActivity;
    }

    public final void a(boolean z, List<String> list) {
        if (this.a.f == LoginHelper.a().g.c()) {
            if (z) {
                for (String a : list) {
                    FollowActivity.a(this.a, a);
                }
            } else if (this.a.c) {
                this.a.c.b(list);
            }
        }
    }
}
