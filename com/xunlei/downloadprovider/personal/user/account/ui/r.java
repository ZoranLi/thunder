package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.downloadprovider.member.login.b.e.l;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: UserAccountInfoActivity */
final class r implements l {
    final /* synthetic */ UserAccountInfoActivity a;

    r(UserAccountInfoActivity userAccountInfoActivity) {
        this.a = userAccountInfoActivity;
    }

    public final void a(int i) {
        this.a.r = true;
        if (i == 0) {
            k.d("success");
        } else {
            k.d("fail");
        }
    }
}
