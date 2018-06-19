package com.xunlei.downloadprovider.ad.common;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Timer;

/* compiled from: RequestTimeoutController */
public final class i {
    public ArrayList<a> a;
    public int b;
    public boolean c = false;
    public Timer d = null;
    Handler e = new Handler(Looper.getMainLooper());

    /* compiled from: RequestTimeoutController */
    public interface a {
        void g_();
    }

    public i(int i) {
        this.b = i;
        this.a = new ArrayList();
        this.d = new Timer(com.alipay.sdk.data.a.f);
    }

    public final void a() {
        this.d.schedule(new j(this), (long) (this.b * 1000));
    }

    public final void a(a aVar) {
        this.a.add(aVar);
    }

    public final void b(a aVar) {
        this.a.remove(aVar);
    }
}
