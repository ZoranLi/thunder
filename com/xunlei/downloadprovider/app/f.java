package com.xunlei.downloadprovider.app;

import com.xunlei.downloadprovider.member.payment.a.e$d;

/* compiled from: PollingService */
final class f implements e$d<Boolean, Integer> {
    final /* synthetic */ Object a;
    final /* synthetic */ a b;
    final /* synthetic */ PollingService c;

    f(PollingService pollingService, Object obj, a aVar) {
        this.c = pollingService;
        this.a = obj;
        this.b = aVar;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        Integer num = (Integer) obj2;
        synchronized (this.a) {
            this.b.a = true;
            this.b.b = bool.booleanValue();
            this.b.c = num.intValue();
            this.a.notifyAll();
        }
    }

    public final void a(String str) {
        synchronized (this.a) {
            this.b.a = false;
            this.b.b = false;
            this.a.notifyAll();
        }
    }
}
