package com.xunlei.downloadprovider.app.a;

/* compiled from: LaunchInitialization */
final class j implements Runnable {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void run() {
        this.a.d.removeCallbacksAndMessages(null);
        i.c();
    }
}
