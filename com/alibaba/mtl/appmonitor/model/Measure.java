package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Measure implements Parcelable {
    public static final Creator<Measure> CREATOR = new e();
    protected Double a;
    protected Double b;
    protected String c;
    protected Double d;

    public int describeContents() {
        return 0;
    }

    public Measure(String str) {
        this(str, Double.valueOf(0.0d));
    }

    private Measure(String str, Double d) {
        this(str, d, Double.valueOf(0.0d), null);
    }

    public Measure(String str, Double d, Double d2, Double d3) {
        double d4 = 0.0d;
        this.a = Double.valueOf(0.0d);
        this.b = Double.valueOf(0.0d);
        this.d = Double.valueOf(0.0d);
        this.a = d2;
        this.b = d3;
        this.c = str;
        if (d != null) {
            d4 = d.doubleValue();
        }
        this.d = Double.valueOf(d4);
    }

    public final Double a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final Double c() {
        return this.d;
    }

    public int hashCode() {
        return 31 + (this.c == null ? 0 : this.c.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Measure measure = (Measure) obj;
        if (this.c == null) {
            if (measure.c != null) {
                return false;
            }
        } else if (this.c.equals(measure.c) == null) {
            return false;
        }
        return true;
    }

    public void writeToParcel(android.os.Parcel r5, int r6) {
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
        r6 = r4.b;	 Catch:{ Throwable -> 0x004b }
        r0 = 1;	 Catch:{ Throwable -> 0x004b }
        r1 = 0;	 Catch:{ Throwable -> 0x004b }
        if (r6 != 0) goto L_0x0008;	 Catch:{ Throwable -> 0x004b }
    L_0x0006:
        r6 = r1;	 Catch:{ Throwable -> 0x004b }
        goto L_0x0009;	 Catch:{ Throwable -> 0x004b }
    L_0x0008:
        r6 = r0;	 Catch:{ Throwable -> 0x004b }
    L_0x0009:
        r5.writeInt(r6);	 Catch:{ Throwable -> 0x004b }
        r6 = r4.b;	 Catch:{ Throwable -> 0x004b }
        if (r6 == 0) goto L_0x0019;	 Catch:{ Throwable -> 0x004b }
    L_0x0010:
        r6 = r4.b;	 Catch:{ Throwable -> 0x004b }
        r2 = r6.doubleValue();	 Catch:{ Throwable -> 0x004b }
        r5.writeDouble(r2);	 Catch:{ Throwable -> 0x004b }
    L_0x0019:
        r6 = r4.a;	 Catch:{ Throwable -> 0x004b }
        if (r6 != 0) goto L_0x001f;	 Catch:{ Throwable -> 0x004b }
    L_0x001d:
        r6 = r1;	 Catch:{ Throwable -> 0x004b }
        goto L_0x0020;	 Catch:{ Throwable -> 0x004b }
    L_0x001f:
        r6 = r0;	 Catch:{ Throwable -> 0x004b }
    L_0x0020:
        r5.writeInt(r6);	 Catch:{ Throwable -> 0x004b }
        r6 = r4.a;	 Catch:{ Throwable -> 0x004b }
        if (r6 == 0) goto L_0x0030;	 Catch:{ Throwable -> 0x004b }
    L_0x0027:
        r6 = r4.a;	 Catch:{ Throwable -> 0x004b }
        r2 = r6.doubleValue();	 Catch:{ Throwable -> 0x004b }
        r5.writeDouble(r2);	 Catch:{ Throwable -> 0x004b }
    L_0x0030:
        r6 = r4.c;	 Catch:{ Throwable -> 0x004b }
        r5.writeString(r6);	 Catch:{ Throwable -> 0x004b }
        r6 = r4.d;	 Catch:{ Throwable -> 0x004b }
        if (r6 != 0) goto L_0x003a;	 Catch:{ Throwable -> 0x004b }
    L_0x0039:
        r0 = r1;	 Catch:{ Throwable -> 0x004b }
    L_0x003a:
        r5.writeInt(r0);	 Catch:{ Throwable -> 0x004b }
        r6 = r4.d;	 Catch:{ Throwable -> 0x004b }
        if (r6 == 0) goto L_0x004a;	 Catch:{ Throwable -> 0x004b }
    L_0x0041:
        r6 = r4.d;	 Catch:{ Throwable -> 0x004b }
        r0 = r6.doubleValue();	 Catch:{ Throwable -> 0x004b }
        r5.writeDouble(r0);	 Catch:{ Throwable -> 0x004b }
    L_0x004a:
        return;
    L_0x004b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.model.Measure.writeToParcel(android.os.Parcel, int):void");
    }

    static Measure a(Parcel parcel) {
        try {
            Object obj = null;
            Double valueOf = (parcel.readInt() == 0 ? 1 : null) == null ? Double.valueOf(parcel.readDouble()) : null;
            Double valueOf2 = (parcel.readInt() == 0 ? 1 : null) == null ? Double.valueOf(parcel.readDouble()) : null;
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                obj = 1;
            }
            return new Measure(readString, obj == null ? Double.valueOf(parcel.readDouble()) : null, valueOf2, valueOf);
        } catch (Parcel parcel2) {
            parcel2.printStackTrace();
            return null;
        }
    }

    public final boolean a(MeasureValue measureValue) {
        measureValue = Double.valueOf(measureValue.c);
        return (measureValue == null || ((this.a != null && measureValue.doubleValue() < this.a.doubleValue()) || (this.b != null && measureValue.doubleValue() > this.b.doubleValue()))) ? null : true;
    }
}
