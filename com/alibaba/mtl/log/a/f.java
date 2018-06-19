package com.alibaba.mtl.log.a;

import com.alibaba.mtl.log.c.c;
import com.alibaba.mtl.log.e.i;

/* compiled from: SystemConfig */
final class f implements Runnable {
    f() {
    }

    public final void run() {
        c a = c.a();
        i.a("LogStoreMgr", "[clear]");
        a.a.b();
        a.b.clear();
    }
}
