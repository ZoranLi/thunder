package com.igexin.push.f.b;

import com.igexin.b.a.b.c;
import com.igexin.push.core.a.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class a extends h {
    private static a b;
    private List<d> a;

    private a() {
        super(360000);
        this.o = true;
        this.a = new ArrayList();
    }

    public static a g() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private void h() {
        a(360000, TimeUnit.MILLISECONDS);
    }

    protected void a() {
        f.a().A();
        for (d dVar : this.a) {
            if (dVar.b()) {
                dVar.a();
                dVar.a(System.currentTimeMillis());
            }
        }
        h();
        c.b().a(this);
    }

    public boolean a(d dVar) {
        return (this.a == null || this.a.contains(dVar) || !this.a.add(dVar)) ? false : true;
    }

    public int b() {
        return 0;
    }
}
