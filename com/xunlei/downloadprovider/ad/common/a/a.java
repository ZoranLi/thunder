package com.xunlei.downloadprovider.ad.common.a;

@Deprecated
/* compiled from: AbstractExecutor */
public abstract class a {
    protected a a;
    protected int b = 1;

    public abstract void a();

    public final void a(a aVar) {
        this.a = aVar;
        aVar.b = this.b + 1;
    }
}
