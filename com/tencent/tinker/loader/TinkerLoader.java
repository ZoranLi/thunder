package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* compiled from: BUGLY */
public class TinkerLoader extends AbstractTinkerLoader {
    private static final String TAG = "Tinker.TinkerLoader";
    private SharePatchInfo patchInfo;

    public Intent tryLoad(TinkerApplication tinkerApplication) {
        Intent intent = new Intent();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tryLoadPatchFilesInternal(tinkerApplication, intent);
        ShareIntentUtil.setIntentPatchCostTime(intent, SystemClock.elapsedRealtime() - elapsedRealtime);
        return intent;
    }

    private void tryLoadPatchFilesInternal(TinkerApplication tinkerApplication, Intent intent) {
        TinkerLoader tinkerLoader = this;
        Context context = tinkerApplication;
        Intent intent2 = intent;
        int tinkerFlags = tinkerApplication.getTinkerFlags();
        if (!ShareTinkerInternals.isTinkerEnabled(tinkerFlags)) {
            ShareIntentUtil.setIntentReturnCode(intent2, -1);
        } else if (ShareTinkerInternals.isInPatchProcess(tinkerApplication)) {
            ShareIntentUtil.setIntentReturnCode(intent2, -1);
        } else {
            File patchDirectory = SharePatchFileUtil.getPatchDirectory(tinkerApplication);
            if (patchDirectory == null) {
                ShareIntentUtil.setIntentReturnCode(intent2, -2);
                return;
            }
            String absolutePath = patchDirectory.getAbsolutePath();
            if (patchDirectory.exists()) {
                patchDirectory = SharePatchFileUtil.getPatchInfoFile(absolutePath);
                if (patchDirectory.exists()) {
                    File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(absolutePath);
                    tinkerLoader.patchInfo = SharePatchInfo.readAndCheckPropertyWithLock(patchDirectory, patchInfoLockFile);
                    if (tinkerLoader.patchInfo == null) {
                        ShareIntentUtil.setIntentReturnCode(intent2, -4);
                        return;
                    }
                    String str = tinkerLoader.patchInfo.oldVersion;
                    String str2 = tinkerLoader.patchInfo.newVersion;
                    String str3 = tinkerLoader.patchInfo.oatDir;
                    if (!(str == null || str2 == null)) {
                        if (str3 != null) {
                            intent2.putExtra(ShareIntentUtil.INTENT_PATCH_OLD_VERSION, str);
                            intent2.putExtra(ShareIntentUtil.INTENT_PATCH_NEW_VERSION, str2);
                            boolean isInMainProcess = ShareTinkerInternals.isInMainProcess(tinkerApplication);
                            int equals = str.equals(str2) ^ 1;
                            int i = (str3.equals(ShareConstants.CHANING_DEX_OPTIMIZE_PATH) && isInMainProcess) ? 1 : 0;
                            str3 = ShareTinkerInternals.getCurrentOatMode(context, str3);
                            intent2.putExtra(ShareIntentUtil.INTENT_PATCH_OAT_DIR, str3);
                            if (equals != 0 && isInMainProcess) {
                                str = str2;
                            }
                            if (ShareTinkerInternals.isNullOrNil(str)) {
                                ShareIntentUtil.setIntentReturnCode(intent2, -5);
                                return;
                            }
                            str2 = SharePatchFileUtil.getPatchVersionDirectory(str);
                            if (str2 == null) {
                                ShareIntentUtil.setIntentReturnCode(intent2, -6);
                                return;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(absolutePath);
                            stringBuilder.append("/");
                            stringBuilder.append(str2);
                            absolutePath = stringBuilder.toString();
                            File file = new File(absolutePath);
                            if (file.exists()) {
                                File file2 = new File(file.getAbsolutePath(), SharePatchFileUtil.getPatchVersionFile(str));
                                if (SharePatchFileUtil.isLegalFile(file2)) {
                                    ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
                                    int checkTinkerPackage = ShareTinkerInternals.checkTinkerPackage(context, tinkerFlags, file2, shareSecurityCheck);
                                    if (checkTinkerPackage != 0) {
                                        intent2.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, checkTinkerPackage);
                                        ShareIntentUtil.setIntentReturnCode(intent2, -8);
                                        return;
                                    }
                                    intent2.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_CONFIG, shareSecurityCheck.getPackagePropertiesIfPresent());
                                    boolean isTinkerEnabledForDex = ShareTinkerInternals.isTinkerEnabledForDex(tinkerFlags);
                                    if (isTinkerEnabledForDex && !TinkerDexLoader.checkComplete(absolutePath, shareSecurityCheck, str3, intent2)) {
                                        return;
                                    }
                                    if (!ShareTinkerInternals.isTinkerEnabledForNativeLib(tinkerFlags) || TinkerSoLoader.checkComplete(absolutePath, shareSecurityCheck, intent2)) {
                                        boolean isTinkerEnabledForResource = ShareTinkerInternals.isTinkerEnabledForResource(tinkerFlags);
                                        if (!isTinkerEnabledForResource || TinkerResourceLoader.checkComplete(context, absolutePath, shareSecurityCheck, intent2)) {
                                            boolean z = ShareTinkerInternals.isVmArt() && ShareTinkerInternals.isSystemOTA(tinkerLoader.patchInfo.fingerPrint) && VERSION.SDK_INT >= 21 && !ShareTinkerInternals.isAfterAndroidO();
                                            intent2.putExtra(ShareIntentUtil.INTENT_PATCH_SYSTEM_OTA, z);
                                            if ((isInMainProcess && equals != 0) || i != 0) {
                                                tinkerLoader.patchInfo.oldVersion = str;
                                                tinkerLoader.patchInfo.oatDir = str3;
                                                if (!SharePatchInfo.rewritePatchInfoFileWithLock(patchDirectory, tinkerLoader.patchInfo, patchInfoLockFile)) {
                                                    ShareIntentUtil.setIntentReturnCode(intent2, -19);
                                                    return;
                                                } else if (i != 0) {
                                                    StringBuilder stringBuilder2 = new StringBuilder();
                                                    stringBuilder2.append(absolutePath);
                                                    stringBuilder2.append("/interpet");
                                                    SharePatchFileUtil.deleteDir(stringBuilder2.toString());
                                                }
                                            }
                                            if (checkSafeModeCount(tinkerApplication)) {
                                                if (isTinkerEnabledForDex) {
                                                    boolean loadTinkerJars = TinkerDexLoader.loadTinkerJars(context, absolutePath, str3, intent2, z);
                                                    if (z) {
                                                        tinkerLoader.patchInfo.fingerPrint = Build.FINGERPRINT;
                                                        tinkerLoader.patchInfo.oatDir = loadTinkerJars ? ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH : "odex";
                                                        if (SharePatchInfo.rewritePatchInfoFileWithLock(patchDirectory, tinkerLoader.patchInfo, patchInfoLockFile)) {
                                                            intent2.putExtra(ShareIntentUtil.INTENT_PATCH_OAT_DIR, tinkerLoader.patchInfo.oatDir);
                                                            i = 0;
                                                        } else {
                                                            ShareIntentUtil.setIntentReturnCode(intent2, -19);
                                                            return;
                                                        }
                                                    }
                                                    if (!loadTinkerJars) {
                                                        return;
                                                    }
                                                }
                                                if (!isTinkerEnabledForResource || TinkerResourceLoader.loadTinkerResources(context, absolutePath, intent2)) {
                                                    if (isTinkerEnabledForDex && isTinkerEnabledForResource) {
                                                        ComponentHotplug.install(context, shareSecurityCheck);
                                                    }
                                                    if (i != 0) {
                                                        ShareTinkerInternals.killAllOtherProcess(tinkerApplication);
                                                    }
                                                    ShareIntentUtil.setIntentReturnCode(intent2, 0);
                                                    return;
                                                }
                                                return;
                                            }
                                            intent2.putExtra(ShareIntentUtil.INTENT_PATCH_EXCEPTION, new TinkerRuntimeException("checkSafeModeCount fail"));
                                            ShareIntentUtil.setIntentReturnCode(intent2, -25);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ShareIntentUtil.setIntentReturnCode(intent2, -7);
                                return;
                            }
                            ShareIntentUtil.setIntentReturnCode(intent2, -6);
                            return;
                        }
                    }
                    ShareIntentUtil.setIntentReturnCode(intent2, -4);
                    return;
                }
                new StringBuilder("tryLoadPatchFiles:patch info not exist:").append(patchDirectory.getAbsolutePath());
                ShareIntentUtil.setIntentReturnCode(intent2, -3);
                return;
            }
            ShareIntentUtil.setIntentReturnCode(intent2, -2);
        }
    }

    private boolean checkSafeModeCount(TinkerApplication tinkerApplication) {
        String processName = ShareTinkerInternals.getProcessName(tinkerApplication);
        StringBuilder stringBuilder = new StringBuilder(ShareConstants.TINKER_OWN_PREFERENCE_CONFIG);
        stringBuilder.append(processName);
        processName = stringBuilder.toString();
        SharedPreferences sharedPreferences = tinkerApplication.getSharedPreferences(processName, 0);
        int i = sharedPreferences.getInt(ShareConstants.TINKER_SAFE_MODE_COUNT, 0) + 1;
        StringBuilder stringBuilder2 = new StringBuilder("tinker safe mode preferName:");
        stringBuilder2.append(processName);
        stringBuilder2.append(" count:");
        stringBuilder2.append(i);
        if (i >= 3) {
            sharedPreferences.edit().putInt(ShareConstants.TINKER_SAFE_MODE_COUNT, 0).commit();
            return false;
        }
        tinkerApplication.setUseSafeMode(true);
        sharedPreferences.edit().putInt(ShareConstants.TINKER_SAFE_MODE_COUNT, i).commit();
        return true;
    }
}
