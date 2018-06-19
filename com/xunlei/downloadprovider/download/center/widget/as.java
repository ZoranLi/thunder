package com.xunlei.downloadprovider.download.center.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.v;
import java.lang.ref.WeakReference;

/* compiled from: TaskCountMonitor */
public class as implements Callback, v {
    protected Handler a = new a(this);
    public b b = this.u;

    /* compiled from: TaskCountMonitor */
    private static class a extends Handler {
        private WeakReference<as> a;

        public a(as asVar) {
            this.a = new WeakReference(asVar);
        }

        public final void handleMessage(Message message) {
            as asVar = (as) this.a.get();
            if (asVar != null) {
                asVar.handleMessage(message);
            }
        }
    }

    /* compiled from: TaskCountMonitor */
    public interface b {
        void a();
    }

    public final Handler c() {
        return this.a;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 113) {
            return null;
        }
        if (this.b != null) {
            this.b.a();
        }
        return true;
    }

    public void a() {
        n.a();
        n.a(this);
    }

    public void b() {
        n.a();
        n.b(this);
        if (this.a != null) {
            this.a.removeCallbacksAndMessages(null);
        }
    }

    public final void d() {
        b();
        this.b = null;
    }

    public final void a(int i, int i2) {
        this.a.obtainMessage(114, i, i2).sendToTarget();
    }

    public final void e() {
        this.a.sendEmptyMessage(113);
    }
}
