package com.xunlei.downloadprovider.download.engine.task.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: MessageThread */
public final class t extends Thread implements Executor {
    public Handler a;
    private Looper b;
    private Callback c;

    /* compiled from: MessageThread */
    public static abstract class a<T> implements Runnable {
        protected T b;

        public abstract void a(T t);

        public a(T t) {
            this.b = t;
        }

        public final void run() {
            a(this.b);
            this.b = null;
        }
    }

    /* compiled from: MessageThread */
    public static class b<PARAM1, PARAM2> {
        public PARAM1 a;
        public PARAM2 b;

        public b(PARAM1 param1, PARAM2 param2) {
            this.a = param1;
            this.b = param2;
        }
    }

    public t(String str, Callback callback) {
        super(str);
        this.c = callback;
    }

    public final void run() {
        Looper.prepare();
        this.b = Looper.myLooper();
        this.a = new Handler(this.b, new u(this));
        Looper.loop();
    }

    public final void execute(@NonNull Runnable runnable) {
        Handler handler = this.a;
        if (handler == null) {
            throw new RejectedExecutionException();
        }
        handler.post(runnable);
    }
}
