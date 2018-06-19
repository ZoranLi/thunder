package com.baidu.mobads.openad.b;

import android.net.ConnectivityManager;
import com.baidu.mobads.command.a;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.List;

class e implements IOAdEventListener {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run(IOAdEvent iOAdEvent) {
        try {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", "网络状态已经改变");
            iOAdEvent = ((ConnectivityManager) this.a.a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (iOAdEvent == null || !iOAdEvent.isConnected()) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", "没有可用网络");
                return;
            }
            String typeName = iOAdEvent.getTypeName();
            iOAdEvent = iOAdEvent.getType();
            StringBuilder stringBuilder = new StringBuilder("当前网络名称：");
            stringBuilder.append(typeName);
            stringBuilder.append("; 网络类型：");
            stringBuilder.append(iOAdEvent);
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", stringBuilder.toString());
            List<IOAdDownloader> allAdsApkDownloaderes = this.a.getAllAdsApkDownloaderes();
            if (allAdsApkDownloaderes != null) {
                for (IOAdDownloader iOAdDownloader : allAdsApkDownloaderes) {
                    if (iOAdEvent == 1) {
                        if (iOAdDownloader.getState() == DownloadStatus.ERROR || iOAdDownloader.getState() == DownloadStatus.PAUSED) {
                            try {
                                iOAdDownloader.resume();
                            } catch (Throwable e) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e);
                            }
                        }
                    } else if (iOAdEvent == null) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", "mobile net work");
                        b a = b.a(iOAdDownloader.getPackageName());
                        if (a != null) {
                            a a2 = a.a();
                            if (a2 == null) {
                                continue;
                            } else if (!a2.s) {
                                try {
                                    iOAdDownloader.pause();
                                } catch (Throwable e2) {
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e2);
                                }
                            } else if (iOAdDownloader.getState() == DownloadStatus.ERROR || iOAdDownloader.getState() == DownloadStatus.PAUSED) {
                                try {
                                    iOAdDownloader.resume();
                                } catch (Throwable e22) {
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e22);
                                }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Throwable e3) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e3);
            com.baidu.mobads.c.a a3 = com.baidu.mobads.c.a.a();
            StringBuilder stringBuilder2 = new StringBuilder("create apk downloader failed: ");
            stringBuilder2.append(e3.toString());
            a3.a(stringBuilder2.toString());
        }
    }
}
