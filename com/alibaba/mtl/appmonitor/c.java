package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.log.e.i;

/* compiled from: AppMonitor */
final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ MeasureSet c;
    final /* synthetic */ DimensionSet d;

    c(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        this.a = str;
        this.b = str2;
        this.c = measureSet;
        this.d = dimensionSet;
    }

    public final void run() {
        try {
            i.a("AppMonitor", "[register]:", AppMonitor.a);
            AppMonitor.a.a(this.a, this.b, this.c, this.d);
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
