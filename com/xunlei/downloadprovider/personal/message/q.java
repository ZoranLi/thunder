package com.xunlei.downloadprovider.personal.message;

import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: MessageItemFragment */
final class q implements d {
    final /* synthetic */ MessageItemFragment a;

    q(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (z) {
            this.a.g = this.a.A.g.c();
            this.a.d();
        }
    }
}
