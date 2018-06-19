package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.downloadprovider.member.login.b.e.j;

/* compiled from: UserAccountPortraitSettingActivity */
final class ak implements j {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ UserAccountPortraitSettingActivity d;

    ak(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity, String str, String str2, String str3) {
        this.d = userAccountPortraitSettingActivity;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final void a(XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr) {
        for (XLBindedOtherAccountItem xLBindedOtherAccountItem : xLBindedOtherAccountItemArr) {
            int i = xLBindedOtherAccountItem.mThirdTypeId;
            if (i == 1) {
                UserAccountPortraitSettingActivity.e(this.d, xLBindedOtherAccountItem.mThirdRelationship);
                UserAccountPortraitSettingActivity.a(this.d, this.c, UserAccountPortraitSettingActivity.h(this.d), UserAccountPortraitSettingActivity.i(this.d), UserAccountPortraitSettingActivity.j(this.d));
            } else if (i == 15) {
                UserAccountPortraitSettingActivity.d(this.d, xLBindedOtherAccountItem.mThirdRelationship);
                UserAccountPortraitSettingActivity.a(this.d, this.b, UserAccountPortraitSettingActivity.e(this.d), UserAccountPortraitSettingActivity.f(this.d), UserAccountPortraitSettingActivity.g(this.d));
            } else if (i == 21) {
                UserAccountPortraitSettingActivity.c(this.d, xLBindedOtherAccountItem.mThirdRelationship);
                UserAccountPortraitSettingActivity.a(this.d, this.a, UserAccountPortraitSettingActivity.b(this.d), UserAccountPortraitSettingActivity.c(this.d), UserAccountPortraitSettingActivity.d(this.d));
            }
        }
    }
}
