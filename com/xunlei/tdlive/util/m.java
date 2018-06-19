package com.xunlei.tdlive.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

/* compiled from: WrapHandlerThread */
public class m {
    private HandlerThread a;
    private Handler b;
    private String c;
    private Callback d;

    public m(String str, Callback callback) {
        this.c = str;
        this.d = callback;
    }

    protected void finalize() {
        try {
            super.finalize();
            b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a() {
        if (this.b == null) {
            this.a = new HandlerThread(this.c);
            this.a.start();
            this.b = new Handler(this.a.getLooper(), this.d);
        }
    }

    public void b() {
        if (this.b != null) {
            this.b.removeCallbacksAndMessages(null);
            this.a.quit();
        }
        this.b = null;
        this.a = null;
    }

    public boolean c() {
        if (this.a == null) {
            return false;
        }
        return this.a.isAlive();
    }

    public boolean a(Message message, int i) {
        if (this.b == null) {
            return null;
        }
        if (i > 0) {
            return this.b.sendMessageDelayed(message, (long) i);
        }
        return this.b.sendMessage(message);
    }
}
