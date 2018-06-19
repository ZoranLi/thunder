package com.xunlei.downloadprovider.homepage.cinecism;

import com.umeng.message.proguard.k;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.member.login.authphone.q;

/* compiled from: CinecismDetailActivity */
final class d extends p {
    final /* synthetic */ CinecismDetailActivity a;

    d(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void a(q qVar) {
        if (qVar.c != null) {
            CinecismDetailActivity.q(this.a);
            if (this.a.p != null) {
                qVar = this.a.p;
                StringBuilder stringBuilder = new StringBuilder("javascript:window.get_userid(");
                stringBuilder.append(LoginHelper.a().g.c());
                stringBuilder.append(k.t);
                qVar.a(stringBuilder.toString());
            }
        }
    }
}
