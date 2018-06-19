package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anet.channel.strategy.dispatch.DispatchConstants;
import org.json.JSONObject;

public class LocationInfo implements Parcelable {
    public static final Creator<LocationInfo> CREATOR = new d();
    public String a;
    public String b;
    public double c;
    public double d;
    public int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public int describeContents() {
        return 0;
    }

    public static LocationInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LocationInfo locationInfo = new LocationInfo();
        locationInfo.a = jSONObject.optString("code");
        locationInfo.b = jSONObject.optString("location_name").trim();
        locationInfo.f = jSONObject.optString("desc");
        locationInfo.g = jSONObject.optString("location_name");
        locationInfo.h = jSONObject.optString("location_code");
        locationInfo.i = jSONObject.optString("city_name");
        locationInfo.j = jSONObject.optString("city_code");
        locationInfo.c = jSONObject.optDouble(DispatchConstants.LONGTITUDE);
        locationInfo.d = jSONObject.optDouble(DispatchConstants.LATITUDE);
        locationInfo.e = jSONObject.optInt("count");
        return locationInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeInt(this.e);
    }

    protected LocationInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.e = parcel.readInt();
    }
}
