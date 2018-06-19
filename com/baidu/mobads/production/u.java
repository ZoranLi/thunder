package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;

class u implements Runnable {
    final /* synthetic */ IXAdContainer a;
    final /* synthetic */ HashMap b;
    final /* synthetic */ q c;

    u(q qVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = qVar;
        this.a = iXAdContainer;
        this.b = hashMap;
    }

    public void run() {
        this.c.b.b(this.a, this.b);
    }
}
