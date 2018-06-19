package com.xunlei.downloadprovider.personal.user.account.address.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.login.b.k;

/* compiled from: UserRegionSelectCityActivity */
final class d implements k {
    final /* synthetic */ UserRegionSelectCityActivity a;

    d(UserRegionSelectCityActivity userRegionSelectCityActivity) {
        this.a = userRegionSelectCityActivity;
    }

    public final void a(boolean z, int i, String str) {
        if (z) {
            this.a.e.b();
            UserRegionSelectCityActivity.e(this.a);
            com.xunlei.downloadprovider.personal.user.account.k.c("success");
            return;
        }
        XLToast.showToast(this.a.getApplicationContext(), "提交失败");
        com.xunlei.downloadprovider.personal.user.account.k.c("fail");
    }
}
