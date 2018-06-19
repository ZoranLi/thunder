package com.xunlei.downloadprovider.ad.downloadlist.a;

import com.xunlei.downloadprovider.ad.a.d;
import com.xunlei.downloadprovider.ad.common.adget.t;
import com.xunlei.downloadprovider.ad.downloadlist.DownloadListADConst.DownloadListSSPAdMapping;
import com.xunlei.downloadprovider.ad.downloadlist.b;

/* compiled from: LoadADExecutor */
final class c implements b {
    final /* synthetic */ int a;
    final /* synthetic */ b b;

    c(b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    public final void a() {
        new t().a(DownloadListSSPAdMapping.getThunderAdInfo(d.b(this.a)), this.b);
    }
}
