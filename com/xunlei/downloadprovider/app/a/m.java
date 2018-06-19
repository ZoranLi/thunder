package com.xunlei.downloadprovider.app.a;

import com.xunlei.common.concurrent.XLThreadPool;

/* compiled from: MainActivityInitializationModule */
public abstract class m {
    protected abstract void d();

    protected abstract void e();

    m() {
    }

    public final void c() {
        d();
        XLThreadPool.execute(new n(this));
    }
}
