package com.xunlei.downloadprovider.plugin;

/* compiled from: XLPluginDownloadManager */
final class n implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ long b;
    final /* synthetic */ p c;
    final /* synthetic */ a$b d;
    final /* synthetic */ a e;

    n(a aVar, int i, long j, p pVar, a$b com_xunlei_downloadprovider_plugin_a_b) {
        this.e = aVar;
        this.a = i;
        this.b = j;
        this.c = pVar;
        this.d = com_xunlei_downloadprovider_plugin_a_b;
    }

    public final void run() {
        if (this.a != 0) {
            a.a();
            new StringBuilder("installPlugin fail : ").append(this.c.a);
            if (this.d != null) {
                this.d.a(this.a);
            }
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.b;
            a.a();
            StringBuilder stringBuilder = new StringBuilder("installPlugin success : ");
            stringBuilder.append(this.c.a);
            stringBuilder.append(" Install time cost ");
            stringBuilder.append(currentTimeMillis);
            stringBuilder.append("ms");
            if (this.d != null) {
                this.d.a();
            }
        }
    }
}
