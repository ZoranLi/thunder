package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class LiveExtra implements Parcelable {
    public static final Creator<LiveExtra> CREATOR = new c();
    public String a;
    public String b;
    public int c;
    public String d;
    public int e;
    public String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;

    public int describeContents() {
        return 1;
    }

    public final boolean a() {
        return "1".equals(this.j);
    }

    public static LiveExtra a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.length() != 0) {
                LiveExtra liveExtra = new LiveExtra();
                liveExtra.g = jSONObject.optString("uid");
                liveExtra.h = jSONObject.optString("nickname");
                liveExtra.a = jSONObject.optString("uuid");
                liveExtra.b = jSONObject.optString("sex");
                liveExtra.i = jSONObject.optString("head_portrait");
                liveExtra.j = jSONObject.optString("rad_status");
                liveExtra.k = jSONObject.optString("last_ptime");
                liveExtra.c = jSONObject.optInt("roomusers");
                liveExtra.d = jSONObject.optString("rad_title");
                liveExtra.l = jSONObject.optInt("total_point");
                liveExtra.e = jSONObject.optInt("record_num");
                liveExtra.f = jSONObject.optString("roomInfo");
                return liveExtra;
            }
        }
        return null;
    }

    public final JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.g);
            jSONObject.put("nickname", this.h);
            jSONObject.put("uuid", this.a);
            jSONObject.put("sex", this.b);
            jSONObject.put("head_portrait", this.i);
            jSONObject.put("rad_status", this.j);
            jSONObject.put("lastPtime", this.k);
            jSONObject.put("roomUsers", this.h);
            jSONObject.put("radTitle", this.d);
            jSONObject.put("totalPoint", this.l);
            jSONObject.put("recordNum", this.e);
            jSONObject.put("mLiveRoomInfoStr", this.f);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.l);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
    }

    protected LiveExtra(Parcel parcel) {
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.l = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
    }
}
