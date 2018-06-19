package com.xunlei.downloadprovider.comment.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.io.Serializable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentInfo implements Parcelable, Serializable {
    public static final Creator<CommentInfo> CREATOR = new c();
    public static int TYPE_CINECISM = 3;
    public static int TYPE_VIDEO = 1;
    public static int TYPE_WEBSITE = 2;
    private static final long serialVersionUID = 5;
    private BaseCommentInfo baseCommentInfo;
    private VideoUserInfo commentUserInfo;
    private boolean isPublishUserInfo;
    private boolean isPublisher;
    private CinecismInfo mCinecismInfo;
    private int mType;
    private WebsiteInfo mWebsiteInfo;
    private BaseVideoInfo relatedVideoInfo;

    public int describeContents() {
        return 0;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public BaseCommentInfo getBaseCommentInfo() {
        if (this.baseCommentInfo == null) {
            synchronized (this) {
                if (this.baseCommentInfo == null) {
                    this.baseCommentInfo = new BaseCommentInfo();
                }
            }
        }
        return this.baseCommentInfo;
    }

    public void setBaseCommentInfo(BaseCommentInfo baseCommentInfo) {
        this.baseCommentInfo = baseCommentInfo;
    }

    public void setRelatedUserInfo(VideoUserInfo videoUserInfo) {
        this.commentUserInfo = videoUserInfo;
    }

    public VideoUserInfo getRelatedUserInfo() {
        if (this.commentUserInfo == null) {
            synchronized (this) {
                if (this.commentUserInfo == null) {
                    this.commentUserInfo = new VideoUserInfo();
                }
            }
        }
        return this.commentUserInfo;
    }

    public BaseVideoInfo getRelatedVideoInfo() {
        if (this.relatedVideoInfo == null) {
            synchronized (this) {
                if (this.relatedVideoInfo == null) {
                    this.relatedVideoInfo = new BaseVideoInfo();
                }
            }
        }
        return this.relatedVideoInfo;
    }

    public void setRelatedVideoInfo(BaseVideoInfo baseVideoInfo) {
        this.relatedVideoInfo = baseVideoInfo;
    }

    public WebsiteInfo getWebsiteInfo() {
        return this.mWebsiteInfo;
    }

    public void setWebsiteInfo(WebsiteInfo websiteInfo) {
        this.mWebsiteInfo = websiteInfo;
    }

    public boolean isPublisher() {
        return this.isPublisher;
    }

    public CinecismInfo getCinecismInfo() {
        return this.mCinecismInfo;
    }

    public void setCinecismInfo(CinecismInfo cinecismInfo) {
        this.mCinecismInfo = cinecismInfo;
    }

    public void setPublisher(long j) {
        j = (j <= 0 || j != getUserId()) ? null : 1;
        this.isPublisher = j;
    }

    public void setPublishUserInfo(boolean z) {
        this.isPublishUserInfo = z;
    }

    public long getId() {
        return getBaseCommentInfo().getId();
    }

    public void setId(long j) {
        getBaseCommentInfo().setId(j);
    }

    public String getContent() {
        return getBaseCommentInfo().getContent();
    }

    public void setContent(String str) {
        getBaseCommentInfo().setContent(str);
    }

    public long getTime() {
        return getBaseCommentInfo().getTime();
    }

    public void setTime(long j) {
        getBaseCommentInfo().setTime(j);
    }

    public String getDevie() {
        return getBaseCommentInfo().getDevie();
    }

    public void setDevie(String str) {
        getBaseCommentInfo().setDevie(str);
    }

    public String getSourceId() {
        return getBaseCommentInfo().getSourceId();
    }

    public void setSourceId(String str) {
        getBaseCommentInfo().setSourceId(str);
    }

    public String getRelateGcid() {
        return getBaseCommentInfo().getRelateGcid();
    }

    public void setGcid(String str) {
        getBaseCommentInfo().setGcid(str);
    }

    public String getProvince() {
        return getRelatedUserInfo().getProvince();
    }

    public void setProvince(String str) {
        getRelatedUserInfo().setProvince(str);
    }

    public String getCity() {
        return getRelatedUserInfo().getCity();
    }

    public void setCity(String str) {
        getRelatedUserInfo().setCity(str);
    }

    public long getUserId() {
        if (this.isPublishUserInfo) {
            return getBaseCommentInfo().getUserId();
        }
        return Long.parseLong(getRelatedUserInfo().getUid());
    }

    public void setUserId(long j) {
        if (!this.isPublishUserInfo) {
            getRelatedUserInfo().setUid(String.valueOf(j));
        }
        getBaseCommentInfo().setUserId(j);
    }

    public String getUserName() {
        if (this.isPublishUserInfo) {
            return getBaseCommentInfo().getUserName();
        }
        return getRelatedUserInfo().getNickname();
    }

    public void setUserName(String str) {
        if (!this.isPublishUserInfo) {
            getRelatedUserInfo().setNickname(str);
        }
        getBaseCommentInfo().setUserName(str);
    }

    public String getUserAvatar() {
        if (this.isPublishUserInfo) {
            return getBaseCommentInfo().getUserAvatar();
        }
        return getRelatedUserInfo().getPortraitUrl();
    }

    public void setUserAvatar(String str) {
        if (!this.isPublishUserInfo) {
            getRelatedUserInfo().setPortraitUrl(str);
        }
        getBaseCommentInfo().setUserAvatar(str);
    }

    public boolean isPreview() {
        return getBaseCommentInfo().isPreview();
    }

    public void setPreview(boolean z) {
        getBaseCommentInfo().setPreview(z);
    }

    public boolean isLiked() {
        return getBaseCommentInfo().isLiked();
    }

    public void setLiked(boolean z) {
        getBaseCommentInfo().setLiked(z);
    }

    public long getLikeCount() {
        return getBaseCommentInfo().getLikeCount();
    }

    public void setLikeCount(long j) {
        getBaseCommentInfo().setLikeCount(j);
    }

    public int getShareCount() {
        return getBaseCommentInfo().getShareCount();
    }

    public void setShareCount(int i) {
        getBaseCommentInfo().setShareCount(i);
    }

    public long getReplyCount() {
        return getBaseCommentInfo().getReplyCount();
    }

    public void setReplyCount(long j) {
        getBaseCommentInfo().setReplyCount(j);
    }

    public List<TargetCommentInfo> getTargetCommentList() {
        return getBaseCommentInfo().getTargetCommentList();
    }

    public void setReplyCommentList(List<TargetCommentInfo> list) {
        getBaseCommentInfo().setReplyCommentList(list);
    }

    public boolean isHot() {
        return getBaseCommentInfo().isHot();
    }

    public void setHot(boolean z) {
        getBaseCommentInfo().setHot(z);
    }

    public void setDownloadSpeed(String str) {
        getBaseCommentInfo().setDownloadSpeed(str);
    }

    public String getDownloadSpeed() {
        return getBaseCommentInfo().getDownloadSpeed();
    }

    public void setPlayPosition(int i) {
        getBaseCommentInfo().setPlayPosition(i);
    }

    public int getPlayPosition() {
        return getBaseCommentInfo().getPlayPosition();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentInfo)) {
            return false;
        }
        CommentInfo commentInfo = (CommentInfo) obj;
        if (getType() != commentInfo.getType()) {
            return false;
        }
        if (getBaseCommentInfo() != null) {
            return getBaseCommentInfo().equals(commentInfo.getBaseCommentInfo());
        }
        return commentInfo.getBaseCommentInfo() == null;
    }

    public int hashCode() {
        return (31 * (getBaseCommentInfo() != null ? getBaseCommentInfo().hashCode() : 0)) + getType();
    }

    public static CommentInfo parseFrom(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("comment_info");
        CommentInfo commentInfo = new CommentInfo();
        commentInfo.baseCommentInfo = BaseCommentInfo.parseFrom(jSONObject2);
        if (jSONObject.has("res_info")) {
            jSONObject = jSONObject.getJSONObject("res_info");
            jSONObject2 = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
            commentInfo.relatedVideoInfo = BaseVideoInfo.createFromJson(jSONObject.optJSONObject(BaseVideoInfo.JSON_KEY));
            commentInfo.setPublishUserInfo(true);
        } else {
            jSONObject2 = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
            commentInfo.setPublishUserInfo(null);
        }
        commentInfo.commentUserInfo = VideoUserInfo.parseFrom(jSONObject2);
        return commentInfo;
    }

    public JSONObject toJSONObject() {
        if (this.baseCommentInfo != null) {
            if (this.commentUserInfo != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject toJSONObject = this.baseCommentInfo.toJSONObject();
                    JSONObject toJSONObject2 = this.commentUserInfo.toJSONObject();
                    jSONObject.put("comment_info", toJSONObject);
                    jSONObject.put(VideoUserInfo.JSON_KEY, toJSONObject2);
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.baseCommentInfo, i);
        parcel.writeParcelable(this.commentUserInfo, i);
        parcel.writeParcelable(this.relatedVideoInfo, i);
        parcel.writeByte(this.isPublisher);
        parcel.writeByte(this.isPublishUserInfo);
    }

    public CommentInfo() {
        this.mType = TYPE_VIDEO;
        this.isPublisher = false;
    }

    protected CommentInfo(Parcel parcel) {
        this.mType = TYPE_VIDEO;
        boolean z = false;
        this.isPublisher = false;
        this.baseCommentInfo = (BaseCommentInfo) parcel.readParcelable(BaseCommentInfo.class.getClassLoader());
        this.commentUserInfo = (VideoUserInfo) parcel.readParcelable(VideoUserInfo.class.getClassLoader());
        this.relatedVideoInfo = (BaseVideoInfo) parcel.readParcelable(BaseVideoInfo.class.getClassLoader());
        this.isPublisher = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != null) {
            z = true;
        }
        this.isPublishUserInfo = z;
    }
}
