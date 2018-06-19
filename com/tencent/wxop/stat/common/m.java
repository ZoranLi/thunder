package com.tencent.wxop.stat.common;

import java.io.File;
import java.io.InputStream;

class m {
    static int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new n()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    static int b() {
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(new String(bArr));
                str = stringBuilder.toString();
            }
            inputStream.close();
            str = str.trim();
            if (str.length() > 0) {
                i = Integer.valueOf(str).intValue();
            }
        } catch (Throwable e) {
            l.k.e(e);
        }
        return i * 1000;
    }

    static int c() {
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(new String(bArr));
                str = stringBuilder.toString();
            }
            inputStream.close();
            str = str.trim();
            if (str.length() > 0) {
                i = Integer.valueOf(str).intValue();
            }
        } catch (Throwable th) {
            l.k.e(th);
        }
        return i * 1000;
    }

    static java.lang.String d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "/proc/cpuinfo";
        r1 = 2;
        r2 = new java.lang.String[r1];
        r3 = "";
        r4 = 0;
        r2[r4] = r3;
        r3 = "";
        r5 = 1;
        r2[r5] = r3;
        r3 = new java.io.FileReader;	 Catch:{ IOException -> 0x0048 }
        r3.<init>(r0);	 Catch:{ IOException -> 0x0048 }
        r0 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0048 }
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ IOException -> 0x0048 }
        r0.<init>(r3, r5);	 Catch:{ IOException -> 0x0048 }
        r3 = r0.readLine();	 Catch:{ IOException -> 0x0048 }
        r5 = "\\s+";	 Catch:{ IOException -> 0x0048 }
        r3 = r3.split(r5);	 Catch:{ IOException -> 0x0048 }
    L_0x0025:
        r5 = r3.length;	 Catch:{ IOException -> 0x0048 }
        if (r1 >= r5) goto L_0x0045;	 Catch:{ IOException -> 0x0048 }
    L_0x0028:
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0048 }
        r5.<init>();	 Catch:{ IOException -> 0x0048 }
        r6 = r2[r4];	 Catch:{ IOException -> 0x0048 }
        r5.append(r6);	 Catch:{ IOException -> 0x0048 }
        r6 = r3[r1];	 Catch:{ IOException -> 0x0048 }
        r5.append(r6);	 Catch:{ IOException -> 0x0048 }
        r6 = " ";	 Catch:{ IOException -> 0x0048 }
        r5.append(r6);	 Catch:{ IOException -> 0x0048 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x0048 }
        r2[r4] = r5;	 Catch:{ IOException -> 0x0048 }
        r1 = r1 + 1;	 Catch:{ IOException -> 0x0048 }
        goto L_0x0025;	 Catch:{ IOException -> 0x0048 }
    L_0x0045:
        r0.close();	 Catch:{ IOException -> 0x0048 }
    L_0x0048:
        r0 = r2[r4];
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.m.d():java.lang.String");
    }
}
