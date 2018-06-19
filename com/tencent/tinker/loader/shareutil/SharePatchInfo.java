package com.tencent.tinker.loader.shareutil;

import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* compiled from: BUGLY */
public class SharePatchInfo {
    public static final String DEFAULT_DIR = "odex";
    public static final String FINGER_PRINT = "print";
    public static final int MAX_EXTRACT_ATTEMPTS = 2;
    public static final String NEW_VERSION = "new";
    public static final String OAT_DIR = "dir";
    public static final String OLD_VERSION = "old";
    private static final String TAG = "Tinker.PatchInfo";
    public String fingerPrint;
    public String newVersion;
    public String oatDir;
    public String oldVersion;

    public SharePatchInfo(String str, String str2, String str3, String str4) {
        this.oldVersion = str;
        this.newVersion = str2;
        this.fingerPrint = str3;
        this.oatDir = str4;
    }

    public static com.tencent.tinker.loader.shareutil.SharePatchInfo readAndCheckPropertyWithLock(java.io.File r3, java.io.File r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x0038;
    L_0x0003:
        if (r4 != 0) goto L_0x0006;
    L_0x0005:
        goto L_0x0038;
    L_0x0006:
        r1 = r4.getParentFile();
        r2 = r1.exists();
        if (r2 != 0) goto L_0x0013;
    L_0x0010:
        r1.mkdirs();
    L_0x0013:
        r4 = com.tencent.tinker.loader.shareutil.ShareFileLockHelper.getFileLock(r4);	 Catch:{ Exception -> 0x0029 }
        r3 = readAndCheckProperty(r3);	 Catch:{ Exception -> 0x0024, all -> 0x0021 }
        if (r4 == 0) goto L_0x0020;
    L_0x001d:
        r4.close();	 Catch:{ IOException -> 0x0020 }
    L_0x0020:
        return r3;
    L_0x0021:
        r3 = move-exception;
        r0 = r4;
        goto L_0x0032;
    L_0x0024:
        r3 = move-exception;
        r0 = r4;
        goto L_0x002a;
    L_0x0027:
        r3 = move-exception;
        goto L_0x0032;
    L_0x0029:
        r3 = move-exception;
    L_0x002a:
        r4 = new com.tencent.tinker.loader.TinkerRuntimeException;	 Catch:{ all -> 0x0027 }
        r1 = "readAndCheckPropertyWithLock fail";	 Catch:{ all -> 0x0027 }
        r4.<init>(r1, r3);	 Catch:{ all -> 0x0027 }
        throw r4;	 Catch:{ all -> 0x0027 }
    L_0x0032:
        if (r0 == 0) goto L_0x0037;
    L_0x0034:
        r0.close();	 Catch:{ IOException -> 0x0037 }
    L_0x0037:
        throw r3;
    L_0x0038:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchInfo.readAndCheckPropertyWithLock(java.io.File, java.io.File):com.tencent.tinker.loader.shareutil.SharePatchInfo");
    }

    public static boolean rewritePatchInfoFileWithLock(java.io.File r2, com.tencent.tinker.loader.shareutil.SharePatchInfo r3, java.io.File r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        if (r2 == 0) goto L_0x003a;
    L_0x0002:
        if (r3 == 0) goto L_0x003a;
    L_0x0004:
        if (r4 != 0) goto L_0x0007;
    L_0x0006:
        goto L_0x003a;
    L_0x0007:
        r0 = r4.getParentFile();
        r1 = r0.exists();
        if (r1 != 0) goto L_0x0014;
    L_0x0011:
        r0.mkdirs();
    L_0x0014:
        r0 = 0;
        r4 = com.tencent.tinker.loader.shareutil.ShareFileLockHelper.getFileLock(r4);	 Catch:{ Exception -> 0x002b }
        r2 = rewritePatchInfoFile(r2, r3);	 Catch:{ Exception -> 0x0026, all -> 0x0023 }
        if (r4 == 0) goto L_0x0022;
    L_0x001f:
        r4.close();	 Catch:{ IOException -> 0x0022 }
    L_0x0022:
        return r2;
    L_0x0023:
        r2 = move-exception;
        r0 = r4;
        goto L_0x0034;
    L_0x0026:
        r2 = move-exception;
        r0 = r4;
        goto L_0x002c;
    L_0x0029:
        r2 = move-exception;
        goto L_0x0034;
    L_0x002b:
        r2 = move-exception;
    L_0x002c:
        r3 = new com.tencent.tinker.loader.TinkerRuntimeException;	 Catch:{ all -> 0x0029 }
        r4 = "rewritePatchInfoFileWithLock fail";	 Catch:{ all -> 0x0029 }
        r3.<init>(r4, r2);	 Catch:{ all -> 0x0029 }
        throw r3;	 Catch:{ all -> 0x0029 }
    L_0x0034:
        if (r0 == 0) goto L_0x0039;
    L_0x0036:
        r0.close();	 Catch:{ IOException -> 0x0039 }
    L_0x0039:
        throw r2;
    L_0x003a:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchInfo.rewritePatchInfoFileWithLock(java.io.File, com.tencent.tinker.loader.shareutil.SharePatchInfo, java.io.File):boolean");
    }

    private static SharePatchInfo readAndCheckProperty(File file) {
        Closeable fileInputStream;
        String property;
        Object obj;
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        while (i < 2 && i2 == 0) {
            i++;
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    property = properties.getProperty("old");
                    try {
                        str = properties.getProperty("new");
                        try {
                            str2 = properties.getProperty(FINGER_PRINT);
                        } catch (IOException e) {
                            obj = e;
                            str2 = str;
                            try {
                                new StringBuilder("read property failed, e:").append(obj);
                                SharePatchFileUtil.closeQuietly(fileInputStream);
                                str = property;
                                if (!str.equals("")) {
                                }
                                i2 = 1;
                            } catch (Throwable th) {
                                file = th;
                            }
                        }
                        try {
                            str3 = properties.getProperty(OAT_DIR);
                            SharePatchFileUtil.closeQuietly(fileInputStream);
                            str4 = str3;
                            str3 = str2;
                            str2 = str;
                        } catch (IOException e2) {
                            obj = e2;
                            str3 = str2;
                            str2 = str;
                            new StringBuilder("read property failed, e:").append(obj);
                            SharePatchFileUtil.closeQuietly(fileInputStream);
                            str = property;
                            if (str.equals("")) {
                            }
                            i2 = 1;
                        }
                    } catch (IOException e3) {
                        obj = e3;
                        new StringBuilder("read property failed, e:").append(obj);
                        SharePatchFileUtil.closeQuietly(fileInputStream);
                        str = property;
                        if (str.equals("")) {
                        }
                        i2 = 1;
                    }
                } catch (IOException e4) {
                    obj = e4;
                    property = str;
                    new StringBuilder("read property failed, e:").append(obj);
                    SharePatchFileUtil.closeQuietly(fileInputStream);
                    str = property;
                    if (str.equals("")) {
                    }
                    i2 = 1;
                }
            } catch (IOException e5) {
                obj = e5;
                fileInputStream = null;
                property = str;
                new StringBuilder("read property failed, e:").append(obj);
                SharePatchFileUtil.closeQuietly(fileInputStream);
                str = property;
                if (str.equals("")) {
                }
                i2 = 1;
            } catch (Throwable th2) {
                file = th2;
                fileInputStream = null;
            }
            str = property;
            if (!(str == null || r4 == null)) {
                if ((str.equals("") || SharePatchFileUtil.checkIfMd5Valid(str)) && SharePatchFileUtil.checkIfMd5Valid(r4)) {
                    i2 = 1;
                } else {
                    new StringBuilder("path info file  corrupted:").append(file.getAbsolutePath());
                }
            }
        }
        if (i2 != 0) {
            return new SharePatchInfo(str, str2, str3, str4);
        }
        return null;
        SharePatchFileUtil.closeQuietly(fileInputStream);
        throw file;
    }

    private static boolean rewritePatchInfoFile(File file, SharePatchInfo sharePatchInfo) {
        Closeable fileOutputStream;
        Object e;
        SharePatchInfo readAndCheckProperty;
        if (file != null) {
            if (sharePatchInfo != null) {
                if (ShareTinkerInternals.isNullOrNil(sharePatchInfo.fingerPrint)) {
                    sharePatchInfo.fingerPrint = Build.FINGERPRINT;
                }
                if (ShareTinkerInternals.isNullOrNil(sharePatchInfo.oatDir)) {
                    sharePatchInfo.oatDir = "odex";
                }
                StringBuilder stringBuilder = new StringBuilder("rewritePatchInfoFile file path:");
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append(" , oldVer:");
                stringBuilder.append(sharePatchInfo.oldVersion);
                stringBuilder.append(", newVer:");
                stringBuilder.append(sharePatchInfo.newVersion);
                stringBuilder.append(", fingerprint:");
                stringBuilder.append(sharePatchInfo.fingerPrint);
                stringBuilder.append(", oatDir:");
                stringBuilder.append(sharePatchInfo.oatDir);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                int i = 0;
                int i2 = i;
                while (i < 2 && i2 == 0) {
                    i++;
                    Properties properties = new Properties();
                    properties.put("old", sharePatchInfo.oldVersion);
                    properties.put("new", sharePatchInfo.newVersion);
                    properties.put(FINGER_PRINT, sharePatchInfo.fingerPrint);
                    properties.put(OAT_DIR, sharePatchInfo.oatDir);
                    Closeable closeable = null;
                    try {
                        fileOutputStream = new FileOutputStream(file, false);
                        try {
                            StringBuilder stringBuilder2 = new StringBuilder("from old version:");
                            stringBuilder2.append(sharePatchInfo.oldVersion);
                            stringBuilder2.append(" to new version:");
                            stringBuilder2.append(sharePatchInfo.newVersion);
                            properties.store(fileOutputStream, stringBuilder2.toString());
                            SharePatchFileUtil.closeQuietly(fileOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            closeable = fileOutputStream;
                            try {
                                new StringBuilder("write property failed, e:").append(e);
                                SharePatchFileUtil.closeQuietly(closeable);
                                readAndCheckProperty = readAndCheckProperty(file);
                                if (readAndCheckProperty == null) {
                                }
                                if (i2 != 0) {
                                    file.delete();
                                }
                            } catch (Throwable th) {
                                file = th;
                                fileOutputStream = closeable;
                            }
                        } catch (Throwable th2) {
                            file = th2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        new StringBuilder("write property failed, e:").append(e);
                        SharePatchFileUtil.closeQuietly(closeable);
                        readAndCheckProperty = readAndCheckProperty(file);
                        if (readAndCheckProperty == null) {
                        }
                        if (i2 != 0) {
                            file.delete();
                        }
                    }
                    readAndCheckProperty = readAndCheckProperty(file);
                    i2 = readAndCheckProperty == null && readAndCheckProperty.oldVersion.equals(sharePatchInfo.oldVersion) && readAndCheckProperty.newVersion.equals(sharePatchInfo.newVersion);
                    if (i2 != 0) {
                        file.delete();
                    }
                }
                if (i2 != 0) {
                    return true;
                }
                return false;
            }
        }
        return false;
        SharePatchFileUtil.closeQuietly(fileOutputStream);
        throw file;
    }
}
