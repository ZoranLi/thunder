package com.xunlei.common.new_ptl.member;

import org.json.JSONArray;
import org.json.JSONObject;

public interface XLOnUserListener {
    boolean onHighSpeedCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLHspeedCapacity xLHspeedCapacity, Object obj, int i2);

    boolean onLixianCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLLixianCapacity xLLixianCapacity, Object obj, int i2);

    boolean onUserAqBindMobile(int i, String str, String str2, Object obj, int i2);

    boolean onUserAqSendMessage(int i, String str, String str2, Object obj, int i2);

    boolean onUserBindedOtherAccount(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3);

    boolean onUserGetBindedOtherAccount(int i, String str, String str2, XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr, Object obj, int i2);

    boolean onUserGetCityCodeByIp(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2);

    boolean onUserGetCityInfo(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2);

    boolean onUserGetOtherAccountInfo(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3);

    boolean onUserGetQRCode(int i, String str, String str2, String str3, byte[] bArr, Object obj, int i2);

    boolean onUserGetRecommendAvatars(int i, String str, String str2, XLAvatarItem[] xLAvatarItemArr, Object obj, int i2);

    boolean onUserInfoCatched(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2);

    boolean onUserLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2);

    boolean onUserLogout(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2);

    boolean onUserMobileLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2);

    boolean onUserMobileRegister(int i, String str, String str2, boolean z, XLUserInfo xLUserInfo, Object obj, int i2);

    boolean onUserMobileSendMessage(int i, String str, String str2, String str3, Object obj, int i2);

    boolean onUserModifyPassWord(int i, String str, String str2, Object obj, int i2);

    boolean onUserPreVerifyedCode(int i, String str, String str2, Object obj, int i2);

    boolean onUserQRCodeLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2);

    boolean onUserQRCodeLoginAuth(int i, String str, String str2, Object obj, int i2);

    boolean onUserRecvChannelMessage(int i, JSONArray jSONArray);

    boolean onUserResumed(int i);

    boolean onUserSelectRecommendAvatar(int i, String str, String str2, Object obj, int i2);

    boolean onUserSessionidLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2);

    boolean onUserSetAvatar(int i, String str, String str2, Object obj, int i2);

    boolean onUserSetInfo(int i, String str, String str2, Object obj, int i2);

    boolean onUserSuspended(int i);

    boolean onUserThirdLogin(int i, String str, String str2, XLUserInfo xLUserInfo, int i2, int i3, Object obj, int i4);

    boolean onUserTokenLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2);

    boolean onUserUnBindeOtherAccount(int i, String str, String str2, int i2, Object obj, int i3);

    boolean onUserVerifyCodeUpdated(int i, String str, String str2, String str3, int i2, byte[] bArr, Object obj, int i3);

    boolean onUserVerifyedCode(int i, String str, String str2, Object obj, int i2);
}
