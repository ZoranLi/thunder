package com.xunlei.downloadprovider.personal;

import com.xunlei.downloadprovider.member.login.b.g;

/* compiled from: UserCenterFragment */
final class c implements g {
    final /* synthetic */ UserCenterFragment a;

    c(UserCenterFragment userCenterFragment) {
        this.a = userCenterFragment;
    }

    public final void onLogout() {
        this.a.h.sendEmptyMessage(1002);
    }
}
