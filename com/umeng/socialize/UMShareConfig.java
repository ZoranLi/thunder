package com.umeng.socialize;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.uploadlog.UMLog;
import com.umeng.socialize.utils.ContextUtil;

public final class UMShareConfig {
    public static final int AUTH_TYPE_SSO = 1;
    public static final int AUTH_TYPE_WEBVIEW = 2;
    public static final int KAKAO_ACCOUNT = 2;
    public static final int KAKAO_STORY = 1;
    public static final int KAKAO_TALK = 0;
    public static final int LINED_IN_BASE_PROFILE = 0;
    public static final int LINED_IN_FULL_PROFILE = 1;
    public static final int LINKED_IN_FRIEND_SCOPE_ANYONE = 0;
    public static final int LINKED_IN_FRIEND_SCOPE_CONNECTIONS = 1;
    private int facebookAuthType;
    private boolean isHideQzoneOnQQFriendList;
    public boolean isNeedAuthOnGetUserInfo;
    private boolean isOpenShareEditActivity = true;
    private int kakaoAuthType;
    private int linkedInFriendScope;
    private int linkedInProfileScope;
    private String platformName = "";
    private int sinaAuthType;

    public UMShareConfig() {
        setShareToLinkedInFriendScope(Config.LinkedInShareCode);
        setShareToQQFriendQzoneItemHide(Config.QQWITHQZONE == 2);
        setShareToQQPlatformName(Config.appName);
        setSinaAuthType(1);
        setFacebookAuthType(1);
        setKaKaoAuthType(Config.KaKaoLoginType);
        isNeedAuthOnGetUserInfo(Config.isNeedAuth);
        setLinkedInProfileScope(Config.LinkedInProfileScope);
    }

    public final UMShareConfig isNeedAuthOnGetUserInfo(boolean z) {
        this.isNeedAuthOnGetUserInfo = z;
        return this;
    }

    public final UMShareConfig setLinkedInProfileScope(int i) {
        if (i == 0 || i == 1) {
            this.linkedInProfileScope = i;
        }
        return this;
    }

    public final UMShareConfig isOpenShareEditActivity(boolean z) {
        this.isOpenShareEditActivity = z;
        UMLog.setIsOpenShareEdit(z);
        return this;
    }

    public final UMShareConfig setShareToQQPlatformName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.platformName = str;
        }
        return this;
    }

    public final UMShareConfig setShareToQQFriendQzoneItemHide(boolean z) {
        this.isHideQzoneOnQQFriendList = z;
        return this;
    }

    public final UMShareConfig setShareToLinkedInFriendScope(int i) {
        if (i == 0 || i == 1) {
            this.linkedInFriendScope = i;
        }
        return this;
    }

    public final UMShareConfig setSinaAuthType(int i) {
        if (i == 1 || i == 2) {
            this.sinaAuthType = i;
        }
        return this;
    }

    public final UMShareConfig setFacebookAuthType(int i) {
        if (i == 1 || i == 2) {
            this.facebookAuthType = i;
        }
        return this;
    }

    public final UMShareConfig setKaKaoAuthType(int i) {
        if (i == 0 || i == 2 || i == 1) {
            this.kakaoAuthType = i;
        }
        return this;
    }

    public final String getAppName() {
        if (TextUtils.isEmpty(this.platformName)) {
            Context context = ContextUtil.getContext();
            if (context != null) {
                CharSequence loadLabel = context.getApplicationInfo().loadLabel(context.getPackageManager());
                if (!TextUtils.isEmpty(loadLabel)) {
                    this.platformName = loadLabel.toString();
                }
            }
        }
        return this.platformName;
    }

    public final boolean isHideQzoneOnQQFriendList() {
        return this.isHideQzoneOnQQFriendList;
    }

    public final boolean isLinkedInShareToAnyone() {
        return this.linkedInFriendScope == 0;
    }

    public final boolean isLinkedInProfileBase() {
        return this.linkedInProfileScope == 0;
    }

    public final boolean isKakaoAuthWithTalk() {
        return this.kakaoAuthType == 0;
    }

    public final boolean isKakaoAuthWithStory() {
        return this.kakaoAuthType == 1;
    }

    public final boolean isKakaoAuthWithAccount() {
        return this.kakaoAuthType == 2;
    }

    public final boolean isSinaAuthWithWebView() {
        return this.sinaAuthType == 2;
    }

    public final boolean isFacebookAuthWithWebView() {
        return this.facebookAuthType == 2;
    }

    public final boolean isNeedAuthOnGetUserInfo() {
        return this.isNeedAuthOnGetUserInfo;
    }

    public final boolean isOpenShareEditActivity() {
        return this.isOpenShareEditActivity;
    }
}
