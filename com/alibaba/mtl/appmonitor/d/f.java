package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.log.e.i;
import java.util.Map;

/* compiled from: AlarmSampling */
public final class f extends g {
    String b = "AlarmSampling";
    private int e = 0;
    private int f = 0;

    public final /* bridge */ /* synthetic */ boolean a(int i, String str, String str2, Map map) {
        return super.a(i, str, str2, map);
    }

    public f(com.alibaba.mtl.appmonitor.a.f fVar, int i) {
        super(fVar, i);
        this.e = i;
        this.f = i;
    }

    public final boolean a(int i, String str, String str2, Boolean bool, Map<String, String> map) {
        String str3 = this.b;
        Object[] objArr = new Object[7];
        objArr[0] = "samplingSeed:";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = "isSuccess:";
        objArr[3] = bool;
        objArr[4] = "successSampling:";
        objArr[5] = Integer.valueOf(this.e);
        StringBuilder stringBuilder = new StringBuilder("failSampling:");
        stringBuilder.append(this.f);
        objArr[6] = stringBuilder.toString();
        i.a(str3, objArr);
        if (this.c != null) {
            h hVar = (h) this.c.get(str);
            if (hVar != null && (hVar instanceof d)) {
                return ((d) hVar).a(i, str2, bool, map);
            }
        }
        return bool.booleanValue() != null ? i < this.e : i < this.f;
    }

    public final void b(org.json.JSONObject r6) {
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
        r0 = "metrics";	 Catch:{ Exception -> 0x0045 }
        r6 = r6.getJSONArray(r0);	 Catch:{ Exception -> 0x0045 }
        if (r6 == 0) goto L_0x0044;	 Catch:{ Exception -> 0x0045 }
    L_0x0013:
        r0 = 0;	 Catch:{ Exception -> 0x0045 }
    L_0x0014:
        r1 = r6.length();	 Catch:{ Exception -> 0x0045 }
        if (r0 >= r1) goto L_0x0044;	 Catch:{ Exception -> 0x0045 }
    L_0x001a:
        r1 = r6.getJSONObject(r0);	 Catch:{ Exception -> 0x0045 }
        r2 = "module";	 Catch:{ Exception -> 0x0045 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x0045 }
        r3 = com.alibaba.mtl.appmonitor.f.b.a(r2);	 Catch:{ Exception -> 0x0045 }
        if (r3 == 0) goto L_0x0041;	 Catch:{ Exception -> 0x0045 }
    L_0x002a:
        r3 = r5.c;	 Catch:{ Exception -> 0x0045 }
        r3 = r3.get(r2);	 Catch:{ Exception -> 0x0045 }
        r3 = (com.alibaba.mtl.appmonitor.d.h) r3;	 Catch:{ Exception -> 0x0045 }
        if (r3 != 0) goto L_0x003e;	 Catch:{ Exception -> 0x0045 }
    L_0x0034:
        r3 = new com.alibaba.mtl.appmonitor.d.d;	 Catch:{ Exception -> 0x0045 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0045 }
        r4 = r5.c;	 Catch:{ Exception -> 0x0045 }
        r4.put(r2, r3);	 Catch:{ Exception -> 0x0045 }
    L_0x003e:
        r3.b(r1);	 Catch:{ Exception -> 0x0045 }
    L_0x0041:
        r0 = r0 + 1;
        goto L_0x0014;
    L_0x0044:
        return;
    L_0x0045:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.d.f.b(org.json.JSONObject):void");
    }

    protected final void a(org.json.JSONObject r2) {
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
        r1 = this;
        super.a(r2);
        r0 = r1.a;
        r1.e = r0;
        r0 = r1.a;
        r1.f = r0;
        r0 = "successSampling";	 Catch:{ Exception -> 0x0030 }
        r0 = r2.getInt(r0);	 Catch:{ Exception -> 0x0030 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0030 }
        if (r0 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x0030 }
    L_0x0017:
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0030 }
        r1.e = r0;	 Catch:{ Exception -> 0x0030 }
    L_0x001d:
        r0 = "failSampling";	 Catch:{ Exception -> 0x0030 }
        r2 = r2.getInt(r0);	 Catch:{ Exception -> 0x0030 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0030 }
        if (r2 == 0) goto L_0x002f;	 Catch:{ Exception -> 0x0030 }
    L_0x0029:
        r2 = r2.intValue();	 Catch:{ Exception -> 0x0030 }
        r1.f = r2;	 Catch:{ Exception -> 0x0030 }
    L_0x002f:
        return;
    L_0x0030:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.d.f.a(org.json.JSONObject):void");
    }

    public final void b(int i) {
        super.b(i);
        this.e = i;
        this.f = i;
    }
}
