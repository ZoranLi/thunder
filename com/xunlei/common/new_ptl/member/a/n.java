package com.xunlei.common.new_ptl.member.a;

import com.xunlei.common.new_ptl.member.XLAvatarItem;
import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.common.new_ptl.member.XLHspeedCapacity;
import com.xunlei.common.new_ptl.member.XLLixianCapacity;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.XLStatUtil;
import com.xunlei.common.stat.base.XLStatCommandID;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: XLStatMemberListener */
public final class n implements XLOnUserListener {
    private XLStatUtil a = null;

    public final boolean onHighSpeedCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLHspeedCapacity xLHspeedCapacity, Object obj, int i2) {
        return false;
    }

    public final boolean onLixianCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLLixianCapacity xLLixianCapacity, Object obj, int i2) {
        return false;
    }

    public final boolean onUserAqSendMessage(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserBindedOtherAccount(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3) {
        return false;
    }

    public final boolean onUserGetBindedOtherAccount(int i, String str, String str2, XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr, Object obj, int i2) {
        return false;
    }

    public final boolean onUserGetCityCodeByIp(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2) {
        return false;
    }

    public final boolean onUserGetCityInfo(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2) {
        return false;
    }

    public final boolean onUserGetOtherAccountInfo(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3) {
        return false;
    }

    public final boolean onUserGetQRCode(int i, String str, String str2, String str3, byte[] bArr, Object obj, int i2) {
        return false;
    }

    public final boolean onUserGetRecommendAvatars(int i, String str, String str2, XLAvatarItem[] xLAvatarItemArr, Object obj, int i2) {
        return false;
    }

    public final boolean onUserMobileLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public final boolean onUserMobileRegister(int i, String str, String str2, boolean z, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public final boolean onUserMobileSendMessage(int i, String str, String str2, String str3, Object obj, int i2) {
        return false;
    }

    public final boolean onUserModifyPassWord(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserQRCodeLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public final boolean onUserQRCodeLoginAuth(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserRecvChannelMessage(int i, JSONArray jSONArray) {
        return false;
    }

    public final boolean onUserResumed(int i) {
        return false;
    }

    public final boolean onUserSelectRecommendAvatar(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserSetAvatar(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserSetInfo(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public final boolean onUserSuspended(int i) {
        return false;
    }

    public final boolean onUserUnBindeOtherAccount(int i, String str, String str2, int i2, Object obj, int i3) {
        return false;
    }

    public n(XLStatUtil xLStatUtil) {
        this.a = xLStatUtil;
    }

    public final boolean onUserLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        str = new XLStatPack();
        str.mUserId = xLUserInfo.getLongValue(USERINFOKEY.UserID);
        str.mErrorCode = i;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        str.mNetType = p.a().C();
        if (!(str.mNetType.equals("2G") == null && str.mNetType.equals("3G") == null && str.mNetType.equals("4G") == null)) {
            str.mISP = p.a().D();
        }
        str2 = p.a().c(i2);
        if (str2 != null) {
            str.mSvrDomain = str2.a;
            str.mRetryNum = str2.b;
            str.mSvrIp = str2.c;
        }
        this.a.report(i2, str, true);
        return false;
    }

    public final boolean onUserThirdLogin(int i, String str, String str2, XLUserInfo xLUserInfo, int i2, int i3, Object obj, int i4) {
        str = new XLStatPack();
        if (i2 == 1) {
            str.mCommandID = XLStatCommandID.XLCID_SINA_LOGIN_BIND;
        } else if (i2 == 4) {
            str.mCommandID = XLStatCommandID.XLCID_ALIPAY_LOGIN_BIND;
        } else if (i2 == 8) {
            str.mCommandID = XLStatCommandID.XLCID_XM_LOGIN_BIND;
        } else if (i2 == 15) {
            str.mCommandID = XLStatCommandID.XLCID_QQ_LOGIN_BIND;
        } else if (i2 == 21) {
            str.mCommandID = XLStatCommandID.XLCID_WX_LOGIN_BIND;
        }
        str.mErrorCode = i;
        str.mFlowId = System.currentTimeMillis();
        str.mUserId = xLUserInfo.getLongValue(USERINFOKEY.UserID);
        str.mFinal = 1;
        str.mNetType = p.a().C();
        if (!(str.mNetType.equals("2G") == 0 && str.mNetType.equals("3G") == 0 && str.mNetType.equals("4G") == 0)) {
            str.mISP = p.a().D();
        }
        i = p.a().c(i4);
        if (i != 0) {
            str.mSvrDomain = i.a;
            str.mRetryNum = i.b;
            str.mSvrIp = i.c;
        }
        this.a.report(i4, str);
        return false;
    }

    public final boolean onUserTokenLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_TOKEN_LOGIN;
        str.mUserId = xLUserInfo.getLongValue(USERINFOKEY.UserID);
        str.mErrorCode = i;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        str.mNetType = p.a().C();
        if (!(str.mNetType.equals("2G") == 0 && str.mNetType.equals("3G") == 0 && str.mNetType.equals("4G") == 0)) {
            str.mISP = p.a().D();
        }
        i = p.a().c(i2);
        if (i != 0) {
            str.mSvrDomain = i.a;
            str.mRetryNum = i.b;
            str.mSvrIp = i.c;
        }
        this.a.report(i2, str);
        return false;
    }

    public final boolean onUserSessionidLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_SESSION_LOGIN;
        str.mUserId = xLUserInfo.getLongValue(USERINFOKEY.UserID);
        str.mErrorCode = i;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        str.mNetType = p.a().C();
        if (!(str.mNetType.equals("2G") == 0 && str.mNetType.equals("3G") == 0 && str.mNetType.equals("4G") == 0)) {
            str.mISP = p.a().D();
        }
        i = p.a().c(i2);
        if (i != 0) {
            str.mSvrDomain = i.a;
            str.mRetryNum = i.b;
            str.mSvrIp = i.c;
        }
        this.a.report(i2, str);
        return false;
    }

    public final boolean onUserLogout(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_LOGOUT;
        str.mUserId = xLUserInfo.getLongValue(USERINFOKEY.UserID);
        str.mErrorCode = i;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        str.mNetType = p.a().C();
        if (!(str.mNetType.equals("2G") == 0 && str.mNetType.equals("3G") == 0 && str.mNetType.equals("4G") == 0)) {
            str.mISP = p.a().D();
        }
        i = p.a().c(i2);
        if (i != 0) {
            str.mSvrDomain = i.a;
            str.mRetryNum = i.b;
            str.mSvrIp = i.c;
        }
        this.a.report(i2, str);
        return false;
    }

    public final boolean onUserInfoCatched(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_USER_INFO;
        str.mUserId = xLUserInfo.getLongValue(USERINFOKEY.UserID);
        str.mErrorCode = i;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        str.mNetType = p.a().C();
        if (!(str.mNetType.equals("2G") == 0 && str.mNetType.equals("3G") == 0 && str.mNetType.equals("4G") == 0)) {
            str.mISP = p.a().D();
        }
        i = p.a().c(i2);
        if (i != 0) {
            str.mSvrDomain = i.a;
            str.mRetryNum = i.b;
            str.mSvrIp = i.c;
        }
        this.a.report(i2, str);
        return false;
    }

    public final boolean onUserVerifyCodeUpdated(int i, String str, String str2, String str3, int i2, byte[] bArr, Object obj, int i3) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_GET_VCODE;
        str.mErrorCode = i;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        str.mNetType = p.a().C();
        if (!(str.mNetType.equals("2G") == 0 && str.mNetType.equals("3G") == 0 && str.mNetType.equals("4G") == 0)) {
            str.mISP = p.a().D();
        }
        i = p.a().c(i3);
        if (i != 0) {
            str.mSvrDomain = i.a;
            str.mRetryNum = i.b;
            str.mSvrIp = i.c;
        }
        this.a.report(i3, str);
        return false;
    }

    public final boolean onUserPreVerifyedCode(int i, String str, String str2, Object obj, int i2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_PRE_VERIFY_CODE;
        str.mErrorCode = i;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        str.mNetType = p.a().C();
        if (!(str.mNetType.equals("2G") == 0 && str.mNetType.equals("3G") == 0 && str.mNetType.equals("4G") == 0)) {
            str.mISP = p.a().D();
        }
        i = p.a().c(i2);
        if (i != 0) {
            str.mSvrDomain = i.a;
            str.mRetryNum = i.b;
            str.mSvrIp = i.c;
        }
        this.a.report(i2, str);
        return false;
    }

    public final boolean onUserVerifyedCode(int i, String str, String str2, Object obj, int i2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_VERIFY_CODE;
        str.mErrorCode = i;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        str.mNetType = p.a().C();
        if (!(str.mNetType.equals("2G") == 0 && str.mNetType.equals("3G") == 0 && str.mNetType.equals("4G") == 0)) {
            str.mISP = p.a().D();
        }
        i = p.a().c(i2);
        if (i != 0) {
            str.mSvrDomain = i.a;
            str.mRetryNum = i.b;
            str.mSvrIp = i.c;
        }
        this.a.report(i2, str);
        return false;
    }

    public final boolean onUserAqBindMobile(int i, String str, String str2, Object obj, int i2) {
        str = new XLStatPack();
        str.mCommandID = XLStatCommandID.XLCID_H5_BINDPHONE;
        str.mUserId = p.a().i().getLongValue(USERINFOKEY.UserID);
        str.mErrorCode = i;
        str.mFlowId = System.currentTimeMillis();
        str.mFinal = 1;
        str.mNetType = p.a().C();
        if (!(str.mNetType.equals("2G") == 0 && str.mNetType.equals("3G") == 0 && str.mNetType.equals("4G") == 0)) {
            str.mISP = p.a().D();
        }
        i = p.a().c(i2);
        if (i != 0) {
            str.mSvrDomain = i.a;
            str.mRetryNum = i.b;
            str.mSvrIp = i.c;
        } else {
            str.mSvrDomain = "aq.xunlei.com";
        }
        this.a.report(i2, str);
        return false;
    }
}
