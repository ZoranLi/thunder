package com.xunlei.downloadprovider.publiser.common.recommendfollow;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: FollowRecommendItemView */
final class a implements OnClickListener {
    final /* synthetic */ FollowRecommendItemView a;

    a(FollowRecommendItemView followRecommendItemView) {
        this.a = followRecommendItemView;
    }

    public final void onClick(View view) {
        long j;
        if (this.a.i != null) {
            if (this.a.i.b != 0) {
                this.a.a();
                j = this.a.i.b;
                FollowRecommendItemView.b(this.a.i.c);
                LoginHelper.a();
                j.a(j, l.c(), this.a.j);
            }
        }
        XLToast.showToast(this.a.getContext(), "该用户未登录");
        j = this.a.i.b;
        FollowRecommendItemView.b(this.a.i.c);
        LoginHelper.a();
        j.a(j, l.c(), this.a.j);
    }
}
