package com.xunlei.downloadprovider.member.register.ui;

import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: MobileSetupActivity */
final class t implements d {
    final /* synthetic */ MobileSetupActivity a;

    t(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (i == 0) {
            this.a.finish();
        }
    }
}
