package com.xunlei.android.shortvideo;

import com.xunlei.android.shortvideo.ShortVideoInterface.b;
import com.xunlei.downloadlib.android.XLLog;
import java.util.ArrayList;

/* compiled from: ShortVideoInterface */
public final class a implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ b b;
    final /* synthetic */ ShortVideoInterface c;

    public a(ShortVideoInterface shortVideoInterface, ArrayList arrayList, b bVar) {
        this.c = shortVideoInterface;
        this.a = arrayList;
        this.b = bVar;
    }

    public final void run() {
        if (ShortVideoInterface.e != Thread.currentThread().getId()) {
            StringBuilder stringBuilder = new StringBuilder("createTask thread id invalid, msThreadId=[");
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
