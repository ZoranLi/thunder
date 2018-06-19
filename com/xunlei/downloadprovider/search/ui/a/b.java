package com.xunlei.downloadprovider.search.ui.a;

import com.xunlei.downloadprovider.search.ui.a.f.a;

/* compiled from: BaseExposureRecyAdapter */
public abstract class b<T> extends f<T> {
    private int d = null;
    private boolean e;

    protected void a(int i, boolean z) {
    }

    protected void b() {
    }

    public b(a aVar, boolean z) {
        super(aVar);
        this.e = z;
    }

    private boolean d() {
        return this.d == 2;
    }

    public final void b(int i) {
        if (d() && this.d != i) {
            b();
        }
        this.d = i;
    }

    protected int a(int i) {
        if (!d() && this.e) {
            a(i, true);
        }
        return -1;
    }

    public void a(boolean z) {
        this.e = true;
    }

    public void a() {
        this.e = false;
    }
}
