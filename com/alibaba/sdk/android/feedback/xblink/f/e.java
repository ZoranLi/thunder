package com.alibaba.sdk.android.feedback.xblink.f;

class e implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ String b;
    final /* synthetic */ d c;

    e(d dVar, f fVar, String str) {
        this.c = dVar;
        this.a = fVar;
        this.b = str;
    }

    public void run() {
        this.c.a(this.a, this.b);
    }
}
