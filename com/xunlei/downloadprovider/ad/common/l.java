package com.xunlei.downloadprovider.ad.common;

import android.os.Handler;
import java.util.ArrayList;

/* compiled from: RequestTimeoutMillisController */
public final class l {
    ArrayList<a> a;
    boolean b;
    private long c;
    private Handler d = new m(this);

    /* compiled from: RequestTimeoutMillisController */
    public interface a {
        void a();
    }

    public l(long j) {
        this.c = j;
        this.a = new ArrayList();
    }

    public final void a(a aVar) {
        this.a.add(aVar);
    }

    public final void a() {
        this.d.removeMessages(1000);
    }

    public final void b() {
        this.d.removeMessages(1000);
        this.d.sendEmptyMessageDelayed(1000, this.c);
    }
}
