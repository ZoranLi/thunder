package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.b.e.m;
import com.xunlei.downloadprovider.personal.user.account.l;

/* compiled from: UserAccountSecurityActivity */
final class as implements m {
    final /* synthetic */ View a;
    final /* synthetic */ UserAccountSecurityActivity b;

    as(UserAccountSecurityActivity userAccountSecurityActivity, View view) {
        this.b = userAccountSecurityActivity;
        this.a = view;
    }

    public final void a(int i) {
        UserAccountSecurityActivity.a(this.b, i, -1);
        this.b.a(this.a, -1);
        this.b.a(i, null);
        l.a().b(i, "");
        l.a().a(i, -1);
    }

    public final void a() {
        XLToast.showToast(this.b, this.b.getString(R.string.user_account_security_unbind_fail));
    }
}
