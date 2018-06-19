package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: UserAccountPortraitSettingActivity */
final class af implements OnClickListener {
    final /* synthetic */ UserAccountPortraitSettingActivity a;

    af(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity) {
        this.a = userAccountPortraitSettingActivity;
    }

    public final void onClick(View view) {
        UserAccountPortraitSettingActivity.a(this.a).d = "qq";
        k.a("account_center", "qq");
        UserAccountPortraitSettingActivity.a(this.a, UserAccountPortraitSettingActivity.a(UserAccountPortraitSettingActivity.e(this.a)), 15, UserAccountPortraitSettingActivity.f(this.a), UserAccountPortraitSettingActivity.g(this.a));
    }
}
