package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.log.e.i;

/* compiled from: AppMonitor */
final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ MeasureSet c;
    final /* synthetic */ DimensionSet d;
    final /* synthetic */ boolean e;

    k(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = measureSet;
        this.d = dimensionSet;
        this.e = z;
    }

    public final void run() {
        try {
            i.a("AppMonitor", "register stat event. module: ", this.a, " monitorPoint: ", this.b);
            AppMonitor.a.a(this.a, this.b, this.c, this.d, this.e);
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
