package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.zip.ZipFile;

/* compiled from: BUGLY */
public class ShareTinkerInternals {
    private static final String PATCH_PROCESS_NAME = ":patch";
    private static final String TAG = "Tinker.TinkerInternals";
    private static final boolean VM_IS_ART = isVmArt(System.getProperty("java.vm.version"));
    private static final boolean VM_IS_JIT = isVmJitInternal();
    private static String currentInstructionSet;
    private static Boolean isPatchProcess;
    private static String processName;
    private static String tinkerID;

    private static String getTinkerSharedPreferencesName() {
        return "tinker_enable_1.9.1";
    }

    public static String getTypeString(int i) {
        switch (i) {
            case 1:
                return "patch_file";
            case 2:
                return "patch_info";
            case 3:
                return "dex";
            case 4:
                return "dex_opt";
            case 5:
                return ShareConstants.SO_PATH;
            case 6:
                return "resource";
            default:
                return "unknown";
        }
    }

    public static boolean isTinkerEnabled(int i) {
        return i != 0;
    }

    public static boolean isTinkerEnabledAll(int i) {
        return i == 7;
    }

    public static boolean isTinkerEnabledForDex(int i) {
        return (i & 1) != 0;
    }

    public static boolean isTinkerEnabledForNativeLib(int i) {
        return (i & 2) != 0;
    }

    public static boolean isTinkerEnabledForResource(int i) {
        return (i & 4) != 0;
    }

    public static boolean isVmArt() {
        if (!VM_IS_ART) {
            if (VERSION.SDK_INT < 21) {
                return false;
            }
        }
        return true;
    }

    public static boolean isVmJit() {
        return VM_IS_JIT && VERSION.SDK_INT < 24;
    }

    public static boolean isAfterAndroidO() {
        return VERSION.SDK_INT > 25;
    }

    public static String getCurrentInstructionSet() throws Exception {
        if (currentInstructionSet != null) {
            return currentInstructionSet;
        }
        currentInstructionSet = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
        new StringBuilder("getCurrentInstructionSet:").append(currentInstructionSet);
        return currentInstructionSet;
    }

    public static boolean isSystemOTA(String str) {
        String str2 = Build.FINGERPRINT;
        if (!(str == null || str.equals("") || str2 == null)) {
            if (!str2.equals("")) {
                if (str.equals(str2)) {
                    return false;
                }
                StringBuilder stringBuilder = new StringBuilder("system OTA,fingerprint not equal:");
                stringBuilder.append(str);
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append(str2);
                return true;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("fingerprint empty:");
        stringBuilder2.append(str);
        stringBuilder2.append(",current:");
        stringBuilder2.append(str2);
        return false;
    }

    public static ShareDexDiffPatchInfo changeTestDexToClassN(ShareDexDiffPatchInfo shareDexDiffPatchInfo, int i) {
        if (!shareDexDiffPatchInfo.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
            return null;
        }
        if (i != 1) {
            StringBuilder stringBuilder = new StringBuilder("classes");
            stringBuilder.append(i);
            stringBuilder.append(ShareConstants.DEX_SUFFIX);
            i = stringBuilder.toString();
        } else {
            i = "classes.dex";
        }
        return new ShareDexDiffPatchInfo(i, shareDexDiffPatchInfo.path, shareDexDiffPatchInfo.destMd5InDvm, shareDexDiffPatchInfo.destMd5InArt, shareDexDiffPatchInfo.dexDiffMd5, shareDexDiffPatchInfo.oldDexCrC, shareDexDiffPatchInfo.newDexCrC, shareDexDiffPatchInfo.dexMode);
    }

    public static boolean isNullOrNil(String str) {
        if (str != null) {
            if (str.length() > null) {
                return null;
            }
        }
        return true;
    }

    public static int checkTinkerPackage(Context context, int i, File file, ShareSecurityCheck shareSecurityCheck) {
        context = checkSignatureAndTinkerID(context, file, shareSecurityCheck);
        return context == null ? checkPackageAndTinkerFlag(shareSecurityCheck, i) : context;
    }

    public static int checkSignatureAndTinkerID(Context context, File file, ShareSecurityCheck shareSecurityCheck) {
        if (shareSecurityCheck.verifyPatchMetaSignature(file) == null) {
            return -1;
        }
        context = getManifestTinkerID(context);
        if (context == null) {
            return -5;
        }
        file = shareSecurityCheck.getPackagePropertiesIfPresent();
        if (file == null) {
            return -2;
        }
        String str = (String) file.get(ShareConstants.TINKER_ID);
        if (str == null) {
            return -6;
        }
        if (context.equals(str) != null) {
            return null;
        }
        shareSecurityCheck = new StringBuilder("tinkerId is not equal, base is ");
        shareSecurityCheck.append(context);
        shareSecurityCheck.append(", but patch is ");
        shareSecurityCheck.append(str);
        return -7;
    }

    public static int checkPackageAndTinkerFlag(ShareSecurityCheck shareSecurityCheck, int i) {
        if (isTinkerEnabledAll(i)) {
            return 0;
        }
        shareSecurityCheck = shareSecurityCheck.getMetaContentMap();
        if (!isTinkerEnabledForDex(i) && shareSecurityCheck.containsKey(ShareConstants.DEX_META_FILE)) {
            return -9;
        }
        if (!isTinkerEnabledForNativeLib(i) && shareSecurityCheck.containsKey(ShareConstants.SO_META_FILE)) {
            return -9;
        }
        if (isTinkerEnabledForResource(i) != 0 || shareSecurityCheck.containsKey(ShareConstants.RES_META_FILE) == null) {
            return 0;
        }
        return -9;
    }

    public static Properties fastGetPatchPackageMeta(File file) {
        Throwable th;
        if (file != null && file.isFile()) {
            if (file.length() != 0) {
                ZipFile zipFile;
                try {
                    zipFile = new ZipFile(file);
                    try {
                        file = zipFile.getEntry(ShareConstants.PACKAGE_META_FILE);
                        if (file == null) {
                            SharePatchFileUtil.closeZip(zipFile);
                            return null;
                        }
                        try {
                            file = zipFile.getInputStream(file);
                            try {
                                Properties properties = new Properties();
                                properties.load(file);
                                SharePatchFileUtil.closeQuietly(file);
                                SharePatchFileUtil.closeZip(zipFile);
                                return properties;
                            } catch (Throwable th2) {
                                th = th2;
                                SharePatchFileUtil.closeQuietly(file);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            file = null;
                            SharePatchFileUtil.closeQuietly(file);
                            throw th;
                        }
                    } catch (IOException e) {
                        file = e;
                        try {
                            new StringBuilder("fastGetPatchPackageMeta exception:").append(file.getMessage());
                            SharePatchFileUtil.closeZip(zipFile);
                            return null;
                        } catch (Throwable th4) {
                            file = th4;
                            SharePatchFileUtil.closeZip(zipFile);
                            throw file;
                        }
                    }
                } catch (IOException e2) {
                    file = e2;
                    zipFile = null;
                    new StringBuilder("fastGetPatchPackageMeta exception:").append(file.getMessage());
                    SharePatchFileUtil.closeZip(zipFile);
                    return null;
                } catch (Throwable th5) {
                    file = th5;
                    zipFile = null;
                    SharePatchFileUtil.closeZip(zipFile);
                    throw file;
                }
            }
        }
        return null;
    }

    public static String getManifestTinkerID(Context context) {
        if (tinkerID != null) {
            return tinkerID;
        }
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(ShareConstants.TINKER_ID);
            if (context != null) {
                tinkerID = String.valueOf(context);
            } else {
                tinkerID = null;
            }
            return tinkerID;
        } catch (Context context2) {
            new StringBuilder("getManifestTinkerID exception:").append(context2.getMessage());
            return null;
        }
    }

    public static void setTinkerDisableWithSharedPreferences(Context context) {
        context.getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, 4).edit().putBoolean(getTinkerSharedPreferencesName(), false).commit();
    }

    public static boolean isTinkerEnableWithSharedPreferences(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, 4).getBoolean(getTinkerSharedPreferencesName(), true);
    }

    public static boolean isInMainProcess(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String str = applicationInfo != null ? applicationInfo.processName : null;
        if (isNullOrNil(str)) {
            str = context.getPackageName();
        }
        context = getProcessName(context);
        if (context == null || context.length() == 0) {
            context = "";
        }
        return str.equals(context);
    }

    public static boolean isInPatchProcess(Context context) {
        if (isPatchProcess != null) {
            return isPatchProcess.booleanValue();
        }
        context = Boolean.valueOf(getProcessName(context).endsWith(PATCH_PROCESS_NAME));
        isPatchProcess = context;
        return context.booleanValue();
    }

    public static String getCurrentOatMode(Context context, String str) {
        if (str.equals(ShareConstants.CHANING_DEX_OPTIMIZE_PATH)) {
            return isInMainProcess(context) != null ? "odex" : ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH;
        } else {
            return str;
        }
    }

    public static void killAllOtherProcess(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            Context<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    public static String getProcessName(Context context) {
        if (processName != null) {
            return processName;
        }
        context = getProcessNameInternal(context);
        processName = context;
        return context;
    }

    private static java.lang.String getProcessNameInternal(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Process.myPid();
        if (r6 == 0) goto L_0x00aa;
    L_0x0006:
        if (r0 > 0) goto L_0x000a;
    L_0x0008:
        goto L_0x00aa;
    L_0x000a:
        r1 = "activity";
        r6 = r6.getSystemService(r1);
        r6 = (android.app.ActivityManager) r6;
        r1 = 0;
        if (r6 == 0) goto L_0x0045;
    L_0x0015:
        r6 = r6.getRunningAppProcesses();
        if (r6 == 0) goto L_0x0045;
    L_0x001b:
        r6 = r6.iterator();	 Catch:{ Exception -> 0x0030 }
    L_0x001f:
        r2 = r6.hasNext();	 Catch:{ Exception -> 0x0030 }
        if (r2 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x0030 }
    L_0x0025:
        r2 = r6.next();	 Catch:{ Exception -> 0x0030 }
        r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2;	 Catch:{ Exception -> 0x0030 }
        r3 = r2.pid;	 Catch:{ Exception -> 0x0030 }
        if (r3 != r0) goto L_0x001f;
    L_0x002f:
        goto L_0x0040;
    L_0x0030:
        r6 = move-exception;
        r2 = new java.lang.StringBuilder;
        r3 = "getProcessNameInternal exception:";
        r2.<init>(r3);
        r6 = r6.getMessage();
        r2.append(r6);
    L_0x003f:
        r2 = r1;
    L_0x0040:
        if (r2 == 0) goto L_0x0045;
    L_0x0042:
        r6 = r2.processName;
        return r6;
    L_0x0045:
        r6 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r2 = new byte[r6];
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x008d }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008d }
        r5 = "/proc/";	 Catch:{ Exception -> 0x008d }
        r4.<init>(r5);	 Catch:{ Exception -> 0x008d }
        r4.append(r0);	 Catch:{ Exception -> 0x008d }
        r0 = "/cmdline";	 Catch:{ Exception -> 0x008d }
        r4.append(r0);	 Catch:{ Exception -> 0x008d }
        r0 = r4.toString();	 Catch:{ Exception -> 0x008d }
        r3.<init>(r0);	 Catch:{ Exception -> 0x008d }
        r0 = r3.read(r2);	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
        if (r0 <= 0) goto L_0x0081;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
    L_0x0067:
        r1 = 0;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
        r4 = r1;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
    L_0x0069:
        if (r4 >= r0) goto L_0x0078;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
    L_0x006b:
        r5 = r2[r4];	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
        if (r5 > r6) goto L_0x0077;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
    L_0x006f:
        r5 = r2[r4];	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
        if (r5 > 0) goto L_0x0074;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
    L_0x0073:
        goto L_0x0077;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
    L_0x0074:
        r4 = r4 + 1;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
        goto L_0x0069;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
    L_0x0077:
        r0 = r4;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
    L_0x0078:
        r6 = new java.lang.String;	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
        r6.<init>(r2, r1, r0);	 Catch:{ Exception -> 0x0088, all -> 0x0085 }
        r3.close();	 Catch:{ Exception -> 0x0080 }
    L_0x0080:
        return r6;
    L_0x0081:
        r3.close();	 Catch:{ Exception -> 0x00a1 }
        goto L_0x00a1;
    L_0x0085:
        r6 = move-exception;
        r1 = r3;
        goto L_0x00a4;
    L_0x0088:
        r6 = move-exception;
        r1 = r3;
        goto L_0x008e;
    L_0x008b:
        r6 = move-exception;
        goto L_0x00a4;
    L_0x008d:
        r6 = move-exception;
    L_0x008e:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008b }
        r2 = "getProcessNameInternal exception:";	 Catch:{ all -> 0x008b }
        r0.<init>(r2);	 Catch:{ all -> 0x008b }
        r6 = r6.getMessage();	 Catch:{ all -> 0x008b }
        r0.append(r6);	 Catch:{ all -> 0x008b }
        if (r1 == 0) goto L_0x00a1;
    L_0x009e:
        r1.close();	 Catch:{ Exception -> 0x00a1 }
    L_0x00a1:
        r6 = "";
        return r6;
    L_0x00a4:
        if (r1 == 0) goto L_0x00a9;
    L_0x00a6:
        r1.close();	 Catch:{ Exception -> 0x00a9 }
    L_0x00a9:
        throw r6;
    L_0x00aa:
        r6 = "";
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareTinkerInternals.getProcessNameInternal(android.content.Context):java.lang.String");
    }

    private static boolean isVmArt(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r4 == 0) goto L_0x002c;
    L_0x0003:
        r1 = "(\\d+)\\.(\\d+)(\\.\\d+)?";
        r1 = java.util.regex.Pattern.compile(r1);
        r4 = r1.matcher(r4);
        r1 = r4.matches();
        if (r1 == 0) goto L_0x002c;
    L_0x0013:
        r1 = 1;
        r2 = r4.group(r1);	 Catch:{ NumberFormatException -> 0x002c }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x002c }
        r3 = 2;	 Catch:{ NumberFormatException -> 0x002c }
        r4 = r4.group(r3);	 Catch:{ NumberFormatException -> 0x002c }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x002c }
        if (r2 > r3) goto L_0x002b;
    L_0x0027:
        if (r2 != r3) goto L_0x002c;
    L_0x0029:
        if (r4 <= 0) goto L_0x002c;
    L_0x002b:
        r0 = r1;
    L_0x002c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareTinkerInternals.isVmArt(java.lang.String):boolean");
    }

    private static boolean isVmJitInternal() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            String str = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejit"});
            return !isNullOrNil(str) && isNullOrNil((String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejitprofiles"})) && str.equals("true");
        } catch (Throwable th) {
            new StringBuilder("isVmJitInternal ex:").append(th);
        }
    }

    public static java.lang.String getExceptionCauseString(java.lang.Throwable r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = new java.io.PrintStream;
        r1.<init>(r0);
    L_0x000a:
        r2 = r3.getCause();	 Catch:{ all -> 0x0024 }
        if (r2 == 0) goto L_0x0015;	 Catch:{ all -> 0x0024 }
    L_0x0010:
        r3 = r3.getCause();	 Catch:{ all -> 0x0024 }
        goto L_0x000a;	 Catch:{ all -> 0x0024 }
    L_0x0015:
        r3.printStackTrace(r1);	 Catch:{ all -> 0x0024 }
        r3 = r0.toString();	 Catch:{ all -> 0x0024 }
        r3 = toVisualString(r3);	 Catch:{ all -> 0x0024 }
        r0.close();	 Catch:{ IOException -> 0x0023 }
    L_0x0023:
        return r3;
    L_0x0024:
        r3 = move-exception;
        r0.close();	 Catch:{ IOException -> 0x0028 }
    L_0x0028:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareTinkerInternals.getExceptionCauseString(java.lang.Throwable):java.lang.String");
    }

    public static String toVisualString(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > '') {
                toCharArray[i] = '\u0000';
                c = '\u0001';
                break;
            }
            i++;
        }
        c = '\u0000';
        return c != '\u0000' ? new String(toCharArray, 0, i) : str;
    }
}
