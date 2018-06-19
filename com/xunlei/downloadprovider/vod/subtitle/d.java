package com.xunlei.downloadprovider.vod.subtitle;

/* compiled from: OnItemSelectedRunnable */
final class d implements Runnable {
    final LoopView a;

    d(LoopView loopView) {
        this.a = loopView;
    }

    public final void run() {
        this.a.b.a(this.a.getSelectedItemValue());
    }
}
