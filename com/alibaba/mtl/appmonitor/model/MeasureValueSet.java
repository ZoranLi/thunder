package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeasureValueSet implements Parcelable, b {
    public static final Creator<MeasureValueSet> CREATOR = new h();
    public Map<String, MeasureValue> a = new LinkedHashMap();

    public int describeContents() {
        return 0;
    }

    public static MeasureValueSet a() {
        return (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
    }

    public final MeasureValueSet a(String str, double d) {
        this.a.put(str, a.a().a(MeasureValue.class, Double.valueOf(d)));
        return this;
    }

    public final void a(String str, MeasureValue measureValue) {
        this.a.put(str, measureValue);
    }

    public final MeasureValue a(String str) {
        return (MeasureValue) this.a.get(str);
    }

    public final void d() {
        for (b a : this.a.values()) {
            a.a().a(a);
        }
        this.a.clear();
    }

    public final void a(Object... objArr) {
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.a);
    }

    static com.alibaba.mtl.appmonitor.model.MeasureValueSet a(android.os.Parcel r2) {
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
        r0 = a();	 Catch:{ Throwable -> 0x0011 }
        r1 = com.alibaba.mtl.appmonitor.model.DimensionValueSet.class;	 Catch:{ Throwable -> 0x0012 }
        r1 = r1.getClassLoader();	 Catch:{ Throwable -> 0x0012 }
        r2 = r2.readHashMap(r1);	 Catch:{ Throwable -> 0x0012 }
        r0.a = r2;	 Catch:{ Throwable -> 0x0012 }
        goto L_0x0012;
    L_0x0011:
        r0 = 0;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.model.MeasureValueSet.a(android.os.Parcel):com.alibaba.mtl.appmonitor.model.MeasureValueSet");
    }
}
