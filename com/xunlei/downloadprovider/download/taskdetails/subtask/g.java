package com.xunlei.downloadprovider.download.taskdetails.subtask;

import android.os.Handler;
import android.os.Looper;

/* compiled from: BTSubTaskViewModel */
public abstract class g {
    static Handler b = new Handler(Looper.getMainLooper());
    BTSubTaskItem c;
    Runnable d = new h(this);

    public abstract void a();

    public abstract void a(BTSubTaskItem bTSubTaskItem);

    public final boolean b(BTSubTaskItem bTSubTaskItem) {
        return (this.c == null || this.c != bTSubTaskItem) ? null : true;
    }
}
