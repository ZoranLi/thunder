package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: BasePayActivity */
final class q implements d {
    final /* synthetic */ BasePayActivity a;

    q(BasePayActivity basePayActivity) {
        this.a = basePayActivity;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        z2 = this.a;
        if (!z) {
            if (i != 0) {
                z = false;
                z2.a(z);
            }
        }
        z = true;
        z2.a(z);
    }
}
