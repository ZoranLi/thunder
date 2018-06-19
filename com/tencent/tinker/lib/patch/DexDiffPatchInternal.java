package com.tencent.tinker.lib.patch;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import com.tencent.tinker.commons.dexpatcher.DexPatchApplier;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.ziputils.ziputil.TinkerZipEntry;
import com.tencent.tinker.ziputils.ziputil.TinkerZipFile;
import com.tencent.tinker.ziputils.ziputil.TinkerZipOutputStream;
import com.tencent.tinker.ziputils.ziputil.TinkerZipUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* compiled from: BUGLY */
public class DexDiffPatchInternal extends BasePatchInternal {
    protected static final int MAX_WAIT_COUNT = 30;
    protected static final String TAG = "Tinker.DexDiffPatchInternal";
    protected static final int WAIT_ASYN_OAT_TIME = 15000;
    private static HashMap<ShareDexDiffPatchInfo, File> classNDexInfo = new HashMap();
    private static boolean isVmArt = ShareTinkerInternals.isVmArt();
    private static ArrayList<File> optFiles = new ArrayList();
    private static ArrayList<ShareDexDiffPatchInfo> patchList = new ArrayList();

    protected static boolean tryRecoverDexFiles(Tinker tinker, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (tinker.isEnabledForDex() == null) {
            TinkerLog.w(TAG, "patch recover, dex is not enabled", new Object[0]);
            return true;
        }
        String str2 = (String) shareSecurityCheck.getMetaContentMap().get(ShareConstants.DEX_META_FILE);
        if (str2 == null) {
            TinkerLog.w(TAG, "patch recover, dex is not contained", new Object[0]);
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tinker = patchDexExtractViaDexDiff(context, str, str2, file);
        str = SystemClock.elapsedRealtime() - elapsedRealtime;
        TinkerLog.i(TAG, "recover dex result:%b, cost:%d", Boolean.valueOf(tinker), Long.valueOf(str));
        return tinker;
    }

    protected static boolean waitAndCheckDexOptFile(java.io.File r12, com.tencent.tinker.lib.tinker.Tinker r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = optFiles;
        r0 = r0.isEmpty();
        r1 = 1;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = patchList;
        r0 = r0.size();
        r0 = r0 * 8;
        r2 = 30;
        if (r0 <= r2) goto L_0x0017;
    L_0x0016:
        r0 = r2;
    L_0x0017:
        r2 = "Tinker.DexDiffPatchInternal";
        r3 = "raw dex count: %d, dex opt dex count: %d, final wait times: %d";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = patchList;
        r5 = r5.size();
        r5 = java.lang.Integer.valueOf(r5);
        r6 = 0;
        r4[r6] = r5;
        r5 = optFiles;
        r5 = r5.size();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r1] = r5;
        r5 = java.lang.Integer.valueOf(r0);
        r7 = 2;
        r4[r7] = r5;
        com.tencent.tinker.lib.util.TinkerLog.i(r2, r3, r4);
        r2 = r6;
    L_0x0042:
        if (r2 >= r0) goto L_0x006b;
    L_0x0044:
        r3 = optFiles;
        r2 = r2 + 1;
        r3 = checkAllDexOptFile(r3, r2);
        if (r3 != 0) goto L_0x0042;
    L_0x004e:
        r3 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        java.lang.Thread.sleep(r3);	 Catch:{ InterruptedException -> 0x0054 }
        goto L_0x0042;
    L_0x0054:
        r3 = move-exception;
        r4 = "Tinker.DexDiffPatchInternal";
        r5 = new java.lang.StringBuilder;
        r8 = "thread sleep InterruptedException e:";
        r5.<init>(r8);
        r5.append(r3);
        r3 = r5.toString();
        r5 = new java.lang.Object[r6];
        com.tencent.tinker.lib.util.TinkerLog.e(r4, r3, r5);
        goto L_0x0042;
    L_0x006b:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r2 = optFiles;
        r2 = r2.iterator();
    L_0x0076:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x00b4;
    L_0x007c:
        r3 = r2.next();
        r3 = (java.io.File) r3;
        r4 = "Tinker.DexDiffPatchInternal";
        r5 = "check dex optimizer file exist: %s, size %d";
        r8 = new java.lang.Object[r7];
        r9 = r3.getPath();
        r8[r6] = r9;
        r9 = r3.length();
        r9 = java.lang.Long.valueOf(r9);
        r8[r1] = r9;
        com.tencent.tinker.lib.util.TinkerLog.i(r4, r5, r8);
        r4 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.isLegalFile(r3);
        if (r4 != 0) goto L_0x0076;
    L_0x00a1:
        r4 = "Tinker.DexDiffPatchInternal";
        r5 = "final parallel dex optimizer file %s is not exist, return false";
        r8 = new java.lang.Object[r1];
        r9 = r3.getName();
        r8[r6] = r9;
        com.tencent.tinker.lib.util.TinkerLog.e(r4, r5, r8);
        r0.add(r3);
        goto L_0x0076;
    L_0x00b4:
        r2 = r0.isEmpty();
        if (r2 != 0) goto L_0x00c9;
    L_0x00ba:
        r13 = r13.getPatchReporter();
        r1 = new com.tencent.tinker.loader.TinkerRuntimeException;
        r2 = "checkDexOptExist failed";
        r1.<init>(r2);
        r13.onPatchDexOptFail(r12, r0, r1);
        return r6;
    L_0x00c9:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 21;
        if (r2 < r3) goto L_0x0140;
    L_0x00cf:
        r2 = 0;
        r3 = optFiles;
        r3 = r3.iterator();
    L_0x00d6:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x0121;
    L_0x00dc:
        r4 = r3.next();
        r4 = (java.io.File) r4;
        r5 = "Tinker.DexDiffPatchInternal";
        r8 = "check dex optimizer file format: %s, size %d";
        r9 = new java.lang.Object[r7];
        r10 = r4.getName();
        r9[r6] = r10;
        r10 = r4.length();
        r10 = java.lang.Long.valueOf(r10);
        r9[r1] = r10;
        com.tencent.tinker.lib.util.TinkerLog.i(r5, r8, r9);
        r5 = com.tencent.tinker.loader.shareutil.ShareElfFile.getFileTypeByMagic(r4);	 Catch:{ IOException -> 0x00d6 }
        if (r5 != r1) goto L_0x00d6;
    L_0x0101:
        r5 = new com.tencent.tinker.loader.shareutil.ShareElfFile;	 Catch:{ Throwable -> 0x010c }
        r5.<init>(r4);	 Catch:{ Throwable -> 0x010c }
        r5.close();	 Catch:{ IOException -> 0x00d6 }
        goto L_0x00d6;
    L_0x010a:
        r12 = move-exception;
        goto L_0x0120;
    L_0x010c:
        r2 = move-exception;
        r5 = "Tinker.DexDiffPatchInternal";	 Catch:{ all -> 0x010a }
        r8 = "final parallel dex optimizer file %s is not elf format, return false";	 Catch:{ all -> 0x010a }
        r9 = new java.lang.Object[r1];	 Catch:{ all -> 0x010a }
        r10 = r4.getName();	 Catch:{ all -> 0x010a }
        r9[r6] = r10;	 Catch:{ all -> 0x010a }
        com.tencent.tinker.lib.util.TinkerLog.e(r5, r8, r9);	 Catch:{ all -> 0x010a }
        r0.add(r4);	 Catch:{ all -> 0x010a }
        goto L_0x00d6;
    L_0x0120:
        throw r12;
    L_0x0121:
        r3 = r0.isEmpty();
        if (r3 != 0) goto L_0x0140;
    L_0x0127:
        if (r2 != 0) goto L_0x0131;
    L_0x0129:
        r1 = new com.tencent.tinker.loader.TinkerRuntimeException;
        r2 = "checkDexOptFormat failed";
        r1.<init>(r2);
        goto L_0x0138;
    L_0x0131:
        r1 = new com.tencent.tinker.loader.TinkerRuntimeException;
        r3 = "checkDexOptFormat failed";
        r1.<init>(r3, r2);
    L_0x0138:
        r13 = r13.getPatchReporter();
        r13.onPatchDexOptFail(r12, r0, r1);
        return r6;
    L_0x0140:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.patch.DexDiffPatchInternal.waitAndCheckDexOptFile(java.io.File, com.tencent.tinker.lib.tinker.Tinker):boolean");
    }

    private static boolean patchDexExtractViaDexDiff(Context context, String str, String str2, File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/dex/");
        String stringBuilder2 = stringBuilder.toString();
        int i = 0;
        if (extractDexDiffInternals(context, stringBuilder2, str2, file, 3) == null) {
            TinkerLog.w(TAG, "patch recover, extractDiffInternals fail", new Object[0]);
            return false;
        }
        str2 = new File(stringBuilder2).listFiles();
        List arrayList = new ArrayList();
        if (str2 != null) {
            int length = str2.length;
            while (i < length) {
                File file2 = str2[i];
                if (file2.isFile()) {
                    arrayList.add(file2);
                }
                i++;
            }
        }
        str2 = new StringBuilder();
        str2.append(str);
        str2.append("/odex/");
        return dexOptimizeDexFiles(context, arrayList, str2.toString(), file);
    }

    private static boolean checkClassNDexFiles(String str) {
        boolean z = false;
        if (!patchList.isEmpty()) {
            if (isVmArt) {
                Iterator it = patchList.iterator();
                ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
                Object obj = null;
                while (it.hasNext()) {
                    ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = (ShareDexDiffPatchInfo) it.next();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(shareDexDiffPatchInfo2.realName);
                    File file = new File(stringBuilder.toString());
                    if (ShareConstants.CLASS_N_PATTERN.matcher(file.getName()).matches()) {
                        classNDexInfo.put(shareDexDiffPatchInfo2, file);
                    }
                    if (shareDexDiffPatchInfo2.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
                        shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
                        obj = file;
                    }
                }
                if (shareDexDiffPatchInfo != null) {
                    classNDexInfo.put(ShareTinkerInternals.changeTestDexToClassN(shareDexDiffPatchInfo, classNDexInfo.size() + 1), obj);
                }
                File file2 = new File(str, ShareConstants.CLASS_N_APK_NAME);
                if (file2.exists() != null) {
                    for (ShareDexDiffPatchInfo shareDexDiffPatchInfo3 : classNDexInfo.keySet()) {
                        if (!SharePatchFileUtil.verifyDexFileMd5(file2, shareDexDiffPatchInfo3.rawName, shareDexDiffPatchInfo3.destMd5InArt)) {
                            TinkerLog.e(TAG, "verify dex file md5 error, entry name; %s, file len: %d", shareDexDiffPatchInfo3.rawName, Long.valueOf(file2.length()));
                            break;
                        }
                    }
                    z = true;
                    if (!z) {
                        SharePatchFileUtil.safeDeleteFile(file2);
                    }
                }
                if (z) {
                    for (File safeDeleteFile : classNDexInfo.values()) {
                        SharePatchFileUtil.safeDeleteFile(safeDeleteFile);
                    }
                }
                return z;
            }
        }
        return false;
    }

    private static boolean mergeClassNDexFiles(Context context, File file, String str) {
        Closeable tinkerZipOutputStream;
        if (!patchList.isEmpty()) {
            if (isVmArt) {
                File file2 = new File(str, ShareConstants.CLASS_N_APK_NAME);
                if (classNDexInfo.isEmpty() != null) {
                    TinkerLog.w(TAG, "classNDexInfo size: %d, no need to merge classN dex files", new Object[]{Integer.valueOf(classNDexInfo.size())});
                    return true;
                }
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    tinkerZipOutputStream = new TinkerZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                    for (ShareDexDiffPatchInfo shareDexDiffPatchInfo : classNDexInfo.keySet()) {
                        File file3 = (File) classNDexInfo.get(shareDexDiffPatchInfo);
                        if (shareDexDiffPatchInfo.isJarMode) {
                            TinkerZipFile tinkerZipFile = new TinkerZipFile(file3);
                            TinkerZipEntry entry = tinkerZipFile.getEntry("classes.dex");
                            TinkerZipEntry tinkerZipEntry = new TinkerZipEntry(entry, shareDexDiffPatchInfo.rawName);
                            Closeable inputStream = tinkerZipFile.getInputStream(entry);
                            try {
                                TinkerZipUtil.extractTinkerEntry(tinkerZipEntry, inputStream, tinkerZipOutputStream);
                                SharePatchFileUtil.closeQuietly(inputStream);
                            } catch (Throwable th) {
                                str = th;
                            }
                        } else {
                            TinkerZipUtil.extractLargeModifyFile(new TinkerZipEntry(shareDexDiffPatchInfo.rawName), file3, Long.parseLong(shareDexDiffPatchInfo.newDexCrC), tinkerZipOutputStream);
                        }
                    }
                    SharePatchFileUtil.closeQuietly(tinkerZipOutputStream);
                    str = 1;
                } catch (Throwable th2) {
                    context = th2;
                    tinkerZipOutputStream = null;
                    SharePatchFileUtil.closeQuietly(tinkerZipOutputStream);
                    throw context;
                }
                if (str != null) {
                    for (ShareDexDiffPatchInfo shareDexDiffPatchInfo2 : classNDexInfo.keySet()) {
                        if (SharePatchFileUtil.verifyDexFileMd5(file2, shareDexDiffPatchInfo2.rawName, shareDexDiffPatchInfo2.destMd5InArt)) {
                            TinkerLog.e(TAG, "verify dex file md5 error, entry name; %s, file len: %d", shareDexDiffPatchInfo2.rawName, Long.valueOf(file2.length()));
                            str = null;
                            break;
                        }
                    }
                }
                if (str == null) {
                    while (context.hasNext() != null) {
                        SharePatchFileUtil.safeDeleteFile(file);
                    }
                } else {
                    TinkerLog.e(TAG, "merge classN dex error, try delete temp file", new Object[0]);
                    SharePatchFileUtil.safeDeleteFile(file2);
                    Tinker.with(context).getPatchReporter().onPatchTypeExtractFail(file, file2, file2.getName(), 7);
                }
                TinkerLog.i(TAG, "merge classN dex file %s, result: %b, size: %d, use: %dms", file2.getPath(), Boolean.valueOf(str), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return str;
            }
        }
        return true;
    }

    private static boolean dexOptimizeDexFiles(Context context, List<File> list, String str, File file) {
        context = Tinker.with(context);
        optFiles.clear();
        if (list != null) {
            File file2 = new File(str);
            if (file2.exists() || file2.mkdirs()) {
                for (File optimizedPathFor : list) {
                    optFiles.add(new File(SharePatchFileUtil.optimizedPathFor(optimizedPathFor, file2)));
                }
                TinkerLog.i(TAG, "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", Integer.valueOf(list.size()), str);
                str = new Vector();
                Throwable[] thArr = new Throwable[1];
                TinkerDexOptimizer.optimizeAll(list, file2, new 1(str, thArr));
                if (str.isEmpty() == null) {
                    context.getPatchReporter().onPatchDexOptFail(file, str, thArr[0]);
                    return false;
                }
            }
            TinkerLog.w(TAG, "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
            return false;
        }
        return true;
    }

    private static boolean checkAllDexOptFile(ArrayList<File> arrayList, int i) {
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            if (!SharePatchFileUtil.isLegalFile((File) arrayList.next())) {
                TinkerLog.e(TAG, "parallel dex optimizer file %s is not exist, just wait %d times", ((File) arrayList.next()).getName(), Integer.valueOf(i));
                return false;
            }
        }
        return true;
    }

    private static boolean extractDexDiffInternals(Context context, String str, String str2, File file, int i) {
        Throwable th;
        StringBuilder stringBuilder;
        String str3 = str;
        File file2 = file;
        int i2 = i;
        patchList.clear();
        ShareDexDiffPatchInfo.parseDexDiffPatchInfo(str2, patchList);
        int i3 = 1;
        boolean z = false;
        if (patchList.isEmpty()) {
            TinkerLog.w(TAG, "extract patch list is empty! type:%s:", ShareTinkerInternals.getTypeString(i));
            return true;
        }
        File file3 = new File(str3);
        if (!file3.exists()) {
            file3.mkdirs();
        }
        Tinker with = Tinker.with(context);
        ZipFile zipFile = null;
        ZipFile zipFile2;
        ZipFile zipFile3;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                TinkerLog.w(TAG, "applicationInfo == null!!!!", new Object[0]);
                SharePatchFileUtil.closeZip(null);
                SharePatchFileUtil.closeZip(null);
                return false;
            }
            zipFile2 = new ZipFile(applicationInfo.sourceDir);
            try {
                zipFile3 = new ZipFile(file2);
                try {
                    if (checkClassNDexFiles(str)) {
                        TinkerLog.w(TAG, "class n dex file %s is already exist, and md5 match, just continue", ShareConstants.CLASS_N_APK_NAME);
                        SharePatchFileUtil.closeZip(zipFile2);
                        SharePatchFileUtil.closeZip(zipFile3);
                        return true;
                    }
                    Iterator it = patchList.iterator();
                    while (it.hasNext()) {
                        String str4;
                        ShareDexDiffPatchInfo shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (shareDexDiffPatchInfo.path.equals("")) {
                            str4 = shareDexDiffPatchInfo.rawName;
                        } else {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(shareDexDiffPatchInfo.path);
                            stringBuilder2.append("/");
                            stringBuilder2.append(shareDexDiffPatchInfo.rawName);
                            str4 = stringBuilder2.toString();
                        }
                        String str5 = shareDexDiffPatchInfo.dexDiffMd5;
                        String str6 = shareDexDiffPatchInfo.oldDexCrC;
                        if (isVmArt || !shareDexDiffPatchInfo.destMd5InDvm.equals("0")) {
                            String str7 = isVmArt ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
                            if (SharePatchFileUtil.checkIfMd5Valid(str7)) {
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(str3);
                                stringBuilder3.append(shareDexDiffPatchInfo.realName);
                                File file4 = new File(stringBuilder3.toString());
                                Iterator it2;
                                ZipEntry entry;
                                ZipEntry entry2;
                                ZipEntry zipEntry;
                                File file5;
                                ZipEntry zipEntry2;
                                ShareDexDiffPatchInfo shareDexDiffPatchInfo2;
                                StringBuilder stringBuilder4;
                                if (!file4.exists()) {
                                    it2 = it;
                                    file4.getParentFile().mkdirs();
                                    entry = zipFile3.getEntry(str4);
                                    entry2 = zipFile2.getEntry(str4);
                                    if (str6.equals("0")) {
                                        if (entry == null) {
                                            str3 = TAG;
                                            stringBuilder3 = new StringBuilder("patch entry is null. path:");
                                            stringBuilder3.append(str4);
                                            TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                            SharePatchFileUtil.closeZip(zipFile2);
                                            SharePatchFileUtil.closeZip(zipFile3);
                                            return false;
                                        } else if (!extractDexFile(zipFile3, entry, file4, shareDexDiffPatchInfo)) {
                                            str3 = TAG;
                                            stringBuilder3 = new StringBuilder("Failed to extract raw patch file ");
                                            stringBuilder3.append(file4.getPath());
                                            TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                            SharePatchFileUtil.closeZip(zipFile2);
                                            SharePatchFileUtil.closeZip(zipFile3);
                                            return false;
                                        }
                                    } else if (str5.equals("0")) {
                                        if (isVmArt) {
                                            if (entry2 != null) {
                                                if (String.valueOf(entry2.getCrc()).equals(str6)) {
                                                    extractDexFile(zipFile2, entry2, file4, shareDexDiffPatchInfo);
                                                    if (!SharePatchFileUtil.verifyDexFileMd5(file4, str7)) {
                                                        str3 = TAG;
                                                        stringBuilder3 = new StringBuilder("Failed to recover dex file when verify patched dex: ");
                                                        stringBuilder3.append(file4.getPath());
                                                        TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                                        with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                                        SharePatchFileUtil.safeDeleteFile(file4);
                                                        SharePatchFileUtil.closeZip(zipFile2);
                                                        SharePatchFileUtil.closeZip(zipFile3);
                                                        return false;
                                                    }
                                                }
                                                TinkerLog.e(TAG, "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str4, str6, String.valueOf(entry2.getCrc()));
                                                with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                                SharePatchFileUtil.closeZip(zipFile2);
                                                SharePatchFileUtil.closeZip(zipFile3);
                                                return false;
                                            }
                                            str3 = TAG;
                                            stringBuilder3 = new StringBuilder("apk entry is null. path:");
                                            stringBuilder3.append(str4);
                                            TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                            SharePatchFileUtil.closeZip(zipFile2);
                                            SharePatchFileUtil.closeZip(zipFile3);
                                            return false;
                                        }
                                    } else if (entry == null) {
                                        str3 = TAG;
                                        stringBuilder3 = new StringBuilder("patch entry is null. path:");
                                        stringBuilder3.append(str4);
                                        TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                        with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        SharePatchFileUtil.closeZip(zipFile3);
                                        return false;
                                    } else if (!SharePatchFileUtil.checkIfMd5Valid(str5)) {
                                        TinkerLog.w(TAG, "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), shareDexDiffPatchInfo.rawName, str5);
                                        with.getPatchReporter().onPatchPackageCheckFail(file2, BasePatchInternal.getMetaCorruptedCode(i));
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        SharePatchFileUtil.closeZip(zipFile3);
                                        return false;
                                    } else if (entry2 != null) {
                                        if (String.valueOf(entry2.getCrc()).equals(str6)) {
                                            zipEntry = entry2;
                                            file5 = file4;
                                            zipEntry2 = entry;
                                            str3 = str7;
                                            shareDexDiffPatchInfo2 = shareDexDiffPatchInfo;
                                            patchDexFile(zipFile2, zipFile3, zipEntry, zipEntry2, shareDexDiffPatchInfo, file5);
                                            if (SharePatchFileUtil.verifyDexFileMd5(file5, str3)) {
                                                TinkerLog.w(TAG, "success recover dex file: %s, size: %d, use time: %d", file5.getPath(), Long.valueOf(file5.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                            } else {
                                                str3 = TAG;
                                                stringBuilder4 = new StringBuilder("Failed to recover dex file when verify patched dex: ");
                                                stringBuilder4.append(file5.getPath());
                                                TinkerLog.w(str3, stringBuilder4.toString(), new Object[0]);
                                                with.getPatchReporter().onPatchTypeExtractFail(file2, file5, shareDexDiffPatchInfo2.rawName, i2);
                                                SharePatchFileUtil.safeDeleteFile(file5);
                                                SharePatchFileUtil.closeZip(zipFile2);
                                                SharePatchFileUtil.closeZip(zipFile3);
                                                return false;
                                            }
                                        }
                                        TinkerLog.e(TAG, "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str4, str6, String.valueOf(entry2.getCrc()));
                                        with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        SharePatchFileUtil.closeZip(zipFile3);
                                        return false;
                                    } else {
                                        str3 = TAG;
                                        stringBuilder3 = new StringBuilder("apk entry is null. path:");
                                        stringBuilder3.append(str4);
                                        TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                        with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        SharePatchFileUtil.closeZip(zipFile3);
                                        return false;
                                    }
                                    it = it2;
                                    str3 = str;
                                } else if (SharePatchFileUtil.verifyDexFileMd5(file4, str7)) {
                                    TinkerLog.w(TAG, "dex file %s is already exist, and md5 match, just continue", file4.getPath());
                                } else {
                                    String str8 = TAG;
                                    it2 = it;
                                    StringBuilder stringBuilder5 = new StringBuilder("have a mismatch corrupted dex ");
                                    stringBuilder5.append(file4.getPath());
                                    TinkerLog.w(str8, stringBuilder5.toString(), new Object[0]);
                                    file4.delete();
                                    entry = zipFile3.getEntry(str4);
                                    entry2 = zipFile2.getEntry(str4);
                                    if (str6.equals("0")) {
                                        if (entry == null) {
                                            str3 = TAG;
                                            stringBuilder3 = new StringBuilder("patch entry is null. path:");
                                            stringBuilder3.append(str4);
                                            TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                            SharePatchFileUtil.closeZip(zipFile2);
                                            SharePatchFileUtil.closeZip(zipFile3);
                                            return false;
                                        } else if (extractDexFile(zipFile3, entry, file4, shareDexDiffPatchInfo)) {
                                            str3 = TAG;
                                            stringBuilder3 = new StringBuilder("Failed to extract raw patch file ");
                                            stringBuilder3.append(file4.getPath());
                                            TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                            SharePatchFileUtil.closeZip(zipFile2);
                                            SharePatchFileUtil.closeZip(zipFile3);
                                            return false;
                                        }
                                    } else if (str5.equals("0")) {
                                        if (isVmArt) {
                                            if (entry2 != null) {
                                                str3 = TAG;
                                                stringBuilder3 = new StringBuilder("apk entry is null. path:");
                                                stringBuilder3.append(str4);
                                                TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                                with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                                SharePatchFileUtil.closeZip(zipFile2);
                                                SharePatchFileUtil.closeZip(zipFile3);
                                                return false;
                                            }
                                            if (String.valueOf(entry2.getCrc()).equals(str6)) {
                                                TinkerLog.e(TAG, "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str4, str6, String.valueOf(entry2.getCrc()));
                                                with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                                SharePatchFileUtil.closeZip(zipFile2);
                                                SharePatchFileUtil.closeZip(zipFile3);
                                                return false;
                                            }
                                            extractDexFile(zipFile2, entry2, file4, shareDexDiffPatchInfo);
                                            if (SharePatchFileUtil.verifyDexFileMd5(file4, str7)) {
                                                str3 = TAG;
                                                stringBuilder3 = new StringBuilder("Failed to recover dex file when verify patched dex: ");
                                                stringBuilder3.append(file4.getPath());
                                                TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                                with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                                SharePatchFileUtil.safeDeleteFile(file4);
                                                SharePatchFileUtil.closeZip(zipFile2);
                                                SharePatchFileUtil.closeZip(zipFile3);
                                                return false;
                                            }
                                        }
                                    } else if (entry == null) {
                                        str3 = TAG;
                                        stringBuilder3 = new StringBuilder("patch entry is null. path:");
                                        stringBuilder3.append(str4);
                                        TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                        with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        SharePatchFileUtil.closeZip(zipFile3);
                                        return false;
                                    } else if (!SharePatchFileUtil.checkIfMd5Valid(str5)) {
                                        TinkerLog.w(TAG, "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), shareDexDiffPatchInfo.rawName, str5);
                                        with.getPatchReporter().onPatchPackageCheckFail(file2, BasePatchInternal.getMetaCorruptedCode(i));
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        SharePatchFileUtil.closeZip(zipFile3);
                                        return false;
                                    } else if (entry2 != null) {
                                        str3 = TAG;
                                        stringBuilder3 = new StringBuilder("apk entry is null. path:");
                                        stringBuilder3.append(str4);
                                        TinkerLog.w(str3, stringBuilder3.toString(), new Object[0]);
                                        with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        SharePatchFileUtil.closeZip(zipFile3);
                                        return false;
                                    } else {
                                        if (String.valueOf(entry2.getCrc()).equals(str6)) {
                                            TinkerLog.e(TAG, "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str4, str6, String.valueOf(entry2.getCrc()));
                                            with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareDexDiffPatchInfo.rawName, i2);
                                            SharePatchFileUtil.closeZip(zipFile2);
                                            SharePatchFileUtil.closeZip(zipFile3);
                                            return false;
                                        }
                                        zipEntry = entry2;
                                        file5 = file4;
                                        zipEntry2 = entry;
                                        str3 = str7;
                                        shareDexDiffPatchInfo2 = shareDexDiffPatchInfo;
                                        patchDexFile(zipFile2, zipFile3, zipEntry, zipEntry2, shareDexDiffPatchInfo, file5);
                                        if (SharePatchFileUtil.verifyDexFileMd5(file5, str3)) {
                                            str3 = TAG;
                                            stringBuilder4 = new StringBuilder("Failed to recover dex file when verify patched dex: ");
                                            stringBuilder4.append(file5.getPath());
                                            TinkerLog.w(str3, stringBuilder4.toString(), new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file2, file5, shareDexDiffPatchInfo2.rawName, i2);
                                            SharePatchFileUtil.safeDeleteFile(file5);
                                            SharePatchFileUtil.closeZip(zipFile2);
                                            SharePatchFileUtil.closeZip(zipFile3);
                                            return false;
                                        }
                                        TinkerLog.w(TAG, "success recover dex file: %s, size: %d, use time: %d", file5.getPath(), Long.valueOf(file5.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    }
                                    it = it2;
                                    str3 = str;
                                }
                                i3 = 1;
                                z = false;
                            } else {
                                TinkerLog.w(TAG, "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), shareDexDiffPatchInfo.rawName, str7);
                                with.getPatchReporter().onPatchPackageCheckFail(file2, BasePatchInternal.getMetaCorruptedCode(i));
                                SharePatchFileUtil.closeZip(zipFile2);
                                SharePatchFileUtil.closeZip(zipFile3);
                                return z;
                            }
                        }
                        Object[] objArr = new Object[i3];
                        objArr[z] = str4;
                        TinkerLog.w(TAG, "patch dex %s is only for art, just continue", objArr);
                    }
                    if (mergeClassNDexFiles(context, file2, str3)) {
                        SharePatchFileUtil.closeZip(zipFile2);
                        SharePatchFileUtil.closeZip(zipFile3);
                        return true;
                    }
                    SharePatchFileUtil.closeZip(zipFile2);
                    SharePatchFileUtil.closeZip(zipFile3);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th22) {
                th = th22;
                zipFile3 = null;
                SharePatchFileUtil.closeZip(zipFile2);
                SharePatchFileUtil.closeZip(zipFile3);
                throw th;
            }
        } catch (Throwable th222) {
            th = th222;
            zipFile3 = null;
            zipFile2 = zipFile3;
            SharePatchFileUtil.closeZip(zipFile2);
            SharePatchFileUtil.closeZip(zipFile3);
            throw th;
        }
    }

    private static boolean extractDexToJar(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        int i = 0;
        boolean z = i;
        while (i < 2 && !z) {
            Closeable zipOutputStream;
            Closeable bufferedInputStream;
            i++;
            OutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder("try Extracting ");
            stringBuilder.append(file.getPath());
            TinkerLog.i(str2, stringBuilder.toString(), new Object[0]);
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                try {
                    bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        byte[] bArr = new byte[16384];
                        zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                        for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.closeEntry();
                        SharePatchFileUtil.closeQuietly(bufferedInputStream);
                        SharePatchFileUtil.closeQuietly(zipOutputStream);
                        z = SharePatchFileUtil.verifyDexFileMd5(file, str);
                        TinkerLog.i(TAG, "isExtractionSuccessful: %b", Boolean.valueOf(z));
                        if (!z) {
                            file.delete();
                            if (file.exists()) {
                                String str3 = TAG;
                                StringBuilder stringBuilder2 = new StringBuilder("Failed to delete corrupted dex ");
                                stringBuilder2.append(file.getPath());
                                TinkerLog.e(str3, stringBuilder2.toString(), new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        zipFile = th;
                    }
                } catch (Throwable th2) {
                    zipFile = th2;
                    bufferedInputStream = null;
                }
            } catch (Throwable th3) {
                zipFile = th3;
                bufferedInputStream = null;
                zipOutputStream = bufferedInputStream;
            }
        }
        return z;
        SharePatchFileUtil.closeQuietly(bufferedInputStream);
        SharePatchFileUtil.closeQuietly(zipOutputStream);
        throw zipFile;
    }

    private static boolean extractDexFile(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) throws IOException {
        String str = isVmArt ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
        String str2 = shareDexDiffPatchInfo.rawName;
        shareDexDiffPatchInfo = shareDexDiffPatchInfo.isJarMode;
        if (!SharePatchFileUtil.isRawDexFile(str2) || shareDexDiffPatchInfo == null) {
            return BasePatchInternal.extract(zipFile, zipEntry, file, str, true);
        }
        return extractDexToJar(zipFile, zipEntry, file, str);
    }

    private static void patchDexFile(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) throws IOException {
        Closeable bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            if (zipEntry2 != null) {
                try {
                    zipFile = new BufferedInputStream(zipFile2.getInputStream(zipEntry2));
                } catch (ZipFile zipFile3) {
                    zipFile2 = zipFile3;
                    zipFile3 = null;
                    SharePatchFileUtil.closeQuietly(bufferedInputStream);
                    SharePatchFileUtil.closeQuietly(zipFile3);
                    throw zipFile2;
                }
            }
            zipFile3 = null;
            try {
                zipFile2 = SharePatchFileUtil.isRawDexFile(shareDexDiffPatchInfo.rawName);
                if (zipFile2 != null) {
                    if (shareDexDiffPatchInfo.isJarMode == null) {
                        new DexPatchApplier(bufferedInputStream, zipFile3).executeAndSaveTo(file);
                        SharePatchFileUtil.closeQuietly(bufferedInputStream);
                        SharePatchFileUtil.closeQuietly(zipFile3);
                    }
                }
                try {
                    zipEntry = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                    try {
                        zipEntry.putNextEntry(new ZipEntry("classes.dex"));
                        if (zipFile2 == null) {
                            try {
                                zipFile2 = new ZipInputStream(bufferedInputStream);
                                do {
                                    zipEntry2 = zipFile2.getNextEntry();
                                    if (zipEntry2 == null) {
                                        break;
                                    }
                                } while ("classes.dex".equals(zipEntry2.getName()) == null);
                                if (zipEntry2 == null) {
                                    shareDexDiffPatchInfo = new StringBuilder("can't recognize zip dex format file:");
                                    shareDexDiffPatchInfo.append(file.getAbsolutePath());
                                    throw new TinkerRuntimeException(shareDexDiffPatchInfo.toString());
                                }
                                new DexPatchApplier(zipFile2, zipFile3).executeAndSaveTo(zipEntry);
                                SharePatchFileUtil.closeQuietly(zipFile2);
                            } catch (Throwable th) {
                                zipEntry2 = th;
                                zipFile2 = null;
                                SharePatchFileUtil.closeQuietly(zipFile2);
                                throw zipEntry2;
                            }
                        }
                        new DexPatchApplier(bufferedInputStream, zipFile3).executeAndSaveTo(zipEntry);
                        zipEntry.closeEntry();
                        SharePatchFileUtil.closeQuietly(zipEntry);
                        SharePatchFileUtil.closeQuietly(bufferedInputStream);
                        SharePatchFileUtil.closeQuietly(zipFile3);
                    } catch (Throwable th2) {
                        zipFile2 = th2;
                    }
                } catch (Throwable th3) {
                    zipFile2 = th3;
                    zipEntry = null;
                    SharePatchFileUtil.closeQuietly(zipEntry);
                    throw zipFile2;
                }
            } catch (Throwable th4) {
                zipFile2 = th4;
                SharePatchFileUtil.closeQuietly(bufferedInputStream);
                SharePatchFileUtil.closeQuietly(zipFile3);
                throw zipFile2;
            }
        } catch (ZipFile zipFile32) {
            zipFile2 = zipFile32;
            zipFile32 = null;
            bufferedInputStream = zipFile32;
            SharePatchFileUtil.closeQuietly(bufferedInputStream);
            SharePatchFileUtil.closeQuietly(zipFile32);
            throw zipFile2;
        }
    }
}
