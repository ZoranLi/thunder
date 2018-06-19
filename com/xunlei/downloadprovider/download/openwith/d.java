package com.xunlei.downloadprovider.download.openwith;

/* compiled from: LocalFileOpenHelper */
public final class d {
    private static com.xunlei.downloadprovider.download.d.d a;

    public static int a(android.content.Context r3, java.lang.String r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.File;
        r0.<init>(r4);
        r0 = r0.exists();
        r1 = -1;
        if (r0 != 0) goto L_0x0014;
    L_0x000c:
        if (r5 == 0) goto L_0x0013;
    L_0x000e:
        r4 = "该文件不存在";
        com.xunlei.common.commonview.XLToast.showToast(r3, r4);
    L_0x0013:
        return r1;
    L_0x0014:
        r5 = com.xunlei.common.businessutil.XLFileTypeUtil.getFileCategoryTypeByName(r4);
        r0 = com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType.E_SOFTWARE_CATEGORY;
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x003c;
    L_0x0020:
        r5 = com.xunlei.downloadprovider.app.AppStatusChgObserver.b();
        r5 = r5.c();
        if (r5 == 0) goto L_0x002b;
    L_0x002a:
        r3 = r5;
    L_0x002b:
        com.xunlei.common.androidutil.ApkHelper.installApk(r3, r4);	 Catch:{ Exception -> 0x0036 }
        r4 = com.xunlei.common.androidutil.ApkHelper.getApkInfo(r3, r4);	 Catch:{ Exception -> 0x0036 }
        if (r4 == 0) goto L_0x003b;
    L_0x0034:
        r3 = 0;
        return r3;
    L_0x0036:
        r4 = "找不到适合的应用打开文件";
        com.xunlei.common.commonview.XLToast.showToast(r3, r4);
    L_0x003b:
        return r1;
    L_0x003c:
        r5 = com.xunlei.downloadprovider.download.openwith.c.a();	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        r5 = r5.a(r4);	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        if (r5 != 0) goto L_0x004c;	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
    L_0x0046:
        r4 = "找不到适合的应用打开文件";	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        com.xunlei.common.commonview.XLToast.showToast(r3, r4);	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        return r1;	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
    L_0x004c:
        a();	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        r0 = new com.xunlei.downloadprovider.download.d.d;	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        r0.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        a = r0;	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        r2 = new com.xunlei.downloadprovider.download.openwith.e;	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        r2.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        r0.i = r2;	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        r0 = a;	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        r0.a(r5, r4);	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        r4 = a;	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        if (r4 == 0) goto L_0x0079;	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
    L_0x0066:
        r4 = a;	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        r4.show();	 Catch:{ IllegalArgumentException -> 0x0073, ActivityNotFoundException -> 0x006c }
        goto L_0x0079;
    L_0x006c:
        r1 = 1;
        r4 = "找不到适合的应用打开文件";
        com.xunlei.common.commonview.XLToast.showToast(r3, r4);
        goto L_0x0079;
    L_0x0073:
        r1 = 2;
        r4 = "找不到适合的应用打开文件";
        com.xunlei.common.commonview.XLToast.showToast(r3, r4);
    L_0x0079:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.openwith.d.a(android.content.Context, java.lang.String, boolean):int");
    }

    static void a() {
        if (a != null) {
            if (a.isShowing()) {
                a.dismiss();
            }
            a = null;
        }
    }
}
