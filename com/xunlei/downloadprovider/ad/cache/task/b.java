package com.xunlei.downloadprovider.ad.cache.task;

import com.xunlei.downloadprovider.ad.cache.CacheException;
import com.xunlei.downloadprovider.ad.cache.a.b.a;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import java.util.HashSet;
import java.util.Set;

/* compiled from: BaseTask */
public abstract class b implements a {
    protected String a = "Ad.Cache.BaseTask";
    protected com.xunlei.downloadprovider.ad.cache.a.b b = null;
    protected final Set<STYLES_INFO> c;
    protected boolean d;

    protected void c(STYLES_INFO styles_info, int i) {
    }

    protected void d(STYLES_INFO styles_info) {
    }

    protected void d(STYLES_INFO styles_info, int i) {
    }

    public b(com.xunlei.downloadprovider.ad.cache.a.b bVar) {
        this.b = bVar;
        this.c = new HashSet();
        bVar = new StringBuilder();
        bVar.append(this.a);
        bVar.append(".");
        bVar.append(getClass().getSimpleName());
        bVar.append(".");
        bVar.append(this.b.a());
        this.a = bVar.toString();
    }

    public final void b(STYLES_INFO styles_info) {
        synchronized (this.c) {
            this.c.add(styles_info);
        }
    }

    public final void c(STYLES_INFO styles_info) {
        synchronized (this.c) {
            this.c.remove(styles_info);
        }
    }

    private boolean e(STYLES_INFO styles_info) {
        synchronized (this.c) {
            styles_info = this.c.contains(styles_info);
        }
        return styles_info;
    }

    public final void a(STYLES_INFO styles_info, int i) {
        if (this.d && e(styles_info)) {
            c(styles_info, i);
        }
    }

    public final void b(STYLES_INFO styles_info, int i) {
        if (this.d && e(styles_info)) {
            d(styles_info, i);
        }
    }

    public final void a(STYLES_INFO styles_info) {
        if (this.d && e(styles_info)) {
            d(styles_info);
        }
    }

    public void c() {
        this.d = true;
        com.xunlei.downloadprovider.ad.cache.a.b bVar = this.b;
        if (this == null) {
            throw new CacheException("OnCacheChangedListener can not be null");
        }
        bVar.d.add(this);
    }
}
