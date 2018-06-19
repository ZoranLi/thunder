package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.downloadprovider.member.login.b.e.i;

/* compiled from: DefaultJsInterface */
final class v implements i {
    final /* synthetic */ String a;
    final /* synthetic */ DefaultJsInterface b;

    v(DefaultJsInterface defaultJsInterface, String str) {
        this.b = defaultJsInterface;
        this.a = str;
    }

    public final void a(int i, XLThirdUserInfo xLThirdUserInfo) {
        this.b.bindThirdAccountCallback(this.a, i, "success", 0, "");
    }

    public final void a(int i, int i2, String str) {
        this.b.bindThirdAccountCallback(this.a, i, "fail", i2, str);
    }
}
