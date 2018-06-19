package com.xunlei.downloadprovider.cooperation;

import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;

/* compiled from: CooperationHelper */
final class e implements Runnable {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        c cVar = this.a;
        if (!cVar.a.isEmpty()) {
            for (k kVar : cVar.a.values()) {
                if (!kVar.b.isEmpty()) {
                    StringBuilder stringBuilder;
                    if (kVar.b.size() == 1) {
                        kVar.c = 0;
                        stringBuilder = new StringBuilder("CooperationItem at ");
                        stringBuilder.append(kVar.a);
                        stringBuilder.append(": ");
                        stringBuilder.append(((CooperationItem) kVar.b.get(kVar.c)).getAppName());
                    } else {
                        int i = -1;
                        for (int i2 = 0; i2 < kVar.b.size(); i2++) {
                            if (!ApkHelper.isApkPackageInstalled(BrothersApplication.getApplicationInstance(), ((CooperationItem) kVar.b.get(i2)).getAppPackageName())) {
                                i = i2;
                                break;
                            }
                        }
                        if (i < 0) {
                            i = 0;
                        }
                        kVar.c = i;
                        stringBuilder = new StringBuilder("CooperationItem at ");
                        stringBuilder.append(kVar.a);
                        stringBuilder.append(": ");
                        stringBuilder.append(((CooperationItem) kVar.b.get(kVar.c)).getAppName());
                    }
                }
            }
        }
    }
}
