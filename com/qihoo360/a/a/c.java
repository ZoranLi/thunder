package com.qihoo360.a.a;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: ProcessLocker */
public final class c {
    private final Context a;
    private FileOutputStream b;
    private FileChannel c;
    private FileLock d;
    private File e;

    public c(Context context, String str) {
        this.a = context;
        try {
            this.e = new File(str);
            this.b = this.a.openFileOutput(str, 0);
            if (this.b != null) {
                this.c = this.b.getChannel();
            }
        } catch (Context context2) {
            context2.getMessage();
        }
    }

    public c(Context context, String str, String str2) {
        this.a = context;
        try {
            this.e = new File(str, str2);
            if (this.e.exists() == null) {
                context = this.e.getParentFile();
                if (context != null) {
                    if (context.exists() != null) {
                        if (context.isDirectory() == null) {
                            str = new StringBuilder("File ");
                            str.append(context);
                            str.append(" exists and is not a directory. Unable to create directory.");
                            throw new IOException(str.toString());
                        }
                    } else if (context.mkdirs() == null && context.isDirectory() == null) {
                        str = new StringBuilder("Unable to create directory ");
                        str.append(context);
                        throw new IOException(str.toString());
                    }
                }
                this.e.createNewFile();
            }
            this.b = new FileOutputStream(this.e, null);
            this.c = this.b.getChannel();
        } catch (Context context2) {
            context2.getMessage();
        }
    }

    public final synchronized boolean a() {
        boolean b;
        b = b();
        if (b) {
            d();
        }
        if (b) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }

    public final synchronized boolean b() {
        if (this.c == null) {
            return false;
        }
        try {
            this.d = this.c.tryLock();
            if (this.d != null) {
                return true;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return false;
    }

    public final synchronized boolean c() {
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
        r4 = this;
        monitor-enter(r4);
        r0 = r4.c;	 Catch:{ all -> 0x003f }
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r4);
        return r1;
    L_0x0008:
        r0 = r1;
    L_0x0009:
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        if (r0 >= r2) goto L_0x003d;
    L_0x000d:
        r2 = r4.c;	 Catch:{ IOException -> 0x0018 }
        r2 = r2.tryLock();	 Catch:{ IOException -> 0x0018 }
        r4.d = r2;	 Catch:{ IOException -> 0x0018 }
        goto L_0x0018;
    L_0x0016:
        r0 = move-exception;
        goto L_0x003a;
    L_0x0018:
        r2 = r4.d;	 Catch:{ Throwable -> 0x0016 }
        if (r2 == 0) goto L_0x001f;
    L_0x001c:
        r0 = 1;
        monitor-exit(r4);
        return r0;
    L_0x001f:
        r2 = r0 % 1000;	 Catch:{ Throwable -> 0x0016 }
        if (r2 != 0) goto L_0x0032;	 Catch:{ Throwable -> 0x0016 }
    L_0x0023:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0016 }
        r3 = "wait process lock: ";	 Catch:{ Throwable -> 0x0016 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0016 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0016 }
        r3 = "/5000";	 Catch:{ Throwable -> 0x0016 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0016 }
    L_0x0032:
        r2 = 10;	 Catch:{ Throwable -> 0x0016 }
        java.lang.Thread.sleep(r2, r1);	 Catch:{ Throwable -> 0x0016 }
        r0 = r0 + 10;
        goto L_0x0009;
    L_0x003a:
        r0.getMessage();	 Catch:{ all -> 0x003f }
    L_0x003d:
        monitor-exit(r4);
        return r1;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.a.a.c.c():boolean");
    }

    public final synchronized void d() {
        if (this.d != null) {
            try {
                this.d.release();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        if (this.c != null) {
            try {
                this.c.close();
            } catch (Throwable th2) {
                th2.getMessage();
            }
        }
        if (this.b != null) {
            try {
                this.b.close();
            } catch (Throwable th22) {
                th22.getMessage();
            }
        }
        if (this.e != null && this.e.exists()) {
            this.e.delete();
        }
    }
}
