package com.igexin.b.a.d;

import com.igexin.b.a.d.a.c;
import com.igexin.b.a.d.a.d;
import com.igexin.b.a.d.a.f;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public abstract class e extends a {
    protected static f E;
    public int A;
    public Exception B;
    public Object C;
    public f D;
    protected final ReentrantLock F;
    protected final Condition G;
    Thread H;
    protected volatile boolean I;
    int J;
    protected c K;
    private byte a;
    protected volatile boolean k;
    protected volatile boolean m;
    protected volatile boolean n;
    protected volatile boolean o;
    protected volatile boolean p;
    protected volatile boolean q;
    protected volatile boolean r;
    protected volatile boolean s;
    protected volatile boolean t;
    protected volatile long u;
    volatile int v;
    public long w;
    public int x;
    public int y;
    public int z;

    public e(int i) {
        this(i, null);
    }

    public e(int i, c cVar) {
        this.z = i;
        this.K = cVar;
        this.F = new ReentrantLock();
        this.G = this.F.newCondition();
    }

    public final int a(long j, TimeUnit timeUnit) {
        int i = 1;
        if (j > 0) {
            int a = E.k.a(this, j, timeUnit);
            if (a != 1) {
                switch (a) {
                    case -2:
                        return -2;
                    case -1:
                        this.u = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
                        return -1;
                    default:
                        break;
                }
            }
            return i;
        }
        i = 0;
        return i;
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(o(), TimeUnit.MILLISECONDS);
    }

    public final void a(int i) {
        this.a = (byte) (this.a & 15);
        this.a = (byte) (((i & 15) << 4) | this.a);
    }

    public final void a(int i, f fVar) {
        if (i < 0) {
            throw new IllegalArgumentException("second must > 0");
        }
        this.y = i;
        this.D = fVar;
    }

    public final void a(c cVar) {
        this.K = cVar;
    }

    public final void b(long j) {
        this.w = j;
    }

    public void b_() {
        this.H = Thread.currentThread();
        this.p = true;
    }

    public void c() {
        if (this.k || this.m) {
            f();
        }
    }

    public void d() {
        this.s = true;
    }

    public abstract void e();

    public void f() {
        this.C = null;
        this.B = null;
        this.H = null;
    }

    final void n() {
        this.J++;
        this.J &= 1090519038;
    }

    long o() {
        return this.u - System.currentTimeMillis();
    }

    public final void p() {
        this.k = true;
    }

    public final boolean q() {
        return this.n;
    }

    public final boolean r() {
        return this.m;
    }

    public final boolean s() {
        return this.k;
    }

    protected void t() {
    }

    public final void u() {
        this.m = true;
    }

    protected void v() {
        if (!this.o && !this.q && !this.r) {
            this.k = true;
            this.p = false;
        } else if (!this.q || this.k) {
            if (!(!this.o || this.n || this.k)) {
                this.p = false;
            }
        } else {
            this.p = false;
        }
    }

    protected void w() {
        if (this.K != null) {
            this.K.a(d.error);
        }
    }
}
