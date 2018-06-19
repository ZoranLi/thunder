package com.tencent.tinker.lib.tinker;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.HashMap;

/* compiled from: BUGLY */
public class TinkerLoadResult {
    private static final String TAG = "Tinker.TinkerLoadResult";
    public long costTime;
    public String currentVersion;
    public File dexDirectory;
    public HashMap<String, String> dexes;
    public File libraryDirectory;
    public HashMap<String, String> libs;
    public int loadCode;
    public String oatDir;
    public HashMap<String, String> packageConfig;
    public SharePatchInfo patchInfo;
    public File patchVersionDirectory;
    public File patchVersionFile;
    public File resourceDirectory;
    public File resourceFile;
    public boolean systemOTA;
    public boolean useInterpretMode;
    public boolean versionChanged;

    public boolean parseTinkerResult(Context context, Intent intent) {
        Intent intent2 = intent;
        Tinker with = Tinker.with(context);
        this.loadCode = ShareIntentUtil.getIntentReturnCode(intent);
        this.costTime = ShareIntentUtil.getIntentPatchCostTime(intent);
        this.systemOTA = ShareIntentUtil.getBooleanExtra(intent2, ShareIntentUtil.INTENT_PATCH_SYSTEM_OTA, false);
        this.oatDir = ShareIntentUtil.getStringExtra(intent2, ShareIntentUtil.INTENT_PATCH_OAT_DIR);
        this.useInterpretMode = ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH.equals(this.oatDir);
        boolean isMainProcess = with.isMainProcess();
        TinkerLog.i(TAG, "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", Integer.valueOf(this.loadCode), ShareTinkerInternals.getProcessName(context), Boolean.valueOf(isMainProcess), Boolean.valueOf(this.systemOTA), Build.FINGERPRINT, this.oatDir, Boolean.valueOf(this.useInterpretMode));
        String stringExtra = ShareIntentUtil.getStringExtra(intent2, ShareIntentUtil.INTENT_PATCH_OLD_VERSION);
        String stringExtra2 = ShareIntentUtil.getStringExtra(intent2, ShareIntentUtil.INTENT_PATCH_NEW_VERSION);
        File patchDirectory = with.getPatchDirectory();
        File patchInfoFile = with.getPatchInfoFile();
        if (!(stringExtra == null || stringExtra2 == null)) {
            if (isMainProcess) {
                r0.currentVersion = stringExtra2;
            } else {
                r0.currentVersion = stringExtra;
            }
            TinkerLog.i(TAG, "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", stringExtra, stringExtra2, r0.currentVersion);
            String patchVersionDirectory = SharePatchFileUtil.getPatchVersionDirectory(r0.currentVersion);
            if (!ShareTinkerInternals.isNullOrNil(patchVersionDirectory)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(patchDirectory.getAbsolutePath());
                stringBuilder.append("/");
                stringBuilder.append(patchVersionDirectory);
                r0.patchVersionDirectory = new File(stringBuilder.toString());
                r0.patchVersionFile = new File(r0.patchVersionDirectory.getAbsolutePath(), SharePatchFileUtil.getPatchVersionFile(r0.currentVersion));
                r0.dexDirectory = new File(r0.patchVersionDirectory, "dex");
                r0.libraryDirectory = new File(r0.patchVersionDirectory, ShareConstants.SO_PATH);
                r0.resourceDirectory = new File(r0.patchVersionDirectory, "res");
                r0.resourceFile = new File(r0.resourceDirectory, ShareConstants.RES_NAME);
            }
            r0.patchInfo = new SharePatchInfo(stringExtra, stringExtra2, Build.FINGERPRINT, r0.oatDir);
            r0.versionChanged = stringExtra.equals(stringExtra2) ^ true;
        }
        Throwable intentPatchException = ShareIntentUtil.getIntentPatchException(intent);
        if (intentPatchException != null) {
            TinkerLog.i(TAG, "Tinker load have exception loadCode:%d", Integer.valueOf(r0.loadCode));
            int i = r0.loadCode;
            int i2 = -1;
            if (i == -25) {
                i2 = -4;
            } else if (i == -23) {
                i2 = -3;
            } else if (i != -20) {
                if (i == -14) {
                    i2 = -2;
                }
            }
            with.getLoadReporter().onLoadException(intentPatchException, i2);
            return false;
        }
        int i3 = r0.loadCode;
        if (i3 != ShareConstants.ERROR_LOAD_GET_INTENT_FAIL) {
            if (i3 != -24) {
                switch (i3) {
                    case -22:
                        if (r0.patchVersionDirectory != null) {
                            TinkerLog.e(TAG, "patch resource file not found:%s", r0.resourceFile.getAbsolutePath());
                            with.getLoadReporter().onLoadFileNotFound(r0.resourceFile, 6, false);
                            break;
                        }
                        TinkerLog.e(TAG, "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
                    case -21:
                        if (r0.patchVersionDirectory != null) {
                            TinkerLog.e(TAG, "patch resource file directory not found:%s", r0.resourceDirectory.getAbsolutePath());
                            with.getLoadReporter().onLoadFileNotFound(r0.resourceDirectory, 6, true);
                            break;
                        }
                        TinkerLog.e(TAG, "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
                    default:
                        String stringExtra3;
                        switch (i3) {
                            case ShareConstants.ERROR_LOAD_PATCH_REWRITE_PATCH_INFO_FAIL /*-19*/:
                                TinkerLog.i(TAG, "rewrite patch info file corrupted", new Object[0]);
                                with.getLoadReporter().onLoadPatchInfoCorrupted(stringExtra, stringExtra2, patchInfoFile);
                                break;
                            case ShareConstants.ERROR_LOAD_PATCH_VERSION_LIB_FILE_NOT_EXIST /*-18*/:
                                stringExtra3 = ShareIntentUtil.getStringExtra(intent2, ShareIntentUtil.INTENT_PATCH_MISSING_LIB_PATH);
                                if (stringExtra3 != null) {
                                    TinkerLog.e(TAG, "patch lib file not found:%s", stringExtra3);
                                    with.getLoadReporter().onLoadFileNotFound(new File(stringExtra3), 5, false);
                                    break;
                                }
                                TinkerLog.e(TAG, "patch lib file not found, but path is null!!!!", new Object[0]);
                                throw new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                            case -17:
                                if (r0.patchVersionDirectory != null) {
                                    TinkerLog.e(TAG, "patch lib file directory not found:%s", r0.libraryDirectory.getAbsolutePath());
                                    with.getLoadReporter().onLoadFileNotFound(r0.libraryDirectory, 5, true);
                                    break;
                                }
                                TinkerLog.e(TAG, "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                                throw new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                            case -16:
                                with.getLoadReporter().onLoadInterpret(2, ShareIntentUtil.getIntentInterpretException(intent));
                                break;
                            case -15:
                                with.getLoadReporter().onLoadInterpret(1, ShareIntentUtil.getIntentInterpretException(intent));
                                break;
                            default:
                                switch (i3) {
                                    case -13:
                                        stringExtra3 = ShareIntentUtil.getStringExtra(intent2, ShareIntentUtil.INTENT_PATCH_MISMATCH_DEX_PATH);
                                        if (stringExtra3 != null) {
                                            TinkerLog.e(TAG, "patch dex file md5 is mismatch: %s", stringExtra3);
                                            with.getLoadReporter().onLoadFileMd5Mismatch(new File(stringExtra3), 3);
                                            break;
                                        }
                                        TinkerLog.e(TAG, "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                                    case -12:
                                        TinkerLog.e(TAG, "patch dex load fail, classloader is null", new Object[0]);
                                        break;
                                    case -11:
                                        stringExtra3 = ShareIntentUtil.getStringExtra(intent2, ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH);
                                        if (stringExtra3 != null) {
                                            TinkerLog.e(TAG, "patch dex opt file not found:%s", stringExtra3);
                                            with.getLoadReporter().onLoadFileNotFound(new File(stringExtra3), 4, false);
                                            break;
                                        }
                                        TinkerLog.e(TAG, "patch dex opt file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                                    case -10:
                                        stringExtra3 = ShareIntentUtil.getStringExtra(intent2, ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH);
                                        if (stringExtra3 != null) {
                                            TinkerLog.e(TAG, "patch dex file not found:%s", stringExtra3);
                                            with.getLoadReporter().onLoadFileNotFound(new File(stringExtra3), 3, false);
                                            break;
                                        }
                                        TinkerLog.e(TAG, "patch dex file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                                    case -9:
                                        if (r0.dexDirectory != null) {
                                            TinkerLog.e(TAG, "patch dex file directory not found:%s", r0.dexDirectory.getAbsolutePath());
                                            with.getLoadReporter().onLoadFileNotFound(r0.dexDirectory, 3, true);
                                            break;
                                        }
                                        TinkerLog.e(TAG, "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                                    case -8:
                                        TinkerLog.i(TAG, "patch package check fail", new Object[0]);
                                        if (r0.patchVersionFile != null) {
                                            with.getLoadReporter().onLoadPackageCheckFail(r0.patchVersionFile, intent2.getIntExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, ShareConstants.ERROR_LOAD_GET_INTENT_FAIL));
                                            break;
                                        }
                                        throw new TinkerRuntimeException("error patch package check fail , but file is null");
                                    case -7:
                                        TinkerLog.e(TAG, "patch version file not found, current version:%s", r0.currentVersion);
                                        if (r0.patchVersionFile != null) {
                                            with.getLoadReporter().onLoadFileNotFound(r0.patchVersionFile, 1, false);
                                            break;
                                        }
                                        throw new TinkerRuntimeException("error load patch version file not exist, but file is null");
                                    case -6:
                                        TinkerLog.e(TAG, "patch version directory not found, current version:%s", r0.currentVersion);
                                        with.getLoadReporter().onLoadFileNotFound(r0.patchVersionDirectory, 1, true);
                                        break;
                                    case -5:
                                        TinkerLog.e(TAG, "path info blank, wait main process to restart", new Object[0]);
                                        break;
                                    case -4:
                                        TinkerLog.e(TAG, "path info corrupted", new Object[0]);
                                        with.getLoadReporter().onLoadPatchInfoCorrupted(stringExtra, stringExtra2, patchInfoFile);
                                        break;
                                    case -3:
                                    case -2:
                                        TinkerLog.w(TAG, "can't find patch file, is ok, just return", new Object[0]);
                                        break;
                                    case -1:
                                        TinkerLog.w(TAG, "tinker is disable, just return", new Object[0]);
                                        break;
                                    case 0:
                                        TinkerLog.i(TAG, "oh yeah, tinker load all success", new Object[0]);
                                        with.setTinkerLoaded(true);
                                        r0.dexes = ShareIntentUtil.getIntentPatchDexPaths(intent);
                                        r0.libs = ShareIntentUtil.getIntentPatchLibsPaths(intent);
                                        r0.packageConfig = ShareIntentUtil.getIntentPackageConfig(intent);
                                        if (r0.useInterpretMode) {
                                            with.getLoadReporter().onLoadInterpret(0, null);
                                        }
                                        if (isMainProcess && r0.versionChanged) {
                                            with.getLoadReporter().onLoadPatchVersionChanged(stringExtra, stringExtra2, patchDirectory, r0.patchVersionDirectory.getName());
                                        }
                                        return true;
                                    default:
                                        break;
                                }
                        }
                }
            } else if (r0.resourceFile == null) {
                TinkerLog.e(TAG, "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                throw new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
            } else {
                TinkerLog.e(TAG, "patch resource file md5 is mismatch: %s", r0.resourceFile.getAbsolutePath());
                with.getLoadReporter().onLoadFileMd5Mismatch(r0.resourceFile, 6);
            }
            return false;
        }
        TinkerLog.e(TAG, "can't get the right intent return code", new Object[0]);
        throw new TinkerRuntimeException("can't get the right intent return code");
    }

    public String getPackageConfigByName(String str) {
        return this.packageConfig != null ? (String) this.packageConfig.get(str) : null;
    }
}
