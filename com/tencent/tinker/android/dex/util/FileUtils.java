package com.tencent.tinker.android.dex.util;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: BUGLY */
public final class FileUtils {
    private FileUtils() {
    }

    public static byte[] readFile(String str) throws IOException {
        return readFile(new File(str));
    }

    public static byte[] readFile(java.io.File r6) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r6.exists();
        if (r0 != 0) goto L_0x001d;
    L_0x0006:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r6);
        r6 = ": file not found";
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x001d:
        r0 = r6.isFile();
        if (r0 != 0) goto L_0x003a;
    L_0x0023:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r6);
        r6 = ": not a file";
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x003a:
        r0 = r6.canRead();
        if (r0 != 0) goto L_0x0057;
    L_0x0040:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r6);
        r6 = ": file not readable";
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x0057:
        r0 = r6.length();
        r2 = (int) r0;
        r3 = (long) r2;
        r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r5 == 0) goto L_0x0078;
    L_0x0061:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r6);
        r6 = ": file too long";
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x0078:
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>(r2);
        r1 = 0;
        r2 = new java.io.BufferedInputStream;	 Catch:{ all -> 0x00a2 }
        r3 = new java.io.FileInputStream;	 Catch:{ all -> 0x00a2 }
        r3.<init>(r6);	 Catch:{ all -> 0x00a2 }
        r2.<init>(r3);	 Catch:{ all -> 0x00a2 }
        r6 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r6 = new byte[r6];	 Catch:{ all -> 0x009f }
    L_0x008c:
        r1 = r2.read(r6);	 Catch:{ all -> 0x009f }
        if (r1 <= 0) goto L_0x0097;	 Catch:{ all -> 0x009f }
    L_0x0092:
        r3 = 0;	 Catch:{ all -> 0x009f }
        r0.write(r6, r3, r1);	 Catch:{ all -> 0x009f }
        goto L_0x008c;
    L_0x0097:
        r2.close();	 Catch:{ Exception -> 0x009a }
    L_0x009a:
        r6 = r0.toByteArray();
        return r6;
    L_0x009f:
        r6 = move-exception;
        r1 = r2;
        goto L_0x00a3;
    L_0x00a2:
        r6 = move-exception;
    L_0x00a3:
        if (r1 == 0) goto L_0x00a8;
    L_0x00a5:
        r1.close();	 Catch:{ Exception -> 0x00a8 }
    L_0x00a8:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dex.util.FileUtils.readFile(java.io.File):byte[]");
    }

    public static byte[] readStream(InputStream inputStream) throws IOException {
        return readStream(inputStream, 32768);
    }

    public static byte[] readStream(InputStream inputStream, int i) throws IOException {
        if (i <= 0) {
            i = 32768;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
        i = new byte[8192];
        while (true) {
            int read = inputStream.read(i);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(i, 0, read);
        }
    }

    public static boolean hasArchiveSuffix(String str) {
        if (!(str.endsWith(".zip") || str.endsWith(ShareConstants.JAR_SUFFIX))) {
            if (str.endsWith(ShareConstants.PATCH_SUFFIX) == null) {
                return null;
            }
        }
        return true;
    }
}
