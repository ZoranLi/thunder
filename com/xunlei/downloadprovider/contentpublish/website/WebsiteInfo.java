package com.xunlei.downloadprovider.contentpublish.website;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.umeng.socialize.common.SocializeConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class WebsiteInfo implements Parcelable {
    public static final Creator<WebsiteInfo> CREATOR = new at();
    public String a;
    public long b;
    public long c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    private String o;

    public int describeContents() {
        return 0;
    }

    public static WebsiteInfo a(JSONObject jSONObject) throws JSONException {
        WebsiteInfo websiteInfo = new WebsiteInfo();
        websiteInfo.a = jSONObject.getString("site_pub_id");
        if (TextUtils.isEmpty(websiteInfo.a)) {
            throw new JSONException("site_pub_id in website_info is empty.");
        }
        websiteInfo.b = jSONObject.optLong("uid");
        websiteInfo.o = jSONObject.optString("icon");
        websiteInfo.c = jSONObject.optLong("pub_time") * 1000;
        websiteInfo.d = jSONObject.optString("description");
        websiteInfo.e = jSONObject.optString("title");
        websiteInfo.f = jSONObject.optString("url");
        JSONObject optJSONObject = jSONObject.optJSONObject(SocializeConstants.KEY_PIC);
        if (optJSONObject != null) {
            websiteInfo.h = optJSONObject.optInt("pic_width");
            websiteInfo.i = optJSONObject.optInt("pic_height");
            websiteInfo.g = optJSONObject.optString("pic_url");
        }
        websiteInfo.j = jSONObject.optBoolean("have_fav");
        websiteInfo.k = jSONObject.optInt("praise");
        websiteInfo.l = jSONObject.optInt("comment_count");
        websiteInfo.m = jSONObject.optInt("share_count");
        websiteInfo.n = jSONObject.optInt("status");
        return websiteInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeLong(this.b);
        parcel.writeString(this.o);
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeByte(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
    }

    protected WebsiteInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readLong();
        this.o = parcel.readString();
        this.c = parcel.readLong();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readByte() != (byte) 0;
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
    }
}
