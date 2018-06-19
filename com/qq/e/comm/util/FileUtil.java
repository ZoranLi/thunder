package com.qq.e.comm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
    public static boolean copyTo(InputStream inputStream, File file) {
        Throwable th;
        Throwable th2;
        if (inputStream == null || file == null) {
            return false;
        }
        OutputStream outputStream = null;
        try {
            if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
                OutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            tryClose(inputStream);
                            tryClose(fileOutputStream);
                            return true;
                        }
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    outputStream = fileOutputStream;
                    tryClose(inputStream);
                    tryClose(outputStream);
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            GDTLogger.e(String.format("Exception while copy from InputStream to File %s", new Object[]{file.getAbsolutePath()}), th);
            tryClose(inputStream);
            tryClose(outputStream);
            return false;
        }
        tryClose(inputStream);
        tryClose(outputStream);
        return false;
    }

    public static String getFileName(String str) {
        return Md5Util.encode(str);
    }

    public static String getTempFileName(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Md5Util.encode(str));
        stringBuilder.append(".temp");
        return stringBuilder.toString();
    }

    public static boolean renameTo(File file, File file2) {
        if (!(file == null || file2 == null)) {
            if (file.exists()) {
                return !file.renameTo(file2) ? copyTo(null, file2) : true;
            }
        }
        return false;
    }

    public static void tryClose(java.io.InputStream r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ Exception -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.FileUtil.tryClose(java.io.InputStream):void");
    }

    public static void tryClose(java.io.OutputStream r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ Exception -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.FileUtil.tryClose(java.io.OutputStream):void");
    }
}
