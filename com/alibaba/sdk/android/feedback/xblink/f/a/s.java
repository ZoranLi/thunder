package com.alibaba.sdk.android.feedback.xblink.f.a;

import com.alibaba.sdk.android.feedback.xblink.f.m;

class s implements Runnable {
    final /* synthetic */ q a;

    s(q qVar) {
        this.a = qVar;
    }

    public void run() {
        m mVar = new m();
        mVar.a("HY_FAILED");
        if (this.a.a.g != null) {
            this.a.a.g.b(mVar);
        }
    }
}
