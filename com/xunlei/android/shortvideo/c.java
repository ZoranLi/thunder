package com.xunlei.android.shortvideo;

import android.content.Context;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.downloadlib.proguard.b;

/* compiled from: ShortVideoInterface */
final class c implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ long b = 157286400;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ ShortVideoInterface e;

    c(ShortVideoInterface shortVideoInterface, Context context, String str) {
        this.e = shortVideoInterface;
        this.a = context;
        this.c = str;
        this.d = null;
    }

    public final void run() {
        if (-1 == ShortVideoInterface.e) {
            ShortVideoInterface.e = Thread.currentThread().getId();
            this.e.d = new b(this.a, this.b, this.c, this.d);
            StringBuilder stringBuilder = new StringBuilder("ShortVideoInterface msThreadId=[");
            stringBuilder.append(ShortVideoInterface.e);
            stringBuilder.append("]");
            XLLog.d("ShortVideoInterface", stringBuilder.toString());
            return;
        }
        stringBuilder = new StringBuilder("ShortVideoInterface thread id invalid, msThreadId=[");
        stringBuilder.append(ShortVideoInterface.e);
        stringBuilder.append("] currentThread=[");
        stringBuilder.append(Thread.currentThread().getId());
        stringBuilder.append("]");
        XLLog.e("ShortVideoInterface", stringBuilder.toString());
    }
}
