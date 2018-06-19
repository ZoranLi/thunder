package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class j {
    private a a;
    private Handler b;
    private volatile boolean c;
    private final boolean d;
    private int e;
    private volatile b f;

    private class a extends Thread {
        final /* synthetic */ j a;
        private final LinkedBlockingQueue<b> b = new LinkedBlockingQueue();

        public a(j jVar) {
            this.a = jVar;
            super("PackageProcessor");
        }

        public void a(b bVar) {
            this.b.add(bVar);
        }

        public void run() {
            long a = this.a.e > 0 ? (long) this.a.e : Long.MAX_VALUE;
            while (!this.a.c) {
                try {
                    this.a.f = (b) this.b.poll(a, TimeUnit.SECONDS);
                    if (this.a.f != null) {
                        this.a.b.sendMessage(this.a.b.obtainMessage(0, this.a.f));
                        this.a.f.b();
                        this.a.b.sendMessage(this.a.b.obtainMessage(1, this.a.f));
                    } else if (this.a.e > 0) {
                        this.a.a();
                    }
                } catch (Throwable e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public j() {
        this(false);
    }

    public j(boolean z) {
        this(z, 0);
    }

    public j(boolean z, int i) {
        this.b = null;
        this.c = false;
        this.e = 0;
        this.b = new k(this, Looper.getMainLooper());
        this.d = z;
        this.e = i;
    }

    private synchronized void a() {
        this.a = null;
        this.c = true;
    }

    public synchronized void a(b bVar) {
        if (this.a == null) {
            this.a = new a(this);
            this.a.setDaemon(this.d);
            this.c = false;
            this.a.start();
        }
        this.a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.b.postDelayed(new l(this, bVar), j);
    }
}
