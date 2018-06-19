package com.xunlei.downloadprovider.member.login.authphone;

import android.content.Context;
import com.xunlei.downloadprovider.member.login.c.h;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: PhoneAuthHelper */
final class s implements c<r$a> {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ r c;

    s(r rVar, Context context, String str) {
        this.c = rVar;
        this.a = context;
        this.b = str;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        r$a com_xunlei_downloadprovider_member_login_authphone_r_a = (r$a) obj;
        r.a(this.c);
        new StringBuilder("checkIsAuth--").append(com_xunlei_downloadprovider_member_login_authphone_r_a);
        if (!"ISAUTH".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a)) {
            this.c.d = true;
        }
        if ("ISAUTH".equals(com_xunlei_downloadprovider_member_login_authphone_r_a.a)) {
            this.c.a(com_xunlei_downloadprovider_member_login_authphone_r_a, this.b);
            return;
        }
        if (r.c == null) {
            r.b(this.a, this.b);
        }
        r.c = true;
        h.a().d();
    }

    public final void onFail(String str) {
        r.a(this.c);
    }
}
