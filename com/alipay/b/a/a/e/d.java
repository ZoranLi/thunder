package com.alipay.b.a.a.e;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private static String a = "";
    private static String b = "";
    private static String c = "";

    public static synchronized void a(String str) {
        synchronized (d.class) {
            List arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList);
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (d.class) {
            a = str;
            b = str2;
            c = str3;
        }
    }

    public static synchronized void a(Throwable th) {
        synchronized (d.class) {
            Object obj;
            List arrayList = new ArrayList();
            if (th != null) {
                Writer stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                obj = stringWriter.toString();
            } else {
                obj = "";
            }
            arrayList.add(obj);
            a(arrayList);
        }
    }

    private static synchronized void a(java.util.List<java.lang.String> r8) {
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
        r0 = com.alipay.b.a.a.e.d.class;
        monitor-enter(r0);
        r1 = b;	 Catch:{ all -> 0x0099 }
        r1 = com.alipay.b.a.a.a.a.a(r1);	 Catch:{ all -> 0x0099 }
        if (r1 != 0) goto L_0x0097;	 Catch:{ all -> 0x0099 }
    L_0x000b:
        r1 = c;	 Catch:{ all -> 0x0099 }
        r1 = com.alipay.b.a.a.a.a.a(r1);	 Catch:{ all -> 0x0099 }
        if (r1 == 0) goto L_0x0015;	 Catch:{ all -> 0x0099 }
    L_0x0013:
        goto L_0x0097;	 Catch:{ all -> 0x0099 }
    L_0x0015:
        r1 = new java.lang.StringBuffer;	 Catch:{ all -> 0x0099 }
        r1.<init>();	 Catch:{ all -> 0x0099 }
        r2 = c;	 Catch:{ all -> 0x0099 }
        r1.append(r2);	 Catch:{ all -> 0x0099 }
        r8 = r8.iterator();	 Catch:{ all -> 0x0099 }
    L_0x0023:
        r2 = r8.hasNext();	 Catch:{ all -> 0x0099 }
        if (r2 == 0) goto L_0x0041;	 Catch:{ all -> 0x0099 }
    L_0x0029:
        r2 = r8.next();	 Catch:{ all -> 0x0099 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x0099 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0099 }
        r4 = ", ";	 Catch:{ all -> 0x0099 }
        r3.<init>(r4);	 Catch:{ all -> 0x0099 }
        r3.append(r2);	 Catch:{ all -> 0x0099 }
        r2 = r3.toString();	 Catch:{ all -> 0x0099 }
        r1.append(r2);	 Catch:{ all -> 0x0099 }
        goto L_0x0023;	 Catch:{ all -> 0x0099 }
    L_0x0041:
        r8 = "\n";	 Catch:{ all -> 0x0099 }
        r1.append(r8);	 Catch:{ all -> 0x0099 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0095 }
        r2 = a;	 Catch:{ Exception -> 0x0095 }
        r8.<init>(r2);	 Catch:{ Exception -> 0x0095 }
        r2 = r8.exists();	 Catch:{ Exception -> 0x0095 }
        if (r2 != 0) goto L_0x0056;	 Catch:{ Exception -> 0x0095 }
    L_0x0053:
        r8.mkdirs();	 Catch:{ Exception -> 0x0095 }
    L_0x0056:
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0095 }
        r2 = a;	 Catch:{ Exception -> 0x0095 }
        r3 = b;	 Catch:{ Exception -> 0x0095 }
        r8.<init>(r2, r3);	 Catch:{ Exception -> 0x0095 }
        r2 = r8.exists();	 Catch:{ Exception -> 0x0095 }
        if (r2 != 0) goto L_0x0068;	 Catch:{ Exception -> 0x0095 }
    L_0x0065:
        r8.createNewFile();	 Catch:{ Exception -> 0x0095 }
    L_0x0068:
        r2 = r8.length();	 Catch:{ Exception -> 0x0095 }
        r4 = r1.length();	 Catch:{ Exception -> 0x0095 }
        r4 = (long) r4;	 Catch:{ Exception -> 0x0095 }
        r6 = r4 + r2;	 Catch:{ Exception -> 0x0095 }
        r2 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;	 Catch:{ Exception -> 0x0095 }
        r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x0095 }
        if (r4 > 0) goto L_0x0081;	 Catch:{ Exception -> 0x0095 }
    L_0x007a:
        r2 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0095 }
        r3 = 1;	 Catch:{ Exception -> 0x0095 }
        r2.<init>(r8, r3);	 Catch:{ Exception -> 0x0095 }
        goto L_0x0086;	 Catch:{ Exception -> 0x0095 }
    L_0x0081:
        r2 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0095 }
        r2.<init>(r8);	 Catch:{ Exception -> 0x0095 }
    L_0x0086:
        r8 = r1.toString();	 Catch:{ Exception -> 0x0095 }
        r2.write(r8);	 Catch:{ Exception -> 0x0095 }
        r2.flush();	 Catch:{ Exception -> 0x0095 }
        r2.close();	 Catch:{ Exception -> 0x0095 }
        monitor-exit(r0);
        return;
    L_0x0095:
        monitor-exit(r0);
        return;
    L_0x0097:
        monitor-exit(r0);
        return;
    L_0x0099:
        r8 = move-exception;
        monitor-exit(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.e.d.a(java.util.List):void");
    }
}
