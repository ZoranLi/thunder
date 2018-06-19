package com.tencent.tinker.loader.shareutil;

import android.content.Intent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: BUGLY */
public class ShareIntentUtil {
    public static final String INTENT_PATCH_COST_TIME = "intent_patch_cost_time";
    public static final String INTENT_PATCH_DEXES_PATH = "intent_patch_dexes_path";
    public static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
    public static final String INTENT_PATCH_INTERPRET_EXCEPTION = "intent_patch_interpret_exception";
    public static final String INTENT_PATCH_LIBS_PATH = "intent_patch_libs_path";
    public static final String INTENT_PATCH_MISMATCH_DEX_PATH = "intent_patch_mismatch_dex_path";
    public static final String INTENT_PATCH_MISMATCH_LIB_PATH = "intent_patch_mismatch_lib_path";
    public static final String INTENT_PATCH_MISSING_DEX_PATH = "intent_patch_missing_dex_path";
    public static final String INTENT_PATCH_MISSING_LIB_PATH = "intent_patch_missing_lib_path";
    public static final String INTENT_PATCH_NEW_VERSION = "intent_patch_new_version";
    public static final String INTENT_PATCH_OAT_DIR = "intent_patch_oat_dir";
    public static final String INTENT_PATCH_OLD_VERSION = "intent_patch_old_version";
    public static final String INTENT_PATCH_PACKAGE_CONFIG = "intent_patch_package_config";
    public static final String INTENT_PATCH_PACKAGE_PATCH_CHECK = "intent_patch_package_patch_check";
    public static final String INTENT_PATCH_SYSTEM_OTA = "intent_patch_system_ota";
    public static final String INTENT_RETURN_CODE = "intent_return_code";
    private static final String TAG = "ShareIntentUtil";

    public static void setIntentReturnCode(Intent intent, int i) {
        intent.putExtra(INTENT_RETURN_CODE, i);
    }

    public static int getIntentReturnCode(Intent intent) {
        return getIntExtra(intent, INTENT_RETURN_CODE, ShareConstants.ERROR_LOAD_GET_INTENT_FAIL);
    }

    public static void setIntentPatchCostTime(Intent intent, long j) {
        intent.putExtra(INTENT_PATCH_COST_TIME, j);
    }

    public static long getIntentPatchCostTime(Intent intent) {
        return intent.getLongExtra(INTENT_PATCH_COST_TIME, 0);
    }

    public static Throwable getIntentPatchException(Intent intent) {
        intent = getSerializableExtra(intent, INTENT_PATCH_EXCEPTION);
        return intent != null ? (Throwable) intent : null;
    }

    public static Throwable getIntentInterpretException(Intent intent) {
        intent = getSerializableExtra(intent, INTENT_PATCH_INTERPRET_EXCEPTION);
        return intent != null ? (Throwable) intent : null;
    }

    public static HashMap<String, String> getIntentPatchDexPaths(Intent intent) {
        intent = getSerializableExtra(intent, INTENT_PATCH_DEXES_PATH);
        return intent != null ? (HashMap) intent : null;
    }

    public static HashMap<String, String> getIntentPatchLibsPaths(Intent intent) {
        intent = getSerializableExtra(intent, INTENT_PATCH_LIBS_PATH);
        return intent != null ? (HashMap) intent : null;
    }

    public static HashMap<String, String> getIntentPackageConfig(Intent intent) {
        intent = getSerializableExtra(intent, INTENT_PATCH_PACKAGE_CONFIG);
        return intent != null ? (HashMap) intent : null;
    }

    public static ArrayList<String> getStringArrayListExtra(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            intent = intent.getStringArrayListExtra(str);
        } catch (Intent intent2) {
            new StringBuilder("getStringExtra exception:").append(intent2.getMessage());
            intent2 = null;
        }
        return intent2;
    }

    public static String getStringExtra(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            intent = intent.getStringExtra(str);
        } catch (Intent intent2) {
            new StringBuilder("getStringExtra exception:").append(intent2.getMessage());
            intent2 = null;
        }
        return intent2;
    }

    public static Serializable getSerializableExtra(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            intent = intent.getSerializableExtra(str);
        } catch (Intent intent2) {
            new StringBuilder("getSerializableExtra exception:").append(intent2.getMessage());
            intent2 = null;
        }
        return intent2;
    }

    public static int getIntExtra(Intent intent, String str, int i) {
        if (intent == null) {
            return i;
        }
        try {
            intent = intent.getIntExtra(str, i);
        } catch (Intent intent2) {
            new StringBuilder("getIntExtra exception:").append(intent2.getMessage());
            intent2 = i;
        }
        return intent2;
    }

    public static boolean getBooleanExtra(Intent intent, String str, boolean z) {
        if (intent == null) {
            return z;
        }
        try {
            intent = intent.getBooleanExtra(str, z);
        } catch (Intent intent2) {
            new StringBuilder("getBooleanExtra exception:").append(intent2.getMessage());
            intent2 = z;
        }
        return intent2;
    }

    public static long getLongExtra(Intent intent, String str, long j) {
        if (intent == null) {
            return j;
        }
        try {
            intent = intent.getLongExtra(str, j);
        } catch (Intent intent2) {
            new StringBuilder("getIntExtra exception:").append(intent2.getMessage());
            intent2 = j;
        }
        return intent2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void fixIntentClassLoader(android.content.Intent r2, java.lang.ClassLoader r3) {
        /*
        r0 = android.content.Intent.class;
        r1 = "mExtras";
        r0 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r0, r1);	 Catch:{ Throwable -> 0x001e }
        r1 = r0.get(r2);	 Catch:{ Throwable -> 0x001e }
        r1 = (android.os.Bundle) r1;	 Catch:{ Throwable -> 0x001e }
        if (r1 != 0) goto L_0x0018;
    L_0x0010:
        r1 = new android.os.Bundle;	 Catch:{ Throwable -> 0x001e }
        r1.<init>();	 Catch:{ Throwable -> 0x001e }
        r0.set(r2, r1);	 Catch:{ Throwable -> 0x001e }
    L_0x0018:
        r2.setExtrasClassLoader(r3);
        return;
    L_0x001c:
        r0 = move-exception;
        goto L_0x0026;
    L_0x001e:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x001c }
        r2.setExtrasClassLoader(r3);
        return;
    L_0x0026:
        r2.setExtrasClassLoader(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareIntentUtil.fixIntentClassLoader(android.content.Intent, java.lang.ClassLoader):void");
    }
}
