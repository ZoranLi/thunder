package com.baidu.mobads.production;

import com.baidu.mobads.vo.d;

class n implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ b b;

    n(b bVar, d dVar) {
        this.b = bVar;
        this.a = dVar;
    }

    public void run() {
        this.b.b(this.a);
    }
}
