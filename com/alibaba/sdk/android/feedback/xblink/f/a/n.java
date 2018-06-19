package com.alibaba.sdk.android.feedback.xblink.f.a;

import com.alibaba.sdk.android.feedback.xblink.f.m;

class n implements Runnable {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public void run() {
        m mVar = new m();
        com.alibaba.sdk.android.feedback.util.n.a("AudioPlayFailed", null);
        if (this.a.c.d != null) {
            this.a.c.d.b(mVar);
        }
    }
}
