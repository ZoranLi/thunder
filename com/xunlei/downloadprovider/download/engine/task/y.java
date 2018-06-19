package com.xunlei.downloadprovider.download.engine.task;

/* compiled from: TaskRequest */
public final class y implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ Object b;
    final /* synthetic */ x c;

    public y(x xVar, int i, Object obj) {
        this.c = xVar;
        this.a = i;
        this.b = obj;
    }

    public final void run() {
        this.c.a(this.b);
    }
}
