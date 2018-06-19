package com.xunlei.downloadprovider.download.privatespace.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.download.privatespace.a.a.h;

/* compiled from: PrivateSpaceFindPwdActivity */
final class d implements h {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    d(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void a() {
        this.a.d.setText("");
        XLToast.showToast(this.a, "验证码已发送，请注意查收");
        this.a.g();
    }

    public final void a(int i, String str) {
        this.a.d.setText("");
        if (i == 201) {
            XLThreadPool.execute(new g(this.a));
        } else {
            XLToast.showToast(this.a, str);
        }
    }
}
