package com.getui.gtc.e;

import android.text.TextUtils;
import com.getui.gtc.a.a;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class e {
    public static void a(File file) {
        if (file != null) {
            try {
                if (file.isFile()) {
                    file.delete();
                    return;
                }
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        if (listFiles.length != 0) {
                            for (File a : listFiles) {
                                a(a);
                            }
                            file.delete();
                            return;
                        }
                    }
                    file.delete();
                }
            } catch (Throwable th) {
                new String[1][0] = th.toString();
            }
        }
    }

    public static boolean a(File file, File file2, String str) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        Object obj = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(obj);
                            if (read == -1) {
                                break;
                            }
                            Object obj2 = new byte[read];
                            System.arraycopy(obj, 0, obj2, 0, read);
                            bufferedOutputStream.write(obj2);
                        }
                        bufferedOutputStream.flush();
                        String b = j.b(file2.getAbsolutePath());
                        if (!b.equals(str)) {
                            a(file2);
                        }
                        boolean equals = b.equals(str);
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            new String[1][0] = e2.toString();
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e22) {
                            new String[1][0] = e22.toString();
                        }
                        try {
                            fileOutputStream.close();
                            return equals;
                        } catch (Exception e3) {
                            new String[1][0] = e3.toString();
                            return equals;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream2 = fileInputStream;
                        try {
                            new String[1][0] = e.toString();
                            a(file2);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e222) {
                                    new String[1][0] = e222.toString();
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e2222) {
                                    new String[1][0] = e2222.toString();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return false;
                                } catch (Exception e32) {
                                    new String[1][0] = e32.toString();
                                    return false;
                                }
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e5) {
                                    new String[1][0] = e5.toString();
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e52) {
                                    new String[1][0] = e52.toString();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e322) {
                                    new String[1][0] = e322.toString();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e52 = e6;
                    bufferedOutputStream = null;
                    fileInputStream2 = fileInputStream;
                    new String[1][0] = e52.toString();
                    a(file2);
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        return false;
                    }
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedOutputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e52 = e7;
                fileOutputStream = null;
                bufferedOutputStream = fileOutputStream;
                fileInputStream2 = fileInputStream;
                new String[1][0] = e52.toString();
                a(file2);
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return false;
                }
                return false;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                bufferedOutputStream = fileOutputStream;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e8) {
            e52 = e8;
            fileOutputStream = null;
            bufferedOutputStream = fileOutputStream;
            new String[1][0] = e52.toString();
            a(file2);
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
                return false;
            }
            return false;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            fileInputStream = fileOutputStream;
            bufferedOutputStream = fileInputStream;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String str2 = a.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append("/");
            stringBuilder.append(str);
            b(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append("/");
            stringBuilder.append(str);
            stringBuilder.append(ShareConstants.DEX_SUFFIX);
            b(stringBuilder.toString());
            Object c = c(str);
            if (!TextUtils.isEmpty(c)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append("/");
                stringBuilder.append(c);
                b(stringBuilder.toString());
            }
            return true;
        } catch (Exception e) {
            new String[1][0] = e.toString();
            return false;
        }
    }

    public static boolean a(java.lang.String r5, java.lang.String r6) {
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
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        if (r0 != 0) goto L_0x006a;
    L_0x0007:
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = c(r6);
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0061 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0061 }
        r3.<init>();	 Catch:{ Throwable -> 0x0061 }
        r3.append(r5);	 Catch:{ Throwable -> 0x0061 }
        r4 = "/";	 Catch:{ Throwable -> 0x0061 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0061 }
        r3.append(r6);	 Catch:{ Throwable -> 0x0061 }
        r6 = ".dex";	 Catch:{ Throwable -> 0x0061 }
        r3.append(r6);	 Catch:{ Throwable -> 0x0061 }
        r6 = r3.toString();	 Catch:{ Throwable -> 0x0061 }
        r2.<init>(r6);	 Catch:{ Throwable -> 0x0061 }
        r6 = r2.exists();	 Catch:{ Throwable -> 0x0062 }
        if (r6 == 0) goto L_0x0068;	 Catch:{ Throwable -> 0x0062 }
    L_0x003e:
        r6 = new java.io.File;	 Catch:{ Throwable -> 0x0062 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0062 }
        r3.<init>();	 Catch:{ Throwable -> 0x0062 }
        r3.append(r5);	 Catch:{ Throwable -> 0x0062 }
        r5 = "/";	 Catch:{ Throwable -> 0x0062 }
        r3.append(r5);	 Catch:{ Throwable -> 0x0062 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0062 }
        r5 = r3.toString();	 Catch:{ Throwable -> 0x0062 }
        r6.<init>(r5);	 Catch:{ Throwable -> 0x0062 }
        a(r6);	 Catch:{ Throwable -> 0x005f }
        r5 = r2.renameTo(r6);	 Catch:{ Throwable -> 0x005f }
        return r5;
    L_0x005f:
        r1 = r6;
        goto L_0x0062;
    L_0x0061:
        r2 = r1;
    L_0x0062:
        a(r2);
        a(r1);
    L_0x0068:
        r5 = 1;
        return r5;
    L_0x006a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.e.e.a(java.lang.String, java.lang.String):boolean");
    }

    public static boolean a(byte[] bArr, String str) {
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
            try {
                fileOutputStream2.write(bArr);
                try {
                    fileOutputStream2.close();
                    return true;
                } catch (IOException e) {
                    new String[1][0] = e.toString();
                    return true;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            new String[1][0] = th.toString();
            if (fileOutputStream != null) {
                fileOutputStream.close();
                return false;
            }
            return false;
        }
    }

    private static void b(String str) {
        File file;
        try {
            file = new File(str);
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            file = null;
        }
        a(file);
    }

    public static boolean b(java.lang.String r5, java.lang.String r6) {
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
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        if (r0 != 0) goto L_0x006a;
    L_0x0007:
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = c(r6);
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0061 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0061 }
        r3.<init>();	 Catch:{ Throwable -> 0x0061 }
        r3.append(r5);	 Catch:{ Throwable -> 0x0061 }
        r4 = "/";	 Catch:{ Throwable -> 0x0061 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0061 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0061 }
        r0 = r3.toString();	 Catch:{ Throwable -> 0x0061 }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0061 }
        r0 = r2.exists();	 Catch:{ Throwable -> 0x0062 }
        if (r0 == 0) goto L_0x0068;	 Catch:{ Throwable -> 0x0062 }
    L_0x0039:
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x0062 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0062 }
        r3.<init>();	 Catch:{ Throwable -> 0x0062 }
        r3.append(r5);	 Catch:{ Throwable -> 0x0062 }
        r5 = "/";	 Catch:{ Throwable -> 0x0062 }
        r3.append(r5);	 Catch:{ Throwable -> 0x0062 }
        r3.append(r6);	 Catch:{ Throwable -> 0x0062 }
        r5 = ".dex";	 Catch:{ Throwable -> 0x0062 }
        r3.append(r5);	 Catch:{ Throwable -> 0x0062 }
        r5 = r3.toString();	 Catch:{ Throwable -> 0x0062 }
        r0.<init>(r5);	 Catch:{ Throwable -> 0x0062 }
        a(r0);	 Catch:{ Throwable -> 0x005f }
        r5 = r2.renameTo(r0);	 Catch:{ Throwable -> 0x005f }
        return r5;
    L_0x005f:
        r1 = r0;
        goto L_0x0062;
    L_0x0061:
        r2 = r1;
    L_0x0062:
        a(r1);
        a(r2);
    L_0x0068:
        r5 = 1;
        return r5;
    L_0x006a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.e.e.b(java.lang.String, java.lang.String):boolean");
    }

    private static String c(String str) {
        try {
            return j.a(str).substring(12, 20);
        } catch (Exception e) {
            new String[1][0] = e.toString();
            return null;
        }
    }
}
