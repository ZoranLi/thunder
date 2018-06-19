package com.tencent.tinker.lib.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* compiled from: BUGLY */
public class UpgradePatchRetry {
    private static final String RETRY_COUNT_PROPERTY = "times";
    private static final String RETRY_FILE_MD5_PROPERTY = "md5";
    private static final String RETRY_INFO_NAME = "patch.retry";
    private static final int RETRY_MAX_COUNT = 5;
    private static final String TAG = "Tinker.UpgradePatchRetry";
    private static final String TEMP_PATCH_NAME = "temp.apk";
    private static UpgradePatchRetry sInstance;
    private Context context = null;
    private boolean isRetryEnable = true;
    private int maxRetryCount = 5;
    private File retryInfoFile = null;
    private File tempPatchFile = null;

    /* compiled from: BUGLY */
    static class RetryInfo {
        String md5;
        String times;

        RetryInfo(String str, String str2) {
            this.md5 = str;
            this.times = str2;
        }

        static RetryInfo readRetryProperty(File file) {
            String property;
            Object e;
            String str;
            StringBuilder stringBuilder;
            Properties properties = new Properties();
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    file = properties.getProperty(UpgradePatchRetry.RETRY_FILE_MD5_PROPERTY);
                    try {
                        property = properties.getProperty(UpgradePatchRetry.RETRY_COUNT_PROPERTY);
                        SharePatchFileUtil.closeQuietly(fileInputStream);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            str = UpgradePatchRetry.TAG;
                            stringBuilder = new StringBuilder("fail to readRetryProperty:");
                            stringBuilder.append(e);
                            TinkerLog.e(str, stringBuilder.toString(), new Object[0]);
                            SharePatchFileUtil.closeQuietly(fileInputStream);
                            property = null;
                            return new RetryInfo(file, property);
                        } catch (Throwable th) {
                            file = th;
                            SharePatchFileUtil.closeQuietly(fileInputStream);
                            throw file;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    file = null;
                    str = UpgradePatchRetry.TAG;
                    stringBuilder = new StringBuilder("fail to readRetryProperty:");
                    stringBuilder.append(e);
                    TinkerLog.e(str, stringBuilder.toString(), new Object[0]);
                    SharePatchFileUtil.closeQuietly(fileInputStream);
                    property = null;
                    return new RetryInfo(file, property);
                }
            } catch (IOException e4) {
                e = e4;
                file = null;
                fileInputStream = file;
                str = UpgradePatchRetry.TAG;
                stringBuilder = new StringBuilder("fail to readRetryProperty:");
                stringBuilder.append(e);
                TinkerLog.e(str, stringBuilder.toString(), new Object[0]);
                SharePatchFileUtil.closeQuietly(fileInputStream);
                property = null;
                return new RetryInfo(file, property);
            } catch (Throwable th2) {
                file = th2;
                fileInputStream = null;
                SharePatchFileUtil.closeQuietly(fileInputStream);
                throw file;
            }
            return new RetryInfo(file, property);
        }

        static void writeRetryProperty(File file, RetryInfo retryInfo) {
            if (retryInfo != null) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                Properties properties = new Properties();
                properties.put(UpgradePatchRetry.RETRY_FILE_MD5_PROPERTY, retryInfo.md5);
                properties.put(UpgradePatchRetry.RETRY_COUNT_PROPERTY, retryInfo.times);
                Closeable closeable = null;
                try {
                    Closeable fileOutputStream = new FileOutputStream(file, false);
                    try {
                        properties.store(fileOutputStream, null);
                        SharePatchFileUtil.closeQuietly(fileOutputStream);
                    } catch (Exception e) {
                        file = e;
                        closeable = fileOutputStream;
                        try {
                            TinkerLog.printErrStackTrace(UpgradePatchRetry.TAG, file, "retry write property fail", new Object[0]);
                            SharePatchFileUtil.closeQuietly(closeable);
                        } catch (Throwable th) {
                            file = th;
                            SharePatchFileUtil.closeQuietly(closeable);
                            throw file;
                        }
                    } catch (Throwable th2) {
                        file = th2;
                        closeable = fileOutputStream;
                        SharePatchFileUtil.closeQuietly(closeable);
                        throw file;
                    }
                } catch (Exception e2) {
                    file = e2;
                    TinkerLog.printErrStackTrace(UpgradePatchRetry.TAG, file, "retry write property fail", new Object[0]);
                    SharePatchFileUtil.closeQuietly(closeable);
                }
            }
        }
    }

    public UpgradePatchRetry(Context context) {
        this.context = context;
        this.retryInfoFile = new File(SharePatchFileUtil.getPatchTempDirectory(context), RETRY_INFO_NAME);
        this.tempPatchFile = new File(SharePatchFileUtil.getPatchTempDirectory(context), TEMP_PATCH_NAME);
    }

    public static UpgradePatchRetry getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new UpgradePatchRetry(context);
        }
        return sInstance;
    }

    public void setRetryEnable(boolean z) {
        this.isRetryEnable = z;
    }

    public void setMaxRetryCount(int i) {
        if (i <= 0) {
            TinkerLog.e(TAG, "max count must large than 0", new Object[0]);
        } else {
            this.maxRetryCount = i;
        }
    }

    public boolean onPatchRetryLoad() {
        if (!this.isRetryEnable) {
            TinkerLog.w(TAG, "onPatchRetryLoad retry disabled, just return", new Object[0]);
            return false;
        } else if (!Tinker.with(this.context).isMainProcess()) {
            TinkerLog.w(TAG, "onPatchRetryLoad retry is not main process, just return", new Object[0]);
            return false;
        } else if (!this.retryInfoFile.exists()) {
            TinkerLog.w(TAG, "onPatchRetryLoad retry info not exist, just return", new Object[0]);
            return false;
        } else if (TinkerServiceInternals.isTinkerPatchServiceRunning(this.context)) {
            TinkerLog.w(TAG, "onPatchRetryLoad tinker service is running, just return", new Object[0]);
            return false;
        } else {
            String absolutePath = this.tempPatchFile.getAbsolutePath();
            if (absolutePath != null) {
                if (new File(absolutePath).exists()) {
                    TinkerLog.w(TAG, "onPatchRetryLoad patch file: %s is exist, retry to patch", absolutePath);
                    TinkerInstaller.onReceiveUpgradePatch(this.context, absolutePath);
                    return true;
                }
            }
            TinkerLog.w(TAG, "onPatchRetryLoad patch file: %s is not exist, just return", absolutePath);
            return false;
        }
    }

    public void onPatchServiceStart(Intent intent) {
        if (!this.isRetryEnable) {
            TinkerLog.w(TAG, "onPatchServiceStart retry disabled, just return", new Object[0]);
        } else if (intent == null) {
            TinkerLog.e(TAG, "onPatchServiceStart intent is null, just return", new Object[0]);
        } else {
            intent = TinkerPatchService.getPatchPathExtra(intent);
            if (intent == null) {
                TinkerLog.w(TAG, "onPatchServiceStart patch path is null, just return", new Object[0]);
                return;
            }
            File file = new File(intent);
            intent = SharePatchFileUtil.getMD5(file);
            if (intent == null) {
                TinkerLog.w(TAG, "onPatchServiceStart patch md5 is null, just return", new Object[0]);
                return;
            }
            RetryInfo readRetryProperty;
            if (this.retryInfoFile.exists()) {
                readRetryProperty = RetryInfo.readRetryProperty(this.retryInfoFile);
                if (!(readRetryProperty.md5 == null || readRetryProperty.times == null)) {
                    if (intent.equals(readRetryProperty.md5)) {
                        intent = Integer.parseInt(readRetryProperty.times);
                        if (intent >= this.maxRetryCount) {
                            SharePatchFileUtil.safeDeleteFile(this.tempPatchFile);
                            TinkerLog.w(TAG, "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                            return;
                        }
                        readRetryProperty.times = String.valueOf(intent + 1);
                    }
                }
                copyToTempFile(file);
                readRetryProperty.md5 = intent;
                readRetryProperty.times = "1";
            } else {
                copyToTempFile(file);
                readRetryProperty = new RetryInfo(intent, "1");
            }
            RetryInfo.writeRetryProperty(this.retryInfoFile, readRetryProperty);
        }
    }

    public boolean onPatchListenerCheck(String str) {
        if (!this.isRetryEnable) {
            TinkerLog.w(TAG, "onPatchListenerCheck retry disabled, just return", new Object[0]);
            return true;
        } else if (!this.retryInfoFile.exists()) {
            TinkerLog.w(TAG, "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
            return true;
        } else if (str == null) {
            TinkerLog.w(TAG, "onPatchListenerCheck md5 is null, just return", new Object[0]);
            return true;
        } else {
            RetryInfo readRetryProperty = RetryInfo.readRetryProperty(this.retryInfoFile);
            if (str.equals(readRetryProperty.md5) == null || Integer.parseInt(readRetryProperty.times) < this.maxRetryCount) {
                return true;
            }
            TinkerLog.w(TAG, "onPatchListenerCheck, retry count %d must exceed than max retry count", Integer.valueOf(Integer.parseInt(readRetryProperty.times)));
            SharePatchFileUtil.safeDeleteFile(this.tempPatchFile);
            return false;
        }
    }

    public boolean onPatchResetMaxCheck(String str) {
        if (!this.isRetryEnable) {
            TinkerLog.w(TAG, "onPatchResetMaxCheck retry disabled, just return", new Object[0]);
            return true;
        } else if (!this.retryInfoFile.exists()) {
            TinkerLog.w(TAG, "onPatchResetMaxCheck retry file is not exist, just return", new Object[0]);
            return true;
        } else if (str == null) {
            TinkerLog.w(TAG, "onPatchResetMaxCheck md5 is null, just return", new Object[0]);
            return true;
        } else {
            RetryInfo readRetryProperty = RetryInfo.readRetryProperty(this.retryInfoFile);
            if (str.equals(readRetryProperty.md5) != null) {
                TinkerLog.i(TAG, "onPatchResetMaxCheck, reset max check to 1", new Object[0]);
                readRetryProperty.times = "1";
                RetryInfo.writeRetryProperty(this.retryInfoFile, readRetryProperty);
            }
            return true;
        }
    }

    public void onPatchServiceResult() {
        if (this.isRetryEnable) {
            if (this.tempPatchFile.exists()) {
                SharePatchFileUtil.safeDeleteFile(this.tempPatchFile);
            }
            return;
        }
        TinkerLog.w(TAG, "onPatchServiceResult retry disabled, just return", new Object[0]);
    }

    private void copyToTempFile(java.io.File r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r8.getAbsolutePath();
        r1 = r7.tempPatchFile;
        r1 = r1.getAbsolutePath();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        r0 = "Tinker.UpgradePatchRetry";
        r1 = "try copy file: %s to %s";
        r2 = 2;
        r3 = new java.lang.Object[r2];
        r4 = r8.getAbsolutePath();
        r5 = 0;
        r3[r5] = r4;
        r4 = r7.tempPatchFile;
        r4 = r4.getAbsolutePath();
        r6 = 1;
        r3[r6] = r4;
        com.tencent.tinker.lib.util.TinkerLog.w(r0, r1, r3);
        r0 = r7.tempPatchFile;	 Catch:{ IOException -> 0x0031 }
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.copyFileUsingStream(r8, r0);	 Catch:{ IOException -> 0x0031 }
        return;
    L_0x0031:
        r0 = "Tinker.UpgradePatchRetry";
        r1 = "fail to copy file: %s to %s";
        r2 = new java.lang.Object[r2];
        r8 = r8.getAbsolutePath();
        r2[r5] = r8;
        r8 = r7.tempPatchFile;
        r8 = r8.getAbsolutePath();
        r2[r6] = r8;
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.util.UpgradePatchRetry.copyToTempFile(java.io.File):void");
    }
}
