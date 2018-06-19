package com.tencent.tinker.lib.tinker;

import android.content.Intent;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.HashMap;

/* compiled from: BUGLY */
public class TinkerApplicationHelper {
    private static final String TAG = "Tinker.TinkerApplicationHelper";

    public static boolean isTinkerEnableAll(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                return ShareTinkerInternals.isTinkerEnabledAll(applicationLike.getTinkerFlags());
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static boolean isTinkerEnableForDex(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                return ShareTinkerInternals.isTinkerEnabledForDex(applicationLike.getTinkerFlags());
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static boolean isTinkerEnableForNativeLib(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                return ShareTinkerInternals.isTinkerEnabledForNativeLib(applicationLike.getTinkerFlags());
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static boolean isTinkerEnableForResource(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                return ShareTinkerInternals.isTinkerEnabledForResource(applicationLike.getTinkerFlags());
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static File getTinkerPatchDirectory(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                return SharePatchFileUtil.getPatchDirectory(applicationLike.getApplication());
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static boolean isTinkerLoadSuccess(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                applicationLike = applicationLike.getTinkerResultIntent();
                if (applicationLike != null && ShareIntentUtil.getIntentReturnCode(applicationLike) == null) {
                    return true;
                }
                return false;
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static HashMap<String, String> getLoadDexesAndMd5(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                applicationLike = applicationLike.getTinkerResultIntent();
                if (applicationLike != null && ShareIntentUtil.getIntentReturnCode(applicationLike) == 0) {
                    return ShareIntentUtil.getIntentPatchDexPaths(applicationLike);
                }
                return null;
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static HashMap<String, String> getLoadLibraryAndMd5(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                applicationLike = applicationLike.getTinkerResultIntent();
                if (applicationLike != null && ShareIntentUtil.getIntentReturnCode(applicationLike) == 0) {
                    return ShareIntentUtil.getIntentPatchLibsPaths(applicationLike);
                }
                return null;
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static HashMap<String, String> getPackageConfigs(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                applicationLike = applicationLike.getTinkerResultIntent();
                if (applicationLike != null && ShareIntentUtil.getIntentReturnCode(applicationLike) == 0) {
                    return ShareIntentUtil.getIntentPackageConfig(applicationLike);
                }
                return null;
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static String getCurrentVersion(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
                if (tinkerResultIntent == null) {
                    return null;
                }
                String stringExtra = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_OLD_VERSION);
                String stringExtra2 = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_NEW_VERSION);
                applicationLike = ShareTinkerInternals.isInMainProcess(applicationLike.getApplication());
                if (stringExtra == null || stringExtra2 == null) {
                    return null;
                }
                return applicationLike != null ? stringExtra2 : stringExtra;
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static void cleanPatch(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike.getApplication() != null) {
                if (isTinkerLoadSuccess(applicationLike)) {
                    TinkerLog.e(TAG, "it is not safety to clean patch when tinker is loaded, you should kill all your process after clean!", new Object[0]);
                }
                SharePatchFileUtil.deleteDir(SharePatchFileUtil.getPatchDirectory(applicationLike.getApplication()));
                return;
            }
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static void loadArmV7aLibrary(ApplicationLike applicationLike, String str) {
        if (!(str == null || str.isEmpty())) {
            if (applicationLike != null) {
                if (!isTinkerEnableForNativeLib(applicationLike) || loadLibraryFromTinker(applicationLike, "lib/armeabi-v7a", str) == null) {
                    System.loadLibrary(str);
                    return;
                }
                return;
            }
        }
        throw new TinkerRuntimeException("libName or context is null!");
    }

    public static void loadArmLibrary(ApplicationLike applicationLike, String str) {
        if (!(str == null || str.isEmpty())) {
            if (applicationLike != null) {
                if (!isTinkerEnableForNativeLib(applicationLike) || loadLibraryFromTinker(applicationLike, "lib/armeabi", str) == null) {
                    System.loadLibrary(str);
                    return;
                }
                return;
            }
        }
        throw new TinkerRuntimeException("libName or context is null!");
    }

    public static boolean loadLibraryFromTinker(ApplicationLike applicationLike, String str, String str2) throws UnsatisfiedLinkError {
        StringBuilder stringBuilder;
        if (!str2.startsWith(ShareConstants.SO_PATH)) {
            stringBuilder = new StringBuilder(ShareConstants.SO_PATH);
            stringBuilder.append(str2);
            str2 = stringBuilder.toString();
        }
        if (!str2.endsWith(".so")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(".so");
            str2 = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(str2);
        str = stringBuilder.toString();
        if (!(isTinkerEnableForNativeLib(applicationLike) == null || isTinkerLoadSuccess(applicationLike) == null)) {
            str2 = getLoadLibraryAndMd5(applicationLike);
            if (str2 != null) {
                String currentVersion = getCurrentVersion(applicationLike);
                if (ShareTinkerInternals.isNullOrNil(currentVersion)) {
                    return false;
                }
                File patchDirectory = SharePatchFileUtil.getPatchDirectory(applicationLike.getApplication());
                if (patchDirectory == null) {
                    return false;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(patchDirectory.getAbsolutePath());
                stringBuilder2.append("/");
                stringBuilder2.append(SharePatchFileUtil.getPatchVersionDirectory(currentVersion));
                File file = new File(stringBuilder2.toString());
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(file.getAbsolutePath());
                stringBuilder3.append("/lib");
                currentVersion = stringBuilder3.toString();
                for (String str3 : str2.keySet()) {
                    String str32;
                    if (str32.equals(str)) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(currentVersion);
                        stringBuilder2.append("/");
                        stringBuilder2.append(str32);
                        String stringBuilder4 = stringBuilder2.toString();
                        File file2 = new File(stringBuilder4);
                        if (!file2.exists()) {
                            continue;
                        } else if (!applicationLike.getTinkerLoadVerifyFlag() || SharePatchFileUtil.verifyFileMd5(file2, (String) str2.get(str32))) {
                            System.load(stringBuilder4);
                            applicationLike = TAG;
                            str = new StringBuilder("loadLibraryFromTinker success:");
                            str.append(stringBuilder4);
                            TinkerLog.i(applicationLike, str.toString(), new Object[0]);
                            return true;
                        } else {
                            str32 = TAG;
                            StringBuilder stringBuilder5 = new StringBuilder("loadLibraryFromTinker md5mismatch fail:");
                            stringBuilder5.append(stringBuilder4);
                            TinkerLog.i(str32, stringBuilder5.toString(), new Object[0]);
                        }
                    }
                }
            }
        }
        return false;
    }
}
