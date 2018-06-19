package com.xunlei.android.shortvideo;

import com.xunlei.android.shortvideo.ShortVideoInterface.PlayerEvent;
import com.xunlei.downloadlib.android.XLLog;

/* compiled from: ShortVideoInterface */
final class b implements Runnable {
    final /* synthetic */ PlayerEvent a;
    final /* synthetic */ long b;
    final /* synthetic */ ShortVideoInterface c;

    b(ShortVideoInterface shortVideoInterface, PlayerEvent playerEvent, long j) {
        this.c = shortVideoInterface;
        this.a = playerEvent;
        this.b = j;
    }

    public final void run() {
        if (ShortVideoInterface.e != Thread.currentThread().getId()) {
            StringBuilder stringBuilder = new StringBuilder("notifyPlayerEvent thread id invalid, msThreadId=[");
            stringBuilder.append(ShortVideoInterface.e);
            stringBuilder.append("] currentThread=[");
            stringBuilder.append(Thread.currentThread().getId());
            stringBuilder.append("]");
            XLLog.e("ShortVideoInterface", stringBuilder.toString());
            return;
        }
        this.c.d.a(this.a, this.b);
    }
}
