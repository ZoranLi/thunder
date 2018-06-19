package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.f.c;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.appmonitor.model.i;
import com.alibaba.mtl.appmonitor.model.j;
import com.alibaba.mtl.appmonitor.model.k;
import com.alibaba.mtl.log.e.r;
import com.alibaba.mtl.log.model.LogField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: EventRepo */
public final class e {
    private static e d;
    public Map<String, c> a = new ConcurrentHashMap();
    public AtomicInteger b = new AtomicInteger(0);
    private Map<UTDimensionValueSet, k> c = new ConcurrentHashMap();
    private AtomicInteger e = new AtomicInteger(0);
    private AtomicInteger f = new AtomicInteger(0);

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (d == null) {
                d = new e();
            }
            eVar = d;
        }
        return eVar;
    }

    private e() {
    }

    public static UTDimensionValueSet a(int i) {
        UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) a.a().a(UTDimensionValueSet.class, new Object[0]);
        uTDimensionValueSet.a(LogField.ACCESS.toString(), com.alibaba.mtl.log.a.e());
        uTDimensionValueSet.a(LogField.ACCESS_SUBTYPE.toString(), com.alibaba.mtl.log.a.f());
        uTDimensionValueSet.a(LogField.USERID.toString(), com.alibaba.mtl.log.a.g());
        uTDimensionValueSet.a(LogField.USERNICK.toString(), com.alibaba.mtl.log.a.h());
        uTDimensionValueSet.a(LogField.EVENTID.toString(), String.valueOf(i));
        return uTDimensionValueSet;
    }

    public final void a(int i, String str, String str2, String str3, double d) {
        UTDimensionValueSet a = a(i);
        ((b) a(a, str, str2, str3, b.class)).a(d);
        if (com.alibaba.mtl.log.a.a.a()) {
            b bVar = (b) a.a().a(b.class, Integer.valueOf(i), str, str2, str3);
            bVar.a(d);
            c.a(a, bVar);
        }
        a(f.a(i), this.e);
    }

    public final void a(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet) {
        e eVar = this;
        String str3 = str;
        String str4 = str2;
        MeasureValueSet measureValueSet2 = measureValueSet;
        DimensionValueSet dimensionValueSet2 = dimensionValueSet;
        i a = j.a().a(str3, str4);
        if (a != null) {
            if (a.c != null) {
                a.c.a(dimensionValueSet2);
            }
            if (a.d != null) {
                MeasureSet measureSet = a.d;
                if (!(measureSet.a == null || measureValueSet2 == null)) {
                    for (Measure measure : measureSet.a) {
                        if (measure.c() != null && measureValueSet2.a(measure.b()) == null) {
                            measureValueSet2.a(measure.b(), measure.c().doubleValue());
                        }
                    }
                }
            }
            UTDimensionValueSet a2 = a(i);
            ((h) a(a2, str3, str4, null, h.class)).a(dimensionValueSet2, measureValueSet2);
            if (com.alibaba.mtl.log.a.a.a()) {
                h hVar = (h) a.a().a(h.class, Integer.valueOf(i), str3, str4);
                hVar.a(dimensionValueSet2, measureValueSet2);
                c.a(a2, hVar);
            }
            a(f.a(i), eVar.f);
            return;
        }
        com.alibaba.mtl.log.e.i.b("EventRepo", "metric is null");
    }

    public final void a(String str, Integer num, String str2, String str3, String str4) {
        i a = j.a().a(str2, str3);
        if (a != null && a.d != null) {
            for (Measure measure : a.d.a) {
                if (measure.b().equals(str4)) {
                    break;
                }
            }
            Measure measure2 = null;
            if (measure2 != null) {
                c cVar;
                synchronized (c.class) {
                    cVar = (c) this.a.get(str);
                    if (cVar == null) {
                        cVar = (c) a.a().a(c.class, num, str2, str3);
                        this.a.put(str, cVar);
                    }
                }
                str = System.currentTimeMillis();
                if (cVar.d.isEmpty() != null) {
                    cVar.e = Long.valueOf(str);
                }
                cVar.d.put(str4, (MeasureValue) a.a().a(MeasureValue.class, Double.valueOf((double) str), Double.valueOf((double) (str - cVar.e.longValue()))));
            }
        }
    }

    public final void a(String str, String str2, boolean z) {
        b bVar = (c) this.a.get(str);
        if (bVar != null) {
            MeasureValue measureValue = (MeasureValue) bVar.d.get(str2);
            int i = 0;
            if (measureValue != null) {
                long currentTimeMillis = System.currentTimeMillis();
                Object[] objArr = new Object[8];
                objArr[0] = "statEvent consumeTime. module:";
                objArr[1] = bVar.f;
                objArr[2] = " monitorPoint:";
                objArr[3] = bVar.g;
                objArr[4] = " measureName:";
                objArr[5] = str2;
                objArr[6] = " time:";
                double d = (double) currentTimeMillis;
                objArr[7] = Double.valueOf(d - measureValue.c);
                com.alibaba.mtl.log.e.i.a("DurationEvent", objArr);
                measureValue.c = d - measureValue.c;
                measureValue.a = true;
                bVar.b.a(str2, measureValue);
                if (bVar.a.d.a(bVar.b) != null) {
                    i = 1;
                }
            }
            if (i != 0) {
                this.a.remove(str);
                if (z) {
                    str = j.a().a(bVar.f, bVar.g);
                    if (str != null) {
                        str.e = null;
                    }
                }
                a(bVar.i, bVar.f, bVar.g, bVar.b, bVar.c);
                a.a().a(bVar);
            }
        }
    }

    public static String a(String str, String str2) {
        str = j.a().a(str, str2);
        return str != null ? str.a() : null;
    }

    public final d a(UTDimensionValueSet uTDimensionValueSet, String str, String str2, String str3, Class<? extends d> cls) {
        if (com.alibaba.mtl.appmonitor.f.b.a(str) && com.alibaba.mtl.appmonitor.f.b.a(str2)) {
            Integer c = uTDimensionValueSet.c();
            if (c != null) {
                k kVar;
                synchronized (this.c) {
                    kVar = (k) this.c.get(uTDimensionValueSet);
                    if (kVar == null) {
                        kVar = (k) a.a().a(k.class, new Object[0]);
                        this.c.put(uTDimensionValueSet, kVar);
                    }
                }
                return kVar.a(c, str, str2, str3, cls);
            }
        }
        return null;
    }

    public final void a(f fVar, AtomicInteger atomicInteger) {
        com.alibaba.mtl.log.e.i.a("EventRepo", fVar.toString(), " EVENT size:", String.valueOf(atomicInteger.incrementAndGet()));
        if (atomicInteger.incrementAndGet() >= fVar.b()) {
            com.alibaba.mtl.log.e.i.a("EventRepo", fVar.toString(), " event size exceed trigger count.");
            atomicInteger.set(0);
            b(fVar.a());
        }
    }

    private Map<UTDimensionValueSet, List<d>> c(int i) {
        Map<UTDimensionValueSet, List<d>> hashMap = new HashMap();
        synchronized (this.c) {
            List arrayList = new ArrayList(this.c.keySet());
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) arrayList.get(i2);
                if (uTDimensionValueSet != null && uTDimensionValueSet.c().intValue() == i) {
                    hashMap.put(uTDimensionValueSet, new ArrayList(((k) this.c.get(uTDimensionValueSet)).a.values()));
                    this.c.remove(uTDimensionValueSet);
                }
            }
        }
        return hashMap;
    }

    public final void b(int i) {
        i = c(i);
        r.a();
        r.a(new g(this, i));
    }
}
