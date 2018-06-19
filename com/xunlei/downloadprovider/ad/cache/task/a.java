package com.xunlei.downloadprovider.ad.cache.task;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ADBackgroundHelper */
public final class a {
    private static a b;
    public List<a> a;

    /* compiled from: ADBackgroundHelper */
    public interface a {
        void a();

        void b();
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private a() {
        this.a = null;
        this.a = new ArrayList();
    }

    public final void a(a aVar) {
        if (!this.a.contains(aVar)) {
            this.a.add(aVar);
        }
    }
}
