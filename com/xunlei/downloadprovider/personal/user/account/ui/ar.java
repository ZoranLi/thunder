package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.b.e.i;
import com.xunlei.downloadprovider.personal.user.account.k;
import com.xunlei.downloadprovider.personal.user.account.l;

/* compiled from: UserAccountSecurityActivity */
final class ar implements i {
    final /* synthetic */ View a;
    final /* synthetic */ UserAccountSecurityActivity b;

    ar(UserAccountSecurityActivity userAccountSecurityActivity, View view) {
        this.b = userAccountSecurityActivity;
        this.a = view;
    }

    public final void a(int i, XLThirdUserInfo xLThirdUserInfo) {
        UserAccountSecurityActivity.a(this.b, i, 0);
        this.b.a(this.a, 0);
        String stringValue = xLThirdUserInfo.getStringValue("nickname");
        this.b.a(i, stringValue);
        l.a().b(i, stringValue);
        l.a().a(i, 0);
        k.a(i, "success", 0);
    }

    public final void a(int i, int i2, String str) {
        if (i2 != XLErrorCode.AUTH_USER_CANCLE) {
            if (i2 != XLErrorCode.BIND_DUPLICATE_ERROR) {
                XLToast.showToast(this.b, this.b.getString(R.string.user_account_security_bind_fail));
            } else {
                XLToast.showToast(this.b, this.b.getString(R.string.user_account_security_bind_duplicate));
            }
        }
        if (i2 != XLErrorCode.AUTH_USER_CANCLE) {
            k.a(i, "fail", i2);
        }
    }
}
