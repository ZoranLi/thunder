package com.xunlei.downloadprovider.app.a;

import android.content.Context;
import android.os.Environment;
import com.getui.gis.sdk.GInsightManager;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.beta.Beta;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.OSUtil;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.download.DownloadManager;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.app.b.b;
import com.xunlei.downloadprovider.app.b.c;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.assistant.clipboardmonitor.ClipboardService;
import com.xunlei.downloadprovider.download.engine.kernel.g;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.loading.LoadingActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.pushmessage.p;
import java.io.File;

/* compiled from: ApplicationInitialization */
class a implements c {
    static final String a = "a";
    private boolean b;
    private boolean c;

    a() {
    }

    public final void a(boolean z) {
        BuglyStrategy buglyStrategy;
        Throwable th;
        String absolutePath;
        StringBuilder stringBuilder;
        File file;
        String curProcessName;
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        boolean endsWith = "5.60.2.5510".endsWith(".0000");
        try {
            String partnerId = AndroidConfig.getPartnerId(applicationInstance);
            buglyStrategy = new BuglyStrategy();
            try {
                buglyStrategy.setAppChannel(partnerId);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                Beta.autoDownloadOnWifi = true;
                Beta.enableNotification = false;
                Beta.canShowApkInfo = false;
                Beta.autoCheckUpgrade = true;
                if (!Beta.canShowApkInfo) {
                    Beta.upgradeDialogLayoutId = R.layout.bugly_upgrade_xl_dialog;
                }
                Beta.canNotShowUpgradeActs.add(LaunchActivity.class);
                Beta.canNotShowUpgradeActs.add(LoadingActivity.class);
                Beta.upgradeStateListener = new b();
                Beta.upgradeDialogLifecycleListener = new c();
                Bugly.init(applicationInstance, "900015673", endsWith, buglyStrategy);
                Bugly.setIsDevelopmentDevice(applicationInstance, endsWith);
                AndroidConfig.init(BrothersApplication.getApplicationInstance());
                BrothersApplication.getSingletonInstance().registerActivityLifeCycle();
                g.a();
                applicationInstance = BrothersApplication.getApplicationInstance();
                if (g.d()) {
                    absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(absolutePath);
                    stringBuilder.append("/xunlei/ThunderdownDB");
                    file = new File(stringBuilder.toString(), "xl_downloads.db");
                    applicationInstance.getSharedPreferences("DownloadManager", 0).edit().putString(DownloadManager.DB_PATH_KEY, file.getAbsolutePath()).apply();
                    new StringBuilder("DownloadSDK: set db_path = ").append(file.getAbsolutePath());
                }
                curProcessName = OSUtil.getCurProcessName(BrothersApplication.getApplicationInstance());
                curProcessName = OSUtil.getProcessNameByCommand();
                VolleyRequestManager.init(BrothersApplication.getApplicationInstance());
                ThunderReport.init(BrothersApplication.getApplicationInstance());
                ThunderReport.setCrashReportProxy(new b(this));
                ThunderReport.setShouleiUserId(LoginHelper.a().g.c());
                ThunderReport.setDebugMode("release".equals("develop"));
                z = HubbleEventBuilder.build("android_launch", "launch");
                LoginHelper.a();
                z.add("if_login", l.c());
                ThunderReport.reportEvent(z);
                GInsightManager.getInstance().init(BrothersApplication.getApplicationInstance(), "vJH6icLzKs5wF78jEcyDA4");
                d.a().h();
                MultiProcessFlag.setMultiProcess(true);
                this.c = true;
                p.a(BrothersApplication.getApplicationInstance(), curProcessName);
                if ("com.xunlei.downloadprovider:umeng".equals(curProcessName)) {
                    ClipboardService.a();
                }
                this.b = this.c;
            }
        } catch (Throwable th3) {
            th = th3;
            buglyStrategy = null;
            th.printStackTrace();
            Beta.autoDownloadOnWifi = true;
            Beta.enableNotification = false;
            Beta.canShowApkInfo = false;
            Beta.autoCheckUpgrade = true;
            if (Beta.canShowApkInfo) {
                Beta.upgradeDialogLayoutId = R.layout.bugly_upgrade_xl_dialog;
            }
            Beta.canNotShowUpgradeActs.add(LaunchActivity.class);
            Beta.canNotShowUpgradeActs.add(LoadingActivity.class);
            Beta.upgradeStateListener = new b();
            Beta.upgradeDialogLifecycleListener = new c();
            Bugly.init(applicationInstance, "900015673", endsWith, buglyStrategy);
            Bugly.setIsDevelopmentDevice(applicationInstance, endsWith);
            AndroidConfig.init(BrothersApplication.getApplicationInstance());
            BrothersApplication.getSingletonInstance().registerActivityLifeCycle();
            g.a();
            applicationInstance = BrothersApplication.getApplicationInstance();
            if (g.d()) {
                absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                stringBuilder = new StringBuilder();
                stringBuilder.append(absolutePath);
                stringBuilder.append("/xunlei/ThunderdownDB");
                file = new File(stringBuilder.toString(), "xl_downloads.db");
                applicationInstance.getSharedPreferences("DownloadManager", 0).edit().putString(DownloadManager.DB_PATH_KEY, file.getAbsolutePath()).apply();
                new StringBuilder("DownloadSDK: set db_path = ").append(file.getAbsolutePath());
            }
            curProcessName = OSUtil.getCurProcessName(BrothersApplication.getApplicationInstance());
            curProcessName = OSUtil.getProcessNameByCommand();
            VolleyRequestManager.init(BrothersApplication.getApplicationInstance());
            ThunderReport.init(BrothersApplication.getApplicationInstance());
            ThunderReport.setCrashReportProxy(new b(this));
            ThunderReport.setShouleiUserId(LoginHelper.a().g.c());
            ThunderReport.setDebugMode("release".equals("develop"));
            z = HubbleEventBuilder.build("android_launch", "launch");
            LoginHelper.a();
            z.add("if_login", l.c());
            ThunderReport.reportEvent(z);
            GInsightManager.getInstance().init(BrothersApplication.getApplicationInstance(), "vJH6icLzKs5wF78jEcyDA4");
            d.a().h();
            MultiProcessFlag.setMultiProcess(true);
            this.c = true;
            p.a(BrothersApplication.getApplicationInstance(), curProcessName);
            if ("com.xunlei.downloadprovider:umeng".equals(curProcessName)) {
                ClipboardService.a();
            }
            this.b = this.c;
        }
        Beta.autoDownloadOnWifi = true;
        Beta.enableNotification = false;
        Beta.canShowApkInfo = false;
        Beta.autoCheckUpgrade = true;
        if (Beta.canShowApkInfo) {
            Beta.upgradeDialogLayoutId = R.layout.bugly_upgrade_xl_dialog;
        }
        Beta.canNotShowUpgradeActs.add(LaunchActivity.class);
        Beta.canNotShowUpgradeActs.add(LoadingActivity.class);
        Beta.upgradeStateListener = new b();
        Beta.upgradeDialogLifecycleListener = new c();
        Bugly.init(applicationInstance, "900015673", endsWith, buglyStrategy);
        Bugly.setIsDevelopmentDevice(applicationInstance, endsWith);
        AndroidConfig.init(BrothersApplication.getApplicationInstance());
        BrothersApplication.getSingletonInstance().registerActivityLifeCycle();
        g.a();
        applicationInstance = BrothersApplication.getApplicationInstance();
        if (g.d()) {
            absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            stringBuilder = new StringBuilder();
            stringBuilder.append(absolutePath);
            stringBuilder.append("/xunlei/ThunderdownDB");
            file = new File(stringBuilder.toString(), "xl_downloads.db");
            applicationInstance.getSharedPreferences("DownloadManager", 0).edit().putString(DownloadManager.DB_PATH_KEY, file.getAbsolutePath()).apply();
            new StringBuilder("DownloadSDK: set db_path = ").append(file.getAbsolutePath());
        }
        curProcessName = OSUtil.getCurProcessName(BrothersApplication.getApplicationInstance());
        if (curProcessName == null || curProcessName.trim().equals("")) {
            curProcessName = OSUtil.getProcessNameByCommand();
        }
        if (BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER.equals(curProcessName) || z) {
            VolleyRequestManager.init(BrothersApplication.getApplicationInstance());
            ThunderReport.init(BrothersApplication.getApplicationInstance());
            ThunderReport.setCrashReportProxy(new b(this));
            ThunderReport.setShouleiUserId(LoginHelper.a().g.c());
            ThunderReport.setDebugMode("release".equals("develop"));
            z = HubbleEventBuilder.build("android_launch", "launch");
            LoginHelper.a();
            z.add("if_login", l.c());
            ThunderReport.reportEvent(z);
            GInsightManager.getInstance().init(BrothersApplication.getApplicationInstance(), "vJH6icLzKs5wF78jEcyDA4");
            d.a().h();
            MultiProcessFlag.setMultiProcess(true);
            this.c = true;
        }
        p.a(BrothersApplication.getApplicationInstance(), curProcessName);
        if ("com.xunlei.downloadprovider:umeng".equals(curProcessName)) {
            ClipboardService.a();
        }
        this.b = this.c;
    }

    public final void a() {
        DownloadConfig.getStoragePath(BrothersApplication.getApplicationInstance());
    }

    public final boolean b() {
        return this.b;
    }
}
