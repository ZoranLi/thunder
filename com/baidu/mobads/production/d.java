package com.baidu.mobads.production;

class d implements Runnable {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public void run() {
        this.a.h.resize(this.a.getProdBase().getWidth(), this.a.getProdBase().getHeight());
    }
}
