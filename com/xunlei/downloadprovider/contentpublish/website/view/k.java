package com.xunlei.downloadprovider.contentpublish.website.view;

import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView.a;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: WebsiteCardView */
final class k implements a {
    final /* synthetic */ a a;

    k(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        this.a.r.a("success", "");
    }

    public final void a(String str) {
        this.a.r.a("fail", str);
    }

    public final void a(boolean z) {
        this.a.r.e();
    }

    public final LoginFrom b() {
        return LoginFrom.HOME_FOLLOW;
    }
}
