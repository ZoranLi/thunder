package com.igexin.b.a.d;

import com.igexin.b.a.d.a.e;

public abstract class a implements e {
    private volatile boolean a;
    private long b;
    protected String l = getClass().getName();

    public void b(boolean z) {
        this.a = z ^ 1;
    }

    public boolean l() {
        return this.a;
    }

    public long m() {
        return this.b;
    }
}
