package com.xunlei.downloadprovider.download.tasklist.list.banner.b;

import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager$BannerType;
import com.xunlei.downloadprovider.download.tasklist.list.banner.p;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: DownloadExceptionBannerHelper */
public class d {
    private static d c;
    PreferenceHelper a;
    PreferenceHelper b;

    private d() {
    }

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    public static boolean a(DownloadTaskInfo downloadTaskInfo) {
        long j;
        BannerManager a = BannerManager.a();
        if (a.a == null) {
            j = -1;
        } else {
            j = a.a.b;
        }
        return (j == -1 || j != downloadTaskInfo.getTaskId()) ? true : null;
    }

    public static void a(boolean z, long j, p pVar) {
        BannerManager.a().a(z, BannerManager$BannerType.TYPE_EXCEPTION, j, pVar);
        if (z) {
            a.a();
            a.a(j);
        }
    }

    public final boolean b(DownloadTaskInfo downloadTaskInfo) {
        if (this.a == null) {
            this.a = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "sp_exception_close");
        }
        PreferenceHelper preferenceHelper = this.a;
        StringBuilder stringBuilder = new StringBuilder("taskId");
        stringBuilder.append(downloadTaskInfo.getTaskId());
        return preferenceHelper.getLong(stringBuilder.toString(), -1) < 0 ? null : true;
    }
}
