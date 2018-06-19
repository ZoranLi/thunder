package com.xunlei.downloadprovider.download.privatespace.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.download.privatespace.an;
import com.xunlei.downloadprovider.download.privatespace.v$a;

/* compiled from: PrivateSpaceFindPwdActivity */
final class i implements v$a {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    i(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void a() {
        if (!this.a.isFinishing()) {
            this.a.i();
            XLToast.showToast(this.a, "密码重置成功，使用新密码查看");
            this.a.finish();
        }
    }

    public final void a(int i, String str) {
        if (this.a.isFinishing() == 0) {
            this.a.i();
            an.b(f.a, "5");
            XLToast.showToast(this.a, str);
        }
    }
}
