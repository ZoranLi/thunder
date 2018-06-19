package com.xunlei.downloadprovider.vod.speeduptrial;

import android.os.MessageQueue.IdleHandler;

/* compiled from: BubbleTipBarControl */
final class k implements IdleHandler {
    final /* synthetic */ f a;

    k(f fVar) {
        this.a = fVar;
    }

    public final boolean queueIdle() {
        this.a.b = true;
        return false;
    }
}
