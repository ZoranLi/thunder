package com.xiaomi.push.service;

class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run() {
        String a = this.a.b(this.a.k);
        synchronized (this.a.i) {
            this.a.m = a;
            this.a.p = true;
        }
        synchronized (this.a.g) {
            this.a.g.notifyAll();
        }
    }
}
