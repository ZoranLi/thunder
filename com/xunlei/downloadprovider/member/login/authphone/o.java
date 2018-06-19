package com.xunlei.downloadprovider.member.login.authphone;

import com.xunlei.downloadprovider.d.b.d;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: AuthFromHelper */
public final class o {
    public static boolean a(String str) {
        if (!(LoginFrom.SELF_LOGIN_VIDEO.toString().equals(str) || LoginFrom.VIDEO_DETAIL_USER_DISCUSS.toString().equals(str) || LoginFrom.VIDEO_DETAIL_USER_DISCUSS_DEFAULT.toString().equals(str) || LoginFrom.DL_USER_DISCUSS.toString().equals(str) || LoginFrom.DL_USER_DISCUSS_DEFAULT.toString().equals(str) || LoginFrom.LINK_DETAIL_DISCUSS.toString().equals(str) || LoginFrom.NEWS_DETAIL_DISCUSS.toString().equals(str) || LoginFrom.CINECISM_DETAIL_DISCUSS.toString().equals(str) || LoginFrom.COLLECT_SUCCESS_PUBLIC.toString().equals(str) || LoginFrom.BROWSER_WEBSITE_SHARE.toString().equals(str) || LoginFrom.PERSONAL_COMMUNITY_REPLY.toString().equals(str) || LoginFrom.SHORT_VIDEO_TAG_PARTICIPATE.toString().equals(str) || LoginFrom.SHORTVIDEO_RECORD_PUBLISH.toString().equals(str) || LoginFrom.SHORTVIDEO_USERCENTER_REPLY.toString().equals(str))) {
            if (LoginFrom.PERSONAL_COMMUNITY_CHAT.toString().equals(str) == null) {
                return null;
            }
        }
        return true;
    }

    public static int b(String str) {
        d dVar = com.xunlei.downloadprovider.d.d.a().e;
        if (!(LoginFrom.SELF_LOGIN_VIDEO.toString().equals(str) || LoginFrom.SHORT_VIDEO_TAG_PARTICIPATE.toString().equals(str))) {
            if (!LoginFrom.SHORTVIDEO_RECORD_PUBLISH.toString().equals(str)) {
                if (!(LoginFrom.VIDEO_DETAIL_USER_DISCUSS.toString().equals(str) || LoginFrom.VIDEO_DETAIL_USER_DISCUSS_DEFAULT.toString().equals(str) || LoginFrom.DL_USER_DISCUSS.toString().equals(str) || LoginFrom.DL_USER_DISCUSS_DEFAULT.toString().equals(str) || LoginFrom.NEWS_DETAIL_DISCUSS.toString().equals(str) || LoginFrom.CINECISM_DETAIL_DISCUSS.toString().equals(str) || LoginFrom.SHORTVIDEO_USERCENTER_REPLY.toString().equals(str) || LoginFrom.LINK_DETAIL_DISCUSS.toString().equals(str))) {
                    if (!LoginFrom.PERSONAL_COMMUNITY_REPLY.toString().equals(str)) {
                        if (!LoginFrom.BROWSER_WEBSITE_SHARE.toString().equals(str)) {
                            if (!LoginFrom.COLLECT_SUCCESS_PUBLIC.toString().equals(str)) {
                                return LoginFrom.PERSONAL_COMMUNITY_CHAT.toString().equals(str) != null ? dVar.f() : -1;
                            }
                        }
                        return dVar.e();
                    }
                }
                return dVar.c();
            }
        }
        return dVar.d();
    }

    public static int c(String str) {
        str = b(str);
        return str < null ? com.xunlei.downloadprovider.d.d.a().e.b() : str;
    }
}
