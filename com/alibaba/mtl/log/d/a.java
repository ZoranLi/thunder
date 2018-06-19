package com.alibaba.mtl.log.d;

import com.alibaba.mtl.log.e.b;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.Random;

/* compiled from: UploadEngine */
public final class a {
    static a a = new a();
    protected long b = com.alibaba.mtl.log.a.a.c();
    int c;
    private boolean d = false;

    public static a a() {
        return a;
    }

    public final synchronized void b() {
        this.d = true;
        if (r.a().b(2)) {
            r.a().a(2);
        }
        d();
        Random random = new Random();
        if (!c.c()) {
            r.a().a(2, new b(this), (long) random.nextInt((int) this.b));
        }
    }

    public final synchronized void c() {
        this.d = false;
        r.a().a(2);
    }

    private long d() {
        long d;
        i.a("UploadEngine", "UTDC.bBackground:", Boolean.valueOf(com.alibaba.mtl.log.a.a), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(b.a(com.alibaba.mtl.log.a.c())));
        boolean a = b.a(com.alibaba.mtl.log.a.c()) ^ true;
        com.alibaba.mtl.log.a.a = a;
        com.alibaba.mtl.log.a.a.c();
        if (a) {
            d = com.alibaba.mtl.log.a.a.d() + ((long) this.c);
        } else {
            d = com.alibaba.mtl.log.a.a.c() + ((long) this.c);
        }
        this.b = d;
        if (com.alibaba.mtl.log.a.a.a()) {
            this.b = 3000;
        }
        return this.b;
    }
}
