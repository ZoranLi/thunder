package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

public class ChatSystem implements IChatUser {
    private static ChatSystem sInstance;

    public String avatarUrl() {
        return "";
    }

    public String gender() {
        return "unknown";
    }

    public String kind() {
        return "system";
    }

    public String nickname() {
        return "system";
    }

    public String raw() {
        return "system";
    }

    public int rawVersion() {
        return 1;
    }

    public long userId() {
        return 0;
    }

    private ChatSystem() {
    }

    public static ChatSystem getInstance() {
        if (sInstance == null) {
            sInstance = new ChatSystem();
        }
        return sInstance;
    }

    public VideoUserInfo userInfo() {
        return new VideoUserInfo();
    }
}
