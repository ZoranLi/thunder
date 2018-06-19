package com.xunlei.downloadprovider.download.privatespace;

import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.kernel.g;
import java.io.File;

/* compiled from: PrivateSpaceMgr */
final class am implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ PrivateSpaceMgr c;

    am(PrivateSpaceMgr privateSpaceMgr, String str, long j) {
        this.c = privateSpaceMgr;
        this.a = str;
        this.b = j;
    }

    public final void run() {
        File file = new File(this.a);
        if (file.exists()) {
            String realDownloadPath = DownloadConfig.getRealDownloadPath(BrothersApplication.getApplicationInstance());
            File file2 = new File(realDownloadPath, file.getName());
            int c = g.b().moveTask(this.b, realDownloadPath);
            StringBuilder stringBuilder = new StringBuilder("[moveFileOutPrivateSpace] sourceFilePath");
            stringBuilder.append(this.a);
            stringBuilder.append(" ,result=");
            stringBuilder.append(c);
            if (c == 200) {
                PrivateSpaceMgr.a(this.c, this.a, file2.getPath());
                PrivateSpaceMgr.a(file, file2);
            }
        }
    }
}
