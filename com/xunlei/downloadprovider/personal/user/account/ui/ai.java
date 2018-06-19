package com.xunlei.downloadprovider.personal.user.account.ui;

import android.widget.ImageView;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.downloadprovider.member.login.b.e.k;

/* compiled from: UserAccountPortraitSettingActivity */
final class ai implements k {
    final /* synthetic */ ImageView a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ int c;
    final /* synthetic */ UserAccountPortraitSettingActivity d;

    ai(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity, ImageView imageView, ImageView imageView2, int i) {
        this.d = userAccountPortraitSettingActivity;
        this.a = imageView;
        this.b = imageView2;
        this.c = i;
    }

    public final void a(XLThirdUserInfo xLThirdUserInfo) {
        UserAccountPortraitSettingActivity.a(this.d, xLThirdUserInfo, this.a, this.b, this.c);
    }
}
