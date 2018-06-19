package com.tencent.open.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: ProGuard */
public class a extends i implements Callback {
    private b a;
    private FileWriter b;
    private File c;
    private char[] d;
    private volatile g e;
    private volatile g f;
    private volatile g g;
    private volatile g h;
    private volatile boolean i;
    private HandlerThread j;
    private Handler k;

    public a(b bVar) {
        this(c.b, true, h.a, bVar);
    }

    public a(int i, boolean z, h hVar, b bVar) {
        super(i, z, hVar);
        this.i = false;
        a(bVar);
        this.e = new g();
        this.f = new g();
        this.g = this.e;
        this.h = this.f;
        this.d = new char[bVar.d()];
        g();
        this.j = new HandlerThread(bVar.c(), bVar.f());
        if (this.j != 0) {
            this.j.start();
        }
        if (this.j.isAlive() != 0 && this.j.getLooper() != 0) {
            this.k = new Handler(this.j.getLooper(), this);
        }
    }

    public void a() {
        if (this.k.hasMessages(1024)) {
            this.k.removeMessages(1024);
        }
        this.k.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        this.j.quit();
    }

    protected void a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        a(e().a(i, thread, j, str, str2, th));
    }

    protected void a(String str) {
        this.g.a(str);
        if (this.g.a() >= c().d()) {
            a();
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1024) {
            f();
        }
        return true;
    }

    private void f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = java.lang.Thread.currentThread();
        r1 = r3.j;
        if (r0 == r1) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r3.i;
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r0 = 1;
        r3.i = r0;
        r3.i();
        r0 = r3.h;	 Catch:{ IOException -> 0x0027, all -> 0x0020 }
        r1 = r3.g();	 Catch:{ IOException -> 0x0027, all -> 0x0020 }
        r2 = r3.d;	 Catch:{ IOException -> 0x0027, all -> 0x0020 }
        r0.a(r1, r2);	 Catch:{ IOException -> 0x0027, all -> 0x0020 }
        goto L_0x0027;
    L_0x0020:
        r0 = move-exception;
        r1 = r3.h;
        r1.b();
        throw r0;
    L_0x0027:
        r0 = r3.h;
        r0.b();
        r0 = 0;
        r3.i = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.a.f():void");
    }

    private java.io.Writer g() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.c();
        r0 = r0.a();
        if (r0 == 0) goto L_0x0012;
    L_0x000a:
        r1 = r3.c;
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0018;
    L_0x0012:
        r1 = r3.b;
        if (r1 != 0) goto L_0x002a;
    L_0x0016:
        if (r0 == 0) goto L_0x002a;
    L_0x0018:
        r3.c = r0;
        r3.h();
        r0 = new java.io.FileWriter;	 Catch:{ IOException -> 0x0028 }
        r1 = r3.c;	 Catch:{ IOException -> 0x0028 }
        r2 = 1;	 Catch:{ IOException -> 0x0028 }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0028 }
        r3.b = r0;	 Catch:{ IOException -> 0x0028 }
        goto L_0x002a;
    L_0x0028:
        r0 = 0;
        return r0;
    L_0x002a:
        r0 = r3.b;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.a.g():java.io.Writer");
    }

    private void h() {
        try {
            if (this.b != null) {
                this.b.flush();
                this.b.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.g == this.e) {
                this.g = this.f;
                this.h = this.e;
            } else {
                this.g = this.e;
                this.h = this.f;
            }
        }
    }

    public b c() {
        return this.a;
    }

    public void a(b bVar) {
        this.a = bVar;
    }
}
