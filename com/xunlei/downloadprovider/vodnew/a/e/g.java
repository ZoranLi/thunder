package com.xunlei.downloadprovider.vodnew.a.e;

/* compiled from: PlayerStateInitialized */
final class g implements Runnable {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        String str = a.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.c);
        stringBuilder.append("onOpenComplete, checkAndAdjustSurfaceViewSize");
        this.a.a.b.a(this.a.a.b.b.getMeasuredWidth(), this.a.a.b.b.getMeasuredHeight());
    }
}
