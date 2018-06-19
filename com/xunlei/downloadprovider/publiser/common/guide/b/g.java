package com.xunlei.downloadprovider.publiser.common.guide.b;

import com.xunlei.downloadprovider.publiser.common.guide.a.a;

/* compiled from: GuideScene */
public abstract class g {
    protected String a;
    public boolean b;
    protected a c;

    public abstract int b();

    public g() {
        this.a = "";
        this.b = false;
        this.c = null;
        this.a = getClass().getSimpleName();
    }

    public final void a(a aVar) {
        this.c = aVar;
    }

    public void a() {
        new StringBuilder("start isGuideTimeout(): ").append(this.b);
        if (!(this.b || this.c == null || !this.c.c())) {
            this.c.a(null);
        }
    }

    public final boolean c() {
        return (b() & 2) > 0;
    }
}
