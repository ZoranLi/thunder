package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Dimension implements Parcelable {
    public static final Creator<Dimension> CREATOR = new b();
    protected String a;
    protected String b;

    public int describeContents() {
        return 0;
    }

    public Dimension() {
        this.b = "null";
    }

    public Dimension(String str) {
        this(str, null);
    }

    private Dimension(String str, String str2) {
        this.b = "null";
        this.a = str;
        if (str2 == null) {
            str2 = "null";
        }
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public int hashCode() {
        return 31 + (this.a == null ? 0 : this.a.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        if (this.a == null) {
            if (dimension.a != null) {
                return false;
            }
        } else if (this.a.equals(dimension.a) == null) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.a);
    }

    static com.alibaba.mtl.appmonitor.model.Dimension a(android.os.Parcel r2) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r2.readString();	 Catch:{ Throwable -> 0x000e }
        r2 = r2.readString();	 Catch:{ Throwable -> 0x000e }
        r1 = new com.alibaba.mtl.appmonitor.model.Dimension;	 Catch:{ Throwable -> 0x000e }
        r1.<init>(r2, r0);	 Catch:{ Throwable -> 0x000e }
        goto L_0x000f;
    L_0x000e:
        r1 = 0;
    L_0x000f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.model.Dimension.a(android.os.Parcel):com.alibaba.mtl.appmonitor.model.Dimension");
    }
}
