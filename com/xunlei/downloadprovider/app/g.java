package com.xunlei.downloadprovider.app;

import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: PollingService */
final class g implements c<Boolean> {
    final /* synthetic */ Object a;
    final /* synthetic */ boolean[] b;
    final /* synthetic */ PollingService c;

    g(PollingService pollingService, Object obj, boolean[] zArr) {
        this.c = pollingService;
        this.a = obj;
        this.b = zArr;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Boolean bool = (Boolean) obj;
        synchronized (this.a) {
            this.b[0] = true;
            this.b[1] = bool.booleanValue();
            this.a.notifyAll();
        }
    }

    public final void onFail(String str) {
        synchronized (this.a) {
            this.b[0] = false;
            this.b[1] = false;
            this.a.notifyAll();
        }
    }
}
