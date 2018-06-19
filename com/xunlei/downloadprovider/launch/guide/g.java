package com.xunlei.downloadprovider.launch.guide;

import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: GuideLoginHelper */
final class g implements d {
    final /* synthetic */ d a;

    g(d dVar) {
        this.a = dVar;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        d.e;
        z = new StringBuilder("OnLoginCompleted() errorCode=");
        z.append(i);
        z.append(" errorDesc=");
        z.append(XLErrorCode.getErrorDesc(i));
        z.append(" isAutoLog=");
        z.append(z2);
        if (i != 0) {
            this.a.a.f();
        } else {
            this.a.f = 1;
            LoginHelper.a().b();
        }
        this.a.a;
        m.m();
    }
}
