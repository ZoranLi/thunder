package com.xunlei.downloadprovider.ad.c.d;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.xunlei.downloadprovider.ad.c.d.a.a;

/* compiled from: InstalledAppsHelper */
final class c implements a {
    c() {
    }

    public final boolean a(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return (a.a(applicationInfo) == null || a.a(packageInfo) != null) ? null : true;
    }
}
