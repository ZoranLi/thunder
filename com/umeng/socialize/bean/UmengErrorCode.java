package com.umeng.socialize.bean;

import com.xunlei.downloadprovider.pushmessage.bean.PushResult;

public enum UmengErrorCode {
    UnKnowCode(2000),
    AuthorizeFailed(PushResult.UNFINISH_DOWNLOAD_NOTICE),
    ShareFailed(PushResult.UNPLAY_NOTICE),
    RequestForUserProfileFailed(2004),
    ShareDataNil(2004),
    ShareDataTypeIllegal(2004),
    NotInstall(2008);
    
    private final int a;

    private UmengErrorCode(int i) {
        this.a = i;
    }

    public final String getMessage() {
        StringBuilder stringBuilder;
        if (this == UnKnowCode) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append("未知错误----");
            return stringBuilder.toString();
        } else if (this == AuthorizeFailed) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append("授权失败----");
            return stringBuilder.toString();
        } else if (this == ShareFailed) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append("分享失败----");
            return stringBuilder.toString();
        } else if (this == RequestForUserProfileFailed) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append("获取用户资料失败----");
            return stringBuilder.toString();
        } else if (this == ShareDataNil) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append("分享内容为空");
            return stringBuilder.toString();
        } else if (this == ShareDataTypeIllegal) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append("分享内容不合法----");
            return stringBuilder.toString();
        } else if (this != NotInstall) {
            return "unkonw";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append("没有安装应用 点击查看错误：https://at.umeng.com/ve4Pbm?cid=476");
            return stringBuilder.toString();
        }
    }

    private String a() {
        StringBuilder stringBuilder = new StringBuilder("错误码：");
        stringBuilder.append(this.a);
        stringBuilder.append(" 错误信息：");
        return stringBuilder.toString();
    }
}
