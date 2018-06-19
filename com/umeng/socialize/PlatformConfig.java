package com.umeng.socialize;

import android.text.TextUtils;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class PlatformConfig {
    public static Map<SHARE_MEDIA, Platform> configs;

    public interface Platform {
        SHARE_MEDIA getName();

        boolean isConfigured();

        void parse(JSONObject jSONObject);
    }

    public static class APPIDPlatform implements Platform {
        public String appId = null;
        public String appkey = null;
        private SHARE_MEDIA p;
        public String redirectUrl = null;

        public void parse(JSONObject jSONObject) {
        }

        public APPIDPlatform(SHARE_MEDIA share_media) {
            this.p = share_media;
        }

        public SHARE_MEDIA getName() {
            return this.p;
        }

        public boolean isConfigured() {
            return (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appkey)) ? false : true;
        }
    }

    public static class CustomPlatform implements Platform {
        public static final String Name = "g+";
        public String appId = null;
        public String appkey = null;
        private SHARE_MEDIA p;

        public boolean isConfigured() {
            return true;
        }

        public void parse(JSONObject jSONObject) {
        }

        public CustomPlatform(SHARE_MEDIA share_media) {
            this.p = share_media;
        }

        public SHARE_MEDIA getName() {
            return this.p;
        }
    }

    static {
        Map hashMap = new HashMap();
        configs = hashMap;
        hashMap.put(SHARE_MEDIA.QQ, new APPIDPlatform(SHARE_MEDIA.QQ));
        configs.put(SHARE_MEDIA.QZONE, new APPIDPlatform(SHARE_MEDIA.QZONE));
        configs.put(SHARE_MEDIA.WEIXIN, new APPIDPlatform(SHARE_MEDIA.WEIXIN));
        configs.put(SHARE_MEDIA.VKONTAKTE, new APPIDPlatform(SHARE_MEDIA.WEIXIN));
        configs.put(SHARE_MEDIA.WEIXIN_CIRCLE, new APPIDPlatform(SHARE_MEDIA.WEIXIN_CIRCLE));
        configs.put(SHARE_MEDIA.WEIXIN_FAVORITE, new APPIDPlatform(SHARE_MEDIA.WEIXIN_FAVORITE));
        configs.put(SHARE_MEDIA.FACEBOOK_MESSAGER, new CustomPlatform(SHARE_MEDIA.FACEBOOK_MESSAGER));
        configs.put(SHARE_MEDIA.DOUBAN, new CustomPlatform(SHARE_MEDIA.DOUBAN));
        configs.put(SHARE_MEDIA.LAIWANG, new APPIDPlatform(SHARE_MEDIA.LAIWANG));
        configs.put(SHARE_MEDIA.LAIWANG_DYNAMIC, new APPIDPlatform(SHARE_MEDIA.LAIWANG_DYNAMIC));
        configs.put(SHARE_MEDIA.YIXIN, new APPIDPlatform(SHARE_MEDIA.YIXIN));
        configs.put(SHARE_MEDIA.YIXIN_CIRCLE, new APPIDPlatform(SHARE_MEDIA.YIXIN_CIRCLE));
        configs.put(SHARE_MEDIA.SINA, new APPIDPlatform(SHARE_MEDIA.SINA));
        configs.put(SHARE_MEDIA.TENCENT, new CustomPlatform(SHARE_MEDIA.TENCENT));
        configs.put(SHARE_MEDIA.ALIPAY, new APPIDPlatform(SHARE_MEDIA.ALIPAY));
        configs.put(SHARE_MEDIA.RENREN, new CustomPlatform(SHARE_MEDIA.RENREN));
        configs.put(SHARE_MEDIA.DROPBOX, new APPIDPlatform(SHARE_MEDIA.DROPBOX));
        configs.put(SHARE_MEDIA.GOOGLEPLUS, new CustomPlatform(SHARE_MEDIA.GOOGLEPLUS));
        configs.put(SHARE_MEDIA.FACEBOOK, new CustomPlatform(SHARE_MEDIA.FACEBOOK));
        configs.put(SHARE_MEDIA.TWITTER, new APPIDPlatform(SHARE_MEDIA.TWITTER));
        configs.put(SHARE_MEDIA.TUMBLR, new CustomPlatform(SHARE_MEDIA.TUMBLR));
        configs.put(SHARE_MEDIA.PINTEREST, new APPIDPlatform(SHARE_MEDIA.PINTEREST));
        configs.put(SHARE_MEDIA.POCKET, new CustomPlatform(SHARE_MEDIA.POCKET));
        configs.put(SHARE_MEDIA.WHATSAPP, new CustomPlatform(SHARE_MEDIA.WHATSAPP));
        configs.put(SHARE_MEDIA.EMAIL, new CustomPlatform(SHARE_MEDIA.EMAIL));
        configs.put(SHARE_MEDIA.SMS, new CustomPlatform(SHARE_MEDIA.SMS));
        configs.put(SHARE_MEDIA.LINKEDIN, new CustomPlatform(SHARE_MEDIA.LINKEDIN));
        configs.put(SHARE_MEDIA.LINE, new CustomPlatform(SHARE_MEDIA.LINE));
        configs.put(SHARE_MEDIA.FLICKR, new CustomPlatform(SHARE_MEDIA.FLICKR));
        configs.put(SHARE_MEDIA.EVERNOTE, new CustomPlatform(SHARE_MEDIA.EVERNOTE));
        configs.put(SHARE_MEDIA.FOURSQUARE, new CustomPlatform(SHARE_MEDIA.FOURSQUARE));
        configs.put(SHARE_MEDIA.YNOTE, new APPIDPlatform(SHARE_MEDIA.YNOTE));
        configs.put(SHARE_MEDIA.KAKAO, new APPIDPlatform(SHARE_MEDIA.KAKAO));
        configs.put(SHARE_MEDIA.INSTAGRAM, new CustomPlatform(SHARE_MEDIA.INSTAGRAM));
        configs.put(SHARE_MEDIA.MORE, new CustomPlatform(SHARE_MEDIA.MORE));
        configs.put(SHARE_MEDIA.DINGTALK, new APPIDPlatform(SHARE_MEDIA.MORE));
    }

    public static void setQQZone(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.QZONE);
        aPPIDPlatform.appId = str;
        aPPIDPlatform.appkey = str2;
        aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.QQ);
        aPPIDPlatform.appId = str;
        aPPIDPlatform.appkey = str2;
    }

    public static void setTwitter(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.TWITTER);
        aPPIDPlatform.appId = str;
        aPPIDPlatform.appkey = str2;
    }

    public static void setAlipay(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.ALIPAY)).appId = str;
    }

    public static void setDropbox(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.DROPBOX);
        aPPIDPlatform.appId = str;
        aPPIDPlatform.appkey = str2;
    }

    public static void setDing(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.DINGTALK)).appId = str;
    }

    public static void setSinaWeibo(String str, String str2, String str3) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.SINA);
        aPPIDPlatform.appId = removeBlank(str);
        aPPIDPlatform.appkey = removeBlank(str2);
        aPPIDPlatform.redirectUrl = str3;
    }

    public static void setVKontakte(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.VKONTAKTE);
        aPPIDPlatform.appId = str;
        aPPIDPlatform.appkey = str2;
    }

    public static void setWeixin(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN);
        aPPIDPlatform.appId = str;
        aPPIDPlatform.appkey = str2;
        aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN_CIRCLE);
        aPPIDPlatform.appId = str;
        aPPIDPlatform.appkey = str2;
        aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN_FAVORITE);
        aPPIDPlatform.appId = str;
        aPPIDPlatform.appkey = str2;
    }

    public static void setLaiwang(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.LAIWANG);
        aPPIDPlatform.appId = str;
        aPPIDPlatform.appkey = str2;
        aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.LAIWANG_DYNAMIC);
        aPPIDPlatform.appId = str;
        aPPIDPlatform.appkey = str2;
    }

    public static void setYixin(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.YIXIN)).appId = str;
        ((APPIDPlatform) configs.get(SHARE_MEDIA.YIXIN_CIRCLE)).appId = str;
    }

    public static void setPinterest(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.PINTEREST)).appId = str;
    }

    public static void setKakao(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.KAKAO)).appId = str;
    }

    public static void setYnote(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.YNOTE)).appId = str;
    }

    public static Platform getPlatform(SHARE_MEDIA share_media) {
        return (Platform) configs.get(share_media);
    }

    public static String removeBlank(String str) {
        return !TextUtils.isEmpty(str) ? str.replace(" ", "") : str;
    }
}
