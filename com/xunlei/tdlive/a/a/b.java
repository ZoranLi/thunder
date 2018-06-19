package com.xunlei.tdlive.a.a;

import com.xunlei.tdlive.a.c;
import com.xunlei.tdlive.a.c.a;

/* compiled from: JsonArrayRecycleAdapter */
public abstract class b<T, H extends f> extends a<H> implements c<T> {
    protected a c;

    public b() {
        this(null);
    }

    public b(a aVar) {
        this.c = aVar;
    }

    public void a(T t) {
        a(t, true, false);
    }
}
