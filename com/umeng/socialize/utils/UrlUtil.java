package com.umeng.socialize.utils;

import com.umeng.socialize.Config;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class UrlUtil {
    public static final String ALL = "https://at.umeng.com/0fqeCy?cid=476";
    public static final String ALL_AUTHFAIL = "https://at.umeng.com/CuKXbi?cid=476";
    public static final String ALL_AUTH_EVERY = "https://at.umeng.com/1HTzyC?cid=476";
    public static final String ALL_AUTH_TWICE = "https://at.umeng.com/i8Dy8n?cid=476";
    public static final String ALL_ERROR_APPKEY = "https://at.umeng.com/ya4Dmy?cid=476";
    public static final String ALL_FILENOTFOUNDEXCEPTION = "https://at.umeng.com/aOzmWf?cid=476";
    public static final String ALL_FOOTER = "";
    public static final String ALL_NOCLASSDEFFOUND = "https://at.umeng.com/5P9baC?cid=476";
    public static final String ALL_NOT_INSTALL = "https://at.umeng.com/ve4Pbm?cid=476";
    public static final String ALL_NO_APPKEY = "https://at.umeng.com/bObWzC?cid=476";
    public static final String ALL_NO_CONFIG = "https://at.umeng.com/8Tfmei?cid=476";
    public static final String ALL_NO_JAR = "https://at.umeng.com/9T595j?cid=476";
    public static final String ALL_NO_ONACTIVITY = "https://at.umeng.com/CCiOHv?cid=476";
    public static final String ALL_NO_RES = "https://at.umeng.com/KzKfWz?cid=476";
    public static final String ALL_SHAREFAIL = "https://at.umeng.com/LXzm8D?cid=476";
    public static final String FACEBOOK_AUTH_FAIL = "https://at.umeng.com/Pn0TTr?cid=476";
    public static final String FACEBOOK_CANCEL_SUCCESS = "https://at.umeng.com/KD4zOf?cid=476";
    public static final String FACEBOOK_GRAY = "https://at.umeng.com/KD4zOf?cid=476";
    public static final String QQ_10044 = "https://at.umeng.com/OTnqea?cid=476";
    public static final String QQ_NO_CALLBACK = "https://at.umeng.com/jiia8D?cid=476";
    public static final String QQ_SHARESUCCESS_CANCEL = "https://at.umeng.com/WT95za?cid=476";
    public static final String QQ_SHARESUCCESS_NOFOUND = "https://at.umeng.com/iWvmGD?cid=476";
    public static final String QQ_SHARE_FAIL = "https://at.umeng.com/19HTvC?cid=476";
    public static final String QQ_TENCENT_INITFAIL = "https://at.umeng.com/iqmK1D?cid=476";
    public static final String SINASIMPLE_WEBAUTH_FAIL = "https://at.umeng.com/CC0LLz?cid=476";
    public static final String SINA_ERROR_SIGN = "https://at.umeng.com/9XX5ry?cid=476";
    public static final String SINA_FULL_C8998 = "https://at.umeng.com/4v4XPn?cid=476";
    public static final String SINA_IP_LIMIT = "https://at.umeng.com/GPruqi?cid=476";
    public static final String SINA_NO_CALLBACK = "https://at.umeng.com/9XXbCm?cid=476";
    public static final String SINA_SIMAPLE_C8998 = "https://at.umeng.com/KHDGXb?cid=476";
    public static final String TWITTER_AUTH_FAIL = "https://at.umeng.com/HL1T9j?cid=476";
    public static final String WX_40125 = "https://at.umeng.com/iiuOHz?cid=476";
    public static final String WX_CIRCLE_NOCONTENT = "https://at.umeng.com/SLDG5z?cid=476";
    public static final String WX_ERROR_SIGN = "https://at.umeng.com/f8HHDi?cid=476";
    public static final String WX_HIT_PUSH = "https://at.umeng.com/H5vGLj?cid=476";
    public static final String WX_NOMUSIC = "https://at.umeng.com/uOjyCu?cid=476";
    public static final String WX_NO_CALLBACK = "https://at.umeng.com/9D49bu?cid=476";
    public static final String WX_NO_LINK = "https://at.umeng.com/KfWLzu?cid=476";

    public static void sharePrint(SHARE_MEDIA share_media) {
        if (share_media == SHARE_MEDIA.QQ || share_media == SHARE_MEDIA.QQ) {
            Log.url("QQ分享小贴士1", "为什么我的QQ没有回调？", QQ_NO_CALLBACK);
            Log.url("QQ分享小贴士2", "为什么qq分享成功却回调取消？", QQ_SHARESUCCESS_CANCEL);
            Log.url("QQ分享小贴士3", "为什么qq分享成功却没有收到消息？", QQ_SHARESUCCESS_NOFOUND);
            Log.url("QQ分享小贴士4", "为什么qq分享失败，缺少权限？", QQ_SHARE_FAIL);
            Log.url("QQ分享小贴士5", "为什么qq tencent初始化失败？", QQ_TENCENT_INITFAIL);
            Log.url("QQ分享小贴士6", "为什么qq提示100044", QQ_10044);
        }
        if (share_media == SHARE_MEDIA.FACEBOOK || share_media == SHARE_MEDIA.FACEBOOK_MESSAGER) {
            Log.url("facebook分享小贴士1", "为什么发布按钮为灰色？", "https://at.umeng.com/KD4zOf?cid=476");
            Log.url("facebook分享小贴士2", "为什么facebook分享取消却回调成功？", "https://at.umeng.com/KD4zOf?cid=476");
            Log.url("facebook分享小贴士3", "为什么facebook分享失败？", FACEBOOK_AUTH_FAIL);
        }
        if (share_media == SHARE_MEDIA.TWITTER) {
            Log.url("twitter分享小贴士1", "为什么twitter授权失败？", TWITTER_AUTH_FAIL);
        }
        if (share_media == SHARE_MEDIA.WEIXIN || share_media == SHARE_MEDIA.WEIXIN_CIRCLE) {
            Log.url("微信分享小贴士1", "为什么微信没有回调？", WX_NO_CALLBACK);
            Log.url("微信分享小贴士2", "为什么微信朋友圈链接不显示描述文字？", WX_CIRCLE_NOCONTENT);
            Log.url("微信分享小贴士3", "为什么微信提示40125/invalid APPsecret？", WX_40125);
            Log.url("微信分享小贴士3", "为什么微信分享提示hit push hold", WX_HIT_PUSH);
        }
        if (share_media == SHARE_MEDIA.SINA && Config.isUmengSina.booleanValue()) {
            Log.url("sina分享小贴士1", "为什么我使用精简版，网页授权认证失败", SINASIMPLE_WEBAUTH_FAIL);
            Log.url("sina分享小贴士2", "为什么我使用精简版，授权不能成功或提示C8998", SINA_SIMAPLE_C8998);
            Log.url("sina分享小贴士3", "为什么我没有回调", SINA_NO_CALLBACK);
            Log.url("sina分享小贴士4", "为什么我提示 Ip Limit, request ip is not", SINA_IP_LIMIT);
        }
        if (share_media == SHARE_MEDIA.SINA && Config.isUmengSina.booleanValue() == null) {
            Log.url("sina分享小贴士1", "为什么我的com.sina.weibo.sdk.net.DownloadService报红？", TWITTER_AUTH_FAIL);
            Log.url("sina分享小贴士1", "为什么我使用完整版，授权不能成功或提示C8998", SINA_FULL_C8998);
            Log.url("sina分享小贴士3", "为什么我没有回调", SINA_NO_CALLBACK);
            Log.url("sina分享小贴士4", "为什么我提示 Ip Limit, request ip is not", SINA_IP_LIMIT);
        }
    }

    public static void getInfoPrint(SHARE_MEDIA share_media) {
        Log.url("获取用户资料小贴士1", "我想每次获取用户资料都授权怎么办？", ALL_AUTH_EVERY);
        Log.url("获取用户资料小贴士2", "为什么我每次获取用户资料都跳转两次授权界面？", ALL_AUTH_TWICE);
        if (share_media == SHARE_MEDIA.QQ) {
            Log.url("QQ授权小贴士1", "为什么qq提示100044？", QQ_10044);
        }
        if (share_media == SHARE_MEDIA.WEIXIN) {
            Log.url("微信授权小贴士1", "为什么微信登陆提示该链接无法访问？", WX_NO_LINK);
            Log.url("微信授权小贴士2", "为什么微信授权一直等待不能成功？", WX_ERROR_SIGN);
            Log.url("微信授权小贴士3", "为什么微信提示40125/invalid APPsecret？", WX_40125);
        }
        if (share_media == SHARE_MEDIA.SINA && Config.isUmengSina.booleanValue()) {
            Log.url("sina授权小贴士1", "为什么我使用精简版，网页授权认证失败", SINASIMPLE_WEBAUTH_FAIL);
            Log.url("sina授权小贴士2", "为什么我使用精简版，授权不能成功或提示C8998", SINA_SIMAPLE_C8998);
            Log.url("sina授权小贴士3", "为什么我没有回调", SINA_NO_CALLBACK);
            Log.url("sina授权小贴士4", "为什么我提示 Ip Limit, request ip is not", SINA_IP_LIMIT);
        }
        if (share_media == SHARE_MEDIA.SINA && Config.isUmengSina.booleanValue() == null) {
            Log.url("sina授权小贴士1", "为什么我的com.sina.weibo.sdk.net.DownloadService报红？", TWITTER_AUTH_FAIL);
            Log.url("sina授权小贴士1", "为什么我使用完整版，授权不能成功或提示C8998", SINA_FULL_C8998);
            Log.url("sina授权小贴士3", "为什么我没有回调", SINA_NO_CALLBACK);
            Log.url("sina授权小贴士4", "为什么我提示 Ip Limit, request ip is not", SINA_IP_LIMIT);
        }
    }
}
