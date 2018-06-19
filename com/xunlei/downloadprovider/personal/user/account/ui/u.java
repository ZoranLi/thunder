package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.login.XLSexType;
import com.xunlei.downloadprovider.personal.user.account.a.b;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: UserAccountInfoActivity */
final class u implements b {
    final /* synthetic */ UserAccountInfoActivity a;

    u(UserAccountInfoActivity userAccountInfoActivity) {
        this.a = userAccountInfoActivity;
    }

    public final void a(int i) {
        if (i == 0) {
            if (com.xunlei.xllib.android.b.a(this.a.getBaseContext())) {
                this.a.u.a(XLSexType.MALE, "user_data_sexy");
                this.a.v = XLSexType.MALE;
            } else {
                XLToast.showToast(this.a.getApplicationContext(), "无网络连接");
            }
        }
        if (i == 1) {
            if (com.xunlei.xllib.android.b.a(this.a.getBaseContext())) {
                this.a.u.a(XLSexType.FEMALE, "user_data_sexy");
                this.a.v = XLSexType.FEMALE;
            } else {
                XLToast.showToast(this.a.getApplicationContext(), "无网络连接");
            }
        }
        if (i == 2) {
            k.c("cancel", null);
        }
    }
}
