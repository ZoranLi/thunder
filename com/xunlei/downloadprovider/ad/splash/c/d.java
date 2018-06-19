package com.xunlei.downloadprovider.ad.splash.c;

import com.xunlei.downloadprovider.ad.splash.c.c.a;
import com.xunlei.downloadprovider.ad.splash.downloader.i;

/* compiled from: SplashMaterialDownloadLoader */
public final class d implements i {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ String c;
    final /* synthetic */ c d;

    public d(c cVar, String str, a aVar, String str2) {
        this.d = cVar;
        this.a = str;
        this.b = aVar;
        this.c = str2;
    }

    public final void a() {
        c.c;
        new StringBuilder("onDownloadComplete mDownloadUrl: ").append(this.a);
        this.b.a(this.c);
    }

    public final void b() {
        c.c;
        new StringBuilder("onDownloadFailed mDownloadUrl: ").append(this.a);
        this.b.a();
    }

    public final void a(int i) {
        c.c;
        StringBuilder stringBuilder = new StringBuilder("onProgress mDownloadUrl: ");
        stringBuilder.append(this.a);
        stringBuilder.append(" progress: ");
        stringBuilder.append(i);
    }
}
