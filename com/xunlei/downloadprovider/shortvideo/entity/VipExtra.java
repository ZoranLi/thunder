package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VipExtra implements Parcelable {
    public static final Creator<VipExtra> CREATOR = new j();
    public boolean a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    private String f;

    public int describeContents() {
        return 0;
    }

    public static VipExtra a(JSONObject jSONObject) {
        return b(jSONObject);
    }

    private static VipExtra b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            VipExtra vipExtra = new VipExtra();
            vipExtra.c = jSONObject.getInt("vasID");
            vipExtra.f = jSONObject.optString("uid");
            boolean z = false;
            vipExtra.a = jSONObject.optInt("isVIP", 0) == 1;
            vipExtra.b = jSONObject.optInt("VIPLevel");
            vipExtra.d = jSONObject.optInt("vasType");
            if (jSONObject.optInt("isYear") == 1) {
                z = true;
            }
            vipExtra.e = z;
            return vipExtra;
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
            return null;
        }
    }

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vasID", this.c);
            jSONObject.put("uid", this.f);
            jSONObject.put("isVIP", this.a);
            jSONObject.put("VIPLevel", this.b);
            jSONObject.put("vasType", this.d);
            jSONObject.put("isYear", this.e);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeByte(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeByte(this.e);
    }

    protected VipExtra(Parcel parcel) {
        this.f = parcel.readString();
        boolean z = false;
        this.a = parcel.readByte() != (byte) 0;
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        if (parcel.readByte() != null) {
            z = true;
        }
        this.e = z;
    }

    public final int b() {
        if (!this.a) {
            return 0;
        }
        if (this.c == 14) {
            return 2;
        }
        return this.d == 5 ? 1 : 3;
    }
}
