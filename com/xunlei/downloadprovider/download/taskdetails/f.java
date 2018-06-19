package com.xunlei.downloadprovider.download.taskdetails;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.taskdetail.c;
import com.xunlei.downloadprovider.download.taskdetails.TaskDetailFragment.a;

/* compiled from: DownloadCenterDetailFragment */
final class f implements a {
    final /* synthetic */ com.xunlei.downloadprovider.ad.taskdetail.view.a a;
    final /* synthetic */ DownloadCenterDetailFragment b;

    f(DownloadCenterDetailFragment downloadCenterDetailFragment, com.xunlei.downloadprovider.ad.taskdetail.view.a aVar) {
        this.b = downloadCenterDetailFragment;
        this.a = aVar;
    }

    public final void a(boolean z, l lVar, c cVar) {
        String str = this.b.c;
        DownloadCenterDetailFragment downloadCenterDetailFragment = this.b;
        com.xunlei.downloadprovider.ad.taskdetail.view.a aVar = this.a;
        aVar.setAdController(cVar);
        if (downloadCenterDetailFragment.b == null && z && lVar != null) {
            aVar.a(lVar);
        } else {
            aVar.d();
        }
    }
}
