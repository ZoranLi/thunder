package com.xunlei.downloadprovider.ad.c.a;

/* compiled from: Timer */
public abstract class f {
    private static final String a = "f";

    public abstract long b();

    public abstract void c();

    public abstract long d();

    protected abstract long e();

    public final boolean f() {
        StringBuilder stringBuilder = new StringBuilder("isTimeUp getCurrentTime: ");
        stringBuilder.append(e());
        stringBuilder.append(" getLatelyExecuteTime: ");
        stringBuilder.append(b());
        stringBuilder.append(" getCycleLength: ");
        stringBuilder.append(d());
        return e() - b() >= d();
    }
}
