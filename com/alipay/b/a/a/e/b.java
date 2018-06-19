package com.alipay.b.a.a.e;

import com.alipay.b.a.a.c.b.a;
import java.io.File;

public final class b {
    private File a = null;
    private a b = null;

    public b(String str, a aVar) {
        this.a = new File(str);
        this.b = aVar;
    }

    private static java.lang.String a(java.lang.String r3) {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "type";	 Catch:{ Exception -> 0x0016 }
        r2 = "id";	 Catch:{ Exception -> 0x0016 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0016 }
        r1 = "error";	 Catch:{ Exception -> 0x0016 }
        r0.put(r1, r3);	 Catch:{ Exception -> 0x0016 }
        r3 = r0.toString();
        return r3;
    L_0x0016:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.e.b.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b() {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.a;	 Catch:{ all -> 0x00be }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r7);
        return;
    L_0x0007:
        r0 = r7.a;	 Catch:{ all -> 0x00be }
        r0 = r0.exists();	 Catch:{ all -> 0x00be }
        if (r0 == 0) goto L_0x00bc;
    L_0x000f:
        r0 = r7.a;	 Catch:{ all -> 0x00be }
        r0 = r0.isDirectory();	 Catch:{ all -> 0x00be }
        if (r0 == 0) goto L_0x00bc;
    L_0x0017:
        r0 = r7.a;	 Catch:{ all -> 0x00be }
        r0 = r0.list();	 Catch:{ all -> 0x00be }
        r0 = r0.length;	 Catch:{ all -> 0x00be }
        if (r0 != 0) goto L_0x0022;
    L_0x0020:
        goto L_0x00bc;
    L_0x0022:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x00be }
        r0.<init>();	 Catch:{ all -> 0x00be }
        r1 = r7.a;	 Catch:{ all -> 0x00be }
        r1 = r1.list();	 Catch:{ all -> 0x00be }
        r2 = r1.length;	 Catch:{ all -> 0x00be }
        r3 = 0;
        r4 = r3;
    L_0x0030:
        if (r4 >= r2) goto L_0x003a;
    L_0x0032:
        r5 = r1[r4];	 Catch:{ all -> 0x00be }
        r0.add(r5);	 Catch:{ all -> 0x00be }
        r4 = r4 + 1;
        goto L_0x0030;
    L_0x003a:
        java.util.Collections.sort(r0);	 Catch:{ all -> 0x00be }
        r1 = r0.size();	 Catch:{ all -> 0x00be }
        r1 = r1 + -1;
        r1 = r0.get(r1);	 Catch:{ all -> 0x00be }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x00be }
        r2 = r0.size();	 Catch:{ all -> 0x00be }
        r4 = java.util.Calendar.getInstance();	 Catch:{ all -> 0x00be }
        r4 = r4.getTime();	 Catch:{ all -> 0x00be }
        r5 = new java.text.SimpleDateFormat;	 Catch:{ all -> 0x00be }
        r6 = "yyyyMMdd";
        r5.<init>(r6);	 Catch:{ all -> 0x00be }
        r4 = r5.format(r4);	 Catch:{ all -> 0x00be }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00be }
        r5.<init>();	 Catch:{ all -> 0x00be }
        r5.append(r4);	 Catch:{ all -> 0x00be }
        r4 = ".log";
        r5.append(r4);	 Catch:{ all -> 0x00be }
        r4 = r5.toString();	 Catch:{ all -> 0x00be }
        r4 = r1.equals(r4);	 Catch:{ all -> 0x00be }
        if (r4 == 0) goto L_0x008d;
    L_0x0077:
        r1 = r0.size();	 Catch:{ all -> 0x00be }
        r4 = 2;
        if (r1 >= r4) goto L_0x0080;
    L_0x007e:
        monitor-exit(r7);
        return;
    L_0x0080:
        r1 = r0.size();	 Catch:{ all -> 0x00be }
        r1 = r1 - r4;
        r1 = r0.get(r1);	 Catch:{ all -> 0x00be }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x00be }
        r2 = r2 + -1;
    L_0x008d:
        r4 = r7.a;	 Catch:{ all -> 0x00be }
        r4 = r4.getAbsolutePath();	 Catch:{ all -> 0x00be }
        r1 = com.alipay.b.a.a.a.b.a(r4, r1);	 Catch:{ all -> 0x00be }
        r1 = a(r1);	 Catch:{ all -> 0x00be }
        r4 = r7.b;	 Catch:{ all -> 0x00be }
        r1 = r4.a(r1);	 Catch:{ all -> 0x00be }
        if (r1 != 0) goto L_0x00a5;
    L_0x00a3:
        r2 = r2 + -1;
    L_0x00a5:
        if (r3 >= r2) goto L_0x00ba;
    L_0x00a7:
        r1 = r0.get(r3);	 Catch:{ all -> 0x00be }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x00be }
        r4 = new java.io.File;	 Catch:{ all -> 0x00be }
        r5 = r7.a;	 Catch:{ all -> 0x00be }
        r4.<init>(r5, r1);	 Catch:{ all -> 0x00be }
        r4.delete();	 Catch:{ all -> 0x00be }
        r3 = r3 + 1;
        goto L_0x00a5;
    L_0x00ba:
        monitor-exit(r7);
        return;
    L_0x00bc:
        monitor-exit(r7);
        return;
    L_0x00be:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.e.b.b():void");
    }

    public final void a() {
        new Thread(new c(this)).start();
    }
}
