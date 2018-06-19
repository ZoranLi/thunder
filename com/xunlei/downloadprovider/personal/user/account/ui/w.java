package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: UserAccountInfoActivity */
final class w implements h {
    final /* synthetic */ UserAccountInfoActivity a;

    w(UserAccountInfoActivity userAccountInfoActivity) {
        this.a = userAccountInfoActivity;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        if (z) {
            this.a.w.sendEmptyMessage(105);
            new StringBuilder("mHandler==111====").append(this.a.w);
        }
    }
}
