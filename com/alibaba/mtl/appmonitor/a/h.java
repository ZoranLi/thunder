package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.model.Dimension;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.i;
import com.alibaba.mtl.appmonitor.model.j;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: StatEvent */
public class h extends d {
    private i a;
    private Map<DimensionValueSet, a> b;

    /* compiled from: StatEvent */
    public class a {
        int a = 0;
        int b = 0;
        final /* synthetic */ h c;
        private List<MeasureValueSet> d = new ArrayList();

        public a(h hVar) {
            this.c = hVar;
        }

        public final void a(MeasureValueSet measureValueSet) {
            if (measureValueSet != null) {
                if (this.c.a != null && this.c.a.b()) {
                    this.d.add(b(measureValueSet));
                } else if (this.d.isEmpty()) {
                    this.d.add(b(measureValueSet));
                } else {
                    MeasureValueSet measureValueSet2 = (MeasureValueSet) this.d.get(0);
                    for (String str : measureValueSet2.a.keySet()) {
                        ((MeasureValue) measureValueSet2.a.get(str)).a(measureValueSet.a(str));
                    }
                }
            }
        }

        private MeasureValueSet b(MeasureValueSet measureValueSet) {
            MeasureValueSet measureValueSet2 = (MeasureValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0]);
            if (!(this.c.a == null || this.c.a.d == null)) {
                List list = this.c.a.d.a;
                if (list != null) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        Measure measure = (Measure) list.get(i);
                        if (measure != null) {
                            MeasureValue measureValue = (MeasureValue) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValue.class, new Object[0]);
                            MeasureValue a = measureValueSet.a(measure.b());
                            if (a.b != null) {
                                measureValue.b = Double.valueOf(a.b.doubleValue());
                            }
                            measureValue.c = a.c;
                            measureValueSet2.a(measure.b(), measureValue);
                        }
                    }
                }
            }
            return measureValueSet2;
        }

        public final List<Map<String, Map<String, Double>>> a() {
            if (this.d != null) {
                if (!this.d.isEmpty()) {
                    List<Map<String, Map<String, Double>>> arrayList = new ArrayList();
                    int size = this.d.size();
                    for (int i = 0; i < size; i++) {
                        MeasureValueSet measureValueSet = (MeasureValueSet) this.d.get(i);
                        if (measureValueSet != null) {
                            Map map = measureValueSet.a;
                            if (!(map == null || map.isEmpty())) {
                                Map hashMap = new HashMap();
                                for (Entry entry : map.entrySet()) {
                                    Map hashMap2 = new HashMap();
                                    String str = (String) entry.getKey();
                                    MeasureValue measureValue = (MeasureValue) entry.getValue();
                                    hashMap2.put(RequestHeaders.COLUMN_VALUE, Double.valueOf(measureValue.c));
                                    if (measureValue.b != null) {
                                        hashMap2.put("offset", measureValue.b);
                                    }
                                    hashMap.put(str, hashMap2);
                                }
                                arrayList.add(hashMap);
                            }
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        }
    }

    public final synchronized void a(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        a aVar;
        if (dimensionValueSet == null) {
            DimensionValueSet dimensionValueSet2 = (DimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(DimensionValueSet.class, new Object[0]);
            dimensionValueSet2.a(dimensionValueSet);
            dimensionValueSet = dimensionValueSet2;
        }
        if (this.b.containsKey(dimensionValueSet)) {
            aVar = (a) this.b.get(dimensionValueSet);
        } else {
            dimensionValueSet2 = (DimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(DimensionValueSet.class, new Object[0]);
            dimensionValueSet2.a(dimensionValueSet);
            a aVar2 = new a(this);
            this.b.put(dimensionValueSet2, aVar2);
            aVar = aVar2;
        }
        if (this.a != null) {
            j a;
            StringBuilder stringBuilder;
            String stringBuilder2;
            StringBuilder stringBuilder3;
            i a2;
            i iVar = this.a;
            if (iVar.c != null) {
                DimensionSet dimensionSet = iVar.c;
                if (dimensionSet.a != null) {
                    if (dimensionValueSet != null) {
                        for (Dimension a3 : dimensionSet.a) {
                            if (!dimensionValueSet.a(a3.a())) {
                            }
                        }
                    }
                    dimensionValueSet = null;
                    a = j.a();
                    stringBuilder = new StringBuilder("config_prefix");
                    stringBuilder.append(iVar.a);
                    stringBuilder2 = stringBuilder.toString();
                    stringBuilder3 = new StringBuilder("config_prefix");
                    stringBuilder3.append(iVar.b);
                    a2 = a.a(stringBuilder2, stringBuilder3.toString());
                    if (a2 != null || a2.d == null || measureValueSet == null || measureValueSet.a == null || iVar.d == null) {
                        if (iVar.d != null) {
                            if (!(dimensionValueSet == null || iVar.d.a(measureValueSet) == null)) {
                                dimensionValueSet = 1;
                            }
                        }
                        if (dimensionValueSet == null) {
                            aVar.a += 1;
                            aVar.a(measureValueSet);
                        } else {
                            aVar.b += 1;
                            if (this.a.b() != null) {
                                aVar.a(measureValueSet);
                            }
                        }
                        com.alibaba.mtl.log.e.i.a("StatEvent", "entity  count:", Integer.valueOf(aVar.a), " noise:", Integer.valueOf(aVar.b));
                    } else {
                        List list = a2.d.a;
                        for (String str : measureValueSet.a.keySet()) {
                            Measure a4 = i.a(str, list);
                            if (a4 == null) {
                                a4 = i.a(str, iVar.d.a);
                            }
                            if (a4 != null) {
                                if (!a4.a(measureValueSet.a(str))) {
                                }
                            }
                        }
                        if (dimensionValueSet == null) {
                            aVar.b += 1;
                            if (this.a.b() != null) {
                                aVar.a(measureValueSet);
                            }
                        } else {
                            aVar.a += 1;
                            aVar.a(measureValueSet);
                        }
                        com.alibaba.mtl.log.e.i.a("StatEvent", "entity  count:", Integer.valueOf(aVar.a), " noise:", Integer.valueOf(aVar.b));
                    }
                }
            }
            dimensionValueSet = 1;
            a = j.a();
            stringBuilder = new StringBuilder("config_prefix");
            stringBuilder.append(iVar.a);
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder("config_prefix");
            stringBuilder3.append(iVar.b);
            a2 = a.a(stringBuilder2, stringBuilder3.toString());
            if (a2 != null) {
            }
            if (iVar.d != null) {
                dimensionValueSet = 1;
            }
            if (dimensionValueSet == null) {
                aVar.a += 1;
                aVar.a(measureValueSet);
            } else {
                aVar.b += 1;
                if (this.a.b() != null) {
                    aVar.a(measureValueSet);
                }
            }
            com.alibaba.mtl.log.e.i.a("StatEvent", "entity  count:", Integer.valueOf(aVar.a), " noise:", Integer.valueOf(aVar.b));
        }
        dimensionValueSet = null;
        if (dimensionValueSet == null) {
            aVar.b += 1;
            if (this.a.b() != null) {
                aVar.a(measureValueSet);
            }
        } else {
            aVar.a += 1;
            aVar.a(measureValueSet);
        }
        com.alibaba.mtl.log.e.i.a("StatEvent", "entity  count:", Integer.valueOf(aVar.a), " noise:", Integer.valueOf(aVar.b));
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
        r14 = this;
        monitor-enter(r14);
        r0 = super.c();	 Catch:{ all -> 0x00e9 }
        r1 = r14.a;	 Catch:{ Exception -> 0x00e7 }
        if (r1 == 0) goto L_0x0018;	 Catch:{ Exception -> 0x00e7 }
    L_0x0009:
        r1 = "isCommitDetail";	 Catch:{ Exception -> 0x00e7 }
        r2 = r14.a;	 Catch:{ Exception -> 0x00e7 }
        r2 = r2.b();	 Catch:{ Exception -> 0x00e7 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x00e7 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00e7 }
    L_0x0018:
        r1 = com.alibaba.mtl.appmonitor.c.a.a();	 Catch:{ Exception -> 0x00e7 }
        r2 = com.alibaba.mtl.appmonitor.c.d.class;	 Catch:{ Exception -> 0x00e7 }
        r3 = 0;	 Catch:{ Exception -> 0x00e7 }
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e7 }
        r1 = r1.a(r2, r4);	 Catch:{ Exception -> 0x00e7 }
        r1 = (org.json.JSONArray) r1;	 Catch:{ Exception -> 0x00e7 }
        r2 = r14.b;	 Catch:{ Exception -> 0x00e7 }
        if (r2 == 0) goto L_0x00e2;	 Catch:{ Exception -> 0x00e7 }
    L_0x002b:
        r2 = r14.b;	 Catch:{ Exception -> 0x00e7 }
        r2 = r2.entrySet();	 Catch:{ Exception -> 0x00e7 }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x00e7 }
    L_0x0035:
        r4 = r2.hasNext();	 Catch:{ Exception -> 0x00e7 }
        if (r4 == 0) goto L_0x00e2;	 Catch:{ Exception -> 0x00e7 }
    L_0x003b:
        r4 = r2.next();	 Catch:{ Exception -> 0x00e7 }
        r4 = (java.util.Map.Entry) r4;	 Catch:{ Exception -> 0x00e7 }
        r5 = com.alibaba.mtl.appmonitor.c.a.a();	 Catch:{ Exception -> 0x00e7 }
        r6 = com.alibaba.mtl.appmonitor.c.e.class;	 Catch:{ Exception -> 0x00e7 }
        r7 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e7 }
        r5 = r5.a(r6, r7);	 Catch:{ Exception -> 0x00e7 }
        r5 = (org.json.JSONObject) r5;	 Catch:{ Exception -> 0x00e7 }
        r6 = r4.getKey();	 Catch:{ Exception -> 0x00e7 }
        r6 = (com.alibaba.mtl.appmonitor.model.DimensionValueSet) r6;	 Catch:{ Exception -> 0x00e7 }
        r4 = r4.getValue();	 Catch:{ Exception -> 0x00e7 }
        r4 = (com.alibaba.mtl.appmonitor.a.h.a) r4;	 Catch:{ Exception -> 0x00e7 }
        r7 = r4.a;	 Catch:{ Exception -> 0x00e7 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00e7 }
        r8 = r4.b;	 Catch:{ Exception -> 0x00e7 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x00e7 }
        r9 = "count";	 Catch:{ Exception -> 0x00e7 }
        r5.put(r9, r7);	 Catch:{ Exception -> 0x00e7 }
        r7 = "noise";	 Catch:{ Exception -> 0x00e7 }
        r5.put(r7, r8);	 Catch:{ Exception -> 0x00e7 }
        r7 = "dimensions";	 Catch:{ Exception -> 0x00e7 }
        if (r6 == 0) goto L_0x007f;	 Catch:{ Exception -> 0x00e7 }
    L_0x0075:
        r8 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00e7 }
        r6 = r6.b();	 Catch:{ Exception -> 0x00e7 }
        r8.<init>(r6);	 Catch:{ Exception -> 0x00e7 }
        goto L_0x0081;	 Catch:{ Exception -> 0x00e7 }
    L_0x007f:
        r8 = "";	 Catch:{ Exception -> 0x00e7 }
    L_0x0081:
        r5.put(r7, r8);	 Catch:{ Exception -> 0x00e7 }
        r4 = r4.a();	 Catch:{ Exception -> 0x00e7 }
        r6 = new org.json.JSONArray;	 Catch:{ Exception -> 0x00e7 }
        r6.<init>();	 Catch:{ Exception -> 0x00e7 }
        r7 = r3;	 Catch:{ Exception -> 0x00e7 }
    L_0x008e:
        r8 = r4.size();	 Catch:{ Exception -> 0x00e7 }
        if (r7 >= r8) goto L_0x00d8;	 Catch:{ Exception -> 0x00e7 }
    L_0x0094:
        r8 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00e7 }
        r8.<init>();	 Catch:{ Exception -> 0x00e7 }
        r9 = r4.get(r7);	 Catch:{ Exception -> 0x00e7 }
        r9 = (java.util.Map) r9;	 Catch:{ Exception -> 0x00e7 }
        if (r9 == 0) goto L_0x00d2;	 Catch:{ Exception -> 0x00e7 }
    L_0x00a1:
        r10 = r9.keySet();	 Catch:{ Exception -> 0x00e7 }
        if (r10 == 0) goto L_0x00d2;	 Catch:{ Exception -> 0x00e7 }
    L_0x00a7:
        r10 = r10.iterator();	 Catch:{ Exception -> 0x00e7 }
    L_0x00ab:
        r11 = r10.hasNext();	 Catch:{ Exception -> 0x00e7 }
        if (r11 == 0) goto L_0x00d2;	 Catch:{ Exception -> 0x00e7 }
    L_0x00b1:
        r11 = r10.next();	 Catch:{ Exception -> 0x00e7 }
        r11 = (java.lang.String) r11;	 Catch:{ Exception -> 0x00e7 }
        r12 = r9.get(r11);	 Catch:{ Exception -> 0x00e7 }
        if (r12 == 0) goto L_0x00cc;	 Catch:{ Exception -> 0x00e7 }
    L_0x00bd:
        r12 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00e7 }
        r13 = r9.get(r11);	 Catch:{ Exception -> 0x00e7 }
        r13 = (java.util.Map) r13;	 Catch:{ Exception -> 0x00e7 }
        r12.<init>(r13);	 Catch:{ Exception -> 0x00e7 }
        r8.put(r11, r12);	 Catch:{ Exception -> 0x00e7 }
        goto L_0x00ab;	 Catch:{ Exception -> 0x00e7 }
    L_0x00cc:
        r12 = "";	 Catch:{ Exception -> 0x00e7 }
        r8.put(r11, r12);	 Catch:{ Exception -> 0x00e7 }
        goto L_0x00ab;	 Catch:{ Exception -> 0x00e7 }
    L_0x00d2:
        r6.put(r8);	 Catch:{ Exception -> 0x00e7 }
        r7 = r7 + 1;	 Catch:{ Exception -> 0x00e7 }
        goto L_0x008e;	 Catch:{ Exception -> 0x00e7 }
    L_0x00d8:
        r4 = "measures";	 Catch:{ Exception -> 0x00e7 }
        r5.put(r4, r6);	 Catch:{ Exception -> 0x00e7 }
        r1.put(r5);	 Catch:{ Exception -> 0x00e7 }
        goto L_0x0035;	 Catch:{ Exception -> 0x00e7 }
    L_0x00e2:
        r2 = "values";	 Catch:{ Exception -> 0x00e7 }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x00e7 }
    L_0x00e7:
        monitor-exit(r14);
        return r0;
    L_0x00e9:
        r0 = move-exception;
        monitor-exit(r14);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.a.h.c():org.json.JSONObject");
    }

    public final synchronized void d() {
        super.d();
        this.a = null;
        for (b a : this.b.keySet()) {
            com.alibaba.mtl.appmonitor.c.a.a().a(a);
        }
        this.b.clear();
    }

    public final void a(Object... objArr) {
        super.a(objArr);
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.a = j.a().a(this.f, this.g);
    }
}
