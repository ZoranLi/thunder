package com.igexin.push.f.b;

import com.igexin.b.a.c.a;
import com.igexin.push.core.a.f;
import com.igexin.push.core.g;
import com.igexin.push.core.i;
import java.util.concurrent.TimeUnit;

public class c extends h {
    private static c a;

    public c() {
        super(i.a().b());
        this.o = true;
    }

    public static c g() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    protected void a() {
        f.a().A();
        g.F = System.currentTimeMillis();
        if (g.l) {
            a.b("heartbeatReq");
            com.igexin.push.core.f.a().i().g();
            return;
        }
        a.b("HeartBeatTimerTask doTaskMethod isOnline = false, refresh wait time !!!!!!");
        h();
    }

    public final int b() {
        return -2147483642;
    }

    public void c() {
        super.c();
        if (!this.k) {
            h();
        }
    }

    public void d() {
    }

    public void h() {
        a(i.a().b(), TimeUnit.MILLISECONDS);
    }

    public void i() {
    }
}
