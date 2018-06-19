package com.xunlei.downloadprovider.publiser.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.shortvideo.entity.UserVisitInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoFollowInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class PublisherInfo implements Parcelable {
    public static final Creator<PublisherInfo> CREATOR = new p();
    public VideoUserInfo a;
    VideoFollowInfo b;
    public UserVisitInfo c;

    public int describeContents() {
        return 0;
    }

    public final VideoUserInfo a() {
        if (this.a == null) {
            this.a = new VideoUserInfo();
        }
        return this.a;
    }

    public final VideoFollowInfo b() {
        if (this.b == null) {
            this.b = new VideoFollowInfo();
        }
        return this.b;
    }

    public final boolean c() {
        return a().getLiveExtra().e > 0;
    }

    public final String d() {
        if (this.a == null) {
            return null;
        }
        return m.b(this.a.getProvince(), this.a.getCity());
    }

    public final String e() {
        String str = "";
        if (this.a == null) {
            return str;
        }
        String birthday = this.a.getBirthday();
        if (TextUtils.isEmpty(birthday) || birthday.equals(DispatchConstants.OTHER)) {
            return str;
        }
        try {
            Date parse = new SimpleDateFormat("yyyyMMdd").parse(birthday);
            Calendar instance = Calendar.getInstance();
            if (instance.before(parse)) {
                return str;
            }
            int i = instance.get(1);
            int i2 = instance.get(2);
            int i3 = instance.get(5);
            instance.setTime(parse);
            int i4 = instance.get(1);
            int i5 = instance.get(2);
            int i6 = instance.get(5);
            i -= i4;
            if (i2 <= i5 && (i2 != i5 || i3 < i6)) {
                i--;
            }
            if (i < 0 || i > 100) {
                birthday = "";
                return birthday;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("岁 ");
            stringBuilder.append(m.a(i5 + 1, i6));
            birthday = stringBuilder.toString();
            return birthday;
        } catch (ParseException e) {
            e.printStackTrace();
            birthday = str;
        }
    }

    public static PublisherInfo a(JSONObject jSONObject) throws JSONException {
        PublisherInfo publisherInfo = new PublisherInfo();
        if (jSONObject == null) {
            return publisherInfo;
        }
        publisherInfo.a = VideoUserInfo.parseFrom(jSONObject.optJSONObject(VideoUserInfo.JSON_KEY));
        publisherInfo.b = VideoFollowInfo.a(jSONObject.optJSONObject("follow_info"));
        publisherInfo.c = UserVisitInfo.a(jSONObject.optJSONObject("visit_info"));
        return publisherInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }

    protected PublisherInfo(Parcel parcel) {
        this.a = (VideoUserInfo) parcel.readParcelable(VideoUserInfo.class.getClassLoader());
        this.b = (VideoFollowInfo) parcel.readParcelable(VideoFollowInfo.class.getClassLoader());
        this.c = (UserVisitInfo) parcel.readParcelable(UserVisitInfo.class.getClassLoader());
    }
}
