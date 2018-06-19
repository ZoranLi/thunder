package com.xunlei.downloadprovider.vod.speeduptrial;

/* compiled from: BaseState */
public class a {
    protected int a;

    public final void a(int i) {
        if (c(i)) {
            this.a = i | (this.a & (i ^ -1));
        }
    }

    public final boolean b(int i) {
        return (this.a & i) == i;
    }

    public final void a() {
        if (c(4)) {
            this.a &= -5;
        }
    }

    private static boolean c(int i) {
        return i % 2 == 0;
    }
}
