package com.xunlei.downloadprovider.homepage.cinecism.ui;

import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView.a;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: CinecismCardView */
final class c implements a {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        this.a.d.a("success", "");
    }

    public final void a(String str) {
        this.a.d.a("fail", str);
    }

    public final void a(boolean z) {
        this.a.d.c();
    }

    public final LoginFrom b() {
        return LoginFrom.HOME_FOLLOW;
    }
}
