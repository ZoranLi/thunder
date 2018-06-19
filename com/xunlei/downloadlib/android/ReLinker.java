package com.xunlei.downloadlib.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReLinker {
    private static final String a = "Relinker";
    private static final String b = "lib";
    private static final int c = 5;
    private static final int d = 4096;

    static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    private ReLinker() {
    }

    public static void loadLibrary(Context context, String str) {
        File file;
        StringBuilder stringBuilder;
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        } else {
            String str2 = null;
            try {
                try {
                    str2 = (String) ApplicationInfo.class.getField("nativeLibraryDir").get(context.getApplicationInfo());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                }
                if (str2 == null) {
                    System.loadLibrary(str);
                    return;
                }
                file = new File(str2, System.mapLibraryName(str));
                if (file.exists()) {
                    System.load(file.getAbsolutePath());
                    return;
                }
                stringBuilder = new StringBuilder("so file not exist, path=");
                stringBuilder.append(file.getAbsolutePath());
                throw new UnsatisfiedLinkError(stringBuilder.toString());
            } catch (UnsatisfiedLinkError e4) {
                String str3 = a;
                stringBuilder = new StringBuilder("loadLibrary, linkError=");
                stringBuilder.append(e4.getMessage());
                XLLog.e(str3, stringBuilder.toString());
                file = a(context, str);
                String str4 = a;
                StringBuilder stringBuilder2 = new StringBuilder("loadLibrary, workaroundFile=");
                stringBuilder2.append(file.getPath());
                XLLog.i(str4, stringBuilder2.toString());
                if (!file.exists()) {
                    synchronized (ReLinker.class) {
                        if (!file.exists()) {
                            b(context, str);
                        }
                    }
                }
                System.load(file.getAbsolutePath());
            } catch (Context context2) {
                str = a;
                StringBuilder stringBuilder3 = new StringBuilder("loadLibrary exception=");
                stringBuilder3.append(context2.getMessage());
                XLLog.e(str, stringBuilder3.toString());
            }
        }
    }

    private static File a(Context context) {
        return context.getDir("lib", 0);
    }

    private static File a(Context context, String str) {
        return new File(a(context), System.mapLibraryName(str));
    }

    @android.annotation.SuppressLint({"NewApi"})
    private static void b(android.content.Context r14, java.lang.String r15) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.xunlei.downloadlib.android.ReLinker.b(android.content.Context, java.lang.String):void. bs: [B:15:0x002a, B:81:0x0122]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
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
        r0 = "Relinker";
        r1 = "unpackLibrary";
        com.xunlei.downloadlib.android.XLLog.i(r0, r1);
        r0 = 0;
        r1 = r14.getApplicationInfo();	 Catch:{ Exception -> 0x0179 }
        r2 = 0;
        r3 = r2;
    L_0x000e:
        r4 = r3 + 1;
        r5 = 5;
        r6 = 1;
        if (r3 >= r5) goto L_0x0027;
    L_0x0014:
        r3 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x0021 }
        r7 = new java.io.File;	 Catch:{ IOException -> 0x0021 }
        r8 = r1.sourceDir;	 Catch:{ IOException -> 0x0021 }
        r7.<init>(r8);	 Catch:{ IOException -> 0x0021 }
        r3.<init>(r7, r6);	 Catch:{ IOException -> 0x0021 }
        goto L_0x0028;
    L_0x0021:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ Exception -> 0x0179 }
        r3 = r4;
        goto L_0x000e;
    L_0x0027:
        r3 = r0;
    L_0x0028:
        if (r3 != 0) goto L_0x0052;
    L_0x002a:
        r14 = "Relinker";	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r0 = "zipFile == null, path=";	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r15.<init>(r0);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r0 = r1.sourceDir;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r15.append(r0);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r15 = r15.toString();	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        com.xunlei.downloadlib.android.XLLog.i(r14, r15);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        if (r3 == 0) goto L_0x004a;
    L_0x0041:
        r3.close();	 Catch:{ IOException -> 0x0045 }
        goto L_0x004a;
    L_0x0045:
        r14 = move-exception;
        r14.printStackTrace();
        return;
    L_0x004a:
        return;
    L_0x004b:
        r14 = move-exception;
        goto L_0x019d;
    L_0x004e:
        r14 = move-exception;
        r0 = r3;
        goto L_0x017a;
    L_0x0052:
        r1 = r2;
    L_0x0053:
        r4 = r1 + 1;
        if (r1 >= r5) goto L_0x016a;
    L_0x0057:
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r7 = 21;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        if (r1 < r7) goto L_0x0064;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x005d:
        r1 = a();	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r7 = r1.length;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        if (r7 > 0) goto L_0x006f;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x0064:
        r1 = 2;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r7 = android.os.Build.CPU_ABI;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1[r2] = r7;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r7 = android.os.Build.CPU_ABI2;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1[r6] = r7;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x006f:
        r7 = r1.length;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r9 = r0;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r10 = r9;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r8 = r2;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x0073:
        if (r8 >= r7) goto L_0x00ad;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x0075:
        r9 = r1[r8];	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r11 = "lib/";	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r10.<init>(r11);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r10.append(r9);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r9 = "/";	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r10.append(r9);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r9 = java.lang.System.mapLibraryName(r15);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r10.append(r9);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r10 = r10.toString();	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r9 = r3.getEntry(r10);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r11 = "Relinker";	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r13 = "zipFile.getEntry, jniNameInApk=";	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r12.<init>(r13);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r12.append(r10);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r12 = r12.toString();	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        com.xunlei.downloadlib.android.XLLog.i(r11, r12);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        if (r9 != 0) goto L_0x00ad;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x00aa:
        r8 = r8 + 1;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        goto L_0x0073;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x00ad:
        if (r9 != 0) goto L_0x00c4;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x00af:
        r14 = "Relinker";	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r0 = "Does not exist in the APK";	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        com.xunlei.downloadlib.android.XLLog.e(r14, r0);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        if (r10 == 0) goto L_0x00be;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x00b8:
        r14 = new com.xunlei.downloadlib.android.ReLinker$a;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r14.<init>(r10);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        throw r14;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x00be:
        r14 = new com.xunlei.downloadlib.android.ReLinker$a;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r14.<init>(r15);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        throw r14;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x00c4:
        r1 = a(r14, r15);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1.delete();	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r7 = r1.createNewFile();	 Catch:{ IOException -> 0x014f }
        if (r7 != 0) goto L_0x00da;	 Catch:{ IOException -> 0x014f }
    L_0x00d1:
        r1 = "Relinker";	 Catch:{ IOException -> 0x014f }
        r7 = "outputFile.createNewFile() failed";	 Catch:{ IOException -> 0x014f }
        com.xunlei.downloadlib.android.XLLog.i(r1, r7);	 Catch:{ IOException -> 0x014f }
        goto L_0x0167;
    L_0x00da:
        r7 = r3.getInputStream(r9);	 Catch:{ FileNotFoundException -> 0x0129, IOException -> 0x0108, all -> 0x0104 }
        r8 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
        r8.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
        a(r7, r8);	 Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00f7 }
        a(r7);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        a(r8);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1.setReadable(r6, r2);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1.setExecutable(r6, r2);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1.setWritable(r6);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        goto L_0x016a;
    L_0x00f7:
        r1 = move-exception;
        goto L_0x010b;
    L_0x00f9:
        r1 = move-exception;
        goto L_0x012c;
    L_0x00fb:
        r14 = move-exception;
        r8 = r0;
        goto L_0x0148;
    L_0x00fe:
        r1 = move-exception;
        r8 = r0;
        goto L_0x010b;
    L_0x0101:
        r1 = move-exception;
        r8 = r0;
        goto L_0x012c;
    L_0x0104:
        r14 = move-exception;
        r7 = r0;
        r8 = r7;
        goto L_0x0148;
    L_0x0108:
        r1 = move-exception;
        r7 = r0;
        r8 = r7;
    L_0x010b:
        r9 = "Relinker";	 Catch:{ all -> 0x0147 }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0147 }
        r11 = " copy(inputStream, fileOut), IOException, ";	 Catch:{ all -> 0x0147 }
        r10.<init>(r11);	 Catch:{ all -> 0x0147 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0147 }
        r10.append(r1);	 Catch:{ all -> 0x0147 }
        r1 = r10.toString();	 Catch:{ all -> 0x0147 }
        com.xunlei.downloadlib.android.XLLog.e(r9, r1);	 Catch:{ all -> 0x0147 }
        a(r7);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x0125:
        a(r8);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        goto L_0x0167;
    L_0x0129:
        r1 = move-exception;
        r7 = r0;
        r8 = r7;
    L_0x012c:
        r9 = "Relinker";	 Catch:{ all -> 0x0147 }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0147 }
        r11 = " copy(inputStream, fileOut), FileNotFoundException, ";	 Catch:{ all -> 0x0147 }
        r10.<init>(r11);	 Catch:{ all -> 0x0147 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0147 }
        r10.append(r1);	 Catch:{ all -> 0x0147 }
        r1 = r10.toString();	 Catch:{ all -> 0x0147 }
        com.xunlei.downloadlib.android.XLLog.e(r9, r1);	 Catch:{ all -> 0x0147 }
        a(r7);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        goto L_0x0125;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x0147:
        r14 = move-exception;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x0148:
        a(r7);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        a(r8);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        throw r14;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x014f:
        r1 = move-exception;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r7 = "Relinker";	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r9 = "IOException ignored, ";	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r8.<init>(r9);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1 = r1.getMessage();	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r8.append(r1);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1 = r8.toString();	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        com.xunlei.downloadlib.android.XLLog.i(r7, r1);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
    L_0x0167:
        r1 = r4;
        goto L_0x0053;
    L_0x016a:
        if (r3 == 0) goto L_0x0175;
    L_0x016c:
        r3.close();	 Catch:{ IOException -> 0x0170 }
        goto L_0x0175;
    L_0x0170:
        r14 = move-exception;
        r14.printStackTrace();
        return;
    L_0x0175:
        return;
    L_0x0176:
        r14 = move-exception;
        r3 = r0;
        goto L_0x019d;
    L_0x0179:
        r14 = move-exception;
    L_0x017a:
        r15 = "Relinker";	 Catch:{ all -> 0x0176 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0176 }
        r2 = "unpackLibrary, Exception=";	 Catch:{ all -> 0x0176 }
        r1.<init>(r2);	 Catch:{ all -> 0x0176 }
        r14 = r14.getMessage();	 Catch:{ all -> 0x0176 }
        r1.append(r14);	 Catch:{ all -> 0x0176 }
        r14 = r1.toString();	 Catch:{ all -> 0x0176 }
        com.xunlei.downloadlib.android.XLLog.e(r15, r14);	 Catch:{ all -> 0x0176 }
        if (r0 == 0) goto L_0x019c;
    L_0x0193:
        r0.close();	 Catch:{ IOException -> 0x0197 }
        goto L_0x019c;
    L_0x0197:
        r14 = move-exception;
        r14.printStackTrace();
        return;
    L_0x019c:
        return;
    L_0x019d:
        if (r3 == 0) goto L_0x01a7;
    L_0x019f:
        r3.close();	 Catch:{ IOException -> 0x01a3 }
        goto L_0x01a7;
    L_0x01a3:
        r15 = move-exception;
        r15.printStackTrace();
    L_0x01a7:
        throw r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.android.ReLinker.b(android.content.Context, java.lang.String):void");
    }

    private static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                closeable2.printStackTrace();
            }
        }
    }

    private static String[] a() {
        String str;
        StringBuilder stringBuilder;
        String[] strArr = new String[0];
        try {
            return (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
        } catch (IllegalAccessException e) {
            str = a;
            stringBuilder = new StringBuilder(" getSupportedABIs IllegalAccessException, ");
            stringBuilder.append(e.getMessage());
            XLLog.e(str, stringBuilder.toString());
            e.printStackTrace();
            return strArr;
        } catch (IllegalArgumentException e2) {
            str = a;
            stringBuilder = new StringBuilder(" getSupportedABIs IllegalArgumentException, ");
            stringBuilder.append(e2.getMessage());
            XLLog.e(str, stringBuilder.toString());
            e2.printStackTrace();
            return strArr;
        } catch (NoSuchFieldException e3) {
            str = a;
            stringBuilder = new StringBuilder(" getSupportedABIs NoSuchFieldException, ");
            stringBuilder.append(e3.getMessage());
            XLLog.e(str, stringBuilder.toString());
            e3.printStackTrace();
            return strArr;
        }
    }
}
