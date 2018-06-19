package com.igexin.push.f.b;

import com.igexin.b.a.b.c;
import com.igexin.push.config.m;
import com.igexin.push.core.g;
import com.igexin.push.d.b;
import com.igexin.push.util.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class e extends h {
    private long a;
    private AtomicBoolean b;

    public e() {
        super(604800000);
        this.a = m.I;
        this.b = new AtomicBoolean(false);
        this.o = true;
    }

    private void a(long j) {
        a(j, TimeUnit.MILLISECONDS);
    }

    public static e g() {
        return f.a;
    }

    protected void a() {
        a(this.a, TimeUnit.MILLISECONDS);
        boolean a = a.a(System.currentTimeMillis());
        if (!g.l && g.h && g.i && g.j && !g.l && !a && a.b()) {
            com.igexin.b.a.c.a.b("PollingTimerTask|run = true");
            b.a().g();
            g.E = 100;
            g.g().h();
        }
    }

    public int b() {
        return 20160629;
    }

    public void h() {
        if (!this.b.get()) {
            c.b().a(this, false, true);
            this.b.set(true);
        }
        a(this.a);
    }

    public void i() {
        a(604800000, TimeUnit.MILLISECONDS);
    }
}
