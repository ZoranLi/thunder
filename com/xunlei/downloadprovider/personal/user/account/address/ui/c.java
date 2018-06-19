package com.xunlei.downloadprovider.personal.user.account.address.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.personal.user.account.address.ui.a.a;
import com.xunlei.xllib.android.b;

/* compiled from: UserRegionSelectCityActivity */
final class c implements a {
    final /* synthetic */ UserRegionSelectCityActivity a;

    c(UserRegionSelectCityActivity userRegionSelectCityActivity) {
        this.a = userRegionSelectCityActivity;
    }

    public final void a(int i) {
        if (i != 0) {
            if (b.a(this.a.getApplicationContext())) {
                this.a.e.a(String.valueOf(this.a.h), String.valueOf(((com.xunlei.downloadprovider.personal.user.account.address.c.a) this.a.d.c(i)).b), null);
                UserRegionSelectCityActivity.d(this.a);
                return;
            }
            XLToast.showToast(this.a.getApplicationContext(), "无网络连接");
        }
    }
}
