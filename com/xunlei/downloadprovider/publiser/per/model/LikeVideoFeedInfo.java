package com.xunlei.downloadprovider.publiser.per.model;

import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class LikeVideoFeedInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private long likeTime;
    private VideoUserInfo relatedUserInfo;
    private BaseVideoInfo relatedVideoInfo;

    public long getLikeTime() {
        return this.likeTime;
    }

    public void setLikeTime(long j) {
        this.likeTime = j;
    }

    public VideoUserInfo getRelatedUserInfo() {
        if (this.relatedUserInfo == null) {
            synchronized (this) {
                if (this.relatedUserInfo == null) {
                    this.relatedUserInfo = new VideoUserInfo();
                }
            }
        }
        return this.relatedUserInfo;
    }

    public void setRelatedUserInfo(VideoUserInfo videoUserInfo) {
        this.relatedUserInfo = videoUserInfo;
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

    public static LikeVideoFeedInfo parseFrom(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        LikeVideoFeedInfo likeVideoFeedInfo = new LikeVideoFeedInfo();
        likeVideoFeedInfo.likeTime = jSONObject.optLong(MessageInfo.INSERT_TIME) * 1000;
        likeVideoFeedInfo.relatedUserInfo = VideoUserInfo.parseFrom(jSONObject.optJSONObject(VideoUserInfo.JSON_KEY));
        likeVideoFeedInfo.relatedVideoInfo = BaseVideoInfo.createFromJson(jSONObject.optJSONObject(BaseVideoInfo.JSON_KEY));
        return likeVideoFeedInfo;
    }
}
