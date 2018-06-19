package com.getui.gtc.event.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

final class h extends Handler {
    final j a = new j();
    boolean b;
    private final int c = 10;
    private final c d;

    h(c cVar, Looper looper) {
        super(looper);
        this.d = cVar;
    }

    public final void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                i a = this.a.a();
                if (a == null) {
                    synchronized (this) {
                        a = this.a.a();
                        if (a == null) {
                            this.b = false;
                            this.b = false;
                            return;
                        }
                    }
                }
                this.d.a(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.c));
            if (sendMessage(obtainMessage())) {
                this.b = true;
                return;
            }
            throw new g("Could not send handler message");
        } catch (Throwable th) {
            this.b = false;
        }
    }
}
