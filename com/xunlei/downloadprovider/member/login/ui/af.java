package com.xunlei.downloadprovider.member.login.ui;

import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: LoginDlgActivity */
final class af implements d {
    final /* synthetic */ LoginDlgActivity a;

    af(LoginDlgActivity loginDlgActivity) {
        this.a = loginDlgActivity;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        StringBuilder stringBuilder = new StringBuilder("onLoginCompleted--isSuccess=");
        stringBuilder.append(z);
        stringBuilder.append("|errCode=");
        stringBuilder.append(i);
        stringBuilder.append("|isAutoLog=");
        stringBuilder.append(z2);
        LoginDlgActivity.i(this.a);
        if (i == 0) {
            this.a.finish();
            LoginDlgActivity.j(this.a);
        } else if (i == true) {
            LoginDlgActivity.h(this.a);
        } else {
            LoginDlgActivity.a(this.a, i);
        }
    }
}
