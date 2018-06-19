package com.xunlei.downloadprovider.bho;

import com.xunlei.downloadprovider.service.DownloadService;
import com.xunlei.downloadprovider.service.DownloadService.c;

/* compiled from: ThunderTaskBHOActivity */
final class e implements c {
    final /* synthetic */ ThunderTaskBHOActivity a;

    e(ThunderTaskBHOActivity thunderTaskBHOActivity) {
        this.a = thunderTaskBHOActivity;
    }

    public final void a(DownloadService downloadService) {
        this.a.d.sendEmptyMessage(1);
    }
}
