package com.tencent.smtt.sdk;

class e implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ d b;

    e(d dVar, boolean z) {
        this.b = dVar;
        this.a = z;
    }

    public void run() {
        this.b.c.onReceiveValue(Boolean.valueOf(this.a));
    }
}
