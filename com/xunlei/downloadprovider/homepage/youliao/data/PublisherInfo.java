package com.xunlei.downloadprovider.homepage.youliao.data;

import java.io.Serializable;

public class PublisherInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private String mAvatarUrl;
    private long mPublishTime;
    private String mPublisherId;
    private String mPublisherName;
    private String mUserKind;
    private int mVStatus = 0;
    private String mVUrl;

    public boolean isV() {
        return getVStatus() == 1;
    }

    public String getUserKind() {
        return this.mUserKind;
    }

    public void setUserKind(String str) {
        this.mUserKind = str;
    }

    public String getPublisherId() {
        return this.mPublisherId;
    }

    public void setPublisherId(String str) {
        this.mPublisherId = str;
    }

    public String getPublisherName() {
        return this.mPublisherName;
    }

    public void setPublisherName(String str) {
        this.mPublisherName = str;
    }

    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.mAvatarUrl = str;
    }

    public int getVStatus() {
        return this.mVStatus;
    }

    public void setVStatus(int i) {
        this.mVStatus = i;
    }

    public String getVUrl() {
        return this.mVUrl;
    }

    public void setVUrl(String str) {
        this.mVUrl = str;
    }

    public long getPublishTime() {
        return this.mPublishTime;
    }

    public void setPublishTime(long j) {
        this.mPublishTime = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PublisherInfo{mUserKind='");
        stringBuilder.append(getUserKind());
        stringBuilder.append('\'');
        stringBuilder.append(", mPublisherId='");
        stringBuilder.append(getPublisherId());
        stringBuilder.append('\'');
        stringBuilder.append(", mPublisherName='");
        stringBuilder.append(getPublisherName());
        stringBuilder.append('\'');
        stringBuilder.append(", mAvatarUrl='");
        stringBuilder.append(getAvatarUrl());
        stringBuilder.append('\'');
        stringBuilder.append(", mVStatus=");
        stringBuilder.append(getVStatus());
        stringBuilder.append(", mVUrl='");
        stringBuilder.append(getVUrl());
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
