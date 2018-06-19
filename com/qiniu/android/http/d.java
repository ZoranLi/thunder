package com.qiniu.android.http;

/* compiled from: Client */
final class d implements Runnable {
    final /* synthetic */ h a;
    final /* synthetic */ o b;

    d(h hVar, o oVar) {
        this.a = hVar;
        this.b = oVar;
    }

    public final void run() {
        this.a.a(this.b, this.b.p);
    }
}
