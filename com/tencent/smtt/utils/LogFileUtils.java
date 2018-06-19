package com.tencent.smtt.utils;

import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils {
    private static OutputStream a;

    public static void closeOutputStream(java.io.OutputStream r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0006;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.LogFileUtils.closeOutputStream(java.io.OutputStream):void");
    }

    public static byte[] createHeaderText(java.lang.String r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = encryptKey(r5, r6);	 Catch:{ Exception -> 0x0035 }
        r6 = "%03d";	 Catch:{ Exception -> 0x0035 }
        r0 = 1;	 Catch:{ Exception -> 0x0035 }
        r1 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0035 }
        r2 = r5.length;	 Catch:{ Exception -> 0x0035 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0035 }
        r3 = 0;	 Catch:{ Exception -> 0x0035 }
        r1[r3] = r2;	 Catch:{ Exception -> 0x0035 }
        r6 = java.lang.String.format(r6, r1);	 Catch:{ Exception -> 0x0035 }
        r1 = r5.length;	 Catch:{ Exception -> 0x0035 }
        r2 = 3;	 Catch:{ Exception -> 0x0035 }
        r1 = r1 + r2;	 Catch:{ Exception -> 0x0035 }
        r1 = new byte[r1];	 Catch:{ Exception -> 0x0035 }
        r4 = r6.charAt(r3);	 Catch:{ Exception -> 0x0035 }
        r4 = (byte) r4;	 Catch:{ Exception -> 0x0035 }
        r1[r3] = r4;	 Catch:{ Exception -> 0x0035 }
        r4 = r6.charAt(r0);	 Catch:{ Exception -> 0x0035 }
        r4 = (byte) r4;	 Catch:{ Exception -> 0x0035 }
        r1[r0] = r4;	 Catch:{ Exception -> 0x0035 }
        r0 = 2;	 Catch:{ Exception -> 0x0035 }
        r6 = r6.charAt(r0);	 Catch:{ Exception -> 0x0035 }
        r6 = (byte) r6;	 Catch:{ Exception -> 0x0035 }
        r1[r0] = r6;	 Catch:{ Exception -> 0x0035 }
        r6 = r5.length;	 Catch:{ Exception -> 0x0035 }
        java.lang.System.arraycopy(r5, r3, r1, r2, r6);	 Catch:{ Exception -> 0x0035 }
        return r1;
    L_0x0035:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.LogFileUtils.createHeaderText(java.lang.String, java.lang.String):byte[]");
    }

    public static String createKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return instance.update(bytes);
        } catch (Throwable th) {
            new StringBuilder("encrypt exception:").append(th.getMessage());
            return null;
        }
    }

    public static byte[] encryptKey(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return instance.update(bytes);
        } catch (Throwable th) {
            new StringBuilder("encrypt exception:").append(th.getMessage());
            return null;
        }
    }

    public static synchronized void writeDataToStorage(java.io.File r6, java.lang.String r7, byte[] r8, java.lang.String r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.smtt.utils.LogFileUtils.class;
        monitor-enter(r0);
        r7 = encrypt(r7, r9);	 Catch:{ all -> 0x0081 }
        r1 = 0;
        if (r7 == 0) goto L_0x000c;
    L_0x000a:
        r9 = r1;
        goto L_0x000d;
    L_0x000c:
        r7 = r1;
    L_0x000d:
        r1 = r6.getParentFile();	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r1.mkdirs();	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r1 = r6.isFile();	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        if (r1 == 0) goto L_0x0031;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
    L_0x001a:
        r1 = r6.exists();	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        if (r1 == 0) goto L_0x0031;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
    L_0x0020:
        r1 = r6.length();	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r3 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        if (r5 <= 0) goto L_0x0031;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
    L_0x002b:
        r6.delete();	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r6.createNewFile();	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
    L_0x0031:
        r1 = a;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        if (r1 != 0) goto L_0x0041;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
    L_0x0035:
        r1 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r1.<init>(r6, r10);	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r6 = new java.io.BufferedOutputStream;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r6.<init>(r1);	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        a = r6;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
    L_0x0041:
        if (r9 == 0) goto L_0x004d;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
    L_0x0043:
        r6 = a;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r7 = r9.getBytes();	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
    L_0x0049:
        r6.write(r7);	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        goto L_0x0060;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
    L_0x004d:
        r6 = a;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r6.write(r8);	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r6 = a;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r6.write(r7);	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r6 = a;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r7 = 2;	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r7 = new byte[r7];	 Catch:{ Throwable -> 0x0076, all -> 0x006b }
        r7 = {10, 10};
        goto L_0x0049;
    L_0x0060:
        r6 = a;	 Catch:{ all -> 0x0081 }
        if (r6 == 0) goto L_0x0069;
    L_0x0064:
        r6 = a;	 Catch:{ Throwable -> 0x0069 }
        r6.flush();	 Catch:{ Throwable -> 0x0069 }
    L_0x0069:
        monitor-exit(r0);
        return;
    L_0x006b:
        r6 = move-exception;
        r7 = a;	 Catch:{ all -> 0x0081 }
        if (r7 == 0) goto L_0x0075;
    L_0x0070:
        r7 = a;	 Catch:{ Throwable -> 0x0075 }
        r7.flush();	 Catch:{ Throwable -> 0x0075 }
    L_0x0075:
        throw r6;	 Catch:{ all -> 0x0081 }
    L_0x0076:
        r6 = a;	 Catch:{ all -> 0x0081 }
        if (r6 == 0) goto L_0x007f;
    L_0x007a:
        r6 = a;	 Catch:{ Throwable -> 0x007f }
        r6.flush();	 Catch:{ Throwable -> 0x007f }
    L_0x007f:
        monitor-exit(r0);
        return;
    L_0x0081:
        r6 = move-exception;
        monitor-exit(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.LogFileUtils.writeDataToStorage(java.io.File, java.lang.String, byte[], java.lang.String, boolean):void");
    }
}
