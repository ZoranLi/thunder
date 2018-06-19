package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.f.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AlarmEvent */
public class a extends d {
    public int a = 0;
    public int b = 0;
    public Map<String, String> c;
    public Map<String, Integer> d;

    public final synchronized void a() {
        this.a++;
    }

    public final synchronized void b() {
        this.b++;
    }

    public final synchronized void a(String str, String str2) {
        if (!b.b(str)) {
            if (this.c == null) {
                this.c = new HashMap();
            }
            if (this.d == null) {
                this.d = new HashMap();
            }
            if (b.a(str2)) {
                int i = 100;
                if (str2.length() <= 100) {
                    i = str2.length();
                }
                this.c.put(str, str2.substring(0, i));
            }
            if (this.d.containsKey(str) == null) {
                this.d.put(str, Integer.valueOf(1));
            } else {
                this.d.put(str, Integer.valueOf(((Integer) this.d.get(str)).intValue() + 1));
            }
        }
    }

    public final synchronized org.json.JSONObject c() {
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
        r8 = this;
        monitor-enter(r8);
        r0 = super.c();	 Catch:{ all -> 0x007c }
        r1 = "successCount";	 Catch:{ Exception -> 0x007a }
        r2 = r8.a;	 Catch:{ Exception -> 0x007a }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x007a }
        r1 = "failCount";	 Catch:{ Exception -> 0x007a }
        r2 = r8.b;	 Catch:{ Exception -> 0x007a }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x007a }
        r1 = r8.d;	 Catch:{ Exception -> 0x007a }
        if (r1 == 0) goto L_0x007a;	 Catch:{ Exception -> 0x007a }
    L_0x0017:
        r1 = com.alibaba.mtl.appmonitor.c.a.a();	 Catch:{ Exception -> 0x007a }
        r2 = com.alibaba.mtl.appmonitor.c.d.class;	 Catch:{ Exception -> 0x007a }
        r3 = 0;	 Catch:{ Exception -> 0x007a }
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x007a }
        r1 = r1.a(r2, r4);	 Catch:{ Exception -> 0x007a }
        r1 = (org.json.JSONArray) r1;	 Catch:{ Exception -> 0x007a }
        r2 = r8.d;	 Catch:{ Exception -> 0x007a }
        r2 = r2.entrySet();	 Catch:{ Exception -> 0x007a }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x007a }
    L_0x0030:
        r4 = r2.hasNext();	 Catch:{ Exception -> 0x007a }
        if (r4 == 0) goto L_0x0075;	 Catch:{ Exception -> 0x007a }
    L_0x0036:
        r4 = r2.next();	 Catch:{ Exception -> 0x007a }
        r4 = (java.util.Map.Entry) r4;	 Catch:{ Exception -> 0x007a }
        r5 = com.alibaba.mtl.appmonitor.c.a.a();	 Catch:{ Exception -> 0x007a }
        r6 = com.alibaba.mtl.appmonitor.c.e.class;	 Catch:{ Exception -> 0x007a }
        r7 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x007a }
        r5 = r5.a(r6, r7);	 Catch:{ Exception -> 0x007a }
        r5 = (org.json.JSONObject) r5;	 Catch:{ Exception -> 0x007a }
        r6 = r4.getKey();	 Catch:{ Exception -> 0x007a }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x007a }
        r7 = "errorCode";	 Catch:{ Exception -> 0x007a }
        r5.put(r7, r6);	 Catch:{ Exception -> 0x007a }
        r7 = "errorCount";	 Catch:{ Exception -> 0x007a }
        r4 = r4.getValue();	 Catch:{ Exception -> 0x007a }
        r5.put(r7, r4);	 Catch:{ Exception -> 0x007a }
        r4 = r8.c;	 Catch:{ Exception -> 0x007a }
        r4 = r4.containsKey(r6);	 Catch:{ Exception -> 0x007a }
        if (r4 == 0) goto L_0x0071;	 Catch:{ Exception -> 0x007a }
    L_0x0066:
        r4 = "errorMsg";	 Catch:{ Exception -> 0x007a }
        r7 = r8.c;	 Catch:{ Exception -> 0x007a }
        r6 = r7.get(r6);	 Catch:{ Exception -> 0x007a }
        r5.put(r4, r6);	 Catch:{ Exception -> 0x007a }
    L_0x0071:
        r1.put(r5);	 Catch:{ Exception -> 0x007a }
        goto L_0x0030;	 Catch:{ Exception -> 0x007a }
    L_0x0075:
        r2 = "errors";	 Catch:{ Exception -> 0x007a }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x007a }
    L_0x007a:
        monitor-exit(r8);
        return r0;
    L_0x007c:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.a.a.c():org.json.JSONObject");
    }

    public final synchronized void d() {
        super.d();
        this.a = 0;
        this.b = 0;
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }
}
