package com.xiaomi.channel.commonutils.misc;

import android.os.Environment;

public class f {
    private static final String a;
    private static final String b;
    private static final String c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
        stringBuilder.append("/mipush/");
        a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("lcfp");
        b = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("lcfp.lock");
        c = stringBuilder.toString();
    }

    public static boolean a(android.content.Context r4, java.lang.String r5, long r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ IOException -> 0x0038, all -> 0x0035 }
        r2 = c;	 Catch:{ IOException -> 0x0038, all -> 0x0035 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0038, all -> 0x0035 }
        com.xiaomi.channel.commonutils.file.a.a(r1);	 Catch:{ IOException -> 0x0038, all -> 0x0035 }
        r2 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x0038, all -> 0x0035 }
        r3 = "rw";	 Catch:{ IOException -> 0x0038, all -> 0x0035 }
        r2.<init>(r1, r3);	 Catch:{ IOException -> 0x0038, all -> 0x0035 }
        r1 = r2.getChannel();	 Catch:{ IOException -> 0x0033 }
        r1 = r1.lock();	 Catch:{ IOException -> 0x0033 }
        r4 = b(r4, r5, r6);	 Catch:{ IOException -> 0x0030, all -> 0x002d }
        if (r1 == 0) goto L_0x0029;
    L_0x0020:
        r5 = r1.isValid();
        if (r5 == 0) goto L_0x0029;
    L_0x0026:
        r1.release();	 Catch:{ IOException -> 0x0029 }
    L_0x0029:
        com.xiaomi.channel.commonutils.file.a.a(r2);
        return r4;
    L_0x002d:
        r4 = move-exception;
        r0 = r1;
        goto L_0x004e;
    L_0x0030:
        r4 = move-exception;
        r0 = r1;
        goto L_0x003a;
    L_0x0033:
        r4 = move-exception;
        goto L_0x003a;
    L_0x0035:
        r4 = move-exception;
        r2 = r0;
        goto L_0x004e;
    L_0x0038:
        r4 = move-exception;
        r2 = r0;
    L_0x003a:
        r4.printStackTrace();	 Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x0048;
    L_0x003f:
        r4 = r0.isValid();
        if (r4 == 0) goto L_0x0048;
    L_0x0045:
        r0.release();	 Catch:{ IOException -> 0x0048 }
    L_0x0048:
        com.xiaomi.channel.commonutils.file.a.a(r2);
        r4 = 1;
        return r4;
    L_0x004d:
        r4 = move-exception;
    L_0x004e:
        if (r0 == 0) goto L_0x0059;
    L_0x0050:
        r5 = r0.isValid();
        if (r5 == 0) goto L_0x0059;
    L_0x0056:
        r0.release();	 Catch:{ IOException -> 0x0059 }
    L_0x0059:
        com.xiaomi.channel.commonutils.file.a.a(r2);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.misc.f.a(android.content.Context, java.lang.String, long):boolean");
    }

    private static boolean b(android.content.Context r17, java.lang.String r18, long r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 1;
        r3 = 23;
        if (r1 < r3) goto L_0x0012;
    L_0x0007:
        r1 = "android.permission.WRITE_EXTERNAL_STORAGE";
        r3 = r17;
        r1 = com.xiaomi.channel.commonutils.android.a.g(r3, r1);
        if (r1 != 0) goto L_0x0014;
    L_0x0011:
        return r2;
    L_0x0012:
        r3 = r17;
    L_0x0014:
        r1 = new java.io.File;
        r4 = b;
        r1.<init>(r4);
        r4 = new java.util.ArrayList;
        r4.<init>();
        r5 = java.lang.System.currentTimeMillis();
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r18;
        r7.append(r8);
        r9 = ":";
        r7.append(r9);
        r9 = r17.getPackageName();
        r7.append(r9);
        r9 = ",";
        r7.append(r9);
        r7.append(r5);
        r7 = r7.toString();
        r9 = r1.exists();
        if (r9 == 0) goto L_0x00c8;
    L_0x004c:
        r9 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
        r11 = new java.io.FileReader;	 Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
        r11.<init>(r1);	 Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
        r9.<init>(r11);	 Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
    L_0x0056:
        r11 = r9.readLine();	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        if (r11 == 0) goto L_0x00ac;	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
    L_0x005c:
        r12 = ":";	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r12 = r11.split(r12);	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r13 = r12.length;	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r14 = 2;	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        if (r13 != r14) goto L_0x0056;	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
    L_0x0066:
        r13 = 0;	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r15 = r12[r13];	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r10 = java.lang.String.valueOf(r18);	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r10 = android.text.TextUtils.equals(r15, r10);	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        if (r10 == 0) goto L_0x00a8;	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
    L_0x0073:
        r10 = r12[r2];	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r11 = ",";	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r10 = r10.split(r11);	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r11 = r10.length;	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        if (r11 != r14) goto L_0x0056;	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
    L_0x007e:
        r11 = r10[r2];	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r11 = java.lang.Long.parseLong(r11);	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r10 = r10[r13];	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r14 = r17.getPackageName();	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r10 = android.text.TextUtils.equals(r10, r14);	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        if (r10 != 0) goto L_0x0056;	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
    L_0x0090:
        r14 = r5 - r11;	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r10 = java.lang.Math.abs(r14);	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        r10 = (float) r10;
        r11 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = r11 * r19;
        r11 = (float) r11;
        r12 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;
        r11 = r11 * r12;
        r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1));
        if (r10 >= 0) goto L_0x0056;
    L_0x00a4:
        com.xiaomi.channel.commonutils.file.a.a(r9);
        return r13;
    L_0x00a8:
        r4.add(r11);	 Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        goto L_0x0056;
    L_0x00ac:
        com.xiaomi.channel.commonutils.file.a.a(r9);
        goto L_0x00cf;
    L_0x00b0:
        r0 = move-exception;
        r1 = r0;
        goto L_0x00c4;
    L_0x00b3:
        r10 = r9;
        goto L_0x00ba;
    L_0x00b5:
        r0 = move-exception;
        r1 = r0;
        r9 = 0;
        goto L_0x00c4;
    L_0x00b9:
        r10 = 0;
    L_0x00ba:
        r4.clear();	 Catch:{ all -> 0x00c1 }
        com.xiaomi.channel.commonutils.file.a.a(r10);
        goto L_0x00cf;
    L_0x00c1:
        r0 = move-exception;
        r1 = r0;
        r9 = r10;
    L_0x00c4:
        com.xiaomi.channel.commonutils.file.a.a(r9);
        throw r1;
    L_0x00c8:
        r3 = com.xiaomi.channel.commonutils.file.a.a(r1);
        if (r3 != 0) goto L_0x00cf;
    L_0x00ce:
        return r2;
    L_0x00cf:
        r4.add(r7);
        r10 = new java.io.BufferedWriter;	 Catch:{ IOException -> 0x00fd, all -> 0x00f9 }
        r3 = new java.io.FileWriter;	 Catch:{ IOException -> 0x00fd, all -> 0x00f9 }
        r3.<init>(r1);	 Catch:{ IOException -> 0x00fd, all -> 0x00f9 }
        r10.<init>(r3);	 Catch:{ IOException -> 0x00fd, all -> 0x00f9 }
        r1 = r4.iterator();	 Catch:{ IOException -> 0x00f6 }
    L_0x00e0:
        r3 = r1.hasNext();	 Catch:{ IOException -> 0x00f6 }
        if (r3 == 0) goto L_0x0107;	 Catch:{ IOException -> 0x00f6 }
    L_0x00e6:
        r3 = r1.next();	 Catch:{ IOException -> 0x00f6 }
        r3 = (java.lang.String) r3;	 Catch:{ IOException -> 0x00f6 }
        r10.write(r3);	 Catch:{ IOException -> 0x00f6 }
        r10.newLine();	 Catch:{ IOException -> 0x00f6 }
        r10.flush();	 Catch:{ IOException -> 0x00f6 }
        goto L_0x00e0;
    L_0x00f6:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0100;
    L_0x00f9:
        r0 = move-exception;
        r1 = r0;
        r10 = 0;
        goto L_0x010d;
    L_0x00fd:
        r0 = move-exception;
        r1 = r0;
        r10 = 0;
    L_0x0100:
        r1 = r1.toString();	 Catch:{ all -> 0x010b }
        com.xiaomi.channel.commonutils.logger.b.d(r1);	 Catch:{ all -> 0x010b }
    L_0x0107:
        com.xiaomi.channel.commonutils.file.a.a(r10);
        return r2;
    L_0x010b:
        r0 = move-exception;
        r1 = r0;
    L_0x010d:
        com.xiaomi.channel.commonutils.file.a.a(r10);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.misc.f.b(android.content.Context, java.lang.String, long):boolean");
    }
}
