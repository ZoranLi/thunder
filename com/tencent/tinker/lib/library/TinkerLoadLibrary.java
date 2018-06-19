package com.tencent.tinker.lib.library;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerLoadResult;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

/* compiled from: BUGLY */
public class TinkerLoadLibrary {
    private static final String TAG = "Tinker.LoadLibrary";

    public static void loadArmLibrary(Context context, String str) {
        if (!(str == null || str.isEmpty())) {
            if (context != null) {
                if (!Tinker.with(context).isEnabledForNativeLib() || loadLibraryFromTinker(context, "lib/armeabi", str) == null) {
                    System.loadLibrary(str);
                    return;
                }
                return;
            }
        }
        throw new TinkerRuntimeException("libName or context is null!");
    }

    public static void loadArmV7Library(Context context, String str) {
        if (!(str == null || str.isEmpty())) {
            if (context != null) {
                if (!Tinker.with(context).isEnabledForNativeLib() || loadLibraryFromTinker(context, "lib/armeabi-v7a", str) == null) {
                    System.loadLibrary(str);
                    return;
                }
                return;
            }
        }
        throw new TinkerRuntimeException("libName or context is null!");
    }

    public static boolean loadLibraryFromTinker(Context context, String str, String str2) throws UnsatisfiedLinkError {
        StringBuilder stringBuilder;
        context = Tinker.with(context);
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
        if (!(context.isEnabledForNativeLib() == null || context.isTinkerLoaded() == null)) {
            str2 = context.getTinkerLoadResultIfPresent();
            if (str2.libs != null) {
                for (String str3 : str2.libs.keySet()) {
                    if (str3.equals(str)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str2.libraryDirectory);
                        stringBuilder2.append("/");
                        stringBuilder2.append(str3);
                        String stringBuilder3 = stringBuilder2.toString();
                        File file = new File(stringBuilder3);
                        if (!file.exists()) {
                            continue;
                        } else if (!context.isTinkerLoadVerify() || SharePatchFileUtil.verifyFileMd5(file, (String) str2.libs.get(str3))) {
                            System.load(stringBuilder3);
                            context = TAG;
                            str = new StringBuilder("loadLibraryFromTinker success:");
                            str.append(stringBuilder3);
                            TinkerLog.i(context, str.toString(), new Object[0]);
                            return true;
                        } else {
                            context.getLoadReporter().onLoadFileMd5Mismatch(file, 5);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void installNavitveLibraryABI(Context context, String str) {
        Tinker with = Tinker.with(context);
        if (with.isTinkerLoaded()) {
            TinkerLoadResult tinkerLoadResultIfPresent = with.getTinkerLoadResultIfPresent();
            if (tinkerLoadResultIfPresent.libs == null) {
                TinkerLog.i(TAG, "tinker libs is null, just return", new Object[0]);
                return;
            }
            File file = tinkerLoadResultIfPresent.libraryDirectory;
            StringBuilder stringBuilder = new StringBuilder("lib/");
            stringBuilder.append(str);
            File file2 = new File(file, stringBuilder.toString());
            if (file2.exists() == null) {
                TinkerLog.e(TAG, "current libraryABI folder is not exist, path: %s", file2.getPath());
                return;
            }
            context = context.getClassLoader();
            if (context == null) {
                TinkerLog.e(TAG, "classloader is null", new Object[0]);
                return;
            }
            str = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("before hack classloader:");
            stringBuilder2.append(context.toString());
            TinkerLog.i(str, stringBuilder2.toString(), new Object[0]);
            try {
                installNativeLibraryPath(context, file2);
            } catch (String str2) {
                String str3 = TAG;
                StringBuilder stringBuilder3 = new StringBuilder("installNativeLibraryPath fail:");
                stringBuilder3.append(str2);
                TinkerLog.e(str3, stringBuilder3.toString(), new Object[0]);
            }
            str2 = TAG;
            stringBuilder2 = new StringBuilder("after hack classloader:");
            stringBuilder2.append(context.toString());
            TinkerLog.i(str2, stringBuilder2.toString(), new Object[0]);
            return;
        }
        TinkerLog.i(TAG, "tinker is not loaded, just return", new Object[0]);
    }

    private static void installNativeLibraryPath(ClassLoader classLoader, File file) throws Throwable {
        if (file != null) {
            if (file.exists()) {
                if ((VERSION.SDK_INT == 25 && VERSION.PREVIEW_SDK_INT != 0) || VERSION.SDK_INT > 25) {
                    try {
                        V25.access$000(classLoader, file);
                        return;
                    } catch (Throwable th) {
                        TinkerLog.e(TAG, "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(VERSION.SDK_INT), th.getMessage());
                        V23.access$100(classLoader, file);
                        return;
                    }
                } else if (VERSION.SDK_INT >= 23) {
                    try {
                        V23.access$100(classLoader, file);
                        return;
                    } catch (Throwable th2) {
                        TinkerLog.e(TAG, "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", Integer.valueOf(VERSION.SDK_INT), th2.getMessage());
                        V14.access$200(classLoader, file);
                        return;
                    }
                } else if (VERSION.SDK_INT >= 14) {
                    V14.access$200(classLoader, file);
                    return;
                } else {
                    V4.access$300(classLoader, file);
                    return;
                }
            }
        }
        TinkerLog.e(TAG, "installNativeLibraryPath, folder %s is illegal", file);
    }
}
