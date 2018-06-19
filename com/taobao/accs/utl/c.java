package com.taobao.accs.utl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public class c {
    public static final String TAG = "FileUtils";

    public static byte[] a(File file) {
        FileInputStream fileInputStream;
        if (file != null) {
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        file = a((InputStream) fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Throwable th) {
                        file = th;
                        try {
                            ALog.e(TAG, "FileInputStream error", file, new Object[0]);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (File file2) {
                                    file2.printStackTrace();
                                }
                            }
                            file2 = null;
                            return file2;
                        } catch (Throwable th2) {
                            file2 = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw file2;
                        }
                    }
                } catch (Throwable th3) {
                    file2 = th3;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw file2;
                }
                return file2;
            }
        }
        ALog.w(TAG, "filetoByte not exist", new Object[0]);
        return null;
    }

    public static boolean a(byte[] bArr, File file) {
        boolean z = false;
        if (bArr != null) {
            if (file != null) {
                if (file != null) {
                    if (file.exists()) {
                        file.delete();
                    }
                    FileOutputStream fileOutputStream = null;
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            try {
                                fileOutputStream2.close();
                            } catch (byte[] bArr2) {
                                bArr2.printStackTrace();
                            }
                            z = true;
                        } catch (Throwable th) {
                            bArr2 = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw bArr2;
                        }
                    } catch (Throwable th2) {
                        bArr2 = th2;
                        ALog.e(TAG, "byteToFile write file error", bArr2, new Object[0]);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return z;
                    }
                }
                return z;
            }
        }
        ALog.w(TAG, "byteToFile null", new Object[]{"data", bArr2, "file", file});
        return false;
    }

    public static byte[] a(java.io.InputStream r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x0026, all -> 0x0023 }
        r2.<init>();	 Catch:{ Throwable -> 0x0026, all -> 0x0023 }
        r3 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r3 = new byte[r3];	 Catch:{ Throwable -> 0x0021 }
    L_0x000e:
        r4 = r6.read(r3);	 Catch:{ Throwable -> 0x0021 }
        r5 = -1;	 Catch:{ Throwable -> 0x0021 }
        if (r4 == r5) goto L_0x0019;	 Catch:{ Throwable -> 0x0021 }
    L_0x0015:
        r2.write(r3, r1, r4);	 Catch:{ Throwable -> 0x0021 }
        goto L_0x000e;	 Catch:{ Throwable -> 0x0021 }
    L_0x0019:
        r6 = r2.toByteArray();	 Catch:{ Throwable -> 0x0021 }
        r2.close();	 Catch:{ Exception -> 0x0037 }
        goto L_0x0037;
    L_0x0021:
        r6 = move-exception;
        goto L_0x0028;
    L_0x0023:
        r6 = move-exception;
        r2 = r0;
        goto L_0x0039;
    L_0x0026:
        r6 = move-exception;
        r2 = r0;
    L_0x0028:
        r3 = "FileUtils";	 Catch:{ all -> 0x0038 }
        r4 = "streamToByte error";	 Catch:{ all -> 0x0038 }
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0038 }
        com.taobao.accs.utl.ALog.e(r3, r4, r6, r1);	 Catch:{ all -> 0x0038 }
        if (r2 == 0) goto L_0x0036;
    L_0x0033:
        r2.close();	 Catch:{ Exception -> 0x0036 }
    L_0x0036:
        r6 = r0;
    L_0x0037:
        return r6;
    L_0x0038:
        r6 = move-exception;
    L_0x0039:
        if (r2 == 0) goto L_0x003e;
    L_0x003b:
        r2.close();	 Catch:{ Exception -> 0x003e }
    L_0x003e:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.c.a(java.io.InputStream):byte[]");
    }
}
