package com.baidu.mobads.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class e implements Parcelable {
    public static final Creator<e> a = new f();
    private JSONObject b;
    private double c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;

    public int describeContents() {
        return 0;
    }

    public e(java.lang.String r5) {
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
        r4.<init>();
        r0 = 1;
        r1 = 0;
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0033 }
        r2.<init>(r5);	 Catch:{ JSONException -> 0x0033 }
        r4.b = r2;	 Catch:{ JSONException -> 0x0033 }
        r5 = r4.b;	 Catch:{ JSONException -> 0x0033 }
        r2 = "version";	 Catch:{ JSONException -> 0x0033 }
        r2 = r5.getDouble(r2);	 Catch:{ JSONException -> 0x0033 }
        r4.c = r2;	 Catch:{ JSONException -> 0x0033 }
        r5 = r4.b;	 Catch:{ JSONException -> 0x0033 }
        r2 = "url";	 Catch:{ JSONException -> 0x0033 }
        r5 = r5.getString(r2);	 Catch:{ JSONException -> 0x0033 }
        r4.d = r5;	 Catch:{ JSONException -> 0x0033 }
        r5 = r4.b;	 Catch:{ JSONException -> 0x0033 }
        r2 = "sign";	 Catch:{ JSONException -> 0x0033 }
        r5 = r5.getString(r2);	 Catch:{ JSONException -> 0x0033 }
        r4.e = r5;	 Catch:{ JSONException -> 0x0033 }
        r4.h = r0;	 Catch:{ JSONException -> 0x0033 }
        r5 = "";	 Catch:{ JSONException -> 0x0033 }
        r4.f = r5;	 Catch:{ JSONException -> 0x0033 }
        r4.g = r1;	 Catch:{ JSONException -> 0x0033 }
        goto L_0x0035;
    L_0x0033:
        r4.h = r1;
    L_0x0035:
        r5 = r4.c();
        if (r5 == 0) goto L_0x003c;
    L_0x003b:
        goto L_0x003d;
    L_0x003c:
        r0 = r1;
    L_0x003d:
        r4.h = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.e.<init>(java.lang.String):void");
    }

    public e(e eVar, String str, Boolean bool) {
        this.c = eVar.b();
        this.d = eVar.c();
        this.e = eVar.d();
        this.h = eVar.a().booleanValue();
        this.f = str;
        this.g = bool.booleanValue();
    }

    private e(Parcel parcel) {
        this.e = parcel.readString();
        this.h = parcel.readInt();
        this.d = parcel.readString();
        this.c = parcel.readDouble();
        this.f = parcel.readString();
        this.g = parcel.readInt();
    }

    public Boolean a() {
        boolean z = true;
        if (this.h != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public double b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String toString() {
        return this.b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.e);
        parcel.writeInt(this.h);
        parcel.writeString(this.d);
        parcel.writeDouble(this.c);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
    }
}
