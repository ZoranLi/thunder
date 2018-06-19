package com.igexin.push.f.b;

import com.igexin.b.a.d.e;
import java.util.concurrent.TimeUnit;

public abstract class h extends e {
    long d;

    public h(long j) {
        this(0, j);
    }

    public h(long j, long j2) {
        super(5);
        this.d = j <= 0 ? j2 : (j - System.currentTimeMillis()) + j2;
        a(this.d, TimeUnit.MILLISECONDS);
    }

    public abstract void a();

    public final void b_() {
        super.b_();
        a();
    }

    protected void e() {
    }
}
