package com.xunlei.downloadprovider.comment.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.alipay.sdk.packet.d;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseCommentInfo implements Parcelable, Serializable {
    public static final Creator<BaseCommentInfo> CREATOR = new b();
    private String content;
    private String devie;
    private String downloadSpeed;
    private String gcid;
    private long id;
    private boolean isHot = false;
    private boolean isLiked;
    private boolean isPreview;
    private long likeCount;
    private int playPosition = -1;
    private List<TargetCommentInfo> replyCommentList;
    private long replyCount;
    private int shareCount;
    private String sourceId;
    private String sourcePlatform;
    private long time;
    private String userAvatar;
    private long userId;
    private String userName;

    public int describeContents() {
        return 0;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        if (str == null) {
            this.content = str;
        } else {
            this.content = str.trim();
        }
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public String getDevie() {
        return this.devie;
    }

    public void setDevie(String str) {
        this.devie = str;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public String getRelateGcid() {
        return this.gcid;
    }

    public void setGcid(String str) {
        this.gcid = str;
    }

    public boolean isPreview() {
        return this.isPreview;
    }

    public void setPreview(boolean z) {
        this.isPreview = z;
    }

    public boolean isLiked() {
        return this.isLiked;
    }

    public void setLiked(boolean z) {
        this.isLiked = z;
    }

    public long getLikeCount() {
        return this.likeCount;
    }

    public void setLikeCount(long j) {
        this.likeCount = j;
    }

    public int getShareCount() {
        return this.shareCount;
    }

    public void setShareCount(int i) {
        this.shareCount = i;
    }

    public long getReplyCount() {
        return this.replyCount;
    }

    public void setReplyCount(long j) {
        this.replyCount = j;
    }

    public List<TargetCommentInfo> getTargetCommentList() {
        return this.replyCommentList;
    }

    public void setReplyCommentList(List<TargetCommentInfo> list) {
        this.replyCommentList = list;
    }

    public boolean isHot() {
        return this.isHot;
    }

    public void setHot(boolean z) {
        this.isHot = z;
    }

    public void setDownloadSpeed(String str) {
        this.downloadSpeed = str;
    }

    public String getDownloadSpeed() {
        return this.downloadSpeed;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserAvatar(String str) {
        this.userAvatar = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getGcid() {
        return this.gcid;
    }

    public List<TargetCommentInfo> getReplyCommentList() {
        return this.replyCommentList;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserAvatar() {
        return this.userAvatar;
    }

    public String getSourcePlatform() {
        return this.sourcePlatform;
    }

    public void setSourcePlatform(String str) {
        this.sourcePlatform = str;
    }

    public int getPlayPosition() {
        return this.playPosition;
    }

    public void setPlayPosition(int i) {
        this.playPosition = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseCommentInfo)) {
            return false;
        }
        return getId() == ((BaseCommentInfo) obj).getId();
    }

    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    public static BaseCommentInfo parseFrom(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BaseCommentInfo baseCommentInfo = new BaseCommentInfo();
        baseCommentInfo.setId(Long.parseLong(jSONObject.getString("cid")));
        baseCommentInfo.setSourceId(jSONObject.optString("sourceId"));
        baseCommentInfo.setContent(jSONObject.getString("comment"));
        baseCommentInfo.setTime(jSONObject.getLong("time"));
        baseCommentInfo.setDownloadSpeed(jSONObject.optString("downLoadSpeed", null));
        baseCommentInfo.setUserName(jSONObject.getString("userName"));
        baseCommentInfo.setUserId(jSONObject.getLong("uid"));
        baseCommentInfo.setUserAvatar(jSONObject.getString("userImg"));
        if (baseCommentInfo.getUserName() == null || !TextUtils.isGraphic(baseCommentInfo.getUserName().trim())) {
            baseCommentInfo.setUserName("迅雷用户");
        }
        baseCommentInfo.setLikeCount(jSONObject.getLong("gcount"));
        baseCommentInfo.setReplyCount(jSONObject.getLong("rcount"));
        baseCommentInfo.setShareCount(jSONObject.optInt("scount", 0));
        baseCommentInfo.setLiked(jSONObject.optBoolean("isPraise", false));
        baseCommentInfo.setPreview(jSONObject.optBoolean("isPdRiew", false));
        JSONArray optJSONArray = jSONObject.optJSONArray("replys");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            Object arrayList = new ArrayList(1);
            baseCommentInfo.setReplyCommentList(arrayList);
            JSONObject optJSONObject = optJSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                TargetCommentInfo targetCommentInfo = new TargetCommentInfo();
                targetCommentInfo.setId(optJSONObject.getLong("cid"));
                targetCommentInfo.setContent(optJSONObject.getString("content"));
                targetCommentInfo.setUserId(optJSONObject.getLong("uid"));
                targetCommentInfo.setUserName(optJSONObject.getString(MessageInfo.USER));
                targetCommentInfo.setUserAvatar(optJSONObject.getString("userImg"));
                if (targetCommentInfo.getUserName() == null || !TextUtils.isGraphic(targetCommentInfo.getUserName().trim())) {
                    targetCommentInfo.setUserName("迅雷用户");
                }
                arrayList.add(targetCommentInfo);
            }
        }
        baseCommentInfo.setDevie(jSONObject.optString(d.n));
        baseCommentInfo.setSourcePlatform(jSONObject.optString("sourcePlatform"));
        jSONObject = jSONObject.optString("extParamsJson", null);
        if (!TextUtils.isEmpty(jSONObject)) {
            baseCommentInfo.setPlayPosition(new JSONObject(jSONObject).optInt("play_position", -1));
        }
        return baseCommentInfo;
    }

    public JSONObject toJSONObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cid", this.id);
            jSONObject.put("sourceId", this.sourceId);
            jSONObject.put("comment", this.content);
            jSONObject.put("time", this.time);
            jSONObject.put("downLoadSpeed", this.downloadSpeed);
            jSONObject.put("userName", this.userName);
            jSONObject.put("uid", this.userId);
            jSONObject.put("userImg", this.userAvatar);
            jSONObject.put("gcount", this.likeCount);
            jSONObject.put("rcount", this.replyCount);
            jSONObject.put("scount", this.shareCount);
            jSONObject.put("isPraise", this.isLiked);
            jSONObject.put("isPdRiew", this.isPreview);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            if (this.replyCommentList != null && this.replyCommentList.size() > 0) {
                TargetCommentInfo targetCommentInfo = (TargetCommentInfo) this.replyCommentList.get(0);
                jSONObject2.put("cid", targetCommentInfo.getId());
                jSONObject2.put("content", targetCommentInfo.getContent());
                jSONObject2.put("uid", targetCommentInfo.getUserId());
                jSONObject2.put(MessageInfo.USER, targetCommentInfo.getUserName());
                jSONObject2.put("userImg", targetCommentInfo.getUserAvatar());
                jSONArray.put(jSONObject2);
                jSONObject.put("replys", jSONArray);
            }
            jSONObject.put(d.n, this.devie);
            jSONObject.put("sourcePlatform", this.sourcePlatform);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("play_position", this.playPosition);
            jSONObject.put("extParamsJson", jSONObject3.toString());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.content);
        parcel.writeLong(this.time);
        parcel.writeString(this.devie);
        parcel.writeString(this.sourceId);
        parcel.writeString(this.gcid);
        parcel.writeByte(this.isPreview);
        parcel.writeByte(this.isLiked);
        parcel.writeLong(this.likeCount);
        parcel.writeInt(this.shareCount);
        parcel.writeLong(this.replyCount);
        parcel.writeList(this.replyCommentList);
        parcel.writeByte(this.isHot);
        parcel.writeString(this.downloadSpeed);
        parcel.writeString(this.userName);
        parcel.writeLong(this.userId);
        parcel.writeString(this.userAvatar);
        parcel.writeString(this.sourcePlatform);
        parcel.writeInt(this.playPosition);
    }

    protected BaseCommentInfo(Parcel parcel) {
        boolean z = false;
        this.id = parcel.readLong();
        this.content = parcel.readString();
        this.time = parcel.readLong();
        this.devie = parcel.readString();
        this.sourceId = parcel.readString();
        this.gcid = parcel.readString();
        this.isPreview = parcel.readByte() != (byte) 0;
        this.isLiked = parcel.readByte() != (byte) 0;
        this.likeCount = parcel.readLong();
        this.shareCount = parcel.readInt();
        this.replyCount = parcel.readLong();
        this.replyCommentList = new ArrayList();
        parcel.readList(this.replyCommentList, TargetCommentInfo.class.getClassLoader());
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.isHot = z;
        this.downloadSpeed = parcel.readString();
        this.userName = parcel.readString();
        this.userId = parcel.readLong();
        this.userAvatar = parcel.readString();
        this.sourcePlatform = parcel.readString();
        this.playPosition = parcel.readInt();
    }
}
