package com.xunlei.downloadprovider.homepage.choiceness.ui;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: HomeChoicenessFragment */
final class t implements d {
    final /* synthetic */ HomeChoicenessFragment a;

    t(HomeChoicenessFragment homeChoicenessFragment) {
        this.a = homeChoicenessFragment;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (this.a.getActivity()) {
            z = this.a.m;
            i = z.a();
            z2 = new StringBuilder("dateAndUser");
            z2.append(LoginHelper.a().g.c());
            i.putString(z2.toString(), "");
            z.b();
            this.a.p.d();
        }
    }
}
