package com.xunlei.downloadprovider.comment.entity;

import java.io.Serializable;

public class TargetCommentInfo implements Serializable {
    private static final long serialVersionUID = 0;
    private String content;
    private String device;
    private long id;
    private String userAvatar;
    private long userId;
    private String userName;

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

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getUserAvatar() {
        return this.userAvatar;
    }

    public void setUserAvatar(String str) {
        this.userAvatar = str;
    }

    public String getDevice() {
        return this.device;
    }

    public void setDevice(String str) {
        this.device = str;
    }
}
