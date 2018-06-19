package com.tencent.tinker.lib.reporter;

import android.content.Context;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.tinker.TinkerLoadResult;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* compiled from: BUGLY */
public class DefaultLoadReporter implements LoadReporter {
    private static final String TAG = "Tinker.DefaultLoadReporter";
    protected final Context context;

    public DefaultLoadReporter(Context context) {
        this.context = context;
    }

    public void onLoadPatchListenerReceiveFail(File file, int i) {
        TinkerLog.i(TAG, "patch loadReporter onLoadPatchListenerReceiveFail: patch receive fail: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i));
    }

    public void onLoadPatchVersionChanged(String str, String str2, File file, String str3) {
        String str4 = TAG;
        StringBuilder stringBuilder = new StringBuilder("patch loadReporter onLoadPatchVersionChanged: patch version change from ");
        stringBuilder.append(str);
        stringBuilder.append(" to ");
        stringBuilder.append(str2);
        int i = 0;
        TinkerLog.i(str4, stringBuilder.toString(), new Object[0]);
        if (str != null) {
            if (str2 != null) {
                if (str.equals(str2) == null && Tinker.with(this.context).isMainProcess() != null) {
                    TinkerLog.i(TAG, "onLoadPatchVersionChanged, try kill all other process", new Object[0]);
                    ShareTinkerInternals.killAllOtherProcess(this.context);
                    UpgradePatchRetry.getInstance(this.context).onPatchResetMaxCheck(str2);
                    str = file.listFiles();
                    if (str != null) {
                        str2 = str.length;
                        while (i < str2) {
                            file = str[i];
                            str4 = file.getName();
                            if (file.isDirectory() && !str4.equals(str3)) {
                                SharePatchFileUtil.deleteDir(file);
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }

    public void onLoadInterpret(int i, Throwable th) {
        TinkerLog.i(TAG, "patch loadReporter onLoadInterpret: type: %d, throwable: %s", Integer.valueOf(i), th);
        switch (i) {
            case 0:
                TinkerLog.i(TAG, "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                TinkerLog.e(TAG, "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                TinkerLog.e(TAG, "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
            default:
                break;
        }
        retryPatch();
    }

    public void onLoadFileNotFound(File file, int i, boolean z) {
        TinkerLog.i(TAG, "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType: %d, isDirectory: %b", file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z));
        if (i == 4) {
            retryPatch();
        } else {
            checkAndCleanPatch();
        }
    }

    public void onLoadFileMd5Mismatch(File file, int i) {
        TinkerLog.i(TAG, "patch load Reporter onLoadFileMd5Mismatch: patch file md5 mismatch file: %s, fileType: %d", file.getAbsolutePath(), Integer.valueOf(i));
        checkAndCleanPatch();
    }

    public void onLoadPatchInfoCorrupted(String str, String str2, File file) {
        TinkerLog.i(TAG, "patch loadReporter onLoadPatchInfoCorrupted: patch info file damage: %s, from version: %s to version: %s", file.getAbsolutePath(), str, str2);
        checkAndCleanPatch();
    }

    public void onLoadResult(File file, int i, long j) {
        TinkerLog.i(TAG, "patch loadReporter onLoadResult: patch load result, path:%s, code: %d, cost: %dms", file.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(j));
    }

    public void onLoadException(Throwable th, int i) {
        StringBuilder stringBuilder;
        switch (i) {
            case -4:
                TinkerLog.i(TAG, "patch loadReporter onLoadException: patch load unCatch exception: %s", th);
                ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
                TinkerLog.i(TAG, "unCaught exception disable tinker forever with sp", new Object[0]);
                i = SharePatchFileUtil.checkTinkerLastUncaughtCrash(this.context);
                if (!ShareTinkerInternals.isNullOrNil(i)) {
                    SharePatchFileUtil.safeDeleteFile(SharePatchFileUtil.getPatchLastCrashFile(this.context));
                    String str = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder("tinker uncaught real exception:");
                    stringBuilder2.append(i);
                    TinkerLog.e(str, stringBuilder2.toString(), new Object[0]);
                    break;
                }
                break;
            case -3:
                if (th.getMessage().contains(ShareConstants.CHECK_RES_INSTALL_FAIL) != 0) {
                    i = TAG;
                    stringBuilder = new StringBuilder("patch loadReporter onLoadException: tinker res check fail:");
                    stringBuilder.append(th.getMessage());
                    TinkerLog.e(i, stringBuilder.toString(), new Object[0]);
                } else {
                    TinkerLog.i(TAG, "patch loadReporter onLoadException: patch load resource exception: %s", th);
                }
                ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
                TinkerLog.i(TAG, "res exception disable tinker forever with sp", new Object[0]);
                break;
            case -2:
                if (th.getMessage().contains(ShareConstants.CHECK_DEX_INSTALL_FAIL) != 0) {
                    i = TAG;
                    stringBuilder = new StringBuilder("patch loadReporter onLoadException: tinker dex check fail:");
                    stringBuilder.append(th.getMessage());
                    TinkerLog.e(i, stringBuilder.toString(), new Object[0]);
                } else {
                    TinkerLog.i(TAG, "patch loadReporter onLoadException: patch load dex exception: %s", th);
                }
                ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
                TinkerLog.i(TAG, "dex exception disable tinker forever with sp", new Object[0]);
                break;
            case -1:
                TinkerLog.i(TAG, "patch loadReporter onLoadException: patch load unknown exception: %s", th);
                break;
            default:
                break;
        }
        TinkerLog.e(TAG, "tinker load exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        TinkerLog.printErrStackTrace(TAG, th, "tinker load exception", new Object[0]);
        Tinker.with(this.context).setTinkerDisable();
        checkAndCleanPatch();
    }

    public void onLoadPackageCheckFail(File file, int i) {
        TinkerLog.i(TAG, "patch loadReporter onLoadPackageCheckFail: load patch package check fail file path: %s, errorCode: %d", file.getAbsolutePath(), Integer.valueOf(i));
        checkAndCleanPatch();
    }

    public void checkAndCleanPatch() {
        Tinker with = Tinker.with(this.context);
        if (with.isMainProcess()) {
            TinkerLoadResult tinkerLoadResultIfPresent = with.getTinkerLoadResultIfPresent();
            if (tinkerLoadResultIfPresent.versionChanged) {
                SharePatchInfo sharePatchInfo = tinkerLoadResultIfPresent.patchInfo;
                if (!(sharePatchInfo == null || ShareTinkerInternals.isNullOrNil(sharePatchInfo.oldVersion))) {
                    TinkerLog.w(TAG, "checkAndCleanPatch, oldVersion %s is not null, try kill all other process", sharePatchInfo.oldVersion);
                    ShareTinkerInternals.killAllOtherProcess(this.context);
                }
            }
        }
        with.cleanPatch();
    }

    public boolean retryPatch() {
        Tinker with = Tinker.with(this.context);
        if (!with.isMainProcess()) {
            return false;
        }
        File file = with.getTinkerLoadResultIfPresent().patchVersionFile;
        if (file == null || !UpgradePatchRetry.getInstance(this.context).onPatchListenerCheck(SharePatchFileUtil.getMD5(file))) {
            return false;
        }
        TinkerLog.i(TAG, "try to repair oat file on patch process", new Object[0]);
        TinkerInstaller.onReceiveUpgradePatch(this.context, file.getAbsolutePath());
        return true;
    }
}
