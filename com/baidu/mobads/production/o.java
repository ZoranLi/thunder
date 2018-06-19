package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;

class o implements Runnable {
    final /* synthetic */ IXAdContainerContext a;
    final /* synthetic */ b b;

    o(b bVar, IXAdContainerContext iXAdContainerContext) {
        this.b = bVar;
        this.a = iXAdContainerContext;
    }

    public void run() {
        this.b.a(this.a);
    }
}
