package com.xunlei.downloadprovider.download.engine.kernel;

/* compiled from: DownloadKernel */
final class h implements Runnable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        String str = g.a;
        g gVar = this.a;
        if (gVar.b != null) {
            if (gVar.c != null) {
                long[] a = g.a(new d(gVar.c, gVar.b).a());
                if (a.length > 0) {
                    gVar.a(2, a);
                }
            }
        }
    }
}
