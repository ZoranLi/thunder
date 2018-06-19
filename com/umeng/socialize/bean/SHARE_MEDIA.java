package com.umeng.socialize.bean;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.shareboard.SnsPlatform;

public enum SHARE_MEDIA {
    GOOGLEPLUS,
    GENERIC,
    SMS,
    EMAIL,
    SINA,
    QZONE,
    QQ,
    RENREN,
    WEIXIN,
    WEIXIN_CIRCLE,
    WEIXIN_FAVORITE,
    TENCENT,
    DOUBAN,
    FACEBOOK,
    FACEBOOK_MESSAGER,
    TWITTER,
    LAIWANG,
    LAIWANG_DYNAMIC,
    YIXIN,
    YIXIN_CIRCLE,
    INSTAGRAM,
    PINTEREST,
    EVERNOTE,
    POCKET,
    LINKEDIN,
    FOURSQUARE,
    YNOTE,
    WHATSAPP,
    LINE,
    FLICKR,
    TUMBLR,
    ALIPAY,
    KAKAO,
    DROPBOX,
    VKONTAKTE,
    DINGTALK,
    MORE;

    public static SHARE_MEDIA convertToEmun(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("wxtimeline")) {
            return WEIXIN_CIRCLE;
        }
        if (str.equals("wxsession")) {
            return WEIXIN;
        }
        for (SHARE_MEDIA share_media : values()) {
            if (share_media.toString().trim().equals(str)) {
                return share_media;
            }
        }
        return null;
    }

    public static SnsPlatform createSnsPlatform(String str, String str2, String str3, String str4, int i) {
        SnsPlatform snsPlatform = new SnsPlatform();
        snsPlatform.mShowWord = str;
        snsPlatform.mIcon = str3;
        snsPlatform.mGrayIcon = str4;
        snsPlatform.mIndex = i;
        snsPlatform.mKeyword = str2;
        return snsPlatform;
    }

    public final SnsPlatform toSnsPlatform() {
        SnsPlatform snsPlatform = new SnsPlatform();
        if (toString().equals(Constants.SOURCE_QQ)) {
            snsPlatform.mShowWord = "umeng_socialize_text_qq_key";
            snsPlatform.mIcon = "umeng_socialize_qq";
            snsPlatform.mGrayIcon = "umeng_socialize_qq";
            snsPlatform.mIndex = 0;
            snsPlatform.mKeyword = "qq";
        } else if (toString().equals("SMS")) {
            snsPlatform.mShowWord = "umeng_socialize_sms";
            snsPlatform.mIcon = "umeng_socialize_sms";
            snsPlatform.mGrayIcon = "umeng_socialize_sms";
            snsPlatform.mIndex = 1;
            snsPlatform.mKeyword = "sms";
        } else if (toString().equals("GOOGLEPLUS")) {
            snsPlatform.mShowWord = "umeng_socialize_text_googleplus_key";
            snsPlatform.mIcon = "umeng_socialize_google";
            snsPlatform.mGrayIcon = "umeng_socialize_google";
            snsPlatform.mIndex = 0;
            snsPlatform.mKeyword = "gooleplus";
        } else if (!toString().equals("GENERIC")) {
            if (toString().equals("EMAIL")) {
                snsPlatform.mShowWord = "umeng_socialize_mail";
                snsPlatform.mIcon = "umeng_socialize_gmail";
                snsPlatform.mGrayIcon = "umeng_socialize_gmail";
                snsPlatform.mIndex = 2;
                snsPlatform.mKeyword = NotificationCompat.CATEGORY_EMAIL;
            } else if (toString().equals("SINA")) {
                snsPlatform.mShowWord = "umeng_socialize_sina";
                snsPlatform.mIcon = "umeng_socialize_sina";
                snsPlatform.mGrayIcon = "umeng_socialize_sina";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "sina";
            } else if (toString().equals("QZONE")) {
                snsPlatform.mShowWord = "umeng_socialize_text_qq_zone_key";
                snsPlatform.mIcon = "umeng_socialize_qzone";
                snsPlatform.mGrayIcon = "umeng_socialize_qzone";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = Constants.SOURCE_QZONE;
            } else if (toString().equals("RENREN")) {
                snsPlatform.mShowWord = "umeng_socialize_text_renren_key";
                snsPlatform.mIcon = "umeng_socialize_renren";
                snsPlatform.mGrayIcon = "umeng_socialize_renren";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "renren";
            } else if (toString().equals("WEIXIN")) {
                snsPlatform.mShowWord = "umeng_socialize_text_weixin_key";
                snsPlatform.mIcon = "umeng_socialize_wechat";
                snsPlatform.mGrayIcon = "umeng_socialize_weichat";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = Token.WX_TOKEN_PLATFORMID_VALUE;
            } else if (toString().equals("WEIXIN_CIRCLE")) {
                snsPlatform.mShowWord = "umeng_socialize_text_weixin_circle_key";
                snsPlatform.mIcon = "umeng_socialize_wxcircle";
                snsPlatform.mGrayIcon = "umeng_socialize_wxcircle";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "wxcircle";
            } else if (toString().equals("WEIXIN_FAVORITE")) {
                snsPlatform.mShowWord = "umeng_socialize_text_weixin_fav_key";
                snsPlatform.mIcon = "umeng_socialize_fav";
                snsPlatform.mGrayIcon = "umeng_socialize_fav";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "wechatfavorite";
            } else if (toString().equals("TENCENT")) {
                snsPlatform.mShowWord = "umeng_socialize_text_tencent_key";
                snsPlatform.mIcon = "umeng_socialize_tx";
                snsPlatform.mGrayIcon = "umeng_socialize_tx";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = SocializeProtocolConstants.PROTOCOL_KEY_TENCENT;
            } else if (toString().equals("FACEBOOK")) {
                snsPlatform.mShowWord = "umeng_socialize_text_facebook_key";
                snsPlatform.mIcon = "umeng_socialize_facebook";
                snsPlatform.mGrayIcon = "umeng_socialize_facebook";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "facebook";
            } else if (toString().equals("FACEBOOK_MESSAGER")) {
                snsPlatform.mShowWord = "umeng_socialize_text_facebookmessager_key";
                snsPlatform.mIcon = "umeng_socialize_fbmessage";
                snsPlatform.mGrayIcon = "umeng_socialize_fbmessage";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "facebook_messager";
            } else if (toString().equals("YIXIN")) {
                snsPlatform.mShowWord = "umeng_socialize_text_yixin_key";
                snsPlatform.mIcon = "umeng_socialize_yixin";
                snsPlatform.mGrayIcon = "umeng_socialize_yixin";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "yinxin";
            } else if (toString().equals("TWITTER")) {
                snsPlatform.mShowWord = "umeng_socialize_text_twitter_key";
                snsPlatform.mIcon = "umeng_socialize_twitter";
                snsPlatform.mGrayIcon = "umeng_socialize_twitter";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "twitter";
            } else if (toString().equals("LAIWANG")) {
                snsPlatform.mShowWord = "umeng_socialize_text_laiwang_key";
                snsPlatform.mIcon = "umeng_socialize_laiwang";
                snsPlatform.mGrayIcon = "umeng_socialize_laiwang";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "laiwang";
            } else if (toString().equals("LAIWANG_DYNAMIC")) {
                snsPlatform.mShowWord = "umeng_socialize_text_laiwangdynamic_key";
                snsPlatform.mIcon = "umeng_socialize_laiwang_dynamic";
                snsPlatform.mGrayIcon = "umeng_socialize_laiwang_dynamic";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "laiwang_dynamic";
            } else if (toString().equals("INSTAGRAM")) {
                snsPlatform.mShowWord = "umeng_socialize_text_instagram_key";
                snsPlatform.mIcon = "umeng_socialize_instagram";
                snsPlatform.mGrayIcon = "umeng_socialize_instagram";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "instagram";
            } else if (toString().equals("YIXIN_CIRCLE")) {
                snsPlatform.mShowWord = "umeng_socialize_text_yixincircle_key";
                snsPlatform.mIcon = "umeng_socialize_yixin_circle";
                snsPlatform.mGrayIcon = "umeng_socialize_yixin_circle";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "yinxincircle";
            } else if (toString().equals("PINTEREST")) {
                snsPlatform.mShowWord = "umeng_socialize_text_pinterest_key";
                snsPlatform.mIcon = "umeng_socialize_pinterest";
                snsPlatform.mGrayIcon = "umeng_socialize_pinterest";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "pinterest";
            } else if (toString().equals("EVERNOTE")) {
                snsPlatform.mShowWord = "umeng_socialize_text_evernote_key";
                snsPlatform.mIcon = "umeng_socialize_evernote";
                snsPlatform.mGrayIcon = "umeng_socialize_evernote";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "evernote";
            } else if (toString().equals("POCKET")) {
                snsPlatform.mShowWord = "umeng_socialize_text_pocket_key";
                snsPlatform.mIcon = "umeng_socialize_pocket";
                snsPlatform.mGrayIcon = "umeng_socialize_pocket";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "pocket";
            } else if (toString().equals("LINKEDIN")) {
                snsPlatform.mShowWord = "umeng_socialize_text_linkedin_key";
                snsPlatform.mIcon = "umeng_socialize_linkedin";
                snsPlatform.mGrayIcon = "umeng_socialize_linkedin";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "linkedin";
            } else if (toString().equals("FOURSQUARE")) {
                snsPlatform.mShowWord = "umeng_socialize_text_foursquare_key";
                snsPlatform.mIcon = "umeng_socialize_foursquare";
                snsPlatform.mGrayIcon = "umeng_socialize_foursquare";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "foursquare";
            } else if (toString().equals("YNOTE")) {
                snsPlatform.mShowWord = "umeng_socialize_text_ydnote_key";
                snsPlatform.mIcon = "umeng_socialize_ynote";
                snsPlatform.mGrayIcon = "umeng_socialize_ynote";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "ynote";
            } else if (toString().equals("WHATSAPP")) {
                snsPlatform.mShowWord = "umeng_socialize_text_whatsapp_key";
                snsPlatform.mIcon = "umeng_socialize_whatsapp";
                snsPlatform.mGrayIcon = "umeng_socialize_whatsapp";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "whatsapp";
            } else if (toString().equals("LINE")) {
                snsPlatform.mShowWord = "umeng_socialize_text_line_key";
                snsPlatform.mIcon = "umeng_socialize_line";
                snsPlatform.mGrayIcon = "umeng_socialize_line";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "line";
            } else if (toString().equals("FLICKR")) {
                snsPlatform.mShowWord = "umeng_socialize_text_flickr_key";
                snsPlatform.mIcon = "umeng_socialize_flickr";
                snsPlatform.mGrayIcon = "umeng_socialize_flickr";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "flickr";
            } else if (toString().equals("TUMBLR")) {
                snsPlatform.mShowWord = "umeng_socialize_text_tumblr_key";
                snsPlatform.mIcon = "umeng_socialize_tumblr";
                snsPlatform.mGrayIcon = "umeng_socialize_tumblr";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "tumblr";
            } else if (toString().equals("KAKAO")) {
                snsPlatform.mShowWord = "umeng_socialize_text_kakao_key";
                snsPlatform.mIcon = "umeng_socialize_kakao";
                snsPlatform.mGrayIcon = "umeng_socialize_kakao";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "kakao";
            } else if (toString().equals("DOUBAN")) {
                snsPlatform.mShowWord = "umeng_socialize_text_douban_key";
                snsPlatform.mIcon = "umeng_socialize_douban";
                snsPlatform.mGrayIcon = "umeng_socialize_douban";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "douban";
            } else if (toString().equals("ALIPAY")) {
                snsPlatform.mShowWord = "umeng_socialize_text_alipay_key";
                snsPlatform.mIcon = "umeng_socialize_alipay";
                snsPlatform.mGrayIcon = "umeng_socialize_alipay";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "alipay";
            } else if (toString().equals("MORE")) {
                snsPlatform.mShowWord = "umeng_socialize_text_more_key";
                snsPlatform.mIcon = "umeng_socialize_more";
                snsPlatform.mGrayIcon = "umeng_socialize_more";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "more";
            } else if (toString().equals("DINGTALK")) {
                snsPlatform.mShowWord = "umeng_socialize_text_dingding_key";
                snsPlatform.mIcon = "umeng_socialize_ding";
                snsPlatform.mGrayIcon = "umeng_socialize_ding";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "ding";
            } else if (toString().equals("VKONTAKTE")) {
                snsPlatform.mShowWord = "umeng_socialize_text_vkontakte_key";
                snsPlatform.mIcon = "vk_icon";
                snsPlatform.mGrayIcon = "vk_icon";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "vk";
            } else if (toString().equals("DROPBOX")) {
                snsPlatform.mShowWord = "umeng_socialize_text_dropbox_key";
                snsPlatform.mIcon = "umeng_socialize_dropbox";
                snsPlatform.mGrayIcon = "umeng_socialize_dropbox";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "dropbox";
            }
        }
        snsPlatform.mPlatform = this;
        return snsPlatform;
    }

    public final String getauthstyle(boolean z) {
        if (toString().equals(Constants.SOURCE_QQ)) {
            return "sso";
        }
        if (toString().equals("SINA")) {
            if (z) {
                return "sso";
            }
            return Config.isUmengSina.booleanValue() ? "cloudy self" : "cloudy third";
        } else if (toString().equals("QZONE")) {
            return "sso";
        } else {
            if (toString().equals("RENREN")) {
                return "cloudy self";
            }
            if (toString().equals("WEIXIN")) {
                return "sso";
            }
            if (toString().equals("TENCENT")) {
                return "cloudy self";
            }
            if (toString().equals("FACEBOOK")) {
                return "sso";
            }
            if (toString().equals("YIXIN")) {
                return "sso";
            }
            if (toString().equals("TWITTER")) {
                return "sso";
            }
            if (toString().equals("LAIWANG")) {
                return "sso";
            }
            if (toString().equals("LINE")) {
                return "sso";
            }
            return toString().equals("DOUBAN") ? "cloudy self" : false;
        }
    }

    public final String getsharestyle(boolean z) {
        if (toString().equals(Constants.SOURCE_QQ)) {
            return "sso";
        }
        if (toString().equals("SINA")) {
            if (Config.isUmengSina.booleanValue()) {
                return "cloudy self";
            }
            return z ? "sso" : "cloudy third";
        } else if (toString().equals("RENREN")) {
            return "cloudy self";
        } else {
            if (toString().equals("DOUBAN")) {
                return "cloudy self";
            }
            return toString().equals("TENCENT") ? "cloudy self" : "sso";
        }
    }

    public final String toString() {
        return super.toString();
    }
}
