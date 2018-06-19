package com.xunlei.downloadprovider.cooperation.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.a.a;
import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.cooperation.data.CooperationData;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.cooperation.ui.dialog.CooperationDialogActivity;
import com.xunlei.downloadprovider.dialog.f;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import java.io.File;

/* compiled from: CooperationController */
public final class b {
    private static b g = new b();
    public Handler a = new Handler(Looper.getMainLooper());
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    private f h;

    private b() {
    }

    public static b a() {
        return g;
    }

    public static CooperationData b() {
        CooperationData a = a(1006, 3);
        if (!(a == null || a.mCooperationItem == null)) {
            if (a.mCooperationScene != null) {
                return a;
            }
        }
        return null;
    }

    public static void a(Context context, String str) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            Object c = c();
            if (!TextUtils.isEmpty(c)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c);
                stringBuilder.append(str);
                stringBuilder.append(ShareConstants.PATCH_SUFFIX);
                ApkHelper.installApk(context, stringBuilder.toString());
            }
        }
    }

    public static boolean a(CooperationItem cooperationItem) {
        if (!TextUtils.isEmpty(cooperationItem.getAppName()) && Environment.getExternalStorageState().equals("mounted")) {
            Object c = c();
            if (!TextUtils.isEmpty(c)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cooperationItem.getAppName());
                stringBuilder.append(ShareConstants.PATCH_SUFFIX);
                if (new File(c, stringBuilder.toString()).exists()) {
                    String appDownloadUrl = cooperationItem.getAppDownloadUrl();
                    n.a();
                    long e = n.e(appDownloadUrl);
                    if (e != -1) {
                        n.a();
                        cooperationItem = n.f(e);
                        if (cooperationItem != null && cooperationItem.mLocalFileName != null && new File(cooperationItem.mLocalFileName).exists() && cooperationItem.mDownloadedSize == cooperationItem.mFileSize) {
                            cooperationItem = 1;
                            if (cooperationItem == null) {
                                return true;
                            }
                        }
                    }
                    cooperationItem = null;
                    if (cooperationItem == null) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static String c() {
        String str = "";
        try {
            File obbDir = AppStatusChgObserver.b().c().getObbDir();
            if (obbDir == null) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obbDir.getAbsolutePath());
            stringBuilder.append("/predownload/");
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static com.xunlei.downloadprovider.cooperation.ui.dialog.CooperationSceneDialogFragment a(android.support.v4.app.FragmentManager r3, com.xunlei.downloadprovider.cooperation.data.CooperationData r4, com.xunlei.downloadprovider.cooperation.ui.a r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.downloadprovider.cooperation.ui.SceneUiStyle.THREE_BUTTON;
        r0 = com.xunlei.downloadprovider.cooperation.ui.dialog.CooperationSceneDialogFragment.a(r4, r0);
        r0.a = r5;
        r1 = new java.lang.StringBuilder;	 Catch:{ IllegalStateException -> 0x0020 }
        r2 = "CooperationSceneDialog";	 Catch:{ IllegalStateException -> 0x0020 }
        r1.<init>(r2);	 Catch:{ IllegalStateException -> 0x0020 }
        r4 = r4.mCooperationScene;	 Catch:{ IllegalStateException -> 0x0020 }
        r4 = r4.getLocation();	 Catch:{ IllegalStateException -> 0x0020 }
        r1.append(r4);	 Catch:{ IllegalStateException -> 0x0020 }
        r4 = r1.toString();	 Catch:{ IllegalStateException -> 0x0020 }
        r0.show(r3, r4);	 Catch:{ IllegalStateException -> 0x0020 }
        goto L_0x0023;
    L_0x0020:
        r5.a();
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.cooperation.ui.b.a(android.support.v4.app.FragmentManager, com.xunlei.downloadprovider.cooperation.data.CooperationData, com.xunlei.downloadprovider.cooperation.ui.a):com.xunlei.downloadprovider.cooperation.ui.dialog.CooperationSceneDialogFragment");
    }

    @Nullable
    public static CooperationData a(int i, int i2) {
        CooperationData cooperationData = new CooperationData();
        cooperationData.mCooperationScene = c.a().b(i);
        cooperationData.mCooperationItem = c.a().a(i2);
        if (cooperationData.mCooperationScene != 0) {
            if (cooperationData.mCooperationItem != 0) {
                return cooperationData;
            }
        }
        return 0;
    }

    public final void a(Context context, CooperationItem cooperationItem, String str) {
        if (cooperationItem != null) {
            String appPackageName = cooperationItem.getAppPackageName();
            boolean isApkPackageInstalled = ApkHelper.isApkPackageInstalled(context, appPackageName);
            a.a(l.c(cooperationItem.getDisplayLocation()), appPackageName, cooperationItem.isShowInstallTip(), isApkPackageInstalled, "");
            if (isApkPackageInstalled) {
                if (TextUtils.isEmpty(str) != null) {
                    str = "";
                }
                cooperationItem = new File(str);
                if (cooperationItem.exists() == null) {
                    ApkHelper.launchAppByPackageName(context, appPackageName);
                    new StringBuilder("file not exist --> ").append(cooperationItem.getAbsolutePath());
                    return;
                }
                cooperationItem = Uri.fromFile(cooperationItem);
                new StringBuilder("file path --> ").append(cooperationItem.toString());
                try {
                    str = new Intent("android.intent.action.SEND");
                    str.setPackage(appPackageName);
                    str.putExtra("android.intent.extra.STREAM", cooperationItem);
                    str.setDataAndType(cooperationItem, "*/*");
                    str.addFlags(268435456);
                    context.startActivity(str);
                    return;
                } catch (Context context2) {
                    context2.printStackTrace();
                    return;
                }
            }
            a(context2, cooperationItem);
        }
    }

    public final void a(Context context, CooperationItem cooperationItem) {
        String appDownloadUrl = cooperationItem.getAppDownloadUrl();
        if (!TextUtils.isEmpty(appDownloadUrl)) {
            boolean isShowInstallTip = cooperationItem.isShowInstallTip();
            n.a();
            long e = n.e(appDownloadUrl);
            TaskInfo taskInfo = null;
            if (e > 0) {
                n.a();
                taskInfo = n.f(e);
            }
            if (taskInfo != null && taskInfo.getTaskStatus() == 8) {
                if (!TextUtils.isEmpty(taskInfo.mLocalFileName)) {
                    if (isShowInstallTip) {
                        a(context, cooperationItem, true, taskInfo.mLocalFileName, taskInfo.getTaskId());
                        return;
                    }
                    b(context, taskInfo.mLocalFileName, taskInfo.getTaskId());
                    return;
                }
            }
            if (isShowInstallTip) {
                a(context, cooperationItem, false, null, -1);
            } else if (a(cooperationItem) != null) {
                a(BrothersApplication.getApplicationInstance(), cooperationItem.getAppName());
            } else {
                c(cooperationItem);
            }
        }
    }

    private static void b(android.content.Context r1, java.lang.String r2, long r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0031 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0031 }
        r2 = r0.exists();	 Catch:{ Exception -> 0x0031 }
        if (r2 != 0) goto L_0x002d;	 Catch:{ Exception -> 0x0031 }
    L_0x000b:
        com.xunlei.downloadprovider.download.engine.task.n.a();	 Catch:{ Exception -> 0x0031 }
        r1 = 1;	 Catch:{ Exception -> 0x0031 }
        r1 = new long[r1];	 Catch:{ Exception -> 0x0031 }
        r2 = 0;	 Catch:{ Exception -> 0x0031 }
        r1[r2] = r3;	 Catch:{ Exception -> 0x0031 }
        com.xunlei.downloadprovider.download.engine.task.n.a(r2, r1);	 Catch:{ Exception -> 0x0031 }
        r1 = com.xunlei.downloadprovider.download.engine.task.n.a();	 Catch:{ Exception -> 0x0031 }
        r2 = r1.a;	 Catch:{ Exception -> 0x0031 }
        r0 = new com.xunlei.downloadprovider.download.engine.task.t;	 Catch:{ Exception -> 0x0031 }
        r0.<init>(r1, r3);	 Catch:{ Exception -> 0x0031 }
        r2.execute(r0);	 Catch:{ Exception -> 0x0031 }
        r1 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ Exception -> 0x0031 }
        com.xunlei.downloadprovider.dialog.XLAlarmDialogActivity.a(r1, r3);	 Catch:{ Exception -> 0x0031 }
        return;	 Catch:{ Exception -> 0x0031 }
    L_0x002d:
        com.xunlei.common.androidutil.ApkHelper.installApk(r1, r0);	 Catch:{ Exception -> 0x0031 }
        return;
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.cooperation.ui.b.b(android.content.Context, java.lang.String, long):void");
    }

    private void a(Context context, CooperationItem cooperationItem, boolean z, String str, long j) {
        f();
        Context context2 = context;
        this.h = new f(context2);
        this.h.setTitle(TextUtils.isEmpty(cooperationItem.getTitle()) ? "" : cooperationItem.getTitle());
        r8.h.b(cooperationItem.getAppDescription());
        CooperationItem cooperationItem2 = cooperationItem;
        r8.h.a(new c(r8, cooperationItem2));
        r8.h.b(new d(r8, cooperationItem2, z, context2, str, j));
        r8.h.show();
        a.a(l.c(cooperationItem2.getDisplayLocation()), cooperationItem2.getAppPackageName());
    }

    private void f() {
        if (this.h != null) {
            if (this.h.isShowing()) {
                this.h.dismiss();
            }
            this.h = null;
        }
    }

    private static void c(CooperationItem cooperationItem) {
        if (cooperationItem != null) {
            DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
            downloadAdditionInfo.b = TextUtils.isEmpty(cooperationItem.getAppSelfIconUrl()) ? cooperationItem.getAppIconUrl() : cooperationItem.getAppSelfIconUrl();
            downloadAdditionInfo.a = cooperationItem.getAppName();
            downloadAdditionInfo.f = true;
            String appDownloadUrl = cooperationItem.getAppDownloadUrl();
            TaskStatInfo taskStatInfo = new TaskStatInfo(appDownloadUrl, null);
            taskStatInfo.a = com.xunlei.downloadprovider.download.report.c.a(l.c(cooperationItem.getDisplayLocation()), cooperationItem.getAppPackageName());
            cooperationItem = "";
            if (!TextUtils.isEmpty(downloadAdditionInfo.a)) {
                cooperationItem = new StringBuilder();
                cooperationItem.append(downloadAdditionInfo.a);
                cooperationItem.append(ShareConstants.PATCH_SUFFIX);
                cooperationItem = cooperationItem.toString();
            }
            com.xunlei.downloadprovider.download.c.a(appDownloadUrl, cooperationItem, 0, "", taskStatInfo, downloadAdditionInfo, null);
        }
    }

    public static void d() {
        new PreferenceHelper(BrothersApplication.getApplicationInstance(), "download_storage_cooperation").putBoolean("cooperation_pop_show", true);
    }

    public static boolean e() {
        return new PreferenceHelper(BrothersApplication.getApplicationInstance(), "download_storage_cooperation").getBoolean("cooperation_pop_show", false);
    }

    public final void a(Context context, int i) {
        CooperationData cooperationData = new CooperationData();
        cooperationData.mCooperationScene = c.a().b(i);
        if (cooperationData.mCooperationScene != 0) {
            CooperationDialogActivity.a(context, cooperationData, SceneUiStyle.TWO_BUTTON, new e(this, context, cooperationData));
            this.d = true;
        }
    }
}
