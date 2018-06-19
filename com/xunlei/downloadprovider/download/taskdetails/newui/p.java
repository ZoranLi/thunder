package com.xunlei.downloadprovider.download.taskdetails.newui;

import com.xunlei.downloadprovider.download.util.k;

/* compiled from: DownloadDetailsActivityFragment */
final class p implements Runnable {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final void run() {
        if (!k.e(this.a.a.f)) {
            this.a.a.a(true, false);
        }
    }
}
