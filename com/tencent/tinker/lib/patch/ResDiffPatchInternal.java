package com.tencent.tinker.lib.patch;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import com.tencent.tinker.bsdiff.BSPatch;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo.LargeModeInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.ziputils.ziputil.TinkerZipEntry;
import com.tencent.tinker.ziputils.ziputil.TinkerZipFile;
import com.tencent.tinker.ziputils.ziputil.TinkerZipOutputStream;
import com.tencent.tinker.ziputils.ziputil.TinkerZipUtil;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: BUGLY */
public class ResDiffPatchInternal extends BasePatchInternal {
    protected static final String TAG = "Tinker.ResDiffPatchInternal";

    protected static boolean tryRecoverResourceFiles(Tinker tinker, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (tinker.isEnabledForResource() == null) {
            TinkerLog.w(TAG, "patch recover, resource is not enabled", new Object[0]);
            return true;
        }
        String str2 = (String) shareSecurityCheck.getMetaContentMap().get(ShareConstants.RES_META_FILE);
        if (str2 != null) {
            if (str2.length() != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                tinker = patchResourceExtractViaResourceDiff(context, str, str2, file);
                str = SystemClock.elapsedRealtime() - elapsedRealtime;
                TinkerLog.i(TAG, "recover resource result:%b, cost:%d", Boolean.valueOf(tinker), Long.valueOf(str));
                return tinker;
            }
        }
        TinkerLog.w(TAG, "patch recover, resource is not contained", new Object[0]);
        return true;
    }

    private static boolean patchResourceExtractViaResourceDiff(Context context, String str, String str2, File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/res/");
        if (extractResourceDiffInternals(context, stringBuilder.toString(), str2, file, 6) != null) {
            return true;
        }
        TinkerLog.w(TAG, "patch recover, extractDiffInternals fail", new Object[0]);
        return false;
    }

    private static boolean extractResourceDiffInternals(Context context, String str, String str2, File file, int i) {
        Throwable th;
        Throwable th2;
        String str3 = str;
        File file2 = file;
        int i2 = i;
        ShareResPatchInfo shareResPatchInfo = new ShareResPatchInfo();
        ShareResPatchInfo.parseAllResPatchInfo(str2, shareResPatchInfo);
        r4 = new Object[2];
        boolean z = false;
        r4[0] = str3;
        r4[1] = shareResPatchInfo.toString();
        TinkerLog.i(TAG, "res dir: %s, meta: %s", r4);
        Tinker with = Tinker.with(context);
        if (SharePatchFileUtil.checkIfMd5Valid(shareResPatchInfo.resArscMd5)) {
            File file3 = new File(str3);
            File file4 = new File(file3, "res_temp");
            File file5 = new File(file3, ShareConstants.RES_NAME);
            if (!file5.exists()) {
                file5.getParentFile().mkdirs();
            } else if (SharePatchFileUtil.checkResourceArscMd5(file5, shareResPatchInfo.resArscMd5)) {
                TinkerLog.w(TAG, "resource file %s is already exist, and md5 match, just return true", file5.getPath());
                return true;
            } else {
                str3 = TAG;
                StringBuilder stringBuilder = new StringBuilder("have a mismatch corrupted resource ");
                stringBuilder.append(file5.getPath());
                TinkerLog.w(str3, stringBuilder.toString(), new Object[0]);
                file5.delete();
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo == null) {
                    TinkerLog.w(TAG, "applicationInfo == null!!!!", new Object[0]);
                    return false;
                }
                String str4 = applicationInfo.sourceDir;
                String str5 = str4;
                File file6 = file5;
                if (!checkAndExtractResourceLargeFile(context, str4, file3, file4, file2, shareResPatchInfo, i2)) {
                    return false;
                }
                TinkerZipOutputStream tinkerZipOutputStream;
                TinkerZipFile tinkerZipFile;
                TinkerZipFile tinkerZipFile2;
                try {
                    tinkerZipOutputStream = new TinkerZipOutputStream(new BufferedOutputStream(new FileOutputStream(file6)));
                    try {
                        tinkerZipFile = new TinkerZipFile(str5);
                    } catch (Throwable th3) {
                        th = th3;
                        tinkerZipFile = null;
                        tinkerZipFile2 = tinkerZipFile;
                        th2 = th;
                        if (tinkerZipOutputStream != null) {
                            tinkerZipOutputStream.close();
                        }
                        if (tinkerZipFile != null) {
                            tinkerZipFile.close();
                        }
                        if (tinkerZipFile2 != null) {
                            tinkerZipFile2.close();
                        }
                        SharePatchFileUtil.deleteDir(file4);
                        throw th2;
                    }
                    try {
                        tinkerZipFile2 = new TinkerZipFile(file2);
                        Enumeration entries = tinkerZipFile.entries();
                        int i3 = 0;
                        while (entries.hasMoreElements()) {
                            TinkerZipEntry tinkerZipEntry = (TinkerZipEntry) entries.nextElement();
                            if (tinkerZipEntry == null) {
                                throw new TinkerRuntimeException("zipEntry is null when get from oldApk");
                            }
                            String name = tinkerZipEntry.getName();
                            if (!(name.contains("../") || !ShareResPatchInfo.checkFileInPattern(shareResPatchInfo.patterns, name) || shareResPatchInfo.deleteRes.contains(name) || shareResPatchInfo.modRes.contains(name) || shareResPatchInfo.largeModRes.contains(name) || name.equals(ShareConstants.RES_MANIFEST))) {
                                TinkerZipUtil.extractTinkerEntry(tinkerZipFile, tinkerZipEntry, tinkerZipOutputStream);
                                i3++;
                            }
                        }
                        TinkerZipEntry entry = tinkerZipFile.getEntry(ShareConstants.RES_MANIFEST);
                        if (entry == null) {
                            TinkerLog.w(TAG, "manifest patch entry is null. path:AndroidManifest.xml", new Object[0]);
                            with.getPatchReporter().onPatchTypeExtractFail(file2, file6, ShareConstants.RES_MANIFEST, i2);
                            tinkerZipOutputStream.close();
                            tinkerZipFile.close();
                            tinkerZipFile2.close();
                            SharePatchFileUtil.deleteDir(file4);
                            return false;
                        }
                        TinkerZipEntry entry2;
                        StringBuilder stringBuilder2;
                        File file7;
                        File file8;
                        TinkerZipUtil.extractTinkerEntry(tinkerZipFile, entry, tinkerZipOutputStream);
                        i3++;
                        Iterator it = shareResPatchInfo.largeModRes.iterator();
                        while (it.hasNext()) {
                            str4 = (String) it.next();
                            entry2 = tinkerZipFile.getEntry(str4);
                            if (entry2 == null) {
                                str3 = TAG;
                                stringBuilder2 = new StringBuilder("large patch entry is null. path:");
                                stringBuilder2.append(str4);
                                TinkerLog.w(str3, stringBuilder2.toString(), new Object[z]);
                                with.getPatchReporter().onPatchTypeExtractFail(file2, file6, str4, i2);
                                tinkerZipOutputStream.close();
                                tinkerZipFile.close();
                                tinkerZipFile2.close();
                                SharePatchFileUtil.deleteDir(file4);
                                return z;
                            }
                            LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.largeModMap.get(str4);
                            file7 = file6;
                            TinkerZipUtil.extractLargeModifyFile(entry2, largeModeInfo.file, largeModeInfo.crc, tinkerZipOutputStream);
                            i3++;
                            file6 = file7;
                            z = false;
                        }
                        file7 = file6;
                        it = shareResPatchInfo.addRes.iterator();
                        while (it.hasNext()) {
                            str4 = (String) it.next();
                            entry2 = tinkerZipFile2.getEntry(str4);
                            if (entry2 == null) {
                                str3 = TAG;
                                stringBuilder2 = new StringBuilder("add patch entry is null. path:");
                                stringBuilder2.append(str4);
                                TinkerLog.w(str3, stringBuilder2.toString(), new Object[0]);
                                with.getPatchReporter().onPatchTypeExtractFail(file2, file7, str4, i2);
                                tinkerZipOutputStream.close();
                                tinkerZipFile.close();
                                tinkerZipFile2.close();
                                SharePatchFileUtil.deleteDir(file4);
                                return false;
                            }
                            file8 = file7;
                            if (shareResPatchInfo.storeRes.containsKey(str4)) {
                                TinkerZipUtil.extractLargeModifyFile(entry2, (File) shareResPatchInfo.storeRes.get(str4), entry2.getCrc(), tinkerZipOutputStream);
                            } else {
                                TinkerZipUtil.extractTinkerEntry(tinkerZipFile2, entry2, tinkerZipOutputStream);
                            }
                            i3++;
                            file7 = file8;
                        }
                        file8 = file7;
                        it = shareResPatchInfo.modRes.iterator();
                        while (it.hasNext()) {
                            str4 = (String) it.next();
                            entry2 = tinkerZipFile2.getEntry(str4);
                            if (entry2 == null) {
                                str3 = TAG;
                                stringBuilder2 = new StringBuilder("mod patch entry is null. path:");
                                stringBuilder2.append(str4);
                                TinkerLog.w(str3, stringBuilder2.toString(), new Object[0]);
                                with.getPatchReporter().onPatchTypeExtractFail(file2, file8, str4, i2);
                                tinkerZipOutputStream.close();
                                tinkerZipFile.close();
                                tinkerZipFile2.close();
                                SharePatchFileUtil.deleteDir(file4);
                                return false;
                            }
                            if (shareResPatchInfo.storeRes.containsKey(str4)) {
                                TinkerZipUtil.extractLargeModifyFile(entry2, (File) shareResPatchInfo.storeRes.get(str4), entry2.getCrc(), tinkerZipOutputStream);
                            } else {
                                TinkerZipUtil.extractTinkerEntry(tinkerZipFile2, entry2, tinkerZipOutputStream);
                            }
                            i3++;
                        }
                        tinkerZipOutputStream.setComment(tinkerZipFile.getComment());
                        tinkerZipOutputStream.close();
                        tinkerZipFile.close();
                        tinkerZipFile2.close();
                        SharePatchFileUtil.deleteDir(file4);
                        if (SharePatchFileUtil.checkResourceArscMd5(file8, shareResPatchInfo.resArscMd5)) {
                            TinkerLog.i(TAG, "final new resource file:%s, entry count:%d, size:%d", file8.getAbsolutePath(), Integer.valueOf(i3), Long.valueOf(file8.length()));
                            return true;
                        }
                        TinkerLog.i(TAG, "check final new resource file fail path:%s, entry count:%d, size:%d", file8.getAbsolutePath(), Integer.valueOf(i3), Long.valueOf(file8.length()));
                        SharePatchFileUtil.safeDeleteFile(file8);
                        with.getPatchReporter().onPatchTypeExtractFail(file2, file8, ShareConstants.RES_NAME, i2);
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        tinkerZipFile2 = null;
                        th2 = th;
                        if (tinkerZipOutputStream != null) {
                            tinkerZipOutputStream.close();
                        }
                        if (tinkerZipFile != null) {
                            tinkerZipFile.close();
                        }
                        if (tinkerZipFile2 != null) {
                            tinkerZipFile2.close();
                        }
                        SharePatchFileUtil.deleteDir(file4);
                        throw th2;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    tinkerZipOutputStream = null;
                    tinkerZipFile = tinkerZipOutputStream;
                    tinkerZipFile2 = tinkerZipFile;
                    th2 = th;
                    if (tinkerZipOutputStream != null) {
                        tinkerZipOutputStream.close();
                    }
                    if (tinkerZipFile != null) {
                        tinkerZipFile.close();
                    }
                    if (tinkerZipFile2 != null) {
                        tinkerZipFile2.close();
                    }
                    SharePatchFileUtil.deleteDir(file4);
                    throw th2;
                }
            } catch (Throwable th6) {
                th2 = th6;
                StringBuilder stringBuilder3 = new StringBuilder("patch ");
                stringBuilder3.append(ShareTinkerInternals.getTypeString(i));
                stringBuilder3.append(" extract failed (");
                stringBuilder3.append(th2.getMessage());
                stringBuilder3.append(").");
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException(stringBuilder3.toString(), th2);
            }
        } else {
            TinkerLog.w(TAG, "resource meta file md5 mismatch, type:%s, md5: %s", ShareTinkerInternals.getTypeString(i), shareResPatchInfo.resArscMd5);
            with.getPatchReporter().onPatchPackageCheckFail(file2, BasePatchInternal.getMetaCorruptedCode(i));
            return false;
        }
    }

    private static boolean checkAndExtractResourceLargeFile(Context context, String str, File file, File file2, File file3, ShareResPatchInfo shareResPatchInfo, int i) {
        Throwable th;
        Throwable th2;
        ZipFile zipFile;
        File file4 = file2;
        File file5 = file3;
        ShareResPatchInfo shareResPatchInfo2 = shareResPatchInfo;
        int i2 = i;
        long currentTimeMillis = System.currentTimeMillis();
        Tinker with = Tinker.with(context);
        String str2 = null;
        ZipFile zipFile2;
        StringBuilder stringBuilder;
        ZipFile zipFile3;
        try {
            ZipFile zipFile4;
            Closeable inputStream;
            Closeable inputStream2;
            ZipFile zipFile5 = new ZipFile(str);
            try {
                ZipEntry entry = zipFile5.getEntry(ShareConstants.RES_ARSC);
                File file6 = new File(file, ShareConstants.RES_ARSC);
                boolean z = false;
                if (entry == null) {
                    try {
                        TinkerLog.w(TAG, "resources apk entry is null. path:resources.arsc", new Object[0]);
                        with.getPatchReporter().onPatchTypeExtractFail(file5, file6, ShareConstants.RES_ARSC, i2);
                        SharePatchFileUtil.closeZip(zipFile5);
                        SharePatchFileUtil.closeZip(null);
                        return false;
                    } catch (Throwable th22) {
                        th = th22;
                        zipFile2 = null;
                        zipFile3 = zipFile5;
                        SharePatchFileUtil.closeZip(zipFile3);
                        SharePatchFileUtil.closeZip(zipFile2);
                        throw th;
                    }
                }
                if (String.valueOf(entry.getCrc()).equals(shareResPatchInfo2.arscBaseCrc)) {
                    if (shareResPatchInfo2.largeModRes.isEmpty()) {
                        if (shareResPatchInfo2.storeRes.isEmpty()) {
                            TinkerLog.i(TAG, "no large modify or store resources, just return", new Object[0]);
                            SharePatchFileUtil.closeZip(zipFile5);
                            SharePatchFileUtil.closeZip(null);
                            return true;
                        }
                    }
                    zipFile2 = new ZipFile(file5);
                    try {
                        String str3;
                        long j;
                        for (String str4 : shareResPatchInfo2.storeRes.keySet()) {
                            try {
                                String str42;
                                long currentTimeMillis2 = System.currentTimeMillis();
                                File file7 = new File(file4, str42);
                                SharePatchFileUtil.ensureFileDirectory(file7);
                                ZipEntry entry2 = zipFile2.getEntry(str42);
                                if (entry2 == null) {
                                    try {
                                        str3 = TAG;
                                        stringBuilder = new StringBuilder("store patch entry is null. path:");
                                        stringBuilder.append(str42);
                                        TinkerLog.w(str3, stringBuilder.toString(), new Object[z]);
                                        with.getPatchReporter().onPatchTypeExtractFail(file5, file7, str42, i2);
                                        SharePatchFileUtil.closeZip(zipFile5);
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        return z;
                                    } catch (Throwable th222) {
                                        th = th222;
                                        zipFile3 = zipFile5;
                                        SharePatchFileUtil.closeZip(zipFile3);
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        throw th;
                                    }
                                }
                                BasePatchInternal.extract(zipFile2, entry2, file7, str2, z);
                                if (entry2.getSize() != file7.length()) {
                                    TinkerLog.w(TAG, "resource meta file size mismatch, type:%s, name: %s, patch size: %d, file size; %d", ShareTinkerInternals.getTypeString(i), str42, Long.valueOf(entry2.getSize()), Long.valueOf(file7.length()));
                                    with.getPatchReporter().onPatchPackageCheckFail(file5, BasePatchInternal.getMetaCorruptedCode(i));
                                    SharePatchFileUtil.closeZip(zipFile5);
                                    SharePatchFileUtil.closeZip(zipFile2);
                                    return false;
                                }
                                shareResPatchInfo2.storeRes.put(str42, file7);
                                String str5 = TAG;
                                str42 = "success recover store file:%s, file size:%d, use time:%d";
                                Object[] objArr = new Object[3];
                                objArr[0] = file7.getPath();
                                zipFile4 = zipFile5;
                                try {
                                    objArr[1] = Long.valueOf(file7.length());
                                    j = currentTimeMillis;
                                    objArr[2] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis2);
                                    TinkerLog.w(str5, str42, objArr);
                                    zipFile5 = zipFile4;
                                    currentTimeMillis = j;
                                    str2 = null;
                                    z = false;
                                } catch (Throwable th3) {
                                    th222 = th3;
                                }
                            } catch (Throwable th4) {
                                th222 = th4;
                                zipFile4 = zipFile5;
                            }
                        }
                        j = currentTimeMillis;
                        zipFile4 = zipFile5;
                        try {
                            Iterator it = shareResPatchInfo2.largeModRes.iterator();
                            while (it.hasNext()) {
                                String str6 = (String) it.next();
                                long currentTimeMillis3 = System.currentTimeMillis();
                                LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo2.largeModMap.get(str6);
                                if (largeModeInfo == null) {
                                    TinkerLog.w(TAG, "resource not found largeModeInfo, type:%s, name: %s", ShareTinkerInternals.getTypeString(i), str6);
                                    with.getPatchReporter().onPatchPackageCheckFail(file5, BasePatchInternal.getMetaCorruptedCode(i));
                                    SharePatchFileUtil.closeZip(zipFile4);
                                    SharePatchFileUtil.closeZip(zipFile2);
                                    return false;
                                }
                                zipFile3 = zipFile4;
                                try {
                                    largeModeInfo.file = new File(file4, str6);
                                    SharePatchFileUtil.ensureFileDirectory(largeModeInfo.file);
                                    if (SharePatchFileUtil.checkIfMd5Valid(largeModeInfo.md5)) {
                                        ZipEntry entry3 = zipFile2.getEntry(str6);
                                        if (entry3 == null) {
                                            str3 = TAG;
                                            stringBuilder = new StringBuilder("large mod patch entry is null. path:");
                                            stringBuilder.append(str6);
                                            TinkerLog.w(str3, stringBuilder.toString(), new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file5, largeModeInfo.file, str6, i2);
                                            SharePatchFileUtil.closeZip(zipFile3);
                                            SharePatchFileUtil.closeZip(zipFile2);
                                            return false;
                                        }
                                        ZipEntry entry4 = zipFile3.getEntry(str6);
                                        if (entry4 == null) {
                                            str3 = TAG;
                                            stringBuilder = new StringBuilder("resources apk entry is null. path:");
                                            stringBuilder.append(str6);
                                            TinkerLog.w(str3, stringBuilder.toString(), new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file5, largeModeInfo.file, str6, i2);
                                            SharePatchFileUtil.closeZip(zipFile3);
                                            SharePatchFileUtil.closeZip(zipFile2);
                                            return false;
                                        }
                                        try {
                                            inputStream = zipFile3.getInputStream(entry4);
                                            try {
                                                inputStream2 = zipFile2.getInputStream(entry3);
                                                try {
                                                    BSPatch.patchFast(inputStream, inputStream2, largeModeInfo.file);
                                                    SharePatchFileUtil.closeQuietly(inputStream);
                                                    SharePatchFileUtil.closeQuietly(inputStream2);
                                                    if (SharePatchFileUtil.verifyFileMd5(largeModeInfo.file, largeModeInfo.md5)) {
                                                        TinkerLog.w(TAG, "success recover large modify file:%s, file size:%d, use time:%d", largeModeInfo.file.getPath(), Long.valueOf(largeModeInfo.file.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                                        zipFile4 = zipFile3;
                                                        file4 = file2;
                                                        file5 = file3;
                                                        shareResPatchInfo2 = shareResPatchInfo;
                                                        i2 = i;
                                                    } else {
                                                        TinkerLog.w(TAG, "Failed to recover large modify file:%s", largeModeInfo.file.getPath());
                                                        SharePatchFileUtil.safeDeleteFile(largeModeInfo.file);
                                                        with.getPatchReporter().onPatchTypeExtractFail(file5, largeModeInfo.file, str6, i2);
                                                        SharePatchFileUtil.closeZip(zipFile3);
                                                        SharePatchFileUtil.closeZip(zipFile2);
                                                        return false;
                                                    }
                                                } catch (Throwable th2222) {
                                                    th = th2222;
                                                }
                                            } catch (Throwable th22222) {
                                                th = th22222;
                                                inputStream2 = null;
                                            }
                                        } catch (Throwable th222222) {
                                            th = th222222;
                                            inputStream2 = null;
                                            inputStream = null;
                                        }
                                    } else {
                                        TinkerLog.w(TAG, "resource meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), str6, largeModeInfo.md5);
                                        with.getPatchReporter().onPatchPackageCheckFail(file5, BasePatchInternal.getMetaCorruptedCode(i));
                                        SharePatchFileUtil.closeZip(zipFile3);
                                        SharePatchFileUtil.closeZip(zipFile2);
                                        return false;
                                    }
                                } catch (Throwable th5) {
                                    th222222 = th5;
                                }
                            }
                            zipFile3 = zipFile4;
                            TinkerLog.w(TAG, "success recover all large modify and store resources use time:%d", Long.valueOf(System.currentTimeMillis() - j));
                            SharePatchFileUtil.closeZip(zipFile3);
                            SharePatchFileUtil.closeZip(zipFile2);
                            return true;
                        } catch (Throwable th6) {
                            th222222 = th6;
                            zipFile3 = zipFile4;
                            th = th222222;
                            SharePatchFileUtil.closeZip(zipFile3);
                            SharePatchFileUtil.closeZip(zipFile2);
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th222222 = th7;
                        zipFile3 = zipFile5;
                        th = th222222;
                        SharePatchFileUtil.closeZip(zipFile3);
                        SharePatchFileUtil.closeZip(zipFile2);
                        throw th;
                    }
                }
                TinkerLog.e(TAG, "resources.arsc's crc is not equal, expect crc: %s, got crc: %s", shareResPatchInfo2.arscBaseCrc, String.valueOf(entry.getCrc()));
                with.getPatchReporter().onPatchTypeExtractFail(file5, file6, ShareConstants.RES_ARSC, i2);
                SharePatchFileUtil.closeZip(zipFile5);
                SharePatchFileUtil.closeZip(null);
                return false;
            } catch (Throwable th2222222) {
                zipFile3 = zipFile5;
                th = th2222222;
                zipFile2 = null;
                SharePatchFileUtil.closeZip(zipFile3);
                SharePatchFileUtil.closeZip(zipFile2);
                throw th;
            }
            th = th2222222;
            zipFile3 = zipFile4;
            SharePatchFileUtil.closeZip(zipFile3);
            SharePatchFileUtil.closeZip(zipFile2);
            throw th;
            SharePatchFileUtil.closeQuietly(inputStream);
            SharePatchFileUtil.closeQuietly(inputStream2);
            throw th;
            th = th2222222;
            zipFile = zipFile4;
            stringBuilder = new StringBuilder("patch ");
            stringBuilder.append(ShareTinkerInternals.getTypeString(i));
            stringBuilder.append(" extract failed (");
            stringBuilder.append(th.getMessage());
            stringBuilder.append(").");
            throw new TinkerRuntimeException(stringBuilder.toString(), th);
        } catch (Throwable th22222222) {
            th = th22222222;
            zipFile2 = null;
            zipFile3 = null;
            SharePatchFileUtil.closeZip(zipFile3);
            SharePatchFileUtil.closeZip(zipFile2);
            throw th;
        }
    }
}
