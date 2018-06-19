package com.alibaba.sdk.android.feedback.xblink.f.a;

import com.alibaba.sdk.android.feedback.xblink.f.m;

class r implements Runnable {
    final /* synthetic */ m a;
    final /* synthetic */ q b;

    r(q qVar, m mVar) {
        this.b = qVar;
        this.a = mVar;
    }

    public void run() {
        if (this.b.a.g != null) {
            this.b.a.g.a(this.a);
        }
    }
}
