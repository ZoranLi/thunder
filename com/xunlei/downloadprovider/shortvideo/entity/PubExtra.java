package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class PubExtra implements Parcelable {
    public static final Creator<PubExtra> CREATOR = new f();
    public int a;
    public String b;
    private String c;
    private String d;

    public int describeContents() {
        return 0;
    }

    public static PubExtra a(JSONObject jSONObject) {
        PubExtra pubExtra = new PubExtra();
        if (jSONObject != null) {
            if (jSONObject.length() != 0) {
                pubExtra.c = jSONObject.optString("uid");
                pubExtra.a = jSONObject.optInt("v_status");
                pubExtra.b = jSONObject.optString("v_url");
                pubExtra.d = jSONObject.optString("v_comment");
                return pubExtra;
            }
        }
        return pubExtra;
    }

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.c);
            jSONObject.put("v_status", this.a);
            jSONObject.put("v_url", this.b);
            jSONObject.put("v_comment", this.d);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
    }

    protected PubExtra(Parcel parcel) {
        this.c = parcel.readString();
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.d = parcel.readString();
    }
}
