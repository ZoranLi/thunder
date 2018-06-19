package com.igexin.a;

import java.io.InputStream;
import java.io.OutputStream;

public class a implements d {
    private long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                outputStream.flush();
                return j;
            }
        }
    }

    private void a(java.io.Closeable r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        if (r1 == 0) goto L_0x0006;
    L_0x0002:
        r1.close();	 Catch:{ IOException -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.a.a.a(java.io.Closeable):void");
    }

    public void a(android.content.Context r19, java.lang.String[] r20, java.lang.String r21, java.io.File r22, com.igexin.a.h r23) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r18 = this;
        r1 = r18;
        r2 = r20;
        r3 = r21;
        r4 = r22;
        r5 = r23;
        r7 = r19.getApplicationInfo();	 Catch:{ all -> 0x00ff }
        r8 = 0;
        r9 = r8;
    L_0x0010:
        r10 = r9 + 1;
        r11 = 5;
        r12 = 1;
        if (r9 >= r11) goto L_0x0025;
    L_0x0016:
        r9 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x0023 }
        r13 = new java.io.File;	 Catch:{ IOException -> 0x0023 }
        r14 = r7.sourceDir;	 Catch:{ IOException -> 0x0023 }
        r13.<init>(r14);	 Catch:{ IOException -> 0x0023 }
        r9.<init>(r13, r12);	 Catch:{ IOException -> 0x0023 }
        goto L_0x0026;
    L_0x0023:
        r9 = r10;
        goto L_0x0010;
    L_0x0025:
        r9 = 0;
    L_0x0026:
        if (r9 != 0) goto L_0x0038;
    L_0x0028:
        r2 = "FATAL! Couldn't find application APK!";	 Catch:{ all -> 0x0034 }
        r5.a(r2);	 Catch:{ all -> 0x0034 }
        if (r9 == 0) goto L_0x0033;
    L_0x002f:
        r9.close();	 Catch:{ IOException -> 0x0033 }
        return;
    L_0x0033:
        return;
    L_0x0034:
        r0 = move-exception;
        r2 = r0;
        goto L_0x0102;
    L_0x0038:
        r7 = r8;
    L_0x0039:
        r10 = r7 + 1;
        if (r7 >= r11) goto L_0x00f3;
    L_0x003d:
        r7 = r2.length;	 Catch:{ all -> 0x0034 }
        r13 = r8;	 Catch:{ all -> 0x0034 }
        r14 = 0;	 Catch:{ all -> 0x0034 }
        r15 = 0;	 Catch:{ all -> 0x0034 }
    L_0x0041:
        if (r13 >= r7) goto L_0x0069;	 Catch:{ all -> 0x0034 }
    L_0x0043:
        r14 = r2[r13];	 Catch:{ all -> 0x0034 }
        r15 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0034 }
        r6 = "lib";	 Catch:{ all -> 0x0034 }
        r15.<init>(r6);	 Catch:{ all -> 0x0034 }
        r6 = java.io.File.separatorChar;	 Catch:{ all -> 0x0034 }
        r15.append(r6);	 Catch:{ all -> 0x0034 }
        r15.append(r14);	 Catch:{ all -> 0x0034 }
        r6 = java.io.File.separatorChar;	 Catch:{ all -> 0x0034 }
        r15.append(r6);	 Catch:{ all -> 0x0034 }
        r15.append(r3);	 Catch:{ all -> 0x0034 }
        r14 = r15.toString();	 Catch:{ all -> 0x0034 }
        r15 = r9.getEntry(r14);	 Catch:{ all -> 0x0034 }
        if (r15 != 0) goto L_0x0069;	 Catch:{ all -> 0x0034 }
    L_0x0066:
        r13 = r13 + 1;	 Catch:{ all -> 0x0034 }
        goto L_0x0041;	 Catch:{ all -> 0x0034 }
    L_0x0069:
        if (r14 == 0) goto L_0x0074;	 Catch:{ all -> 0x0034 }
    L_0x006b:
        r6 = "Looking for %s in APK...";	 Catch:{ all -> 0x0034 }
        r7 = new java.lang.Object[r12];	 Catch:{ all -> 0x0034 }
        r7[r8] = r14;	 Catch:{ all -> 0x0034 }
        r5.a(r6, r7);	 Catch:{ all -> 0x0034 }
    L_0x0074:
        if (r15 != 0) goto L_0x0084;	 Catch:{ all -> 0x0034 }
    L_0x0076:
        if (r14 == 0) goto L_0x007e;	 Catch:{ all -> 0x0034 }
    L_0x0078:
        r2 = new com.igexin.a.b;	 Catch:{ all -> 0x0034 }
        r2.<init>(r14);	 Catch:{ all -> 0x0034 }
        throw r2;	 Catch:{ all -> 0x0034 }
    L_0x007e:
        r2 = new com.igexin.a.b;	 Catch:{ all -> 0x0034 }
        r2.<init>(r3);	 Catch:{ all -> 0x0034 }
        throw r2;	 Catch:{ all -> 0x0034 }
    L_0x0084:
        r6 = "Found %s! Extracting...";	 Catch:{ all -> 0x0034 }
        r7 = new java.lang.Object[r12];	 Catch:{ all -> 0x0034 }
        r7[r8] = r14;	 Catch:{ all -> 0x0034 }
        r5.a(r6, r7);	 Catch:{ all -> 0x0034 }
        r6 = r22.exists();	 Catch:{ IOException -> 0x00f0 }
        if (r6 != 0) goto L_0x009a;	 Catch:{ IOException -> 0x00f0 }
    L_0x0093:
        r6 = r22.createNewFile();	 Catch:{ IOException -> 0x00f0 }
        if (r6 != 0) goto L_0x009a;
    L_0x0099:
        goto L_0x00f0;
    L_0x009a:
        r6 = r9.getInputStream(r15);	 Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e4, all -> 0x00d9 }
        r7 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x00eb, IOException -> 0x00e5, all -> 0x00d6 }
        r7.<init>(r4);	 Catch:{ FileNotFoundException -> 0x00eb, IOException -> 0x00e5, all -> 0x00d6 }
        r13 = r1.a(r6, r7);	 Catch:{ FileNotFoundException -> 0x00ec, IOException -> 0x00e6, all -> 0x00d3 }
        r15 = r7.getFD();	 Catch:{ FileNotFoundException -> 0x00ec, IOException -> 0x00e6, all -> 0x00d3 }
        r15.sync();	 Catch:{ FileNotFoundException -> 0x00ec, IOException -> 0x00e6, all -> 0x00d3 }
        r16 = r22.length();	 Catch:{ FileNotFoundException -> 0x00ec, IOException -> 0x00e6, all -> 0x00d3 }
        r15 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1));
        if (r15 == 0) goto L_0x00bd;
    L_0x00b6:
        r1.a(r6);	 Catch:{ all -> 0x0034 }
    L_0x00b9:
        r1.a(r7);	 Catch:{ all -> 0x0034 }
        goto L_0x00f0;	 Catch:{ all -> 0x0034 }
    L_0x00bd:
        r1.a(r6);	 Catch:{ all -> 0x0034 }
        r1.a(r7);	 Catch:{ all -> 0x0034 }
        r4.setReadable(r12, r8);	 Catch:{ all -> 0x0034 }
        r4.setExecutable(r12, r8);	 Catch:{ all -> 0x0034 }
        r4.setWritable(r12);	 Catch:{ all -> 0x0034 }
        if (r9 == 0) goto L_0x00d2;
    L_0x00ce:
        r9.close();	 Catch:{ IOException -> 0x00d2 }
        return;
    L_0x00d2:
        return;
    L_0x00d3:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00dd;
    L_0x00d6:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00dc;
    L_0x00d9:
        r0 = move-exception;
        r2 = r0;
        r6 = 0;
    L_0x00dc:
        r7 = 0;
    L_0x00dd:
        r1.a(r6);	 Catch:{ all -> 0x0034 }
        r1.a(r7);	 Catch:{ all -> 0x0034 }
        throw r2;	 Catch:{ all -> 0x0034 }
    L_0x00e4:
        r6 = 0;	 Catch:{ all -> 0x0034 }
    L_0x00e5:
        r7 = 0;	 Catch:{ all -> 0x0034 }
    L_0x00e6:
        r1.a(r6);	 Catch:{ all -> 0x0034 }
        goto L_0x00b9;	 Catch:{ all -> 0x0034 }
    L_0x00ea:
        r6 = 0;	 Catch:{ all -> 0x0034 }
    L_0x00eb:
        r7 = 0;	 Catch:{ all -> 0x0034 }
    L_0x00ec:
        r1.a(r6);	 Catch:{ all -> 0x0034 }
        goto L_0x00b9;	 Catch:{ all -> 0x0034 }
    L_0x00f0:
        r7 = r10;	 Catch:{ all -> 0x0034 }
        goto L_0x0039;	 Catch:{ all -> 0x0034 }
    L_0x00f3:
        r2 = "FATAL! Couldn't extract the library from the APK!";	 Catch:{ all -> 0x0034 }
        r5.a(r2);	 Catch:{ all -> 0x0034 }
        if (r9 == 0) goto L_0x00fe;
    L_0x00fa:
        r9.close();	 Catch:{ IOException -> 0x00fe }
        return;
    L_0x00fe:
        return;
    L_0x00ff:
        r0 = move-exception;
        r2 = r0;
        r9 = 0;
    L_0x0102:
        if (r9 == 0) goto L_0x0107;
    L_0x0104:
        r9.close();	 Catch:{ IOException -> 0x0107 }
    L_0x0107:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.a.a.a(android.content.Context, java.lang.String[], java.lang.String, java.io.File, com.igexin.a.h):void");
    }
}
