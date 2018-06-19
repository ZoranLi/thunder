package com.xunlei.downloadprovider.homepage.follow.ui.view;

import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: RecommendFollowBaseView */
final class v implements a {
    final /* synthetic */ com.xunlei.downloadprovider.homepage.follow.b.a a;
    final /* synthetic */ RecommendFollowBaseView b;

    v(RecommendFollowBaseView recommendFollowBaseView, com.xunlei.downloadprovider.homepage.follow.b.a aVar) {
        this.b = recommendFollowBaseView;
        this.a = aVar;
    }

    public final void a() {
        this.b.a(this.a, true, "success", "");
        if (this.b.a != null) {
            this.b.a.a();
        }
    }

    public final void a(String str) {
        this.b.b();
        this.b.a(this.a, true, "fail", str);
    }
}
