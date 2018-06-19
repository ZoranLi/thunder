package com.alibaba.wireless.security.framework;

import com.alibaba.wireless.security.framework.b.a;

class g implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ b c;

    g(b bVar, String str, String str2) {
        this.c = bVar;
        this.a = str;
        this.b = str2;
    }

    public void run() {
        try {
            this.c.a(this.a, this.b, true);
        } catch (Throwable e) {
            a.a("load weak dependency", e);
        }
    }
}
