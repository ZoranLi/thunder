package com.huawei.hms.api;

import com.huawei.hms.support.api.ResolveResult;

/* compiled from: HuaweiApiClientImpl */
class e implements Runnable {
    final /* synthetic */ ResolveResult a;
    final /* synthetic */ b b;

    e(b bVar, ResolveResult resolveResult) {
        this.b = bVar;
        this.a = resolveResult;
    }

    public void run() {
        this.b.a.a(this.a);
    }
}
