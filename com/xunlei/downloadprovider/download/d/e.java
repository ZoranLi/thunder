package com.xunlei.downloadprovider.download.d;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.cooperation.ui.b;
import com.xunlei.downloadprovider.download.d.a.a;
import com.xunlei.downloadprovider.download.openwith.c;
import com.xunlei.xllib.b.d;
import java.io.File;

/* compiled from: DownloadTaskOpenAppSelectDialog */
final class e implements a {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void a(f fVar) {
        if (fVar != null) {
            if (fVar.e) {
                b a = b.a();
                Context a2 = this.a.a;
                String b = this.a.h;
                if (fVar != null) {
                    CooperationItem cooperationItem = fVar.f;
                    if (cooperationItem != null) {
                        String appPackageName = cooperationItem.getAppPackageName();
                        boolean isApkPackageInstalled = ApkHelper.isApkPackageInstalled(a2, appPackageName);
                        com.xunlei.downloadprovider.cooperation.a.a.a(l.c(cooperationItem.getDisplayLocation()), appPackageName, cooperationItem.isShowInstallTip(), isApkPackageInstalled, "");
                        if (isApkPackageInstalled) {
                            if (TextUtils.isEmpty(b)) {
                                b = "";
                            }
                            File file = new File(b);
                            if (file.exists()) {
                                fVar = fVar.c;
                                if (fVar != null) {
                                    fVar = c.a().a(a2, b, fVar);
                                    if (fVar != null) {
                                        fVar.addFlags(67108864);
                                        a2.startActivity(fVar);
                                    }
                                } else {
                                    XLToast.showToast(a2, "找不到适合的应用打开文件");
                                }
                            } else {
                                ApkHelper.launchAppByPackageName(a2, appPackageName);
                                new StringBuilder("file not exist --> ").append(file.getAbsolutePath());
                            }
                        } else {
                            a.a(a2, cooperationItem);
                        }
                    }
                }
                this.a.b();
            } else if (fVar.d) {
                if (!(d.a(this.a.d) != null || this.a.g == null || this.a.d.contains(this.a.g) == null)) {
                    this.a.d.remove(this.a.g);
                }
                this.a.d.addAll(this.a.e);
                this.a.b.a(this.a.d);
            } else {
                if (this.a.i != null) {
                    this.a.i.a(fVar, this.a.h);
                }
            }
        }
    }
}
