package com.xunlei.downloadprovider.publiser.per.model;

import com.xunlei.downloadprovider.comment.entity.BaseCommentInfo;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentVideoFeedInfo extends b implements Serializable {
    private static final long serialVersionUID = 1;
    private int commentStatus;
    private VideoUserInfo commentUserInfo;
    private BaseVideoInfo relatedVideoInfo;

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

    public void setRelatedUserInfo(VideoUserInfo videoUserInfo) {
        this.commentUserInfo = videoUserInfo;
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

    public int getCommentStatus() {
        return this.commentStatus;
    }

    public static CommentVideoFeedInfo parseFrom(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        CommentVideoFeedInfo commentVideoFeedInfo = new CommentVideoFeedInfo();
        commentVideoFeedInfo.baseCommentInfo = BaseCommentInfo.parseFrom(jSONObject.getJSONObject("comment_info"));
        commentVideoFeedInfo.commentUserInfo = VideoUserInfo.parseFrom(jSONObject.optJSONObject(VideoUserInfo.JSON_KEY));
        commentVideoFeedInfo.relatedVideoInfo = BaseVideoInfo.createFromJson(jSONObject.optJSONObject(BaseVideoInfo.JSON_KEY));
        commentVideoFeedInfo.commentStatus = jSONObject.optInt("resource_status");
        return commentVideoFeedInfo;
    }
}
