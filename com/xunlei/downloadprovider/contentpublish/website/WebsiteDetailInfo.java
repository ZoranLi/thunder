package com.xunlei.downloadprovider.contentpublish.website;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class WebsiteDetailInfo implements Parcelable {
    public static final Creator<WebsiteDetailInfo> CREATOR = new am();
    VideoUserInfo a;
    WebsiteInfo b;

    public int describeContents() {
        return 0;
    }

    public static WebsiteDetailInfo a(JSONObject jSONObject) {
        WebsiteDetailInfo websiteDetailInfo = new WebsiteDetailInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject("site_info");
        if (optJSONObject != null) {
            try {
                websiteDetailInfo.b = WebsiteInfo.a(optJSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
        if (jSONObject != null) {
            try {
                websiteDetailInfo.a = VideoUserInfo.parseFrom(jSONObject);
            } catch (JSONObject jSONObject2) {
                jSONObject2.printStackTrace();
            }
        }
        return websiteDetailInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }

    protected WebsiteDetailInfo(Parcel parcel) {
        this.a = (VideoUserInfo) parcel.readParcelable(VideoUserInfo.class.getClassLoader());
        this.b = (WebsiteInfo) parcel.readParcelable(WebsiteInfo.class.getClassLoader());
    }
}
