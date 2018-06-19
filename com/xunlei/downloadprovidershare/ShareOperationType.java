package com.xunlei.downloadprovidershare;

import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;

public enum ShareOperationType {
    SINA,
    QQ,
    QZONE,
    WEIXIN,
    WEIXIN_CIRCLE,
    COPY_URL,
    QR_SHARE,
    SYSTEM_SHARE,
    EXCHANGE_SHARE,
    DOWNLOAD,
    DELETE,
    REPORT,
    COOPERATION,
    MAIN_PAGE,
    XL_ID,
    LINK_PUBLISH,
    THUNDER_COMMAND;

    public final boolean isShouldProcessShareUrl() {
        switch (m.a[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public final String getReportShareTo() {
        String str = "";
        switch (m.a[ordinal()]) {
            case 1:
                return Token.WX_TOKEN_PLATFORMID_VALUE;
            case 2:
                return "pengyouquan";
            case 3:
                return "qq";
            case 4:
                return Constants.SOURCE_QZONE;
            case 5:
                return "weibo";
            case 6:
                return "copy";
            case 7:
                return "system";
            case 8:
                return "code";
            case 9:
                return "xlpasswd";
            case 10:
                return "xunlei_home";
            default:
                return str;
        }
    }

    public final boolean isPlatformShare() {
        if (!(this == WEIXIN || this == WEIXIN_CIRCLE || this == SINA || this == QQ)) {
            if (this != QZONE) {
                return false;
            }
        }
        return true;
    }
}
