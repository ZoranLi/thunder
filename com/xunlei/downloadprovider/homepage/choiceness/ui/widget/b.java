package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: FollowBtnView */
final class b implements a {
    final /* synthetic */ FollowBtnView a;

    b(FollowBtnView followBtnView) {
        this.a = followBtnView;
    }

    public final void a() {
        this.a.setEnabled(false);
        if (this.a.c != null) {
            this.a.c.a();
        }
    }

    public final void a(String str) {
        this.a.setEnabled(true);
        if (this.a.c != null) {
            this.a.c.a(str);
        }
    }
}
