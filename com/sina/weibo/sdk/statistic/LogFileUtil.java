package com.sina.weibo.sdk.statistic;

import android.os.Environment;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.MD5;
import java.io.File;

class LogFileUtil {
    public static final String ANALYTICS_FILE_NAME = "app_logs";
    private static final String ANALYTICS_FILE_SUFFIX = ".txt";
    private static final String SDCARD_WEIBO_ANALYTICS_DIR = "/sina/weibo/.applogs/";

    LogFileUtil() {
    }

    public static String getAppLogs(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return readStringFromFile(str);
    }

    public static String getAppLogPath(String str) {
        String str2 = "";
        if (LogReport.getPackageName() != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(MD5.hexdigest(LogReport.getPackageName()));
            stringBuilder.append("/");
            str2 = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(getSDPath());
        stringBuilder2.append(SDCARD_WEIBO_ANALYTICS_DIR);
        stringBuilder2.append(str2);
        stringBuilder2.append(str);
        stringBuilder2.append(".txt");
        return stringBuilder2.toString();
    }

    private static String getSDPath() {
        File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.toString();
        }
        return null;
    }

    private static java.lang.String readStringFromFile(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r4 = "";
        return r4;
    L_0x0009:
        r0 = new java.io.File;
        r0.<init>(r4);
        r4 = r0.isFile();
        if (r4 == 0) goto L_0x0068;
    L_0x0014:
        r4 = r0.exists();
        if (r4 != 0) goto L_0x001b;
    L_0x001a:
        goto L_0x0068;
    L_0x001b:
        r4 = 0;
        r1 = new java.lang.StringBuilder;
        r2 = r0.length();
        r2 = (int) r2;
        r1.<init>(r2);
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0056, OutOfMemoryError -> 0x004c }
        r3 = new java.io.FileReader;	 Catch:{ IOException -> 0x0056, OutOfMemoryError -> 0x004c }
        r3.<init>(r0);	 Catch:{ IOException -> 0x0056, OutOfMemoryError -> 0x004c }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0056, OutOfMemoryError -> 0x004c }
    L_0x0030:
        r4 = r2.readLine();	 Catch:{ IOException -> 0x0046, OutOfMemoryError -> 0x0042, all -> 0x003e }
        if (r4 == 0) goto L_0x003a;	 Catch:{ IOException -> 0x0046, OutOfMemoryError -> 0x0042, all -> 0x003e }
    L_0x0036:
        r1.append(r4);	 Catch:{ IOException -> 0x0046, OutOfMemoryError -> 0x0042, all -> 0x003e }
        goto L_0x0030;
    L_0x003a:
        r2.close();	 Catch:{ IOException -> 0x005d }
        goto L_0x005d;
    L_0x003e:
        r4 = move-exception;
        r0 = r4;
        r4 = r2;
        goto L_0x0062;
    L_0x0042:
        r4 = move-exception;
        r0 = r4;
        r4 = r2;
        goto L_0x004d;
    L_0x0046:
        r4 = move-exception;
        r0 = r4;
        r4 = r2;
        goto L_0x0057;
    L_0x004a:
        r0 = move-exception;
        goto L_0x0062;
    L_0x004c:
        r0 = move-exception;
    L_0x004d:
        r0.printStackTrace();	 Catch:{ all -> 0x004a }
        if (r4 == 0) goto L_0x005d;
    L_0x0052:
        r4.close();	 Catch:{ IOException -> 0x005d }
        goto L_0x005d;
    L_0x0056:
        r0 = move-exception;
    L_0x0057:
        r0.printStackTrace();	 Catch:{ all -> 0x004a }
        if (r4 == 0) goto L_0x005d;
    L_0x005c:
        goto L_0x0052;
    L_0x005d:
        r4 = r1.toString();
        return r4;
    L_0x0062:
        if (r4 == 0) goto L_0x0067;
    L_0x0064:
        r4.close();	 Catch:{ IOException -> 0x0067 }
    L_0x0067:
        throw r0;
    L_0x0068:
        r4 = "";
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogFileUtil.readStringFromFile(java.lang.String):java.lang.String");
    }

    public static synchronized void writeToFile(java.lang.String r9, java.lang.String r10, boolean r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.sina.weibo.sdk.statistic.LogFileUtil.class;
        monitor-enter(r0);
        r1 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x00cd }
        if (r1 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r0);
        return;
    L_0x000b:
        r1 = "WBAgent";	 Catch:{ all -> 0x00cd }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00cd }
        r3 = "filePath:";	 Catch:{ all -> 0x00cd }
        r2.<init>(r3);	 Catch:{ all -> 0x00cd }
        r2.append(r9);	 Catch:{ all -> 0x00cd }
        r2 = r2.toString();	 Catch:{ all -> 0x00cd }
        com.sina.weibo.sdk.utils.LogUtil.i(r1, r2);	 Catch:{ all -> 0x00cd }
        if (r10 == 0) goto L_0x00cb;	 Catch:{ all -> 0x00cd }
    L_0x0020:
        r1 = r10.length();	 Catch:{ all -> 0x00cd }
        if (r1 != 0) goto L_0x0028;	 Catch:{ all -> 0x00cd }
    L_0x0026:
        goto L_0x00cb;	 Catch:{ all -> 0x00cd }
    L_0x0028:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00cd }
        r1.<init>(r10);	 Catch:{ all -> 0x00cd }
        r10 = 0;	 Catch:{ all -> 0x00cd }
        r2 = r1.charAt(r10);	 Catch:{ all -> 0x00cd }
        r3 = 91;	 Catch:{ all -> 0x00cd }
        r4 = 1;	 Catch:{ all -> 0x00cd }
        if (r2 != r3) goto L_0x003c;	 Catch:{ all -> 0x00cd }
    L_0x0037:
        r2 = "";	 Catch:{ all -> 0x00cd }
        r1.replace(r10, r4, r2);	 Catch:{ all -> 0x00cd }
    L_0x003c:
        r2 = r1.length();	 Catch:{ all -> 0x00cd }
        r2 = r2 - r4;	 Catch:{ all -> 0x00cd }
        r2 = r1.charAt(r2);	 Catch:{ all -> 0x00cd }
        r3 = 44;	 Catch:{ all -> 0x00cd }
        if (r2 == r3) goto L_0x0057;	 Catch:{ all -> 0x00cd }
    L_0x0049:
        r2 = r1.length();	 Catch:{ all -> 0x00cd }
        r2 = r2 - r4;	 Catch:{ all -> 0x00cd }
        r3 = r1.length();	 Catch:{ all -> 0x00cd }
        r4 = ",";	 Catch:{ all -> 0x00cd }
        r1.replace(r2, r3, r4);	 Catch:{ all -> 0x00cd }
    L_0x0057:
        r2 = new java.io.File;	 Catch:{ all -> 0x00cd }
        r2.<init>(r9);	 Catch:{ all -> 0x00cd }
        r9 = 0;
        r3 = r2.getParentFile();	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        r4 = r3.exists();	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        if (r4 != 0) goto L_0x006a;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
    L_0x0067:
        r3.mkdirs();	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
    L_0x006a:
        r3 = r2.exists();	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        if (r3 != 0) goto L_0x0074;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
    L_0x0070:
        r2.createNewFile();	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        goto L_0x0090;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
    L_0x0074:
        r3 = r2.lastModified();	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        r5 = 0;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        if (r7 <= 0) goto L_0x0090;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
    L_0x007e:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        r5 = r2.lastModified();	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        r7 = r3 - r5;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        r3 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        if (r5 <= 0) goto L_0x0090;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
    L_0x008f:
        goto L_0x0091;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
    L_0x0090:
        r10 = r11;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
    L_0x0091:
        r11 = new java.io.FileWriter;	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        r11.<init>(r2, r10);	 Catch:{ IOException -> 0x00bc, all -> 0x00b0 }
        r9 = r1.toString();	 Catch:{ IOException -> 0x00ae, all -> 0x00ab }
        r11.write(r9);	 Catch:{ IOException -> 0x00ae, all -> 0x00ab }
        r11.flush();	 Catch:{ IOException -> 0x00ae, all -> 0x00ab }
        r11.close();	 Catch:{ IOException -> 0x00a5 }
        monitor-exit(r0);
        return;
    L_0x00a5:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ all -> 0x00cd }
        monitor-exit(r0);
        return;
    L_0x00ab:
        r10 = move-exception;
        r9 = r11;
        goto L_0x00b1;
    L_0x00ae:
        r9 = r11;
        goto L_0x00bc;
    L_0x00b0:
        r10 = move-exception;
    L_0x00b1:
        if (r9 == 0) goto L_0x00bb;
    L_0x00b3:
        r9.close();	 Catch:{ IOException -> 0x00b7 }
        goto L_0x00bb;
    L_0x00b7:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ all -> 0x00cd }
    L_0x00bb:
        throw r10;	 Catch:{ all -> 0x00cd }
    L_0x00bc:
        if (r9 == 0) goto L_0x00c9;
    L_0x00be:
        r9.close();	 Catch:{ IOException -> 0x00c3 }
        monitor-exit(r0);
        return;
    L_0x00c3:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ all -> 0x00cd }
        monitor-exit(r0);
        return;
    L_0x00c9:
        monitor-exit(r0);
        return;
    L_0x00cb:
        monitor-exit(r0);
        return;
    L_0x00cd:
        r9 = move-exception;
        monitor-exit(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogFileUtil.writeToFile(java.lang.String, java.lang.String, boolean):void");
    }

    public static boolean delete(String str) {
        File file = new File(str);
        if (file.exists() == null || file.isFile() == null) {
            return false;
        }
        file.delete();
        return true;
    }
}
