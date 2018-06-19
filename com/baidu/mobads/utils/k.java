package com.baidu.mobads.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class k implements IXAdIOUtils {
    public static String a(Context context) {
        if (!m.a(context)) {
            return a(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH);
        }
        if (m.c(context)) {
            return a(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH);
        }
        return a(context.getExternalFilesDir(null).getPath());
    }

    @java.lang.Deprecated
    public java.lang.String getStoreagePath(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
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
        r1 = this;
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0018 }
        r0.<init>();	 Catch:{ Exception -> 0x0018 }
        r2 = r1.getExternalFilesDir(r2);	 Catch:{ Exception -> 0x0018 }
        r2 = r2.getPath();	 Catch:{ Exception -> 0x0018 }
        r0.append(r2);	 Catch:{ Exception -> 0x0018 }
        r0.append(r4);	 Catch:{ Exception -> 0x0018 }
        r2 = r0.toString();	 Catch:{ Exception -> 0x0018 }
        return r2;
    L_0x0018:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r3);
        r2.append(r4);
        r2 = r2.toString();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.k.getStoreagePath(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public String getStoreagePath(Context context) {
        return a(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH);
    }

    public static java.lang.String a(android.content.Context r0, java.lang.String r1) {
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
        r0 = b(r0);	 Catch:{ Exception -> 0x000d }
        r0 = r0.getPath();	 Catch:{ Exception -> 0x000d }
        r0 = a(r0);	 Catch:{ Exception -> 0x000d }
        return r0;
    L_0x000d:
        r0 = a(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.k.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(IXAdIOUtils.DEFAULT_CACHE_PATH);
        return stringBuilder.toString();
    }

    public File getExternalFilesDir(Context context) {
        return b(context);
    }

    public static File b(Context context) {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return context.getFilesDir();
            }
            if (d.b(context, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
                return a();
            }
            if (VERSION.SDK_INT >= 19) {
                return context.getExternalFilesDir(null);
            }
            return context.getFilesDir();
        } catch (Context context2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e("XAdIOUtils", context2.getMessage());
            return null;
        }
    }

    private static File a() {
        return Environment.getExternalStorageDirectory();
    }

    public java.io.File deleteFileRecursive(java.io.File r5) {
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
        r4 = this;
        r0 = 0;
        r1 = r5.isDirectory();	 Catch:{ Exception -> 0x0023 }
        if (r1 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x0023 }
    L_0x0007:
        r1 = r5.listFiles();	 Catch:{ Exception -> 0x0023 }
        r2 = 0;	 Catch:{ Exception -> 0x0023 }
    L_0x000c:
        r3 = r1.length;	 Catch:{ Exception -> 0x0023 }
        if (r2 >= r3) goto L_0x001b;	 Catch:{ Exception -> 0x0023 }
    L_0x000f:
        r3 = r1[r2];	 Catch:{ Exception -> 0x0023 }
        r3 = r4.deleteFileRecursive(r3);	 Catch:{ Exception -> 0x0023 }
        if (r3 == 0) goto L_0x0018;	 Catch:{ Exception -> 0x0023 }
    L_0x0017:
        return r3;	 Catch:{ Exception -> 0x0023 }
    L_0x0018:
        r2 = r2 + 1;	 Catch:{ Exception -> 0x0023 }
        goto L_0x000c;	 Catch:{ Exception -> 0x0023 }
    L_0x001b:
        r1 = r5.delete();	 Catch:{ Exception -> 0x0023 }
        if (r1 == 0) goto L_0x0022;
    L_0x0021:
        return r0;
    L_0x0022:
        return r5;
    L_0x0023:
        r1 = r5.delete();
        if (r1 == 0) goto L_0x002a;
    L_0x0029:
        return r0;
    L_0x002a:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.k.deleteFileRecursive(java.io.File):java.io.File");
    }

    public File deleteFileRecursive(String str) {
        return deleteFileRecursive(new File(str));
    }

    public boolean renameFile(java.lang.String r3, java.lang.String r4) {
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
        r2 = this;
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0018 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0018 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0018 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0018 }
        r4 = r1.exists();	 Catch:{ Exception -> 0x0018 }
        if (r4 == 0) goto L_0x0016;	 Catch:{ Exception -> 0x0018 }
    L_0x0011:
        r3 = r1.renameTo(r3);	 Catch:{ Exception -> 0x0018 }
        goto L_0x0017;
    L_0x0016:
        r3 = r0;
    L_0x0017:
        return r3;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.k.renameFile(java.lang.String, java.lang.String):boolean");
    }

    public void copyFileInputStream(InputStream inputStream, String str) {
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                str = new byte[1024];
                while (true) {
                    int read = inputStream.read(str);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(str, 0, read);
                }
                inputStream.close();
                fileOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th) {
                str = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw str;
            }
        } catch (Throwable th2) {
            str = th2;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw str;
        }
    }

    public void copyFileFromAssetsTo(Context context, String str, String str2) {
        try {
            XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileInputStream(context.getAssets().open(str), str2);
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public static boolean a(java.io.File r5) {
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
        r0 = 0;
        if (r5 == 0) goto L_0x001c;
    L_0x0003:
        r1 = r5.exists();	 Catch:{ Exception -> 0x001b }
        if (r1 == 0) goto L_0x001c;	 Catch:{ Exception -> 0x001b }
    L_0x0009:
        r1 = r5.canRead();	 Catch:{ Exception -> 0x001b }
        if (r1 == 0) goto L_0x001c;	 Catch:{ Exception -> 0x001b }
    L_0x000f:
        r1 = r5.length();	 Catch:{ Exception -> 0x001b }
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x001c;
    L_0x0019:
        r5 = 1;
        return r5;
    L_0x001b:
        return r0;
    L_0x001c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.k.a(java.io.File):boolean");
    }

    public static boolean b(java.lang.String r5) {
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
        r0 = 0;
        r1 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0026 }
        if (r1 == 0) goto L_0x0008;	 Catch:{ Exception -> 0x0026 }
    L_0x0007:
        return r0;	 Catch:{ Exception -> 0x0026 }
    L_0x0008:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0026 }
        r1.<init>(r5);	 Catch:{ Exception -> 0x0026 }
        r5 = r1.exists();	 Catch:{ Exception -> 0x0026 }
        if (r5 == 0) goto L_0x0025;	 Catch:{ Exception -> 0x0026 }
    L_0x0013:
        r5 = r1.canRead();	 Catch:{ Exception -> 0x0026 }
        if (r5 == 0) goto L_0x0025;	 Catch:{ Exception -> 0x0026 }
    L_0x0019:
        r1 = r1.length();	 Catch:{ Exception -> 0x0026 }
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x0025;
    L_0x0023:
        r5 = 1;
        return r5;
    L_0x0025:
        return r0;
    L_0x0026:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.k.b(java.lang.String):boolean");
    }
}
