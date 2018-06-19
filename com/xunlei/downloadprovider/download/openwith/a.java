package com.xunlei.downloadprovider.download.openwith;

import android.content.pm.PackageInfo;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.task.n;
import java.io.File;
import java.io.FileFilter;

/* compiled from: ApkFileManager */
public final class a {
    private static a a;

    /* compiled from: ApkFileManager */
    private static class a implements FileFilter {
        private String a;

        a(String str) {
            this.a = str;
        }

        public final boolean accept(File file) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(ShareConstants.PATCH_SUFFIX) && ApkHelper.isApkPackageFileInstalled(BrothersApplication.getApplicationInstance(), file.getAbsolutePath())) {
                PackageInfo packageArchiveInfo = BrothersApplication.getApplicationInstance().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
                if (packageArchiveInfo != null) {
                    if (this.a.equals(packageArchiveInfo.packageName)) {
                        n.a();
                        n.b(file.getAbsolutePath());
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ all -> 0x005c }
        r0 = com.xunlei.common.businessutil.DownloadConfig.getRealDownloadPath(r0);	 Catch:{ all -> 0x005c }
        r1 = new com.xunlei.downloadprovider.download.openwith.a$a;	 Catch:{ all -> 0x005c }
        r1.<init>(r4);	 Catch:{ all -> 0x005c }
        if (r0 == 0) goto L_0x001e;
    L_0x0010:
        r2 = new java.io.File;	 Catch:{ all -> 0x005c }
        r2.<init>(r0);	 Catch:{ all -> 0x005c }
        r0 = r2.isDirectory();	 Catch:{ all -> 0x005c }
        if (r0 == 0) goto L_0x001e;
    L_0x001b:
        r2.listFiles(r1);	 Catch:{ all -> 0x005c }
    L_0x001e:
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ all -> 0x0051 }
        r1 = "apk_path";
        r0 = com.xunlei.common.androidutil.PreferenceHelper.readStringFromPref(r0, r1, r4);	 Catch:{ all -> 0x0051 }
        if (r0 != 0) goto L_0x0035;
    L_0x002a:
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ all -> 0x005c }
        r1 = "apk_path";
        com.xunlei.common.androidutil.PreferenceHelper.removeKeyFromPref(r0, r1, r4);	 Catch:{ all -> 0x005c }
        monitor-exit(r3);
        return;
    L_0x0035:
        r1 = new java.io.File;	 Catch:{ all -> 0x0051 }
        r1.<init>(r0);	 Catch:{ all -> 0x0051 }
        r1 = r1.exists();	 Catch:{ all -> 0x0051 }
        if (r1 == 0) goto L_0x0046;
    L_0x0040:
        com.xunlei.downloadprovider.download.engine.task.n.a();	 Catch:{ all -> 0x0051 }
        com.xunlei.downloadprovider.download.engine.task.n.b(r0);	 Catch:{ all -> 0x0051 }
    L_0x0046:
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ all -> 0x005c }
        r1 = "apk_path";
        com.xunlei.common.androidutil.PreferenceHelper.removeKeyFromPref(r0, r1, r4);	 Catch:{ all -> 0x005c }
        monitor-exit(r3);
        return;
    L_0x0051:
        r0 = move-exception;
        r1 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ all -> 0x005c }
        r2 = "apk_path";
        com.xunlei.common.androidutil.PreferenceHelper.removeKeyFromPref(r1, r2, r4);	 Catch:{ all -> 0x005c }
        throw r0;	 Catch:{ all -> 0x005c }
    L_0x005c:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.openwith.a.a(java.lang.String):void");
    }
}
