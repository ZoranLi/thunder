package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.data.c;
import com.ta.utdid2.device.UTDevice;

public final class b {
    private static b b;
    public Context a;

    private b() {
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    private Context d() {
        return this.a;
    }

    public final void a(Context context) {
        this.a = context.getApplicationContext();
    }

    private static c e() {
        return c.a();
    }

    public static boolean b() {
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
        r0 = 5;
        r1 = new java.lang.String[r0];
        r2 = "/system/xbin/";
        r3 = 0;
        r1[r3] = r2;
        r2 = "/system/bin/";
        r4 = 1;
        r1[r4] = r2;
        r2 = "/system/sbin/";
        r5 = 2;
        r1[r5] = r2;
        r2 = "/sbin/";
        r6 = 3;
        r1[r6] = r2;
        r2 = "/vendor/bin/";
        r7 = 4;
        r1[r7] = r2;
        r2 = r3;
    L_0x001d:
        if (r2 >= r0) goto L_0x0067;
    L_0x001f:
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0067 }
        r7.<init>();	 Catch:{ Exception -> 0x0067 }
        r8 = r1[r2];	 Catch:{ Exception -> 0x0067 }
        r7.append(r8);	 Catch:{ Exception -> 0x0067 }
        r8 = "su";	 Catch:{ Exception -> 0x0067 }
        r7.append(r8);	 Catch:{ Exception -> 0x0067 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x0067 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0067 }
        r8.<init>(r7);	 Catch:{ Exception -> 0x0067 }
        r8 = r8.exists();	 Catch:{ Exception -> 0x0067 }
        if (r8 == 0) goto L_0x0064;	 Catch:{ Exception -> 0x0067 }
    L_0x003d:
        r0 = new java.lang.String[r6];	 Catch:{ Exception -> 0x0067 }
        r1 = "ls";	 Catch:{ Exception -> 0x0067 }
        r0[r3] = r1;	 Catch:{ Exception -> 0x0067 }
        r1 = "-l";	 Catch:{ Exception -> 0x0067 }
        r0[r4] = r1;	 Catch:{ Exception -> 0x0067 }
        r0[r5] = r7;	 Catch:{ Exception -> 0x0067 }
        r0 = a(r0);	 Catch:{ Exception -> 0x0067 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0067 }
        if (r1 != 0) goto L_0x0063;	 Catch:{ Exception -> 0x0067 }
    L_0x0053:
        r1 = "root";	 Catch:{ Exception -> 0x0067 }
        r1 = r0.indexOf(r1);	 Catch:{ Exception -> 0x0067 }
        r2 = "root";	 Catch:{ Exception -> 0x0067 }
        r0 = r0.lastIndexOf(r2);	 Catch:{ Exception -> 0x0067 }
        if (r1 != r0) goto L_0x0062;
    L_0x0061:
        goto L_0x0063;
    L_0x0062:
        return r4;
    L_0x0063:
        return r3;
    L_0x0064:
        r2 = r2 + 1;
        goto L_0x001d;
    L_0x0067:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.sys.b.b():boolean");
    }

    private static java.lang.String a(java.lang.String[] r4) {
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
        r0 = "";
        r1 = 0;
        r2 = new java.lang.ProcessBuilder;	 Catch:{ Throwable -> 0x003f, all -> 0x0039 }
        r2.<init>(r4);	 Catch:{ Throwable -> 0x003f, all -> 0x0039 }
        r4 = 0;	 Catch:{ Throwable -> 0x003f, all -> 0x0039 }
        r2.redirectErrorStream(r4);	 Catch:{ Throwable -> 0x003f, all -> 0x0039 }
        r4 = r2.start();	 Catch:{ Throwable -> 0x003f, all -> 0x0039 }
        r1 = new java.io.DataOutputStream;	 Catch:{ Throwable -> 0x0037, all -> 0x0035 }
        r2 = r4.getOutputStream();	 Catch:{ Throwable -> 0x0037, all -> 0x0035 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0037, all -> 0x0035 }
        r2 = new java.io.DataInputStream;	 Catch:{ Throwable -> 0x0037, all -> 0x0035 }
        r3 = r4.getInputStream();	 Catch:{ Throwable -> 0x0037, all -> 0x0035 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0037, all -> 0x0035 }
        r2 = r2.readLine();	 Catch:{ Throwable -> 0x0037, all -> 0x0035 }
        r0 = "exit\n";	 Catch:{ Throwable -> 0x0031, all -> 0x0035 }
        r1.writeBytes(r0);	 Catch:{ Throwable -> 0x0031, all -> 0x0035 }
        r1.flush();	 Catch:{ Throwable -> 0x0031, all -> 0x0035 }
        r4.waitFor();	 Catch:{ Throwable -> 0x0031, all -> 0x0035 }
    L_0x0031:
        r4.destroy();	 Catch:{ Exception -> 0x0042 }
        goto L_0x0042;
    L_0x0035:
        r0 = move-exception;
        goto L_0x003b;
    L_0x0037:
        r2 = r0;
        goto L_0x0031;
    L_0x0039:
        r0 = move-exception;
        r4 = r1;
    L_0x003b:
        r4.destroy();	 Catch:{ Exception -> 0x003e }
    L_0x003e:
        throw r0;
    L_0x003f:
        r2 = r0;
        r4 = r1;
        goto L_0x0031;
    L_0x0042:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.sys.b.a(java.lang.String[]):java.lang.String");
    }

    public final String c() {
        String str = "";
        try {
            return UTDevice.getUtdid(this.a);
        } catch (Throwable th) {
            a.a(com.alipay.sdk.app.statistic.c.e, com.alipay.sdk.app.statistic.c.i, th);
            return str;
        }
    }
}
