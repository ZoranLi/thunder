package com.xunlei.tdlive.util;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: StopWatch */
public class j {
    private Handler a = null;
    private Timer b = null;
    private int c = 1000;
    private Runnable d;
    private boolean e = false;

    public j(int i, Runnable runnable) {
        a(i, runnable);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        b();
    }

    public void a(int i) {
        this.c = i;
    }

    private void a(int i, Runnable runnable) {
        if (i > 0) {
            if (runnable != null) {
                this.c = i;
                this.d = runnable;
            }
        }
    }

    public void a() {
        if (this.a == null) {
            this.a = new Handler();
        }
        if (this.b == null) {
            StringBuilder stringBuilder = new StringBuilder("StopWatch_");
            stringBuilder.append(hashCode());
            this.b = new Timer(stringBuilder.toString());
            TimerTask anonymousClass1 = new TimerTask(this) {
                final /* synthetic */ j a;

                {
                    this.a = r1;
                }

                public void run() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r2 = this;
                    r0 = r2.a;	 Catch:{ Exception -> 0x0020 }
                    r0 = r0.d;	 Catch:{ Exception -> 0x0020 }
                    if (r0 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x0020 }
                L_0x0008:
                    r0 = r2.a;	 Catch:{ Exception -> 0x0020 }
                    r0 = r0.a;	 Catch:{ Exception -> 0x0020 }
                    if (r0 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x0020 }
                L_0x0010:
                    r0 = r2.a;	 Catch:{ Exception -> 0x0020 }
                    r0 = r0.a;	 Catch:{ Exception -> 0x0020 }
                    r1 = r2.a;	 Catch:{ Exception -> 0x0020 }
                    r1 = r1.d;	 Catch:{ Exception -> 0x0020 }
                    r0.post(r1);	 Catch:{ Exception -> 0x0020 }
                L_0x001f:
                    return;
                L_0x0020:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.j.1.run():void");
                }
            };
            if (this.e) {
                this.b.schedule(anonymousClass1, (long) this.c);
                return;
            }
            this.b.schedule(anonymousClass1, (long) this.c, (long) this.c);
        }
    }

    public void b() {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        if (this.a != null) {
            this.a.removeCallbacks(this.d);
            this.a = null;
        }
    }

    public void c() {
        b();
        a();
    }

    public void d() {
        if (this.d != null) {
            this.d.run();
        }
    }
}
