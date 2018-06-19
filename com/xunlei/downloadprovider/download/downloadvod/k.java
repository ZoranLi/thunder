package com.xunlei.downloadprovider.download.downloadvod;

/* compiled from: TaskBxbbPlaySource */
final class k implements Runnable {
    final /* synthetic */ i$a a;

    k(i$a com_xunlei_downloadprovider_download_downloadvod_i_a) {
        this.a = com_xunlei_downloadprovider_download_downloadvod_i_a;
    }

    public final void run() {
        if (i.b(this.a.c) != null) {
            i.j();
            i.b(this.a.c).a(this.a.c, "1");
        }
    }
}
