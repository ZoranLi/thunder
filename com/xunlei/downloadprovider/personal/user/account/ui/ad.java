package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.e.h;
import com.xunlei.downloadprovider.personal.user.account.k;
import com.xunlei.xllib.android.b;

/* compiled from: UserAccountPortraitSettingActivity */
final class ad implements h {
    final /* synthetic */ UserAccountPortraitSettingActivity a;

    ad(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity) {
        this.a = userAccountPortraitSettingActivity;
    }

    public final void a(int i, String str) {
        if (i == 0) {
            UserAccountPortraitSettingActivity.n(this.a);
            if (UserAccountPortraitSettingActivity.o(this.a) != 0) {
                UserAccountPortraitSettingActivity.a(this.a);
                LoginHelper.a().e();
                UserAccountPortraitSettingActivity.p(this.a);
            }
            UserAccountPortraitSettingActivity.l(this.a).b();
            XLToast.showToast(this.a.getApplicationContext(), this.a.getString(R.string.user_account_set_avatar_success));
            k.a("account_center", str, "success");
        } else if (i == XLErrorCode.AVATAR_MANUAL_AUDIT) {
            XLToast.showToast(this.a.getApplicationContext(), this.a.getString(R.string.user_account_set_avatar_waiting_manual_audit));
        } else {
            if (b.a(this.a.getApplicationContext()) != 0) {
                XLToast.showToast(this.a.getApplicationContext(), this.a.getString(R.string.user_account_set_avatar_fail));
            } else {
                XLToast.showToast(this.a.getApplicationContext(), "无网络连接");
            }
            k.a("account_center", str, "fail");
        }
    }
}
