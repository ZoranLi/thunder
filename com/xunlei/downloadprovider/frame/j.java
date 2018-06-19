package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.member.login.b.g;

/* compiled from: MainTabActivity */
final class j implements g {
    final /* synthetic */ MainTabActivity a;

    j(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void onLogout() {
        MainTabActivity.e(this.a).obtainMessage(0).sendToTarget();
        MainTabActivity.e(this.a).obtainMessage(3).sendToTarget();
        MainTabActivity.e(this.a).obtainMessage(4).sendToTarget();
        MainTabActivity.a(this.a, MainTabActivity.f(this.a));
    }
}
