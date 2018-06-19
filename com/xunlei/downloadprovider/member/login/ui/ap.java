package com.xunlei.downloadprovider.member.login.ui;

import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;
import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: XLLoginOfflineDlgActivity */
final class ap implements d {
    final /* synthetic */ XLLoginOfflineDlgActivity a;

    ap(XLLoginOfflineDlgActivity xLLoginOfflineDlgActivity) {
        this.a = xLLoginOfflineDlgActivity;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (XLLoginOfflineDlgActivity.b()) {
            if (i == 0) {
                this.a.finish();
                return;
            }
            XLLoginOfflineDlgActivity.a(this.a).a(LoginPageType.LOGIN_PAGE, this.a, null, LoginFrom.FORCE_LOGIN, -1, null);
        }
    }
}
