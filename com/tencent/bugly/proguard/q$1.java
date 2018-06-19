package com.tencent.bugly.proguard;

import com.tencent.bugly.beta.global.e;

/* compiled from: BUGLY */
class q$1 implements Runnable {
    final /* synthetic */ u a;
    final /* synthetic */ q b;

    q$1(q qVar, u uVar) {
        this.b = qVar;
        this.a = uVar;
    }

    public void run() {
        e.E.V.onPatchReceived(this.a.a());
    }
}
