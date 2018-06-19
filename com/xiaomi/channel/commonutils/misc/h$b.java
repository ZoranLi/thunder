package com.xiaomi.channel.commonutils.misc;

import com.xiaomi.channel.commonutils.misc.h.a;

class h$b implements Runnable {
    a c;

    public h$b(a aVar) {
        this.c = aVar;
    }

    void a() {
    }

    void b() {
    }

    public void run() {
        a();
        this.c.run();
        b();
    }
}
