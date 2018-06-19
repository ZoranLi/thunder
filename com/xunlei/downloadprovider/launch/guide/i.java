package com.xunlei.downloadprovider.launch.guide;

import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.authphone.r$a;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: GuideLoginHelper */
final class i implements c<r$a> {
    final /* synthetic */ d a;

    i(d dVar) {
        this.a = dVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        r$a com_xunlei_downloadprovider_member_login_authphone_r_a = (r$a) obj;
        d.e;
        new StringBuilder("checkIsAuth--").append(com_xunlei_downloadprovider_member_login_authphone_r_a);
        if ("NOAUTH".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a) == null) {
            this.a.a.f();
        } else if (d.a().e.b() != null) {
            this.a.b.c();
        }
    }

    public final void onFail(String str) {
        d.e;
        this.a.a.f();
    }
}
