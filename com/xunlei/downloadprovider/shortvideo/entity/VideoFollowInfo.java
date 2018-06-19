package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class VideoFollowInfo implements Parcelable {
    public static final Creator<VideoFollowInfo> CREATOR = new h();
    public boolean a;
    public int b;
    public int c;
    public long d;
    private String e;
    private String f;

    public int describeContents() {
        return 0;
    }

    public static VideoFollowInfo a(JSONObject jSONObject) {
        return a(new VideoFollowInfo(), jSONObject);
    }

    public static VideoFollowInfo a(VideoFollowInfo videoFollowInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return videoFollowInfo;
        }
        if (videoFollowInfo == null) {
            videoFollowInfo = new VideoFollowInfo();
        }
        videoFollowInfo.a = jSONObject.optBoolean("is_follow");
        videoFollowInfo.b = jSONObject.optInt("fans_count");
        videoFollowInfo.c = jSONObject.optInt("follow_count");
        videoFollowInfo.e = jSONObject.optString("myuid", "0");
        videoFollowInfo.f = jSONObject.optString("targetuid", "0");
        videoFollowInfo.d = jSONObject.optLong("follow_time");
        return videoFollowInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeByte(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }

    protected VideoFollowInfo(Parcel parcel) {
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.a = parcel.readByte() != (byte) 0;
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }
}
