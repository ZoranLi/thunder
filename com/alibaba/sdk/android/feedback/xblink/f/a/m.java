package com.alibaba.sdk.android.feedback.xblink.f.a;

import com.alibaba.sdk.android.feedback.util.n;

class m implements Runnable {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public void run() {
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        n.a("AudioPlaySuccess", null);
        if (this.a.c.d != null) {
            this.a.c.d.a(mVar);
        }
    }
}
