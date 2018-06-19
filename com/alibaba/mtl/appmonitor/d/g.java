package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.appmonitor.a.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: EventTypeSampling */
public class g extends a<JSONObject> {
    private f b;
    protected Map<String, h> c;
    protected int d = -1;

    public g(f fVar, int i) {
        super(i);
        this.b = fVar;
        this.c = Collections.synchronizedMap(new HashMap());
    }

    public boolean a(int i, String str, String str2, Map<String, String> map) {
        if (this.c != null) {
            h hVar = (h) this.c.get(str);
            if (hVar != null) {
                return hVar.a(i, str2, map);
            }
        }
        return i < this.a;
    }

    public void b(org.json.JSONObject r6) {
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
        r5 = this;
        r5.a(r6);
        r5.c(r6);
        r0 = r5.c;
        r0.clear();
        r0 = "metrics";	 Catch:{ Exception -> 0x0047 }
        r6 = r6.optJSONArray(r0);	 Catch:{ Exception -> 0x0047 }
        if (r6 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x0047 }
    L_0x0013:
        r0 = 0;	 Catch:{ Exception -> 0x0047 }
    L_0x0014:
        r1 = r6.length();	 Catch:{ Exception -> 0x0047 }
        if (r0 >= r1) goto L_0x0046;	 Catch:{ Exception -> 0x0047 }
    L_0x001a:
        r1 = r6.getJSONObject(r0);	 Catch:{ Exception -> 0x0047 }
        r2 = "module";	 Catch:{ Exception -> 0x0047 }
        r2 = r1.optString(r2);	 Catch:{ Exception -> 0x0047 }
        r3 = com.alibaba.mtl.appmonitor.f.b.a(r2);	 Catch:{ Exception -> 0x0047 }
        if (r3 == 0) goto L_0x0043;	 Catch:{ Exception -> 0x0047 }
    L_0x002a:
        r3 = r5.c;	 Catch:{ Exception -> 0x0047 }
        r3 = r3.get(r2);	 Catch:{ Exception -> 0x0047 }
        r3 = (com.alibaba.mtl.appmonitor.d.h) r3;	 Catch:{ Exception -> 0x0047 }
        if (r3 != 0) goto L_0x0040;	 Catch:{ Exception -> 0x0047 }
    L_0x0034:
        r3 = new com.alibaba.mtl.appmonitor.d.h;	 Catch:{ Exception -> 0x0047 }
        r4 = r5.a;	 Catch:{ Exception -> 0x0047 }
        r3.<init>(r2, r4);	 Catch:{ Exception -> 0x0047 }
        r4 = r5.c;	 Catch:{ Exception -> 0x0047 }
        r4.put(r2, r3);	 Catch:{ Exception -> 0x0047 }
    L_0x0040:
        r3.b(r1);	 Catch:{ Exception -> 0x0047 }
    L_0x0043:
        r0 = r0 + 1;
        goto L_0x0014;
    L_0x0046:
        return;
    L_0x0047:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.d.g.b(org.json.JSONObject):void");
    }

    protected final void c(org.json.JSONObject r5) {
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
        r4 = this;
        r0 = "EventTypeSampling";
        r1 = 3;
        r1 = new java.lang.Object[r1];
        r2 = "[updateEventTypeTriggerCount]";
        r3 = 0;
        r1[r3] = r2;
        r2 = 1;
        r1[r2] = r4;
        r2 = 2;
        r1[r2] = r5;
        com.alibaba.mtl.log.e.i.a(r0, r1);
        if (r5 != 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r0 = "cacheCount";	 Catch:{ Throwable -> 0x0028 }
        r5 = r5.optInt(r0);	 Catch:{ Throwable -> 0x0028 }
        if (r5 <= 0) goto L_0x0027;	 Catch:{ Throwable -> 0x0028 }
    L_0x001e:
        r0 = r4.b;	 Catch:{ Throwable -> 0x0028 }
        if (r0 == 0) goto L_0x0027;	 Catch:{ Throwable -> 0x0028 }
    L_0x0022:
        r0 = r4.b;	 Catch:{ Throwable -> 0x0028 }
        r0.b(r5);	 Catch:{ Throwable -> 0x0028 }
    L_0x0027:
        return;
    L_0x0028:
        r5 = "EventTypeSampling";
        r0 = "updateTriggerCount";
        com.alibaba.mtl.log.e.i.a(r5, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.d.g.c(org.json.JSONObject):void");
    }

    public void b(int i) {
        this.a = i;
    }
}
