package com.huawei.hms.api;

import com.huawei.hms.support.api.ResolveResult;

/* compiled from: HuaweiApiClientImpl */
class d implements Runnable {
    final /* synthetic */ ResolveResult a;
    final /* synthetic */ a b;

    d(a aVar, ResolveResult resolveResult) {
        this.b = aVar;
        this.a = resolveResult;
    }

    public void run() {
        this.b.a.b(this.a);
    }
}
