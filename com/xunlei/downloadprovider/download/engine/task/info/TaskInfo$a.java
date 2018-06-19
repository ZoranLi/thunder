package com.xunlei.downloadprovider.download.engine.task.info;

import android.os.SystemClock;

public class TaskInfo$a {
    public boolean a = true;
    public int b = -1;
    public int c = -1;
    int d = 0;
    public long e;
    private long f;

    public final boolean a() {
        return this.c != -1 && SystemClock.elapsedRealtime() - this.f > 5000;
    }

    public final void a(int i) {
        long j;
        this.c = i;
        if (i == -1) {
            j = 0;
        } else {
            j = SystemClock.elapsedRealtime();
        }
        this.f = j;
    }
}
