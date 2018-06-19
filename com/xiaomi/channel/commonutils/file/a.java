package com.xiaomi.channel.commonutils.file;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xunlei.download.proguard.c;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class a {
    public static final String[] a = new String[]{"jpg", "png", "bmp", "gif", "webp"};

    public static void a(java.io.File r3, java.io.File r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0039, IOException -> 0x001b }
        r2 = 0;	 Catch:{ FileNotFoundException -> 0x0039, IOException -> 0x001b }
        r1.<init>(r3, r2);	 Catch:{ FileNotFoundException -> 0x0039, IOException -> 0x001b }
        r3 = new java.util.zip.ZipOutputStream;	 Catch:{ FileNotFoundException -> 0x0039, IOException -> 0x001b }
        r3.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0039, IOException -> 0x001b }
        a(r3, r4, r0, r0);	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0016, all -> 0x0013 }
        a(r3);
        return;
    L_0x0013:
        r4 = move-exception;
        r0 = r3;
        goto L_0x0035;
    L_0x0016:
        r4 = move-exception;
        r0 = r3;
        goto L_0x001c;
    L_0x0019:
        r4 = move-exception;
        goto L_0x0035;
    L_0x001b:
        r4 = move-exception;
    L_0x001c:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0019 }
        r1 = "zip file failure + ";	 Catch:{ all -> 0x0019 }
        r3.<init>(r1);	 Catch:{ all -> 0x0019 }
        r4 = r4.getMessage();	 Catch:{ all -> 0x0019 }
        r3.append(r4);	 Catch:{ all -> 0x0019 }
        r3 = r3.toString();	 Catch:{ all -> 0x0019 }
        com.xiaomi.channel.commonutils.logger.b.a(r3);	 Catch:{ all -> 0x0019 }
        a(r0);
        return;
    L_0x0035:
        a(r0);
        throw r4;
    L_0x0039:
        r3 = r0;
    L_0x003a:
        a(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.file.a.a(java.io.File, java.io.File):void");
    }

    public static void a(java.io.InputStream r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.file.a.a(java.io.InputStream):void");
    }

    public static void a(java.io.OutputStream r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.flush();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        r0.close();	 Catch:{ IOException -> 0x0008 }
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.file.a.a(java.io.OutputStream):void");
    }

    public static void a(java.io.RandomAccessFile r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.file.a.a(java.io.RandomAccessFile):void");
    }

    public static void a(java.io.Reader r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.file.a.a(java.io.Reader):void");
    }

    public static void a(java.io.Writer r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.file.a.a(java.io.Writer):void");
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        IOException e;
        StringBuilder stringBuilder;
        Throwable th;
        if (str == null) {
            Object obj = "";
        }
        InputStream inputStream = null;
        try {
            InputStream inputStream2;
            int i = 0;
            if (file.isDirectory()) {
                File[] listFiles = fileFilter != null ? file.listFiles(fileFilter) : file.listFiles();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(obj);
                stringBuilder2.append(File.separator);
                zipOutputStream.putNextEntry(new ZipEntry(stringBuilder2.toString()));
                if (TextUtils.isEmpty(obj)) {
                    str = "";
                } else {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(obj);
                    stringBuilder3.append(File.separator);
                    str = stringBuilder3.toString();
                }
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    File file2 = listFiles[i2];
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(str);
                    stringBuilder4.append(listFiles[i2].getName());
                    a(zipOutputStream, file2, stringBuilder4.toString(), null);
                }
                File[] listFiles2 = file.listFiles(new b());
                if (listFiles2 != null) {
                    int length = listFiles2.length;
                    while (i < length) {
                        File file3 = listFiles2[i];
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str);
                        stringBuilder2.append(File.separator);
                        stringBuilder2.append(file3.getName());
                        a(zipOutputStream, file3, stringBuilder2.toString(), fileFilter);
                        i++;
                    }
                }
                inputStream2 = null;
            } else {
                ZipEntry zipEntry;
                if (TextUtils.isEmpty(obj)) {
                    Date date = new Date();
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(String.valueOf(date.getTime()));
                    stringBuilder5.append(c.n);
                    zipEntry = new ZipEntry(stringBuilder5.toString());
                } else {
                    zipEntry = new ZipEntry(obj);
                }
                zipOutputStream.putNextEntry(zipEntry);
                inputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e2) {
                    e = e2;
                    inputStream = inputStream2;
                    try {
                        stringBuilder = new StringBuilder("zipFiction failed with exception:");
                        stringBuilder.append(e.toString());
                        b.d(stringBuilder.toString());
                        a(inputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        a(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    a(inputStream);
                    throw th;
                }
            }
            a(inputStream2);
        } catch (IOException e3) {
            e = e3;
            stringBuilder = new StringBuilder("zipFiction failed with exception:");
            stringBuilder.append(e.toString());
            b.d(stringBuilder.toString());
            a(inputStream);
        }
    }

    public static boolean a(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            return (parentFile.exists() || parentFile.mkdirs()) ? file.createNewFile() : false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static byte[] a(byte[] r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x001b }
        r0.<init>();	 Catch:{ Exception -> 0x001b }
        r1 = new java.util.zip.GZIPOutputStream;	 Catch:{ Exception -> 0x001b }
        r1.<init>(r0);	 Catch:{ Exception -> 0x001b }
        r1.write(r2);	 Catch:{ Exception -> 0x001b }
        r1.finish();	 Catch:{ Exception -> 0x001b }
        r1.close();	 Catch:{ Exception -> 0x001b }
        r1 = r0.toByteArray();	 Catch:{ Exception -> 0x001b }
        r0.close();	 Catch:{ Exception -> 0x001b }
        r2 = r1;
    L_0x001b:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.file.a.a(byte[]):byte[]");
    }
}
