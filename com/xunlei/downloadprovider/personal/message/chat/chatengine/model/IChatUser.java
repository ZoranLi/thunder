package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.io.Serializable;

public interface IChatUser extends Serializable {
    public static final String DEFAULT_NICK_NAME = BrothersApplication.getApplicationInstance().getString(R.string.personal_chat_default_user_nickname);
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";

    String avatarUrl();

    String gender();

    String kind();

    String nickname();

    String raw();

    int rawVersion();

    long userId();

    VideoUserInfo userInfo();
}
