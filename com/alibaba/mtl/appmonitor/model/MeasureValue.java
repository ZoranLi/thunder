package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;

public class MeasureValue implements Parcelable, b {
    public static final Creator<MeasureValue> CREATOR = new g();
    public boolean a;
    public Double b;
    public double c;

    public int describeContents() {
        return 0;
    }

    public final synchronized void a(com.alibaba.mtl.appmonitor.model.MeasureValue r5) {
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
        monitor-enter(r4);
        if (r5 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r4);
        return;
    L_0x0005:
        r0 = r4.c;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r2 = r5.c;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r0 = r0 + r2;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r4.c = r0;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r0 = r5.b;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        if (r0 == 0) goto L_0x002f;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
    L_0x0010:
        r0 = r4.b;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        if (r0 != 0) goto L_0x001c;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
    L_0x0014:
        r0 = 0;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r0 = java.lang.Double.valueOf(r0);	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r4.b = r0;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
    L_0x001c:
        r0 = r4.b;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r0 = r0.doubleValue();	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r5 = r5.b;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r2 = r5.doubleValue();	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r0 = r0 + r2;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r5 = java.lang.Double.valueOf(r0);	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r4.b = r5;	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
    L_0x002f:
        monitor-exit(r4);
        return;
    L_0x0031:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
    L_0x0034:
        monitor-exit(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.model.MeasureValue.a(com.alibaba.mtl.appmonitor.model.MeasureValue):void");
    }

    public final synchronized void d() {
        this.c = 0.0d;
        this.b = null;
        this.a = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.Object... r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        if (r5 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r4);
        return;
    L_0x0005:
        r0 = r5.length;	 Catch:{ all -> 0x0021 }
        r1 = 0;
        if (r0 <= 0) goto L_0x0013;
    L_0x0009:
        r0 = r5[r1];	 Catch:{ all -> 0x0021 }
        r0 = (java.lang.Double) r0;	 Catch:{ all -> 0x0021 }
        r2 = r0.doubleValue();	 Catch:{ all -> 0x0021 }
        r4.c = r2;	 Catch:{ all -> 0x0021 }
    L_0x0013:
        r0 = r5.length;	 Catch:{ all -> 0x0021 }
        r2 = 1;
        if (r0 <= r2) goto L_0x001f;
    L_0x0017:
        r5 = r5[r2];	 Catch:{ all -> 0x0021 }
        r5 = (java.lang.Double) r5;	 Catch:{ all -> 0x0021 }
        r4.b = r5;	 Catch:{ all -> 0x0021 }
        r4.a = r1;	 Catch:{ all -> 0x0021 }
    L_0x001f:
        monitor-exit(r4);
        return;
    L_0x0021:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.model.MeasureValue.a(java.lang.Object[]):void");
    }

    public void writeToParcel(android.os.Parcel r3, int r4) {
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
        r4 = r2.a;	 Catch:{ Throwable -> 0x001b }
        r3.writeInt(r4);	 Catch:{ Throwable -> 0x001b }
        r4 = r2.b;	 Catch:{ Throwable -> 0x001b }
        if (r4 != 0) goto L_0x000c;	 Catch:{ Throwable -> 0x001b }
    L_0x0009:
        r0 = 0;	 Catch:{ Throwable -> 0x001b }
        goto L_0x0012;	 Catch:{ Throwable -> 0x001b }
    L_0x000c:
        r4 = r2.b;	 Catch:{ Throwable -> 0x001b }
        r0 = r4.doubleValue();	 Catch:{ Throwable -> 0x001b }
    L_0x0012:
        r3.writeDouble(r0);	 Catch:{ Throwable -> 0x001b }
        r0 = r2.c;	 Catch:{ Throwable -> 0x001b }
        r3.writeDouble(r0);	 Catch:{ Throwable -> 0x001b }
        return;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.model.MeasureValue.writeToParcel(android.os.Parcel, int):void");
    }

    static MeasureValue a(Parcel parcel) {
        MeasureValue measureValue = null;
        try {
            boolean z = parcel.readInt() != 0;
            Double valueOf = Double.valueOf(parcel.readDouble());
            double readDouble = parcel.readDouble();
            MeasureValue measureValue2 = (MeasureValue) a.a().a(MeasureValue.class, new Object[0]);
            try {
                measureValue2.a = z;
                measureValue2.b = valueOf;
                measureValue2.c = readDouble;
                return measureValue2;
            } catch (Throwable th) {
                Throwable th2 = th;
                measureValue = measureValue2;
                parcel = th2;
                parcel.printStackTrace();
                return measureValue;
            }
        } catch (Throwable th3) {
            parcel = th3;
            parcel.printStackTrace();
            return measureValue;
        }
    }
}
