package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: UserAccountMemberActivity */
final class y implements h {
    final /* synthetic */ UserAccountMemberActivity a;

    y(UserAccountMemberActivity userAccountMemberActivity) {
        this.a = userAccountMemberActivity;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        this.a.r.obtainMessage(100, i, -1).sendToTarget();
    }
}
