package com.igexin.b.a.c;

import android.app.Activity;
import com.igexin.push.config.q;
import java.lang.Thread.UncaughtExceptionHandler;

public class a extends Activity implements UncaughtExceptionHandler {
    public static boolean a = q.a.equals("debug");

    public static synchronized void a(String str) {
        synchronized (a.class) {
            b(str);
        }
    }

    public static void a(String str, String str2) {
    }

    public static synchronized void b(java.lang.String r7) {
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
        r0 = com.igexin.b.a.c.a.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x00eb }
        if (r1 != 0) goto L_0x0019;	 Catch:{ all -> 0x00eb }
    L_0x0007:
        r1 = com.igexin.push.core.g.O;	 Catch:{ all -> 0x00eb }
        if (r1 == 0) goto L_0x0017;	 Catch:{ all -> 0x00eb }
    L_0x000b:
        r1 = com.igexin.push.core.g.P;	 Catch:{ all -> 0x00eb }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00eb }
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 >= 0) goto L_0x0019;
    L_0x0015:
        monitor-exit(r0);
        return;
    L_0x0017:
        monitor-exit(r0);
        return;
    L_0x0019:
        r1 = new java.text.SimpleDateFormat;	 Catch:{ all -> 0x00eb }
        r2 = "yyyy-MM-dd";	 Catch:{ all -> 0x00eb }
        r3 = java.util.Locale.getDefault();	 Catch:{ all -> 0x00eb }
        r1.<init>(r2, r3);	 Catch:{ all -> 0x00eb }
        r2 = new java.util.Date;	 Catch:{ all -> 0x00eb }
        r2.<init>();	 Catch:{ all -> 0x00eb }
        r1 = r1.format(r2);	 Catch:{ all -> 0x00eb }
        r2 = com.igexin.push.core.g.e;	 Catch:{ all -> 0x00eb }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x00eb }
        if (r3 == 0) goto L_0x0037;
    L_0x0035:
        monitor-exit(r0);
        return;
    L_0x0037:
        r3 = android.os.Environment.getExternalStorageState();	 Catch:{ all -> 0x00eb }
        r4 = "mounted";	 Catch:{ all -> 0x00eb }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x00eb }
        if (r3 == 0) goto L_0x00e9;	 Catch:{ all -> 0x00eb }
    L_0x0043:
        r3 = "/sdcard/libs//";	 Catch:{ all -> 0x00eb }
        r4 = new java.io.File;	 Catch:{ all -> 0x00eb }
        r4.<init>(r3);	 Catch:{ all -> 0x00eb }
        r5 = r4.exists();	 Catch:{ all -> 0x00eb }
        if (r5 != 0) goto L_0x0058;	 Catch:{ all -> 0x00eb }
    L_0x0050:
        r4 = r4.mkdir();	 Catch:{ all -> 0x00eb }
        if (r4 != 0) goto L_0x0058;
    L_0x0056:
        monitor-exit(r0);
        return;
    L_0x0058:
        r4 = 0;
        r5 = new java.io.File;	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r6.<init>();	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r6.append(r3);	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r6.append(r2);	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r2 = ".";	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r6.append(r2);	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r6.append(r1);	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r1 = ".log";	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r6.append(r1);	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r1 = r6.toString();	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r5.<init>(r1);	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r1 = r5.exists();	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        if (r1 != 0) goto L_0x0088;	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
    L_0x0080:
        r1 = r5.createNewFile();	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        if (r1 != 0) goto L_0x0088;
    L_0x0086:
        monitor-exit(r0);
        return;
    L_0x0088:
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r2 = 1;	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r1.<init>(r5, r2);	 Catch:{ Exception -> 0x00df, all -> 0x00d7 }
        r2 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r3 = "yyyy-MM-dd HH:mm:ss:SSS";	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r4 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r3 = new java.util.Date;	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r3.<init>();	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r2 = r2.format(r3);	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r3.<init>();	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r3.append(r2);	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r2 = "|";	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r3.append(r2);	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r3.append(r7);	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r7 = r3.toString();	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r2.<init>();	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r2.append(r7);	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r7 = "\r\n";	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r2.append(r7);	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r7 = r2.toString();	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r7 = r7.getBytes();	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r1.write(r7);	 Catch:{ Exception -> 0x00e0, all -> 0x00d5 }
        r1.close();	 Catch:{ IOException -> 0x00d3 }
        monitor-exit(r0);
        return;
    L_0x00d3:
        monitor-exit(r0);
        return;
    L_0x00d5:
        r7 = move-exception;
        goto L_0x00d9;
    L_0x00d7:
        r7 = move-exception;
        r1 = r4;
    L_0x00d9:
        if (r1 == 0) goto L_0x00de;
    L_0x00db:
        r1.close();	 Catch:{ IOException -> 0x00de }
    L_0x00de:
        throw r7;	 Catch:{ all -> 0x00eb }
    L_0x00df:
        r1 = r4;
    L_0x00e0:
        if (r1 == 0) goto L_0x00e9;
    L_0x00e2:
        r1.close();	 Catch:{ IOException -> 0x00e7 }
        monitor-exit(r0);
        return;
    L_0x00e7:
        monitor-exit(r0);
        return;
    L_0x00e9:
        monitor-exit(r0);
        return;
    L_0x00eb:
        r7 = move-exception;
        monitor-exit(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.c.a.b(java.lang.String):void");
    }

    public static void b(String str, String str2) {
    }

    public void uncaughtException(Thread thread, Throwable th) {
    }
}
