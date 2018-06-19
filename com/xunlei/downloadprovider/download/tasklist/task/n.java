package com.xunlei.downloadprovider.download.tasklist.task;

import android.os.SystemClock;

/* compiled from: TaskListManager */
final class n implements Runnable {
    final /* synthetic */ h a;

    n(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.a.b != null && !this.a.b.isEmpty()) {
            boolean z = false;
            for (s sVar : this.a.b.values()) {
                boolean z2;
                s.a(sVar.b, elapsedRealtime, true);
                sVar.a(elapsedRealtime, true);
                sVar.l();
                if (sVar.b() != 1) {
                    if (sVar.b() != 2) {
                        z2 = false;
                        if (z2) {
                            z = true;
                        }
                        this.a.m.k.a(Boolean.valueOf(z));
                    }
                }
                z2 = true;
                if (z2) {
                    z = true;
                }
                this.a.m.k.a(Boolean.valueOf(z));
            }
            this.a.m();
        }
    }
}
