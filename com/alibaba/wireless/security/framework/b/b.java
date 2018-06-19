package com.alibaba.wireless.security.framework.b;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class b {
    private FileChannel a = null;
    private FileLock b = null;
    private RandomAccessFile c = null;
    private File d = null;
    private boolean e = true;

    public b(android.content.Context r1, java.lang.String r2) {
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
        r0 = this;
        r0.<init>();
        r1 = 0;
        r0.a = r1;
        r0.b = r1;
        r0.c = r1;
        r0.d = r1;
        r1 = 1;
        r0.e = r1;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0024 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0024 }
        r0.d = r1;	 Catch:{ Exception -> 0x0024 }
        r1 = r0.d;	 Catch:{ Exception -> 0x0024 }
        r1 = r1.exists();	 Catch:{ Exception -> 0x0024 }
        if (r1 != 0) goto L_0x0023;	 Catch:{ Exception -> 0x0024 }
    L_0x001e:
        r1 = r0.d;	 Catch:{ Exception -> 0x0024 }
        r1.createNewFile();	 Catch:{ Exception -> 0x0024 }
    L_0x0023:
        return;
    L_0x0024:
        r1 = r0.d;
        r1 = r1.exists();
        if (r1 != 0) goto L_0x003d;
    L_0x002c:
        r1 = r0.d;	 Catch:{ Exception -> 0x0032 }
        r1.createNewFile();	 Catch:{ Exception -> 0x0032 }
        return;
    L_0x0032:
        r1 = r0.d;
        r1 = r1.exists();
        if (r1 != 0) goto L_0x003d;
    L_0x003a:
        r1 = 0;
        r0.e = r1;
    L_0x003d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.b.<init>(android.content.Context, java.lang.String):void");
    }

    public boolean a() {
        if (!this.e) {
            return true;
        }
        try {
            if (this.d != null) {
                this.c = new RandomAccessFile(this.d, "rw");
                this.a = this.c.getChannel();
                this.b = this.a.lock();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean b() {
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
        r0 = r4.e;
        r1 = 1;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = 0;
        r2 = 0;
        r3 = r4.b;	 Catch:{ IOException -> 0x0014 }
        if (r3 == 0) goto L_0x0015;	 Catch:{ IOException -> 0x0014 }
    L_0x000c:
        r3 = r4.b;	 Catch:{ IOException -> 0x0014 }
        r3.release();	 Catch:{ IOException -> 0x0014 }
        r4.b = r2;	 Catch:{ IOException -> 0x0014 }
        goto L_0x0015;
    L_0x0014:
        r1 = r0;
    L_0x0015:
        r3 = r4.a;	 Catch:{ IOException -> 0x0021 }
        if (r3 == 0) goto L_0x0022;	 Catch:{ IOException -> 0x0021 }
    L_0x0019:
        r3 = r4.a;	 Catch:{ IOException -> 0x0021 }
        r3.close();	 Catch:{ IOException -> 0x0021 }
        r4.a = r2;	 Catch:{ IOException -> 0x0021 }
        goto L_0x0022;
    L_0x0021:
        r1 = r0;
    L_0x0022:
        r3 = r4.c;	 Catch:{ IOException -> 0x002e }
        if (r3 == 0) goto L_0x002d;	 Catch:{ IOException -> 0x002e }
    L_0x0026:
        r3 = r4.c;	 Catch:{ IOException -> 0x002e }
        r3.close();	 Catch:{ IOException -> 0x002e }
        r4.c = r2;	 Catch:{ IOException -> 0x002e }
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.b.b.b():boolean");
    }
}
