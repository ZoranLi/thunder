package com.xunlei.downloadprovider.publiser.per.model;

import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: PublishItemInfo */
public abstract class g {
    private VideoUserInfo mVideoUserInfo;

    public abstract boolean equals(Object obj);

    public VideoUserInfo getUserInfo() {
        if (this.mVideoUserInfo == null) {
            this.mVideoUserInfo = new VideoUserInfo();
        }
        return this.mVideoUserInfo;
    }

    public void setUserInfo(VideoUserInfo videoUserInfo) {
        this.mVideoUserInfo = videoUserInfo;
    }
}
