package com.xunlei.downloadprovider.app.a;

/* compiled from: InitializationWrapper */
final class h implements Runnable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        this.a.b.a();
        this.a.d = true;
        this.a.e.sendMessageAtFrontOfQueue(this.a.e.obtainMessage(1));
    }
}
