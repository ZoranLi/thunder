package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;

import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: RedEnvelopeBannerPresenter */
final class c implements a {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void a(DownloadTaskInfo downloadTaskInfo, RedPacketConditionsInfo redPacketConditionsInfo, long j) {
        a aVar = this.a;
        if (aVar.b == null) {
            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a().c = null;
        } else {
            aVar.b.post(new d(aVar, downloadTaskInfo, redPacketConditionsInfo, j));
        }
    }

    public final void a(boolean z) {
        a aVar = this.a;
        if (aVar.b == null) {
            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a().c = false;
        } else {
            aVar.b.post(new e(aVar, z));
        }
    }

    public final void a() {
        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a().c = false;
    }
}
