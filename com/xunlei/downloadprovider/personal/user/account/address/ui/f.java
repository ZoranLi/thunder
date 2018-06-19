package com.xunlei.downloadprovider.personal.user.account.address.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.login.b.k;

/* compiled from: UserRegionSelectProvinceActivity */
final class f implements k {
    final /* synthetic */ UserRegionSelectProvinceActivity a;

    f(UserRegionSelectProvinceActivity userRegionSelectProvinceActivity) {
        this.a = userRegionSelectProvinceActivity;
    }

    public final void a(boolean z, int i, String str) {
        if (i == 0) {
            this.a.g.b();
            this.a.finish();
            com.xunlei.downloadprovider.personal.user.account.k.c("success");
            return;
        }
        XLToast.showToast(this.a.getApplicationContext(), "提交失败");
        com.xunlei.downloadprovider.personal.user.account.k.c("fail");
    }
}
