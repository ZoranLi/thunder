package com.getui.gtc.b;

import android.content.Context;
import android.text.TextUtils;
import com.getui.gtc.a.b;
import com.getui.gtc.a.h;
import com.getui.gtc.b.a.a;
import com.getui.gtc.e.e;
import com.getui.gtc.e.i;
import com.getui.gtc.e.j;
import com.getui.gtc.e.k;
import com.getui.gtc.e.l;
import com.getui.gtc.entity.d;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xiaomi.mipush.sdk.Constants;
import dalvik.system.DexClassLoader;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mtopsdk.mtop.antiattack.CheckCodeDO;

public final class c {
    private static c i;
    Context a;
    String b;
    String c;
    String d;
    private List e;
    private String f;
    private a g;
    private a h;

    private c() {
    }

    public static synchronized com.getui.gtc.b.c a(android.content.Context r5) {
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
        r0 = com.getui.gtc.b.c.class;
        monitor-enter(r0);
        r1 = i;	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        if (r1 != 0) goto L_0x006c;	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
    L_0x0007:
        r1 = new com.getui.gtc.b.c;	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        r1.<init>();	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        i = r1;	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        r2 = 0;
        r5 = r5.getApplicationContext();	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r1.a = r5;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5.<init>();	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r1.e = r5;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5 = com.getui.gtc.a.a.c;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r1.b = r5;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5 = com.getui.gtc.a.a.b;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r1.c = r5;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5.<init>();	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r3 = r1.b;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5.append(r3);	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r3 = java.io.File.separator;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5.append(r3);	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r3 = "gtc";	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r3 = com.getui.gtc.e.j.a(r3);	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r4 = 7;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r3 = r3.substring(r2, r4);	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5.append(r3);	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r3 = java.io.File.separator;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5.append(r3);	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r3 = "data";	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5.append(r3);	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r1.f = r5;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5 = r5.c();	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r1.d = r5;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r5 = com.getui.gtc.b.a.a();	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        r1.g = r5;	 Catch:{ Throwable -> 0x0062, all -> 0x0070 }
        goto L_0x006c;
    L_0x0062:
        r5 = move-exception;
        r1 = 1;
        r1 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        r1[r2] = r5;	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
    L_0x006c:
        r5 = i;	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        monitor-exit(r0);
        return r5;
    L_0x0070:
        r5 = move-exception;
        monitor-exit(r0);
        throw r5;
    L_0x0073:
        r5 = 0;
        monitor-exit(r0);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.b.c.a(android.content.Context):com.getui.gtc.b.c");
    }

    static /* synthetic */ void a(c cVar, d dVar, com.getui.gtc.entity.a.a aVar) {
        try {
            if (cVar.h == null) {
                cVar.h = new g(cVar);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cVar.c);
            stringBuilder.append("/");
            stringBuilder.append(aVar.c);
            File file = new File(stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(cVar.b);
            stringBuilder2.append("/");
            stringBuilder2.append(aVar.c);
            File file2 = new File(stringBuilder2.toString());
            if (file2.exists()) {
                if (j.b(file2.getAbsolutePath()).equals(aVar.e)) {
                    cVar.h.a(dVar, aVar.a, file2.getAbsolutePath());
                    return;
                }
                file2.delete();
            }
            if (file.exists() && j.b(file.getAbsolutePath()).equals(aVar.e) && e.a(file, file2, aVar.e)) {
                cVar.h.a(dVar, aVar.a, file2.getAbsolutePath());
                return;
            }
            if (cVar.g != null) {
                cVar.g.a(dVar, aVar);
                cVar.g.c = cVar.h;
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.getui.gtc.entity.Ie r18, com.getui.gtc.entity.d r19) {
        /*
        r17 = this;
        r10 = r17;
        monitor-enter(r17);
        if (r18 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r17);
        return;
    L_0x0007:
        r12 = 0;
        r2 = r18.getCn();	 Catch:{ Throwable -> 0x01b0 }
        r3 = r18.getAid();	 Catch:{ Throwable -> 0x01b0 }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x01b0 }
        if (r4 == 0) goto L_0x001b;
    L_0x0016:
        r8 = r19;
        r3 = r8.e;	 Catch:{ Throwable -> 0x01b0 }
        goto L_0x001d;
    L_0x001b:
        r8 = r19;
    L_0x001d:
        r4 = r18.getK();	 Catch:{ Throwable -> 0x01b0 }
        r5 = r18.getCs();	 Catch:{ Throwable -> 0x01b0 }
        r6 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x01b0 }
        if (r6 != 0) goto L_0x01ab;
    L_0x002b:
        r6 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x01b0 }
        if (r6 != 0) goto L_0x01ab;
    L_0x0031:
        r6 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x01b0 }
        if (r6 != 0) goto L_0x01ab;
    L_0x0037:
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x01b0 }
        if (r6 == 0) goto L_0x003f;
    L_0x003d:
        goto L_0x01ab;
    L_0x003f:
        r6 = new java.lang.String;	 Catch:{ Throwable -> 0x01b0 }
        r2 = android.util.Base64.decode(r2, r12);	 Catch:{ Throwable -> 0x01b0 }
        r6.<init>(r2);	 Catch:{ Throwable -> 0x01b0 }
        r2 = r10.b(r6);	 Catch:{ Throwable -> 0x01b0 }
        if (r2 == 0) goto L_0x0050;
    L_0x004e:
        monitor-exit(r17);
        return;
    L_0x0050:
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x01b0 }
        r5 = android.util.Base64.decode(r5, r12);	 Catch:{ Throwable -> 0x01b0 }
        r5 = com.getui.gtc.e.i.a(r5, r6);	 Catch:{ Throwable -> 0x01b0 }
        r2.<init>(r5);	 Catch:{ Throwable -> 0x01b0 }
        r5 = new java.lang.String;	 Catch:{ Throwable -> 0x01b0 }
        r4 = android.util.Base64.decode(r4, r12);	 Catch:{ Throwable -> 0x01b0 }
        r4 = com.getui.gtc.e.i.a(r4, r6);	 Catch:{ Throwable -> 0x01b0 }
        r5.<init>(r4);	 Catch:{ Throwable -> 0x01b0 }
        r7 = com.getui.gtc.e.j.a(r6);	 Catch:{ Throwable -> 0x01b0 }
        r13 = new java.io.File;	 Catch:{ Throwable -> 0x01b0 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01b0 }
        r4.<init>();	 Catch:{ Throwable -> 0x01b0 }
        r9 = r10.a;	 Catch:{ Throwable -> 0x01b0 }
        r9 = r9.getFilesDir();	 Catch:{ Throwable -> 0x01b0 }
        r4.append(r9);	 Catch:{ Throwable -> 0x01b0 }
        r9 = "/";
        r4.append(r9);	 Catch:{ Throwable -> 0x01b0 }
        r4.append(r7);	 Catch:{ Throwable -> 0x01b0 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x01b0 }
        r13.<init>(r4);	 Catch:{ Throwable -> 0x01b0 }
        r4 = r13.exists();	 Catch:{ Throwable -> 0x01b0 }
        if (r4 == 0) goto L_0x00a4;
    L_0x0093:
        r4 = r13.getAbsolutePath();	 Catch:{ Throwable -> 0x01b0 }
        r4 = com.getui.gtc.e.j.b(r4);	 Catch:{ Throwable -> 0x01b0 }
        r4 = r2.equalsIgnoreCase(r4);	 Catch:{ Throwable -> 0x01b0 }
        if (r4 != 0) goto L_0x00a4;
    L_0x00a1:
        r13.delete();	 Catch:{ Throwable -> 0x01b0 }
    L_0x00a4:
        r4 = r13.exists();	 Catch:{ Throwable -> 0x01b0 }
        if (r4 != 0) goto L_0x011a;
    L_0x00aa:
        r4 = 0;
        r9 = r10.a;	 Catch:{ Throwable -> 0x00f7, all -> 0x00f3 }
        r9 = r9.getAssets();	 Catch:{ Throwable -> 0x00f7, all -> 0x00f3 }
        r14 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f7, all -> 0x00f3 }
        r15 = "gtc/";
        r14.<init>(r15);	 Catch:{ Throwable -> 0x00f7, all -> 0x00f3 }
        r14.append(r7);	 Catch:{ Throwable -> 0x00f7, all -> 0x00f3 }
        r15 = ".so";
        r14.append(r15);	 Catch:{ Throwable -> 0x00f7, all -> 0x00f3 }
        r14 = r14.toString();	 Catch:{ Throwable -> 0x00f7, all -> 0x00f3 }
        r9 = r9.open(r14);	 Catch:{ Throwable -> 0x00f7, all -> 0x00f3 }
        r14 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x00f0, all -> 0x00ec }
        r14.<init>(r13);	 Catch:{ Throwable -> 0x00f0, all -> 0x00ec }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = new byte[r4];	 Catch:{ Throwable -> 0x00e8 }
    L_0x00d1:
        r15 = r9.read(r4);	 Catch:{ Throwable -> 0x00e8 }
        r11 = -1;
        if (r15 == r11) goto L_0x00dc;
    L_0x00d8:
        r14.write(r4, r12, r15);	 Catch:{ Throwable -> 0x00e8 }
        goto L_0x00d1;
    L_0x00dc:
        r14.flush();	 Catch:{ Throwable -> 0x00e8 }
        if (r9 == 0) goto L_0x00e4;
    L_0x00e1:
        r9.close();	 Catch:{ Throwable -> 0x01b0 }
    L_0x00e4:
        r14.close();	 Catch:{ Throwable -> 0x01b0 }
        goto L_0x011a;
    L_0x00e8:
        r0 = move-exception;
        r4 = r0;
        r11 = 1;
        goto L_0x00fc;
    L_0x00ec:
        r0 = move-exception;
        r1 = r0;
        r14 = r4;
        goto L_0x010e;
    L_0x00f0:
        r0 = move-exception;
        r14 = r4;
        goto L_0x00fa;
    L_0x00f3:
        r0 = move-exception;
        r1 = r0;
        r14 = r4;
        goto L_0x010f;
    L_0x00f7:
        r0 = move-exception;
        r9 = r4;
        r14 = r9;
    L_0x00fa:
        r11 = 1;
        r4 = r0;
    L_0x00fc:
        r15 = new java.lang.String[r11];	 Catch:{ all -> 0x010c }
        r4 = r4.toString();	 Catch:{ all -> 0x010c }
        r15[r12] = r4;	 Catch:{ all -> 0x010c }
        if (r9 == 0) goto L_0x0109;
    L_0x0106:
        r9.close();	 Catch:{ Throwable -> 0x01b0 }
    L_0x0109:
        if (r14 == 0) goto L_0x011a;
    L_0x010b:
        goto L_0x00e4;
    L_0x010c:
        r0 = move-exception;
        r1 = r0;
    L_0x010e:
        r4 = r9;
    L_0x010f:
        if (r4 == 0) goto L_0x0114;
    L_0x0111:
        r4.close();	 Catch:{ Throwable -> 0x01b0 }
    L_0x0114:
        if (r14 == 0) goto L_0x0119;
    L_0x0116:
        r14.close();	 Catch:{ Throwable -> 0x01b0 }
    L_0x0119:
        throw r1;	 Catch:{ Throwable -> 0x01b0 }
    L_0x011a:
        r4 = r13.exists();	 Catch:{ Throwable -> 0x01b0 }
        if (r4 == 0) goto L_0x015a;
    L_0x0120:
        r3 = r13.getAbsolutePath();	 Catch:{ Throwable -> 0x014a }
        r3 = com.getui.gtc.e.j.b(r3);	 Catch:{ Throwable -> 0x014a }
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Throwable -> 0x014a }
        if (r2 == 0) goto L_0x0148;
    L_0x012e:
        r2 = r10.a;	 Catch:{ Throwable -> 0x014a }
        r3 = r13.getAbsolutePath();	 Catch:{ Throwable -> 0x014a }
        r9 = r10.d;	 Catch:{ Throwable -> 0x014a }
        r11 = r18.getCs();	 Catch:{ Throwable -> 0x014a }
        r1 = r10;
        r4 = r6;
        r6 = r7;
        r7 = r9;
        r9 = r11;
        r1 = r1.a(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x014a }
        if (r1 == 0) goto L_0x0148;
    L_0x0145:
        r13.delete();	 Catch:{ Throwable -> 0x014a }
    L_0x0148:
        monitor-exit(r17);
        return;
    L_0x014a:
        r0 = move-exception;
        r1 = r0;
        r2 = 1;
        r3 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x0157 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x01b0 }
        r3[r12] = r1;	 Catch:{ Throwable -> 0x01b0 }
        monitor-exit(r17);
        return;
    L_0x0157:
        r0 = move-exception;
        r1 = r0;
        goto L_0x01b3;
    L_0x015a:
        r1 = java.lang.Class.forName(r6);	 Catch:{ Throwable -> 0x019e }
        r2 = r1.newInstance();	 Catch:{ Throwable -> 0x019e }
        r4 = "onCreate";
        r5 = 3;
        r6 = new java.lang.Class[r5];	 Catch:{ Throwable -> 0x019e }
        r7 = android.content.Context.class;
        r6[r12] = r7;	 Catch:{ Throwable -> 0x019e }
        r7 = java.lang.String.class;
        r8 = 1;
        r6[r8] = r7;	 Catch:{ Throwable -> 0x019a }
        r7 = java.lang.String.class;
        r8 = 2;
        r6[r8] = r7;	 Catch:{ Throwable -> 0x019e }
        r1 = r1.getDeclaredMethod(r4, r6);	 Catch:{ Throwable -> 0x019e }
        r4 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x019e }
        r5 = r10.a;	 Catch:{ Throwable -> 0x019e }
        r4[r12] = r5;	 Catch:{ Throwable -> 0x019e }
        r5 = 1;
        r4[r5] = r3;	 Catch:{ Throwable -> 0x0196 }
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x019e }
        r3 = r3.c();	 Catch:{ Throwable -> 0x019e }
        r4[r8] = r3;	 Catch:{ Throwable -> 0x019e }
        r1.invoke(r2, r4);	 Catch:{ Throwable -> 0x019e }
        r1 = r10.e;	 Catch:{ Throwable -> 0x019e }
        r1.add(r2);	 Catch:{ Throwable -> 0x019e }
        monitor-exit(r17);
        return;
    L_0x0196:
        r0 = move-exception;
        r1 = r0;
        r2 = r5;
        goto L_0x01a1;
    L_0x019a:
        r0 = move-exception;
        r1 = r0;
        r2 = r8;
        goto L_0x01a1;
    L_0x019e:
        r0 = move-exception;
        r1 = r0;
        r2 = 1;
    L_0x01a1:
        r3 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x0157 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x01b0 }
        r3[r12] = r1;	 Catch:{ Throwable -> 0x01b0 }
        monitor-exit(r17);
        return;
    L_0x01ab:
        monitor-exit(r17);
        return;
    L_0x01ad:
        r0 = move-exception;
        r1 = r0;
        goto L_0x01bd;
    L_0x01b0:
        r0 = move-exception;
        r1 = r0;
        r2 = 1;
    L_0x01b3:
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x01ad }
        r1 = r1.toString();	 Catch:{ all -> 0x01ad }
        r2[r12] = r1;	 Catch:{ all -> 0x01ad }
        monitor-exit(r17);
        return;
    L_0x01bd:
        monitor-exit(r17);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.b.c.a(com.getui.gtc.entity.Ie, com.getui.gtc.entity.d):void");
    }

    private void a(File file) {
        if (file.isDirectory()) {
            for (String file2 : file.list()) {
                a(new File(file, file2));
            }
        }
        file.delete();
    }

    private static void a(File file, File file2, String str) {
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
                            bufferedOutputStream.write(i.a(obj2, str));
                        }
                        bufferedOutputStream.flush();
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
                        } catch (Exception e3) {
                            new String[1][0] = e3.toString();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream2 = fileInputStream;
                        try {
                            new String[1][0] = e.toString();
                            e.a(file2);
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
                                } catch (Exception e32) {
                                    new String[1][0] = e32.toString();
                                }
                            }
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
                    e.a(file2);
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
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
                e.a(file2);
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
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
            e.a(file2);
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
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

    private boolean a(Context context, String str, String str2, String str3, String str4, String str5, d dVar, String str6) {
        if (b(str2)) {
            return false;
        }
        File file = new File(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(ShareConstants.JAR_SUFFIX);
        str = stringBuilder.toString();
        File file2 = new File(str);
        String absolutePath = context.getFilesDir().getAbsolutePath();
        e.b(absolutePath, str4);
        a(file, file2, str3);
        if (file2.exists()) {
            try {
                Class loadClass;
                a(str, str2, str6);
                try {
                    loadClass = new DexClassLoader(file2.getAbsolutePath(), absolutePath, null, context.getClassLoader()).loadClass(str2);
                    e.a(file2);
                    e.a(absolutePath, str4);
                } catch (Exception e) {
                    new String[1][0] = e.toString();
                    e.a(file2);
                    e.a(absolutePath, str4);
                    loadClass = null;
                }
                if (loadClass != null) {
                    Object newInstance = loadClass.newInstance();
                    if (newInstance != null) {
                        try {
                            Method declaredMethod;
                            Object[] objArr;
                            CharSequence charSequence = dVar.e;
                            String[] strArr = new String[1];
                            StringBuilder stringBuilder2 = new StringBuilder("reflect init:");
                            stringBuilder2.append(str2);
                            stringBuilder2.append(", appid:");
                            stringBuilder2.append(charSequence);
                            strArr[0] = stringBuilder2.toString();
                            if (TextUtils.isEmpty(charSequence)) {
                                declaredMethod = loadClass.getDeclaredMethod("onCreate", new Class[]{Context.class, String.class});
                                objArr = new Object[]{context, str5};
                            } else {
                                declaredMethod = loadClass.getDeclaredMethod("onCreate", new Class[]{Context.class, String.class, String.class});
                                objArr = new Object[]{context, charSequence, str5};
                            }
                            declaredMethod.invoke(newInstance, objArr);
                            this.e.add(newInstance);
                            return true;
                        } catch (Exception e2) {
                            new String[1][0] = e2.toString();
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                new String[1][0] = th.toString();
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }
        return false;
    }

    private boolean a(String str, String str2, String str3) {
        try {
            String d = d(str2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d);
            stringBuilder.append(File.separator);
            stringBuilder.append(CheckCodeDO.CHECKCODE_CHECK_URL_KEY);
            d = stringBuilder.toString();
            if (new File(d).exists()) {
                CharSequence c = c(d);
                if (!TextUtils.isEmpty(c) && str3.equals(c)) {
                    return true;
                }
            }
            a(str2);
            new String[1][0] = "unzip ...";
            stringBuilder = new StringBuilder();
            stringBuilder.append(d(str2));
            stringBuilder.append(File.separator);
            if (k.a(str, stringBuilder.toString(), "res")) {
                new String[1][0] = "write cs finish ...";
                if (e.a(str3.getBytes(), d)) {
                    new String[1][0] = "write ck finish ...";
                    return true;
                }
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
        return false;
    }

    private boolean b(String str) {
        if (!(this.e == null || TextUtils.isEmpty(str))) {
            for (Object obj : this.e) {
                if (str.equals(obj.getClass().getCanonicalName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static java.lang.String c(java.lang.String r5) {
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
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x003f, all -> 0x0032 }
        r1.<init>();	 Catch:{ Exception -> 0x003f, all -> 0x0032 }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0030, all -> 0x002e }
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0030, all -> 0x002e }
        r3.<init>(r5);	 Catch:{ Exception -> 0x0030, all -> 0x002e }
    L_0x000f:
        r5 = r3.read(r2);	 Catch:{ Exception -> 0x0041, all -> 0x002b }
        r4 = -1;	 Catch:{ Exception -> 0x0041, all -> 0x002b }
        if (r5 == r4) goto L_0x001b;	 Catch:{ Exception -> 0x0041, all -> 0x002b }
    L_0x0016:
        r4 = 0;	 Catch:{ Exception -> 0x0041, all -> 0x002b }
        r1.write(r2, r4, r5);	 Catch:{ Exception -> 0x0041, all -> 0x002b }
        goto L_0x000f;	 Catch:{ Exception -> 0x0041, all -> 0x002b }
    L_0x001b:
        r5 = new java.lang.String;	 Catch:{ Exception -> 0x0041, all -> 0x002b }
        r2 = r1.toByteArray();	 Catch:{ Exception -> 0x0041, all -> 0x002b }
        r5.<init>(r2);	 Catch:{ Exception -> 0x0041, all -> 0x002b }
        r3.close();	 Catch:{ IOException -> 0x0027 }
    L_0x0027:
        r1.close();	 Catch:{ IOException -> 0x002a }
    L_0x002a:
        return r5;
    L_0x002b:
        r5 = move-exception;
        r0 = r3;
        goto L_0x0034;
    L_0x002e:
        r5 = move-exception;
        goto L_0x0034;
    L_0x0030:
        r3 = r0;
        goto L_0x0041;
    L_0x0032:
        r5 = move-exception;
        r1 = r0;
    L_0x0034:
        if (r0 == 0) goto L_0x0039;
    L_0x0036:
        r0.close();	 Catch:{ IOException -> 0x0039 }
    L_0x0039:
        if (r1 == 0) goto L_0x003e;
    L_0x003b:
        r1.close();	 Catch:{ IOException -> 0x003e }
    L_0x003e:
        throw r5;
    L_0x003f:
        r1 = r0;
        r3 = r1;
    L_0x0041:
        if (r3 == 0) goto L_0x0046;
    L_0x0043:
        r3.close();	 Catch:{ IOException -> 0x0046 }
    L_0x0046:
        if (r1 == 0) goto L_0x004b;
    L_0x0048:
        r1.close();	 Catch:{ IOException -> 0x004b }
    L_0x004b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.b.c.c(java.lang.String):java.lang.String");
    }

    private String d(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f);
        stringBuilder.append(File.separator);
        stringBuilder.append(j.a(str).substring(0, 7));
        return stringBuilder.toString();
    }

    public final synchronized void a() {
        try {
            if (this.e != null) {
                this.e.clear();
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    public final synchronized void a(d dVar) {
        int i = dVar.a;
        try {
            com.getui.gtc.entity.a b = b.b().b(i);
            if (b != null && b.b.size() > 0) {
                List<Integer> arrayList = new ArrayList(b.b.size());
                boolean[] zArr = new boolean[]{false};
                b.a(new f(this, dVar, arrayList, zArr));
                if (zArr[0] || !arrayList.isEmpty()) {
                    for (Integer intValue : arrayList) {
                        b.b(intValue.intValue());
                    }
                    b.b().a(i, b);
                }
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
        try {
            Object a = b.b().a(i);
            if (!TextUtils.isEmpty(a)) {
                for (String valueOf : a.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    a(l.a(Integer.valueOf(valueOf).intValue(), dVar.b), dVar);
                }
            }
        } catch (Throwable th2) {
            new String[1][0] = th2.toString();
            return;
        }
        return;
    }

    public final synchronized void a(d dVar, com.getui.gtc.entity.a aVar, com.getui.gtc.entity.a aVar2) {
        try {
            h.d.put(dVar.a, aVar);
            if (aVar2 != null && aVar2.b.size() > 0) {
                aVar2.a(new d(this, aVar, aVar2));
            }
            if (aVar != null && aVar.b.size() > 0) {
                aVar.a(new e(this, aVar2, dVar));
            }
            if (aVar2 != null && aVar2.b.size() > 0) {
                aVar2.a = aVar.a;
                b.b().a(dVar.a, aVar2);
            }
        } catch (Exception e) {
            new String[1][0] = e.toString();
        }
    }

    public final synchronized void a(d dVar, String str, String str2) {
        try {
            List<String> asList = Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (TextUtils.isEmpty(str2)) {
                for (String str22 : asList) {
                    a(l.a(Integer.valueOf(str22).intValue(), dVar.b), dVar);
                }
                return;
            }
            List asList2 = Arrays.asList(str22.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
            for (String str3 : asList) {
                if (!asList2.contains(str3)) {
                    a(l.a(Integer.valueOf(str3).intValue(), dVar.b), dVar);
                }
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    public final void a(String str) {
        File file = new File(d(str));
        if (file.exists()) {
            a(file);
        }
    }
}
