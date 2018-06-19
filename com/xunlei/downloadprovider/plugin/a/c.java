package com.xunlei.downloadprovider.plugin.a;

import android.os.Bundle;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.member.login.authphone.q;

/* compiled from: IThunderMemberFacadeImpl */
final class c extends p {
    final /* synthetic */ b$b a;

    c(b$b com_xunlei_downloadprovider_plugin_a_b_b) {
        this.a = com_xunlei_downloadprovider_plugin_a_b_b;
    }

    public final void a(q qVar) {
        Bundle bundle = new Bundle(3);
        bundle.putBoolean("isAuthSuccess", qVar.a);
        bundle.putBoolean("isCancelAuth", qVar.b);
        bundle.putBoolean("isGoOnNextStep", qVar.c);
        com.xunlei.downloadprovider.h.c.a(BrothersApplication.getApplicationInstance(), "Action_User_Phone_Auth", bundle);
    }
}
