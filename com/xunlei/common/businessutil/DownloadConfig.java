package com.xunlei.common.businessutil;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.xllib.android.e;
import java.io.File;

public class DownloadConfig extends DownloadPathConfig {
    public static final int DEFAULT_NUM = 3;
    public static final int DEFAULT_SPEED = 512;
    public static final int MAX_NUM = 5;
    public static final int MIN_NUM = 1;
    public static final int MIN_SPEED = 10;
    public static final String NONEXIST_REAL_DOWNLOAD_PATH = "##noexist##";
    private static final StorageInfo sStorageInfo = new StorageInfo(null);

    public static void initDefaultDownloadPath(Context context) {
        DownloadPathConfig.initDefaultDownloadPathImpl(context);
        refreshStorageInfo(context);
    }

    public static String getRealDownloadPath(Context context) {
        return DownloadPathConfig.getRealDownloadPathImpl(context);
    }

    public static String getSavedRealDownloadPath(Context context, int i, boolean z) {
        return DownloadPathConfig.getSavedRealDownloadPathImpl(context, i, z);
    }

    public static String setRealDownloadPath(int i, String str) {
        return DownloadPathConfig.setRealDownloadPathImpl(i, str);
    }

    public static boolean isStoragePathExist(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.File;	 Catch:{ Exception -> 0x000e }
        r1 = getStoragePath(r1);	 Catch:{ Exception -> 0x000e }
        r0.<init>(r1);	 Catch:{ Exception -> 0x000e }
        r1 = r0.exists();	 Catch:{ Exception -> 0x000e }
        return r1;
    L_0x000e:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.businessutil.DownloadConfig.isStoragePathExist(android.content.Context):boolean");
    }

    public static String getStoragePath(Context context) {
        return DownloadPathConfig.getStoragePathImpl(context);
    }

    public static long getStorageAvailableSize(Context context) {
        return e.a(getStoragePath(context));
    }

    public static long getStorageTotalSize(Context context) {
        context = getStoragePath(context);
        sStorageInfo.mStorageAvailableSize = e.b(context);
        return sStorageInfo.mStorageAvailableSize;
    }

    public static long getCachedStorageAvailableSize(Context context) {
        refreshStorageInfo(context);
        return sStorageInfo.mStorageAvailableSize;
    }

    public static void refreshStorageInfo(Context context) {
        XLThreadPool.execute(new 1(context.getApplicationContext()));
    }

    public static String getRecordVideoPath() {
        StringBuilder stringBuilder;
        String stringBuilder2;
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        if (Build.MODEL.trim().toLowerCase().indexOf("zte") != -1) {
            if (externalStoragePublicDirectory.exists()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(externalStoragePublicDirectory);
                stringBuilder.append(File.separator);
                stringBuilder.append("Camera");
                stringBuilder2 = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(externalStoragePublicDirectory.getPath().replace("/sdcard/", "/sdcard-ext/"));
                stringBuilder.append(File.separator);
                stringBuilder.append("Camera");
                stringBuilder2 = stringBuilder.toString();
            }
        } else if (Build.MODEL.trim().toLowerCase().indexOf("vivo") != -1) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(Environment.getExternalStorageDirectory());
            stringBuilder3.append(File.separator);
            stringBuilder3.append("相机");
            stringBuilder2 = stringBuilder3.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(externalStoragePublicDirectory);
            stringBuilder.append(File.separator);
            stringBuilder.append("Camera");
            stringBuilder2 = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(File.separator);
        return stringBuilder.toString();
    }

    public static String getDownloadDirName() {
        return DownloadPathConfig.getDownloadDirNameImpl();
    }

    public static String getAdPath(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DownloadPathConfig.getDownloadPathImpl(context));
        stringBuilder.append("ad/");
        return stringBuilder.toString();
    }
}
