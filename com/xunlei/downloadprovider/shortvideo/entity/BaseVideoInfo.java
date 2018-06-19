package com.xunlei.downloadprovider.shortvideo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.TextView;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.d.b.n;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseVideoInfo implements Parcelable, Serializable {
    public static final Creator<BaseVideoInfo> CREATOR = new b();
    public static final String GZH = "gzh";
    public static final String JSON_KEY = "video_info";
    public static final String PS_SL = "ps_sl";
    public static final String PS_YL = "ps_yl";
    public static final String PS_ZB = "ps_zb";
    public static final String SC_SL = "sc_sl";
    public static final String SC_YL = "sc_yl";
    public static final String SC_ZB = "sc_zb";
    private static Map<String, String> sVideoPlatformMap;
    private AudioInfo audioInfo;
    private int commentCount;
    private String coverUrl;
    private int duration;
    private int fileSize;
    private String gcid;
    private boolean hasLike;
    private boolean isFromShot;
    private boolean isTop;
    private int likeCount;
    private LocationInfo locationInfo;
    private String mPreloadPlayUrl;
    private String mServerExtData;
    private int playCount;
    private String playUrl;
    private int posterHeight;
    private int posterWidth;
    private long publisherId;
    private int shareCount;
    private String source;
    private int status;
    private String title;
    private long uplineTime;
    private int videoHeight;
    private String videoId;
    private String videoType;
    private int videoWidth;

    public int describeContents() {
        return 2;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public String getTitle() {
        String str = this.title;
        return str != null ? str.trim() : null;
    }

    public int getDuration() {
        return this.duration;
    }

    public long getUplineTime() {
        return this.uplineTime;
    }

    public void setUplineTime(long j) {
        this.uplineTime = j;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getGcid() {
        return this.gcid;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getPosterWidth() {
        return this.posterWidth;
    }

    public int getPosterHeight() {
        return this.posterHeight;
    }

    public int getStatus() {
        return this.status;
    }

    public long getPublisherId() {
        return this.publisherId;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public boolean hasLike() {
        return this.hasLike;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public int getShareCount() {
        return this.shareCount;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public String getSource() {
        return this.source;
    }

    public void setLikeCount(int i) {
        this.likeCount = i;
    }

    public void setHasLike(boolean z) {
        this.hasLike = z;
    }

    public void setShareCount(int i) {
        this.shareCount = i;
    }

    public void setCommentCount(int i) {
        this.commentCount = i;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setPlayUrl(String str) {
        this.playUrl = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setGcid(String str) {
        this.gcid = str;
    }

    public void setFileSize(int i) {
        this.fileSize = i;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public void setPosterWidth(int i) {
        this.posterWidth = i;
    }

    public void setPosterHeight(int i) {
        this.posterHeight = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setPublisherId(long j) {
        this.publisherId = j;
    }

    public void setPlayCount(int i) {
        this.playCount = i;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getVideoType() {
        return this.videoType;
    }

    public boolean isFromYouLiaoShot() {
        return this.videoType != null && PS_YL.equals(this.videoType);
    }

    public boolean isFromShot() {
        return this.isFromShot;
    }

    public boolean isFromYouLiao() {
        if (!PS_YL.equals(this.videoType)) {
            if (!SC_YL.equals(this.videoType)) {
                return false;
            }
        }
        return true;
    }

    public boolean isFromXLLive() {
        if (!PS_ZB.equals(this.videoType)) {
            if (!SC_ZB.equals(this.videoType)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFromShot(String str) {
        if (!(PS_SL.equals(str) || PS_YL.equals(str))) {
            if (PS_ZB.equals(str) == null) {
                return null;
            }
        }
        return true;
    }

    public boolean isTop() {
        return this.isTop;
    }

    public void setTop(boolean z) {
        this.isTop = z;
    }

    public String getServerExtData() {
        return this.mServerExtData;
    }

    public void setServerExtData(String str) {
        this.mServerExtData = str;
    }

    public void setPreloadPlayUrl(String str) {
        this.mPreloadPlayUrl = str;
    }

    public String getPreloadPlayUrl() {
        return this.mPreloadPlayUrl;
    }

    public LocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    public AudioInfo getAudioInfo() {
        return this.audioInfo;
    }

    public static BaseVideoInfo parseFrom(BaseVideoInfo baseVideoInfo, JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (jSONObject.length() > 0) {
                if (baseVideoInfo == null) {
                    baseVideoInfo = new BaseVideoInfo();
                }
                baseVideoInfo.videoId = jSONObject.getString(AgooConstants.MESSAGE_ID);
                baseVideoInfo.title = jSONObject.optString("title");
                baseVideoInfo.duration = jSONObject.optInt(SocializeProtocolConstants.DURATION);
                baseVideoInfo.uplineTime = jSONObject.optLong("upline_time") * 1000;
                baseVideoInfo.playUrl = jSONObject.optString("play_url");
                baseVideoInfo.coverUrl = jSONObject.optString("cover_url");
                baseVideoInfo.gcid = jSONObject.optString("gcid");
                baseVideoInfo.fileSize = jSONObject.optInt("file_size");
                baseVideoInfo.videoWidth = jSONObject.optInt("video_width");
                baseVideoInfo.videoHeight = jSONObject.optInt("video_height");
                baseVideoInfo.posterWidth = jSONObject.optInt("poster_width");
                baseVideoInfo.posterHeight = jSONObject.optInt("poster_height");
                baseVideoInfo.status = jSONObject.optInt("status");
                baseVideoInfo.setPublisherId(jSONObject.optLong("uid"));
                baseVideoInfo.likeCount = jSONObject.optInt("fav_count");
                baseVideoInfo.hasLike = jSONObject.optBoolean("have_fav");
                baseVideoInfo.playCount = jSONObject.optInt("play_count");
                baseVideoInfo.shareCount = jSONObject.optInt("share_count");
                baseVideoInfo.commentCount = jSONObject.optInt("comment_count");
                baseVideoInfo.source = jSONObject.optString("source");
                baseVideoInfo.videoType = jSONObject.optString("video_type");
                baseVideoInfo.isFromShot = isFromShot(baseVideoInfo.videoType);
                JSONObject optJSONObject = jSONObject.optJSONObject("location_info");
                if (optJSONObject != null) {
                    baseVideoInfo.locationInfo = LocationInfo.a(optJSONObject);
                }
                jSONObject = jSONObject.optJSONObject("audio_info");
                if (jSONObject != null) {
                    baseVideoInfo.audioInfo = AudioInfo.a(jSONObject);
                }
                return baseVideoInfo;
            }
        }
        return baseVideoInfo;
    }

    public static BaseVideoInfo createFromJson(JSONObject jSONObject) throws JSONException {
        return parseFrom(new BaseVideoInfo(), jSONObject);
    }

    public static String getShareUrl(String str) {
        StringBuilder stringBuilder = new StringBuilder(d.a().n.b());
        stringBuilder.append("_t=");
        stringBuilder.append(System.currentTimeMillis() / 300000);
        stringBuilder.append("&origin=a_sl_app_v5.60.2.5510&id=");
        stringBuilder.append(str);
        stringBuilder.append("&entry=link");
        return stringBuilder.toString();
    }

    public static String getRedPacketShareUrl(String str) {
        n nVar = d.a().l;
        StringBuilder stringBuilder = new StringBuilder(nVar.c());
        stringBuilder.append("_t=");
        stringBuilder.append(System.currentTimeMillis() / 300000);
        stringBuilder.append("&origin=a_sl_app_v5.60.2.5510&id=");
        stringBuilder.append(str);
        stringBuilder.append("&inviter=");
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("&entry=");
        stringBuilder.append(nVar.b() == n.b ? SocializeConstants.KEY_PIC : "link");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.videoId);
        parcel.writeString(this.title);
        parcel.writeInt(this.duration);
        parcel.writeLong(this.uplineTime);
        parcel.writeString(this.playUrl);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.gcid);
        parcel.writeInt(this.fileSize);
        parcel.writeInt(this.videoWidth);
        parcel.writeInt(this.videoHeight);
        parcel.writeInt(this.posterWidth);
        parcel.writeInt(this.posterHeight);
        parcel.writeInt(this.status);
        parcel.writeLong(this.publisherId);
        parcel.writeInt(this.likeCount);
        parcel.writeByte(this.hasLike);
        parcel.writeInt(this.playCount);
        parcel.writeInt(this.shareCount);
        parcel.writeInt(this.commentCount);
        parcel.writeString(this.source);
        parcel.writeString(this.videoType);
        parcel.writeString(this.mServerExtData);
        parcel.writeString(this.mPreloadPlayUrl);
        parcel.writeParcelable(this.locationInfo, i);
        parcel.writeParcelable(this.audioInfo, i);
    }

    protected BaseVideoInfo(Parcel parcel) {
        this.videoId = parcel.readString();
        this.title = parcel.readString();
        this.duration = parcel.readInt();
        this.uplineTime = parcel.readLong();
        this.playUrl = parcel.readString();
        this.coverUrl = parcel.readString();
        this.gcid = parcel.readString();
        this.fileSize = parcel.readInt();
        this.videoWidth = parcel.readInt();
        this.videoHeight = parcel.readInt();
        this.posterWidth = parcel.readInt();
        this.posterHeight = parcel.readInt();
        this.status = parcel.readInt();
        this.publisherId = parcel.readLong();
        this.likeCount = parcel.readInt();
        this.hasLike = parcel.readByte() != (byte) 0;
        this.playCount = parcel.readInt();
        this.shareCount = parcel.readInt();
        this.commentCount = parcel.readInt();
        this.source = parcel.readString();
        this.videoType = parcel.readString();
        this.mServerExtData = parcel.readString();
        this.mPreloadPlayUrl = parcel.readString();
        this.locationInfo = (LocationInfo) parcel.readParcelable(LocationInfo.class.getClassLoader());
        this.audioInfo = (AudioInfo) parcel.readParcelable(AudioInfo.class.getClassLoader());
    }

    static {
        Map hashMap = new HashMap();
        sVideoPlatformMap = hashMap;
        hashMap.put(PS_YL, " 通过有料APP拍摄");
        sVideoPlatformMap.put(SC_YL, " 通过有料APP上传");
        sVideoPlatformMap.put(PS_ZB, " 通过迅雷直播APP拍摄");
        sVideoPlatformMap.put(SC_ZB, " 通过迅雷直播APP上传");
    }

    public static void setVideoPlatformTextView(TextView textView, String str, boolean z) {
        CharSequence charSequence = (String) sVideoPlatformMap.get(str);
        if (!(PS_YL.equals(str) || SC_YL.equals(str) || PS_ZB.equals(str))) {
            if (SC_ZB.equals(str) == null) {
                textView.setVisibility(8);
                return;
            }
        }
        textView.setVisibility(null);
        if (!z) {
            charSequence = charSequence.trim();
        }
        textView.setText(charSequence);
    }
}
