package com.xunlei.downloadprovider.publiser.per.model;

import android.graphics.Bitmap;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class PublishVideoFeedInfo extends g implements Serializable {
    private static final long serialVersionUID = 1;
    private Bitmap mPosterBitmap;
    private long publishTime;
    private BaseVideoInfo relatedVideoInfo;

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

    public long getPublishTime() {
        return this.publishTime;
    }

    public void setPublishTime(long j) {
        this.publishTime = j;
    }

    public static PublishVideoFeedInfo parseFrom(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        PublishVideoFeedInfo publishVideoFeedInfo = new PublishVideoFeedInfo();
        publishVideoFeedInfo.publishTime = jSONObject.optLong(MessageInfo.INSERT_TIME) * 1000;
        publishVideoFeedInfo.setUserInfo(VideoUserInfo.parseFrom(jSONObject.optJSONObject(VideoUserInfo.JSON_KEY)));
        publishVideoFeedInfo.relatedVideoInfo = BaseVideoInfo.createFromJson(jSONObject.optJSONObject(BaseVideoInfo.JSON_KEY));
        publishVideoFeedInfo.relatedVideoInfo.setUplineTime(publishVideoFeedInfo.publishTime);
        return publishVideoFeedInfo;
    }

    public void setPosterBitmap(Bitmap bitmap) {
        this.mPosterBitmap = bitmap;
    }

    public Bitmap getPosterBitmap() {
        return this.mPosterBitmap;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PublishVideoFeedInfo)) {
            return false;
        }
        return getRelatedVideoInfo().getVideoId().equals(((PublishVideoFeedInfo) obj).getRelatedVideoInfo().getVideoId());
    }
}
