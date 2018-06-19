package com.tencent.bugly.beta;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.tinker.TinkerApplicationLike;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.tinker.TinkerManager.TinkerPatchResultListener;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.beta.upgrade.c;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: BUGLY */
public class Beta extends a {
    public static final String TAG_CANCEL_BUTTON = "beta_cancel_button";
    public static final String TAG_CONFIRM_BUTTON = "beta_confirm_button";
    public static final String TAG_IMG_BANNER = "beta_upgrade_banner";
    public static final String TAG_TIP_MESSAGE = "beta_tip_message";
    public static final String TAG_TITLE = "beta_title";
    public static final String TAG_UPGRADE_FEATURE = "beta_upgrade_feature";
    public static final String TAG_UPGRADE_INFO = "beta_upgrade_info";
    private static DownloadTask a = null;
    public static String appChannel = null;
    public static int appVersionCode = Integer.MIN_VALUE;
    public static String appVersionName = null;
    public static boolean autoCheckUpgrade = true;
    public static boolean autoDownloadOnWifi = false;
    public static boolean autoInit = true;
    public static BetaPatchListener betaPatchListener = null;
    public static boolean canAutoDownloadPatch = true;
    public static boolean canAutoPatch = true;
    public static List<Class<? extends Activity>> canNotShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static boolean canNotifyUserRestart = false;
    public static boolean canShowApkInfo = true;
    public static List<Class<? extends Activity>> canShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static int defaultBannerId = 0;
    public static boolean dialogFullScreen = false;
    public static DownloadListener downloadListener = null;
    public static boolean enableHotfix = false;
    public static boolean enableNotification = true;
    public static long initDelay = 3000;
    public static String initProcessName = null;
    public static Beta instance = new Beta();
    public static int largeIconId = 0;
    public static boolean showInterruptedStrategy = true;
    public static int smallIconId = 0;
    public static List<String> soBlackList = Collections.synchronizedList(new ArrayList());
    public static File storageDir = null;
    public static String strNetworkTipsCancelBtn = "取消";
    public static String strNetworkTipsConfirmBtn = "继续下载";
    public static String strNetworkTipsMessage = "你已切换到移动网络，是否继续当前下载？";
    public static String strNetworkTipsTitle = "网络提示";
    public static String strNotificationClickToContinue = "继续下载";
    public static String strNotificationClickToInstall = "点击安装";
    public static String strNotificationClickToRetry = "点击重试";
    public static String strNotificationClickToView = "点击查看";
    public static String strNotificationDownloadError = "下载失败";
    public static String strNotificationDownloadSucc = "下载完成";
    public static String strNotificationDownloading = "正在下载";
    public static String strNotificationHaveNewVersion = "有新版本";
    public static String strToastCheckUpgradeError = "检查新版本失败，请稍后重试";
    public static String strToastCheckingUpgrade = "正在检查，请稍候...";
    public static String strToastYourAreTheLatestVersion = "你已经是最新版了";
    public static String strUpgradeDialogCancelBtn = "下次再说";
    public static String strUpgradeDialogContinueBtn = "继续";
    public static String strUpgradeDialogFeatureLabel = "更新说明";
    public static String strUpgradeDialogFileSizeLabel = "包大小";
    public static String strUpgradeDialogInstallBtn = "安装";
    public static String strUpgradeDialogRetryBtn = "重试";
    public static String strUpgradeDialogUpdateTimeLabel = "更新时间";
    public static String strUpgradeDialogUpgradeBtn = "立即更新";
    public static String strUpgradeDialogVersionLabel = "版本";
    public static int tipsDialogLayoutId;
    public static long upgradeCheckPeriod;
    public static int upgradeDialogLayoutId;
    public static UILifecycleListener<UpgradeInfo> upgradeDialogLifecycleListener;
    public static UpgradeListener upgradeListener;
    public static UpgradeStateListener upgradeStateListener;

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public static Beta getInstance() {
        instance.id = 1002;
        instance.version = "1.3.4";
        instance.versionKey = "G10";
        return instance;
    }

    public static void checkUpgrade() {
        checkUpgrade(true, false);
    }

    public static void checkUpgrade(boolean r11, boolean r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0119 }
        r0 = r0.v;	 Catch:{ Exception -> 0x0119 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0119 }
        r1 = 2;	 Catch:{ Exception -> 0x0119 }
        r2 = 1;	 Catch:{ Exception -> 0x0119 }
        r3 = 0;	 Catch:{ Exception -> 0x0119 }
        if (r0 == 0) goto L_0x0054;	 Catch:{ Exception -> 0x0119 }
    L_0x000d:
        r0 = android.os.Looper.myLooper();	 Catch:{ Exception -> 0x0119 }
        r4 = android.os.Looper.getMainLooper();	 Catch:{ Exception -> 0x0119 }
        if (r0 != r4) goto L_0x0034;	 Catch:{ Exception -> 0x0119 }
    L_0x0017:
        r0 = com.tencent.bugly.proguard.am.a();	 Catch:{ Exception -> 0x0119 }
        r4 = new com.tencent.bugly.beta.global.d;	 Catch:{ Exception -> 0x0119 }
        r5 = 19;	 Catch:{ Exception -> 0x0119 }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0119 }
        r11 = java.lang.Boolean.valueOf(r11);	 Catch:{ Exception -> 0x0119 }
        r1[r3] = r11;	 Catch:{ Exception -> 0x0119 }
        r11 = java.lang.Boolean.valueOf(r12);	 Catch:{ Exception -> 0x0119 }
        r1[r2] = r11;	 Catch:{ Exception -> 0x0119 }
        r4.<init>(r5, r1);	 Catch:{ Exception -> 0x0119 }
        r0.a(r4);	 Catch:{ Exception -> 0x0119 }
        return;	 Catch:{ Exception -> 0x0119 }
    L_0x0034:
        r0 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0119 }
        monitor-enter(r0);	 Catch:{ Exception -> 0x0119 }
    L_0x0037:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0051 }
        r4 = r4.v;	 Catch:{ all -> 0x0051 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0051 }
        if (r4 == 0) goto L_0x004f;
    L_0x0041:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ InterruptedException -> 0x0047 }
        r4.wait();	 Catch:{ InterruptedException -> 0x0047 }
        goto L_0x0037;
    L_0x0047:
        r4 = "wait error";	 Catch:{ all -> 0x0051 }
        r5 = new java.lang.Object[r3];	 Catch:{ all -> 0x0051 }
        com.tencent.bugly.proguard.an.e(r4, r5);	 Catch:{ all -> 0x0051 }
        goto L_0x0037;	 Catch:{ all -> 0x0051 }
    L_0x004f:
        monitor-exit(r0);	 Catch:{ all -> 0x0051 }
        goto L_0x0054;	 Catch:{ all -> 0x0051 }
    L_0x0051:
        r11 = move-exception;	 Catch:{ all -> 0x0051 }
        monitor-exit(r0);	 Catch:{ all -> 0x0051 }
        throw r11;	 Catch:{ Exception -> 0x0119 }
    L_0x0054:
        r0 = 3;	 Catch:{ Exception -> 0x0119 }
        if (r11 != 0) goto L_0x00a1;	 Catch:{ Exception -> 0x0119 }
    L_0x0057:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0119 }
        r4 = r4.v;	 Catch:{ Exception -> 0x0119 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0119 }
        if (r4 == 0) goto L_0x0069;	 Catch:{ Exception -> 0x0119 }
    L_0x0061:
        r4 = "[beta] BetaModule is uninitialized";	 Catch:{ Exception -> 0x0119 }
        r5 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0119 }
        com.tencent.bugly.proguard.an.e(r4, r5);	 Catch:{ Exception -> 0x0119 }
        goto L_0x00a1;	 Catch:{ Exception -> 0x0119 }
    L_0x0069:
        r4 = "st.bch";	 Catch:{ Exception -> 0x0119 }
        r5 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR;	 Catch:{ Exception -> 0x0119 }
        r4 = com.tencent.bugly.beta.global.a.a(r4, r5);	 Catch:{ Exception -> 0x0119 }
        r4 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r4;	 Catch:{ Exception -> 0x0119 }
        if (r4 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x0119 }
    L_0x0075:
        r5 = r4.a;	 Catch:{ Exception -> 0x0119 }
        if (r5 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x0119 }
    L_0x0079:
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0119 }
        r7 = r4.e;	 Catch:{ Exception -> 0x0119 }
        r9 = r5 - r7;	 Catch:{ Exception -> 0x0119 }
        r5 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0119 }
        r5 = r5.c;	 Catch:{ Exception -> 0x0119 }
        r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));	 Catch:{ Exception -> 0x0119 }
        if (r7 > 0) goto L_0x009c;	 Catch:{ Exception -> 0x0119 }
    L_0x0089:
        r4 = r4.a;	 Catch:{ Exception -> 0x0119 }
        r4 = r4.p;	 Catch:{ Exception -> 0x0119 }
        if (r4 != r0) goto L_0x0090;	 Catch:{ Exception -> 0x0119 }
    L_0x008f:
        goto L_0x009c;	 Catch:{ Exception -> 0x0119 }
    L_0x0090:
        r5 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0119 }
        r8 = 0;	 Catch:{ Exception -> 0x0119 }
        r9 = 0;	 Catch:{ Exception -> 0x0119 }
        r10 = "";	 Catch:{ Exception -> 0x0119 }
        r6 = r11;	 Catch:{ Exception -> 0x0119 }
        r7 = r12;	 Catch:{ Exception -> 0x0119 }
        r5.a(r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x0119 }
        goto L_0x00a1;	 Catch:{ Exception -> 0x0119 }
    L_0x009c:
        r4 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0119 }
        r4.a(r11, r12, r3);	 Catch:{ Exception -> 0x0119 }
    L_0x00a1:
        if (r11 == 0) goto L_0x0118;	 Catch:{ Exception -> 0x0119 }
    L_0x00a3:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0119 }
        r4 = r4.v;	 Catch:{ Exception -> 0x0119 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0119 }
        r5 = 5;	 Catch:{ Exception -> 0x0119 }
        r6 = 18;	 Catch:{ Exception -> 0x0119 }
        if (r4 == 0) goto L_0x00e6;	 Catch:{ Exception -> 0x0119 }
    L_0x00b0:
        r12 = "[beta] BetaModule is uninitialized";	 Catch:{ Exception -> 0x0119 }
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0119 }
        com.tencent.bugly.proguard.an.e(r12, r4);	 Catch:{ Exception -> 0x0119 }
        r12 = upgradeStateListener;	 Catch:{ Exception -> 0x0119 }
        if (r12 == 0) goto L_0x00d7;	 Catch:{ Exception -> 0x0119 }
    L_0x00bb:
        r12 = new com.tencent.bugly.beta.global.d;	 Catch:{ Exception -> 0x0119 }
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0119 }
        r4 = upgradeStateListener;	 Catch:{ Exception -> 0x0119 }
        r0[r3] = r4;	 Catch:{ Exception -> 0x0119 }
        r3 = -1;	 Catch:{ Exception -> 0x0119 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0119 }
        r0[r2] = r3;	 Catch:{ Exception -> 0x0119 }
        r11 = java.lang.Boolean.valueOf(r11);	 Catch:{ Exception -> 0x0119 }
        r0[r1] = r11;	 Catch:{ Exception -> 0x0119 }
        r12.<init>(r6, r0);	 Catch:{ Exception -> 0x0119 }
        com.tencent.bugly.beta.utils.e.a(r12);	 Catch:{ Exception -> 0x0119 }
        return;	 Catch:{ Exception -> 0x0119 }
    L_0x00d7:
        r11 = new com.tencent.bugly.beta.global.d;	 Catch:{ Exception -> 0x0119 }
        r12 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0119 }
        r0 = strToastCheckUpgradeError;	 Catch:{ Exception -> 0x0119 }
        r12[r3] = r0;	 Catch:{ Exception -> 0x0119 }
        r11.<init>(r5, r12);	 Catch:{ Exception -> 0x0119 }
        com.tencent.bugly.beta.utils.e.a(r11);	 Catch:{ Exception -> 0x0119 }
        return;	 Catch:{ Exception -> 0x0119 }
    L_0x00e6:
        r4 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0119 }
        r4.a(r11, r12, r2);	 Catch:{ Exception -> 0x0119 }
        r12 = upgradeStateListener;	 Catch:{ Exception -> 0x0119 }
        if (r12 == 0) goto L_0x010a;	 Catch:{ Exception -> 0x0119 }
    L_0x00ef:
        r12 = new com.tencent.bugly.beta.global.d;	 Catch:{ Exception -> 0x0119 }
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0119 }
        r4 = upgradeStateListener;	 Catch:{ Exception -> 0x0119 }
        r0[r3] = r4;	 Catch:{ Exception -> 0x0119 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0119 }
        r0[r2] = r3;	 Catch:{ Exception -> 0x0119 }
        r11 = java.lang.Boolean.valueOf(r11);	 Catch:{ Exception -> 0x0119 }
        r0[r1] = r11;	 Catch:{ Exception -> 0x0119 }
        r12.<init>(r6, r0);	 Catch:{ Exception -> 0x0119 }
        com.tencent.bugly.beta.utils.e.a(r12);	 Catch:{ Exception -> 0x0119 }
        return;	 Catch:{ Exception -> 0x0119 }
    L_0x010a:
        r11 = new com.tencent.bugly.beta.global.d;	 Catch:{ Exception -> 0x0119 }
        r12 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0119 }
        r0 = strToastCheckingUpgrade;	 Catch:{ Exception -> 0x0119 }
        r12[r3] = r0;	 Catch:{ Exception -> 0x0119 }
        r11.<init>(r5, r12);	 Catch:{ Exception -> 0x0119 }
        com.tencent.bugly.beta.utils.e.a(r11);	 Catch:{ Exception -> 0x0119 }
    L_0x0118:
        return;
    L_0x0119:
        r11 = move-exception;
        r12 = com.tencent.bugly.proguard.an.b(r11);
        if (r12 != 0) goto L_0x0123;
    L_0x0120:
        r11.printStackTrace();
    L_0x0123:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.checkUpgrade(boolean, boolean):void");
    }

    public static com.tencent.bugly.beta.UpgradeInfo getUpgradeInfo() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0020 }
        r1 = "st.bch";	 Catch:{ Exception -> 0x0020 }
        r2 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR;	 Catch:{ Exception -> 0x0020 }
        r1 = com.tencent.bugly.beta.global.a.a(r1, r2);	 Catch:{ Exception -> 0x0020 }
        r1 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r1;	 Catch:{ Exception -> 0x0020 }
        r0.b = r1;	 Catch:{ Exception -> 0x0020 }
        r0 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0020 }
        r0 = r0.b;	 Catch:{ Exception -> 0x0020 }
        if (r0 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x0020 }
    L_0x0014:
        r0 = new com.tencent.bugly.beta.UpgradeInfo;	 Catch:{ Exception -> 0x0020 }
        r1 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0020 }
        r1 = r1.b;	 Catch:{ Exception -> 0x0020 }
        r1 = r1.a;	 Catch:{ Exception -> 0x0020 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0020 }
        return r0;
    L_0x0020:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.getUpgradeInfo():com.tencent.bugly.beta.UpgradeInfo");
    }

    public static synchronized void init(Context context, boolean z) {
        synchronized (Beta.class) {
            an.a("Beta init start....", new Object[0]);
            ac a = ac.a();
            int i = instance.id;
            int i2 = e.a + 1;
            e.a = i2;
            a.a(i, i2);
            if (TextUtils.isEmpty(initProcessName)) {
                initProcessName = context.getPackageName();
            }
            an.a("Beta will init at: %s", initProcessName);
            an.a("current process: %s", com.tencent.bugly.crashreport.common.info.a.b().e);
            if (TextUtils.equals(initProcessName, com.tencent.bugly.crashreport.common.info.a.b().e)) {
                e eVar = e.E;
                if (TextUtils.isEmpty(eVar.v)) {
                    an.a("current upgrade sdk version:1.3.4", new Object[0]);
                    eVar.D = z;
                    if (upgradeCheckPeriod < 0) {
                        an.d("upgradeCheckPeriod cannot be negative", new Object[0]);
                    } else {
                        eVar.c = upgradeCheckPeriod;
                        an.a("setted upgradeCheckPeriod: %d", Long.valueOf(upgradeCheckPeriod));
                    }
                    if (initDelay < 0) {
                        an.d("initDelay cannot be negative", new Object[0]);
                    } else {
                        eVar.b = initDelay;
                        an.a("setted initDelay: %d", Long.valueOf(initDelay));
                    }
                    if (smallIconId) {
                        try {
                            if (context.getResources().getDrawable(smallIconId)) {
                                eVar.f = smallIconId;
                                an.a("setted smallIconId: %d", Integer.valueOf(smallIconId));
                            }
                        } catch (boolean z2) {
                            an.e("smallIconId is not available:\n %s", z2.toString());
                        }
                    }
                    if (largeIconId) {
                        try {
                            if (context.getResources().getDrawable(largeIconId)) {
                                eVar.g = largeIconId;
                                an.a("setted largeIconId: %d", Integer.valueOf(largeIconId));
                            }
                        } catch (boolean z22) {
                            an.e("largeIconId is not available:\n %s", z22.toString());
                        }
                    }
                    if (defaultBannerId) {
                        try {
                            if (context.getResources().getDrawable(defaultBannerId)) {
                                eVar.h = defaultBannerId;
                                an.a("setted defaultBannerId: %d", Integer.valueOf(defaultBannerId));
                            }
                        } catch (boolean z222) {
                            an.e("defaultBannerId is not available:\n %s", z222.toString());
                        }
                    }
                    if (upgradeDialogLayoutId) {
                        try {
                            z222 = context.getResources().getLayout(upgradeDialogLayoutId);
                            if (z222) {
                                eVar.i = upgradeDialogLayoutId;
                                an.a("setted upgradeDialogLayoutId: %d", Integer.valueOf(upgradeDialogLayoutId));
                                z222.close();
                            }
                        } catch (boolean z2222) {
                            an.e("upgradeDialogLayoutId is not available:\n %s", z2222.toString());
                        }
                    }
                    if (tipsDialogLayoutId) {
                        try {
                            z2222 = context.getResources().getLayout(tipsDialogLayoutId);
                            if (z2222) {
                                eVar.j = tipsDialogLayoutId;
                                an.a("setted tipsDialogLayoutId: %d", Integer.valueOf(tipsDialogLayoutId));
                                z2222.close();
                            }
                        } catch (boolean z22222) {
                            an.e("tipsDialogLayoutId is not available:\n %s", z22222.toString());
                        }
                    }
                    if (upgradeDialogLifecycleListener) {
                        try {
                            eVar.k = upgradeDialogLifecycleListener;
                            z22222 = new StringBuilder("setted upgradeDialogLifecycleListener:%s");
                            z22222.append(upgradeDialogLifecycleListener);
                            an.a(z22222.toString(), new Object[0]);
                        } catch (boolean z222222) {
                            an.e("upgradeDialogLifecycleListener is not available:\n %", z222222.toString());
                        }
                    }
                    if (canShowUpgradeActs && !canShowUpgradeActs.isEmpty()) {
                        for (Class cls : canShowUpgradeActs) {
                            if (cls != null) {
                                eVar.m.add(cls);
                            }
                        }
                        an.a("setted canShowUpgradeActs: %s", eVar.m);
                    }
                    if (canNotShowUpgradeActs && !canNotShowUpgradeActs.isEmpty()) {
                        for (Class cls2 : canNotShowUpgradeActs) {
                            if (cls2 != null) {
                                eVar.n.add(cls2);
                            }
                        }
                        an.a("setted canNotShowUpgradeActs: %s", eVar.n);
                    }
                    eVar.d = autoCheckUpgrade;
                    String str = "autoCheckUpgrade %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = eVar.d ? "is opened" : "is closed";
                    an.a(str, objArr);
                    eVar.e = showInterruptedStrategy;
                    str = "showInterruptedStrategy %s";
                    objArr = new Object[1];
                    objArr[0] = eVar.e ? "is opened" : "is closed";
                    an.a(str, objArr);
                    str = "isDIY %s";
                    objArr = new Object[1];
                    objArr[0] = upgradeListener != null ? "is opened" : "is closed";
                    an.a(str, objArr);
                    if (storageDir) {
                        if (storageDir.exists() || storageDir.mkdirs()) {
                            eVar.l = storageDir;
                            an.a("setted storageDir: %s", storageDir.getAbsolutePath());
                        } else {
                            an.a("storageDir is not exists: %s", storageDir.getAbsolutePath());
                        }
                    }
                    if (!eVar.p) {
                        eVar.p = s.a;
                    }
                    if (TextUtils.isEmpty(eVar.u)) {
                        eVar.u = com.tencent.bugly.crashreport.common.info.a.b().f();
                    }
                    eVar.R = enableNotification;
                    objArr = new Object[1];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(enableNotification);
                    objArr[0] = stringBuilder.toString();
                    an.a("enableNotification %s", objArr);
                    eVar.S = autoDownloadOnWifi;
                    objArr = new Object[1];
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(autoDownloadOnWifi);
                    objArr[0] = stringBuilder.toString();
                    an.a("autoDownloadOnWifi %s", objArr);
                    eVar.T = canShowApkInfo;
                    objArr = new Object[1];
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(canShowApkInfo);
                    objArr[0] = stringBuilder.toString();
                    an.a("canShowApkInfo %s", objArr);
                    eVar.U = canAutoPatch;
                    objArr = new Object[1];
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(canAutoPatch);
                    objArr[0] = stringBuilder.toString();
                    an.a("canAutoPatch %s", objArr);
                    eVar.V = betaPatchListener;
                    eVar.x = appVersionName;
                    eVar.w = appVersionCode;
                    eVar.W = canNotifyUserRestart;
                    objArr = new Object[1];
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(canNotifyUserRestart);
                    objArr[0] = stringBuilder.toString();
                    an.a("canNotifyUserRestart %s", objArr);
                    eVar.X = canAutoDownloadPatch;
                    objArr = new Object[1];
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(canAutoDownloadPatch);
                    objArr[0] = stringBuilder.toString();
                    an.a("canAutoDownloadPatch %s", objArr);
                    eVar.Y = enableHotfix;
                    objArr = new Object[1];
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(enableHotfix);
                    objArr[0] = stringBuilder.toString();
                    an.a("enableHotfix %s", objArr);
                    if (soBlackList && !soBlackList.isEmpty()) {
                        for (String str2 : soBlackList) {
                            if (str2 != null) {
                                eVar.Z.add(str2);
                            }
                        }
                        an.a("setted soBlackList: %s", eVar.Z);
                    }
                    if (appChannel) {
                        eVar.P = appChannel;
                        an.a("Beta channel %s", appChannel);
                    }
                    eVar.a(context);
                    ResBean resBean = (ResBean) com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.CREATOR);
                    ResBean.a = resBean;
                    if (resBean == null) {
                        ResBean.a = new ResBean();
                    }
                    c.a.e = upgradeListener;
                    c.a.f = upgradeStateListener;
                    c.a.d = downloadListener;
                    if (getStrategyTask() && downloadListener) {
                        getStrategyTask().addListener(c.a.d);
                    }
                    if (enableHotfix) {
                        an.a("enableHotfix %s", "1");
                        ap.b("D4", "1");
                        r.a(context);
                    }
                    z222222 = context.getResources();
                    DisplayMetrics displayMetrics = z222222.getDisplayMetrics();
                    Configuration configuration = z222222.getConfiguration();
                    configuration.locale = Locale.getDefault();
                    if (configuration.locale.equals(Locale.US) || configuration.locale.equals(Locale.ENGLISH)) {
                        strToastYourAreTheLatestVersion = context.getResources().getString(R$string.strToastYourAreTheLatestVersion);
                        strToastCheckUpgradeError = context.getResources().getString(R$string.strToastCheckUpgradeError);
                        strToastCheckingUpgrade = context.getResources().getString(R$string.strToastCheckingUpgrade);
                        strNotificationDownloading = context.getResources().getString(R$string.strNotificationDownloading);
                        strNotificationClickToView = context.getResources().getString(R$string.strNotificationClickToView);
                        strNotificationClickToInstall = context.getResources().getString(R$string.strNotificationClickToInstall);
                        strNotificationClickToContinue = context.getResources().getString(R$string.strNotificationClickToContinue);
                        strNotificationClickToRetry = context.getResources().getString(R$string.strNotificationClickToRetry);
                        strNotificationDownloadSucc = context.getResources().getString(R$string.strNotificationDownloadSucc);
                        strNotificationDownloadError = context.getResources().getString(R$string.strNotificationDownloadError);
                        strNotificationHaveNewVersion = context.getResources().getString(R$string.strNotificationHaveNewVersion);
                        strNetworkTipsMessage = context.getResources().getString(R$string.strNetworkTipsMessage);
                        strNetworkTipsTitle = context.getResources().getString(R$string.strNetworkTipsTitle);
                        strNetworkTipsConfirmBtn = context.getResources().getString(R$string.strNetworkTipsConfirmBtn);
                        strNetworkTipsCancelBtn = context.getResources().getString(R$string.strNetworkTipsCancelBtn);
                        strUpgradeDialogVersionLabel = context.getResources().getString(R$string.strUpgradeDialogVersionLabel);
                        strUpgradeDialogFileSizeLabel = context.getResources().getString(R$string.strUpgradeDialogFileSizeLabel);
                        strUpgradeDialogUpdateTimeLabel = context.getResources().getString(R$string.strUpgradeDialogUpdateTimeLabel);
                        strUpgradeDialogFeatureLabel = context.getResources().getString(R$string.strUpgradeDialogFeatureLabel);
                        strUpgradeDialogUpgradeBtn = context.getResources().getString(R$string.strUpgradeDialogUpgradeBtn);
                        strUpgradeDialogInstallBtn = context.getResources().getString(R$string.strUpgradeDialogInstallBtn);
                        strUpgradeDialogRetryBtn = context.getResources().getString(R$string.strUpgradeDialogRetryBtn);
                        strUpgradeDialogContinueBtn = context.getResources().getString(R$string.strUpgradeDialogContinueBtn);
                        strUpgradeDialogCancelBtn = context.getResources().getString(R$string.strUpgradeDialogCancelBtn);
                    }
                    z222222.updateConfiguration(configuration, displayMetrics);
                    am.a().a(new d(1, new Object[0]), eVar.b);
                    context = ac.a();
                    int i3 = instance.id;
                    int i4 = e.a - 1;
                    e.a = i4;
                    context.a(i3, i4);
                    an.a("Beta init finished...", new Object[0]);
                    return;
                }
                an.d("Beta has been initialized [apkMD5 : %s]", new Object[]{eVar.v});
                return;
            }
        }
    }

    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        com.tencent.bugly.crashreport.common.info.a.b().c("G10", "1.3.4");
        if (autoInit != null) {
            init(context, z);
        }
    }

    public String[] getTables() {
        return new String[]{"dl_1002", "ge_1002", "st_1002"};
    }

    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Throwable th;
        while (i < i2) {
            Cursor query;
            if (i == 10) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.setLength(0);
                    stringBuilder.append(" CREATE TABLE  IF NOT EXISTS st_1002 ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
                    an.c("create %s", stringBuilder.toString());
                    sQLiteDatabase.execSQL(stringBuilder.toString());
                } catch (Throwable th2) {
                    if (!an.b(th2)) {
                        th2.printStackTrace();
                    }
                }
                try {
                    SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                    query = sQLiteDatabase2.query("t_pf", null, "_id = 1002", null, null, null, null);
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        return;
                    }
                    while (query.moveToNext()) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            if (query.getLong(query.getColumnIndex("_id")) > 0) {
                                contentValues.put("_id", Long.valueOf(query.getLong(query.getColumnIndex("_id"))));
                            }
                            contentValues.put("_tm", Long.valueOf(query.getLong(query.getColumnIndex("_tm"))));
                            contentValues.put("_tp", query.getString(query.getColumnIndex("_tp")));
                            contentValues.put("_dt", query.getBlob(query.getColumnIndex("_dt")));
                            sQLiteDatabase.replace("st_1002", null, contentValues);
                        } catch (Throwable th3) {
                            th2 = th3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th4) {
                    sQLiteDatabase = th4;
                    query = null;
                }
            }
            i++;
        }
        return;
        if (query != null) {
            query.close();
        }
        throw sQLiteDatabase;
    }

    public static void registerDownloadListener(DownloadListener downloadListener) {
        e.E.q = downloadListener;
        if (e.E.q != null && c.a.c != null) {
            c.a.c.addListener(downloadListener);
        }
    }

    public static void unregisterDownloadListener() {
        if (c.a.c != null) {
            c.a.c.removeListener(e.E.q);
        }
        e.E.q = null;
    }

    public static DownloadTask startDownload() {
        if (c.a.h == null || c.a.h.b[0] != c.a.c) {
            c.a.h = new d(13, c.a.c, c.a.b);
        }
        c.a.h.run();
        return c.a.c;
    }

    public static void cancelDownload() {
        if (!(c.a.i != null && c.a.i.b[0] == c.a.c && c.a.i.b[1] == c.a.b && ((Boolean) c.a.i.b[2]).booleanValue() == c.a.g)) {
            c.a.i = new d(14, c.a.c, c.a.b, Boolean.valueOf(c.a.g));
        }
        c.a.i.run();
    }

    public static DownloadTask getStrategyTask() {
        if (a == null) {
            c.a.b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("st.bch", BetaGrayStrategy.CREATOR);
            if (c.a.b != null) {
                a = e.E.p.a(c.a.b.a.f.b, e.E.t.getAbsolutePath(), null, c.a.b.a.f.a);
                c.a.c = a;
            }
        }
        return c.a.c;
    }

    public static synchronized void showUpgradeDialog(String str, int i, String str2, long j, int i2, int i3, String str3, String str4, long j2, String str5, String str6, int i4, DownloadListener downloadListener, Runnable runnable, Runnable runnable2, boolean z) {
        synchronized (Beta.class) {
            String str7;
            boolean z2;
            y yVar;
            try {
                Map hashMap = new HashMap();
                hashMap.put("IMG_title", str6);
                hashMap.put("VAL_style", String.valueOf(i4));
                str7 = str;
                String str8 = str2;
                long j3 = j;
                y yVar2 = r2;
                Map map = hashMap;
                y yVar3 = new y(str7, str8, j3, 0, new v(e.E.u, (byte) 1, i3, str3, i2, "", 1, "", str5, "1.3.4", ""), new u(str5, str4, "", j2, ""), (byte) i, 0, 0, null, "", map, null, 1, System.currentTimeMillis(), 1);
                str7 = null;
                z2 = true;
                if (a != null) {
                    String downloadUrl = a.getDownloadUrl();
                    if (downloadUrl == null) {
                        a.delete(z2);
                        a = str7;
                    }
                }
            } finally {
                downloadUrl = 
/*
Method generation error in method: com.tencent.bugly.beta.Beta.showUpgradeDialog(java.lang.String, int, java.lang.String, long, int, int, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, int, com.tencent.bugly.beta.download.DownloadListener, java.lang.Runnable, java.lang.Runnable, boolean):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x011f: MERGE  (r2_28 'downloadUrl' java.lang.String) = (r0_1 java.lang.String), (r45_0 'str4' java.lang.String) in method: com.tencent.bugly.beta.Beta.showUpgradeDialog(java.lang.String, int, java.lang.String, long, int, int, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, int, com.tencent.bugly.beta.download.DownloadListener, java.lang.Runnable, java.lang.Runnable, boolean):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:227)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 27 more

*/

                public static synchronized void onUpgradeReceived(String str, int i, String str2, long j, int i2, int i3, String str3, String str4, long j2, String str5, String str6, int i4, int i5, long j3, String str7, boolean z, boolean z2, int i6, String str8, long j4) {
                    synchronized (Beta.class) {
                        try {
                            String str9;
                            Map hashMap = new HashMap();
                            hashMap.put("IMG_title", str6);
                            hashMap.put("VAL_style", String.valueOf(i4));
                            v vVar = new v(e.E.u, (byte) 1, i3, str3, i2, "", 1, "", str5, "", "");
                            String uVar = new u(str5, str4, "", j2, "");
                            y yVar = new y(str, str2, j, 0, vVar, uVar, (byte) i, i5, j3, null, "", hashMap, str7, 1, j4, 1);
                            c cVar = c.a;
                            if (str8 == null) {
                                String str10 = "";
                            } else {
                                str9 = str8;
                            }
                            cVar.a(z, z2, i6, yVar, str9);
                        } finally {
                            Object obj = r0;
                        }
                    }
                }

                public static synchronized com.tencent.bugly.proguard.y getUpgradeStrategy() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = com.tencent.bugly.beta.Beta.class;
                    monitor-enter(r0);
                    r1 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ all -> 0x0028 }
                    r2 = "st.bch";	 Catch:{ all -> 0x0028 }
                    r3 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR;	 Catch:{ all -> 0x0028 }
                    r2 = com.tencent.bugly.beta.global.a.a(r2, r3);	 Catch:{ all -> 0x0028 }
                    r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2;	 Catch:{ all -> 0x0028 }
                    r1.b = r2;	 Catch:{ all -> 0x0028 }
                    r1 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0025 }
                    r1 = r1.b;	 Catch:{ Exception -> 0x0025 }
                    if (r1 == 0) goto L_0x0025;	 Catch:{ Exception -> 0x0025 }
                L_0x0017:
                    r1 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0025 }
                    r1 = r1.b;	 Catch:{ Exception -> 0x0025 }
                    r1 = r1.a;	 Catch:{ Exception -> 0x0025 }
                    r1 = r1.clone();	 Catch:{ Exception -> 0x0025 }
                    r1 = (com.tencent.bugly.proguard.y) r1;	 Catch:{ Exception -> 0x0025 }
                    monitor-exit(r0);
                    return r1;
                L_0x0025:
                    r1 = 0;
                    monitor-exit(r0);
                    return r1;
                L_0x0028:
                    r1 = move-exception;
                    monitor-exit(r0);
                    throw r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.getUpgradeStrategy():com.tencent.bugly.proguard.y");
                }

                public static synchronized void installApk(File file) {
                    synchronized (Beta.class) {
                        try {
                            y upgradeStrategy = getUpgradeStrategy();
                            if (!(upgradeStrategy == null || com.tencent.bugly.beta.global.a.a(e.E.s, file, upgradeStrategy.f.a) == null)) {
                                p.a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0, upgradeStrategy.e, upgradeStrategy.m, upgradeStrategy.p, null));
                            }
                        } catch (File file2) {
                            file2.printStackTrace();
                        }
                    }
                }

                public static void applyTinkerPatch(Context context, String str) {
                    TinkerManager.getInstance().applyPatch(context, str);
                }

                public static void downloadPatch() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = com.tencent.bugly.proguard.q.a;
                    r1 = com.tencent.bugly.proguard.q.a;
                    r2 = 0;
                    r1 = r1.a(r2);
                    r0.b = r1;
                    r0 = com.tencent.bugly.proguard.q.a;	 Catch:{ Exception -> 0x001f }
                    r0 = r0.b;	 Catch:{ Exception -> 0x001f }
                    if (r0 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x001f }
                L_0x0011:
                    r0 = com.tencent.bugly.proguard.q.a;	 Catch:{ Exception -> 0x001f }
                    r0 = r0.b;	 Catch:{ Exception -> 0x001f }
                    r0 = r0.a;	 Catch:{ Exception -> 0x001f }
                    r1 = com.tencent.bugly.proguard.q.a;	 Catch:{ Exception -> 0x001f }
                    r2 = 0;	 Catch:{ Exception -> 0x001f }
                    r3 = 1;	 Catch:{ Exception -> 0x001f }
                    r1.a(r2, r0, r3);	 Catch:{ Exception -> 0x001f }
                L_0x001e:
                    return;
                L_0x001f:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.downloadPatch():void");
                }

                public static void applyDownloadedPatch() {
                    if (new File(e.E.H.getAbsolutePath()).exists()) {
                        TinkerManager.getInstance().applyPatch(e.E.H.getAbsolutePath(), true);
                    } else {
                        an.c(Beta.class, "[applyDownloadedPatch] patch file not exist", new Object[0]);
                    }
                }

                public static void installTinker() {
                    enableHotfix = true;
                    installTinker(TinkerApplicationLike.getTinkerPatchApplicationLike());
                }

                public static void installTinker(Object obj) {
                    enableHotfix = true;
                    TinkerManager.installTinker(obj);
                }

                public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
                    enableHotfix = true;
                    TinkerManager.installTinker(obj, obj2, obj3, obj4, tinkerPatchResultListener, obj5);
                }

                public static void cleanTinkerPatch(boolean z) {
                    com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false);
                    TinkerManager.getInstance().cleanPatch(z);
                }

                public static void loadArmLibrary(Context context, String str) {
                    TinkerManager.loadArmLibrary(context, str);
                }

                public static void loadArmV7Library(Context context, String str) {
                    TinkerManager.loadArmV7Library(context, str);
                }

                public static void loadLibraryFromTinker(Context context, String str, String str2) {
                    TinkerManager.loadLibraryFromTinker(context, str, str2);
                }

                public static void loadLibrary(String str) {
                    e eVar = e.E;
                    if (str != null) {
                        try {
                            if (!str.isEmpty()) {
                                if (com.tencent.bugly.beta.global.a.b("LoadSoFileResult", true)) {
                                    com.tencent.bugly.beta.global.a.a("LoadSoFileResult", false);
                                    Object b = com.tencent.bugly.beta.global.a.b(str, "");
                                    boolean b2 = com.tencent.bugly.beta.global.a.b("PatchResult", false);
                                    if (TextUtils.isEmpty(b) || !b2) {
                                        System.loadLibrary(str);
                                    } else {
                                        StringBuilder stringBuilder = new StringBuilder("lib/");
                                        stringBuilder.append(b);
                                        TinkerManager.loadLibraryFromTinker(eVar.s, stringBuilder.toString(), str);
                                    }
                                    com.tencent.bugly.beta.global.a.a("LoadSoFileResult", true);
                                    return;
                                }
                                System.loadLibrary(str);
                                com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", true);
                                cleanTinkerPatch(true);
                                return;
                            }
                        } catch (String str2) {
                            str2.printStackTrace();
                            com.tencent.bugly.beta.global.a.a("LoadSoFileResult", false);
                            return;
                        }
                    }
                    an.e("libName is invalid", new Object[0]);
                }

                public static void unInit() {
                    if (com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false)) {
                        com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false);
                        TinkerManager.getInstance().cleanPatch(true);
                    }
                }
            }
