package com.xunlei.downloadprovider.member.payment.paymentfloat;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: FloatFragment */
final class j implements d {
    final /* synthetic */ FloatFragment a;

    j(FloatFragment floatFragment) {
        this.a = floatFragment;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (z) {
            this.a.d();
            LoginHelper.a().b(this.a.C);
            this.a.C = null;
        }
    }
}
