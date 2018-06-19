package com.xunlei.downloadprovider.cooperation;

import android.os.Environment;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.download.engine.task.n;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: CooperationDownloader */
public final class b implements Runnable {
    final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        Collection arrayList = new ArrayList();
        int i = 0;
        if (Environment.getExternalStorageState().equals("mounted")) {
            for (int i2 = 0; i2 < this.a.b.size(); i2++) {
                CooperationItem cooperationItem = (CooperationItem) this.a.b.get(i2);
                boolean isApkPackageInstalled = ApkHelper.isApkPackageInstalled(BrothersApplication.getApplicationInstance(), cooperationItem.getAppPackageName());
                String appDownloadUrl = cooperationItem.getAppDownloadUrl();
                n.a();
                long e = n.e(appDownloadUrl);
                if (isApkPackageInstalled) {
                    arrayList.add(cooperationItem);
                    if (e != -1) {
                        n.a();
                        if (n.f(e).getCustomFlags() == 101) {
                            n.a().c(false, e);
                        }
                    } else {
                        this.a.a.add(this.a.b.get(i2));
                    }
                } else if (e != -1) {
                    arrayList.add(cooperationItem);
                }
            }
        }
        this.a.b.removeAll(arrayList);
        while (i < this.a.b.size()) {
            a.a((CooperationItem) this.a.b.get(i));
            i++;
        }
    }
}
