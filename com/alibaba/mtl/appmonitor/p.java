package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

/* compiled from: AppMonitor */
final class p implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ DimensionValueSet c;
    final /* synthetic */ MeasureValueSet d;

    p(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        this.a = str;
        this.b = str2;
        this.c = dimensionValueSet;
        this.d = measureValueSet;
    }

    public final void run() {
        try {
            AppMonitor.a.a(this.a, this.b, this.c, this.d);
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
