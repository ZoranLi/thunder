package com.xunlei.downloadprovider.ad.common;

import java.util.TimerTask;

/* compiled from: RequestTimeoutController */
final class j extends TimerTask {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void run() {
        this.a.e.post(new k(this));
    }
}
