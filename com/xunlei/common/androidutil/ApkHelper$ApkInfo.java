package com.xunlei.common.androidutil;

import android.content.pm.PackageInfo;
import android.content.res.Resources;

public final class ApkHelper$ApkInfo {
    private PackageInfo mPackageInfo;
    private Resources mResources;

    public ApkHelper$ApkInfo(PackageInfo packageInfo, Resources resources) {
        this.mPackageInfo = packageInfo;
        this.mResources = resources;
    }

    public final java.lang.CharSequence getApkLabel() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.mPackageInfo;
        if (r0 == 0) goto L_0x0027;
    L_0x0004:
        r0 = r3.mResources;
        if (r0 == 0) goto L_0x0027;
    L_0x0008:
        r0 = r3.mPackageInfo;
        r0 = r0.applicationInfo;
        r0 = r0.nonLocalizedLabel;
        if (r0 != 0) goto L_0x0028;
    L_0x0010:
        r1 = r3.mPackageInfo;
        r1 = r1.applicationInfo;
        r1 = r1.labelRes;
        if (r1 == 0) goto L_0x0020;
    L_0x0018:
        r2 = r3.mResources;	 Catch:{ NotFoundException -> 0x0028 }
        r1 = r2.getText(r1);	 Catch:{ NotFoundException -> 0x0028 }
        r0 = r1;
        goto L_0x0028;
    L_0x0020:
        r0 = r3.mPackageInfo;
        r0 = r0.applicationInfo;
        r0 = r0.packageName;
        goto L_0x0028;
    L_0x0027:
        r0 = 0;
    L_0x0028:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.androidutil.ApkHelper$ApkInfo.getApkLabel():java.lang.CharSequence");
    }

    public final android.graphics.drawable.Drawable getApkIcon() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mPackageInfo;
        if (r0 == 0) goto L_0x0017;
    L_0x0004:
        r0 = r2.mResources;
        if (r0 == 0) goto L_0x0017;
    L_0x0008:
        r0 = r2.mPackageInfo;
        r0 = r0.applicationInfo;
        r0 = r0.icon;
        if (r0 == 0) goto L_0x0017;
    L_0x0010:
        r1 = r2.mResources;	 Catch:{ NotFoundException -> 0x0017 }
        r0 = r1.getDrawable(r0);	 Catch:{ NotFoundException -> 0x0017 }
        goto L_0x0018;
    L_0x0017:
        r0 = 0;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.androidutil.ApkHelper$ApkInfo.getApkIcon():android.graphics.drawable.Drawable");
    }

    public final String getPackageName() {
        return this.mPackageInfo != null ? this.mPackageInfo.packageName : null;
    }

    public final String getApkVersionName() {
        return this.mPackageInfo != null ? ApkHelper.getMainVerName(this.mPackageInfo.versionName) : null;
    }

    public final int getApkVersionCode() {
        return this.mPackageInfo != null ? this.mPackageInfo.versionCode : 0;
    }
}
