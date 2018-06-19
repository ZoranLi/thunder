package com.baidu.mobads.openad.b;

import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class c implements Runnable {
    final /* synthetic */ IOAdDownloader a;
    final /* synthetic */ b b;

    c(b bVar, IOAdDownloader iOAdDownloader) {
        this.b = bVar;
        this.a = iOAdDownloader;
    }

    public void run() {
        try {
            if (this.b.c.g == DownloadStatus.CANCELLED) {
                b.a.cancel(this.b.c.f);
                return;
            }
            b.a.notify(this.b.c.f, this.b.b(this.a));
            if (this.b.c.g == DownloadStatus.ERROR) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "status >> error");
                return;
            }
            if (this.b.c.g == DownloadStatus.INITING && this.b.c.r == 1) {
                b bVar = this.b;
                StringBuilder stringBuilder = new StringBuilder("开始下载 ");
                stringBuilder.append(this.b.c.a);
                bVar.d(stringBuilder.toString());
            }
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", e);
        }
    }
}
