package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: MainTabActivity */
final class i implements h {
    final /* synthetic */ MainTabActivity a;

    i(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        MainTabActivity.e(this.a).obtainMessage(0).sendToTarget();
    }
}
