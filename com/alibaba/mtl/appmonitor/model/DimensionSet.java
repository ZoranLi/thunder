package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class DimensionSet implements Parcelable {
    public static final Creator<DimensionSet> CREATOR = new c();
    public List<Dimension> a = new ArrayList(3);

    public int describeContents() {
        return 0;
    }

    public static DimensionSet a() {
        return new DimensionSet();
    }

    private DimensionSet() {
    }

    public final DimensionSet a(String str) {
        Dimension dimension = new Dimension(str);
        if (this.a.contains(dimension) != null) {
            return this;
        }
        this.a.add(dimension);
        return this;
    }

    public final void a(DimensionValueSet dimensionValueSet) {
        if (this.a != null && dimensionValueSet != null) {
            for (Dimension dimension : this.a) {
                if (dimension.b() != null && dimensionValueSet.b(dimension.a()) == null) {
                    dimensionValueSet.a(dimension.a(), dimension.b());
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.a != null) {
            try {
                Object[] toArray = this.a.toArray();
                Parcelable[] parcelableArr = null;
                if (toArray != null) {
                    parcelableArr = new Dimension[toArray.length];
                    for (int i2 = 0; i2 < toArray.length; i2++) {
                        parcelableArr[i2] = (Dimension) toArray[i2];
                    }
                }
                parcel.writeParcelableArray(parcelableArr, i);
            } catch (Parcel parcel2) {
                parcel2.printStackTrace();
            }
        }
    }

    static com.alibaba.mtl.appmonitor.model.DimensionSet a(android.os.Parcel r7) {
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
        r0 = new com.alibaba.mtl.appmonitor.model.DimensionSet;
        r0.<init>();
        r1 = com.alibaba.mtl.appmonitor.model.DimensionSet.class;	 Catch:{ Throwable -> 0x0049 }
        r1 = r1.getClassLoader();	 Catch:{ Throwable -> 0x0049 }
        r7 = r7.readParcelableArray(r1);	 Catch:{ Throwable -> 0x0049 }
        if (r7 == 0) goto L_0x0050;	 Catch:{ Throwable -> 0x0049 }
    L_0x0011:
        r1 = r0.a;	 Catch:{ Throwable -> 0x0049 }
        if (r1 != 0) goto L_0x001c;	 Catch:{ Throwable -> 0x0049 }
    L_0x0015:
        r1 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0049 }
        r1.<init>();	 Catch:{ Throwable -> 0x0049 }
        r0.a = r1;	 Catch:{ Throwable -> 0x0049 }
    L_0x001c:
        r1 = 0;	 Catch:{ Throwable -> 0x0049 }
        r2 = r1;	 Catch:{ Throwable -> 0x0049 }
    L_0x001e:
        r3 = r7.length;	 Catch:{ Throwable -> 0x0049 }
        if (r2 >= r3) goto L_0x0050;	 Catch:{ Throwable -> 0x0049 }
    L_0x0021:
        r3 = r7[r2];	 Catch:{ Throwable -> 0x0049 }
        if (r3 == 0) goto L_0x0035;	 Catch:{ Throwable -> 0x0049 }
    L_0x0025:
        r3 = r7[r2];	 Catch:{ Throwable -> 0x0049 }
        r3 = r3 instanceof com.alibaba.mtl.appmonitor.model.Dimension;	 Catch:{ Throwable -> 0x0049 }
        if (r3 == 0) goto L_0x0035;	 Catch:{ Throwable -> 0x0049 }
    L_0x002b:
        r3 = r0.a;	 Catch:{ Throwable -> 0x0049 }
        r4 = r7[r2];	 Catch:{ Throwable -> 0x0049 }
        r4 = (com.alibaba.mtl.appmonitor.model.Dimension) r4;	 Catch:{ Throwable -> 0x0049 }
        r3.add(r4);	 Catch:{ Throwable -> 0x0049 }
        goto L_0x0046;	 Catch:{ Throwable -> 0x0049 }
    L_0x0035:
        r3 = "DimensionSet";	 Catch:{ Throwable -> 0x0049 }
        r4 = 2;	 Catch:{ Throwable -> 0x0049 }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0049 }
        r5 = "parcelables[i]:";	 Catch:{ Throwable -> 0x0049 }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x0049 }
        r5 = r7[r2];	 Catch:{ Throwable -> 0x0049 }
        r6 = 1;	 Catch:{ Throwable -> 0x0049 }
        r4[r6] = r5;	 Catch:{ Throwable -> 0x0049 }
        com.alibaba.mtl.log.e.i.a(r3, r4);	 Catch:{ Throwable -> 0x0049 }
    L_0x0046:
        r2 = r2 + 1;
        goto L_0x001e;
    L_0x0049:
        r7 = "DimensionSet";
        r1 = "[readFromParcel]";
        com.alibaba.mtl.log.e.i.a(r7, r1);
    L_0x0050:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.model.DimensionSet.a(android.os.Parcel):com.alibaba.mtl.appmonitor.model.DimensionSet");
    }
}
