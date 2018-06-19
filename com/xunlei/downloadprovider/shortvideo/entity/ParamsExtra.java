package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class ParamsExtra implements Parcelable {
    public static final Creator<ParamsExtra> CREATOR = new e();
    public String a;
    public long b;
    public int c;
    private int d;
    private long e;
    private long f;
    private int g;

    public int describeContents() {
        return 0;
    }

    public static ParamsExtra a(JSONObject jSONObject) {
        ParamsExtra paramsExtra = new ParamsExtra();
        if (jSONObject != null) {
            if (jSONObject.length() != 0) {
                paramsExtra.a = jSONObject.optString("lastest_res_title");
                paramsExtra.b = jSONObject.optLong("res_update_time");
                paramsExtra.d = jSONObject.optInt("fav_count");
                paramsExtra.e = jSONObject.optLong("play_count");
                paramsExtra.f = jSONObject.optLong("play_time");
                paramsExtra.g = jSONObject.optInt("share_count");
                paramsExtra.c = jSONObject.optInt("pub_res_count");
                return paramsExtra;
            }
        }
        return paramsExtra;
    }

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lastest_res_title", this.a);
            jSONObject.put("res_update_time", this.b);
            jSONObject.put("fav_count", this.d);
            jSONObject.put("play_count", this.e);
            jSONObject.put("play_time", this.f);
            jSONObject.put("share_count", this.g);
            jSONObject.put("pub_res_count", this.c);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeLong(this.b);
        parcel.writeInt(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.c);
    }

    protected ParamsExtra(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readLong();
        this.d = parcel.readInt();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        this.g = parcel.readInt();
        this.c = parcel.readInt();
    }
}
