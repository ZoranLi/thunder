package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;

class t implements Runnable {
    final /* synthetic */ IXAdContainer a;
    final /* synthetic */ HashMap b;
    final /* synthetic */ q c;

    t(q qVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = qVar;
        this.a = iXAdContainer;
        this.b = hashMap;
    }

    public void run() {
        this.c.b.a(this.a, this.b);
    }
}
