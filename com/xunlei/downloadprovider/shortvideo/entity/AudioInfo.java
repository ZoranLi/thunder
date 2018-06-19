package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class AudioInfo implements Parcelable {
    public static final Creator<AudioInfo> CREATOR = new a();
    public String a;
    public String b;
    public int c;
    private String d;
    private String e;
    private int f;

    public int describeContents() {
        return 0;
    }

    public static AudioInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AudioInfo audioInfo = new AudioInfo();
        audioInfo.a = jSONObject.optString("audio_id");
        audioInfo.b = jSONObject.optString("title").trim();
        audioInfo.d = jSONObject.optString("singer");
        audioInfo.e = jSONObject.optString("poster_url");
        audioInfo.f = jSONObject.optInt("status");
        audioInfo.c = jSONObject.optInt("count");
        return audioInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.c);
    }

    protected AudioInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.c = parcel.readInt();
    }
}
