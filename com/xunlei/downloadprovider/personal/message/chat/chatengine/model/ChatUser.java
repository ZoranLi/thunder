package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONObject;

public class ChatUser implements IChatUser {
    public static final int CURRENT_RAW_VERSION = 1;
    private String avatarUrl = "";
    private String gender = "unknown";
    private String kind = "";
    private String nickname = DEFAULT_NICK_NAME;
    private String raw = "";
    private int rawVersion = 0;
    private long userId = 0;
    private VideoUserInfo userInfo = null;

    public void setGender(String str) {
        this.gender = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public String nickname() {
        return this.nickname;
    }

    public String gender() {
        return this.gender;
    }

    public String avatarUrl() {
        return this.avatarUrl;
    }

    public long userId() {
        return this.userId;
    }

    public String kind() {
        return this.kind;
    }

    public int rawVersion() {
        return this.rawVersion;
    }

    public void setRaw(int i, String str) {
        if (str != null && i == 1) {
            this.rawVersion = i;
            this.raw = str;
            try {
                this.userInfo = VideoUserInfo.parseFrom(new JSONObject(str));
            } catch (int i2) {
                i2.printStackTrace();
            }
        }
    }

    public String raw() {
        return this.raw;
    }

    public VideoUserInfo userInfo() {
        return this.userInfo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ChatUser{nickname='");
        stringBuilder.append(this.nickname);
        stringBuilder.append('\'');
        stringBuilder.append(", avatarUrl='");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", gender='");
        stringBuilder.append(this.gender);
        stringBuilder.append('\'');
        stringBuilder.append(", userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", kind='");
        stringBuilder.append(this.kind);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
