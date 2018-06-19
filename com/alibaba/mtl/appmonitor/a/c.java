package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.i;
import com.alibaba.mtl.appmonitor.model.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DurationEvent */
public class c extends d {
    private static final Long j = Long.valueOf(300000);
    i a;
    MeasureValueSet b;
    public DimensionValueSet c;
    Map<String, MeasureValue> d;
    Long e;

    public final boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        List list = this.a.d.a;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Measure measure = (Measure) list.get(i);
                if (measure != null) {
                    double doubleValue = measure.a() != null ? measure.a().doubleValue() : (double) j.longValue();
                    MeasureValue measureValue = (MeasureValue) this.d.get(measure.b());
                    if (!(measureValue == null || measureValue.a || ((double) currentTimeMillis) - measureValue.c <= doubleValue)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void d() {
        super.d();
        this.a = null;
        this.e = null;
        for (b a : this.d.values()) {
            a.a().a(a);
        }
        this.d.clear();
        if (this.b != null) {
            a.a().a(this.b);
            this.b = null;
        }
        if (this.c != null) {
            a.a().a(this.c);
            this.c = null;
        }
    }

    public final void a(Object... objArr) {
        super.a(objArr);
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.a = j.a().a(this.f, this.g);
        if (this.a.c != null) {
            this.c = (DimensionValueSet) a.a().a(DimensionValueSet.class, new Object[0]);
            this.a.c.a(this.c);
        }
        this.b = (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
    }
}
