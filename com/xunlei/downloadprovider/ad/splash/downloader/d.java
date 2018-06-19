package com.xunlei.downloadprovider.ad.splash.downloader;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DownloadRequestQueue */
public final class d {
    public Set<DownloadRequest> a = new HashSet();
    public PriorityBlockingQueue<DownloadRequest> b = new PriorityBlockingQueue();
    public b[] c;
    private AtomicInteger d = new AtomicInteger();
    private a e;

    /* compiled from: DownloadRequestQueue */
    class a {
        final Executor a;
        final /* synthetic */ d b;

        public a(d dVar, Handler handler) {
            this.b = dVar;
            this.a = new e(this, dVar, handler);
        }
    }

    public d() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.c = new b[Runtime.getRuntime().availableProcessors()];
        this.e = new a(this, handler);
    }

    public final void a() {
        b();
        for (int i = 0; i < this.c.length; i++) {
            b bVar = new b(this.b, this.e);
            this.c[i] = bVar;
            bVar.start();
        }
    }

    public final void b() {
        for (int i = 0; i < this.c.length; i++) {
            if (this.c[i] != null) {
                b bVar = this.c[i];
                bVar.a = true;
                bVar.interrupt();
            }
        }
    }

    public final int a(DownloadRequest downloadRequest) {
        int incrementAndGet = this.d.incrementAndGet();
        downloadRequest.h = this;
        synchronized (this.a) {
            this.a.add(downloadRequest);
        }
        downloadRequest.b = incrementAndGet;
        this.b.add(downloadRequest);
        return incrementAndGet;
    }
}
