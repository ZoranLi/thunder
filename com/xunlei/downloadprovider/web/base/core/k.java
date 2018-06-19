package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.downloadprovider.member.payment.external.l;

/* compiled from: DefaultJsInterface */
final class k implements Runnable {
    final /* synthetic */ DefaultJsInterface a;

    k(DefaultJsInterface defaultJsInterface) {
        this.a = defaultJsInterface;
    }

    public final void run() {
        if (this.a.mPayListener != null) {
            String str = BaseJsInterface.TAG;
            l.a().b(this.a.mPayListener);
        }
    }
}
