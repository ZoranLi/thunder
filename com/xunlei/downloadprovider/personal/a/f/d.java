package com.xunlei.downloadprovider.personal.a.f;

import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.user.a.a;
import com.xunlei.downloadprovider.personal.user.account.m;

/* compiled from: UserCenterUtil */
final class d implements a {
    final /* synthetic */ LoginHelper a;
    final /* synthetic */ int b = SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_LENGTH;
    final /* synthetic */ StaticHandler c;

    d(LoginHelper loginHelper, StaticHandler staticHandler) {
        this.a = loginHelper;
        this.c = staticHandler;
    }

    public final void a(String str) {
        str = com.xunlei.downloadprovider.member.login.c.a.a(str.equals("1") ^ 1, m.a(this.a.g.d()), this.a.g().toString(), this.a.f(), m.a(this.a.j(), this.a.k()), this.a.h());
        Message obtain = Message.obtain();
        obtain.what = this.b;
        obtain.arg1 = str;
        this.c.sendMessage(obtain);
    }
}
