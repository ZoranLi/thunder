package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;

/* compiled from: UserAccountEditActivity */
final class k implements com.xunlei.downloadprovider.member.login.b.k {
    final /* synthetic */ UserAccountEditActivity a;

    k(UserAccountEditActivity userAccountEditActivity) {
        this.a = userAccountEditActivity;
    }

    public final void a(boolean z, int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("onUserInfoSetCompleted errorCode, userdata==>");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(str);
        if (z) {
            this.a.i.b();
            if (this.a.d) {
                com.xunlei.downloadprovider.personal.user.account.k.b("account_center", "success");
            } else {
                com.xunlei.downloadprovider.personal.user.account.k.b("success");
            }
            this.a.finish();
        } else if (i == true) {
            XLToast.showToast(this.a.getApplicationContext(), this.a.getString(R.string.user_account_set_nickname_sensitive_word));
        } else {
            XLToast.showToast(this.a.getApplicationContext(), this.a.getString(R.string.user_account_set_nickname_fail));
            if (this.a.d) {
                com.xunlei.downloadprovider.personal.user.account.k.b("account_center", "fail");
            } else {
                com.xunlei.downloadprovider.personal.user.account.k.b("fail");
            }
            this.a.finish();
        }
    }
}
