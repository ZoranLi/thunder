package com.xunlei.downloadprovider.publiser.common.recommendfollow;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: FollowRecommendItemView */
final class b implements a {
    final /* synthetic */ FollowRecommendItemView a;

    b(FollowRecommendItemView followRecommendItemView) {
        this.a = followRecommendItemView;
    }

    public final void a() {
        this.a.g.setBackgroundResource(R.drawable.btn_unfollow_selector2);
        this.a.g.setText("已关注");
        j.a(this.a.i.b, "success", null, this.a.j);
    }

    public final void a(String str) {
        j.a(this.a.i.b, "fail", str, this.a.j);
    }
}
