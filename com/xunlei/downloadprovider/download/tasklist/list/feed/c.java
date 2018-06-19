package com.xunlei.downloadprovider.download.tasklist.list.feed;

import com.xunlei.downloadprovider.ad.c.a.b;
import com.xunlei.downloadprovider.ad.c.a.d;
import com.xunlei.downloadprovider.ad.c.a.e;
import com.xunlei.downloadprovider.ad.c.a.g;
import java.util.concurrent.TimeUnit;

/* compiled from: PageClearTask */
public final class c extends g implements b {
    private static final long a = TimeUnit.DAYS.toMillis(1);
    private final e b = new d("sp_key_clear_page_time");

    public final void a() {
        d a = d.a();
        a.a.put(Integer.valueOf(0), Integer.valueOf(1));
        a.a.put(Integer.valueOf(1), Integer.valueOf(1));
        a.a.put(Integer.valueOf(2), Integer.valueOf(1));
        a.b();
        c();
    }

    protected final long b() {
        return this.b.a();
    }

    protected final void c() {
        this.b.a(System.currentTimeMillis());
    }

    protected final long d() {
        return a;
    }
}
