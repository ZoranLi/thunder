package com.tencent.bugly.beta.tinker;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.tinker.TinkerReport.Reporter;
import com.tencent.bugly.beta.tinker.TinkerUtils.ScreenState;
import com.tencent.tinker.lib.library.TinkerLoadLibrary;
import com.tencent.tinker.lib.listener.PatchListener;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerApplicationHelper;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;

/* compiled from: BUGLY */
public class TinkerManager {
    public static final String MF_FILE = "YAPATCH.MF";
    public static final String PATCH_DIR = "dex";
    public static final String PATCH_NAME = "patch.apk";
    private static final String TAG = "Tinker.TinkerManager";
    public static String apkOriginalBuildNum = "";
    private static boolean isInstalled = false;
    public static String patchCurBuildNum = "";
    static TinkerPatchResultListener patchResultListener;
    private static UncaughtExceptionHandler systemExceptionHandler;
    private static TinkerManager tinkerManager = new TinkerManager();
    public static TinkerReport tinkerReport;
    private static TinkerUncaughtExceptionHandler uncaughtExceptionHandler;
    static LoadReporter userLoadReporter;
    static PatchListener userPatchListener;
    static PatchReporter userPatchReporter;
    static AbstractPatch userUpgradePatchProcessor;
    private Application application;
    private ApplicationLike applicationLike;
    private TinkerListener tinkerListener;

    /* compiled from: BUGLY */
    public interface TinkerListener {
        void onApplyFailure(String str);

        void onApplySuccess(String str);

        void onDownloadFailure(String str);

        void onDownloadSuccess(String str);

        void onPatchRollback();

        void onPatchStart();
    }

    /* compiled from: BUGLY */
    public interface TinkerPatchResultListener {
        void onPatchResult(PatchResult patchResult);
    }

    public static TinkerManager getInstance() {
        return tinkerManager;
    }

    private void setTinkerApplicationLike(ApplicationLike applicationLike) {
        this.applicationLike = applicationLike;
        if (applicationLike != null) {
            this.application = applicationLike.getApplication();
        }
    }

    public static ApplicationLike getTinkerApplicationLike() {
        return getInstance().applicationLike;
    }

    public static Application getApplication() {
        return getInstance().application;
    }

    public static void registJavaCrashHandler() {
        if (uncaughtExceptionHandler == null) {
            systemExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            UncaughtExceptionHandler tinkerUncaughtExceptionHandler = new TinkerUncaughtExceptionHandler();
            uncaughtExceptionHandler = tinkerUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(tinkerUncaughtExceptionHandler);
        }
    }

    public static void unregistJavaCrashHandler() {
        if (systemExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(systemExceptionHandler);
        }
    }

    public static void setUpgradeRetryEnable(boolean z) {
        UpgradePatchRetry.getInstance(getTinkerApplicationLike().getApplication()).setRetryEnable(z);
    }

    private static void installDefaultTinker(ApplicationLike applicationLike) {
        if (isInstalled) {
            TinkerLog.w(TAG, "install tinker, but has installed, ignore", new Object[0]);
        } else if (applicationLike == null) {
            TinkerLog.e(TAG, "Tinker ApplicationLike is null", new Object[0]);
        } else {
            getInstance().setTinkerApplicationLike(applicationLike);
            registJavaCrashHandler();
            setUpgradeRetryEnable(true);
            tinkerReport = new TinkerReport();
            TinkerLog.setTinkerLogImp(new TinkerLogger());
            if (TinkerInstaller.install(applicationLike, new TinkerLoadReporter(applicationLike.getApplication()), new TinkerPatchReporter(applicationLike.getApplication()), new TinkerPatchListener(applicationLike.getApplication()), TinkerResultService.class, new UpgradePatch()) != null) {
                isInstalled = true;
            }
        }
    }

    public static void installTinker(Object obj) {
        if (obj == null) {
            TinkerLog.e(TAG, "Tinker ApplicationLike is null", new Object[0]);
        } else if (obj instanceof ApplicationLike) {
            installDefaultTinker((ApplicationLike) obj);
        } else {
            TinkerLog.e(TAG, "NOT tinker ApplicationLike object", new Object[0]);
        }
    }

    public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
        if (obj2 != null) {
            if (obj2 instanceof LoadReporter) {
                userLoadReporter = (LoadReporter) obj2;
            } else {
                TinkerLog.e(TAG, "NOT LoadReporter object", new Object[0]);
                return;
            }
        }
        if (obj3 != null) {
            if ((obj3 instanceof PatchReporter) != null) {
                userPatchReporter = (PatchReporter) obj3;
            } else {
                TinkerLog.e(TAG, "NOT PatchReporter object", new Object[0]);
                return;
            }
        }
        if (obj4 != null) {
            if ((obj4 instanceof PatchListener) != null) {
                userPatchListener = (PatchListener) obj4;
            } else {
                TinkerLog.e(TAG, "NOT PatchListener object", new Object[0]);
                return;
            }
        }
        if (tinkerPatchResultListener != null) {
            if ((tinkerPatchResultListener instanceof TinkerPatchResultListener) != null) {
                patchResultListener = tinkerPatchResultListener;
            } else {
                TinkerLog.e(TAG, "NOT TinkerPatchResultListener object", new Object[0]);
                return;
            }
        }
        if (obj5 != null) {
            if ((obj5 instanceof AbstractPatch) != null) {
                userUpgradePatchProcessor = (AbstractPatch) obj5;
            } else {
                TinkerLog.e(TAG, "NOT AbstractPatch object", new Object[0]);
                return;
            }
        }
        installTinker(obj);
    }

    public static void loadArmLibrary(Context context, String str) {
        TinkerLoadLibrary.loadArmLibrary(context, str);
    }

    public static void loadArmV7Library(Context context, String str) {
        TinkerLoadLibrary.loadArmV7Library(context, str);
    }

    public static void loadLibraryFromTinker(Context context, String str, String str2) {
        TinkerLoadLibrary.loadLibraryFromTinker(context, str, str2);
    }

    public void applyPatch(Context context, String str) {
        if (isInstalled) {
            if (this.tinkerListener != null) {
                this.tinkerListener.onPatchStart();
            }
            TinkerInstaller.onReceiveUpgradePatch(context, str);
            return;
        }
        TinkerLog.w(TAG, "Tinker has not been installed.", new Object[0]);
    }

    public static String getTinkerId() {
        if (Tinker.with(getApplication()).isTinkerLoaded()) {
            HashMap packageConfigs = TinkerApplicationHelper.getPackageConfigs(getTinkerApplicationLike());
            return packageConfigs != null ? String.valueOf(packageConfigs.get(ShareConstants.TINKER_ID)).replace("tinker_id_", "") : "";
        } else {
            Object manifestTinkerID = ShareTinkerInternals.getManifestTinkerID(getApplication());
            return !TextUtils.isEmpty(manifestTinkerID) ? manifestTinkerID.replace("tinker_id_", "") : "";
        }
    }

    public static String getNewTinkerId() {
        HashMap packageConfigs = TinkerApplicationHelper.getPackageConfigs(getTinkerApplicationLike());
        return packageConfigs != null ? String.valueOf(packageConfigs.get(ShareConstants.NEW_TINKER_ID)).replace("tinker_id_", "") : "";
    }

    public void cleanPatch(boolean z) {
        onPatchRollback(z);
    }

    public static boolean isTinkerManagerInstalled() {
        return isInstalled;
    }

    public void setTinkerListener(TinkerListener tinkerListener) {
        this.tinkerListener = tinkerListener;
    }

    public TinkerListener getTinkerListener() {
        return this.tinkerListener;
    }

    public void setTinkerReport(Reporter reporter) {
        if (tinkerReport != null) {
            tinkerReport.setReporter(reporter);
        }
    }

    public void onDownloadSuccess(java.lang.String r5, boolean r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = "Tinker.TinkerManager";	 Catch:{ Exception -> 0x0017 }
        r2 = "onDownloadSuccess.";	 Catch:{ Exception -> 0x0017 }
        r3 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0017 }
        com.tencent.tinker.lib.util.TinkerLog.d(r1, r2, r3);	 Catch:{ Exception -> 0x0017 }
        r1 = r4.tinkerListener;	 Catch:{ Exception -> 0x0017 }
        if (r1 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x0017 }
    L_0x000e:
        r1 = r4.tinkerListener;	 Catch:{ Exception -> 0x0017 }
        r1.onDownloadSuccess(r5);	 Catch:{ Exception -> 0x0017 }
    L_0x0013:
        r4.applyPatch(r5, r6);	 Catch:{ Exception -> 0x0017 }
        return;
    L_0x0017:
        r5 = "Tinker.TinkerManager";
        r6 = "apply patch failed";
        r0 = new java.lang.Object[r0];
        com.tencent.tinker.lib.util.TinkerLog.e(r5, r6, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.tinker.TinkerManager.onDownloadSuccess(java.lang.String, boolean):void");
    }

    public void applyPatch(String str, boolean z) {
        try {
            File file = new File(this.applicationLike.getApplication().getDir("dex", 0).getAbsolutePath(), PATCH_NAME);
            File file2 = null;
            if (checkNewPatch(str)) {
                TinkerLog.d(TAG, "has new patch.", new Object[0]);
                file2 = new File(str);
                TinkerUtils.copy(file2, file);
            }
            if (file.exists() == null) {
                TinkerLog.d(TAG, "patch not exist, just return.", new Object[0]);
                return;
            }
            if (file2 != null && z) {
                TinkerLog.d(TAG, "starting patch.", new Object[0]);
                applyPatch(this.applicationLike.getApplication(), file2.getAbsolutePath());
            }
        } catch (String str2) {
            TinkerLog.e(TAG, str2.getMessage(), new Object[0]);
        }
    }

    public boolean checkNewPatch(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "Tinker.TinkerManager";
        r1 = "check if has new patch.";
        r2 = 0;
        r3 = new java.lang.Object[r2];
        com.tencent.tinker.lib.util.TinkerLog.d(r0, r1, r3);
        r0 = getTinkerId();
        apkOriginalBuildNum = r0;
        r0 = getNewTinkerId();
        patchCurBuildNum = r0;
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 1;
        if (r0 == 0) goto L_0x0021;
    L_0x001d:
        r5 = 0;
        r0 = r5;
    L_0x001f:
        r5 = r2;
        goto L_0x002e;
    L_0x0021:
        r0 = new java.io.File;
        r0.<init>(r5);
        r5 = r0.exists();
        if (r5 != 0) goto L_0x002d;
    L_0x002c:
        goto L_0x001f;
    L_0x002d:
        r5 = r1;
    L_0x002e:
        if (r5 == 0) goto L_0x009b;
    L_0x0030:
        r5 = "YAPATCH.MF";
        r5 = com.tencent.bugly.beta.tinker.TinkerUtils.readJarEntry(r0, r5);
        if (r5 != 0) goto L_0x0039;
    L_0x0038:
        return r2;
    L_0x0039:
        r0 = new java.io.ByteArrayInputStream;
        r0.<init>(r5);
        r5 = new java.util.Properties;	 Catch:{ Exception -> 0x0091 }
        r5.<init>();	 Catch:{ Exception -> 0x0091 }
        r5.load(r0);	 Catch:{ Exception -> 0x0091 }
        r0 = "From";	 Catch:{ Exception -> 0x0091 }
        r0 = r5.getProperty(r0);	 Catch:{ Exception -> 0x0091 }
        if (r0 == 0) goto L_0x0087;	 Catch:{ Exception -> 0x0091 }
    L_0x004e:
        r0 = "To";	 Catch:{ Exception -> 0x0091 }
        r0 = r5.getProperty(r0);	 Catch:{ Exception -> 0x0091 }
        if (r0 != 0) goto L_0x0057;	 Catch:{ Exception -> 0x0091 }
    L_0x0056:
        goto L_0x0087;	 Catch:{ Exception -> 0x0091 }
    L_0x0057:
        r0 = apkOriginalBuildNum;	 Catch:{ Exception -> 0x0091 }
        if (r0 != 0) goto L_0x0065;	 Catch:{ Exception -> 0x0091 }
    L_0x005b:
        r5 = "Tinker.TinkerManager";	 Catch:{ Exception -> 0x0091 }
        r0 = "patchCurBuildNum is null";	 Catch:{ Exception -> 0x0091 }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0091 }
        com.tencent.tinker.lib.util.TinkerLog.e(r5, r0, r1);	 Catch:{ Exception -> 0x0091 }
        return r2;	 Catch:{ Exception -> 0x0091 }
    L_0x0065:
        r0 = apkOriginalBuildNum;	 Catch:{ Exception -> 0x0091 }
        r3 = "From";	 Catch:{ Exception -> 0x0091 }
        r3 = r5.getProperty(r3);	 Catch:{ Exception -> 0x0091 }
        r0 = r0.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x0091 }
        if (r0 == 0) goto L_0x007d;	 Catch:{ Exception -> 0x0091 }
    L_0x0073:
        r0 = "To";	 Catch:{ Exception -> 0x0091 }
        r5 = r5.getProperty(r0);	 Catch:{ Exception -> 0x0091 }
        patchCurBuildNum = r5;	 Catch:{ Exception -> 0x0091 }
        r2 = r1;	 Catch:{ Exception -> 0x0091 }
        goto L_0x009c;	 Catch:{ Exception -> 0x0091 }
    L_0x007d:
        r5 = "Tinker.TinkerManager";	 Catch:{ Exception -> 0x0091 }
        r0 = "orign buildno invalid";	 Catch:{ Exception -> 0x0091 }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0091 }
        com.tencent.tinker.lib.util.TinkerLog.e(r5, r0, r1);	 Catch:{ Exception -> 0x0091 }
        goto L_0x009c;	 Catch:{ Exception -> 0x0091 }
    L_0x0087:
        r5 = "Tinker.TinkerManager";	 Catch:{ Exception -> 0x0091 }
        r0 = "From/To is null";	 Catch:{ Exception -> 0x0091 }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0091 }
        com.tencent.tinker.lib.util.TinkerLog.e(r5, r0, r1);	 Catch:{ Exception -> 0x0091 }
        return r2;
    L_0x0091:
        r5 = "Tinker.TinkerManager";
        r0 = "get properties failed";
        r1 = new java.lang.Object[r2];
        com.tencent.tinker.lib.util.TinkerLog.e(r5, r0, r1);
        goto L_0x009c;
    L_0x009b:
        r2 = r5;
    L_0x009c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.tinker.TinkerManager.checkNewPatch(java.lang.String):boolean");
    }

    public File getPatchDirectory(Context context) {
        return SharePatchFileUtil.getPatchDirectory(context);
    }

    public void onDownloadFailure(String str) {
        if (this.tinkerListener != null) {
            this.tinkerListener.onDownloadFailure(str);
        }
    }

    public void onApplySuccess(String str) {
        if (this.tinkerListener != null) {
            this.tinkerListener.onApplySuccess(str);
        }
    }

    public void onApplyFailure(String str) {
        if (this.tinkerListener != null) {
            this.tinkerListener.onApplyFailure(str);
        }
    }

    public void onPatchRollback(boolean z) {
        if (Tinker.with(getApplication()).isTinkerLoaded()) {
            if (z) {
                TinkerLog.i(TAG, "delete patch now", new Object[0]);
                TinkerUtils.rollbackPatch(getApplication());
            } else {
                TinkerLog.i(TAG, "tinker wait screen to restart process", new Object[0]);
                z = new ScreenState(getApplication(), new IOnScreenOff() {
                    public void onScreenOff() {
                        TinkerUtils.rollbackPatch(TinkerManager.getApplication());
                    }
                });
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (TinkerManager.this.tinkerListener != null) {
                        TinkerManager.this.tinkerListener.onPatchRollback();
                    }
                }
            });
            return;
        }
        TinkerLog.w("Tinker.PatchRequestCallback", "TinkerPatchRequestCallback: onPatchRollback, tinker is not loaded, just return", new Object[0]);
    }
}
