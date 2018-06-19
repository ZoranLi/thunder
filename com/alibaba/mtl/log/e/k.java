package com.alibaba.mtl.log.e;

import java.io.File;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: MutiProcessLock */
public final class k {
    static File a;
    static FileChannel b;
    static FileLock c;

    public static synchronized boolean a(android.content.Context r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = com.alibaba.mtl.log.e.k.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x0028;	 Catch:{ all -> 0x006c }
    L_0x0007:
        r1 = new java.io.File;	 Catch:{ all -> 0x006c }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006c }
        r2.<init>();	 Catch:{ all -> 0x006c }
        r5 = r5.getFilesDir();	 Catch:{ all -> 0x006c }
        r2.append(r5);	 Catch:{ all -> 0x006c }
        r5 = java.io.File.separator;	 Catch:{ all -> 0x006c }
        r2.append(r5);	 Catch:{ all -> 0x006c }
        r5 = "ap.Lock";	 Catch:{ all -> 0x006c }
        r2.append(r5);	 Catch:{ all -> 0x006c }
        r5 = r2.toString();	 Catch:{ all -> 0x006c }
        r1.<init>(r5);	 Catch:{ all -> 0x006c }
        a = r1;	 Catch:{ all -> 0x006c }
    L_0x0028:
        r5 = a;	 Catch:{ all -> 0x006c }
        r5 = r5.exists();	 Catch:{ all -> 0x006c }
        if (r5 != 0) goto L_0x0037;
    L_0x0030:
        r1 = a;	 Catch:{ IOException -> 0x0037 }
        r1 = r1.createNewFile();	 Catch:{ IOException -> 0x0037 }
        r5 = r1;
    L_0x0037:
        r1 = 1;
        if (r5 != 0) goto L_0x003c;
    L_0x003a:
        monitor-exit(r0);
        return r1;
    L_0x003c:
        r5 = b;	 Catch:{ all -> 0x006c }
        r2 = 0;
        if (r5 != 0) goto L_0x0053;
    L_0x0041:
        r5 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0051 }
        r3 = a;	 Catch:{ Exception -> 0x0051 }
        r4 = "rw";	 Catch:{ Exception -> 0x0051 }
        r5.<init>(r3, r4);	 Catch:{ Exception -> 0x0051 }
        r5 = r5.getChannel();	 Catch:{ Exception -> 0x0051 }
        b = r5;	 Catch:{ Exception -> 0x0051 }
        goto L_0x0053;
    L_0x0051:
        monitor-exit(r0);
        return r2;
    L_0x0053:
        r5 = b;	 Catch:{ Throwable -> 0x005f }
        r5 = r5.tryLock();	 Catch:{ Throwable -> 0x005f }
        if (r5 == 0) goto L_0x0060;	 Catch:{ Throwable -> 0x005f }
    L_0x005b:
        c = r5;	 Catch:{ Throwable -> 0x005f }
        monitor-exit(r0);
        return r1;
    L_0x005f:
        r5 = 0;
    L_0x0060:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006c }
        r3 = "mLock:";	 Catch:{ all -> 0x006c }
        r1.<init>(r3);	 Catch:{ all -> 0x006c }
        r1.append(r5);	 Catch:{ all -> 0x006c }
        monitor-exit(r0);
        return r2;
    L_0x006c:
        r5 = move-exception;
        monitor-exit(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.k.a(android.content.Context):boolean");
    }

    public static synchronized void a() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = com.alibaba.mtl.log.e.k.class;
        monitor-enter(r0);
        r1 = c;	 Catch:{ all -> 0x002b }
        r2 = 0;
        if (r1 == 0) goto L_0x0014;
    L_0x0008:
        r1 = c;	 Catch:{ IOException -> 0x000d, all -> 0x0010 }
        r1.release();	 Catch:{ IOException -> 0x000d, all -> 0x0010 }
    L_0x000d:
        c = r2;	 Catch:{ all -> 0x002b }
        goto L_0x0014;	 Catch:{ all -> 0x002b }
    L_0x0010:
        r1 = move-exception;	 Catch:{ all -> 0x002b }
        c = r2;	 Catch:{ all -> 0x002b }
        throw r1;	 Catch:{ all -> 0x002b }
    L_0x0014:
        r1 = b;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0029;
    L_0x0018:
        r1 = b;	 Catch:{ Exception -> 0x0025, all -> 0x0021 }
        r1.close();	 Catch:{ Exception -> 0x0025, all -> 0x0021 }
        b = r2;	 Catch:{ all -> 0x002b }
        monitor-exit(r0);
        return;
    L_0x0021:
        r1 = move-exception;
        b = r2;	 Catch:{ all -> 0x002b }
        throw r1;	 Catch:{ all -> 0x002b }
    L_0x0025:
        b = r2;	 Catch:{ all -> 0x002b }
        monitor-exit(r0);
        return;
    L_0x0029:
        monitor-exit(r0);
        return;
    L_0x002b:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.k.a():void");
    }
}
