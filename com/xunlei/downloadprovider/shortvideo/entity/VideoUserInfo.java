package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.xunlei.common.androidutil.DateTimeUtil;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.login.XLSexType;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.publiser.visitors.model.Gender;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoUserInfo implements Parcelable, Serializable {
    public static final Creator<VideoUserInfo> CREATOR = new i();
    public static final int FLAG_LIVE = 2;
    public static final int FLAG_PARAMS = 8;
    public static final int FLAG_PUB = 4;
    public static final int FLAG_VIP = 1;
    public static final String JSON_KEY = "user_info";
    private String birthday;
    private String city;
    private String country;
    private String description;
    private String kind;
    private LiveExtra liveExtra;
    private long loginTime;
    private VipExtras mVipExtras;
    private String newno;
    private String nickname;
    private ParamsExtra paramsExtra;
    private String portraitUrl;
    private String province;
    private PubExtra pubExtra;
    private String sex;
    private String uid;

    public int describeContents() {
        return 0;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getNewno() {
        return this.newno;
    }

    public void setNewno(String str) {
        this.newno = str;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public String getSex() {
        return this.sex;
    }

    public Gender getGender() {
        if (IChatUser.GENDER_MALE.equals(this.sex)) {
            return Gender.MALE;
        }
        if (IChatUser.GENDER_FEMALE.equals(this.sex)) {
            return Gender.FEMALE;
        }
        return Gender.UNKNOWN;
    }

    public void setSex(String str) {
        this.sex = str;
    }

    public void setSex(XLSexType xLSexType) {
        if (XLSexType.MALE.equals(xLSexType)) {
            this.sex = IChatUser.GENDER_MALE;
        } else if (XLSexType.FEMALE.equals(xLSexType) != null) {
            this.sex = IChatUser.GENDER_FEMALE;
        } else {
            this.sex = "unknown";
        }
    }

    public boolean isMale() {
        return this.sex == null || !IChatUser.GENDER_FEMALE.equals(this.sex);
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getNickname() {
        return TextUtils.isEmpty(this.nickname) ? "迅雷用户" : this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public void setPortraitUrl(String str) {
        this.portraitUrl = str;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public long getLoginTime() {
        return this.loginTime;
    }

    public void setLoginTime(long j) {
        this.loginTime = j;
    }

    public LiveExtra getLiveExtra() {
        if (this.liveExtra == null) {
            synchronized (this) {
                if (this.liveExtra == null) {
                    this.liveExtra = new LiveExtra();
                }
            }
        }
        return this.liveExtra;
    }

    public void setLiveExtra(LiveExtra liveExtra) {
        this.liveExtra = liveExtra;
    }

    public PubExtra getPubExtra() {
        if (this.pubExtra == null) {
            synchronized (this) {
                if (this.pubExtra == null) {
                    this.pubExtra = new PubExtra();
                }
            }
        }
        return this.pubExtra;
    }

    public void setPubExtra(PubExtra pubExtra) {
        this.pubExtra = pubExtra;
    }

    public VipExtras getVipExtras() {
        if (this.mVipExtras == null) {
            synchronized (this) {
                if (this.mVipExtras == null) {
                    this.mVipExtras = new VipExtras();
                }
            }
        }
        return this.mVipExtras;
    }

    public void setVipExtras(VipExtras vipExtras) {
        this.mVipExtras = vipExtras;
    }

    public VipExtra getVipInfo() {
        VipExtra vipExtra = (VipExtra) getVipExtras().a().get(2);
        VipExtra vipExtra2 = (VipExtra) getVipExtras().a().get(14);
        if (vipExtra != null && vipExtra.a) {
            return vipExtra;
        }
        if (vipExtra2 == null || !vipExtra2.a) {
            if (vipExtra != null) {
                return vipExtra;
            }
            if (vipExtra2 == null) {
                return new VipExtra();
            }
        }
        return vipExtra2;
    }

    public void addVip(VipExtra vipExtra) {
        getVipExtras().a().put(vipExtra.c, vipExtra);
    }

    public ParamsExtra getParamsExtra() {
        if (this.paramsExtra == null) {
            synchronized (this) {
                if (this.paramsExtra == null) {
                    this.paramsExtra = new ParamsExtra();
                }
            }
        }
        return this.paramsExtra;
    }

    public void setParamsExtra(ParamsExtra paramsExtra) {
        this.paramsExtra = paramsExtra;
    }

    public String getUid() {
        if (TextUtils.isEmpty(this.uid)) {
            this.uid = "0";
        }
        return this.uid;
    }

    public boolean isFollowed() {
        return b.a().b(Long.parseLong(getUid()));
    }

    public boolean isPub() {
        return "pub".equals(this.kind);
    }

    public boolean isAuthPub() {
        if (this.pubExtra != null && this.pubExtra.a == 1) {
            return true;
        }
        return false;
    }

    public VipExtra getDownloadVipInfo() {
        return (VipExtra) getVipExtras().a().get(2);
    }

    public VipExtra getkuainiaoVipInfo() {
        return (VipExtra) getVipExtras().a().get(14);
    }

    public boolean isDownloadVip() {
        VipExtra vipExtra = (VipExtra) getVipExtras().a().get(2);
        return vipExtra != null && vipExtra.a;
    }

    public boolean isKuainiaoVip() {
        VipExtra vipExtra = (VipExtra) getVipExtras().a().get(14);
        return vipExtra != null && vipExtra.a;
    }

    public boolean isVip() {
        if (!isDownloadVip()) {
            if (!isKuainiaoVip()) {
                return false;
            }
        }
        return true;
    }

    public static VideoUserInfo parseFrom(JSONObject jSONObject) throws JSONException {
        return parseFrom(new VideoUserInfo(), jSONObject);
    }

    public static VideoUserInfo parseFrom(VideoUserInfo videoUserInfo, JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (jSONObject.length() > 0) {
                if (videoUserInfo == null) {
                    videoUserInfo = new VideoUserInfo();
                }
                videoUserInfo.uid = jSONObject.getString("uid");
                videoUserInfo.newno = jSONObject.optString("newno");
                videoUserInfo.birthday = jSONObject.optString("birthday");
                videoUserInfo.country = jSONObject.optString("country");
                videoUserInfo.province = jSONObject.optString("province").trim();
                videoUserInfo.city = jSONObject.optString("city").trim();
                videoUserInfo.sex = jSONObject.optString("sex", "unknown");
                videoUserInfo.description = jSONObject.optString("description").trim();
                videoUserInfo.nickname = jSONObject.optString("nick_name").trim();
                videoUserInfo.portraitUrl = jSONObject.optString("portrait_url");
                videoUserInfo.kind = jSONObject.optString("kind", "pub");
                videoUserInfo.loginTime = DateUtil.date2TimeStamp(jSONObject.optString("login_time"), "yyyy-MM-dd HH:mm:ss");
                videoUserInfo.mVipExtras = VipExtras.a(jSONObject.optJSONArray("vip_extra"));
                videoUserInfo.pubExtra = PubExtra.a(jSONObject.optJSONObject("pub_extra"));
                videoUserInfo.liveExtra = LiveExtra.a(jSONObject.optJSONObject("live_extra"));
                videoUserInfo.paramsExtra = ParamsExtra.a(jSONObject.optJSONObject("params"));
                return videoUserInfo;
            }
        }
        return videoUserInfo;
    }

    public JSONObject toJSONObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.uid);
            jSONObject.put("newno", this.newno);
            jSONObject.put("birthday", this.birthday);
            jSONObject.put("country", this.country);
            jSONObject.put("province", this.province);
            jSONObject.put("city", this.city);
            jSONObject.put("sex", this.sex);
            jSONObject.put("description", this.description);
            jSONObject.put("nick_name", this.nickname);
            jSONObject.put("portrait_url", this.portraitUrl);
            jSONObject.put("kind", this.kind);
            jSONObject.put("login_time", DateTimeUtil.getDateTime(this.loginTime));
            if (this.mVipExtras != null) {
                Object obj;
                String str = "vip_extra";
                VipExtras vipExtras = this.mVipExtras;
                if (vipExtras.a == null) {
                    obj = null;
                } else {
                    obj = new JSONArray();
                    VipExtra vipExtra = (VipExtra) vipExtras.a.get(2);
                    if (vipExtra != null) {
                        obj.put(vipExtra.a());
                    }
                    VipExtra vipExtra2 = (VipExtra) vipExtras.a.get(14);
                    if (vipExtra2 != null) {
                        obj.put(vipExtra2.a());
                    }
                }
                jSONObject.put(str, obj);
            }
            if (this.pubExtra != null) {
                jSONObject.put("pub_extra", this.pubExtra.a());
            }
            if (this.liveExtra != null) {
                jSONObject.put("live_extra", this.liveExtra.b());
            }
            if (this.paramsExtra != null) {
                jSONObject.put("params", this.paramsExtra.a());
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeString(this.newno);
        parcel.writeString(this.birthday);
        parcel.writeString(this.country);
        parcel.writeString(this.province);
        parcel.writeString(this.sex);
        parcel.writeString(this.city);
        parcel.writeString(this.description);
        parcel.writeString(this.nickname);
        parcel.writeString(this.portraitUrl);
        parcel.writeString(this.kind);
        parcel.writeLong(this.loginTime);
        parcel.writeParcelable(this.liveExtra, i);
        parcel.writeParcelable(this.pubExtra, i);
        parcel.writeParcelable(this.mVipExtras, i);
        parcel.writeParcelable(this.paramsExtra, i);
    }

    protected VideoUserInfo(Parcel parcel) {
        this.uid = parcel.readString();
        this.newno = parcel.readString();
        this.birthday = parcel.readString();
        this.country = parcel.readString();
        this.province = parcel.readString();
        this.sex = parcel.readString();
        this.city = parcel.readString();
        this.description = parcel.readString();
        this.nickname = parcel.readString();
        this.portraitUrl = parcel.readString();
        this.kind = parcel.readString();
        this.loginTime = parcel.readLong();
        this.liveExtra = (LiveExtra) parcel.readParcelable(LiveExtra.class.getClassLoader());
        this.pubExtra = (PubExtra) parcel.readParcelable(PubExtra.class.getClassLoader());
        this.mVipExtras = (VipExtras) parcel.readParcelable(VipExtras.class.getClassLoader());
        this.paramsExtra = (ParamsExtra) parcel.readParcelable(ParamsExtra.class.getClassLoader());
    }

    public static VideoUserInfo create() {
        VideoUserInfo videoUserInfo = new VideoUserInfo();
        videoUserInfo.uid = "614753256";
        videoUserInfo.nickname = "Test User";
        videoUserInfo.portraitUrl = "http://img2.user.kanimg.com/usrimg/614753256/300x300";
        videoUserInfo.kind = "yl_daren";
        return videoUserInfo;
    }
}
