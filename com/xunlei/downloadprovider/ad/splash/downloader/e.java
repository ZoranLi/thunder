package com.xunlei.downloadprovider.ad.splash.downloader;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: DownloadRequestQueue */
final class e implements Executor {
    final /* synthetic */ d a;
    final /* synthetic */ Handler b;
    final /* synthetic */ a c;

    e(a aVar, d dVar, Handler handler) {
        this.c = aVar;
        this.a = dVar;
        this.b = handler;
    }

    public final void execute(Runnable runnable) {
        this.b.post(runnable);
    }
}
