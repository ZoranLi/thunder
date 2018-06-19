package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

/* compiled from: BUGLY */
public class SharePatchFileUtil {
    private static final String TAG = "Tinker.PatchFileUtil";
    private static char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static File getPatchDirectory(Context context) {
        context = context.getApplicationInfo();
        if (context == null) {
            return null;
        }
        return new File(context.dataDir, ShareConstants.PATCH_DIRECTORY_NAME);
    }

    public static File getPatchTempDirectory(Context context) {
        context = context.getApplicationInfo();
        if (context == null) {
            return null;
        }
        return new File(context.dataDir, ShareConstants.PATCH_TEMP_DIRECTORY_NAME);
    }

    public static File getPatchLastCrashFile(Context context) {
        context = getPatchTempDirectory(context);
        if (context == null) {
            return null;
        }
        return new File(context, ShareConstants.PATCH_TEMP_LAST_CRASH_NAME);
    }

    public static File getPatchInfoFile(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/patch.info");
        return new File(stringBuilder.toString());
    }

    public static File getPatchInfoLockFile(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/info.lock");
        return new File(stringBuilder.toString());
    }

    public static String getPatchVersionDirectory(String str) {
        if (str != null) {
            if (str.length() == 32) {
                StringBuilder stringBuilder = new StringBuilder(ShareConstants.PATCH_BASE_NAME);
                stringBuilder.append(str.substring(0, 8));
                return stringBuilder.toString();
            }
        }
        return null;
    }

    public static String getPatchVersionFile(String str) {
        if (str != null) {
            if (str.length() == 32) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getPatchVersionDirectory(str));
                stringBuilder.append(ShareConstants.PATCH_SUFFIX);
                return stringBuilder.toString();
            }
        }
        return null;
    }

    public static boolean checkIfMd5Valid(String str) {
        if (str != null) {
            if (str.length() == 32) {
                return true;
            }
        }
        return null;
    }

    public static String checkTinkerLastUncaughtCrash(Context context) {
        context = getPatchLastCrashFile(context);
        if (!isLegalFile(context)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(context)));
            while (true) {
                try {
                    context = bufferedReader.readLine();
                    if (context != null) {
                        stringBuffer.append(context);
                        stringBuffer.append("\n");
                    } else {
                        closeQuietly(bufferedReader);
                        return stringBuffer.toString();
                    }
                } catch (Exception e) {
                    context = e;
                }
            }
        } catch (Exception e2) {
            context = e2;
            bufferedReader = null;
            try {
                new StringBuilder("checkTinkerLastUncaughtCrash exception: ").append(context);
                closeQuietly(bufferedReader);
                return null;
            } catch (Throwable th) {
                context = th;
                closeQuietly(bufferedReader);
                throw context;
            }
        } catch (Throwable th2) {
            context = th2;
            bufferedReader = null;
            closeQuietly(bufferedReader);
            throw context;
        }
    }

    public static final boolean isLegalFile(File file) {
        return (file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0) ? true : null;
    }

    public static long getFileOrDirectorySize(File file) {
        long j = 0;
        if (file != null) {
            if (file.exists()) {
                if (file.isFile()) {
                    return file.length();
                }
                file = file.listFiles();
                if (file != null) {
                    for (File file2 : file) {
                        long fileOrDirectorySize;
                        if (file2.isDirectory()) {
                            fileOrDirectorySize = j + getFileOrDirectorySize(file2);
                        } else {
                            fileOrDirectorySize = j + file2.length();
                        }
                        j = fileOrDirectorySize;
                    }
                }
                return j;
            }
        }
        return 0;
    }

    public static final boolean safeDeleteFile(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        new StringBuilder("safeDeleteFile, try to delete path: ").append(file.getPath());
        boolean delete = file.delete();
        if (!delete) {
            new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(file.getPath());
            file.deleteOnExit();
        }
        return delete;
    }

    public static final boolean deleteDir(String str) {
        return str == null ? null : deleteDir(new File(str));
    }

    public static final boolean deleteDir(File file) {
        int i = 0;
        if (file != null) {
            if (file.exists()) {
                if (file.isFile()) {
                    safeDeleteFile(file);
                } else if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        while (i < length) {
                            deleteDir(listFiles[i]);
                            i++;
                        }
                        safeDeleteFile(file);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean verifyFileMd5(File file, String str) {
        if (str == null) {
            return false;
        }
        file = getMD5(file);
        if (file == null) {
            return false;
        }
        return str.equals(file);
    }

    public static boolean isRawDexFile(String str) {
        return str == null ? null : str.endsWith(ShareConstants.DEX_SUFFIX);
    }

    public static boolean verifyDexFileMd5(File file, String str) {
        return verifyDexFileMd5(file, "classes.dex", str);
    }

    public static boolean verifyDexFileMd5(java.io.File r3, java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x0067;
    L_0x0003:
        if (r5 == 0) goto L_0x0067;
    L_0x0005:
        if (r4 != 0) goto L_0x0008;
    L_0x0007:
        goto L_0x0067;
    L_0x0008:
        r1 = r3.getName();
        r1 = isRawDexFile(r1);
        if (r1 == 0) goto L_0x0017;
    L_0x0012:
        r3 = getMD5(r3);
        goto L_0x0041;
    L_0x0017:
        r1 = 0;
        r2 = new java.util.zip.ZipFile;	 Catch:{ Throwable -> 0x004d }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x004d }
        r4 = r2.getEntry(r4);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        if (r4 != 0) goto L_0x0035;	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
    L_0x0023:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r5 = "There's no entry named: classes.dex in ";	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r5 = r3.getAbsolutePath();	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r2.close();	 Catch:{ Throwable -> 0x0034 }
    L_0x0034:
        return r0;
    L_0x0035:
        r4 = r2.getInputStream(r4);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r4 = getMD5(r4);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r2.close();	 Catch:{ Throwable -> 0x0040 }
    L_0x0040:
        r3 = r4;
    L_0x0041:
        r3 = r5.equals(r3);
        return r3;
    L_0x0046:
        r3 = move-exception;
        goto L_0x0061;
    L_0x0048:
        r1 = r2;
        goto L_0x004d;
    L_0x004a:
        r3 = move-exception;
        r2 = r1;
        goto L_0x0061;
    L_0x004d:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004a }
        r5 = "Bad dex jar file: ";	 Catch:{ all -> 0x004a }
        r4.<init>(r5);	 Catch:{ all -> 0x004a }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x004a }
        r4.append(r3);	 Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x0060;
    L_0x005d:
        r1.close();	 Catch:{ Throwable -> 0x0060 }
    L_0x0060:
        return r0;
    L_0x0061:
        if (r2 == 0) goto L_0x0066;
    L_0x0063:
        r2.close();	 Catch:{ Throwable -> 0x0066 }
    L_0x0066:
        throw r3;
    L_0x0067:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchFileUtil.verifyDexFileMd5(java.io.File, java.lang.String, java.lang.String):boolean");
    }

    public static void copyFileUsingStream(File file, File file2) throws IOException {
        Closeable fileInputStream;
        if (isLegalFile(file)) {
            if (file2 != null) {
                if (!file.getAbsolutePath().equals(file2.getAbsolutePath())) {
                    File parentFile = file2.getParentFile();
                    if (!(parentFile == null || parentFile.exists())) {
                        parentFile.mkdirs();
                    }
                    Closeable closeable = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            file = new FileOutputStream(file2, false);
                        } catch (Throwable th) {
                            file2 = th;
                            closeQuietly(fileInputStream);
                            closeQuietly(closeable);
                            throw file2;
                        }
                        try {
                            file2 = new byte[16384];
                            while (true) {
                                int read = fileInputStream.read(file2);
                                if (read > 0) {
                                    file.write(file2, 0, read);
                                } else {
                                    closeQuietly(fileInputStream);
                                    closeQuietly(file);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            file2 = th2;
                            closeable = file;
                            closeQuietly(fileInputStream);
                            closeQuietly(closeable);
                            throw file2;
                        }
                    } catch (Throwable th3) {
                        file2 = th3;
                        fileInputStream = null;
                        closeQuietly(fileInputStream);
                        closeQuietly(closeable);
                        throw file2;
                    }
                }
            }
        }
    }

    public static String loadDigestes(JarFile jarFile, JarEntry jarEntry) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        Closeable closeable = null;
        try {
            jarFile = jarFile.getInputStream(jarEntry);
            jarEntry = new byte[16384];
            Closeable bufferedInputStream = new BufferedInputStream(jarFile);
            while (true) {
                try {
                    jarFile = bufferedInputStream.read(jarEntry);
                    if (jarFile > null) {
                        stringBuilder.append(new String(jarEntry, 0, jarFile));
                    } else {
                        closeQuietly(bufferedInputStream);
                        return stringBuilder.toString();
                    }
                } catch (Throwable th) {
                    jarFile = th;
                    closeable = bufferedInputStream;
                }
            }
        } catch (Throwable th2) {
            jarFile = th2;
            closeQuietly(closeable);
            throw jarFile;
        }
    }

    public static final java.lang.String getMD5(java.io.InputStream r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x004a }
        r1.<init>(r7);	 Catch:{ Exception -> 0x004a }
        r7 = "MD5";	 Catch:{ Exception -> 0x004a }
        r7 = java.security.MessageDigest.getInstance(r7);	 Catch:{ Exception -> 0x004a }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004a }
        r3 = 32;	 Catch:{ Exception -> 0x004a }
        r2.<init>(r3);	 Catch:{ Exception -> 0x004a }
        r3 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;	 Catch:{ Exception -> 0x004a }
        r3 = new byte[r3];	 Catch:{ Exception -> 0x004a }
    L_0x001b:
        r4 = r1.read(r3);	 Catch:{ Exception -> 0x004a }
        r5 = -1;	 Catch:{ Exception -> 0x004a }
        r6 = 0;	 Catch:{ Exception -> 0x004a }
        if (r4 == r5) goto L_0x0027;	 Catch:{ Exception -> 0x004a }
    L_0x0023:
        r7.update(r3, r6, r4);	 Catch:{ Exception -> 0x004a }
        goto L_0x001b;	 Catch:{ Exception -> 0x004a }
    L_0x0027:
        r7 = r7.digest();	 Catch:{ Exception -> 0x004a }
    L_0x002b:
        r1 = r7.length;	 Catch:{ Exception -> 0x004a }
        if (r6 >= r1) goto L_0x0045;	 Catch:{ Exception -> 0x004a }
    L_0x002e:
        r1 = r7[r6];	 Catch:{ Exception -> 0x004a }
        r1 = r1 & 255;	 Catch:{ Exception -> 0x004a }
        r1 = r1 + 256;	 Catch:{ Exception -> 0x004a }
        r3 = 16;	 Catch:{ Exception -> 0x004a }
        r1 = java.lang.Integer.toString(r1, r3);	 Catch:{ Exception -> 0x004a }
        r3 = 1;	 Catch:{ Exception -> 0x004a }
        r1 = r1.substring(r3);	 Catch:{ Exception -> 0x004a }
        r2.append(r1);	 Catch:{ Exception -> 0x004a }
        r6 = r6 + 1;	 Catch:{ Exception -> 0x004a }
        goto L_0x002b;	 Catch:{ Exception -> 0x004a }
    L_0x0045:
        r7 = r2.toString();	 Catch:{ Exception -> 0x004a }
        return r7;
    L_0x004a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchFileUtil.getMD5(java.io.InputStream):java.lang.String");
    }

    public static java.lang.String getMD5(byte[] r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "MD5";	 Catch:{ Exception -> 0x0037 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x0037 }
        r0.update(r8);	 Catch:{ Exception -> 0x0037 }
        r8 = r0.digest();	 Catch:{ Exception -> 0x0037 }
        r0 = r8.length;	 Catch:{ Exception -> 0x0037 }
        r1 = r0 * 2;	 Catch:{ Exception -> 0x0037 }
        r1 = new char[r1];	 Catch:{ Exception -> 0x0037 }
        r2 = 0;	 Catch:{ Exception -> 0x0037 }
        r3 = r2;	 Catch:{ Exception -> 0x0037 }
    L_0x0014:
        if (r2 >= r0) goto L_0x0031;	 Catch:{ Exception -> 0x0037 }
    L_0x0016:
        r4 = r8[r2];	 Catch:{ Exception -> 0x0037 }
        r5 = r3 + 1;	 Catch:{ Exception -> 0x0037 }
        r6 = hexDigits;	 Catch:{ Exception -> 0x0037 }
        r7 = r4 >>> 4;	 Catch:{ Exception -> 0x0037 }
        r7 = r7 & 15;	 Catch:{ Exception -> 0x0037 }
        r6 = r6[r7];	 Catch:{ Exception -> 0x0037 }
        r1[r3] = r6;	 Catch:{ Exception -> 0x0037 }
        r3 = r5 + 1;	 Catch:{ Exception -> 0x0037 }
        r6 = hexDigits;	 Catch:{ Exception -> 0x0037 }
        r4 = r4 & 15;	 Catch:{ Exception -> 0x0037 }
        r4 = r6[r4];	 Catch:{ Exception -> 0x0037 }
        r1[r5] = r4;	 Catch:{ Exception -> 0x0037 }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x0037 }
        goto L_0x0014;	 Catch:{ Exception -> 0x0037 }
    L_0x0031:
        r8 = new java.lang.String;	 Catch:{ Exception -> 0x0037 }
        r8.<init>(r1);	 Catch:{ Exception -> 0x0037 }
        return r8;
    L_0x0037:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchFileUtil.getMD5(byte[]):java.lang.String");
    }

    public static java.lang.String getMD5(java.io.File r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 == 0) goto L_0x0024;
    L_0x0003:
        r1 = r2.exists();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0024;
    L_0x000a:
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r1.<init>(r2);	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r2 = getMD5(r1);	 Catch:{ Exception -> 0x0020, all -> 0x0017 }
        closeQuietly(r1);
        return r2;
    L_0x0017:
        r2 = move-exception;
        r0 = r1;
        goto L_0x001b;
    L_0x001a:
        r2 = move-exception;
    L_0x001b:
        closeQuietly(r0);
        throw r2;
    L_0x001f:
        r1 = r0;
    L_0x0020:
        closeQuietly(r1);
        return r0;
    L_0x0024:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchFileUtil.getMD5(java.io.File):java.lang.String");
    }

    public static String optimizedPathFor(File file, File file2) {
        if (ShareTinkerInternals.isAfterAndroidO()) {
            try {
                file2 = ShareTinkerInternals.getCurrentInstructionSet();
                File parentFile = file.getParentFile();
                file = file.getName();
                int lastIndexOf = file.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    file = file.substring(0, lastIndexOf);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(parentFile.getAbsolutePath());
                stringBuilder.append("/oat/");
                stringBuilder.append(file2);
                stringBuilder.append("/");
                stringBuilder.append(file);
                stringBuilder.append(ShareConstants.ODEX_SUFFIX);
                return stringBuilder.toString();
            } catch (File file3) {
                throw new TinkerRuntimeException("getCurrentInstructionSet fail:", file3);
            }
        }
        file3 = file3.getName();
        if (!file3.endsWith(ShareConstants.DEX_SUFFIX)) {
            int lastIndexOf2 = file3.lastIndexOf(".");
            if (lastIndexOf2 < 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(file3);
                stringBuilder2.append(ShareConstants.DEX_SUFFIX);
                file3 = stringBuilder2.toString();
            } else {
                StringBuilder stringBuilder3 = new StringBuilder(lastIndexOf2 + 4);
                stringBuilder3.append(file3, 0, lastIndexOf2);
                stringBuilder3.append(ShareConstants.DEX_SUFFIX);
                file3 = stringBuilder3.toString();
            }
        }
        return new File(file2, file3).getPath();
    }

    public static void closeQuietly(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0007;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0006 }
        goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchFileUtil.closeQuietly(java.io.Closeable):void");
    }

    public static void closeZip(java.util.zip.ZipFile r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0007;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0006 }
        goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchFileUtil.closeZip(java.util.zip.ZipFile):void");
    }

    public static boolean checkResourceArscMd5(File file, String str) {
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                file = zipFile2.getEntry(ShareConstants.RES_ARSC);
                if (file == null) {
                    closeZip(zipFile2);
                    return false;
                }
                try {
                    file = zipFile2.getInputStream(file);
                    try {
                        String md5 = getMD5((InputStream) file);
                        if (md5 == null || md5.equals(str) == null) {
                            closeQuietly(file);
                            closeZip(zipFile2);
                            return false;
                        }
                        closeQuietly(file);
                        closeZip(zipFile2);
                        return true;
                    } catch (Throwable th) {
                        str = th;
                        closeQuietly(file);
                        throw str;
                    }
                } catch (Throwable th2) {
                    str = th2;
                    file = null;
                    closeQuietly(file);
                    throw str;
                }
            } catch (Throwable th3) {
                file = th3;
                zipFile = zipFile2;
                closeZip(zipFile);
                throw file;
            }
        } catch (Throwable th4) {
            file = th4;
            new StringBuilder("checkResourceArscMd5 throwable:").append(file.getMessage());
            closeZip(zipFile);
            return false;
        }
    }

    public static void ensureFileDirectory(File file) {
        if (file != null) {
            file = file.getParentFile();
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }
}
