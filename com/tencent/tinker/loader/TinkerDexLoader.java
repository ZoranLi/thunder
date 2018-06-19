package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Intent;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: BUGLY */
public class TinkerDexLoader {
    private static final String DEFAULT_DEX_OPTIMIZE_PATH = "odex";
    private static final String DEX_MEAT_FILE = "assets/dex_meta.txt";
    private static final String DEX_PATH = "dex";
    private static final String INTERPRET_DEX_OPTIMIZE_PATH = "interpet";
    private static final String TAG = "Tinker.TinkerDexLoader";
    private static HashSet<ShareDexDiffPatchInfo> classNDexInfo = new HashSet();
    private static boolean isVmArt = ShareTinkerInternals.isVmArt();
    private static final ArrayList<ShareDexDiffPatchInfo> loadDexList = new ArrayList();

    /* compiled from: BUGLY */
    final class AnonymousClass1 implements ResultCallback {
        long start;
        final /* synthetic */ boolean[] val$parallelOTAResult;
        final /* synthetic */ Throwable[] val$parallelOTAThrowable;

        AnonymousClass1(boolean[] zArr, Throwable[] thArr) {
            this.val$parallelOTAResult = zArr;
            this.val$parallelOTAThrowable = thArr;
        }

        public final void onStart(File file, File file2) {
            this.start = System.currentTimeMillis();
            new StringBuilder("start to optimize dex:").append(file.getPath());
        }

        public final void onSuccess(File file, File file2, File file3) {
            file2 = new StringBuilder("success to optimize dex ");
            file2.append(file.getPath());
            file2.append(", use time ");
            file2.append(System.currentTimeMillis() - this.start);
        }

        public final void onFailed(File file, File file2, Throwable th) {
            this.val$parallelOTAResult[0] = null;
            this.val$parallelOTAThrowable[0] = th;
            file2 = new StringBuilder("fail to optimize dex ");
            file2.append(file.getPath());
            file2.append(", use time ");
            file2.append(System.currentTimeMillis() - this.start);
        }
    }

    private TinkerDexLoader() {
    }

    @TargetApi(14)
    public static boolean loadTinkerJars(TinkerApplication tinkerApplication, String str, String str2, Intent intent, boolean z) {
        String str3 = str;
        Intent intent2 = intent;
        if (loadDexList.isEmpty() && classNDexInfo.isEmpty()) {
            return true;
        }
        PathClassLoader pathClassLoader = (PathClassLoader) TinkerDexLoader.class.getClassLoader();
        boolean z2 = false;
        if (pathClassLoader != null) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            File file;
            Application application;
            new StringBuilder("classloader: ").append(pathClassLoader.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str3);
            stringBuilder3.append("/dex/");
            String stringBuilder4 = stringBuilder3.toString();
            Object arrayList = new ArrayList();
            Iterator it = loadDexList.iterator();
            while (it.hasNext()) {
                shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                if (!isJustArtSupportDex(shareDexDiffPatchInfo)) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(stringBuilder4);
                    stringBuilder5.append(shareDexDiffPatchInfo.realName);
                    File file2 = new File(stringBuilder5.toString());
                    if (tinkerApplication.isTinkerLoadVerifyFlag()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (SharePatchFileUtil.verifyDexFileMd5(file2, getInfoMd5(shareDexDiffPatchInfo))) {
                            stringBuilder = new StringBuilder("verify dex file:");
                            stringBuilder.append(file2.getPath());
                            stringBuilder.append(" md5, use time: ");
                            stringBuilder.append(System.currentTimeMillis() - currentTimeMillis);
                        } else {
                            ShareIntentUtil.setIntentReturnCode(intent2, -13);
                            intent2.putExtra(ShareIntentUtil.INTENT_PATCH_MISMATCH_DEX_PATH, file2.getAbsolutePath());
                            return z2;
                        }
                    }
                    arrayList.add(file2);
                    z2 = false;
                }
            }
            if (isVmArt && !classNDexInfo.isEmpty()) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(stringBuilder4);
                stringBuilder2.append(ShareConstants.CLASS_N_APK_NAME);
                file = new File(stringBuilder2.toString());
                long currentTimeMillis2 = System.currentTimeMillis();
                if (tinkerApplication.isTinkerLoadVerifyFlag()) {
                    it = classNDexInfo.iterator();
                    while (it.hasNext()) {
                        shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                        if (!SharePatchFileUtil.verifyDexFileMd5(file, shareDexDiffPatchInfo.rawName, shareDexDiffPatchInfo.destMd5InArt)) {
                            ShareIntentUtil.setIntentReturnCode(intent2, -13);
                            intent2.putExtra(ShareIntentUtil.INTENT_PATCH_MISMATCH_DEX_PATH, file.getAbsolutePath());
                            return false;
                        }
                    }
                }
                StringBuilder stringBuilder6 = new StringBuilder("verify dex file:");
                stringBuilder6.append(file.getPath());
                stringBuilder6.append(" md5, use time: ");
                stringBuilder6.append(System.currentTimeMillis() - currentTimeMillis2);
                arrayList.add(file);
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str3);
            stringBuilder2.append("/");
            stringBuilder2.append(str2);
            file = new File(stringBuilder2.toString());
            if (z) {
                boolean[] zArr = new boolean[]{true};
                Throwable[] thArr = new Throwable[1];
                try {
                    String currentInstructionSet = ShareTinkerInternals.getCurrentInstructionSet();
                    deleteOutOfDateOATFile(str);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str3);
                    stringBuilder.append("/interpet");
                    File file3 = new File(stringBuilder.toString());
                    TinkerDexOptimizer.optimizeAll(arrayList, file3, true, currentInstructionSet, new AnonymousClass1(zArr, thArr));
                    if (zArr[0]) {
                        application = tinkerApplication;
                        file = file3;
                    } else {
                        intent2.putExtra(ShareIntentUtil.INTENT_PATCH_INTERPRET_EXCEPTION, thArr[0]);
                        ShareIntentUtil.setIntentReturnCode(intent2, -16);
                        return false;
                    }
                } catch (Serializable th) {
                    new StringBuilder("getCurrentInstructionSet fail:").append(th);
                    deleteOutOfDateOATFile(str);
                    intent2.putExtra(ShareIntentUtil.INTENT_PATCH_INTERPRET_EXCEPTION, th);
                    ShareIntentUtil.setIntentReturnCode(intent2, -15);
                    return false;
                }
            }
            application = tinkerApplication;
            try {
                SystemClassLoaderAdder.installDexes(application, pathClassLoader, file, arrayList);
                return true;
            } catch (Serializable th2) {
                intent2.putExtra(ShareIntentUtil.INTENT_PATCH_EXCEPTION, th2);
                ShareIntentUtil.setIntentReturnCode(intent2, -14);
                return false;
            }
        }
        boolean z3 = false;
        ShareIntentUtil.setIntentReturnCode(intent2, -12);
        return z3;
    }

    public static boolean checkComplete(String str, ShareSecurityCheck shareSecurityCheck, String str2, Intent intent) {
        String str3 = (String) shareSecurityCheck.getMetaContentMap().get("assets/dex_meta.txt");
        if (str3 == null) {
            return true;
        }
        loadDexList.clear();
        classNDexInfo.clear();
        ArrayList arrayList = new ArrayList();
        ShareDexDiffPatchInfo.parseDexDiffPatchInfo(str3, arrayList);
        if (arrayList.isEmpty() != null) {
            return true;
        }
        shareSecurityCheck = new HashMap();
        ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = (ShareDexDiffPatchInfo) it.next();
            if (!isJustArtSupportDex(shareDexDiffPatchInfo2)) {
                if (!ShareDexDiffPatchInfo.checkDexDiffPatchInfo(shareDexDiffPatchInfo2)) {
                    intent.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, -3);
                    ShareIntentUtil.setIntentReturnCode(intent, -8);
                    return false;
                } else if (isVmArt && shareDexDiffPatchInfo2.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
                    shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
                } else if (isVmArt && ShareConstants.CLASS_N_PATTERN.matcher(shareDexDiffPatchInfo2.realName).matches()) {
                    classNDexInfo.add(shareDexDiffPatchInfo2);
                } else {
                    shareSecurityCheck.put(shareDexDiffPatchInfo2.realName, getInfoMd5(shareDexDiffPatchInfo2));
                    loadDexList.add(shareDexDiffPatchInfo2);
                }
            }
        }
        if (isVmArt && !(shareDexDiffPatchInfo == null && classNDexInfo.isEmpty())) {
            if (shareDexDiffPatchInfo != null) {
                classNDexInfo.add(ShareTinkerInternals.changeTestDexToClassN(shareDexDiffPatchInfo, classNDexInfo.size() + 1));
            }
            shareSecurityCheck.put(ShareConstants.CLASS_N_APK_NAME, "");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/dex/");
        String stringBuilder2 = stringBuilder.toString();
        File file = new File(stringBuilder2);
        if (file.exists()) {
            if (file.isDirectory()) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str);
                stringBuilder3.append("/");
                stringBuilder3.append(str2);
                stringBuilder3.append("/");
                str2 = new File(stringBuilder3.toString());
                for (String str4 : shareSecurityCheck.keySet()) {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(stringBuilder2);
                    stringBuilder4.append(str4);
                    File file2 = new File(stringBuilder4.toString());
                    if (SharePatchFileUtil.isLegalFile(file2)) {
                        file = new File(SharePatchFileUtil.optimizedPathFor(file2, str2));
                        if (!SharePatchFileUtil.isLegalFile(file)) {
                            intent.putExtra(ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH, file.getAbsolutePath());
                            ShareIntentUtil.setIntentReturnCode(intent, -11);
                            return false;
                        }
                    }
                    intent.putExtra(ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH, file2.getAbsolutePath());
                    ShareIntentUtil.setIntentReturnCode(intent, -10);
                    return false;
                }
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_DEXES_PATH, shareSecurityCheck);
                return true;
            }
        }
        ShareIntentUtil.setIntentReturnCode(intent, -9);
        return false;
    }

    private static String getInfoMd5(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        return isVmArt ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
    }

    private static void deleteOutOfDateOATFile(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/odex/");
        SharePatchFileUtil.deleteDir(stringBuilder.toString());
        if (ShareTinkerInternals.isAfterAndroidO()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("/dex/oat/");
            SharePatchFileUtil.deleteDir(stringBuilder.toString());
        }
    }

    private static boolean isJustArtSupportDex(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (isVmArt || shareDexDiffPatchInfo.destMd5InDvm.equals("0") == null) {
            return false;
        }
        return true;
    }
}
