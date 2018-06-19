package com.xunlei.downloadprovider.homepage;

/* compiled from: AutoRefreshHelper */
public final class a {
    public boolean a;
    public boolean b = this.c;
    private boolean c = true;
    private a d;

    /* compiled from: AutoRefreshHelper */
    public interface a {
        void a();

        long b();

        void c();

        int d();
    }

    public a(a aVar) {
        this.d = aVar;
    }

    public final void a() {
        StringBuilder stringBuilder = new StringBuilder("checkAndAutoRefreshData--mShouldAutoRefresh=");
        stringBuilder.append(this.c);
        stringBuilder.append("|mAllowRefreshOnNextCheck=");
        stringBuilder.append(this.b);
        if (!this.c) {
            return;
        }
        if (!this.b) {
            this.b = true;
        } else if (!this.a) {
            if (System.currentTimeMillis() - this.d.b() >= ((long) ((this.d.d() * 60) * 1000))) {
                this.a = true;
                this.d.a();
            }
        }
    }

    public final void b() {
        this.d.c();
    }
}
