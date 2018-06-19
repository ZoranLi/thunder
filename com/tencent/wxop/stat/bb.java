package com.tencent.wxop.stat;

class bb implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ au b;

    bb(au auVar, int i) {
        this.b = auVar;
        this.a = i;
    }

    public void run() {
        this.b.b(this.a, true);
        this.b.b(this.a, false);
    }
}
