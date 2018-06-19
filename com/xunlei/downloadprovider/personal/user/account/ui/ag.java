package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: UserAccountPortraitSettingActivity */
final class ag implements OnClickListener {
    final /* synthetic */ UserAccountPortraitSettingActivity a;

    ag(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity) {
        this.a = userAccountPortraitSettingActivity;
    }

    public final void onClick(View view) {
        UserAccountPortraitSettingActivity.a(this.a).d = "weibo";
        k.a("account_center", "weibo");
        UserAccountPortraitSettingActivity.a(this.a, UserAccountPortraitSettingActivity.a(UserAccountPortraitSettingActivity.h(this.a)), 1, UserAccountPortraitSettingActivity.i(this.a), UserAccountPortraitSettingActivity.j(this.a));
    }
}
