package com.xunlei.downloadprovider.download.engine.task;

import android.os.Handler;
import android.os.Looper;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: CreateTaskCallbackDelivery */
public final class d implements c {
    c a;
    private Handler b;

    public d(c cVar) {
        this(cVar, (byte) 0);
    }

    private d(c cVar, byte b) {
        this.a = cVar;
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        if (this.a != null) {
            this.b.post(new e(this, taskInfo, i, i2));
        }
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        if (this.a != null) {
            this.b.post(new f(this, taskInfo, i, i2));
        }
    }

    public final void a() {
        this.a = null;
        this.b.removeCallbacksAndMessages(null);
    }
}
