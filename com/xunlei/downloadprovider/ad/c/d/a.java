package com.xunlei.downloadprovider.ad.c.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: InstalledAppsHelper */
public class a {
    private static final String a = "a";

    /* compiled from: InstalledAppsHelper */
    public interface a {
        boolean a(ApplicationInfo applicationInfo, PackageInfo packageInfo);
    }

    public static e[] a(Context context) {
        return a(context, new b());
    }

    public static e[] b(Context context) {
        return a(context, new c());
    }

    public static boolean a(PackageInfo packageInfo) {
        return Pattern.compile("^\\bcom.android.*$", 2).matcher(packageInfo.packageName).matches();
    }

    public static boolean a(@NonNull ApplicationInfo applicationInfo) {
        if ((applicationInfo.flags & 1) != 1) {
            if ((applicationInfo.flags & 128) != 128) {
                return null;
            }
        }
        return true;
    }

    private static e[] a(Context context, a aVar) {
        context = context.getPackageManager();
        List<PackageInfo> arrayList = new ArrayList(context.getInstalledPackages(0));
        Object obj = new e[arrayList.size()];
        int i = 0;
        for (PackageInfo packageInfo : arrayList) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo(packageInfo.packageName, 0);
                if (aVar.a(applicationInfo, packageInfo)) {
                    obj[i] = new e();
                    obj[i].a = packageInfo.packageName;
                    obj[i].b = context.getApplicationLabel(packageInfo.applicationInfo).toString();
                    obj[i].c = context.getInstallerPackageName(packageInfo.packageName);
                    obj[i].p = applicationInfo;
                    obj[i].f = packageInfo.versionCode;
                    obj[i].g = packageInfo.versionName;
                    obj[i].h = packageInfo.firstInstallTime;
                    obj[i].i = packageInfo.lastUpdateTime;
                    obj[i].j = packageInfo.applicationInfo.uid;
                    obj[i].l = packageInfo.applicationInfo.dataDir;
                    obj[i].o = applicationInfo.targetSdkVersion;
                    boolean z = true;
                    obj[i].q = (applicationInfo.flags & 1) == 1;
                    e eVar = obj[i];
                    if ((applicationInfo.flags & 128) != 128) {
                        z = false;
                    }
                    eVar.r = z;
                    obj[i].s = applicationInfo.flags;
                    i++;
                }
            } catch (NameNotFoundException e) {
                new StringBuilder("exception: ").append(e.getLocalizedMessage());
            }
        }
        context = new e[i];
        System.arraycopy(obj, 0, context, 0, i);
        return context;
    }
}
