package com.igexin.push.c;

import com.igexin.b.a.c.a;
import com.igexin.push.core.g;
import com.igexin.push.f.b.h;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class k extends h {
    public static final AtomicBoolean a = new AtomicBoolean(false);
    private static final String b = "com.igexin.push.c.k";
    private static k c;
    private boolean e;

    private k() {
        super(150);
        this.o = true;
    }

    public static synchronized k c_() {
        k kVar;
        synchronized (k.class) {
            if (c == null) {
                c = new k();
            }
            kVar = c;
        }
        return kVar;
    }

    protected void a() {
        a(f.a, TimeUnit.MILLISECONDS);
        if (this.e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("|detect task already stop");
            a.b(stringBuilder.toString());
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("|");
        stringBuilder.append(f.a / 1000);
        stringBuilder.append("s passed, do task method, start redect ~~~~");
        a.b(stringBuilder.toString());
        boolean g = com.igexin.push.util.a.g();
        g.h = g;
        if (g) {
            i.a().d();
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("|");
        stringBuilder.append(f.a / 1000);
        stringBuilder.append("s passed, network is unavailable, stop ###");
        a.b(stringBuilder.toString());
    }

    public void a(long j) {
        a(j, TimeUnit.MILLISECONDS);
    }

    public int b() {
        return 20150607;
    }

    public void g() {
        this.o = false;
        this.e = true;
        p();
    }
}
