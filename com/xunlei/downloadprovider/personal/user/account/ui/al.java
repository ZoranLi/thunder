package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: UserAccountPortraitSettingActivity */
final class al implements h {
    final /* synthetic */ UserAccountPortraitSettingActivity a;

    al(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity) {
        this.a = userAccountPortraitSettingActivity;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        if (z) {
            UserAccountPortraitSettingActivity.k(this.a).sendEmptyMessage(107);
        }
    }
}
