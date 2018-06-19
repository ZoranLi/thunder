package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.appmonitor.a.d;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MetricValueSet */
public class k implements b {
    public Map<i, d> a = Collections.synchronizedMap(new HashMap());

    public final d a(Integer num, String str, String str2, String str3, Class<? extends d> cls) {
        b a;
        int i;
        if (num.intValue() == f.STAT.a()) {
            a = j.a().a(str, str2);
            i = 0;
        } else {
            a = (i) a.a().a(i.class, str, str2, str3);
            i = 1;
        }
        d dVar = null;
        if (a != null) {
            if (this.a.containsKey(a)) {
                dVar = (d) this.a.get(a);
            } else {
                d dVar2;
                synchronized (k.class) {
                    dVar2 = (d) a.a().a(cls, num, str, str2, str3);
                    this.a.put(a, dVar2);
                }
                dVar = dVar2;
                i = 0;
            }
            if (i != 0) {
                a.a().a(a);
            }
        }
        return dVar;
    }

    public final void d() {
        for (b a : this.a.values()) {
            a.a().a(a);
        }
        this.a.clear();
    }

    public final void a(Object... objArr) {
        if (this.a == null) {
            this.a = Collections.synchronizedMap(new HashMap());
        }
    }
}
