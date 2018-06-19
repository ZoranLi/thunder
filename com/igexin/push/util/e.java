package com.igexin.push.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.igexin.b.a.b.c;
import com.igexin.b.b.a;
import com.igexin.push.config.m;
import com.igexin.push.core.bean.f;
import com.igexin.push.core.c.h;
import com.igexin.push.core.g;
import com.igexin.sdk.a.b;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.android.agoo.common.AgooConstants;

public class e {
    private static final Object a = new Object();

    public static void a() {
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
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r2 = com.igexin.push.core.g.X;	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r2 = r1.exists();	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        if (r2 != 0) goto L_0x002f;	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
    L_0x000e:
        r2 = r1.createNewFile();	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        if (r2 != 0) goto L_0x002f;	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
    L_0x0014:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r3 = "FileUtils | create file : ";	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r2.append(r1);	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r1 = " failed !!!";	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r2.append(r1);	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r1 = r2.toString();	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        com.igexin.b.a.c.a.b(r1);	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        return;	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
    L_0x002f:
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r2 = com.igexin.push.core.g.X;	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0099, all -> 0x0094 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0092 }
        r2 = "v01";	 Catch:{ Exception -> 0x0092 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0092 }
        r2 = com.igexin.push.core.g.w;	 Catch:{ Exception -> 0x0092 }
        r0.append(r2);	 Catch:{ Exception -> 0x0092 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0092 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0092 }
        r2.<init>();	 Catch:{ Exception -> 0x0092 }
        r2.append(r0);	 Catch:{ Exception -> 0x0092 }
        r3 = com.igexin.push.core.g.q;	 Catch:{ Exception -> 0x0092 }
        r0 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0092 }
        r2.append(r0);	 Catch:{ Exception -> 0x0092 }
        r0 = "|";	 Catch:{ Exception -> 0x0092 }
        r2.append(r0);	 Catch:{ Exception -> 0x0092 }
        r0 = com.igexin.push.core.g.a;	 Catch:{ Exception -> 0x0092 }
        r2.append(r0);	 Catch:{ Exception -> 0x0092 }
        r0 = "|";	 Catch:{ Exception -> 0x0092 }
        r2.append(r0);	 Catch:{ Exception -> 0x0092 }
        r0 = com.igexin.push.core.g.r;	 Catch:{ Exception -> 0x0092 }
        r2.append(r0);	 Catch:{ Exception -> 0x0092 }
        r0 = "|";	 Catch:{ Exception -> 0x0092 }
        r2.append(r0);	 Catch:{ Exception -> 0x0092 }
        r0 = com.igexin.sdk.GTServiceManager.getInstance();	 Catch:{ Exception -> 0x0092 }
        r3 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x0092 }
        r0 = r0.getUserActivtiy(r3);	 Catch:{ Exception -> 0x0092 }
        r2.append(r0);	 Catch:{ Exception -> 0x0092 }
        r0 = r2.toString();	 Catch:{ Exception -> 0x0092 }
        r0 = r0.getBytes();	 Catch:{ Exception -> 0x0092 }
        r2 = com.igexin.push.core.g.C;	 Catch:{ Exception -> 0x0092 }
        r0 = com.igexin.b.a.a.a.d(r0, r2);	 Catch:{ Exception -> 0x0092 }
        r1.write(r0);	 Catch:{ Exception -> 0x0092 }
        r1.close();	 Catch:{ IOException -> 0x0091 }
    L_0x0091:
        return;
    L_0x0092:
        r0 = move-exception;
        goto L_0x009d;
    L_0x0094:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x00b9;
    L_0x0099:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x009d:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b8 }
        r3 = "FileUtils | ";	 Catch:{ all -> 0x00b8 }
        r2.<init>(r3);	 Catch:{ all -> 0x00b8 }
        r0 = r0.toString();	 Catch:{ all -> 0x00b8 }
        r2.append(r0);	 Catch:{ all -> 0x00b8 }
        r0 = r2.toString();	 Catch:{ all -> 0x00b8 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ all -> 0x00b8 }
        if (r1 == 0) goto L_0x00b7;
    L_0x00b4:
        r1.close();	 Catch:{ IOException -> 0x00b7 }
    L_0x00b7:
        return;
    L_0x00b8:
        r0 = move-exception;
    L_0x00b9:
        if (r1 == 0) goto L_0x00be;
    L_0x00bb:
        r1.close();	 Catch:{ IOException -> 0x00be }
    L_0x00be:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.e.a():void");
    }

    public static void a(f fVar) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(g.ab);
        stringBuilder2.append("/");
        stringBuilder2.append(fVar.c());
        File file = new File(stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(g.ac);
        stringBuilder3.append("/");
        stringBuilder3.append(fVar.c());
        File file2 = new File(stringBuilder3.toString());
        if (file2.exists()) {
            if (a.a(g.f, file2.getAbsolutePath()).equals(fVar.f())) {
                stringBuilder = new StringBuilder("FileUtils|downloadExt ext is exsit ");
                stringBuilder.append(file2);
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                Intent intent = new Intent(g.f, com.igexin.push.core.a.f.a().a(g.f));
                intent.putExtra("action", "com.igexin.sdk.action.extdownloadsuccess");
                intent.putExtra(AgooConstants.MESSAGE_ID, fVar.a());
                intent.putExtra("result", true);
                g.f.startService(intent);
                return;
            }
            file2.delete();
        }
        if (file.exists() && a.a(g.f, file.getAbsolutePath()).equals(fVar.f())) {
            stringBuilder3 = new StringBuilder("FileUtils|downloadExt ext is exsit do copy ");
            stringBuilder3.append(file);
            com.igexin.b.a.c.a.b(stringBuilder3.toString());
            if (a(file, file2, fVar.f())) {
                intent = new Intent(g.f, com.igexin.push.core.a.f.a().a(g.f));
                intent.putExtra("action", "com.igexin.sdk.action.extdownloadsuccess");
                intent.putExtra(AgooConstants.MESSAGE_ID, fVar.a());
                intent.putExtra("result", true);
                g.f.startService(intent);
                return;
            }
        }
        stringBuilder = new StringBuilder("FileUtils|ext is not exsit start download name = ");
        stringBuilder.append(fVar.c());
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        new Thread(new h(g.f, fVar, false)).start();
    }

    public static void a(byte[] r3, java.lang.String r4, boolean r5) {
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
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x001e, all -> 0x0017 }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x001e, all -> 0x0017 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x001e, all -> 0x0017 }
        r1.<init>(r2, r5);	 Catch:{ Exception -> 0x001e, all -> 0x0017 }
        r1.write(r3);	 Catch:{ Exception -> 0x0015, all -> 0x0012 }
        r1.close();	 Catch:{ Exception -> 0x0011 }
    L_0x0011:
        return;
    L_0x0012:
        r3 = move-exception;
        r0 = r1;
        goto L_0x0018;
    L_0x0015:
        r0 = r1;
        goto L_0x001e;
    L_0x0017:
        r3 = move-exception;
    L_0x0018:
        if (r0 == 0) goto L_0x001d;
    L_0x001a:
        r0.close();	 Catch:{ Exception -> 0x001d }
    L_0x001d:
        throw r3;
    L_0x001e:
        if (r0 == 0) goto L_0x0023;
    L_0x0020:
        r0.close();	 Catch:{ Exception -> 0x0023 }
    L_0x0023:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.e.a(byte[], java.lang.String, boolean):void");
    }

    public static boolean a(Context context) {
        return !new b(context).b();
    }

    public static boolean a(java.io.File r7, java.io.File r8, java.lang.String r9) {
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
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0080, all -> 0x007b }
        r2.<init>(r7);	 Catch:{ Throwable -> 0x0080, all -> 0x007b }
        r3 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0076, all -> 0x0073 }
        r3.<init>(r8);	 Catch:{ Throwable -> 0x0076, all -> 0x0073 }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ Throwable -> 0x0070, all -> 0x006d }
        r4.<init>(r3);	 Catch:{ Throwable -> 0x0070, all -> 0x006d }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
    L_0x0015:
        r5 = r2.read(r0);	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r6 = -1;	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        if (r5 == r6) goto L_0x0025;	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
    L_0x001c:
        r6 = new byte[r5];	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        java.lang.System.arraycopy(r0, r1, r6, r1, r5);	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r4.write(r6);	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        goto L_0x0015;	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
    L_0x0025:
        r4.flush();	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r0 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r5 = r8.getAbsolutePath();	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r0 = com.igexin.b.b.a.a(r0, r5);	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r9 = r0.equals(r9);	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        if (r9 != 0) goto L_0x0045;	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
    L_0x0038:
        r8.delete();	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r2.close();	 Catch:{ IOException -> 0x003e }
    L_0x003e:
        r4.close();	 Catch:{ IOException -> 0x0041 }
    L_0x0041:
        r3.close();	 Catch:{ IOException -> 0x0044 }
    L_0x0044:
        return r1;
    L_0x0045:
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r0 = "FileUtils|copyFile success from : ";	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r9.<init>(r0);	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r9.append(r7);	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r7 = " to : ";	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r9.append(r7);	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r9.append(r8);	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r7 = r9.toString();	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        com.igexin.b.a.c.a.b(r7);	 Catch:{ Throwable -> 0x006b, all -> 0x0069 }
        r2.close();	 Catch:{ IOException -> 0x0061 }
    L_0x0061:
        r4.close();	 Catch:{ IOException -> 0x0064 }
    L_0x0064:
        r3.close();	 Catch:{ IOException -> 0x0067 }
    L_0x0067:
        r7 = 1;
        return r7;
    L_0x0069:
        r7 = move-exception;
        goto L_0x00b3;
    L_0x006b:
        r7 = move-exception;
        goto L_0x0079;
    L_0x006d:
        r7 = move-exception;
        r4 = r0;
        goto L_0x00b3;
    L_0x0070:
        r7 = move-exception;
        r4 = r0;
        goto L_0x0079;
    L_0x0073:
        r7 = move-exception;
        r3 = r0;
        goto L_0x007e;
    L_0x0076:
        r7 = move-exception;
        r3 = r0;
        r4 = r3;
    L_0x0079:
        r0 = r2;
        goto L_0x0083;
    L_0x007b:
        r7 = move-exception;
        r2 = r0;
        r3 = r2;
    L_0x007e:
        r4 = r3;
        goto L_0x00b3;
    L_0x0080:
        r7 = move-exception;
        r3 = r0;
        r4 = r3;
    L_0x0083:
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b1 }
        r2 = "FileUtils";	 Catch:{ all -> 0x00b1 }
        r9.<init>(r2);	 Catch:{ all -> 0x00b1 }
        r7 = r7.toString();	 Catch:{ all -> 0x00b1 }
        r9.append(r7);	 Catch:{ all -> 0x00b1 }
        r7 = r9.toString();	 Catch:{ all -> 0x00b1 }
        com.igexin.b.a.c.a.b(r7);	 Catch:{ all -> 0x00b1 }
        r7 = r8.exists();	 Catch:{ all -> 0x00b1 }
        if (r7 == 0) goto L_0x00a1;	 Catch:{ all -> 0x00b1 }
    L_0x009e:
        r8.delete();	 Catch:{ all -> 0x00b1 }
    L_0x00a1:
        if (r0 == 0) goto L_0x00a6;
    L_0x00a3:
        r0.close();	 Catch:{ IOException -> 0x00a6 }
    L_0x00a6:
        if (r4 == 0) goto L_0x00ab;
    L_0x00a8:
        r4.close();	 Catch:{ IOException -> 0x00ab }
    L_0x00ab:
        if (r3 == 0) goto L_0x00b0;
    L_0x00ad:
        r3.close();	 Catch:{ IOException -> 0x00b0 }
    L_0x00b0:
        return r1;
    L_0x00b1:
        r7 = move-exception;
        r2 = r0;
    L_0x00b3:
        if (r2 == 0) goto L_0x00b8;
    L_0x00b5:
        r2.close();	 Catch:{ IOException -> 0x00b8 }
    L_0x00b8:
        if (r4 == 0) goto L_0x00bd;
    L_0x00ba:
        r4.close();	 Catch:{ IOException -> 0x00bd }
    L_0x00bd:
        if (r3 == 0) goto L_0x00c2;
    L_0x00bf:
        r3.close();	 Catch:{ IOException -> 0x00c2 }
    L_0x00c2:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.e.a(java.io.File, java.io.File, java.lang.String):boolean");
    }

    public static boolean a(String str, String str2, boolean z) {
        StringBuilder stringBuilder;
        com.igexin.b.a.c.a.b("FileUtils|rename file...");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String substring = a.a(str2).substring(12, 20);
        File file;
        try {
            stringBuilder = new StringBuilder("FileUtils|rename file reverseName:");
            stringBuilder.append(substring);
            stringBuilder.append(" isForward:");
            stringBuilder.append(z);
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            StringBuilder stringBuilder2;
            StringBuilder stringBuilder3;
            File file2;
            if (z) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("/");
                stringBuilder2.append(str2);
                stringBuilder2.append(ShareConstants.DEX_SUFFIX);
                file = new File(stringBuilder2.toString());
                if (file.exists()) {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str);
                    stringBuilder3.append("/");
                    stringBuilder3.append(substring);
                    file2 = new File(stringBuilder3.toString());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    stringBuilder3 = new StringBuilder("FileUtils|rename file from ");
                    stringBuilder3.append(file.getAbsolutePath());
                    stringBuilder3.append(" --> ");
                    stringBuilder3.append(file2.getAbsolutePath());
                    com.igexin.b.a.c.a.b(stringBuilder3.toString());
                    file.renameTo(file2);
                    return true;
                }
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("/");
            stringBuilder2.append(substring);
            file = new File(stringBuilder2.toString());
            if (file.exists()) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str);
                stringBuilder3.append("/");
                stringBuilder3.append(str2);
                stringBuilder3.append(ShareConstants.DEX_SUFFIX);
                file2 = new File(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder("FileUtils|rename file from ");
                stringBuilder3.append(file.getAbsolutePath());
                stringBuilder3.append(" --> ");
                stringBuilder3.append(file2.getAbsolutePath());
                com.igexin.b.a.c.a.b(stringBuilder3.toString());
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
                return true;
            }
        } catch (Throwable th) {
            stringBuilder = new StringBuilder("FileUtils|renameGenerateFile error:");
            stringBuilder.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("/");
            stringBuilder.append(str2);
            stringBuilder.append(ShareConstants.DEX_SUFFIX);
            file = new File(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("/");
            stringBuilder.append(substring);
            File file3 = new File(stringBuilder.toString());
            if (file.exists()) {
                file.delete();
            }
            if (file3.exists()) {
                file3.delete();
            }
        }
        return false;
    }

    public static byte[] a(java.lang.String r5) {
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
        r0 = new java.io.File;
        r0.<init>(r5);
        r0 = r0.exists();
        r1 = 0;
        if (r0 != 0) goto L_0x0023;
    L_0x000c:
        r0 = new java.lang.StringBuilder;
        r2 = "FileUtils|get data from file = ";
        r0.<init>(r2);
        r0.append(r5);
        r5 = " file not exist ######";
        r0.append(r5);
        r5 = r0.toString();
        com.igexin.b.a.c.a.b(r5);
        return r1;
    L_0x0023:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0054, all -> 0x0050 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x0054, all -> 0x0050 }
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x004d, all -> 0x004a }
        r5.<init>();	 Catch:{ Exception -> 0x004d, all -> 0x004a }
    L_0x0031:
        r3 = r2.read(r0);	 Catch:{ Exception -> 0x0048 }
        r4 = -1;	 Catch:{ Exception -> 0x0048 }
        if (r3 == r4) goto L_0x003d;	 Catch:{ Exception -> 0x0048 }
    L_0x0038:
        r4 = 0;	 Catch:{ Exception -> 0x0048 }
        r5.write(r0, r4, r3);	 Catch:{ Exception -> 0x0048 }
        goto L_0x0031;	 Catch:{ Exception -> 0x0048 }
    L_0x003d:
        r0 = r5.toByteArray();	 Catch:{ Exception -> 0x0048 }
        r2.close();	 Catch:{ Exception -> 0x0044 }
    L_0x0044:
        r5.close();	 Catch:{ Exception -> 0x0077 }
        return r0;
    L_0x0048:
        r0 = move-exception;
        goto L_0x0057;
    L_0x004a:
        r0 = move-exception;
        r5 = r1;
        goto L_0x0079;
    L_0x004d:
        r0 = move-exception;
        r5 = r1;
        goto L_0x0057;
    L_0x0050:
        r0 = move-exception;
        r5 = r1;
        r2 = r5;
        goto L_0x0079;
    L_0x0054:
        r0 = move-exception;
        r5 = r1;
        r2 = r5;
    L_0x0057:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0078 }
        r4 = "FileUtils|";	 Catch:{ all -> 0x0078 }
        r3.<init>(r4);	 Catch:{ all -> 0x0078 }
        r0 = r0.toString();	 Catch:{ all -> 0x0078 }
        r3.append(r0);	 Catch:{ all -> 0x0078 }
        r0 = r3.toString();	 Catch:{ all -> 0x0078 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ all -> 0x0078 }
        if (r2 == 0) goto L_0x0071;
    L_0x006e:
        r2.close();	 Catch:{ Exception -> 0x0071 }
    L_0x0071:
        if (r5 == 0) goto L_0x0076;
    L_0x0073:
        r5.close();	 Catch:{ Exception -> 0x0076 }
    L_0x0076:
        r0 = r1;
    L_0x0077:
        return r0;
    L_0x0078:
        r0 = move-exception;
    L_0x0079:
        if (r2 == 0) goto L_0x007e;
    L_0x007b:
        r2.close();	 Catch:{ Exception -> 0x007e }
    L_0x007e:
        if (r5 == 0) goto L_0x0083;
    L_0x0080:
        r5.close();	 Catch:{ Exception -> 0x0083 }
    L_0x0083:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.e.a(java.lang.String):byte[]");
    }

    public static java.lang.String b() {
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
        r1 = com.igexin.push.core.g.X;	 Catch:{ Exception -> 0x0032 }
        r1 = a(r1);	 Catch:{ Exception -> 0x0032 }
        if (r1 != 0) goto L_0x000f;	 Catch:{ Exception -> 0x0032 }
    L_0x0009:
        r1 = "FileUtils | read file cid id = null";	 Catch:{ Exception -> 0x0032 }
        com.igexin.b.a.c.a.b(r1);	 Catch:{ Exception -> 0x0032 }
        return r0;	 Catch:{ Exception -> 0x0032 }
    L_0x000f:
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x0032 }
        r3 = com.igexin.push.core.g.C;	 Catch:{ Exception -> 0x0032 }
        r1 = com.igexin.b.a.a.a.c(r1, r3);	 Catch:{ Exception -> 0x0032 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0032 }
        r1 = "\\|";	 Catch:{ Exception -> 0x0032 }
        r1 = r2.split(r1);	 Catch:{ Exception -> 0x0032 }
        r2 = r1.length;	 Catch:{ Exception -> 0x0032 }
        r3 = 2;	 Catch:{ Exception -> 0x0032 }
        if (r2 <= r3) goto L_0x0032;	 Catch:{ Exception -> 0x0032 }
    L_0x0024:
        r1 = r1[r3];	 Catch:{ Exception -> 0x0032 }
        if (r1 == 0) goto L_0x0031;
    L_0x0028:
        r2 = "null";	 Catch:{ Exception -> 0x0031 }
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0031 }
        if (r2 == 0) goto L_0x0031;
    L_0x0030:
        goto L_0x0032;
    L_0x0031:
        r0 = r1;
    L_0x0032:
        r1 = new java.lang.StringBuilder;
        r2 = "FileUtils|get cid from file cid = ";
        r1.<init>(r2);
        r1.append(r0);
        r1 = r1.toString();
        com.igexin.b.a.c.a.b(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.e.b():java.lang.String");
    }

    public static void b(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getFilesDir().getPath());
        stringBuilder.append("/init_c.pid");
        File file = new File(stringBuilder.toString());
        if (file.exists()) {
            file.delete();
        }
        if (!m.x) {
            com.igexin.b.a.c.a.b("FileUtils|isReportInitialize = false");
        } else if (g.g.get()) {
            c.b().a(new f(context), false, true);
        } else {
            new Thread(new g(context)).start();
        }
    }

    private static void b(Context context, String str) {
        if (context != null && str != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getPath());
            stringBuilder.append("/init_c1.pid");
            String stringBuilder2 = stringBuilder.toString();
            synchronized (a) {
                if (str.length() == 0) {
                    a(str.getBytes(), stringBuilder2, false);
                } else {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str);
                    stringBuilder3.append("|");
                    a(stringBuilder3.toString().getBytes(), stringBuilder2, true);
                }
            }
        }
    }

    public static void b(java.io.File r6, java.io.File r7, java.lang.String r8) {
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
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0059, all -> 0x0054 }
        r1.<init>(r6);	 Catch:{ Exception -> 0x0059, all -> 0x0054 }
        r6 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0050, all -> 0x004c }
        r6.<init>(r7);	 Catch:{ Exception -> 0x0050, all -> 0x004c }
        r2 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x004a, all -> 0x0047 }
        r2.<init>(r6);	 Catch:{ Exception -> 0x004a, all -> 0x0047 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
    L_0x0014:
        r3 = r1.read(r0);	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
        r4 = -1;	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
        if (r3 == r4) goto L_0x0029;	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
    L_0x001b:
        r4 = new byte[r3];	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
        r5 = 0;	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
        java.lang.System.arraycopy(r0, r5, r4, r5, r3);	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
        r3 = com.igexin.b.a.a.a.c(r4, r8);	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
        r2.write(r3);	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
        goto L_0x0014;	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
    L_0x0029:
        r2.flush();	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
        r1.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0034;
    L_0x0030:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x0034:
        r2.close();	 Catch:{ IOException -> 0x0038 }
        goto L_0x003c;
    L_0x0038:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x003c:
        r6.close();	 Catch:{ IOException -> 0x0040 }
        return;
    L_0x0040:
        r6 = move-exception;
        r6.printStackTrace();
        return;
    L_0x0045:
        r7 = move-exception;
        goto L_0x0085;
    L_0x0047:
        r7 = move-exception;
        r2 = r0;
        goto L_0x0085;
    L_0x004a:
        r2 = r0;
        goto L_0x0052;
    L_0x004c:
        r7 = move-exception;
        r6 = r0;
        r2 = r6;
        goto L_0x0085;
    L_0x0050:
        r6 = r0;
        r2 = r6;
    L_0x0052:
        r0 = r1;
        goto L_0x005b;
    L_0x0054:
        r7 = move-exception;
        r6 = r0;
        r1 = r6;
        r2 = r1;
        goto L_0x0085;
    L_0x0059:
        r6 = r0;
        r2 = r6;
    L_0x005b:
        r8 = r7.exists();	 Catch:{ all -> 0x0083 }
        if (r8 == 0) goto L_0x0064;	 Catch:{ all -> 0x0083 }
    L_0x0061:
        r7.delete();	 Catch:{ all -> 0x0083 }
    L_0x0064:
        if (r0 == 0) goto L_0x006e;
    L_0x0066:
        r0.close();	 Catch:{ IOException -> 0x006a }
        goto L_0x006e;
    L_0x006a:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x006e:
        if (r2 == 0) goto L_0x0078;
    L_0x0070:
        r2.close();	 Catch:{ IOException -> 0x0074 }
        goto L_0x0078;
    L_0x0074:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x0078:
        if (r6 == 0) goto L_0x0082;
    L_0x007a:
        r6.close();	 Catch:{ IOException -> 0x007e }
        return;
    L_0x007e:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0082:
        return;
    L_0x0083:
        r7 = move-exception;
        r1 = r0;
    L_0x0085:
        if (r1 == 0) goto L_0x008f;
    L_0x0087:
        r1.close();	 Catch:{ IOException -> 0x008b }
        goto L_0x008f;
    L_0x008b:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x008f:
        if (r2 == 0) goto L_0x0099;
    L_0x0091:
        r2.close();	 Catch:{ IOException -> 0x0095 }
        goto L_0x0099;
    L_0x0095:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0099:
        if (r6 == 0) goto L_0x00a3;
    L_0x009b:
        r6.close();	 Catch:{ IOException -> 0x009f }
        goto L_0x00a3;
    L_0x009f:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x00a3:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.e.b(java.io.File, java.io.File, java.lang.String):void");
    }

    public static boolean b(String str) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder("FileUtils|removeExt ");
        stringBuilder2.append(str);
        com.igexin.b.a.c.a.b(stringBuilder2.toString());
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(g.ac);
            stringBuilder.append("/");
            stringBuilder.append(str);
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder("FileUtils|removeExt delete ext path = ");
            stringBuilder4.append(stringBuilder3);
            com.igexin.b.a.c.a.b(stringBuilder4.toString());
            File file = new File(stringBuilder3);
            boolean delete = file.exists() ? file.delete() : true;
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append(g.ac);
            stringBuilder4.append("/");
            stringBuilder4.append(str);
            stringBuilder4.append(ShareConstants.DEX_SUFFIX);
            String stringBuilder5 = stringBuilder4.toString();
            StringBuilder stringBuilder6 = new StringBuilder("FileUtils|removeExt delete ext dex path = ");
            stringBuilder6.append(stringBuilder5);
            com.igexin.b.a.c.a.b(stringBuilder6.toString());
            File file2 = new File(stringBuilder5);
            if (file2.exists()) {
                delete = delete && file2.delete();
            }
            str = a.a(str).substring(12, 20);
            stringBuilder4 = new StringBuilder("FileUtils|removeExt renamedExtName = ");
            stringBuilder4.append(str);
            com.igexin.b.a.c.a.b(stringBuilder4.toString());
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append(g.ac);
            stringBuilder7.append("/");
            stringBuilder7.append(str);
            file = new File(stringBuilder7.toString());
            if (file.exists()) {
                StringBuilder stringBuilder8 = new StringBuilder("FileUtils|removeExt, delete ext rename Ext path = ");
                stringBuilder8.append(file.getAbsolutePath());
                com.igexin.b.a.c.a.b(stringBuilder8.toString());
                boolean delete2 = file.delete();
                delete &= delete2;
                stringBuilder4 = new StringBuilder("FileUtils|removeExt, delete ext renamedExt succeed = ");
                stringBuilder4.append(delete2);
                com.igexin.b.a.c.a.b(stringBuilder4.toString());
            }
            return delete;
        } catch (Throwable th) {
            stringBuilder = new StringBuilder("FileUtils|");
            stringBuilder.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            return false;
        }
    }

    public static String c() {
        String str;
        StringBuilder stringBuilder;
        Exception e;
        try {
            StringBuilder stringBuilder2 = new StringBuilder("FileUtils|get device id from file : ");
            stringBuilder2.append(g.Y);
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
            byte[] a = a(g.Y);
            if (a == null) {
                com.igexin.b.a.c.a.b("FileUtils|read file device id = null");
                return null;
            }
            str = new String(a, "utf-8");
            try {
                stringBuilder = new StringBuilder("FileUtils|read file device id = ");
                stringBuilder.append(str);
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                return str;
            } catch (Exception e2) {
                e = e2;
                stringBuilder = new StringBuilder("FileUtils|get device id from file : ");
                stringBuilder.append(e.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = null;
            stringBuilder = new StringBuilder("FileUtils|get device id from file : ");
            stringBuilder.append(e.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            return str;
        }
    }

    private static String c(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        stringBuilder.append("|");
        stringBuilder.append(g.r);
        stringBuilder.append("|");
        stringBuilder.append(g.a);
        stringBuilder.append("|");
        stringBuilder.append("1");
        stringBuilder.append("|");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static long d() {
        long j = 0;
        try {
            byte[] a = a(g.X);
            if (a == null) {
                com.igexin.b.a.c.a.b("FileUtils|read session from file, not exist");
                return 0;
            }
            String str = new String(com.igexin.b.a.a.a.c(a, g.C));
            String substring = str.contains("null") ? str.substring(7) : str.substring(20);
            int indexOf = substring.indexOf("|");
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            long parseLong = Long.parseLong(substring);
            if (parseLong != 0) {
                j = parseLong;
            }
            StringBuilder stringBuilder = new StringBuilder("FileUtils|session : ");
            stringBuilder.append(j);
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            return j;
        } catch (Exception e) {
            StringBuilder stringBuilder2 = new StringBuilder("FileUtils|");
            stringBuilder2.append(e.toString());
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
        }
    }

    public static void e() {
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
        r0 = com.igexin.push.core.g.y;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = new java.lang.StringBuilder;
        r1 = "FileUtils|save device id to file : ";
        r0.<init>(r1);
        r1 = com.igexin.push.core.g.Y;
        r0.append(r1);
        r0 = r0.toString();
        com.igexin.b.a.c.a.b(r0);
        r0 = 0;
        r1 = new java.util.concurrent.locks.ReentrantReadWriteLock;
        r1.<init>();
        r1 = r1.writeLock();
        r2 = r1.tryLock();	 Catch:{ Exception -> 0x0082 }
        if (r2 == 0) goto L_0x0077;	 Catch:{ Exception -> 0x0082 }
    L_0x0028:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0082 }
        r3 = com.igexin.push.core.g.Y;	 Catch:{ Exception -> 0x0082 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0082 }
        r3 = r2.exists();	 Catch:{ Exception -> 0x0082 }
        if (r3 != 0) goto L_0x0059;	 Catch:{ Exception -> 0x0082 }
    L_0x0035:
        r3 = r2.createNewFile();	 Catch:{ Exception -> 0x0082 }
        if (r3 != 0) goto L_0x0059;	 Catch:{ Exception -> 0x0082 }
    L_0x003b:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0082 }
        r4 = "FileUtils|create file : ";	 Catch:{ Exception -> 0x0082 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0082 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0082 }
        r3.append(r2);	 Catch:{ Exception -> 0x0082 }
        r2 = " failed !!!";	 Catch:{ Exception -> 0x0082 }
        r3.append(r2);	 Catch:{ Exception -> 0x0082 }
        r2 = r3.toString();	 Catch:{ Exception -> 0x0082 }
        com.igexin.b.a.c.a.b(r2);	 Catch:{ Exception -> 0x0082 }
        r1.unlock();
        return;
    L_0x0059:
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0082 }
        r3 = com.igexin.push.core.g.Y;	 Catch:{ Exception -> 0x0082 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0082 }
        r0 = com.igexin.push.core.g.y;	 Catch:{ Exception -> 0x0072, all -> 0x006d }
        r3 = "utf-8";	 Catch:{ Exception -> 0x0072, all -> 0x006d }
        r0 = r0.getBytes(r3);	 Catch:{ Exception -> 0x0072, all -> 0x006d }
        r2.write(r0);	 Catch:{ Exception -> 0x0072, all -> 0x006d }
        r0 = r2;
        goto L_0x0077;
    L_0x006d:
        r0 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x00a1;
    L_0x0072:
        r0 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x0083;
    L_0x0077:
        if (r0 == 0) goto L_0x007c;
    L_0x0079:
        r0.close();	 Catch:{ IOException -> 0x007c }
    L_0x007c:
        r1.unlock();
        return;
    L_0x0080:
        r2 = move-exception;
        goto L_0x00a1;
    L_0x0082:
        r2 = move-exception;
    L_0x0083:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r4 = "FileUtils|";	 Catch:{ all -> 0x0080 }
        r3.<init>(r4);	 Catch:{ all -> 0x0080 }
        r2 = r2.toString();	 Catch:{ all -> 0x0080 }
        r3.append(r2);	 Catch:{ all -> 0x0080 }
        r2 = r3.toString();	 Catch:{ all -> 0x0080 }
        com.igexin.b.a.c.a.b(r2);	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x009d;
    L_0x009a:
        r0.close();	 Catch:{ IOException -> 0x009d }
    L_0x009d:
        r1.unlock();
        return;
    L_0x00a1:
        if (r0 == 0) goto L_0x00a6;
    L_0x00a3:
        r0.close();	 Catch:{ IOException -> 0x00a6 }
    L_0x00a6:
        r1.unlock();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.e.e():void");
    }

    public static void f() {
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
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = com.igexin.push.core.g.f;
        r1 = r1.getFilesDir();
        r1 = r1.getPath();
        r0.append(r1);
        r1 = "/init.pid";
        r0.append(r1);
        r0 = r0.toString();
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0059 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0059 }
        r2 = r2.exists();	 Catch:{ Exception -> 0x0059 }
        if (r2 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x0059 }
    L_0x0027:
        r2 = com.igexin.push.core.g.r;	 Catch:{ Exception -> 0x0059 }
        r2 = r2.getBytes();	 Catch:{ Exception -> 0x0059 }
        r3 = r2.length;	 Catch:{ Exception -> 0x0059 }
        r3 = new byte[r3];	 Catch:{ Exception -> 0x0059 }
        r4 = 0;	 Catch:{ Exception -> 0x0059 }
    L_0x0031:
        r5 = r2.length;	 Catch:{ Exception -> 0x0059 }
        if (r4 >= r5) goto L_0x0041;	 Catch:{ Exception -> 0x0059 }
    L_0x0034:
        r5 = r2[r4];	 Catch:{ Exception -> 0x0059 }
        r6 = com.igexin.push.core.g.ae;	 Catch:{ Exception -> 0x0059 }
        r6 = r6[r4];	 Catch:{ Exception -> 0x0059 }
        r5 = r5 ^ r6;	 Catch:{ Exception -> 0x0059 }
        r5 = (byte) r5;	 Catch:{ Exception -> 0x0059 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0059 }
        r4 = r4 + 1;	 Catch:{ Exception -> 0x0059 }
        goto L_0x0031;	 Catch:{ Exception -> 0x0059 }
    L_0x0041:
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0059 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0059 }
        r2.write(r3);	 Catch:{ Exception -> 0x004e, all -> 0x004b }
        r1 = r2;
        goto L_0x0051;
    L_0x004b:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0075;
    L_0x004e:
        r0 = move-exception;
        r1 = r2;
        goto L_0x005a;
    L_0x0051:
        if (r1 == 0) goto L_0x0074;
    L_0x0053:
        r1.close();	 Catch:{ Exception -> 0x0056 }
    L_0x0056:
        return;
    L_0x0057:
        r0 = move-exception;
        goto L_0x0075;
    L_0x0059:
        r0 = move-exception;
    L_0x005a:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0057 }
        r3 = "FileUtils|";	 Catch:{ all -> 0x0057 }
        r2.<init>(r3);	 Catch:{ all -> 0x0057 }
        r0 = r0.toString();	 Catch:{ all -> 0x0057 }
        r2.append(r0);	 Catch:{ all -> 0x0057 }
        r0 = r2.toString();	 Catch:{ all -> 0x0057 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ all -> 0x0057 }
        if (r1 == 0) goto L_0x0074;
    L_0x0071:
        r1.close();	 Catch:{ Exception -> 0x0074 }
    L_0x0074:
        return;
    L_0x0075:
        if (r1 == 0) goto L_0x007a;
    L_0x0077:
        r1.close();	 Catch:{ Exception -> 0x007a }
    L_0x007a:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.e.f():void");
    }

    public static void g() {
        b(g.f, "");
    }

    public static String h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(g.f.getFilesDir().getPath());
        stringBuilder.append("/init_c1.pid");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3;
        try {
            byte[] a;
            synchronized (a) {
                a = a(stringBuilder2);
            }
            if (a == null) {
                return null;
            }
            String str = new String(a);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i = 0;
            if (str.endsWith("|")) {
                str = str.substring(0, str.length() - 1);
            }
            String[] split = str.split("\\|");
            if (split.length <= 300 || System.currentTimeMillis() - Long.parseLong(split[0]) <= 604800000) {
                stringBuilder3 = new StringBuilder();
                int length = split.length;
                while (i < length) {
                    stringBuilder3.append(c(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(Long.parseLong(split[i])))));
                    stringBuilder3.append("\n");
                    i++;
                }
                if (stringBuilder3.length() > 0) {
                    stringBuilder3.deleteCharAt(stringBuilder3.length() - 1);
                }
                return stringBuilder3.toString();
            }
            g();
            return null;
        } catch (Throwable th) {
            stringBuilder3 = new StringBuilder("FileUtils|upload init data error = ");
            stringBuilder3.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder3.toString());
            g();
            return null;
        }
    }
}
