package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: MainTabActivity */
final class z implements d {
    final /* synthetic */ MainTabActivity a;

    z(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        MainTabActivity.e(this.a).obtainMessage(false).sendToTarget();
        if (i == 0) {
            MainTabActivity.e(this.a).obtainMessage(5).sendToTarget();
            MainTabActivity.e(this.a).obtainMessage(2).sendToTarget();
            MainTabActivity.a(this.a, MainTabActivity.f(this.a));
        }
        z = MainTabActivity.a;
    }
}
