package com.xunlei.downloadprovider.vod.player;

/* compiled from: TouchListenerProxy */
final class a implements Runnable {
    final /* synthetic */ TouchListenerProxy a;

    a(TouchListenerProxy touchListenerProxy) {
        this.a = touchListenerProxy;
    }

    public final void run() {
        if (this.a.g != null && (this.a.a & 1) != 0) {
            this.a.c = 0;
            this.a.g;
        }
    }
}
