package com.xunlei.downloadprovider.personal;

import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: UserCenterFragment */
final class b implements h {
    final /* synthetic */ UserCenterFragment a;

    b(UserCenterFragment userCenterFragment) {
        this.a = userCenterFragment;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        if (z) {
            this.a.h.sendEmptyMessage(1001);
        }
    }
}
