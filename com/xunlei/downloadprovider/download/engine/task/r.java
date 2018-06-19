package com.xunlei.downloadprovider.download.engine.task;

import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager$Property;
import com.xunlei.downloadprovider.download.engine.kernel.g;
import com.xunlei.downloadprovider.download.engine.task.n.a;

/* compiled from: DownloadTaskManager */
final class r implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ n b;

    r(n nVar, boolean z) {
        this.b = nVar;
        this.a = z;
    }

    public final void run() {
        synchronized (this) {
            a a = n.a(this.b);
            n.b(this.b);
        }
        if (a != null) {
            g a2 = g.a();
            long j = a.a;
            String str = a.b;
            String str2 = a.c;
            boolean z = a.d;
            if (a2.b != null) {
                StringBuilder stringBuilder = new StringBuilder("DownloadSDK: setUserLoginInfo - UserId = ");
                stringBuilder.append(j);
                stringBuilder.append(" jumpKey = ");
                stringBuilder.append(str);
                stringBuilder.append(" isVip = ");
                stringBuilder.append(z);
                a2.b.setProperty(DownloadManager$Property.PROP_USER_ID, j == 0 ? "" : String.valueOf(j));
                DownloadManager downloadManager = a2.b;
                String str3 = DownloadManager$Property.PROP_JUMP_KEY;
                if (str == null) {
                    str = "";
                }
                downloadManager.setProperty(str3, str);
                DownloadManager downloadManager2 = a2.b;
                String str4 = DownloadManager$Property.PROP_SESSION_ID;
                if (str2 == null) {
                    str2 = "";
                }
                downloadManager2.setProperty(str4, str2);
                downloadManager2 = a2.b;
                str2 = DownloadManager$Property.PROP_VIP_KEY;
                String str5 = (!z || j == 0) ? "0" : "1";
                downloadManager2.setProperty(str2, str5);
                a2.b.setProperty(DownloadManager$Property.PROP_VERSION_KEY, "5.60.2.5510");
            }
        }
        if (this.a) {
            g.a().a(true);
        }
    }
}
