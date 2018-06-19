package com.duiba.maila.sdk.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public final class f {
    private static String a = "/sdcard/data/my/ml.properties";

    public static void a(java.lang.String r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "nslct";
        r1 = "al";
        r0 = c(r0, r1);
        r1 = new java.util.Properties;
        r1.<init>();
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r3 = a;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r3 = r2.getParentFile();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r3 = r3.exists();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        if (r3 != 0) goto L_0x0025;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
    L_0x001e:
        r3 = r2.getParentFile();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r3.mkdirs();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
    L_0x0025:
        r3 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r5 = r2.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r4.append(r5);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r5 = ".lock";	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r4.append(r5);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r4 = r3.exists();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        if (r4 != 0) goto L_0x0048;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
    L_0x0045:
        r3.createNewFile();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
    L_0x0048:
        r4 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r5 = "rw";	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r4.<init>(r3, r5);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r3 = r4.getChannel();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r5 = r3.tryLock();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        if (r5 != 0) goto L_0x0071;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
    L_0x0059:
        r8 = new java.io.IOException;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r9 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r0 = "Can not lock the registry cache file";	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r9.<init>(r0);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r0 = r2.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r9.append(r0);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r9 = r9.toString();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        throw r8;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
    L_0x0071:
        r6 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r6.<init>(r2);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r2 = 0;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r7 = r0[r2];	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        if (r7 == 0) goto L_0x0082;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
    L_0x007b:
        r7 = "nslct";	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r2 = r0[r2];	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r1.setProperty(r7, r2);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
    L_0x0082:
        r2 = 1;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r7 = r0[r2];	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        if (r7 == 0) goto L_0x008e;	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
    L_0x0087:
        r7 = "al";	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r0 = r0[r2];	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r1.setProperty(r7, r0);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
    L_0x008e:
        r0 = "slct";	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r1.setProperty(r0, r9);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r9 = "scm";	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r1.setProperty(r9, r8);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r8 = "xianhongwei modify";	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r1.store(r6, r8);	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r6.close();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r5.release();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r3.close();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        r4.close();	 Catch:{ FileNotFoundException -> 0x00b0, IOException -> 0x00ab, Exception -> 0x00aa }
        return;
    L_0x00aa:
        return;
    L_0x00ab:
        r8 = move-exception;
        r8.printStackTrace();
        return;
    L_0x00b0:
        r8 = move-exception;
        r8.printStackTrace();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duiba.maila.sdk.util.f.a(java.lang.String, java.lang.String):void");
    }

    public static void b(java.lang.String r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "slct";
        r1 = "scm";
        r0 = c(r0, r1);
        r1 = new java.util.Properties;
        r1.<init>();
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r3 = a;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r3 = r2.getParentFile();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r3 = r3.exists();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        if (r3 != 0) goto L_0x0025;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
    L_0x001e:
        r3 = r2.getParentFile();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r3.mkdirs();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
    L_0x0025:
        r3 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r5 = r2.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r5 = ".lock";	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r3.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r4 = r3.exists();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        if (r4 != 0) goto L_0x0048;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
    L_0x0045:
        r3.createNewFile();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
    L_0x0048:
        r4 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r5 = "rw";	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r4.<init>(r3, r5);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r3 = r4.getChannel();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r5 = r3.tryLock();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        if (r5 != 0) goto L_0x005a;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
    L_0x0059:
        return;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
    L_0x005a:
        r6 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r6.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r2 = 0;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r7 = r0[r2];	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        if (r7 == 0) goto L_0x006b;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
    L_0x0064:
        r7 = "slct";	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r2 = r0[r2];	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r1.setProperty(r7, r2);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
    L_0x006b:
        r2 = 1;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r7 = r0[r2];	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        if (r7 == 0) goto L_0x0077;	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
    L_0x0070:
        r7 = "scm";	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r0 = r0[r2];	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r1.setProperty(r7, r0);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
    L_0x0077:
        r0 = "nslct";	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r1.setProperty(r0, r9);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r9 = "al";	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r1.setProperty(r9, r8);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r8 = "xianhongwei modify";	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r1.store(r6, r8);	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r6.close();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r5.release();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r3.close();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        r4.close();	 Catch:{ FileNotFoundException -> 0x0095, IOException -> 0x0094, Exception -> 0x0093 }
        return;
    L_0x0093:
        return;
    L_0x0094:
        return;
    L_0x0095:
        r8 = move-exception;
        r8.printStackTrace();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duiba.maila.sdk.util.f.b(java.lang.String, java.lang.String):void");
    }

    private static String[] c(String str, String str2) {
        String[] strArr = new String[2];
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            InputStream fileInputStream = new FileInputStream(a);
            try {
                properties.load(fileInputStream);
                strArr[0] = properties.getProperty(str);
                strArr[1] = properties.getProperty(str2);
                try {
                    fileInputStream.close();
                } catch (String str3) {
                    str3.printStackTrace();
                }
            } catch (Exception e) {
                str3 = e;
                inputStream = fileInputStream;
                try {
                    str3.getMessage();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return strArr;
                } catch (Throwable th) {
                    str3 = th;
                    fileInputStream = inputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (String str22) {
                            str22.printStackTrace();
                        }
                    }
                    throw str3;
                }
            } catch (Throwable th2) {
                str3 = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw str3;
            }
        } catch (Exception e2) {
            str3 = e2;
            str3.getMessage();
            if (inputStream != null) {
                inputStream.close();
            }
            return strArr;
        }
        return strArr;
    }
}
