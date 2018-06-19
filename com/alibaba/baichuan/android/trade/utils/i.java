package com.alibaba.baichuan.android.trade.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alibaba.baichuan.android.trade.utils.g.a;

public class i {
    private static volatile i d;
    public Handler a;
    private Handler b = new Handler(Looper.getMainLooper());
    private HandlerThread c = new HandlerThread("SDK Looper Thread");

    private i() {
        this.c.start();
        while (this.c.getLooper() == null) {
            try {
                this.c.wait();
            } catch (InterruptedException e) {
                new StringBuilder("创建handlerThread错误：").append(e.getMessage());
                a.b();
            }
        }
        this.a = new k(this, this.c.getLooper());
    }

    public static i a() {
        if (d == null) {
            synchronized (i.class) {
                if (d == null) {
                    d = new i();
                }
            }
        }
        return d;
    }

    public final void a(Runnable runnable) {
        this.a.post(runnable);
    }

    public final void b(Runnable runnable) {
        this.b.post(runnable);
    }
}
