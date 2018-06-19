package com.xunlei.downloadprovider.personal.user.account.ui;

import android.widget.ImageView;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.b.e.i;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: UserAccountPortraitSettingActivity */
final class ah implements i {
    final /* synthetic */ ImageView a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ int c;
    final /* synthetic */ UserAccountPortraitSettingActivity d;

    ah(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity, ImageView imageView, ImageView imageView2, int i) {
        this.d = userAccountPortraitSettingActivity;
        this.a = imageView;
        this.b = imageView2;
        this.c = i;
    }

    public final void a(int i, XLThirdUserInfo xLThirdUserInfo) {
        UserAccountPortraitSettingActivity.a(this.d, i);
        UserAccountPortraitSettingActivity.a(this.d, xLThirdUserInfo, this.a, this.b, this.c);
    }

    public final void a(int i, int i2, String str) {
        if (i2 != XLErrorCode.AUTH_USER_CANCLE) {
            if (i2 != XLErrorCode.BIND_DUPLICATE_ERROR) {
                UserAccountPortraitSettingActivity.b(this.d, R.string.user_account_security_bind_fail);
                if (UserAccountPortraitSettingActivity.a(this.d) != null) {
                    k.a("account_center", UserAccountPortraitSettingActivity.a(this.d).d, "fail");
                }
            } else {
                UserAccountPortraitSettingActivity.b(this.d, R.string.user_account_security_bind_duplicate);
                if (UserAccountPortraitSettingActivity.a(this.d) != null) {
                    k.a("account_center", UserAccountPortraitSettingActivity.a(this.d).d, "fail");
                }
            }
        } else if (UserAccountPortraitSettingActivity.a(this.d) != null) {
            k.a("account_center", UserAccountPortraitSettingActivity.a(this.d).d, "cancel");
        }
        if (i2 != XLErrorCode.AUTH_USER_CANCLE) {
            k.a(i, "fail", i2);
        }
    }
}
