package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.log.model.LogField;
import java.util.HashSet;
import java.util.Set;

public class UTDimensionValueSet extends DimensionValueSet {
    private static final Set<LogField> b = new HashSet<LogField>() {
        {
            add(LogField.PAGE);
            add(LogField.ARG1);
            add(LogField.ARG2);
            add(LogField.ARG3);
            add(LogField.ARGS);
        }
    };

    public final java.lang.Integer c() {
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
        r2 = this;
        r0 = r2.a;
        if (r0 == 0) goto L_0x0019;
    L_0x0004:
        r0 = r2.a;
        r1 = com.alibaba.mtl.log.model.LogField.EVENTID;
        r1 = r1.toString();
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x0019;
    L_0x0014:
        r0 = com.alibaba.mtl.appmonitor.f.a.a(r0);	 Catch:{ NumberFormatException -> 0x0019 }
        goto L_0x001a;
    L_0x0019:
        r0 = 0;
    L_0x001a:
        r0 = java.lang.Integer.valueOf(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.model.UTDimensionValueSet.c():java.lang.Integer");
    }

    public final void d() {
        super.d();
    }

    public final void a(Object... objArr) {
        super.a(objArr);
    }
}
