package com.xunlei.downloadprovider.h;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;

/* compiled from: PollingScheduler */
final class h implements Runnable {
    final /* synthetic */ PendingIntent a;
    final /* synthetic */ g b;

    h(g gVar, PendingIntent pendingIntent) {
        this.b = gVar;
        this.a = pendingIntent;
    }

    public final void run() {
        try {
            this.a.send();
        } catch (CanceledException e) {
            g.b;
            new StringBuilder("pendingIntent send error=>").append(e.getMessage());
            e.printStackTrace();
        }
    }
}
