package com.xunlei.downloadprovider.member.login.b;

import com.xunlei.common.new_ptl.member.XLAvatarItem;
import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.common.new_ptl.member.XLHspeedCapacity;
import com.xunlei.common.new_ptl.member.XLLixianCapacity;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: XunleiOnUserListener */
public class p implements XLOnUserListener {
    public boolean onHighSpeedCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLHspeedCapacity xLHspeedCapacity, Object obj, int i2) {
        return false;
    }

    public boolean onLixianCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLLixianCapacity xLLixianCapacity, Object obj, int i2) {
        return false;
    }

    public boolean onUserAqBindMobile(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public boolean onUserAqSendMessage(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public boolean onUserBindedOtherAccount(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3) {
        return false;
    }

    public boolean onUserGetBindedOtherAccount(int i, String str, String str2, XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr, Object obj, int i2) {
        return false;
    }

    public boolean onUserGetCityCodeByIp(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2) {
        return false;
    }

    public boolean onUserGetCityInfo(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2) {
        return false;
    }

    public boolean onUserGetOtherAccountInfo(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3) {
        return false;
    }

    public boolean onUserGetQRCode(int i, String str, String str2, String str3, byte[] bArr, Object obj, int i2) {
        return false;
    }

    public boolean onUserGetRecommendAvatars(int i, String str, String str2, XLAvatarItem[] xLAvatarItemArr, Object obj, int i2) {
        return false;
    }

    public boolean onUserInfoCatched(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public boolean onUserLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public boolean onUserLogout(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public boolean onUserMobileLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public boolean onUserMobileRegister(int i, String str, String str2, boolean z, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public boolean onUserMobileSendMessage(int i, String str, String str2, String str3, Object obj, int i2) {
        return false;
    }

    public boolean onUserModifyPassWord(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public boolean onUserPreVerifyedCode(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public boolean onUserQRCodeLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public boolean onUserQRCodeLoginAuth(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public boolean onUserRecvChannelMessage(int i, JSONArray jSONArray) {
        return false;
    }

    public boolean onUserResumed(int i) {
        return false;
    }

    public boolean onUserSelectRecommendAvatar(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public boolean onUserSessionidLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public boolean onUserSetAvatar(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public boolean onUserSetInfo(int i, String str, String str2, Object obj, int i2) {
        return false;
    }

    public boolean onUserSuspended(int i) {
        return false;
    }

    public boolean onUserThirdLogin(int i, String str, String str2, XLUserInfo xLUserInfo, int i2, int i3, Object obj, int i4) {
        return false;
    }

    public boolean onUserTokenLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
        return false;
    }

    public boolean onUserUnBindeOtherAccount(int i, String str, String str2, int i2, Object obj, int i3) {
        return false;
    }

    public boolean onUserVerifyCodeUpdated(int i, String str, String str2, String str3, int i2, byte[] bArr, Object obj, int i3) {
        return false;
    }

    public boolean onUserVerifyedCode(int i, String str, String str2, Object obj, int i2) {
        return false;
    }
}
