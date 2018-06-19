package com.xunlei.downloadprovider.personal.user.account.address.ui;

import com.xunlei.downloadprovider.personal.user.account.address.ui.a.a;

/* compiled from: UserRegionSelectProvinceActivity */
final class e implements a {
    final /* synthetic */ UserRegionSelectProvinceActivity a;

    e(UserRegionSelectProvinceActivity userRegionSelectProvinceActivity) {
        this.a = userRegionSelectProvinceActivity;
    }

    public final void a(int i) {
        if (i == 0 && !(this.a.i == null && this.a.j == null)) {
            this.a.g.a(this.a.i, this.a.j, null);
            UserRegionSelectProvinceActivity.d(this.a);
        }
        if (i >= 2) {
            UserRegionSelectCityActivity.a(this.a, (com.xunlei.downloadprovider.personal.user.account.address.c.a) this.a.f.c(i - 1));
        }
    }
}
