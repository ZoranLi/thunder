package com.tencent.tinker.lib.patch;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import com.tencent.tinker.bsdiff.BSPatch;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: BUGLY */
public class BsDiffPatchInternal extends BasePatchInternal {
    private static final String TAG = "Tinker.BsDiffPatchInternal";

    protected static boolean tryRecoverLibraryFiles(Tinker tinker, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (tinker.isEnabledForNativeLib() == null) {
            TinkerLog.w(TAG, "patch recover, library is not enabled", new Object[0]);
            return true;
        }
        String str2 = (String) shareSecurityCheck.getMetaContentMap().get(ShareConstants.SO_META_FILE);
        if (str2 == null) {
            TinkerLog.w(TAG, "patch recover, library is not contained", new Object[0]);
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tinker = patchLibraryExtractViaBsDiff(context, str, str2, file);
        str = SystemClock.elapsedRealtime() - elapsedRealtime;
        TinkerLog.i(TAG, "recover lib result:%b, cost:%d", Boolean.valueOf(tinker), Long.valueOf(str));
        return tinker;
    }

    private static boolean patchLibraryExtractViaBsDiff(Context context, String str, String str2, File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/lib/");
        return extractBsDiffInternals(context, stringBuilder.toString(), str2, file, 5);
    }

    private static boolean extractBsDiffInternals(Context context, String str, String str2, File file, int i) {
        StringBuilder stringBuilder;
        Throwable th;
        Closeable closeable;
        Throwable th2;
        ZipFile zipFile;
        String str3 = str;
        File file2 = file;
        int i2 = i;
        ArrayList arrayList = new ArrayList();
        ShareBsDiffPatchInfo.parseDiffPatchInfo(str2, arrayList);
        boolean z = false;
        if (arrayList.isEmpty()) {
            TinkerLog.w(TAG, "extract patch list is empty! type:%s:", ShareTinkerInternals.getTypeString(i));
            return true;
        }
        File file3 = new File(str3);
        if (!file3.exists()) {
            file3.mkdirs();
        }
        Tinker with = Tinker.with(context);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            TinkerLog.w(TAG, "applicationInfo == null!!!!", new Object[0]);
            return false;
        }
        Closeable inputStream;
        ZipFile zipFile2;
        ZipFile zipFile3;
        try {
            zipFile2 = new ZipFile(applicationInfo.sourceDir);
            try {
                zipFile3 = new ZipFile(file2);
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str4;
                        ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (shareBsDiffPatchInfo.path.equals("")) {
                            str4 = shareBsDiffPatchInfo.name;
                        } else {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(shareBsDiffPatchInfo.path);
                            stringBuilder2.append("/");
                            stringBuilder2.append(shareBsDiffPatchInfo.name);
                            str4 = stringBuilder2.toString();
                        }
                        String str5 = shareBsDiffPatchInfo.md5;
                        if (SharePatchFileUtil.checkIfMd5Valid(str5)) {
                            Iterator it2;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(shareBsDiffPatchInfo.path);
                            stringBuilder3.append("/");
                            stringBuilder3.append(shareBsDiffPatchInfo.name);
                            String stringBuilder4 = stringBuilder3.toString();
                            StringBuilder stringBuilder5 = new StringBuilder();
                            stringBuilder5.append(str3);
                            stringBuilder5.append(stringBuilder4);
                            File file4 = new File(stringBuilder5.toString());
                            if (!file4.exists()) {
                                it2 = it;
                                file4.getParentFile().mkdirs();
                            } else if (str5.equals(SharePatchFileUtil.getMD5(file4))) {
                                TinkerLog.w(TAG, "bsdiff file %s is already exist, and md5 match, just continue", file4.getPath());
                                z = false;
                            } else {
                                stringBuilder4 = TAG;
                                stringBuilder5 = new StringBuilder("have a mismatch corrupted dex ");
                                stringBuilder5.append(file4.getPath());
                                it2 = it;
                                TinkerLog.w(stringBuilder4, stringBuilder5.toString(), new Object[0]);
                                file4.delete();
                            }
                            str3 = shareBsDiffPatchInfo.patchMd5;
                            ZipEntry entry = zipFile3.getEntry(str4);
                            if (entry == null) {
                                str3 = TAG;
                                stringBuilder = new StringBuilder("patch entry is null. path:");
                                stringBuilder.append(str4);
                                TinkerLog.w(str3, stringBuilder.toString(), new Object[0]);
                                with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareBsDiffPatchInfo.name, i2);
                                SharePatchFileUtil.closeZip(zipFile2);
                                SharePatchFileUtil.closeZip(zipFile3);
                                return false;
                            }
                            boolean z2;
                            if (str3.equals("0")) {
                                if (BasePatchInternal.extract(zipFile3, entry, file4, str5, false)) {
                                    z2 = false;
                                } else {
                                    str3 = TAG;
                                    stringBuilder = new StringBuilder("Failed to extract file ");
                                    stringBuilder.append(file4.getPath());
                                    TinkerLog.w(str3, stringBuilder.toString(), new Object[0]);
                                    with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareBsDiffPatchInfo.name, i2);
                                    SharePatchFileUtil.closeZip(zipFile2);
                                    SharePatchFileUtil.closeZip(zipFile3);
                                    return false;
                                }
                            } else if (SharePatchFileUtil.checkIfMd5Valid(str3)) {
                                ZipEntry entry2 = zipFile2.getEntry(str4);
                                if (entry2 == null) {
                                    str3 = TAG;
                                    stringBuilder = new StringBuilder("apk entry is null. path:");
                                    stringBuilder.append(str4);
                                    TinkerLog.w(str3, stringBuilder.toString(), new Object[0]);
                                    with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareBsDiffPatchInfo.name, i2);
                                    SharePatchFileUtil.closeZip(zipFile2);
                                    SharePatchFileUtil.closeZip(zipFile3);
                                    return false;
                                }
                                stringBuilder4 = shareBsDiffPatchInfo.rawCrc;
                                long j = currentTimeMillis;
                                if (String.valueOf(entry2.getCrc()).equals(stringBuilder4)) {
                                    try {
                                        Closeable inputStream2 = zipFile2.getInputStream(entry2);
                                        try {
                                            inputStream = zipFile3.getInputStream(entry);
                                            try {
                                                BSPatch.patchFast(inputStream2, inputStream, file4);
                                                SharePatchFileUtil.closeQuietly(inputStream2);
                                                SharePatchFileUtil.closeQuietly(inputStream);
                                                if (SharePatchFileUtil.verifyFileMd5(file4, str5)) {
                                                    Object[] objArr = new Object[2];
                                                    String path = file4.getPath();
                                                    z2 = false;
                                                    objArr[0] = path;
                                                    objArr[1] = Long.valueOf(System.currentTimeMillis() - j);
                                                    TinkerLog.w(TAG, "success recover bsdiff file: %s, use time: %d", objArr);
                                                } else {
                                                    str3 = TAG;
                                                    stringBuilder = new StringBuilder("Failed to recover diff file ");
                                                    stringBuilder.append(file4.getPath());
                                                    TinkerLog.w(str3, stringBuilder.toString(), new Object[0]);
                                                    with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareBsDiffPatchInfo.name, i2);
                                                    SharePatchFileUtil.safeDeleteFile(file4);
                                                    SharePatchFileUtil.closeZip(zipFile2);
                                                    SharePatchFileUtil.closeZip(zipFile3);
                                                    return false;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                closeable = inputStream2;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            closeable = inputStream2;
                                            inputStream = null;
                                        }
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        closeable = null;
                                        inputStream = null;
                                    }
                                } else {
                                    TinkerLog.e(TAG, "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str4, stringBuilder4, String.valueOf(entry2.getCrc()));
                                    with.getPatchReporter().onPatchTypeExtractFail(file2, file4, shareBsDiffPatchInfo.name, i2);
                                    SharePatchFileUtil.closeZip(zipFile2);
                                    SharePatchFileUtil.closeZip(zipFile3);
                                    return false;
                                }
                            } else {
                                TinkerLog.w(TAG, "meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), shareBsDiffPatchInfo.name, str3);
                                with.getPatchReporter().onPatchPackageCheckFail(file2, BasePatchInternal.getMetaCorruptedCode(i));
                                SharePatchFileUtil.closeZip(zipFile2);
                                SharePatchFileUtil.closeZip(zipFile3);
                                return false;
                            }
                            z = z2;
                            it = it2;
                            str3 = str;
                        } else {
                            TinkerLog.w(TAG, "meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), shareBsDiffPatchInfo.name, shareBsDiffPatchInfo.md5);
                            with.getPatchReporter().onPatchPackageCheckFail(file2, BasePatchInternal.getMetaCorruptedCode(i));
                            SharePatchFileUtil.closeZip(zipFile2);
                            SharePatchFileUtil.closeZip(zipFile3);
                            return z;
                        }
                    }
                    SharePatchFileUtil.closeZip(zipFile2);
                    SharePatchFileUtil.closeZip(zipFile3);
                    return true;
                } catch (Throwable th52) {
                    th2 = th52;
                }
            } catch (Throwable th522) {
                th2 = th522;
                zipFile3 = null;
                SharePatchFileUtil.closeZip(zipFile2);
                SharePatchFileUtil.closeZip(zipFile3);
                throw th2;
            }
        } catch (Throwable th5222) {
            th2 = th5222;
            zipFile3 = null;
            zipFile2 = null;
            SharePatchFileUtil.closeZip(zipFile2);
            SharePatchFileUtil.closeZip(zipFile3);
            throw th2;
        }
        SharePatchFileUtil.closeQuietly(closeable);
        SharePatchFileUtil.closeQuietly(inputStream);
        throw th2;
        th2 = th5222;
        SharePatchFileUtil.closeQuietly(closeable);
        SharePatchFileUtil.closeQuietly(inputStream);
        throw th2;
    }
}
