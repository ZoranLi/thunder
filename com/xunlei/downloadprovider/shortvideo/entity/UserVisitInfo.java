package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class UserVisitInfo implements Parcelable {
    public static final Creator<UserVisitInfo> CREATOR = new g();
    public int a;
    private long b;

    public int describeContents() {
        return 0;
    }

    public static UserVisitInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        UserVisitInfo userVisitInfo = new UserVisitInfo();
        userVisitInfo.a = jSONObject.optInt("visit_count", 0);
        userVisitInfo.b = jSONObject.optLong("uid");
        return userVisitInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeLong(this.b);
    }

    protected UserVisitInfo(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readLong();
    }
}
